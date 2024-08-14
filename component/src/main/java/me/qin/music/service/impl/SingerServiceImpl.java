package me.qin.music.service.impl;
import me.qin.music.entity.Singer;
import me.qin.music.entity.SingerExample;
import me.qin.music.mapper.AlbumMapper;
import me.qin.music.mapper.SingerMapper;
import me.qin.music.service.SingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 封装了对歌手信息操作的事物
 * @author PasserbyA
 * @date 2022/11/16 15:40
 */

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
public class SingerServiceImpl implements SingerService {

    @Autowired
    SingerMapper singerMapper;

    /**
     * 添加一个歌手信息
     * @param singer 歌手实例
     * @return 若成功返回 1
     */
    @Override
    public int addSinger(Singer singer) {
        singer.setSingerId(null);
        return singerMapper.insertSelective(singer);
    }

    /**
     * 根据id查询一个歌手的信息
     *
     * @param id 歌手id
     * @return 若成功返回歌手实例 否则返回null
     */
    @Override
    public Singer getSingerById(Integer id) {
        return singerMapper.selectByPrimaryKey(id);
    }

    /**
     * 根据id删除一个歌手的信息
     *
     * @param id 歌手id
     * @return 若成功返回 1
     */
    @Override
    public int delSingerById(Integer id) {
        return singerMapper.deleteByPrimaryKey(id);
    }

    /**
     * 根据id 批量的删除歌手的信息
     *
     * @param ids 歌手id
     * @return 返回被删除数量
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public int delSingerById(List<Integer> ids) {
        SingerExample example = new SingerExample();
        example.createCriteria().andSingerIdIn(ids);
        return singerMapper.deleteByExample(example);
    }

    /**
     * 根据id更新歌手信息
     *
     * @param singer 歌手实例（id不为null）
     * @return 若成功返回1
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public int upSingerById(Singer singer) {
        return singerMapper.updateByPrimaryKeySelective(singer);
    }
}

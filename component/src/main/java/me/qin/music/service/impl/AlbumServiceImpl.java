package me.qin.music.service.impl;

import me.qin.music.entity.Album;
import me.qin.music.entity.AlbumExample;
import me.qin.music.entity.Songlist;
import me.qin.music.mapper.AlbumMapper;
import me.qin.music.service.AlbumService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 *封装对专辑操作的事务
 * @author PasserbyA
 * @date 2022/11/16 15:38
 */

@Service
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    AlbumMapper albumMapper;

    /**
     * 添加一个专辑
     * @param album 专辑实例
     * @return 添加成功返回1
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public int addAlbumById(@NotNull Album album){
        album.setAlbumId(null);
        return albumMapper.insertSelective(album);
    }

    /**
     * 通过id获取一个专辑
     * @param id 专辑id
     * @return 专辑实例
     */
    @Override
    @Transactional(readOnly = true)
    public Album getAlbumById(Integer id) {
        return albumMapper.selectByPrimaryKey(id);
    }

    /**
     * 通过id删除一个专辑
     * @param id 专辑id
     * @return 成功返回1
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public int delAlbumById(Integer id){
        return albumMapper.deleteByPrimaryKey(id);
    }

    /**
     * 通过id 批量的 删除专辑
     * @param ids 专辑id
     * @return 返回删除条数
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    @Override
    public int delAlbumById(List<Integer> ids) {
        AlbumExample example = new AlbumExample();
        example.createCriteria().andAlbumIdIn(ids);
        return albumMapper.deleteByExample(example);
    }

    /**
     * 根据id更新专辑信息
     * @param album 专辑实例（id不为空）
     * @return 更新成功返回1
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    @Override
    public int upAlbum(Album album){
        return albumMapper.updateByPrimaryKeySelective(album);
    }

    /**
     *根据作者名字返回专辑的id
     * @param authorName 作者名字
     * @return 属于作者的专辑的id集合
     */
    @Override
    @Transactional(readOnly = true)
    public List<Integer> getIdsByAuthor(String authorName){
        AlbumExample example = new AlbumExample();
        example.createCriteria().andAuthorEqualTo(authorName);
        List<Album> albums = albumMapper.selectByExample(example);
        return albums.stream().map(Album::getAlbumId).collect(Collectors.toList());
    }


}

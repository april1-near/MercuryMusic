package me.qin.music.service.impl;

import me.qin.music.entity.Song;
import me.qin.music.entity.SongExample;
import me.qin.music.entity.SonglistExample;
import me.qin.music.mapper.SongMapper;
import me.qin.music.mapper.SongWithListMapper;
import me.qin.music.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * 封装对歌曲的事务操作
 * @author PasserbyA
 * @date 2022/11/16 19:19
 */

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
public class SongServiceImpl implements SongService {

    @Autowired
    SongMapper songMapper;
    @Autowired
    SongWithListMapper songWithListMapper;


    @Override
    public List<Song> getAllSongs() {
        return songMapper.selectByExample(new SongExample());
    }

    @Override
    public List<Song> searchSongs(String name, String author) {
        SongExample example = new SongExample();
        SongExample.Criteria criteria = example.createCriteria();

        if (name != null) {
            criteria.andNameEqualTo(name);
        }

        if (author != null) {
            criteria.andAuthorEqualTo(author);
        }

        return songMapper.selectByExample(example);
    }


    /**
     * 根据id删除歌曲
     *会将歌曲移出与之关联的歌单
     * @param id 歌曲id
     * @return 若成功返回1
     */
    @Override
    public Integer delSongById(Integer id) {
      songWithListMapper.delSongFromList(Arrays.asList(id));
      return songMapper.deleteByPrimaryKey(id);
    }

    /**
     * 根据 id 批量的 删除歌曲
     *会将歌曲移出与之关联的歌单
     * @param ids 歌曲ids
     * @return 返回删除条数
     */
    @Override
    public Integer delSongById(List<Integer> ids) {
        songWithListMapper.delSongFromList(ids);
        SongExample example = new SongExample();
        example.createCriteria().andSongIdIn(ids);
        return songMapper.deleteByExample(example);
    }

    /**
     * 根据实例中的id 更新歌曲的信息
     *
     * @param song song实例（id不为null）
     * @return 若成功返回1
     */
    @Override
    public Integer upSong(Song song) {
        return songMapper.updateByPrimaryKeySelective(song);
    }

    /**
     * 添加一个歌曲信息
     *
     * @param song 歌曲实例
     * @return 若成功返回1
     */
    @Override
    public Integer addSong(Song song) {
        song.setSongId(null);
//        KeyHolder keyHolder = new GeneratedKeyHolder();
        songMapper.insert(song);

        return song.getSongId();
    }

    /**
     * 根据id获取一个歌曲信息
     *
     * @param id 歌曲id
     * @return 歌曲实例
     */
    @Override
    public Song getSongById(Integer id) {
        return songMapper.selectByPrimaryKey(id);
    }
}

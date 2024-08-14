package me.qin.music.service;

import me.qin.music.entity.Song;

import java.util.List;

/**
 * 封装对歌曲的事务操作
 * @author PasserbyA
 * @date 2022/11/16 19:10
 */
public interface SongService {


    List<Song> getAllSongs();

    List<Song> searchSongs(String name, String author);

    /**
     * 根据id删除歌曲
     * @param id 歌曲id
     * @return 若成功返回1
     */
    public Integer delSongById(Integer id);

    /**
     * 根据 id 批量的 删除歌曲
     * @param ids 歌曲ids
     * @return 返回删除条数
     */
    public Integer delSongById(List<Integer> ids);


    /**
     * 根据实例中的id 更新歌曲的信息
     * @param song song实例（id不为null）
     * @return 若成功返回1
     */
    public Integer upSong(Song song);


    /**
     * 添加一个歌曲信息
     * @param song  歌曲实例
     * @return 若成功返回1
     */
    public Integer addSong(Song song);

    /**
     * 根据id获取一个歌曲信息
     * @param id 歌曲id
     * @return 歌曲实例
     */
    public Song getSongById(Integer id);
}

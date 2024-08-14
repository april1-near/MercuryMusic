package me.qin.music.service;

import me.qin.music.entity.Album;
import me.qin.music.entity.Singer;
import me.qin.music.entity.Song;
import me.qin.music.entity.Songlist;

import java.util.List;
import java.util.Map;

/**
 * @author PasserbyA
 * @date 2022/10/16 19:48
 */
public interface SearchService {

    /**
     * 查询符合条件的歌曲
     * @param searchInfo 查询信息
     * @return 返回模糊查询结果
     */
    public List<Song> searchSong(String searchInfo);

    /**
     * 模糊查询歌单
     * @param searchInfo 查询信息
     * @return 结果
     */
    List<Songlist> searchPlayList(String searchInfo);

    List<Album> searchAlbum(String searchInfo);

    List<Singer> searchSinger(String searchInfo);

    Map<String,Object> searchByAll(String searchInfo);
}

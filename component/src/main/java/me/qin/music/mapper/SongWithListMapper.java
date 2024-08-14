package me.qin.music.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 这个mapper封装 歌单与歌曲的关联查询操作
 * 部分操作写在SongListMapper 里面了
 * 不想改了 :)
 * @author PasserbyA
 * @date 2022/11/16 19:45
 */
public interface SongWithListMapper {


    /**
     * 给定歌曲id，把它与所有歌单取消关联
     * @param songIds 歌曲id集合
     * @return 更新条数
     */
    Integer delSongFromList(@Param("songIds") List<Integer> songIds);




}

package me.qin.music.mapper;

import me.qin.music.entity.Song;
import me.qin.music.entity.Songlist;
import me.qin.music.entity.SonglistExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SonglistMapper {
    int countByExample(SonglistExample example);

    int deleteByExample(SonglistExample example);

    int deleteByPrimaryKey(Integer listId);

    int insert(Songlist record);

    int insertSelective(Songlist record);

    List<Songlist> selectByExample(SonglistExample example);

    Songlist selectByPrimaryKey(Integer listId);

    int updateByExampleSelective(@Param("record") Songlist record, @Param("example") SonglistExample example);

    int updateByExample(@Param("record") Songlist record, @Param("example") SonglistExample example);

    int updateByPrimaryKeySelective(Songlist record);

    int updateByPrimaryKey(Songlist record);

    /**
     * 查询列表中的歌曲
     * @param listId 列表id
     * @return 歌曲集合
     */
    List<Song> selectSongInListByListId(@Param("listId") Integer listId);

    /**
     * 向歌单中批量添加歌曲
     * @param listId 歌单id
     * @param songId 歌曲id集合
     * @return 影响行数
     */
    int putSongToList(@Param("listId") Integer listId, @Param("songId") List<Integer> songId);

    /**
     * 向歌单中批量删除歌曲
     * @param listId 歌单id
     * @param songId 歌曲id集合
     * @return 影响行数
     */
    int delSongForList(@Param("listId") Integer listId, @Param("songId") List<Integer> songId);

    /**
     * 将歌单中的所有歌曲取消关联
     * @param listId 歌单id
     */
    void disassociateSongFromList(@Param("listId")  List<Integer> listId);

    /**
     * 根据歌单id获取歌曲id集合
     * @param listId id
     * @return 歌曲id集合
     */
    List<Integer> selectSongIdByListId(@Param("listId") Integer listId);



}
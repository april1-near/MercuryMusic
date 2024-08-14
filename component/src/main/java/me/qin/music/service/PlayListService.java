package me.qin.music.service;

import me.qin.music.entity.Song;
import me.qin.music.entity.Songlist;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 对歌单的操作
 * @author PasserbyA
 * @date 2022/10/26 15:58
 */
public interface PlayListService {

    /**
     * 查询指定用户的歌单
     * @param userId 用户id
     * @return 列表集合
     */
    List<Songlist> getPlayListByUserId(Integer userId);

    /**
     * 批量删除列表
     * @param listId 要删除的歌单的id集合
     * @return 删除行数
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    Integer delPlayList(List<Integer> listId);

    /**
     * 批量删除一个用户的歌单
     * @param listId 要删除的歌单的id集合
     * @param userId 用户id
     * @return 删除行数
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    Integer delUserPlaylist(List<Integer> listId, Integer userId);

    /**
     * 添加一个歌单
     *
     * @param playList 歌单信息
     * @return 添加状态
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    Integer addPlayList(Songlist playList);

    /**
     * 更新歌单信息
     * @param playList 新的歌单
     * @return 更新状态
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    Integer upDatePlayList(Songlist playList);

    /**
     * 向歌单中添加歌曲
     *
     * @param listId 歌单id
     * @param songId 添加歌曲集合
     * @return 添加成功条数
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    Integer playListPushSong(Integer listId, List<Integer> songId);


    /**
     * 从歌单删除歌曲
     *
     * @param listId 歌单id
     * @param songId 添加歌曲集合
     * @return 删除成功条数
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    Integer delSongFromList(Integer listId, List<Integer> songId);


    /**
     * 通过歌单id获取其中的歌曲
     *
     * @param listId id
     * @return 歌曲集合
     */
    List<Song> getSongByListId(Integer listId);

    /**
     * 根据id获取一个歌单
     * @param listId 歌单id
     * @return 歌单
     */
    Songlist getPlayListById(Integer listId);

    void clearList(List<Integer> listIds);
}


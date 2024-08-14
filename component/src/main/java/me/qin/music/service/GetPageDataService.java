package me.qin.music.service;

import com.github.pagehelper.PageInfo;
import me.qin.music.entity.*;

import java.util.Map;

/**
 * @author PasserbyA
 * @date 2022/10/17 20:36
 */
public interface GetPageDataService {

    /**
     * 分页专辑
     * @param pageNo 页码
     * @return  获取给定页码专辑
     */
    PageInfo<Album> getAlbum(Integer pageNo);

    Integer getPageSize();

    void setPageSize(Integer pageSize);

    /**
     * 带有分页信息的列表
     * @param pageNo 页码
     * @return 用户公开的歌单
     */
    PageInfo<Songlist> getPublicPlayList(Integer pageNo);

    /**
     * 带有分页信息的列表
     * @param pageNo 页码
     * @return 所有的用户歌单
     */
    PageInfo<Songlist> getAllPlayList(Integer pageNo);

    /**
     * 带有分页信息的列表
     * @param pageNo 页码
     * @return 用户
     */
    PageInfo<User> getUserList(Integer pageNo);

    /**
     * 带有分页信息的列表
     * @param pageNo 页码
     * @return 作家
     */
    PageInfo<Singer> getSingerList(Integer pageNo);

    /**
     * 根据情况分页获取歌单中的歌曲
     * @param userId 创建者id
     * @param listId 歌单id
     * @param pageNo 页码
     * @return 分页信息
     */
    Map<String, Object> getSongAndList(Integer userId, Integer listId, Integer pageNo);

    /**
     * 分页获取歌单中的歌曲
     * @param pageNo 页码
     * @param listId 歌单id
     * @return 分页信息
     */
    PageInfo<Song> getSongPageFormList(Integer listId, Integer pageNo);

    Boolean playlistIsOvert(Integer userId, Integer listId);
}

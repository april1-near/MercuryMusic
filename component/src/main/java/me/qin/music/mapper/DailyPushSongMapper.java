package me.qin.music.mapper;

import me.qin.music.entity.Song;

import java.util.List;

/**
 * @author PasserbyA
 * @date 2022/10/16 13:46
 */
public interface DailyPushSongMapper {

    /**
     * 获取每日推荐
     * @return 每日推荐歌曲
     */
    List<Song> selectDailyPush();

    /**
     * 清空每日推荐表
     */
    void deleteAllField();

    /**
     * 更新推荐内容
     * @param n 更新量
     */
    void updateAllField(Integer n);

}

package me.qin.music.service;

import me.qin.music.entity.Song;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 未登录访问的service
 * @author PasserbyA
 * @date 2022/10/14 22:04
 */
public interface DailyPushService {


    /**
     * 获取每日推荐歌曲
     * @return 每日推荐歌曲列表
     */
    List<Song> getDailyPushSong();


    @Scheduled(cron = "0 0 0 * * ?")
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class )
    void upDailySong();
}

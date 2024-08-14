package me.qin.music.service.impl;

import me.qin.music.entity.Song;
import me.qin.music.mapper.DailyPushSongMapper;
import me.qin.music.service.DailyPushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author PasserbyA
 * @date 2022/10/14 22:05
 */

@Service
@Transactional(readOnly = true)
public class DailyPushServiceImpl implements DailyPushService {

    @Autowired
    private DailyPushSongMapper dailyPushMapper;

    @Override
    public List<Song> getDailyPushSong(){
        List<Song> dailySong = dailyPushMapper.selectDailyPush();
        return dailySong;
    }

    /**
     * 每天零点刷新每日推荐表
     */
    @Scheduled(cron = "0 0 0 * * ?")
    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class )
    public void upDailySong(){
        dailyPushMapper.deleteAllField();
        dailyPushMapper.updateAllField(30);
    }

}

package serviceTest;

import me.qin.music.entity.Songlist;
import me.qin.music.service.PlayListService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

/**
 * @author PasserbyA
 * @date 2022/10/30 12:07
 */

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:spring_config.xml")//加载配置文件
public class SongListServiceTest {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PlayListService playListService;

    @Test
    void test(){
        log.info(()->"测试开始");

        Songlist songlist = new Songlist();
        songlist.setCreator(21);
        songlist.setListId(343);
        songlist.setName("歌单·1");
        songlist.setHide(0);
        songlist.setCoverUrl("dfdfdfdfghhygh");

//        playListService.addPlayList(songlist);
        List<Integer> integers = new ArrayList<>();
        integers.add(23);
        List<Integer> songId = new ArrayList<>();
        songId.add(54);
        songId.add(83);
        songId.add(72);

        List<Integer> songId2 = new ArrayList<>();
        songId2.add(54);
        songId2.add(542);
        songId2.add(345);
        songId2.add(24);
//        songId.removeAll(songId2);
        System.out.println(songId);

        playListService.playListPushSong(24,songId);
        playListService.playListPushSong(24,songId);
//        playListService.delPlayList(integers);



        log.info(()->"测试结束");
    }
}

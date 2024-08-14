package mybatis_test;

import me.qin.music.mapper.SongWithListMapper;
import me.qin.music.mapper.SonglistMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author PasserbyA
 * @date 2022/10/27 12:33
 */

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:spring_config.xml")//加载配置文件

public class PlayListTest {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    SongWithListMapper songWithListMapper;
    @Autowired
    private SonglistMapper listMapper;

    @Test
    public void delTest() {
        log.info(() -> "测试开始");

        List<Integer> sid = new ArrayList<>();
        sid.add(88);
        sid.add(23);
        sid.add(25);
        sid.add(40);
//        listMapper.putSongToList(12,sid );
//        listMapper.delSongForList(12,null);
//        List<Song> songs = listMapper.selectSongInListByListId(12);
//        songs.forEach(System.out::println);

//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(12);
//        listMapper.disassociateSongFromList(null);

        System.out.println(listMapper.selectByPrimaryKey(1));
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(dateFormat.format(new Date()));


        log.info(() -> "测试结束");
    }

    @Test
    void songWithList(){

        log.info(() -> "开始");
        System.out.println(songWithListMapper.delSongFromList(Arrays.asList(1,5)));
        log.info(() -> "结束");
    }
}

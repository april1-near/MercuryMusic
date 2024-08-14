package serviceTest;

import me.qin.music.entity.Song;
import me.qin.music.service.SearchService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.function.Supplier;

/**
 * @author PasserbyA
 * @date 2022/10/16 21:40
 */

 @ExtendWith(SpringExtension.class)
 @ContextConfiguration("classpath:spring_config.xml")//加载配置文件
public class SearchServiceTest {
     private final Logger log = LoggerFactory.getLogger(this.getClass());
     @Autowired
    private SearchService searchService;

     @Test
     void searchSongTest(){
         log.info(new Supplier<String>() {
             @Override
             public String get() {
                 return "测试开始";
             }
         });

         List<Song> songs = searchService.searchSong("药");
         System.out.println(songs);

         log.info(new Supplier<String>() {
             @Override
             public String get() {
                 return "测试结束";
             }
         });

    }
}

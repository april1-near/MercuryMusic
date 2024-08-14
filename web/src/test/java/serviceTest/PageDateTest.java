package serviceTest;

import com.github.pagehelper.PageInfo;
import me.qin.music.entity.Song;
import me.qin.music.service.GetPageDataService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * @author PasserbyA
 * @date 2022/10/16 21:40
 */

 @ExtendWith(SpringExtension.class)
 @ContextConfiguration("classpath:spring_config.xml")//加载配置文件
public class PageDateTest {
     private final Logger log = LoggerFactory.getLogger(this.getClass());
     @Autowired
    private GetPageDataService pageDataService;

     @Test
     void Test(){
         log.info(() -> "测试开始");

         PageInfo<Song> pageInfo = pageDataService.getSongPageFormList(2784, 1);
         System.out.println(pageInfo.toString());

         log.info(() -> "测试结束");

    }
}

package serviceTest;

import com.github.pagehelper.PageInfo;
import me.qin.music.entity.User;
import me.qin.music.service.DailyPushService;
import me.qin.music.service.GetPageDataService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

/**
 * @author PasserbyA
 * @date 2022/10/16 14:29
 */

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:spring_config.xml")//加载配置文件
public class VisitServiceTest {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    DailyPushService visitService;
    @Autowired
    GetPageDataService pageDataService;

    @Test
    public void getDailySongTest() {
        log.info(() -> "测试开始");

        PageInfo<User> pageInfo = pageDataService.getUserList(1);

        List<User> list = pageInfo.getList();
        list.forEach(System.out::println);


        log.info(() -> "测试结束");
    }



}

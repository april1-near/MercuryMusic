package serviceTest;

import me.qin.music.entity.User;
import me.qin.music.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.function.Supplier;

/**
 * @author PasserbyA
 * @date 2022/10/12 22:31
 */

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:spring_config.xml")//加载配置文件
public class userServiceTest {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserService userService;

    @Test
    public void loginTest() {
        log.info(new Supplier<String>() {
            @Override
            public String get() {
                return "测试开始";
            }
        });

        User user = userService.getUserByLogin("谭                                                               安琪","kS5FmwtFrZ");
        System.out.println(user);
        log.info(new Supplier<String>() {
            @Override
            public String get() {
                return "测试结束";
            }
        });
    }
}

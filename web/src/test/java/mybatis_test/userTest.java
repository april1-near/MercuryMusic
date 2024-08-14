package mybatis_test;

import me.qin.music.entity.User;
import me.qin.music.entity.UserExample;
import me.qin.music.mapper.DailyPushSongMapper;
import me.qin.music.mapper.UserMapper;
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
 * @date 2022/10/12 19:53
 */

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:spring_config.xml")//加载配置文件
public class userTest {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private DailyPushSongMapper pushMapper;

    @Test
    public void test() {
        log.info(new Supplier<String>() {
            @Override
            public String get() {
                return "测试开始";
            }
        });

        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        List<User> users = userMapper.selectByExample(example);
        users.forEach(System.out::println);

        log.info(new Supplier<String>() {
            @Override
            public String get() {
                return "测试结束";
            }
        });
    }

    @Test
    public void pushTest(){

        pushMapper.deleteAllField();
        pushMapper.updateAllField(30);

    }
}
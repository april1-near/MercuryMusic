package me.qin.music.service.impl;

import me.qin.music.entity.User;
import me.qin.music.entity.UserExample;
import me.qin.music.mapper.SonglistMapper;
import me.qin.music.mapper.UserMapper;
import me.qin.music.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/**
 * @author PasserbyA
 * @date 2022/10/12 20:41
 */
@Service
@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Transactional(readOnly = true)
    @Override
    public User getUserByLogin(String userName, String passwd) {

        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(userName).andPasswdEqualTo(passwd);
        List<User> users = userMapper.selectByExample(example);
        if (users != null && users.size() > 0 ){
            return users.get(0);
        }
        return null;
    }

    /**
     * 添加一个用户
     * @param user 用户信息
     * @return 1
     */
    @Override
    public Integer addUser(User user){
        user.setUserId(null);
        return userMapper.insertSelective(user);
    }

    /**
     * 批量删除用户
     * @param userId 要删除的用户的id集合
     * @return 删除个数
     */
    @Override
    public Integer delUser(List<Integer> userId){
        UserExample example = new UserExample();
        example.createCriteria().andUserIdIn(userId);
        return userMapper.deleteByExample(example);
    }

    /**
     * 更新用户信息
     * @param user 用户信息
     * @return 1
     */
    @Override
    public Integer uptUser(User user){
        return userMapper.updateByPrimaryKeySelective(user);
    }

}

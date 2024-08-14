package me.qin.music.service;

import me.qin.music.entity.User;

import java.util.List;

/**
 * @author PasserbyA
 * @date 2022/10/12 20:39
 */
public interface UserService {

    /**
     * 获取一个用户用于登录
     * @param userName 用户名
     * @param passwd 密码
     * @return 返回一个实例
     */
    User getUserByLogin(String userName,String passwd);

    /**
     * 添加一个用户
     * @param user 用户信息
     * @return 1
     */
    Integer addUser(User user);

    /**
     * 批量删除用户
     * @param userId 要删除的用户的id集合
     * @return 删除个数
     */
    Integer delUser(List<Integer> userId);

    /**
     * 更新用户信息
     * @param user 用户信息
     * @return 1
     */
    Integer uptUser(User user);
}

package me.qin.music.service;

import me.qin.music.entity.Singer;

import java.util.List;

/**
 * 封装对歌手信息的操作
 * @author PasserbyA
 * @date 2022/11/16 15:40
 */
public interface SingerService {


    /**
     * 添加一个歌手信息
     * @param singer 歌手实例
     * @return 若成功返回 1
     */
    public int addSinger(Singer singer);

    /**
     * 根据id查询一个歌手的信息
     * @param id 歌手id
     * @return 若成功返回歌手实例 否则返回null
     */
    public Singer getSingerById(Integer id);


    /**
     * 根据id删除一个歌手的信息
     * @param id 歌手id
     * @return 若成功返回 1
     */
    public int delSingerById(Integer id);

    /**
     * 根据id 批量的删除歌手的信息
     * @param ids 歌手id
     * @return 返回被删除数量
     */
    public int delSingerById(List<Integer> ids);

    /**
     * 根据id更新歌手信息
     * @param singer 歌手实例（id不为null）
     * @return 若成功返回1
     */
    public int upSingerById(Singer singer);

}

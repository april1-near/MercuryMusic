package me.qin.music.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import me.qin.music.entity.*;
import me.qin.music.mapper.AlbumMapper;
import me.qin.music.mapper.SingerMapper;
import me.qin.music.mapper.SonglistMapper;
import me.qin.music.mapper.UserMapper;
import me.qin.music.service.GetPageDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author PasserbyA
 * @date 2022/10/17 20:39
 */
@Service
@Transactional(readOnly = true)
public class GetPageDataServiceImpl implements GetPageDataService {

    @Autowired
    private SonglistMapper listMapper;
    @Autowired
    private AlbumMapper albumMapper;
    @Autowired
    private SingerMapper singerMapper;
    @Autowired
    private UserMapper userMapper;

    /**
     * 每页展示条目数
     */
    private Integer pageSize;

    public GetPageDataServiceImpl() {
        this.pageSize = 20;
    }

    @Override
    public Integer getPageSize() {
        return pageSize;
    }
    @Override
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public PageInfo<Songlist> getPublicPlayList(Integer pageNo) {
        SonglistExample example = new SonglistExample();
        SonglistExample.Criteria criteria = example.createCriteria();
        criteria.andHideEqualTo(0);
        PageHelper.startPage(pageNo,pageSize);
        List<Songlist> songList = listMapper.selectByExample(example);
        return new PageInfo<>(songList);
    }

    /**
     * 带有分页信息的列表
     * @param pageNo 页码
     * @return 所有的用户歌单
     */
    @Override
    public PageInfo<Songlist> getAllPlayList(Integer pageNo) {
        PageHelper.startPage(pageNo,pageSize);
        List<Songlist> songList = listMapper.selectByExample(new SonglistExample());
        return new PageInfo<>(songList);
    }

    /**
     * 带有分页信息的列表
     * @param pageNo 页码
     * @return 用户
     */
    @Override
    public PageInfo<User> getUserList(Integer pageNo) {
        PageHelper.startPage(pageNo,pageSize);
        List<User> users = userMapper.selectByExample(new UserExample());
        return new PageInfo<>(users);
    }

    /**
     * 带有分页信息的列表
     * @param pageNo 页码
     * @return 作家
     */
    @Override
    public PageInfo<Singer> getSingerList(Integer pageNo) {
        PageHelper.startPage(pageNo,pageSize);
        List<Singer> singers = singerMapper.selectByExample(new SingerExample());
        return new PageInfo<>(singers);
    }

    @Override
    public PageInfo<Album> getAlbum(Integer pageNo){
        AlbumExample e = new AlbumExample();
        PageHelper.startPage(pageNo,pageSize);
        List<Album> albums = albumMapper.selectByExample(e);
        return new PageInfo<>(albums);
    }

    /**
     * 获取歌单以及歌单中的歌曲
     * @param userId 创建者
     * @param listId 歌单id
     * @param pageNo 页码
     * @return map 中存放 listInfo 歌单信息，PageInfo songInfo 歌曲的信息
     */
    @Override
    public Map<String, Object> getSongAndList(Integer userId, Integer listId, Integer pageNo) {
        Map<String,Object> map = new HashMap<>();
        PageInfo<Song> pageInfo = null;
        if (playlistIsOvert(userId,listId)) {
            Songlist songlist = listMapper.selectByPrimaryKey(listId);
            map.put("listInfo",songlist);
            PageHelper.startPage(pageNo,pageSize);
            List<Song> songs = listMapper.selectSongInListByListId(listId);
            pageInfo = new PageInfo<>(songs);
        }else {
            return null;
        }
        map.put("SongInfo",pageInfo);
        return map;
    }

    /**
     * 查询歌单中的歌曲
     * @param listId 歌单id
     * @param pageNo 页码
     * @return 歌曲
     */
    @Override
    public PageInfo<Song> getSongPageFormList(Integer listId, Integer pageNo) {
        PageHelper.startPage(pageNo,pageSize);
        List<Song> songs = listMapper.selectSongInListByListId(listId);
        return new PageInfo<>(songs);
    }

    /**
     * 这里用来判断歌单对用户是否可见
     * @param userId 创建者id
     * @param listId 歌单id
     * @return 结果
     */
    @Override
    public Boolean playlistIsOvert(Integer userId, Integer listId){
        Songlist songlist = listMapper.selectByPrimaryKey(listId);
        if (songlist == null){
            return false;
        }
        if (songlist.getHide().equals(1)){
            return songlist.getCreator().equals(userId);
        }
        return true;
    }

}

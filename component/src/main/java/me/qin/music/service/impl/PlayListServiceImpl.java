package me.qin.music.service.impl;

import me.qin.music.entity.Song;
import me.qin.music.entity.Songlist;
import me.qin.music.entity.SonglistExample;
import me.qin.music.mapper.SonglistMapper;
import me.qin.music.service.PlayListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author PasserbyA
 * @date 2022/10/26 15:59
 */
@Service
public class PlayListServiceImpl implements PlayListService {
    @Autowired
    private SonglistMapper listMapper;

    /**
     * 查询指定用户的歌单
     * @param userId 用户id
     * @return 列表集合
     */
    @Transactional(readOnly = true)
    @Override
    public List<Songlist> getPlayListByUserId(Integer userId){
        SonglistExample example = new SonglistExample();
        example.createCriteria().andCreatorEqualTo(userId);

        List<Songlist> songList = listMapper.selectByExample(example);
        if (songList != null && songList.size() >0 ){
            return songList;
        }
        return null;
    }

    /**
     * 批量删除歌单
     * @param listId 要删除的歌单的id集合
     * @return 删除行数
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    @Override
    public Integer delPlayList(List<Integer> listId){
        //删除歌单中所有的歌曲
        listMapper.disassociateSongFromList(listId);

        SonglistExample example = new SonglistExample();
        SonglistExample.Criteria criteria = example.createCriteria();
        criteria.andListIdIn(listId);
        return  listMapper.deleteByExample(example);
    }

    /**
     * 批量删除指定用户的歌单
     * @param listId 要删除的歌单的id集合
     * @return 删除行数
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    @Override
    public Integer delUserPlaylist(List<Integer> listId, Integer userId){
        SonglistExample example = new SonglistExample();
        SonglistExample.Criteria criteria = example.createCriteria();
        criteria.andCreatorEqualTo(userId);
        criteria.andListIdIn(listId);
        //查询用户所有歌单
        List<Songlist> songList = listMapper.selectByExample(example);
        //属于 userId 用户的歌单的id集合
        List<Integer> listIds = songList.stream().map(Songlist::getListId).collect(Collectors.toList());
        //求交集
        listId.retainAll(listIds);
        //删除歌单中所有的歌曲
        listMapper.disassociateSongFromList(listId);

        return listMapper.deleteByExample(example);
    }

    /**
     * 添加一个歌单
     * @param playList 歌单信息
     * @return 添加状态
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    @Override
    public Integer addPlayList(Songlist playList){
        if (playList != null){
            playList.setListId(null);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            playList.setCreateTime(sdf.format(new Date()));
            return listMapper.insertSelective(playList);
        }
        return 0;
    }

    /**
     * 更新歌单信息
     * @param playList 新的歌单
     * @return 更新状态
     */
    @Override
    public Integer upDatePlayList(Songlist playList) {
        return listMapper.updateByPrimaryKeySelective(playList);
    }

    /**
     * 向歌单中添加歌曲
     * @param listId 歌单id
     * @param songId 添加歌曲集合
     * @return 添加状态
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    @Override
    public Integer playListPushSong(Integer listId, List<Integer> songId){

        List<Integer> songInList = listMapper.selectSongIdByListId(listId);
        songId.removeAll(songInList);
        return listMapper.putSongToList(listId, songId);
    }

    /**
     * 从歌单删除歌曲
     * @param listId 歌单id
     * @param songId 添加歌曲集合
     * @return 删除成功条数
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    @Override
    public Integer delSongFromList(Integer listId, List<Integer> songId){
        return listMapper.delSongForList(listId,songId);
    }

    /**
     * 通过歌单id获取其中的歌曲
     * @param listId id
     * @return 歌曲集合
     */
    @Override
    @Transactional(readOnly = true)
    public List<Song> getSongByListId(Integer listId) {
        return listMapper.selectSongInListByListId(listId);
    }

    /**
     * 根据id获取一个歌单
     * @param listId id
     * @return 歌单
     */
    @Override
    public Songlist getPlayListById(Integer listId){
        return listMapper.selectByPrimaryKey(listId);
   }

   @Override
    public void clearList(List<Integer> listIds){
        listMapper.disassociateSongFromList(listIds);
   }


}
package me.qin.music.service.impl;

import me.qin.music.entity.*;
import me.qin.music.mapper.AlbumMapper;
import me.qin.music.mapper.SingerMapper;
import me.qin.music.mapper.SongMapper;
import me.qin.music.mapper.SonglistMapper;
import me.qin.music.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 提供搜索服务
 * @author PasserbyA
 * @date 2022/10/16 19:48
 */

@Service
@Transactional(readOnly = true)
public class SearchServiceImpl implements SearchService {
    @Autowired
    private SongMapper songMapper;

    @Autowired
    private SonglistMapper songlistMapper;

    @Autowired
    private AlbumMapper albumMapper;

    @Autowired
    private SingerMapper singerMapper;


    @Override
    public List<Song> searchSong(String searchInfo){
        SongExample songExample = new SongExample();
        SongExample.Criteria criteria = songExample.createCriteria();
        String selectInfo = "%"+searchInfo+"%";
        criteria.andNameLike(selectInfo);
        List<Song> songs = songMapper.selectByExample(songExample);
        return songs;
    }

    @Override
    public List<Songlist> searchPlayList(String searchInfo){
        SonglistExample example = new SonglistExample();
        SonglistExample.Criteria criteria = example.createCriteria();
        String selectInfo = "%"+searchInfo+"%";
        criteria.andNameLike(selectInfo).andHideEqualTo(0);
        List<Songlist> playList = songlistMapper.selectByExample(example);
        return playList;
    }

    @Override
    public List<Album> searchAlbum(String searchInfo){
        AlbumExample example = new AlbumExample();
        AlbumExample.Criteria criteria = example.createCriteria();
        String selectInfo = "%"+searchInfo+"%";
        criteria.andNameLike(selectInfo);
        List<Album> albums = albumMapper.selectByExample(example);
        return  albums;
    }

    @Override
    public List<Singer> searchSinger(String searchInfo){
        SingerExample example = new SingerExample();
        SingerExample.Criteria criteria = example.createCriteria();
        String selectInfo = "%"+searchInfo+"%";
        criteria.andNameLike(selectInfo);
        List<Singer> singers = singerMapper.selectByExample(example);
        return singers;
    }


    @Override
    public Map<String,Object> searchByAll(String searchInfo){
        Map<String,Object> map = new HashMap<>();

        List<Singer> singers = searchSinger(searchInfo);
        if (singers !=null && singers.size()>0){
            map.put("singer",singers);
        }

        List<Song> songs = searchSong(searchInfo);
        if (songs !=null && songs.size()>0){
            map.put("song",songs);
        }

        List<Songlist> playList = searchPlayList(searchInfo);
        if (playList != null && playList.size()>0){
            map.put("playList",playList);
        }

        List<Album> albums = searchAlbum(searchInfo);
        if (albums != null && albums.size()>0){
            map.put("album",albums);
        }

        return map;
    }


}

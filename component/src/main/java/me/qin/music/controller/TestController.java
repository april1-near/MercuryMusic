package me.qin.music.controller;

import me.qin.music.entity.Album;
import me.qin.music.entity.Singer;
import me.qin.music.entity.Song;
import me.qin.music.entity.Songlist;
import me.qin.music.service.DailyPushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 测试
 * @author PasserbyA
 * @date 2022/10/16 15:37
 */

@Controller
public class TestController {

    @Autowired
    private DailyPushService visitService;

    @ResponseBody
    @RequestMapping(value = "test/message" ,produces = "text/html;charset=UTF-8")
    public String requestMessage(){

        return "你好---------来自服务器！";
    }


    @RequestMapping(value = "test/song" ,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<Song> requestObject(){
        List<Song> dailyPushSong = visitService.getDailyPushSong();
        return  dailyPushSong;
    }

    @RequestMapping(value = "test/map" ,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Map<String,Object> getMap(){
        Map<String,Object> map = new HashMap<>();
        List<Song> songs = new ArrayList<>();
        List<Album> albums = new ArrayList<>();
        List<Songlist> songlist = new ArrayList<>();
        List<Singer> singers = null;
        songs.add(new Song(43,"df","dfdfd","dfdffdgh","hght","hthu","hthghgh"));
        albums.add(new Album(24,"fdfdf","gru","dfdf"));
        songlist.add(new Songlist());


        map.put("song",songs);
        map.put("album",albums);
        map.put("playList",songlist);
        map.put("singer",singers);


        return map;
    }


    @RequestMapping(value = "test/getList" ,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getList(@RequestBody List<Integer> list) {

        System.out.println(list);
        return "rttrtrt";
    }




}

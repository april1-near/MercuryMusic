package me.qin.music.controller;

import me.qin.music.entity.Album;
import me.qin.music.entity.Singer;
import me.qin.music.entity.Song;
import me.qin.music.entity.Songlist;
import me.qin.music.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 响应搜索请求
 * @author PasserbyA
 * @date 2022/10/16 22:14
 */

@Controller
public class SearchController {

    @Autowired
    private SearchService searchService;

    /**
     * 给定范围搜索
     * @param range 搜索范围
     * @param searchInfo 搜索关键字
     * @return 结果
     */
    @ResponseBody
    @RequestMapping(value = "search",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public Map<String,Object> searchSelective(
            @RequestParam(value = "range",required = false) List<String> range,
            @RequestParam("searchInfo") String searchInfo
    ){
        if (range == null || range.size() == 0){
            return searchService.searchByAll(searchInfo);
        }

        Map<String,Object> map = new HashMap<>();

        //菜鸟判断四连
        for (String r : range) {
            if ("song".equals(r)){
                List<Song> songs = searchService.searchSong(searchInfo);
                if (songs !=null && songs.size()>0){
                    map.put("song",songs);
                }
            }

            if ("singer".equals(r)){
                List<Singer> singers = searchService.searchSinger(searchInfo);
                if (singers !=null && singers.size()>0){
                    map.put("singer",singers);
                }
            }

            if ("album".equals(r)){
                List<Album> albums = searchService.searchAlbum(searchInfo);
                if (albums != null && albums.size()>0){
                    map.put("album",albums);
                }
            }

            if ("playList".equals(r)){
                List<Songlist> playList = searchService.searchPlayList(searchInfo);
                if (playList != null && playList.size()>0){
                    map.put("playList",playList);
                }
            }

        }
        return map;
    }


}

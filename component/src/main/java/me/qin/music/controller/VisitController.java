package me.qin.music.controller;

import com.github.pagehelper.PageInfo;
import me.qin.music.entity.*;
import me.qin.music.service.DailyPushService;
import me.qin.music.service.GetPageDataService;
import me.qin.music.util.message.MessageConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * 响应一般访问的请求
 * @author PasserbyA
 * @date 2022/10/14 22:04
 */

@Controller
@Transactional(readOnly = true)
public class VisitController  {

    @Autowired
    private DailyPushService dailyPushService;
    @Autowired
    private GetPageDataService pageDataService;

    /**
     * @param session 获取登录状态
     * @param model model
     * @return 首页视图
     */
    @RequestMapping(value = "visit")
    public String showSongList(HttpSession session,
                               Model model
    ){
        Object user = session.getAttribute("user");
        if (user == null){
            model.addAttribute("loginSing", MessageConst.NOT_LOGGED_SIGN);
        }else {
            model.addAttribute("loginSing", MessageConst.LOGGED_IN_SIGN);
        }
        return "visit";
    }

    /**
     * 获取推荐
     * @return 每日推荐歌曲
     */
    @RequestMapping(value = "dailyPush" ,
            produces = "application/json;charset=UTF-8",
            method = RequestMethod.GET )
    @ResponseBody
    public List<Song> showPushSong(){
        return dailyPushService.getDailyPushSong();
    }

//    /**
//     * 获取歌单列表
//     * @param pageNo 页码
//     * @return 带有分信息的pageInfo
//     */
//    @RequestMapping(value = "playList/{pageNo}" ,
//            produces = "application/json;charset=UTF-8",
//            method = RequestMethod.GET)
//    @ResponseBody
//    public PageInfo<Songlist> showPubPlayList(@PathVariable Integer pageNo){
//        return pageDataService.getPublicPlayList(pageNo);
//    }

    /**
     * 获取一些专辑
     * @param pageNo 页码
     * @return 第 pageNo 页的专辑信息
     */
    @RequestMapping(value = "albumList/{pageNo}" ,
            produces = "application/json;charset=UTF-8",
            method = RequestMethod.GET)
    @ResponseBody
    public PageInfo<Album> showAlbumList(@PathVariable Integer pageNo){
        return pageDataService.getAlbum(pageNo);
    }

    /**
     * 获取一些歌手
     * @param pageNo 页码
     * @return 第 pageNo 页的歌手信息
     */
    @RequestMapping(value = "singerList/{pageNo}",
            produces = "application/json;charset=UTF-8",
            method = RequestMethod.GET)
    @ResponseBody
    public PageInfo<Singer> showSinger(@PathVariable Integer pageNo) {
        return pageDataService.getSingerList(pageNo);
    }


    /**
     * 返回一个歌单展示视图，其中包含歌单中30首歌曲
     * @param session session
     * @param model mode
     * @param listId 歌单id
     * @return 视图
     */
    @RequestMapping(value = "playlistDetail/{listId}",
            produces = "application/json;charset=UTF-8",
            method = RequestMethod.GET)
    public String showSongInList(
            HttpSession session,
            Model model,
            @PathVariable("listId") Integer listId
    ){
        Object user = session.getAttribute("user");
        Integer userId = null;
        if (user instanceof User){
            userId = ((User) user).getUserId();
        }
        Map<String, Object> listAndSong = pageDataService.getSongAndList(userId, listId, 1);
        model.addAttribute("listAndSong",listAndSong);
        return "playList";
    }


    @RequestMapping(value = "upSongList/{listId}/{pageNo}",
            produces = "application/json;charset=UTF-8",
            method = RequestMethod.GET)
    public PageInfo<Song> upSongPage(
            HttpSession session,
            @PathVariable("listId") Integer listId,
            @PathVariable("pageNo") Integer pageNo
    ){
        Object user = session.getAttribute("user");
        Integer userId = null;
        if (user instanceof User){
            userId = ((User) user).getUserId();
        }

        if (pageDataService.playlistIsOvert(userId,listId)){
            return pageDataService.getSongPageFormList(listId,pageNo);
        }
        return null;
    }



}


package me.qin.music.controller;

import me.qin.music.entity.Song;
import me.qin.music.entity.Songlist;
import me.qin.music.entity.User;
import me.qin.music.service.PlayListService;
import me.qin.music.service.SongService;
import me.qin.music.service.UserService;
import me.qin.music.util.message.MessageConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 响应用户操作的请求
 * @author PasserbyA
 * @date 2022/10/13 16:49
 */

@Controller
@CrossOrigin(origins = "http://localhost:8080")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private SongService songService;
    @Autowired
    private PlayListService playListService;
    /**
     * 用户登录功能
     * @param uName 名字
     * @param uPasswd 密码
     * @param session session
//     * @param model model
     * @return 用户个人界面视图
     */
    @PostMapping("/login")
    public ResponseEntity<?> userLogin(HttpSession session,
                                       @RequestParam("uName") String uName,
                                       @RequestParam("uPasswd") String uPasswd) {

//        System.out.println(uName);
//        System.out.println(uPasswd);
        User user = userService.getUserByLogin(uName, uPasswd);
        Map<String, Object> response = new HashMap<>();
        if (user == null){
            //用户名或密码错误
            response.put("msg", MessageConst.LOGIN_FINED_MESSAGE);
            response.put("user", null);
        } else {
            session.setAttribute("user",user);
            response.put("msg", "登录成功");
            response.put("user", user);
        }
        //返回用户信息和提示信息
        return ResponseEntity.ok(response);
    }

    /**
     * 请求用户界面
     * @param session session对象
     * @return 返回一个视图
     */
    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public String userGetHome(HttpSession session) {
        Object user = session.getAttribute("user");
        if(user instanceof User){
            return "account/home";
        }
        //用户没有登录
        return "redirect:/slogin";
    }

    /**
     * 注销登录
     * @param session session对象
     * @return 转发至首页
     */
    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String userLogout(HttpSession session) {
        Object user = session.getAttribute("user");
        if(user instanceof User){
            session.removeAttribute("user");
        }
        return "redirect:/";
    }


    /**
     * 请求用户所有的歌单
     * @param userId 用户ID
     * @return 歌单集合
     */
    @GetMapping("/u/myLists/{userId}")
    @ResponseBody
    public List<Songlist> userPlayList(@PathVariable("userId") Integer userId) {
        return playListService.getPlayListByUserId(userId);
    }


    /**
     * 用户删除自己的歌单
     * @param session session
     * @param listId 要删除歌单的id
     * @return 被删除的歌单的id
     */
    @RequestMapping(value = "/u/delPlayList/",
            method = RequestMethod.DELETE,
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Integer userDelPlayList(HttpSession session,
                                   @RequestBody List<Integer> listId
    ){
        User user = (User) session.getAttribute("user");
        return playListService.delUserPlaylist(listId, user.getUserId());
    }

    /**
     * 用户请求创建一个歌单
     * @param session session
     * @param playList 歌单信息
     * @return 结果
     */
    @RequestMapping(value = "/u/addPlayList/",
            method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Integer userAddPlayList(HttpSession session,
                                   @RequestBody Songlist playList
    ){
        User user = (User) session.getAttribute("user");
        playList.setCreator(user.getUserId());
        return playListService.addPlayList(playList);
    }

    /**
     * 用户请求更新歌单
     * @param session session
     * @param playList 更新信息
     * @return 结果
     */
    @RequestMapping(value = "/u/upPlayList/",
            method = RequestMethod.PUT,
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Boolean userUpdatePlayList(
            HttpSession session,
            @RequestBody Songlist playList
    ){
        User  user = (User) session.getAttribute("user");
        //数据库中的歌单信息
        Songlist dbList = playListService.getPlayListById(playList.getListId());
        if (dbList == null || !user.getUserId().equals(dbList.getCreator()) ){
            return false;
        }
        return playListService.upDatePlayList(playList).equals(1);
    }

    /**
     * 用户向歌单中添加音乐
     * @param session session
     * @param listId 歌单id
     * @return 添加结果
     */

    @RequestMapping(value = "/userCollect/{listId}",
            method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8")
    public ResponseEntity<Integer> userPushSongToList(
            HttpSession session,
            @PathVariable  Integer listId,
            @RequestBody Song song
    ) {
        User user = (User) session.getAttribute("user");
        //数据库中的歌单信息
        List songIds = new ArrayList();
//        Map<String, Object> response = new HashMap<>();
        List<Song> songs = songService.searchSongs(song.getName(), song.getAuthor());
        if (songs.isEmpty()) {
             int songId = songService.addSong(song);
            System.out.println(songId);
            songIds.add(songId);
        }else {
            songIds.add(songs.get(0).getSongId());
        }
        Integer integer = playListService.playListPushSong(listId, songIds);
//        System.out.println(integer);
        return ResponseEntity.ok(integer);
    }


    /**
     * 用户从歌单中删除音乐
     * @param session session
     * @param listId 歌单id
     * @param songIds 添加的歌曲
     * @return 添加结果
     */
    public boolean userDelSongFormList(
            HttpSession session,
            @RequestBody Integer listId,
            @RequestBody List<Integer> songIds
    ){
        User  user = (User) session.getAttribute("user");
        //数据库中的歌单信息
        Songlist dbList = playListService.getPlayListById(listId);
        if (songIds == null ||songIds.size() == 0 || !user.getUserId().equals(dbList.getCreator()) ){
            return false;
        }
        Integer integer = playListService.delSongFromList(listId, songIds);
        return integer > 0;
    }
}
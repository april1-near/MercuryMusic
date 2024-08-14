package me.qin.music.controller;

import com.github.pagehelper.PageInfo;
import me.qin.music.entity.*;
import me.qin.music.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 实现管理员操作的类
 * 所以操作通过该路径： m/xxx/xxx/
 * filter过滤 m/**
 *
 * 登录视图: /mlogin
 * 登录请求：GET：su/manage
 * 后台视图：POST：m/manage
 * 管理员注销请求：m/logout
 *
 *用户管理：
 *   创建用户:POST: m/user
 *   删除用户:DELETE: m/user
 *   更新用户:PUT：m/user
 *
 * 歌单管理：
 *   创建歌单：POST: m/playlist
 *   删除歌单：DELETE：m/playlist/
 *   更新歌单: PUT:m/playList
 *     歌单中分页的歌曲 GET: m/l/song
 *     从歌单中移除歌曲：DELETE: m/l/song
 *     向歌单中添加歌曲：POST: m/l/song
 *     清空歌单：DELETE: m/l/clearSong
 *
 * 歌手管理：
 *    添加一个歌手：POST: m/singer
 *    移除歌手：DELETE: m/singer
 *    更新歌手：PUT: m/singer
 *
 * 专辑管理：
 *  添加一个专辑：POST: m/album
 *  移除专辑：DELETE: m/album
 *  更新专辑：PUT: m/album
 * 
 *  后台展示：
 *    分页的用户信息：GET m/showUser/{pageNo}
 *    分页的歌单信息：GET m/showPlayList/{pageNo}
 *    分页的专辑信息 GET m/showAlbum/{pageNo}
 *    分页的歌手信息 GET m/showSinger/{pageNo}
 *
 * 歌曲管理：
 *   获取一首歌曲的信息 GET： m/song
 *   更新一首歌曲的信息 PUT： m/song
 *   删除一首歌曲的信息：DELETE: m/song
 *   上传一首歌曲：(暂不实现)
 *
 *
 * @author PasserbyA
 * @date 2022/11/5 19:59
 */

@Controller
public class ManageController {

    @Autowired
    GetPageDataService pageDataService;
    @Autowired
    UserService userService;
    @Autowired
    PlayListService listService;
    @Autowired
    AlbumService albumService;
    @Autowired
    SingerService singerService;
    @Autowired
    SongService songService;


    /**
     * 分页的用户信息：GET m/showUser/{pageNo}
     *
     * @param pageNo 页码
     * @return PageInfo
     */
    @RequestMapping(value = "m/showUser/{pageNo}",
            produces = "application/json;charset=UTF-8",
            method = RequestMethod.GET)
    @ResponseBody
    public PageInfo<User> mShowUser(@PathVariable Integer pageNo) {
        return pageDataService.getUserList(pageNo);
    }

    /**
     * 分页的歌单信息：GET m/showPlayList/{pageNo}
     *
     * @param pageNo 页码
     * @return PageInfo
     */
    @RequestMapping(value = "m/showPlayList/{pageNo}",
            produces = "application/json;charset=UTF-8",
            method = RequestMethod.GET)
    @ResponseBody
    public PageInfo<Songlist> mShowPlayList(@PathVariable Integer pageNo) {
        return pageDataService.getAllPlayList(pageNo);
    }

    /**
     * 分页的专辑信息 GET m/showAlbum/{pageNo}
     *
     * @param pageNo 页码
     * @return PageInfo
     */
    @RequestMapping(value = "m/showAlbum/{pageNo}",
            produces = "application/json;charset=UTF-8",
            method = RequestMethod.GET)
    @ResponseBody
    public PageInfo<Album> mShowAlbum(@PathVariable Integer pageNo) {
        return pageDataService.getAlbum(pageNo);
    }

    /**
     * 分页的歌手信息 GET m/showSinger/{pageNo}
     *
     * @param pageNo 页码
     * @return PageInfo
     */
    @RequestMapping(value = "m/showSinger/{pageNo}",
            produces = "application/json;charset=UTF-8",
            method = RequestMethod.GET)
    @ResponseBody
    public PageInfo<Singer> mShowSinger(@PathVariable Integer pageNo) {
        return pageDataService.getSingerList(pageNo);
    }


    /**
     * 歌单中分页的歌曲 GET: m/l/showSong/{listId}/{pageNo}
     *
     * @param listId 歌单id
     * @param pageNo 页码
     * @return PageInfo
     */
    @RequestMapping(value = "m/l/showSong/{listId}/{pageNo}",
            produces = "application/json;charset=UTF-8",
            method = RequestMethod.GET)
    @ResponseBody
    public PageInfo<Song> mlShowSong(@PathVariable Integer listId,
                                     @PathVariable Integer pageNo
    ) {
        return pageDataService.getSongPageFormList(listId, pageNo);
    }

    /*用户管理********************************************************************/

    /**
     * 创建用户:POST: m/user/
     * 添加一个用户
     *
     * @param user 用户信息
     * @return 结果
     */
    @RequestMapping(value = "m/user",
            produces = "application/json;charset=UTF-8",
            method = RequestMethod.POST)
    @ResponseBody
    public Boolean mAddUser(@RequestBody User user) {
        return userService.addUser(user).equals(1);
    }

    /**
     * 删除用户:DELETE: m/user/
     *
     * @param userId id集合
     * @return 删除行数
     */
    @RequestMapping(value = "m/user",
            produces = "application/json;charset=UTF-8",
            method = RequestMethod.DELETE)
    @ResponseBody
    public Integer mDelUser(@RequestBody List<Integer> userId) {
        for (Integer uid : userId) {
            List<Songlist> userPlayList = listService.getPlayListByUserId(uid);
            List<Integer> listIds = userPlayList.stream().map(Songlist::getListId).collect(Collectors.toList());
            listService.delPlayList(userId);
        }
        return userService.delUser(userId);
    }

    /**
     * 更新用户:PUT：m/PUTUser
     *
     * @param user 新的用户信息
     * @return 1
     */
    @RequestMapping(value = "m/user",
            produces = "application/json;charset=UTF-8",
            method = RequestMethod.PUT)
    @ResponseBody
    public Integer mPutUser(@RequestBody User user) {
        return userService.uptUser(user);
    }

    /*歌单管理********************************************************************/

    /**
     * 创建歌单：POST: m/playlist
     *
     * @param session  session
     * @param songlist 歌单信息
     * @return 结果
     */
    @RequestMapping(value = "m/playlist",
            produces = "application/json;charset=UTF-8",
            method = RequestMethod.POST)
    @ResponseBody
    public Integer mAddPlaylist(@RequestBody Songlist songlist,
                                HttpSession session) {
        if (songlist.getCreator() == null) {
            User admin = (User) session.getAttribute("user");
            songlist.setCreator(admin.getUserId());
        }
        return listService.addPlayList(songlist);
    }

    /**
     * 删除歌单：DELETE：m/playlist/
     *
     * @param listIds 歌单id
     * @return 删除行数
     */
    @RequestMapping(value = "m/playlist",
            produces = "application/json;charset=UTF-8",
            method = RequestMethod.DELETE)
    @ResponseBody
    public Integer mDelPlayList(@RequestBody List<Integer> listIds) {
        return listService.delPlayList(listIds);
    }

    /**
     * 更新歌单: PUT:m/playlist
     *
     * @param songlist 新的歌单信息
     * @return 1
     */
    @RequestMapping(value = "m/playlist",
            produces = "application/json;charset=UTF-8",
            method = RequestMethod.PUT)
    @ResponseBody
    public Integer mUptPlayList(@RequestBody Songlist songlist) {
        return listService.upDatePlayList(songlist);
    }

    /**
     * 歌单中分页的歌曲 GET: m/l/song
     *
     * @param listId 歌单id
     * @param pageNo 页码
     * @return PageInfo
     */
    @RequestMapping(value = "m/l/song/{listId}/{pageNo}",
            produces = "application/json;charset=UTF-8",
            method = RequestMethod.GET)
    @ResponseBody
    public PageInfo<Song> mGetSongForList(@PathVariable Integer listId,
                                          @PathVariable Integer pageNo
    ) {
        return pageDataService.getSongPageFormList(listId, pageNo);
    }

    /**
     * 从歌单中移除歌曲：DELETE: m/l/song
     *
     * @param listId  歌单id
     * @param songIds 歌曲id集合
     * @return 删除条数
     */
    @RequestMapping(value = "m/l/song/",
            produces = "application/json;charset=UTF-8",
            method = RequestMethod.PUT)
    @ResponseBody
    public Integer mRemSongFromList(@RequestBody Integer listId,
                                    @RequestBody List<Integer> songIds
    ) {
        return listService.delSongFromList(listId, songIds);
    }

    /**
     * 向歌单中添加歌曲：POST: m/l/song
     *
     * @param listId  歌单id
     * @param songIds 歌曲id集合
     * @return 添加成功返回1
     */
    @RequestMapping(value = "m/l/song/",
            produces = "application/json;charset=UTF-8",
            method = RequestMethod.POST)
    @ResponseBody
    public Integer mPushSongToList(@RequestBody Integer listId,
                                   @RequestBody List<Integer> songIds
    ) {
        return listService.playListPushSong(listId, songIds);
    }

    /**
     * @param listId 歌单id
     *清空歌单：DELETE: m/l/clear/{listId}
     */
    @RequestMapping(value = "m/l/clear/{listId}",
            produces = "application/json;charset=UTF-8",
            method = RequestMethod.DELETE)
    @ResponseBody
    public void mClearPlaylist(@PathVariable("listId") Integer listId) {
        List<Integer> list = new ArrayList<>();
        list.add(listId);
        listService.clearList(list);
    }

// * 歌手管理：
//*     添加一个歌手：POST: m/singer
// *    移除歌手：DELETE: m/singer
// *    更新歌手：PUT: m/singer

    /**
     * 请求添加一个歌手信息 POST: m/singer
     *
     * @param singer 歌手实例
     * @return 若成功返回true
     */
    @RequestMapping(value = "m/singer",
            produces = "application/json;charset=UTF-8",
            method = RequestMethod.POST)
    @ResponseBody
    public Boolean mAddSinger(@RequestBody Singer singer) {
        if (singer.getSingerId() == null) {
            return false;
        }
        return singerService.addSinger(singer) == 1;
    }

    /**
     * 请求删除一个歌手信息 DELETE: m/singer
     *删除作者信息并删除作者所有的专辑
     * @param ids id集合
     * @return 返回删除条数
     */
    @RequestMapping(value = "m/singer",
            produces = "application/json;charset=UTF-8",
            method = RequestMethod.DELETE)
    @ResponseBody
    public Integer mDelSinger(@RequestBody List<Integer> ids) {
        for (Integer id : ids) {
            Singer singer = singerService.getSingerById(id);
            if (singer != null){
                List<Integer> albumIds = albumService.getIdsByAuthor(singer.getName());
                albumService.delAlbumById(ids);
            }
        }
        return singerService.delSingerById(ids);
    }

    /**
     * 跟新一个歌手的信息 PUT  m/singer
     * @param singer 新的实例
     * @return 若成功返回 1
     */
    @RequestMapping(value = "m/singer",
            produces = "application/json;charset=UTF-8",
            method = RequestMethod.PUT)
    @ResponseBody
    public Integer mPutSinger(@RequestBody Singer singer) {
        if (singer.getSingerId() == null) {
            return 0;
        }
        return singerService.upSingerById(singer);
    }


//     * 专辑管理：
// *  添加一个专辑：POST: m/album
// *  移除专辑：DELETE: m/album
// *  更新专辑：PUT: m/album

    /**
     * 添加一个专辑 POST: m/album
     *
     * @param album 专辑实例
     * @return 添加成功返回1
     */
    @RequestMapping(value = "m/album",
            produces = "application/json;charset=UTF-8",
            method = RequestMethod.POST)
    @ResponseBody
    public Integer mAddAlbum(@RequestBody Album album) {
        return albumService.addAlbumById(album);
    }

    /**
     * 根据id 批量的删除歌手的信息
     *DELETE: m/album
     * @param ids 歌手id
     * @return 返回被删除数量
     */
    @RequestMapping(value = "m/album",
            produces = "application/json;charset=UTF-8",
            method = RequestMethod.DELETE)
    @ResponseBody
    public Integer mDelAlbum(@RequestBody List<Integer> ids) {
        return albumService.delAlbumById(ids);
    }

    /**
     * 请求更新一个专辑信息
     * PUT: m/album
     * @param album 新的 专辑信息 album对象
     * @return 若成功返回1
     */
    @RequestMapping(value = "m/album",
            produces = "application/json;charset=UTF-8",
            method = RequestMethod.PUT)
    @ResponseBody
    public Integer mPutAlbum(@RequestBody Album album) {
        if (album.getAlbumId() == null)
        {
            return 0;
        }
        return albumService.upAlbum(album);
    }


//     * 歌曲管理：
// *   获取一首歌曲的信息 GET： m/song
// *   更新一首歌曲的信息 PUT： m/song
// *   删除一首歌曲的信息：DELETE: m/song

    /**
     * 管理员获取一首歌曲的信息 GET: m/song
     * @param songId 歌曲id
     * @return song实例
     */
    @RequestMapping(value = "m/song",
            produces = "application/json;charset=UTF-8",
            method = RequestMethod.GET)
    @ResponseBody
    public Song mGetSong(@RequestBody Integer songId){
        return songService.getSongById(songId);
    }

    // *   更新一首歌曲的信息 PUT： m/song


    /**
     * 更新一首歌曲的信息 PUT： m/song
     * @param song 歌曲实例
     * @return 若成功返回1
     */
    @RequestMapping(value = "m/song",
            produces = "application/json;charset=UTF-8",
            method = RequestMethod.PUT)
    @ResponseBody
    public Integer mPutSong(@RequestBody Song song){
        if (song.getSongId() == null){
            return 0;
        }
        return songService.upSong(song);
    }

    @RequestMapping(value = "m/song",
            produces = "application/json;charset=UTF-8",
            method = RequestMethod.DELETE)
    @ResponseBody
    public Integer mDelSong(@RequestBody Integer songId){
        return songService.delSongById(songId);
    }




}
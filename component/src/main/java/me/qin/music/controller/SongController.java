package me.qin.music.controller;

/**
 * @author PasserbyA
 * @date 2023/11/3 0:21
 */

import me.qin.music.entity.Song;
import me.qin.music.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/playList")

public class SongController {
    @Autowired
    private SongService songService;

    @PostMapping("/addsong")
    public Integer addSong(@RequestBody Song song) {
        // 调用 SongService 的 addSong 方法将歌曲添加到数据库
        return songService.addSong(song);
    }

    @GetMapping("/getAllsong")
    public ResponseEntity<?> getAll() {
//         调用 SongService 的 addSong 方法将歌曲添加到数据库
        List<Song> allSongs = songService.getAllSongs();
        System.out.println(allSongs);
        return ResponseEntity.ok(allSongs);
    }





}

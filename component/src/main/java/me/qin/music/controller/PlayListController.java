package me.qin.music.controller;

import me.qin.music.entity.Song;
import me.qin.music.service.PlayListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author PasserbyA
 * @date 2023/11/2 21:33
 */
@Controller
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/playList")
public class PlayListController {

    @Autowired
    private PlayListService playListService;

    @GetMapping("/{listId}")
    public ResponseEntity<?> getSongByListId(@PathVariable Integer listId) {
        try {
            List<Song> songs = playListService.getSongByListId(listId);
            return ResponseEntity.ok(songs);
        } catch (Exception e) {
            // 处理异常
            return ResponseEntity.badRequest().body("Failed to retrieve songs from the playlist.");
        }
    }



}

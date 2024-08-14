package me.qin.music.service;

import me.qin.music.entity.Album;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 *封装对专辑操作的事务
 * @author PasserbyA
 * @date 2022/11/16 15:38
 */

public interface AlbumService {


    int addAlbumById(@NotNull Album album);

    Album getAlbumById(Integer id);

    int delAlbumById(Integer id);

    int delAlbumById(List<Integer> ids);

    int upAlbum(Album album);

    List<Integer> getIdsByAuthor(String authorName);
}

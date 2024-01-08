package com.github.riannegreiros.springcloud.springcloud.services;

import com.github.riannegreiros.springcloud.springcloud.entities.Album;
import com.github.riannegreiros.springcloud.springcloud.entities.RecentlyHeard;
import com.github.riannegreiros.springcloud.springcloud.entities.User;
import com.github.riannegreiros.springcloud.springcloud.repositories.AlbumRepository;
import com.github.riannegreiros.springcloud.springcloud.repositories.RecentlyHeardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class RecentlyHeardService {

    @Autowired
    private RecentlyHeardRepository recentlyHeardRepository;

    @Autowired
    private AlbumRepository albumRepository;

    public void save(User user, Long albumId) {
        Album album = albumRepository.findById(albumId).orElseThrow(() -> new EntityNotFoundException("Album not found with id: " + albumId));

        RecentlyHeard recentlyHeard = new RecentlyHeard();
        recentlyHeard.setUser(user);
        recentlyHeard.setAlbum(album);
        recentlyHeardRepository.save(recentlyHeard);
    }

    public List<Album> getRecentHeards(Long userId) {
        // Assuming RecentlyHeard has a ManyToOne relationship with Album
        return recentlyHeardRepository.findTop4ByUserIdOrderByCreatedAtDesc(userId)
                .stream()
                .map(RecentlyHeard::getAlbum)
                .toList();
    }
}

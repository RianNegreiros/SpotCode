package com.github.riannegreiros.springcloud.springcloud.services;

import com.github.riannegreiros.springcloud.springcloud.entities.Album;
import com.github.riannegreiros.springcloud.springcloud.entities.RecentlyHeard;
import com.github.riannegreiros.springcloud.springcloud.entities.User;
import com.github.riannegreiros.springcloud.springcloud.repositories.AlbumRepository;
import com.github.riannegreiros.springcloud.springcloud.repositories.RecentlyHeardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class RecentlyHeardService {

    @Autowired
    private RecentlyHeardRepository recentlyHeardRepository;

    @Autowired
    private AlbumRepository albumRepository;

    public void save(Long albumId) {
        Album album = albumRepository.findById(albumId).orElseThrow(() -> new EntityNotFoundException("Album not found with id: " + albumId));

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = null;

        if (authentication != null && authentication.getPrincipal() instanceof User userDetails) {
            user = userDetails;
        }

        RecentlyHeard recentlyHeard = new RecentlyHeard();
        recentlyHeard.setUser(user);
        recentlyHeard.setAlbum(album);
        recentlyHeardRepository.save(recentlyHeard);
    }
}

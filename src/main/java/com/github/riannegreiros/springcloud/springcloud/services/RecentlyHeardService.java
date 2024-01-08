package com.github.riannegreiros.springcloud.springcloud.services;

import com.github.riannegreiros.springcloud.springcloud.entities.Album;
import com.github.riannegreiros.springcloud.springcloud.entities.RecentlyHeard;
import com.github.riannegreiros.springcloud.springcloud.entities.User;
import com.github.riannegreiros.springcloud.springcloud.repositories.RecentlyHeardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class RecentlyHeardService {

    @Autowired
    private RecentlyHeardRepository recentlyHeardRepository;

    public void save(User user, Album album) {
        RecentlyHeard recentlyHeard = new RecentlyHeard();
        recentlyHeard.setUser(user);
        recentlyHeard.setAlbum(album);
        recentlyHeard.setListenedAt(LocalDate.now());
        recentlyHeardRepository.save(recentlyHeard);
    }
}

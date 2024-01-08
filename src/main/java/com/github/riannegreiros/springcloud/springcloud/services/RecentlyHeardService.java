package com.github.riannegreiros.springcloud.springcloud.services;

import com.github.riannegreiros.springcloud.springcloud.entities.Album;
import com.github.riannegreiros.springcloud.springcloud.entities.RecentlyHeard;
import com.github.riannegreiros.springcloud.springcloud.entities.User;
import com.github.riannegreiros.springcloud.springcloud.repositories.RecentlyHeardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<Album> loadRecentHeard() {
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int limit = 4;

        List<RecentlyHeard> recentlyHeardList = recentlyHeardRepository.findByUserOrderByCreatedAtDesc(currentUser, PageRequest.of(0, limit));

        return recentlyHeardList.stream()
                .map(RecentlyHeard::getAlbum)
                .collect(Collectors.toList());
    }
}

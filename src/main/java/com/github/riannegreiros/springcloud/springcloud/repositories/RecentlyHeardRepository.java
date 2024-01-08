package com.github.riannegreiros.springcloud.springcloud.repositories;

import com.github.riannegreiros.springcloud.springcloud.entities.RecentlyHeard;
import com.github.riannegreiros.springcloud.springcloud.entities.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecentlyHeardRepository extends JpaRepository<RecentlyHeard, Long> {
    List<RecentlyHeard> findTop4ByUserIdOrderByCreatedAtDesc(Long userId);
}

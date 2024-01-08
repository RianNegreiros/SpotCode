package com.github.riannegreiros.springcloud.springcloud.repositories;

import com.github.riannegreiros.springcloud.springcloud.entities.RecentlyHeard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecentlyHeardRepository extends JpaRepository<RecentlyHeard, Long> {
}

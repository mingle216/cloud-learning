package com.mmh.content.repository;

import com.mmh.content.domain.entity.Share;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ShareRepository extends JpaRepository<Share,Integer> {
}

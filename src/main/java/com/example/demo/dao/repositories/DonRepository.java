package com.example.demo.dao.repositories;

import com.example.demo.dao.entities.Don;
import com.example.demo.dao.entities.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonRepository extends JpaRepository<Don, Long> {

    List<Don> findByActionId(Long actionId);
    Page<Don> findByActionId(Long actionId, Pageable pageable);
    List<Don> findByType(Type type);
}
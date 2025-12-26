package com.example.demo.dao.repositories;

import com.example.demo.dao.entities.Action;
import com.example.demo.dao.entities.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActionRepository extends JpaRepository<Action, Long> {

    List<Action> findByTitreContaining(String titre);
    Page<Action> findByTitreContaining(String titre, Pageable pageable);
    List<Action> findByStatus(Status status);

    @Query("SELECT a FROM Action a WHERE a.titre LIKE %:keyword% OR a.description LIKE %:keyword%")
    Page<Action> search(@Param("keyword") String keyword, Pageable pageable);
}
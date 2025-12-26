package com.example.demo.dao.repositories;

import com.example.demo.dao.entities.Organisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganisateurRepository extends JpaRepository<Organisateur, Long> {
}
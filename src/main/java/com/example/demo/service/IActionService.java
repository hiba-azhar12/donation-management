package com.example.demo.service;

import com.example.demo.dao.entities.Action;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IActionService {
    List<Action> getAll();
    Page<Action> getAll(int page, int size);
    Action getById(Long id);
    void save(Action action);
    void delete(Long id);
    Page<Action> search(String keyword, int page, int size);
}
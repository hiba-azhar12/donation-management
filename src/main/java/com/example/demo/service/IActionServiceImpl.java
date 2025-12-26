package com.example.demo.service;

import com.example.demo.dao.entities.Action;
import com.example.demo.dao.repositories.ActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IActionServiceImpl implements IActionService {

    @Autowired
    private ActionRepository actionRepository;

    @Override
    public List<Action> getAll() {
        return actionRepository.findAll();
    }

    @Override
    public Page<Action> getAll(int page, int size) {
        return actionRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public Action getById(Long id) {
        return actionRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Action action) {
        actionRepository.save(action);
    }

    @Override
    public void delete(Long id) {
        actionRepository.deleteById(id);
    }

    @Override
    public Page<Action> search(String keyword, int page, int size) {
        return actionRepository.search(keyword, PageRequest.of(page, size));
    }
}
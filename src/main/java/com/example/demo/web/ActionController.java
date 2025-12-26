package com.example.demo.web;

import com.example.demo.dao.entities.Action;
import com.example.demo.service.IActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/actions")
public class ActionController {

    @Autowired
    private IActionService actionService;

    @GetMapping
    public String list(Model model,
                       @RequestParam(defaultValue = "0") int page,
                       @RequestParam(defaultValue = "") String keyword) {

        Page<Action> actionsPage = keyword.isEmpty()
                ? actionService.getAll(page, 5)
                : actionService.search(keyword, page, 5);

        model.addAttribute("actions", actionsPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", actionsPage.getTotalPages());
        model.addAttribute("keyword", keyword);

        return "actions/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("action", new Action());
        return "actions/add";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Action action) {
        actionService.save(action);
        return "redirect:/actions";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("action", actionService.getById(id));
        return "actions/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Action action) {
        actionService.save(action);
        return "redirect:/actions";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        actionService.delete(id);
        return "redirect:/actions";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable Long id, Model model) {
        model.addAttribute("action", actionService.getById(id));
        return "actions/details";
    }
}
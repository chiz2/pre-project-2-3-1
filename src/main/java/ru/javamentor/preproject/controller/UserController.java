package ru.javamentor.preproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.javamentor.preproject.model.User;
import ru.javamentor.preproject.service.UserService;
import javax.validation.Valid;


@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public String getUsers(Model model) {
        model.addAttribute("users", service.getUsers());
        return "users";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping
    public String create(@ModelAttribute("user")User user) {
        service.save(user);
    return "redirect:users";
    }

    @DeleteMapping("/{id}")
    public String remove(@PathVariable("id") int id) {
        service.remove(id);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", service.show(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") @Valid User user,
                         @PathVariable("id") int id) {
        service.update(id, user);
        return "redirect:/users";
    }
}

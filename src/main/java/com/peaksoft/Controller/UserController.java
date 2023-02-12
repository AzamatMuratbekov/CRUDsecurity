package com.peaksoft.Controller;

import com.peaksoft.entity.User;
import com.peaksoft.service.RoleService;
import com.peaksoft.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final RoleService roleService;

    @GetMapping
    public String hello() {
        return "hello1";
    }

    @GetMapping("/users")
    public String users(Model model) {
        model.addAttribute("users", userService.getAll());

        return "users";
    }
    @GetMapping("/adduser")
    public String add(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("roles", roleService.getAllRole());
        return "saveUser";
    }
    @PostMapping("/saveuser")
    public String save(@ModelAttribute("user") User user) {
        userService.addUser(user, user.getRoleId());
        return "redirect:/users/profile";
    }
    @GetMapping("/profile")
    public String profile(HttpServletRequest request, Model model) {
        Principal principal = request.getUserPrincipal();
        model.addAttribute("user", userService.getUserByUserName(principal.getName()));
        return "profile";

    }
}

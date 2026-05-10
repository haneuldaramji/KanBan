package com.kanban.controller;

import com.kanban.entity.User;
import com.kanban.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.register(user.getUsername(), user.getPassword(), user.getNickname());
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        // 단순화를 위해 성공 시 username 반환 (실제로는 JWT 토큰 생성 로직 필요)
        User found = userService.findByUsername(user.getUsername());
        return "Login successful for: " + found.getUsername();
    }
}

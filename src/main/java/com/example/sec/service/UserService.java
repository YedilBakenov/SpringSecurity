package com.example.sec.service;

import com.example.sec.model.Permission;
import com.example.sec.model.User;
import com.example.sec.repository.PermissionRepository;
import com.example.sec.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final PermissionRepository permissionRepository;

    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (User) authentication.getPrincipal();
    }

    public String addUser(User newUser, String rePassword) {
        User user = userRepository.findByEmail(newUser.getEmail());
        if (user != null) {
            return "errorEmail";
        }

        if (user != null || !newUser.getPassword().equals(rePassword)) {
            return "errorPassword";
        }

        newUser.setPassword(passwordEncoder.encode(rePassword));

        Permission role = permissionRepository.getStandartPermission();

        newUser.setPermissions(List.of(role));

        userRepository.save(newUser);

        return "success";
    }

    public String changePassword(String currentPassword, String newPassword, String reNewPassword) {
        if(!passwordEncoder.matches(currentPassword, getCurrentUser().getPassword())){
            return "errorCurrentPassword";
        }

        if(!newPassword.equals(reNewPassword)){
            return "errorNewPassword";
        }

        getCurrentUser().setPassword(passwordEncoder.encode(newPassword));

        userRepository.save(getCurrentUser());

        return "success";
    }
}

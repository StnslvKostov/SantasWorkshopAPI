package com.swapi.exam.service;

import com.swapi.exam.model.DTO.UserDTO;
import com.swapi.exam.model.User;
import com.swapi.exam.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;

    public User register(UserDTO dto) {
        if (userRepository.existsByUsername(dto.getUsername())) {
            throw new RuntimeException("Username already exists");
        }
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setRole("ROLE_USER");
        user.setEnabled(true);
        return userRepository.save(user);
    }

    public void login(UserDTO dto) { //Пробвам с войд вместо да връща User, както e при register. Не знам кое е по-добре.
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                dto.getUsername(),
                dto.getPassword()
        );

        authenticationManager.authenticate(authentication);
        // ако е грешна паролата → Exception
    }
}

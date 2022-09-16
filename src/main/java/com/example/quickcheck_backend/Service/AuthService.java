package com.example.quickcheck_backend.Service;

import com.example.quickcheck_backend.Model.User;
import com.example.quickcheck_backend.Repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthRepository authRepository;
    public void register(User user) {
        String hashedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(hashedPassword);
        authRepository.save(user);
    }

}

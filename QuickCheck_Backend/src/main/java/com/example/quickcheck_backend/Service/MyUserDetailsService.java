package com.example.quickcheck_backend.Service;


import com.example.quickcheck_backend.Model.User;
import com.example.quickcheck_backend.Repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

    private final AuthRepository authRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userr=authRepository.findUsersByUserName(username);

        if(userr==null){
            throw new UsernameNotFoundException("Invalid username or password");
        }
          return userr;

    }
}

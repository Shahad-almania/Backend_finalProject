package com.example.quickcheck_backend.Repository;

import com.example.quickcheck_backend.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository  extends JpaRepository<User,Integer> {
    User findUsersByUserName(String username);

}

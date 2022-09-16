package com.example.quickcheck_backend.Repository;

import com.example.quickcheck_backend.Model.Email;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmailRepository extends JpaRepository<Email,Integer> {

    List<Email> findByUserId(Integer id);

}

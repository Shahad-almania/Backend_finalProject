package com.example.quickcheck_backend.Repository;

import com.example.quickcheck_backend.Model.URL;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface URLRepository extends JpaRepository<URL,Integer> {

     List<URL> findByUserId(Integer id);
}

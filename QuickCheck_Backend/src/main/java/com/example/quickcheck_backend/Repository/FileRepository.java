package com.example.quickcheck_backend.Repository;

import com.example.quickcheck_backend.Model.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface FileRepository extends JpaRepository<File,Integer> {

    List<File> findByUserId(Integer id);
}

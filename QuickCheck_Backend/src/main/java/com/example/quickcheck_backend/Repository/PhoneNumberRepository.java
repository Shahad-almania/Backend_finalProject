package com.example.quickcheck_backend.Repository;

import com.example.quickcheck_backend.Model.PhoneNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhoneNumberRepository extends JpaRepository<PhoneNumber,Integer> {

    List<PhoneNumber> findByUserId(Integer id);

}

package com.example.quickcheck_backend.Service;

import com.example.quickcheck_backend.Model.PhoneNumber;
import com.example.quickcheck_backend.Model.User;
import com.example.quickcheck_backend.Repository.PhoneNumberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PhoneNumberService {

    private final PhoneNumberRepository phoneNumberRepository;

    public List<PhoneNumber> getPhoneNumber(User user){
        return phoneNumberRepository.findByUserId(user.getId());
    }

    public void addPhoneNumber(PhoneNumber phoneNumber, User user){
        phoneNumber.setUserId(user.getId());
        phoneNumberRepository.save(phoneNumber);
    }

    public void updatePhoneNumber(PhoneNumber phoneNumber,Integer id){
        PhoneNumber num=phoneNumberRepository.getById(id);
        num.setNumber(phoneNumber.getNumber());
        num.setResponse(phoneNumber.getResponse());
        num.setUserId(phoneNumber.getUserId());

        phoneNumberRepository.save(num);
    }

    public void deletePhoneNumber(Integer id){
       PhoneNumber numberr=phoneNumberRepository.getById(id);
       phoneNumberRepository.delete(numberr);
    }
}

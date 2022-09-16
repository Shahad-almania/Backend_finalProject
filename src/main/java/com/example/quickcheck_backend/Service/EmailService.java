package com.example.quickcheck_backend.Service;

import com.example.quickcheck_backend.Model.Email;
import com.example.quickcheck_backend.Model.User;
import com.example.quickcheck_backend.Repository.EmailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final EmailRepository emailRepository;

    public List<Email> getEmail(User user){
        return emailRepository.findByUserId(user.getId());
    }

       public void addEmail(Email email, User user){
        email.setUserId(user.getId());
        emailRepository.save(email);
       }

          public  void updateEmail(Email email, Integer id){
          Email email1= emailRepository.getById(id);
          email1.setEmailAdress(email.getEmailAdress());
          email1.setDomain(email.getDomain());
          email1.setWebmail(email.isWebmail());
          email1.setSpam(email.isSpam());
          email1.setUserId(email.getUserId());

          emailRepository.save(email1);
          }

          public void deleteEmail(Integer id){
              Email emaill= emailRepository.getById(id);
              emailRepository.delete(emaill);

          }

}

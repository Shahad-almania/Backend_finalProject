package com.example.quickcheck_backend.Service;

import com.example.quickcheck_backend.Model.URL;
import com.example.quickcheck_backend.Model.User;
import com.example.quickcheck_backend.Repository.URLRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class URLService {
    private final URLRepository urlRepository;

    public List<URL> getURL(User user){
        return urlRepository.findByUserId(user.getId());
    }

    public void addURL(URL url, User user){
        url.setUserId(user.getId());
        urlRepository.save(url);
    }

    public void updateURL(URL url,Integer id){
       URL url11=urlRepository.getById(id);
          url11.setUrl(url.getUrl());
          url11.setName(url.getName());
          url11.setDetected(url.getDetected());
          url11.setResult(url.getResult());
          url11.setUserId(url.getUserId());
          urlRepository.save(url11);
   }

    public void deleteURL (Integer id){
        URL url2=urlRepository.getById(id);
        urlRepository.delete(url2);
    }
}


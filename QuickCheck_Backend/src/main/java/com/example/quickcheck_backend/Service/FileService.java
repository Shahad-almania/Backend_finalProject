package com.example.quickcheck_backend.Service;

import com.example.quickcheck_backend.Model.File;
import com.example.quickcheck_backend.Model.User;
import com.example.quickcheck_backend.Repository.FileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FileService {
    private final FileRepository fileRepository;
    public List<File> getFile(User user){
        return fileRepository.findByUserId(user.getId());
    }
      public void addFile(File file,User user) {
        file.setUserId(user.getId());
        fileRepository.save(file);
      }
   public void updateFile(File file,Integer id){
          File file1= fileRepository.getById(id);
          file1.setName(file.getName());
          file1.setDeleted(file.getDeleted());
          file1.setResult(file.getResult());
          file1.setUserId(file.getUserId());
          fileRepository.save(file1);
   }
    public void deleteFile (Integer id){
        File file2=fileRepository.getById(id);
        fileRepository.delete(file2);
    }
}

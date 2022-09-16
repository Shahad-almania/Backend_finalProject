package com.example.quickcheck_backend.Controller;

import com.example.quickcheck_backend.DTO.ApiResponse;
import com.example.quickcheck_backend.Model.File;
import com.example.quickcheck_backend.Model.User;
import com.example.quickcheck_backend.Service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/file")
public class FileController {

    private final FileService fileService;

    @GetMapping
    public ResponseEntity getFile(@AuthenticationPrincipal User user){
        return ResponseEntity.status(200).body(fileService.getFile(user));

    }

    @PostMapping
    public ResponseEntity addFile(@RequestBody @Valid File file, @AuthenticationPrincipal User user ){
        fileService.addFile(file,user);
        return ResponseEntity.status(201).body(new ApiResponse("New File added..",201));

    }

    @PutMapping("/{id}")
    public ResponseEntity updateFile(@RequestBody @Valid File file, @PathVariable Integer id , @AuthenticationPrincipal User user){
        fileService.updateFile(file,id);
        return ResponseEntity.status(201).body(new ApiResponse("Update the File..",201));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteFile(@PathVariable Integer id, @AuthenticationPrincipal User user){
        fileService.deleteFile(id);
        return ResponseEntity.status(201).body(new ApiResponse("Delete the File..",201));
    }
}

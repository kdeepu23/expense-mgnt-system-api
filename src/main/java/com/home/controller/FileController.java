package com.home.controller;

import com.home.services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("file")
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping("/upload")
    public String uploadFile(@RequestBody MultipartFile fileToUpload) throws IOException {
        return fileService.fileUpload(fileToUpload);
    }

    @PostMapping("/getBuckets")
    public List<String> getBuckets() {
        return fileService.getBuckets();
    }

    @PostMapping("/deleteAll")
    public String deleteAll() {
        return fileService.deleteAll();
    }
}

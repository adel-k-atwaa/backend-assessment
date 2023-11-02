package com.example.SystemDesign.Service;

import com.example.SystemDesign.Domain.File;
import com.example.SystemDesign.Repository.FileRepository;
import com.example.SystemDesign.Service.DTO.FileDTO;
import com.example.SystemDesign.Service.Mapper.FileMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FileService {
    private final FileRepository fileRepository;
    private final FileMapper fileMapper;
    public FileService(FileRepository fileRepository,FileMapper fileMapper) {
        this.fileRepository = fileRepository;
        this.fileMapper=fileMapper;
    }

    public FileDTO save(FileDTO fileDTO){
        File file = fileMapper.toEntty(fileDTO);
        return fileMapper.toDto(fileRepository.save(file));
    }
    public FileDTO save(File file){
        return fileMapper.toDto(fileRepository.save(file));
    }
}

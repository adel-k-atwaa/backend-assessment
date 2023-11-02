package com.example.SystemDesign.web.rest;

import com.example.SystemDesign.Domain.File;
import com.example.SystemDesign.Domain.Item;
import com.example.SystemDesign.Repository.ItemRepository;
import com.example.SystemDesign.Service.DTO.FileDTO;
import com.example.SystemDesign.Service.DTO.FileItemDTO;
import com.example.SystemDesign.Service.DTO.ItemDTO;
import com.example.SystemDesign.Service.FileService;
import com.example.SystemDesign.Service.ItemService;
import com.example.SystemDesign.Service.Mapper.ItemMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/item/file")
public class FileItemResource {


    private final ItemService itemService;
    private final FileService fileService;

    public FileItemResource(ItemService itemService, FileService fileService) {
        this.itemService = itemService;
        this.fileService = fileService;
    }

    @PostMapping
    public ResponseEntity<ItemDTO> create(FileItemDTO fileItemDTO){
        ItemDTO itemDTO = itemService.save(fileItemDTO);
        File file = itemDTO.getFile();
//        Item item=fileDTO.getItem();

//        item.setId(itemDTO.getId());
//        fileDTO.setItem(item);
//        fileService.save(itemDTO.getFile());
//        itemDTO =itemService.findById(itemDTO.getId()).get();
        return ResponseEntity.ok(itemDTO);
    }

    @GetMapping("{id}")
    public ResponseEntity<ItemDTO> download(@PathVariable("id") Long id){
        return ResponseEntity.ok(null);
    }

}

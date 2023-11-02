package com.example.SystemDesign.web.rest;


import com.example.SystemDesign.Repository.ItemRepository;
import com.example.SystemDesign.Service.DTO.FolderItemDTO;
import com.example.SystemDesign.Service.DTO.ItemDTO;
import com.example.SystemDesign.Service.ItemService;
import com.example.SystemDesign.Service.Mapper.ItemMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/item/folder")
public class FolderItemResource {

    private final ItemService itemService;
    public FolderItemResource( ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public ResponseEntity<ItemDTO> create(@RequestBody FolderItemDTO folderItemDTO){
//        System.err.println(folderItemDTO);
        ItemDTO itemDTO = itemService.save(folderItemDTO);
        return ResponseEntity.ok(itemDTO);
    }
}

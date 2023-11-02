package com.example.SystemDesign.web.rest;

import com.example.SystemDesign.Service.DTO.ItemDTO;
import com.example.SystemDesign.Service.DTO.SpaceItemDTO;
import com.example.SystemDesign.Service.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/v1/item/space")
public class SpaceItemResource {
    private final ItemService itemService;

    public SpaceItemResource(ItemService itemService) {

        this.itemService = itemService;
    }

    @GetMapping
    public ResponseEntity<List<ItemDTO>> getAllSpace(){
        return ResponseEntity.ok(itemService.findAll());
    }

    @PostMapping
    public  ResponseEntity<ItemDTO> save(@RequestBody SpaceItemDTO spaceItemDTO){
        System.err.println(spaceItemDTO);
        ItemDTO itemDTO = itemService.save(spaceItemDTO);
        return ResponseEntity.ok(itemDTO);
    }

}

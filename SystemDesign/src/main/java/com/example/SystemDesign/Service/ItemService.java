package com.example.SystemDesign.Service;


import com.example.SystemDesign.Domain.Item;
import com.example.SystemDesign.Repository.ItemRepository;
import com.example.SystemDesign.Service.DTO.FileItemDTO;
import com.example.SystemDesign.Service.DTO.FolderItemDTO;
import com.example.SystemDesign.Service.DTO.ItemDTO;
import com.example.SystemDesign.Service.DTO.SpaceItemDTO;
import com.example.SystemDesign.Service.Mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ItemService {

    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    @Autowired
    public ItemService(ItemRepository itemRepository,ItemMapper itemMapper) {
        this.itemRepository = itemRepository;
        this.itemMapper=itemMapper;
    }

    public ItemDTO save(ItemDTO itemDTO){
        Item item =itemMapper.toEntty(itemDTO);
        item=itemRepository.save(item);
        return itemMapper.toDto(item);
    }

    public ItemDTO save(FolderItemDTO itemDTO){
        Item item =itemMapper.toEntty(itemDTO);
        item.setParent(item.getParent());
        System.err.println(item);
        item=itemRepository.save(item);
        return itemMapper.toDto(item);
    }

    public ItemDTO save(SpaceItemDTO itemDTO){
        Item item =itemMapper.toEntty(itemDTO);
        item=itemRepository.save(item);
        return itemMapper.toDto(item);
    }

    public ItemDTO save(FileItemDTO itemDTO){
        Item item =itemMapper.toEntty(itemDTO);
        item=itemRepository.save(item);
        return itemMapper.toDto(item);
    }


    @Transactional(readOnly = true)
    public List<ItemDTO> findAll() {
        return itemMapper.toDto(itemRepository.findAll());
    }

    @Transactional(readOnly = true)
    public Optional<ItemDTO> findById(Long id){
        return itemMapper.toDto(itemRepository.findById(id));
    }
}

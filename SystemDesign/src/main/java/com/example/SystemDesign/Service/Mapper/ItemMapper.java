package com.example.SystemDesign.Service.Mapper;

import com.example.SystemDesign.Domain.File;
import com.example.SystemDesign.Domain.Item;
import com.example.SystemDesign.Service.DTO.*;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Optional;

@Mapper(componentModel = "spring", uses = {})
public interface ItemMapper extends EntityMapper<ItemDTO, Item> {
    @Named("id")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "parent", source = "parent")
    ItemDTO toDtoId(Item item);

    @Override
    default Optional<Item> toEntity(Optional<ItemDTO> dto) {
        return dto.map(this::toEntty);
    }

    @Override
    default Optional<ItemDTO> toDto(Optional<Item> entity) {
        return entity.map(this::toDto);
    }

    Item toEntity(FolderItemDTO dto);

    Item toEntity(SpaceItemDTO dto);

    Item toEntity(FileItemDTO dto);
}

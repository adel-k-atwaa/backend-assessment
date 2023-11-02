package com.example.SystemDesign.Service.Mapper;

import com.example.SystemDesign.Domain.File;
import com.example.SystemDesign.Service.DTO.FileDTO;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Optional;

@Mapper(componentModel = "spring", uses = {})
public interface FileMapper extends EntityMapper<FileDTO, File>{
    @Named("fileId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "fileId", source = "fileId")
    FileDTO toDtoId(File File);

    @Override
    default Optional<File> toEntity(Optional<FileDTO> dto) {
        return dto.map(this::toEntty);
    }

    @Override
    default Optional<FileDTO> toDto(Optional<File> entity) {
        return entity.map(this::toDto);
    }
}

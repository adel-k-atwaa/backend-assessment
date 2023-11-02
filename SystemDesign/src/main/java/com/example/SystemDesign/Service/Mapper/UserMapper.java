package com.example.SystemDesign.Service.Mapper;

import com.example.SystemDesign.Domain.File;
import com.example.SystemDesign.Domain.User;
import com.example.SystemDesign.Service.DTO.FileDTO;
import com.example.SystemDesign.Service.DTO.UserDTO;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Optional;

@Mapper(componentModel = "spring", uses = {})
public interface UserMapper extends EntityMapper<UserDTO, User> {
    @Named("id")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    UserDTO toDtoId(User user);

    @Override
    default Optional<User> toEntity(Optional<UserDTO> dto) {
        return dto.map(this::toEntty);
    }

    @Override
    default Optional<UserDTO> toDto(Optional<User> entity) {
        return entity.map(this::toDto);
    }
}

package com.example.SystemDesign.Service.Mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;
import java.util.Optional;

public interface EntityMapper<D,E> {
    E toEntty(D dto);

    D toDto(E entity);

    Optional<D> toDto(Optional<E> entity);

    Optional<E> toEntity(Optional<D> dto);

    List<E> toEntity(List<D> dtoList);

    List<D> toDto(List<E> entityList);

    @Named("partialUpdate")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void partialUpdate(@MappingTarget E entity, D dto);
}

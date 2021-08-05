package com.gs3.avaliacao.junior.gs3backend.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.IterableMapping;

import java.util.List;

public interface AbstractMapper<E, T> {

    E toEntity(T dto);

    @InheritInverseConfiguration
    T toDTO(E entity);

    @IterableMapping(qualifiedByName = "toDto")
    List<E> toEntityList(List<T> dtos);

    @IterableMapping(qualifiedByName = "toEntity")
    List<T> toDtoList(List<E> entities);


}

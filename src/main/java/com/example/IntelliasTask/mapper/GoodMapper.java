package com.example.IntelliasTask.mapper;

import com.example.IntelliasTask.dto.GoodDto;
import com.example.IntelliasTask.model.Good;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

/**
 * This class is mapper for class Good and GoodDto
 */
@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = IGNORE,
        implementationPackage = "com.example.IntelliasTask.mapper.impl"
)
public abstract class GoodMapper {

    /**
     * This method convert your entity in DTO
     *
     * @param good entity
     * @return DTO
     */
    public abstract GoodDto toDto(Good good);

    /**
     * This method convert your DTO in entity
     *
     * @param goodDto DTO
     * @return entity
     */
    public abstract Good toEntity(GoodDto goodDto);

    /**
     * This method update fields your entity
     *
     * @param goodDto DTO class with new fields
     * @param good    entity which you want update
     */
    public abstract void updateProperties(GoodDto goodDto, @MappingTarget Good good);

}

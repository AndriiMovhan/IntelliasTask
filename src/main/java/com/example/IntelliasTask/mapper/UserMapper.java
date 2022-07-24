package com.example.IntelliasTask.mapper;

import com.example.IntelliasTask.dto.UserDto;
import com.example.IntelliasTask.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

/**
 * This class is mapper for class User and UserDto
 */
@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = IGNORE,
        implementationPackage = "com.example.IntelliasTask.mapper.impl"
)
public abstract class UserMapper {

    /**
     * This method convert your entity in DTO
     *
     * @param user entity
     * @return DTO
     */
    public abstract UserDto toDto(User user);

    /**
     * This method convert your DTO in entity
     *
     * @param userDto DTO
     * @return entity
     */
    public abstract User toEntity(UserDto userDto);

    /**
     * This method update fields your entity
     *
     * @param userDto DTO class with new fields
     * @param user    entity which you want update
     */
    public abstract void updateProperties(UserDto userDto, @MappingTarget User user);
}

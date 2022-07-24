package com.example.IntelliasTask.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * This class it's DTO for entity User
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Integer id;
    private @NotBlank String firstName;
    private @NotBlank String lastName;
    private @NotNull Integer amountOfMoney;
}

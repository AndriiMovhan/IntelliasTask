package com.example.IntelliasTask.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * This class it's DTO for entity Good
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GoodDto {

    private Integer id;
    private @NotBlank String name;
    private @NotNull Integer price;
}

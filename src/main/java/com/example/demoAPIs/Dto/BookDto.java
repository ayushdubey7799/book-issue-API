package com.example.demoAPIs.Dto;

import com.example.demoAPIs.model.UserEntity;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookDto {
    @NotNull
    private String name;
    @NotNull
    private String authorName;
    @NotNull
    private UserEntity user;
}

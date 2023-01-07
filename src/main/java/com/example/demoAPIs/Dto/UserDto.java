package com.example.demoAPIs.Dto;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {
    @NotNull
    private String name;

    @NotNull
    private String email;

    @NotNull
    private String phoneNo;
}

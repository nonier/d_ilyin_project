package com.example.film_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActorDto {

    private String firstName;
    private String secondName;
    private int age;
    private List<ActorRoleDto> actorRoles;
}

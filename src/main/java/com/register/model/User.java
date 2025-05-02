package com.register.model;

import jakarta.persistence.Id;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private byte age;
    private String telephone;
    private Address address;
}

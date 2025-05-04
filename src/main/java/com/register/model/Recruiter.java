package com.register.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recruiter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // Información privada
    private String firstName;
    private String lastName;
    private String email;
    private String telephone;

    // Información compañia
    private String companyName;
    private String companyWebsite;
    private String companyLogoUrl;
    private String positionTitle;

    // Ubicación (opcional según el modelo)
    private String location;

    // Perfil profesional
    @Column(length = 1000)
    private String bio; // Descripción corta sobre el reclutador

    // Fechas
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Otros posibles campos
    private boolean verified;
}

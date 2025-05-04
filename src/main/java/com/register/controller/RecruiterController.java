package com.register.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.register.repository.RecruiterRepository;
import com.register.model.Recruiter;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/recruiters")
@RequiredArgsConstructor
public class RecruiterController {

    private final RecruiterRepository recruiterRepository;

    // Obtener todos los reclutadores
    @GetMapping
    public List<Recruiter> getAllRecruiters() {
        return recruiterRepository.findAll();
    }

    // Obtener reclutador por ID
    @GetMapping("/{id}")
    public ResponseEntity<Recruiter> getRecruiterById(@PathVariable Long id) {
        Optional<Recruiter> recruiter = recruiterRepository.findById(id);
        return recruiter.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Crear nuevo reclutador
    @PostMapping
    public Recruiter createRecruiter(@RequestBody Recruiter recruiter) {
        return recruiterRepository.save(recruiter);
    }

    // Actualizar reclutador
    @PutMapping("/{id}")
    public ResponseEntity<Recruiter> updateRecruiter(@PathVariable Long id, @RequestBody Recruiter updatedData) {
        return recruiterRepository.findById(id).map(recruiter -> {
            recruiter.setFirstName(updatedData.getFirstName());
            recruiter.setLastName(updatedData.getLastName());
            recruiter.setEmail(updatedData.getEmail());
            recruiter.setTelephone(updatedData.getTelephone());
            recruiter.setCompanyName(updatedData.getCompanyName());
            recruiter.setCompanyWebsite(updatedData.getCompanyWebsite());
            recruiter.setPositionTitle(updatedData.getPositionTitle());
            recruiter.setBio(updatedData.getBio());
            recruiter.setLocation(updatedData.getLocation());
            return ResponseEntity.ok(recruiterRepository.save(recruiter));
        }).orElse(ResponseEntity.notFound().build());
    }

    // Eliminar reclutador
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecruiter(@PathVariable Long id) {
        if (recruiterRepository.existsById(id)) {
            recruiterRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

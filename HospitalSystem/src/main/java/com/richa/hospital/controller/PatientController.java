package com.richa.hospital.controller;

import com.richa.hospital.entity.Patient;
import com.richa.hospital.exceptions.ResourceNotFoundException;
import com.richa.hospital.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    PatientRepository patientRepository;

    @GetMapping("/health")
    public String getHealth()
    {
        return "Service is up";
    }

    @PostMapping
    public boolean bookAppointement(@RequestBody Patient patient)
    {
        try
        {
            String id=UUID.randomUUID().toString();
            patient.setPatientId(id);
            patientRepository.save(patient);
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping
    public ResponseEntity<List<Patient>> getAllPatients()
    {
        return ResponseEntity.status(HttpStatus.FOUND).body(patientRepository.findAll());
    }


    @GetMapping("{id}")
    public Patient getPatientById(@PathVariable String id)
    {
        return patientRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Patient not found with id "+id));
    }

    @DeleteMapping("{id}")
    public String deletePatientById(@PathVariable String id){
        patientRepository.deleteById(id);
        return "Successfully deleted patient with id : "+id;
    }




}

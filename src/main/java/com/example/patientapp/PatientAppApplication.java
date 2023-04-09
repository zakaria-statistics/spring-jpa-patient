package com.example.patientapp;

import com.example.patientapp.entities.Patient;
import com.example.patientapp.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class PatientAppApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(PatientAppApplication.class, args);
    }

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public void run(String... args) throws Exception {

        // Create a new patient
        Patient patient = new Patient();
        patient.setNom("John");
        patient.setScore(10);
        patientRepository.save(patient);
        System.out.println("New patient created: " + patient.toString());

        // Update the patient's score
        patientRepository.updatePatientScoreById(patient.getId(), 20);
        patient = patientRepository.findById(patient.getId()).orElse(null);
        System.out.println("Patient after score update: " + patient.toString());

        // Delete the patient
        patientRepository.deletePatientById(patient.getId());
        System.out.println("Patient deleted: " + patient.toString());

    }

}

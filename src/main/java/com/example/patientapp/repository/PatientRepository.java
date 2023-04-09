package com.example.patientapp.repository;

import com.example.patientapp.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface PatientRepository extends JpaRepository<Patient, Long> {

   @Transactional
   @Modifying
   @Query("UPDATE Patient p SET p.score = :score WHERE p.id = :id")
   void updatePatientScoreById(@Param("id") Long id, @Param("score") int score);

   void deletePatientById(Long id);

}

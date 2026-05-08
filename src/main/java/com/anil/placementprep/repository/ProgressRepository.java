package com.anil.placementprep.repository;

import com.anil.placementprep.entity.Progress;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProgressRepository extends JpaRepository<Progress, Long> {

    List<Progress> findByUserEmail(String userEmail);

    long countByStatus(String status);
}
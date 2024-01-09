package com.spring.henallux.firstSpringProject.dataAccess.repository;

import com.spring.henallux.firstSpringProject.dataAccess.entity.ReductionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReductionRepository extends JpaRepository<ReductionEntity, Integer> {
}

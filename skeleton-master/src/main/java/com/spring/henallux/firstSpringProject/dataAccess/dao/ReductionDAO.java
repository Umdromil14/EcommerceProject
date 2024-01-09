package com.spring.henallux.firstSpringProject.dataAccess.dao;

import com.spring.henallux.firstSpringProject.dataAccess.repository.ReductionRepository;
import com.spring.henallux.firstSpringProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.firstSpringProject.model.Reduction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReductionDAO implements ReductionDataAccess{

    private ReductionRepository reductionRepository;

    private ProviderConverter providerConverter;

    @Autowired
    public ReductionDAO(ReductionRepository reductionRepository, ProviderConverter providerConverter){
        this.reductionRepository = reductionRepository;
        this.providerConverter = providerConverter;
    }

    public void insertReduction(Reduction reduction){
        reductionRepository.save(providerConverter.reductionModelToReductionEntity(reduction));
    }
}

package com.spring.henallux.firstSpringProject.services;

import com.spring.henallux.firstSpringProject.dataAccess.dao.ReductionDataAccess;
import com.spring.henallux.firstSpringProject.model.Reduction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReductionServices {

    private ReductionDataAccess reductionDAO;

    @Autowired
    public ReductionServices(ReductionDataAccess reductionDAO){
        this.reductionDAO = reductionDAO;
    }

    public void insertReduction(Reduction reduction){
        reductionDAO.insertReduction(reduction);
    }
}

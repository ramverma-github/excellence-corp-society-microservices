package com.excellence.society.corp.serviesimpl;

import com.excellence.society.corp.domain.Contributor;
import com.excellence.society.corp.repositories.ContributorRepository;
import com.excellence.society.corp.services.ContributorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContributorServiceImpl implements ContributorService {

    @Autowired
    private ContributorRepository contributorRepository;

    @Override
    public Boolean registerContributor(Contributor contributorUser) {
        Contributor isRegistered = contributorRepository.save(contributorUser);
        if (isRegistered.getId() >= 1) {
            return true;
        }
        return false;
    }

    @Override
    public List<Contributor> getContributorList() {
        return contributorRepository.findAll();
    }

}

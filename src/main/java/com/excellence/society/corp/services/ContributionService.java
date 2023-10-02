package com.excellence.society.corp.services;

import com.excellence.society.corp.domain.Contribution;

import java.util.List;
import java.util.Optional;

public interface ContributionService {
    List<Contribution> getContributionList();
    public boolean addContribution(Contribution contribution);
    public Optional<Contribution> getContributionById(Integer id);
    public void deleteContributionById(Integer id);
    public Contribution updateContributionById(Contribution contribution);
}

package com.excellence.society.corp.serviesimpl;

import com.excellence.society.corp.domain.Contribution;
import com.excellence.society.corp.repositories.ContributionRepository;
import com.excellence.society.corp.services.ContributionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContributionServiceImpl implements ContributionService {

    @Autowired
    private ContributionRepository contributionRepository;
    @Override
    public List<Contribution> getContributionList() {
        return getContributions();
    }

    @Override
    public boolean addContribution(Contribution contribution) {
        Contribution isAdded = contributionRepository.save(contribution);
        if(isAdded.getId()>=1){
            return true;
        }
        return false;
    }

    @Override
    public Optional<Contribution> getContributionById(Integer id) {
        return contributionRepository.findById(id);
    }

    @Override
    public void deleteContributionById(Integer id) {
        contributionRepository.deleteById(id);
    }

    @Override
    public Contribution updateContributionById(Contribution contribution) {
        if(null != contribution){
            Optional<Contribution> current = contributionRepository.findById(contribution.getId());
            if(current.isPresent()){
                Contribution result = current.get();
                result.setAmount(contribution.getAmount());
                result.setContributor(contribution.getContributor());
             return contributionRepository.save(result);
            }
        }
        return null;
    }
    private List<Contribution> getContributions() {
        return contributionRepository.findAll();
    }

}

package com.excellence.society.corp.controlller;

import com.excellence.society.corp.domain.Contribution;
import com.excellence.society.corp.services.ContributionService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ContributionController {

    @Autowired
    private ContributionService contributionService;

    @Autowired
    private Gson gson;

    @PostMapping("/contribution/add")
    public boolean addContribution(@RequestBody String contributionData){
        return contributionService.addContribution(gson.fromJson(contributionData, Contribution.class));
    }

    @GetMapping("/contributions")
    public List<Contribution> getContributionAmount(){
        return contributionService.getContributionList();
    }

    @GetMapping("/contributions/{id}")
    public Optional<Contribution> getContributionById(@PathVariable Integer id){
        ResponseEntity<Contribution> responseEntity =  new RestTemplate()
                .getForEntity("http://localhost:8082/api/contributions", Contribution.class);
        Contribution contribution = responseEntity.getBody();
        System.out.println("Response Entity: "+contribution.toString());
       return contributionService.getContributionById(id);
    }

    @DeleteMapping("/contributions/{id}")
    public String deleteContributionById(@PathVariable Integer id){
        contributionService.deleteContributionById(id);
        return "Record deleted!!";
    }
    @PutMapping("/contributions/update")
    public Contribution updateContributionById(@RequestBody String contribution){
       return contributionService.updateContributionById(gson.fromJson(contribution, Contribution.class));
    }

}

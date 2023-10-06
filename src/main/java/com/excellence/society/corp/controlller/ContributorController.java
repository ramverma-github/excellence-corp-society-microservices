package com.excellence.society.corp.controlller;

import com.excellence.society.corp.domain.Contributor;
import com.excellence.society.corp.services.ContributorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ContributorController {

    @Autowired
    private ContributorService contributorService;

    @PostMapping("/contributor/register")
    public String registerContributor(@RequestBody Contributor contributor){
        Boolean result = contributorService.registerContributor(contributor);
        return "Registered Successfully : "+result;
    }

    @GetMapping("/contributors")
    public List<Contributor> contributorList(){
        List<Contributor> result = contributorService.getContributorList();
        return result;
    }
}

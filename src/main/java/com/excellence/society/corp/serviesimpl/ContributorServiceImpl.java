package com.excellence.society.corp.serviesimpl;

import com.excellence.society.corp.domain.Contributor;
import com.excellence.society.corp.services.ContributorService;
import org.springframework.stereotype.Service;

@Service
public class ContributorServiceImpl implements ContributorService {
    @Override
    public String registerContributor(Contributor user) {
        //Dao Layer need to add here to store these data into DB!
        return "Success";
    }

}

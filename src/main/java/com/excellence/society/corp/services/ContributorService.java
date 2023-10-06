package com.excellence.society.corp.services;

import com.excellence.society.corp.domain.Contributor;

import java.util.List;

public interface ContributorService {
    public Boolean registerContributor(Contributor user);
    public List<Contributor> getContributorList();
}

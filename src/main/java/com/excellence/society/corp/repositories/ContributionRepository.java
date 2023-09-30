package com.excellence.society.corp.repositories;

import com.excellence.society.corp.domain.Contribution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContributionRepository extends JpaRepository<Contribution, Integer> {
}

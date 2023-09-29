package com.excellence.society.corp.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name="CONTRIBUTION")
public class Contribution {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private Double amount;
    @OneToOne(cascade = CascadeType.ALL, targetEntity = Contributor.class)
    @JoinColumn(name = "contributor_id", referencedColumnName = "id")
    private Contributor contributor;

}

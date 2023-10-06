package com.excellence.society.corp.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Contributor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String fullName;
    @DateTimeFormat(pattern = "DD-MM-YYYY")
    private String dateOfBirth;
    private String gender;
    private String emailId;
    private Long mobileNumber;
    private String profession;
    private String address;
    private String city;
    private String state;
    private String country;
    private String pin;
    private String idProof;
    private Long idProofNumber;
    private String nomineeName;
    private String nomineeIdProof;
    private Long nomineeIdProofNumber;
}
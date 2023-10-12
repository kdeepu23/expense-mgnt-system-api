package com.home.dto;

import lombok.*;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

@Entity
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long expId;

    @Column
    private String expCategory;

    @Column
    private Date expDate;

    @Column
    private Double expAmount;

    @Column
    private String expBy;

    @Column
    private String expDescription;

}

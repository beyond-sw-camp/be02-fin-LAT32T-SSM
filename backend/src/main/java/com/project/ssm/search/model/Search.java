package com.project.ssm.search.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Search {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long searchIdx;
    private String memberId;
    private String memberName;
}

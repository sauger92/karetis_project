package com.auger.karetisproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name="random_data")
@Entity
@Getter
@Setter
@AllArgsConstructor
public class RandomData {

    private int random1;
    private int random2;
    private int random3;
}

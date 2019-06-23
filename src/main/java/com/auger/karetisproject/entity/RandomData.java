package com.auger.karetisproject.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;

@Table(name="random_data")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class RandomData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private BigInteger random1;
    private BigInteger random2;
    private BigInteger random3;

    public  RandomData(BigInteger random1, BigInteger random2, BigInteger random3 ) {
        this.random1 = random1;
        this.random2 = random2;
        this.random3 = random3;
    }
}

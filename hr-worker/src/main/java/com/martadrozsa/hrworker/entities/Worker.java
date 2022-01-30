package com.martadrozsa.hrworker.entities;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;


@Entity
@Data
@Table(name = "tb_worker")
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double dailyIncome;
}

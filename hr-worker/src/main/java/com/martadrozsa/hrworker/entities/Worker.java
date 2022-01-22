package com.martadrozsa.hrworker.entities;

import lombok.Data;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Data
@Table(name = "tb_worker")
public class Worker implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double dailyIncome;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Worker worker = (Worker) o;
        return id != null && Objects.equals(id, worker.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

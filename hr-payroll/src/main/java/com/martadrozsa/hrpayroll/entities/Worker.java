package com.martadrozsa.hrpayroll.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Worker implements Serializable {


    private Long id;
    private String name;
    private Double dailyIncome;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Worker)) return false;

        Worker worker = (Worker) o;

        return getId().equals(worker.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}

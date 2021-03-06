package com.fantastik4.prisonsystemapplication.models;

import org.springframework.stereotype.Component;

@Component
public class Sector {
    private long id;
    private int Capacity;

    private int OccupiedCells;

    public Sector(long id, int capacity) {
        this.id = id;
        Capacity = capacity;
    }

    public Sector() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCapacity() {
        return Capacity;
    }

    public void setCapacity(int capacity) {
        Capacity = capacity;
    }

    @Override
    public String toString() {
        return "Sector{" +
                "id=" + id +
                ", Capacity=" + Capacity +
                '}';
    }
}

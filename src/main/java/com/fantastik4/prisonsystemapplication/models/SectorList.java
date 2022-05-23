package com.fantastik4.prisonsystemapplication.models;

import java.util.ArrayList;
import java.util.List;

public class SectorList {

    private List<Sector> sectors;

    public SectorList() {
        sectors = new ArrayList<>();
    }

    public SectorList(List<Sector> sectors) {
        this.sectors = sectors;
    }

    public List<Sector> getSectors() {
        return sectors;
    }
}

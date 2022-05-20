package com.fantastik4.prisonsystemapplication.models;

import java.util.ArrayList;
import java.util.List;

//inner list-wrapping class
public class PrisonersList{

    private List<Prisoner> prisoners;

    public PrisonersList(List<Prisoner> prisoners) {
        this.prisoners = prisoners;
    }

    public PrisonersList(){
        prisoners = new ArrayList<>();
    }

    public List<Prisoner> getPrisoners() {
        return prisoners;
    }
    public void setPrisoners(List<Prisoner> prisoners) {
        this.prisoners = prisoners;
    }
}
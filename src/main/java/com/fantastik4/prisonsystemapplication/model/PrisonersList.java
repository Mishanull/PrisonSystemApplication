package com.fantastik4.prisonsystemapplication.model;

import java.util.ArrayList;

//inner list-wrapping class
public class PrisonersList{

    private ArrayList<Prisoner> prisoners;

    public PrisonersList(ArrayList<Prisoner> prisoners) {
        this.prisoners = prisoners;
    }

    public PrisonersList(){
        prisoners = new ArrayList<>();
    }

    public ArrayList<Prisoner> getPrisoners() {
        return prisoners;
    }
    public void setPrisoners(ArrayList<Prisoner> prisoners) {
        this.prisoners = prisoners;
    }
}
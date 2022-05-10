package com.fantastik4.prisonsystemapplication.model;

import java.util.ArrayList;
import java.util.List;

public class GuardsList {

    private List<Guard> guards;

    public GuardsList(List<Guard> guards) {
        this.guards = guards;
    }

    public GuardsList() {
        guards = new ArrayList<Guard>();
    }

    public List<Guard> getGuards() {
        return guards;
    }

    public void setGuards(List<Guard> guards)
    {
        this.guards = guards;
    }
}

package com.example.waterpack;

import java.util.Vector;

public class Water_Calculator {
    private float waterToday;
    private Vector<Float> waterWeek;
    private float waterLastWeek;

    public Water_Calculator(float waterToday){
        this.waterToday = waterToday;
    }
    public Water_Calculator(float waterToday, Vector<Float> waterWeek, float waterLastWeek){
        this.waterToday = waterToday;
        this.waterLastWeek = waterLastWeek;
        this.waterWeek = waterWeek;
    }

}

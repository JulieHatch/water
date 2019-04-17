package com.example.waterpack;

public class User {

    // User class variables
    public String   username;
    protected char  gender;
    protected float waterPerDay;

    public User(String username, String gender, float weight, float height, float age) {
        this.username = username;
        this.gender = gender.charAt(0);
        this.setWaterPerDay(age, gender.charAt(0), weight, height);
    }

    // getters and setters

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public float getWaterPerDay() {
        return waterPerDay;
    }

    public void setWaterPerDay(float age, char gender, float weight, float height) {
        float wpd= 0;
        /*
        Because the source I used only needs gender currently for the calculation,
        and different research may lead to others wanting more variables to be added,
        which is why I made the possibility of a more intensive calculation of how much
        water a person may need.

        According to the mayo clinic this is how much males and females should drink a day
        Site: https://www.mayoclinic.org/healthy-lifestyle/nutrition-and-healthy-eating/in-depth/water/art-20044256
        */
        if(gender=='f') wpd = (float) 92;
        if(gender=='m') wpd = (float) 124;
        this.waterPerDay    = wpd;
    }
}

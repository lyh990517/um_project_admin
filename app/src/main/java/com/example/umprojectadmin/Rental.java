package com.example.umprojectadmin;

public class Rental {
    private String rent_name;
    private String rent_umb;
    private int rent_num;
    private String rent_state;
    private String rent_date;
    private String rent_time;

    public Rental(String rent_name, String rent_umb, int rent_num, String rent_state, String rent_date, String rent_time) {
        this.rent_name = rent_name;
        this.rent_umb = rent_umb;
        this.rent_num = rent_num;
        this.rent_state = rent_state;
        this.rent_date = rent_date;
        this.rent_time = rent_time;
    }

    public String getRent_name() {
        return rent_name;
    }

    public String getRent_umb() {
        return rent_umb;
    }

    public int getRent_num() {
        return rent_num;
    }

    public String getRent_state() {
        return rent_state;
    }

    public String getRent_date() {
        return rent_date;
    }

    public String getRent_time() {
        return rent_time;
    }

    public void setRent_name(String rent_name) {
        this.rent_name = rent_name;
    }

    public void setRent_umb(String rent_umb) {
        this.rent_umb = rent_umb;
    }

    public void setRent_num(int rent_num) {
        this.rent_num = rent_num;
    }

    public void setRent_state(String rent_state) {
        this.rent_state = rent_state;
    }

    public void setRent_date(String rent_date) {
        this.rent_date = rent_date;
    }

    public void setRent_time(String rent_time) {
        this.rent_time = rent_time;
    }

}

package com.mobileapps.week1day4_layouts_intents;

import java.io.Serializable;

public class Person implements Serializable {

    String FirstName;
    String LastName;
    String BirthDay;
    String BirthMonth;
    String BirthYear;

    public Person(
            String FirstName,
            String LastName,
            String BirthDay,
            String BirthMonth,
            String BirthYear){

        this.FirstName = FirstName;
        this.LastName = LastName;
        this.BirthDay = BirthDay;
        this.BirthMonth = BirthMonth;
        this.BirthYear = BirthYear;

    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getBirthDay() {
        return BirthDay;
    }

    public void setBirthDay(String birthDay) {
        BirthDay = birthDay;
    }

    public String getBirthMonth() {
        return BirthMonth;
    }

    public void setBirthMonth(String birthMonth) {
        BirthMonth = birthMonth;
    }

    public String getBirthYear() {
        return BirthYear;
    }

    public void setBirthYear(String birthYear) {
        BirthYear = birthYear;
    }
}

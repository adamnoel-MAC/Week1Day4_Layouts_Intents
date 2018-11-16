package com.mobileapps.week1day4_layouts_intents;

import android.os.Parcel;
import android.os.Parcelable;

public class Place implements Parcelable {

    private String StreetNumber;
    private String StreetName;
    private String City;
    private String State;
    private String Zip;

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(StreetNumber);
        dest.writeString(StreetName);
        dest.writeString(City);
        dest.writeString(State);
        dest.writeString(Zip);
    }

    private Place(Parcel in) {
        StreetNumber = in.readString();
        StreetName = in.readString();
        City = in.readString();
        State = in.readString();
        Zip = in.readString();
    }

    public Place(String streetNumber, String streetName, String city, String state, String zip) {
        this.StreetNumber = streetNumber;
        this.StreetName = streetName;
        this.City = city;
        this.State = state;
        this.Zip = zip;
    }

    public String getStreetNumber() {
        return StreetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        StreetNumber = streetNumber;
    }

    public String getStreetName() {
        return StreetName;
    }

    public void setStreetName(String streetName) {
        StreetName = streetName;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getZip() {
        return Zip;
    }

    public void setZip(String zip) {
        Zip = zip;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Place> CREATOR
            = new Creator<Place>() {

        @Override
        public Place createFromParcel(Parcel in) {
            return new Place(in);
        }

        @Override
        public Place[] newArray(int size) {
            return new Place[size];
        }
    };

}

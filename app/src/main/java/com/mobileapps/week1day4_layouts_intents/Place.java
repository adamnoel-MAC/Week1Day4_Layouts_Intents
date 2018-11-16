package com.mobileapps.week1day4_layouts_intents;

import android.os.Parcel;
import android.os.Parcelable;
public class Place implements Parcelable {

    String StreetNumber;
    String StreetName;
    String City;
    String State;
    String Zip;

    protected Place(Parcel in) {
        StreetNumber = in.readString();
        StreetName = in.readString();
        City = in.readString();
        State = in.readString();
        Zip = in.readString();
    }

    public static final Creator<Place> CREATOR = new Creator<Place>() {
        @Override
        public Place createFromParcel(Parcel in) {
            return new Place(in);
        }

        @Override
        public Place[] newArray(int size) {
            return new Place[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(StreetNumber);
        dest.writeString(StreetName);
        dest.writeString(City);
        dest.writeString(State);
        dest.writeString(Zip);
    }
}

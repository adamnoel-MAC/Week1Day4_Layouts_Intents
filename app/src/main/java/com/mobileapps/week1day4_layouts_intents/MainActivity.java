package com.mobileapps.week1day4_layouts_intents;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName() + "_TAG";

    private static final int PROFILE_ACTIVITY_REQUEST_CODE = 9;

    TextView tvFullName;
    TextView tvBirthDate;
    TextView tvStreetAddress;
    TextView tvCitySTZip;
    TextView tvPhoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: ");

        tvFullName = findViewById(R.id.tvFullName);
        tvBirthDate = findViewById(R.id.tvBirthDate);
        tvStreetAddress = findViewById(R.id.tvStreetAddress);
        tvCitySTZip = findViewById(R.id.tvCitySTZip);
        tvPhoneNumber = findViewById(R.id.tvPhoneNumber);

        Bundle extrasBundle = getIntent().getBundleExtra("bundle");
        if(extrasBundle != null) {

            String rFirstName = extrasBundle.getString("rFirstName");
            tvFullName.setText(rFirstName);
        }

    }

    public void onButtonClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.btnBeginUserProfile:
                intent = new Intent(this, UserProfile.class);
                startActivity(intent);
                break;
            case R.id.btnRetrieveUserProfile:
                intent = new Intent(this, UserProfile.class);
                startActivityForResult(intent, PROFILE_ACTIVITY_REQUEST_CODE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.d(TAG, "onActivityResult: ");

        if (requestCode == PROFILE_ACTIVITY_REQUEST_CODE) {
            if (resultCode == 1) {
                String rFirstName = data.getStringExtra("rFirstName");
                String rLastName = data.getStringExtra("rLastName");
                String rBirthDay = data.getStringExtra("rBirthDay");
                String rBirthMonth = data.getStringExtra("rBirthMonth");
                String rBirthYear = data.getStringExtra("rBirthYear");
                String rStreetNumber = data.getStringExtra("rStreetNumber");
                String rStreetName = data.getStringExtra("rStreetName");
                String rCity = data.getStringExtra("rCity");
                String rState = data.getStringExtra("rState");
                String rZip = data.getStringExtra("rZip");
                String rPhoneNumber = data.getStringExtra("rPhoneNumber");

                tvFullName.setText(rFirstName + " " + rLastName);
                tvBirthDate.setText(rBirthMonth + "/" + rBirthDay + "/" + rBirthYear);
                tvStreetAddress.setText(rStreetNumber + " " + rStreetName);
                tvCitySTZip.setText(rCity + ", " + rState + "  " + rZip);
                tvPhoneNumber.setText(rPhoneNumber);
            }
            else if (resultCode == 2){
                Serializable person = (Person) data.getSerializableExtra("person");
                String rFirstName = ((Person) person).FirstName;
                String rLastName = ((Person) person).LastName;
                String rBirthDay = ((Person) person).BirthDay;
                String rBirthMonth = ((Person) person).BirthMonth;
                String rBirthYear = ((Person) person).BirthYear;

                Place place = data.getParcelableExtra("place");
                String rStreetNumber = place.getStreetNumber();
                String rStreetName = place.getStreetName();
                String rCity = place.getCity();
                String rState = place.getState();
                String rZip = place.getZip();

                String rPhoneNumber = data.getStringExtra("rPhoneNumber");

                tvFullName.setText(rFirstName + " " + rLastName);
                tvBirthDate.setText(rBirthMonth + "/" + rBirthDay + "/" + rBirthYear);
                tvStreetAddress.setText(rStreetNumber + " " + rStreetName);
                tvCitySTZip.setText(rCity + ", " + rState + "  " + rZip);
                tvPhoneNumber.setText(rPhoneNumber);
            }
            else if (resultCode == 3){

                Bundle extrasBundle = data.getBundleExtra("bundle");

                Serializable person = (Person) extrasBundle.getSerializable("person");

                String rFirstName = ((Person) person).FirstName;
                String rLastName = ((Person) person).LastName;
                String rBirthDay = ((Person) person).BirthDay;
                String rBirthMonth = ((Person) person).BirthMonth;
                String rBirthYear = ((Person) person).BirthYear;

                Place place = extrasBundle.getParcelable("place");

                String rStreetNumber = place.getStreetNumber();
                String rStreetName = place.getStreetName();
                String rCity = place.getCity();
                String rState = place.getState();
                String rZip = place.getZip();

                String rPhoneNumber = extrasBundle.getString("rPhoneNumber");

                tvFullName.setText(rFirstName + " " + rLastName);
                tvBirthDate.setText(rBirthMonth + "/" + rBirthDay + "/" + rBirthYear);
                tvStreetAddress.setText(rStreetNumber + " " + rStreetName);
                tvCitySTZip.setText(rCity + ", " + rState + "  " + rZip);
                tvPhoneNumber.setText(rPhoneNumber);
            }
            if (resultCode == RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }
    }//onActivityResult

    //tvFullName.setText();
    /** Called when the user taps the Send button */
    //public void sendMessage(View view) {
    // Do something in response to button
    //}


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }
}


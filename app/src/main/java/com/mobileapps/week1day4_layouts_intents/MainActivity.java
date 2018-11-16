package com.mobileapps.week1day4_layouts_intents;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private static final int PROFILE_ACTIVITY_REQUEST_CODE = 0;

    TextView tvFullName;
    TextView tvBirthDate;
    TextView tvStreetAddress;
    TextView tvCitySTZip;
    TextView tvPhoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvFullName = findViewById(R.id.tvFullName);
        tvBirthDate = findViewById(R.id.tvBirthDate);
        tvStreetAddress = findViewById(R.id.tvStreetAddress);
        tvCitySTZip = findViewById(R.id.tvCitySTZip);
        tvPhoneNumber = findViewById(R.id.tvPhoneNumber);

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

        if (requestCode == PROFILE_ACTIVITY_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
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
}


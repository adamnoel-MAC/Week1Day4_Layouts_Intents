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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvFullName = findViewById(R.id.tvFullName);
        tvBirthDate = findViewById(R.id.tvBirthDate);
        tvStreetAddress = findViewById(R.id.tvStreetAddress);
        tvCitySTZip = findViewById(R.id.tvCitySTZip);

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

                tvFullName.setText(rFirstName);

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


package com.mobileapps.week1day4_layouts_intents;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class UserProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

    }
    public void onButtonClick(View view) {

        EditText etFirstName = findViewById(R.id.etFirstName);
        String rFirstName = etFirstName.getText().toString();

        EditText etLastName = findViewById(R.id.etLastName);
        String rLastName = etLastName.getText().toString();

        EditText etBirthMonth = findViewById(R.id.etBirthMonth);
        String rBirthMonth = etBirthMonth.getText().toString();

        EditText etBirthDay = findViewById(R.id.etBirthDay);
        String rBirthDay = etBirthDay.getText().toString();

        EditText etBirthYear = findViewById(R.id.etBirthYear);
        String rBirthYear = etBirthYear.getText().toString();

        EditText etStreetNumber = findViewById(R.id.etStreetNumber);
        String rStreetNumber = etStreetNumber.getText().toString();

        EditText etStreetName = findViewById(R.id.etStreetName);
        String rStreetName = etStreetName.getText().toString();

        EditText etCity = findViewById(R.id.etCity);
        String rCity = etCity.getText().toString();

        EditText etState = findViewById(R.id.etState);
        String rState = etState.getText().toString();

        EditText etZip = findViewById(R.id.etZip);
        String rZip = etZip.getText().toString();

        EditText etPhoneNumber = findViewById(R.id.etPhoneNumber);
        String rPhoneNumber = etPhoneNumber.getText().toString();

        Intent returnIntent = new Intent();

        returnIntent.putExtra("rFirstName",rFirstName);
        returnIntent.putExtra("rLastName",rLastName);
        returnIntent.putExtra("rBirthDay",rBirthDay);
        returnIntent.putExtra("rBirthMonth",rBirthMonth);
        returnIntent.putExtra("rBirthYear",rBirthYear);
        returnIntent.putExtra("rStreetNumber",rStreetNumber);
        returnIntent.putExtra("rStreetName",rStreetName);
        returnIntent.putExtra("rCity",rCity);
        returnIntent.putExtra("rState",rState);
        returnIntent.putExtra("rZip",rZip);
        returnIntent.putExtra("rPhoneNumber",rPhoneNumber);

        setResult(RESULT_OK,returnIntent);
        finish();
    }
}

package com.mobileapps.week1day4_layouts_intents;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class UserProfile extends AppCompatActivity {

    public static final String TAG = UserProfile.class.getSimpleName() + "_TAG";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        Log.d(TAG, "onCreate: ");
    }

    public void onButtonClick(View view) {

        Intent returnIntent = new Intent();

        EditText etFirstName = findViewById(R.id.etFirstName);
        EditText etLastName = findViewById(R.id.etLastName);
        EditText etBirthMonth = findViewById(R.id.etBirthMonth);
        EditText etBirthDay = findViewById(R.id.etBirthDay);
        EditText etBirthYear = findViewById(R.id.etBirthYear);
        EditText etStreetNumber = findViewById(R.id.etStreetNumber);
        EditText etStreetName = findViewById(R.id.etStreetName);
        EditText etCity = findViewById(R.id.etCity);
        EditText etState = findViewById(R.id.etState);
        EditText etZip = findViewById(R.id.etZip);
        EditText etPhoneNumber = findViewById(R.id.etPhoneNumber);

        String rFirstName = etFirstName.getText().toString();
        String rLastName = etLastName.getText().toString();
        String rBirthMonth = etBirthMonth.getText().toString();
        String rBirthDay = etBirthDay.getText().toString();
        String rBirthYear = etBirthYear.getText().toString();
        String rStreetNumber = etStreetNumber.getText().toString();
        String rStreetName = etStreetName.getText().toString();
        String rCity = etCity.getText().toString();
        String rState = etState.getText().toString();
        String rZip = etZip.getText().toString();
        String rPhoneNumber = etPhoneNumber.getText().toString();

        Person person = new Person(rFirstName,rLastName,rBirthDay,rBirthMonth,rBirthYear);
        Place place = new Place(rStreetNumber,rStreetName,rCity,rState,rZip);

        switch (view.getId()) {
            case R.id.btnSend:

                Intent sendIntent = new Intent(this, MainActivity.class);
                Bundle sbundle = new Bundle();
                sbundle.putString("rFirstName",rFirstName);
                sendIntent.putExtra("bundle", sbundle);

                startActivity(sendIntent);

                finish();
                break;

            case R.id.btnOK:

                returnIntent.putExtra("rFirstName", rFirstName);
                returnIntent.putExtra("rLastName", rLastName);
                returnIntent.putExtra("rBirthDay", rBirthDay);
                returnIntent.putExtra("rBirthMonth", rBirthMonth);
                returnIntent.putExtra("rBirthYear", rBirthYear);
                returnIntent.putExtra("rStreetNumber", rStreetNumber);
                returnIntent.putExtra("rStreetName", rStreetName);
                returnIntent.putExtra("rCity", rCity);
                returnIntent.putExtra("rState", rState);
                returnIntent.putExtra("rZip", rZip);
                returnIntent.putExtra("rPhoneNumber", rPhoneNumber);

                setResult(1, returnIntent);
                finish();
                break;

            case R.id.btnObjects:

                returnIntent.putExtra("person",person);
                returnIntent.putExtra("place", place);
                returnIntent.putExtra("rPhoneNumber", rPhoneNumber);

                setResult(2, returnIntent);
                finish();
                break;

            case R.id.btnBundle:

                Bundle bundle = new Bundle();

                bundle.putSerializable("person",person);
                bundle.putParcelable("place",place);
                bundle.putString("rPhoneNumber",rPhoneNumber);

                returnIntent.putExtra("bundle", bundle);

                setResult(3, returnIntent);
                finish();
        }
    }

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

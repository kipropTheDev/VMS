package com.example.mgeni_mock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.lang.reflect.Array;

public class VehicleCheckin extends AppCompatActivity {
    Button submitBtn;
    EditText visitorName, visitorID, visitorTemp, visitorPhone,visitorEmail, visitorCarReg,
                visitorOrg, visited, visitorNum, visitorItems;
    Spinner visitComp, visitReason;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_checkin);

        //spinner
        visitComp = findViewById(R.id.visitCompany);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.comp_arr, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        visitComp.setAdapter(adapter);

        visitReason = findViewById(R.id.reasonSpn);
        ArrayAdapter<CharSequence> aa = ArrayAdapter.createFromResource(this,
                R.array.reasons_array, android.R.layout.simple_spinner_item);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        visitReason.setAdapter(aa);




        //assign the created widgets to respective design member
        visitorName = findViewById(R.id.walkinName);
        visitorID = findViewById(R.id.walkinID);
        visitorTemp = findViewById(R.id.walkinTemp);
        visitorPhone = findViewById(R.id.walkinPhone);
        visitorEmail = findViewById(R.id.walkinEmail);
        visitorCarReg = findViewById(R.id.walkinOrg);
        visitorOrg = findViewById(R.id.walkinVisited);
        visited = findViewById(R.id.visited);
        visitorNum = findViewById(R.id.walkinNos);
        visitorItems = findViewById(R.id.walkinPersonal);
        submitBtn = findViewById(R.id.submitBtn);
    }



    public void onSubmit(View view){
        String type = "vehicle";
        String visName = visitorName.getText().toString();
        String visID = visitorID.getText().toString();
        String visTemp = visitorTemp.getText().toString();
        String visPhone = visitorPhone.getText().toString();
        String visEmail = visitorEmail.getText().toString();
        String visCarReg = visitorCarReg.getText().toString();
        String visOrg = visitorOrg.getText().toString();
        String visComp = visitComp.getSelectedItem().toString();
        String visReason = visitReason.getSelectedItem().toString();
        String visit = visited.getText().toString();
        String visNum = visitorNum.getText().toString();
        String visitems = visitorItems.getText().toString();

        //call Db class
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        //params array of items [0]->[...]
        backgroundWorker.execute(type, visName, visID, visTemp, visPhone, visEmail,
                                visCarReg, visOrg, visComp, visReason, visit, visNum, visitems);
        visitorName.setText("");
        visitorID.setText("");
        visitorTemp.setText("");
        visitorPhone.setText("");
        visitorEmail.setText("");
        visitorCarReg.setText("");
        visitorOrg.setText("");
        visited.setText("");
        visitorNum.setText("");
        visitorItems.setText("");

    }


    public void onClickBack(View view){
        Intent intent = new Intent(getApplicationContext(), CheckIn_screen.class);
        startActivity(intent);
    }
}
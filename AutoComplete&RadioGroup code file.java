package com.example.exofautocomplete;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // Complier ko batao kya use kr rhe ho
    EditText firstName, lastName;
    Button result;
    AutoCompleteTextView item;
    RadioGroup rg;
    RadioButton rb;
    String[] menu = {"Chips", "Kurkure", "Namekeen", "Biscuit"};
    @SuppressLint({"ResourceType", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // identity do
        firstName = findViewById(R.id.fName);
        lastName = findViewById(R.id.lname);
        item = findViewById(R.id.foodItem);
        result = findViewById(R.id.submit);
        rg = findViewById(R.id.genderGroup);

        //Autocomplete
        ArrayAdapter chooseItem = new ArrayAdapter(this, android.R.layout.select_dialog_item, menu);
        item.setThreshold(1);
        item.setAdapter(chooseItem);

        //Radio Group
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedInt) {
                rb = findViewById(checkedInt);
            }
        });
        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String orderList = "FirstName: " + firstName.getText().toString() + "\nLastName: " + lastName.getText().toString() +
                        "\nGender: "  + rb.getText() + "ChosedItem: " + item.getText().toString();
                Toast.makeText(MainActivity.this, orderList, Toast.LENGTH_LONG).show();
            }
        });
    }
}
package com.birds.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button mButton;
    EditText mHeightField;
    EditText mWeightField;
    TextView mBMIView;
    TextView mErrorField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = (Button)findViewById(R.id.calculateButton);
        mHeightField = ((EditText)findViewById(R.id.heightField));
        mWeightField = ((EditText)findViewById(R.id.weightField));
        mBMIView = ((TextView)findViewById(R.id.BMIView));
        mErrorField = ((TextView)findViewById(R.id.ErrorField));

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(TextUtils.isEmpty(mHeightField.getText().toString())){

                    mErrorField.setText("You have not entered your height!");
                    mBMIView.setText("");

                } else if (TextUtils.isEmpty(mWeightField.getText().toString())){

                    mErrorField.setText("You have not entered your weight!");
                    mBMIView.setText("");

                } else {
                    int height = Integer.parseInt(String.valueOf(mHeightField.getText()));
                    int weight = Integer.parseInt(String.valueOf(mWeightField.getText()));
                    double result = (weight / (Math.pow(height, 2)) * 703);

                    String stringResult = String.format("%.2f", result);
                    mBMIView.setText(stringResult);

                    mErrorField.setText("");
                }

            }
        });

      
    }
}
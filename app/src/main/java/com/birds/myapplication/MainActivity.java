package com.birds.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button mButton;
    EditText mHeightField;
    EditText mWeightField;
    TextView mBMIView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = (Button)findViewById(R.id.calculateButton);
        mHeightField = ((EditText)findViewById(R.id.heightField));
        mWeightField = ((EditText)findViewById(R.id.weightField));
        mBMIView = ((TextView)findViewById(R.id.BMIView));

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                int height = Integer.parseInt(String.valueOf(mHeightField.getText()));
                int weight = Integer.parseInt(String.valueOf(mWeightField.getText()));
                double result = (weight / (Math.pow(height, 2)) * 703);

                String stringResult = String.format("%.2f", result);
                mBMIView.setText(stringResult);

            }
        });

      
    }
}
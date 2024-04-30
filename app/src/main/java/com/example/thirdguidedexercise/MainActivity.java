package com.example.thirdguidedexercise;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText editNum1, editNum2;
    Button sumButton, aveButton, multiplyButton, divideButton;
    Toast toast;
    View view;
    double firstNum = 0, secondNum = 0, total = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EdgeToEdge.enable(this);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editNum1 = findViewById(R.id.editNum1);
        editNum2 = findViewById(R.id.editNum2);
        sumButton = findViewById(R.id.sumButton);
        aveButton = findViewById(R.id.averageButton);
        divideButton = findViewById(R.id.divideButton);
        multiplyButton = findViewById(R.id.multiplyButton);

        computeTotal();
    }

    public void computeTotal() {
        sumButton.setOnClickListener(view -> {
            if (editNum1.getText().toString().isEmpty() ||
                    editNum2.getText().toString().isEmpty()) {
                displayErrorMessage();
            } else {
                firstNum = Double.parseDouble(editNum1.getText().toString());
                secondNum = Double.parseDouble(editNum2.getText().toString());
                total = firstNum + secondNum;
                Toast.makeText(getApplicationContext(),
                        "SUM: " + total, Toast.LENGTH_SHORT).show();
            }
        });

        aveButton.setOnClickListener(view -> {
            if (editNum1.getText().toString().isEmpty() ||
                    editNum2.getText().toString().isEmpty()) {
                displayErrorMessage();
            } else {
                firstNum = Double.parseDouble(editNum1.getText().toString());
                secondNum = Double.parseDouble(editNum2.getText().toString());
                total = (firstNum + secondNum) / 2;
                Toast.makeText(getApplicationContext(),
                        "AVE: " + total, Toast.LENGTH_SHORT).show();
            }
        });

        multiplyButton.setOnClickListener(view -> {
            if (editNum1.getText().toString().isEmpty() ||
                    editNum2.getText().toString().isEmpty()) {
                displayErrorMessage();
            } else {
                firstNum = Double.parseDouble(editNum1.getText().toString());
                secondNum = Double.parseDouble(editNum2.getText().toString());
                total = firstNum * secondNum;
                Toast.makeText(getApplicationContext(),
                        "MULTIPLY: " + total, Toast.LENGTH_SHORT).show();
            }
        });

        divideButton.setOnClickListener(view -> {
            if (editNum1.getText().toString().isEmpty() ||
                    editNum2.getText().toString().isEmpty()) {
                displayErrorMessage();
            } else {
                firstNum = Double.parseDouble(editNum1.getText().toString());
                secondNum = Double.parseDouble(editNum2.getText().toString());
                if (secondNum != 0) {
                    total = firstNum / secondNum;
                    Toast.makeText(getApplicationContext(),
                            "DIVIDE: " + total, Toast.LENGTH_SHORT).show();
                } else {
                    displayErrorMessage();
                }
            }
        });
    }


    public void displayErrorMessage() {
        toast = Toast.makeText(getApplicationContext(), "Please Enter a Number", Toast.LENGTH_SHORT);
        view = toast.getView();
        if (view != null) {
            view.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN);
        }
        TextView toastMessage = view.findViewById(android.R.id.message);
        if (toastMessage != null) {
            toastMessage.setTextColor(Color.RED);
        }
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }
}

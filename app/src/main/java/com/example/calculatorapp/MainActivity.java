package com.example.calculatorapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.Button;
import android.widget.TextView;

import android.view.View;

public class MainActivity extends AppCompatActivity {
    private TextView txtDisplay;

    private Button btnClear;
    private Button btnBack;
    private Button btnSignChange;
    private Button btnDivide;
    private Button btnMultiply;
    private Button btnSubtract;
    private Button btnAdd;
    private Button btnSquareRoot;
    private Button btnEquals;

    private Button btnZero;
    private Button btnOne;
    private Button btnTwo;
    private Button btnThree;
    private Button btnFour;
    private Button btnFive;
    private Button btnSix;
    private Button btnSeven;
    private Button btnEight;
    private Button btnNine;
    private double firstNumber = 0;
    private boolean newNumber = true;
    private String currentOperation = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtDisplay = findViewById(R.id.txtDisplay);

        btnClear = findViewById(R.id.btnClear);
        btnBack = findViewById(R.id.btnBack);
        btnSignChange = findViewById(R.id.btnSignChange);
        btnDivide = findViewById(R.id.btnDivide);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnSubtract = findViewById(R.id.btnSubtract);
        btnAdd = findViewById(R.id.btnAdd);
        btnSquareRoot = findViewById(R.id.btnSquareRoot);
        btnEquals = findViewById(R.id.btnEquals);

        btnZero = findViewById(R.id.btnZero);
        btnOne = findViewById(R.id.btnOne);
        btnTwo = findViewById(R.id.btnTwo);
        btnThree = findViewById(R.id.btnThree);
        btnFour = findViewById(R.id.btnFour);
        btnFive = findViewById(R.id.btnFive);
        btnSix = findViewById(R.id.btnSix);
        btnSeven = findViewById(R.id.btnSeven);
        btnEight = findViewById(R.id.btnEight);
        btnNine = findViewById(R.id.btnNine);

        SetNumberButtonListeners();
        btnClear.setOnClickListener(view -> {
            txtDisplay.setText("0");
        });

        btnAdd.setOnClickListener(view -> {
            firstNumber = Double.parseDouble(txtDisplay.getText().toString());
            newNumber = true;
        });

        btnSubtract.setOnClickListener(view -> {
            firstNumber = Double.parseDouble(txtDisplay.getText().toString());
            currentOperation = "-";
            newNumber = true;
        });

        btnMultiply.setOnClickListener(view -> {
            firstNumber = Double.parseDouble(txtDisplay.getText().toString());
            currentOperation = "*";
            newNumber = true;
        });

        btnDivide.setOnClickListener(view -> {
            firstNumber = Double.parseDouble(txtDisplay.getText().toString());
            currentOperation = "/";
            newNumber = true;
        });

        btnSquareRoot.setOnClickListener(view -> {
            double number = Double.parseDouble(txtDisplay.getText().toString());

            if (number >= 0) {
                double result = Math.sqrt(number);
                txtDisplay.setText(String.valueOf(result));
                newNumber = true;
            } else {
                txtDisplay.setText("Error");
            }
        });

        btnEquals.setOnClickListener(view -> {
            double secondNumber = Double.parseDouble(txtDisplay.getText().toString());
            double result;

            if (currentOperation.equals("-")) {
                result = firstNumber - secondNumber;
            } else if (currentOperation.equals("*")) {
                result = firstNumber * secondNumber;
            } else if (currentOperation.equals("/")) {
                if (secondNumber == 0) {
                    txtDisplay.setText("Error");
                    return;
                }

                result = firstNumber / secondNumber;
            }else {
                result = firstNumber + secondNumber;
            }

            txtDisplay.setText(String.valueOf(result));
            newNumber = true;
        });

        btnBack.setOnClickListener(view -> {
            String currentText = txtDisplay.getText().toString();

            if (currentText.length() > 1) {
                txtDisplay.setText(currentText.substring(0, currentText.length() - 1));
            } else {
                txtDisplay.setText("0");
            }
        });

        btnSignChange.setOnClickListener(view -> {
            String currentText = txtDisplay.getText().toString();

            if (!currentText.equals("0")) {
                if (currentText.startsWith("-")) {
                    txtDisplay.setText(currentText.substring(1));
                } else {
                    txtDisplay.setText("-" + currentText);
                }
            }
        });


    }
    private void SetNumberButtonListeners() {

        View.OnClickListener numberListener = view -> {
            Button clickedButton = (Button) view;
            String number = clickedButton.getText().toString();

            if (newNumber || txtDisplay.getText().toString().equals("0")) {
                txtDisplay.setText(number);
                newNumber = false;
            } else {
                txtDisplay.append(number);
            }
        };

        btnZero.setOnClickListener(numberListener);
        btnOne.setOnClickListener(numberListener);
        btnTwo.setOnClickListener(numberListener);
        btnThree.setOnClickListener(numberListener);
        btnFour.setOnClickListener(numberListener);
        btnFive.setOnClickListener(numberListener);
        btnSix.setOnClickListener(numberListener);
        btnSeven.setOnClickListener(numberListener);
        btnEight.setOnClickListener(numberListener);
        btnNine.setOnClickListener(numberListener);
    }
}
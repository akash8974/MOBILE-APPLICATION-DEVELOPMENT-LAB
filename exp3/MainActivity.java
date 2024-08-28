package com.example.myapplication;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
 private TextView display;
 private String input = "";
 private boolean isNewOp = true;
 @Override
 protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 setContentView(R.layout.activity_main);
 display = findViewById(R.id.display);
 // Number buttons
 findViewById(R.id.btn0).setOnClickListener(this::onNumberClick);
 findViewById(R.id.btn1).setOnClickListener(this::onNumberClick);
 findViewById(R.id.btn2).setOnClickListener(this::onNumberClick);
 findViewById(R.id.btn3).setOnClickListener(this::onNumberClick);
 findViewById(R.id.btn4).setOnClickListener(this::onNumberClick);
 findViewById(R.id.btn5).setOnClickListener(this::onNumberClick);
 findViewById(R.id.btn6).setOnClickListener(this::onNumberClick);
 findViewById(R.id.btn7).setOnClickListener(this::onNumberClick);
 findViewById(R.id.btn8).setOnClickListener(this::onNumberClick);
 findViewById(R.id.btn9).setOnClickListener(this::onNumberClick);
 // Operation buttons
 findViewById(R.id.btnAdd).setOnClickListener(this::onOperationClick);
 findViewById(R.id.btnSub).setOnClickListener(this::onOperationClick);
 findViewById(R.id.btnMul).setOnClickListener(this::onOperationClick);
 findViewById(R.id.btnDiv).setOnClickListener(this::onOperationClick);
 // Scientific buttons
 findViewById(R.id.btnSin).setOnClickListener(this::onScientificOperationClick);
 findViewById(R.id.btnCos).setOnClickListener(this::onScientificOperationClick);
 findViewById(R.id.btnTan).setOnClickListener(this::onScientificOperationClick);
 findViewById(R.id.btnLog).setOnClickListener(this::onScientificOperationClick);
 // Other buttons
 findViewById(R.id.btnDot).setOnClickListener(this::onDotClick);
 findViewById(R.id.btnEqual).setOnClickListener(this::onEqualClick);
 findViewById(R.id.btnClear).setOnClickListener(v -> {
 input = "";
 display.setText("0");
 });
 }
 private void onNumberClick(View view) {
 if (isNewOp) {
 input = "";
 isNewOp = false;
 }
 Button button = (Button) view;
 input += button.getText().toString();
 display.setText(input);
 }
 private void onOperationClick(View view) {
 Button button = (Button) view;
 input += " " + button.getText().toString() + " ";
 display.setText(input);
 }
 private void onScientificOperationClick(View view) {
 Button button = (Button) view;
 String op = button.getText().toString();
 double result = 0;
 double value = Double.parseDouble(input);
 switch (op) {
 case "sin":
 result = Math.sin(Math.toRadians(value));
 break;
 case "cos":
 result = Math.cos(Math.toRadians(value));
 break;
 case "tan":
 result = Math.tan(Math.toRadians(value));
 break;
 case "log":
 result = Math.log10(value);
 break;
 }
 display.setText(String.valueOf(result));
 input = String.valueOf(result);
 isNewOp = true;
 }
 private void onDotClick(View view) {
 if (!input.contains(".")) {
 input += ".";
 display.setText(input);
 }
 }
 private void onEqualClick(View view) {
 String[] tokens = input.split(" ");
 if (tokens.length < 3) return;
 double a = Double.parseDouble(tokens[0]);
 double b = Double.parseDouble(tokeens[2]);
 String op = tokens[1];
 double result = 0;
 switch (op) {
 case "+":
 result = a + b;
 break;
 case "-":
 result = a - b;
 break;
 case "*":
 result = a * b;
 break;
 case "/":
 result = a / b;
 break;
 }
 display.setText(String.valueOf(result));
 input = String.valueOf(result);
 isNewOp = true;
 }
}

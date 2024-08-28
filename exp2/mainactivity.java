package com.example.akash;
import android.os.Bundle;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
public class MainActivity extends AppCompatActivity {
 TextView textView;
 Button buttonChangeFont, buttonChangeColor;
 @Override
 protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 EdgeToEdge.enable(this);
 setContentView(R.layout.activity_main);
 textView = findViewById(R.id.textView);
 buttonChangeFont = findViewById(R.id.buttonChangeFont);
 buttonChangeColor = findViewById(R.id.buttonChangeColor);
 ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
 Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
 v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
 return insets;
 });
 buttonChangeFont.setOnClickListener(v -> {
 textView.setTextSize(40);
 Toast.makeText(getApplicationContext(), "Font Size Changed",
Toast.LENGTH_LONG).show();
 });
 buttonChangeColor.setOnClickListener(v -> {
 textView.setTextColor(Color.RED);
 Toast.makeText(getApplicationContext(), "Font Color Changed",
Toast.LENGTH_LONG).show();
 });
 }
}

package com.example.akashdata;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
 private EditText editTextName, editTextRollNo, editTextMarks, editTextCollege, editTextGender;
 private Button buttonAdd, buttonUpdate, buttonDelete, buttonView;
 private DatabaseHelper dbHelper;
 @Override
 protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 setContentView(R.layout.activity_main);
 editTextName = findViewById(R.id.editTextName);
 editTextRollNo = findViewById(R.id.editTextRollNo);
 editTextMarks = findViewById(R.id.editTextMarks);
 editTextCollege = findViewById(R.id.editTextCollege);
 editTextGender = findViewById(R.id.editTextGender);
 buttonAdd = findViewById(R.id.buttonAdd);
 buttonUpdate = findViewById(R.id.buttonUpdate);
 buttonDelete = findViewById(R.id.buttonDelete);
 buttonView = findViewById(R.id.buttonView);
 dbHelper = new DatabaseHelper(this);
 buttonAdd.setOnClickListener(new View.OnClickListener() {
 @Override
 public void onClick(View v) {
 addStudent();
 }
 });
 buttonUpdate.setOnClickListener(new View.OnClickListener() {
 @Override
 public void onClick(View v) {
 updateStudent();
 }
 });
 buttonDelete.setOnClickListener(new View.OnClickListener() {
 @Override
 public void onClick(View v) {
 deleteStudent();
 }
 });
 buttonView.setOnClickListener(new View.OnClickListener() {
 @Override
 public void onClick(View v) {
 viewStudents();
 }
 });
 }
 private void addStudent() {
 String name = editTextName.getText().toString();
 int rollNo = Integer.parseInt(editTextRollNo.getText().toString());
 int marks = Integer.parseInt(editTextMarks.getText().toString());
 String college = editTextCollege.getText().toString();
 String gender = editTextGender.getText().toString();
 boolean result = dbHelper.insertStudent(name, rollNo, marks, college, gender);
 if (result) {
 Toast.makeText(this, "Student added successfully", Toast.LENGTH_SHORT).show();
 } else {
 Toast.makeText(this, "Failed to add student", Toast.LENGTH_SHORT).show();
 }
 }
 private void updateStudent() {
 String name = editTextName.getText().toString();
 int rollNo = Integer.parseInt(editTextRollNo.getText().toString());
 int marks = Integer.parseInt(editTextMarks.getText().toString());
 String college = editTextCollege.getText().toString();
 String gender = editTextGender.getText().toString();
 boolean result = dbHelper.updateStudent(name, rollNo, marks, college, gender);
 if (result) {
 Toast.makeText(this, "Student updated successfully", Toast.LENGTH_SHORT).show();
 } else {
 Toast.makeText(this, "Failed to update student", Toast.LENGTH_SHORT).show();
 }
 }
 private void deleteStudent() {
 int rollNo = Integer.parseInt(editTextRollNo.getText().toString());
 boolean result = dbHelper.deleteStudent(rollNo);
 if (result) {
 Toast.makeText(this, "Student deleted successfully", Toast.LENGTH_SHORT).show();
 } else {
 Toast.makeText(this, "Failed to delete student", Toast.LENGTH_SHORT).show();
 }
 }
 private void viewStudents() {
 Cursor cursor = dbHelper.getAllStudents();
 if (cursor.getCount() == 0) {
 Toast.makeText(this, "No student records found", Toast.LENGTH_SHORT).show();
 return;
 }
 StringBuilder buffer = new StringBuilder();
 while (cursor.moveToNext()) {
 String name = cursor.getString(cursor.getColumnIndex("Name"));
 int rollNo = cursor.getInt(cursor.getColumnIndex("RollNo"));
 int marks = cursor.getInt(cursor.getColumnIndex("Marks"));
 String college = cursor.getString(cursor.getColumnIndex("College"));
 String gender = cursor.getString(cursor.getColumnIndex("Gender"));
 buffer.append("Name: ").append(name).append("\n");
 buffer.append("Roll No: ").append(rollNo).append("\n");
 buffer.append("Marks: ").append(marks).append("\n");
 buffer.append("College: ").append(college).append("\n");
 buffer.append("Gender: ").append(gender).append("\n\n");
 }
 // Show results in a dialog
 ResultsDialogFragment dialog = new ResultsDialogFragment(buffer.toString());
 dialog.show(getSupportFragmentManager(), "ResultsDialog");
}}

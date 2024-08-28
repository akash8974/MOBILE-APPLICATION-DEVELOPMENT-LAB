package com.example.akashdata;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class DatabaseHelper extends SQLiteOpenHelper {
 private static final String DATABASE_NAME = "student.db";
 private static final int DATABASE_VERSION = 1;
 private static final String TABLE_NAME = "Student";
 private static final String COLUMN_NAME = "Name";
 private static final String COLUMN_ROLL_NO = "RollNo";
 private static final String COLUMN_MARKS = "Marks";
 private static final String COLUMN_COLLEGE = "College";
 private static final String COLUMN_GENDER = "Gender";
 public DatabaseHelper(Context context) {
 super(context, DATABASE_NAME, null, DATABASE_VERSION);
 }
 @Override
 public void onCreate(SQLiteDatabase db) {
 String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" +
 COLUMN_NAME + " TEXT, " +
 COLUMN_ROLL_NO + " INTEGER PRIMARY KEY, " +
 COLUMN_MARKS + " INTEGER, " +
 COLUMN_COLLEGE + " TEXT, " +
 COLUMN_GENDER + " TEXT)";
 db.execSQL(CREATE_TABLE);
 }
 @Override
 public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
 db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
 onCreate(db);
 }
 // Insert student details
 public boolean insertStudent(String name, int rollNo, int marks, String college, String gender) {
 SQLiteDatabase db = this.getWritableDatabase();
 ContentValues values = new ContentValues();
 values.put(COLUMN_NAME, name);
 values.put(COLUMN_ROLL_NO, rollNo);
 values.put(COLUMN_MARKS, marks);
 values.put(COLUMN_COLLEGE, college);
 values.put(COLUMN_GENDER, gender);
 long result = db.insert(TABLE_NAME, null, values);
 return result != -1;
 }
 // Update student record
 public boolean updateStudent(String name, int rollNo, int marks, String college, String gender) {
 SQLiteDatabase db = this.getWritableDatabase();
 ContentValues values = new ContentValues();
 values.put(COLUMN_NAME, name);
 values.put(COLUMN_MARKS, marks);
 values.put(COLUMN_COLLEGE, college);
 values.put(COLUMN_GENDER, gender);
 int result = db.update(TABLE_NAME, values, COLUMN_ROLL_NO + " = ?", new
String[]{String.valueOf(rollNo)});
 return result > 0;
 }
 // Delete a specified record
 public boolean deleteStudent(int rollNo) {
 SQLiteDatabase db = this.getWritableDatabase();
 int result = db.delete(TABLE_NAME, COLUMN_ROLL_NO + " = ?", new
String[]{String.valueOf(rollNo)});
 return result > 0;
 }
 // Retrieve all student details
 public Cursor getAllStudents() {
 SQLiteDatabase db = this.getReadableDatabase();
 return db.query(TABLE_NAME, null, null, null, null, null, null);
 }
}

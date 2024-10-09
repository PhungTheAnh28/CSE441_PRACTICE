package com.example.btth_3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddStudentActivity extends AppCompatActivity {
    private EditText idEditText, firstNameEditText, middleNameEditText, lastNameEditText, genderEditText, birthDateEditText, emailEditText, addressEditText, majorEditText, gpaEditText, yearEditText;
    private Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);


        idEditText = findViewById(R.id.student_id);
        firstNameEditText = findViewById(R.id.student_first_name);
        middleNameEditText = findViewById(R.id.student_middle_name);
        lastNameEditText = findViewById(R.id.student_last_name);
        genderEditText = findViewById(R.id.student_gender);
        birthDateEditText = findViewById(R.id.student_birth_date);
        emailEditText = findViewById(R.id.student_email);
        addressEditText = findViewById(R.id.student_address);
        majorEditText = findViewById(R.id.student_major);
        gpaEditText = findViewById(R.id.student_gpa);
        yearEditText = findViewById(R.id.student_year);
        addButton = findViewById(R.id.button_add_student);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewStudent();
            }
        });
    }

    private void addNewStudent() {

        String id = idEditText.getText().toString();
        String firstName = firstNameEditText.getText().toString();
        String middleName = middleNameEditText.getText().toString();
        String lastName = lastNameEditText.getText().toString();
        String gender = genderEditText.getText().toString();
        String birthDate = birthDateEditText.getText().toString();
        String email = emailEditText.getText().toString();
        String address = addressEditText.getText().toString();
        String major = majorEditText.getText().toString();
        double gpa = Double.parseDouble(gpaEditText.getText().toString());
        int year = Integer.parseInt(yearEditText.getText().toString());


        com.example.btth_3.Student.FullName fullName = new com.example.btth_3.Student.FullName(firstName, middleName, lastName);
        com.example.btth_3.Student newStudent = new com.example.btth_3.Student(id, fullName, gender, birthDate, email, address, major, gpa, year);


        Intent resultIntent = new Intent();
        resultIntent.putExtra("new_student", newStudent);
        setResult(RESULT_OK, resultIntent);
        finish();
    }
}

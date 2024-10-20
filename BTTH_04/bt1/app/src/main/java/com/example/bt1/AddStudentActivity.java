package com.example.bt1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class AddStudentActivity extends AppCompatActivity {

    private EditText editTextStudentId, editTextName, editTextClass, editTextGpa;
    private Button btnSave;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        editTextStudentId = findViewById(R.id.editTextStudentId);
        editTextName = findViewById(R.id.editTextFullName);
        editTextClass = findViewById(R.id.editTextClass);
        editTextGpa = findViewById(R.id.editTextGPA);
        btnSave = findViewById(R.id.buttonSave);

        databaseReference = FirebaseDatabase.getInstance().getReference("sinhvien");

        btnSave.setOnClickListener(v -> saveStudent());
    }

    private void saveStudent() {
        String id = editTextStudentId.getText().toString();
        String name = editTextName.getText().toString();
        String className = editTextClass.getText().toString();
        double gpa;

        try {
            gpa = Double.parseDouble(editTextGpa.getText().toString());
        } catch (NumberFormatException e) {
            gpa = 0;
        }

        Student student = new Student(id, name, className, gpa);
        databaseReference.child(id).setValue(student);
        finish();
    }
}


package com.example.bt1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EditStudentActivity extends AppCompatActivity {

    private EditText editTextName, editTextClass, editTextGpa;
    private Button btnSave;
    private DatabaseReference databaseReference;
    private String studentId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_student);

        editTextName = findViewById(R.id.editTextName);
        editTextClass = findViewById(R.id.editTextClass);
        editTextGpa = findViewById(R.id.editTextGPA);
        btnSave = findViewById(R.id.buttonUpdate);


        databaseReference = FirebaseDatabase.getInstance().getReference("sinhvien");

        Student student = (Student) getIntent().getSerializableExtra("sinhvien");
        if (student != null) {
            studentId = student.getMssv();
            editTextName.setText(student.getHoten());
            editTextClass.setText(student.getLop());
            editTextGpa.setText(String.valueOf(student.getGpa()));
        }

        btnSave.setOnClickListener(v -> saveStudent());
    }

    private void saveStudent() {
        String name = editTextName.getText().toString().trim();
        String className = editTextClass.getText().toString().trim();
        double gpa;

        try {
            gpa = Double.parseDouble(editTextGpa.getText().toString().trim());
        } catch (NumberFormatException e) {
            gpa = 0;
        }

        Student student = new Student(studentId, name, className, gpa);


        databaseReference.child(studentId).setValue(student)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        Toast.makeText(this, "Cập nhật thông tin thành công", Toast.LENGTH_SHORT).show();
                        finish();
                    } else {

                        Toast.makeText(this, "Có lỗi xảy ra khi lưu thông tin sinh viên", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
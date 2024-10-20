package com.example.bt1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class StudentDetailActivity extends AppCompatActivity {


    private TextView textViewStudentId, textViewName, textViewClass, textViewGpa;
    private Button buttonEdit, buttonDelete;
    private DatabaseReference databaseReference;
    private String studentId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_detail);

        textViewStudentId = findViewById(R.id.textViewStudentId);
        textViewName = findViewById(R.id.textViewName);
        textViewClass = findViewById(R.id.textViewClass);
        textViewGpa = findViewById(R.id.textViewGpa);
        buttonEdit = findViewById(R.id.buttonEdit);
        buttonDelete = findViewById(R.id.buttonDelete);


        Student student = (Student) getIntent().getSerializableExtra("student"); // Sửa tên khóa từ "sinhvien" thành "student"


        if (student != null) {
            studentId = student.getMssv();
            textViewStudentId.setText("MSSV: " + student.getMssv());
            textViewName.setText("Họ tên: " + student.getHoten());
            textViewClass.setText("Lớp: " + student.getLop());
            textViewGpa.setText("GPA: " + student.getGpa());
        }


        databaseReference = FirebaseDatabase.getInstance().getReference("sinhvien");


        buttonEdit.setOnClickListener(v -> {
            Intent intent = new Intent(StudentDetailActivity.this, EditStudentActivity.class);
            intent.putExtra("student", student);
            startActivity(intent);
        });

        buttonDelete.setOnClickListener(v -> {
            if (studentId != null) {
                deleteStudent();
            } else {
                Toast.makeText(this, "Không thể xóa sinh viên, thông tin không hợp lệ", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void deleteStudent() {
        databaseReference.child(studentId).removeValue()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        Toast.makeText(StudentDetailActivity.this, "Sinh viên đã được xóa", Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(StudentDetailActivity.this, "Có lỗi xảy ra khi xóa sinh viên", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}

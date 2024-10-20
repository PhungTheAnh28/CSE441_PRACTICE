package com.example.bt1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listViewStudents;
    private Button btnAddStudent;
    private DatabaseReference databaseReference;
    private ArrayList<Student> studentList;
    private StudentAdapter studentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewStudents = findViewById(R.id.listViewStudents);
        btnAddStudent = findViewById(R.id.btnAddStudent);
        studentList = new ArrayList<>();

        databaseReference = FirebaseDatabase.getInstance().getReference("sinhvien");

        studentAdapter = new StudentAdapter(this, studentList);
        listViewStudents.setAdapter(studentAdapter);

        loadStudentsFromDatabase();

        btnAddStudent.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddStudentActivity.class);
            startActivity(intent);
        });

        listViewStudents.setOnItemClickListener((parent, view, position, id) -> {
            Student selectedStudent = studentList.get(position);
            if (selectedStudent != null) {

                Intent intent = new Intent(MainActivity.this, StudentDetailActivity.class);
                intent.putExtra("student", selectedStudent);
                startActivity(intent);
            } else {
                Toast.makeText(MainActivity.this, "Lỗi: Không tìm thấy sinh viên", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Hàm tải sinh viên từ Firebase
    private void loadStudentsFromDatabase() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                studentList.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Student student = snapshot.getValue(Student.class);
                    if (student != null) {
                        studentList.add(student);
                    }
                }
                studentAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(MainActivity.this, "Lỗi: Không thể tải danh sách sinh viên", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

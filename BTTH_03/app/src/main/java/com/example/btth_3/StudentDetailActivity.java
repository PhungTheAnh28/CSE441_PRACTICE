package com.example.btth_3;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class StudentDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_detail);

        ImageView avatarImageView = findViewById(R.id.student_avatar);
        TextView idTextView = findViewById(R.id.student_id);
        TextView nameTextView = findViewById(R.id.student_name);
        TextView genderTextView = findViewById(R.id.student_gender);
        TextView birthDateTextView = findViewById(R.id.student_birth_date);
        TextView emailTextView = findViewById(R.id.student_email);
        TextView addressTextView = findViewById(R.id.student_address);
        TextView majorTextView = findViewById(R.id.student_major);
        TextView gpaTextView = findViewById(R.id.student_gpa);
        TextView yearTextView = findViewById(R.id.student_year);

        Student student = (Student) getIntent().getSerializableExtra("student");


        if (student != null) {
            idTextView.setText("Mã sinh viên: " + student.getId());
            nameTextView.setText("Họ và tên: " + student.getFullName().getFirst() + " " + student.getFullName().getMidd() + " " + student.getFullName().getLast());
            genderTextView.setText("Giới tính: " + student.getGender());
            birthDateTextView.setText("Ngày sinh: " + student.getBirthDate());
            emailTextView.setText("Email: " + student.getEmail());
            addressTextView.setText("Địa chỉ: " + student.getAddress());
            majorTextView.setText("Ngành học: " + student.getMajor());
            gpaTextView.setText("GPA: " + String.valueOf(student.getGpa()));
            yearTextView.setText("Năm: " + String.valueOf(student.getYear()));

            if (student.getGender().equalsIgnoreCase("Nam")) {
                avatarImageView.setImageResource(R.drawable.male_icon); // Thay đổi tên tài nguyên nếu cần
            } else {
                avatarImageView.setImageResource(R.drawable.female_icon); // Thay đổi tên tài nguyên nếu cần
            }
        }
    }
}

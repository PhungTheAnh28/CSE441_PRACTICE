package com.example.prac2;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etId, etFullname, etDate, etSalary;
    private TextView tvResult;
    private Button btnAddStaff;

    // StringBuilder để lưu trữ thông tin tất cả nhân viên
    private StringBuilder staffList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Khai báo các view
        etId = findViewById(R.id.etId);
        etFullname = findViewById(R.id.etFullname);
        etDate = findViewById(R.id.etDate);
        etSalary = findViewById(R.id.etSalary);
        btnAddStaff = findViewById(R.id.btnAddStaff);
        tvResult = findViewById(R.id.tvResult);

        // Khởi tạo StringBuilder
        staffList = new StringBuilder();

        // Gán sự kiện click cho nút Add New Staff
        btnAddStaff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy dữ liệu từ các EditText
                String id = etId.getText().toString().trim();
                String fullname = etFullname.getText().toString().trim();
                String date = etDate.getText().toString().trim();
                String salary = etSalary.getText().toString().trim();

                // Kiểm tra xem các trường có được nhập đầy đủ không
                if (!TextUtils.isEmpty(id) && !TextUtils.isEmpty(fullname) && !TextUtils.isEmpty(date) && !TextUtils.isEmpty(salary)) {
                    // Nếu nhập đầy đủ, thêm thông tin vào staffList
                    staffList.append(id).append(" - ").append(fullname).append(" - ").append(date).append(" - ").append(salary).append("\n");

                    // Cập nhật kết quả lên TextView
                    tvResult.setText(staffList.toString());
                } else {
                    // Nếu chưa nhập đầy đủ, hiển thị "No result"
                    tvResult.setText("No result");
                }
            }
        });
    }
}
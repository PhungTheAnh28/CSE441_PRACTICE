package com.example.btth2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 1;  // Mã request
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResult = findViewById(R.id.textViewResult);
        Button buttonStartActivity = findViewById(R.id.buttonStartActivity);

        buttonStartActivity.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ChildActivity.class);
            startActivityForResult(intent, REQUEST_CODE);  // Bắt đầu ChildActivity
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            if (data != null) {
                // Lấy dữ liệu từ Intent
                String hoTen = data.getStringExtra("hoTen");
                String gpa = data.getStringExtra("gpa");

                // Hiển thị kết quả lên màn hình
                textViewResult.setText("Họ tên: " + hoTen + "\nGPA: " + gpa);
            }
        }
    }
};
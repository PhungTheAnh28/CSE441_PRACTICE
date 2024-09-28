package com.example.btth2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class ChildActivity extends AppCompatActivity {

    private EditText editTextHoTen, editTextGpa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);

        editTextHoTen = findViewById(R.id.editTextHoTen);
        editTextGpa = findViewById(R.id.editTextGpa);

        Button buttonSubmit = findViewById(R.id.buttonSubmit);

        buttonSubmit.setOnClickListener(v -> {
            String hoTen = editTextHoTen.getText().toString();
            String gpa = editTextGpa.getText().toString();

            // Tạo Intent để gửi dữ liệu về MainActivity
            Intent resultIntent = new Intent();
            resultIntent.putExtra("hoTen", hoTen);
            resultIntent.putExtra("gpa", gpa);

            setResult(RESULT_OK, resultIntent);  // Đặt kết quả OK và kèm theo dữ liệu
            finish();  // Đóng ChildActivity
        });
    }
}


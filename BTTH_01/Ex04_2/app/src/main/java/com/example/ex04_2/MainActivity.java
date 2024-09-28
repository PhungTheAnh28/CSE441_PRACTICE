package com.example.ex04_2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    EditText editText_chieuCao, editText_ten, editText_canNang, editText_BMI, editText_chuanDoan;
    Button btn_tinh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText_ten = findViewById(R.id.editText_ten);
        editText_chieuCao = findViewById(R.id.editText_chieuCao);
        editText_canNang = findViewById(R.id.editText_canNang);
        editText_BMI = findViewById(R.id.editText_BMI);
        editText_chuanDoan = findViewById(R.id.editText_chuanDoan);
        btn_tinh = findViewById(R.id.btn_tinhBMI);
        btn_tinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String strChieuCao = editText_chieuCao.getText().toString().trim();
                    String strCanNang = editText_canNang.getText().toString().trim();

                    if (strChieuCao.isEmpty() || strCanNang.isEmpty()) {
                        Toast.makeText(MainActivity.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    strChieuCao = strChieuCao.replace(',', '.');
                    strCanNang = strCanNang.replace(',', '.');

                    double chieuCao = Double.parseDouble(strChieuCao);
                    double canNang = Double.parseDouble(strCanNang);

                    if (chieuCao == 0) {
                        Toast.makeText(MainActivity.this, "Chiều cao phải khác không", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    double BMI = canNang / Math.pow(chieuCao, 2);
                    String chuandoan;

                    if (BMI < 18) {
                        chuandoan = "Bạn gầy";
                    } else if (BMI < 25) {
                        chuandoan = "Bạn bình thường";
                    } else if (BMI < 30) {
                        chuandoan = "Bạn béo phì độ 1";
                    } else if (BMI < 35) {
                        chuandoan = "Bạn béo phì độ 2";
                    } else {
                        chuandoan = "Bạn béo phì độ 3";
                    }
                    DecimalFormat dcf = new DecimalFormat("#.0");
                    editText_BMI.setText(dcf.format(BMI));
                    editText_chuanDoan.setText(chuandoan);
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Cân nặng hoặc chiều cao không hợp lệ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

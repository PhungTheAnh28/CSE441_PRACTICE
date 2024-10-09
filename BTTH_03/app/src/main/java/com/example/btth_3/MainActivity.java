package com.example.btth_3;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int ADD_STUDENT_REQUEST = 1;
    private RecyclerView recyclerView;
    private StudentAdapter studentAdapter;
    private List<Student> studentList;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        studentList = new ArrayList<>();
        studentAdapter = new StudentAdapter(this, studentList);
        recyclerView.setAdapter(studentAdapter);


        searchView = findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                studentAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                studentAdapter.getFilter().filter(newText);
                return false;
            }
        });


        ImageButton addStudentButton = findViewById(R.id.button_add_student);
        addStudentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddStudentActivity.class);
                startActivityForResult(intent, ADD_STUDENT_REQUEST);
            }
        });


        Button sortButton = findViewById(R.id.button_sort_gpa); // Thêm ID cho nút sắp xếp trong layout
        sortButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                studentAdapter.sortByGPA(); // Gọi phương thức sắp xếp
            }
        });

        new LoadStudentsTask().execute();
    }

    private class LoadStudentsTask extends AsyncTask<Void, Void, List<Student>> {
        @Override
        protected List<Student> doInBackground(Void... voids) {
            List<Student> students = new ArrayList<>();
            try {
                InputStream inputStream = getResources().openRawResource(R.raw.student);
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    stringBuilder.append(line);
                }

                JSONArray jsonArray = new JSONArray(stringBuilder.toString());
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);

                    String id = jsonObject.getString("id");

                    JSONObject fullNameObject = jsonObject.getJSONObject("full_name");
                    String first = fullNameObject.getString("first");
                    String midd = fullNameObject.optString("midd", "");
                    String last = fullNameObject.getString("last");
                    Student.FullName fullName = new Student.FullName(last, midd, first);

                    String gender = jsonObject.getString("gender");
                    String birthDate = jsonObject.getString("birth_date");
                    String email = jsonObject.getString("email");
                    String address = jsonObject.getString("address");
                    String major = jsonObject.getString("major");
                    double gpa = jsonObject.getDouble("gpa");
                    int year = jsonObject.getInt("year");

                    Student student = new Student(id, fullName, gender, birthDate, email, address, major, gpa, year);
                    students.add(student);
                }
            } catch (JSONException e) {
                Log.e("MainActivity", "JSON parsing error", e);
                return null;
            } catch (Exception e) {
                Log.e("MainActivity", "Error reading JSON", e);
                return null;
            }
            return students;
        }

        @Override
        protected void onPostExecute(List<Student> students) {
            if (students != null) {
                studentList.addAll(students);
                studentAdapter.notifyDataSetChanged();
            } else {
                Toast.makeText(MainActivity.this, "Failed to load data", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ADD_STUDENT_REQUEST && resultCode == RESULT_OK && data != null) {
            Student newStudent = (Student) data.getSerializableExtra("new_student");
            if (newStudent != null) {
                studentList.add(newStudent);
                studentAdapter.notifyDataSetChanged();
            }
        }
    }
}

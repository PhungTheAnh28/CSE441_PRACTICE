package com.example.bt1;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class StudentAdapter extends ArrayAdapter<Student> {
    private Context context;
    private ArrayList<Student> students;

    public StudentAdapter(Context context, ArrayList<Student> students) {
        super(context, 0, students);
        this.context = context;
        this.students = students;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.student_item, parent, false);
        }


        Student student = students.get(position);

        TextView tvName = convertView.findViewById(R.id.tvName);
        TextView tvClass = convertView.findViewById(R.id.tvClass);
        TextView tvGPA = convertView.findViewById(R.id.tvGPA);

        tvName.setText(student.getHoten());
        tvClass.setText(student.getLop());
        tvGPA.setText("GPA: " + student.getGpa());

        return convertView;
    }
}

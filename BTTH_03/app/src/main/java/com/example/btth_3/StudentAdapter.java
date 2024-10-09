package com.example.btth_3;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> implements Filterable {
    private List<Student> studentList;
    private List<Student> studentListFull; // Danh sách đầy đủ để phục vụ cho tìm kiếm
    private Context context;

    public StudentAdapter(Context context, List<Student> studentList) {
        this.context = context;
        this.studentList = studentList;
        this.studentListFull = new ArrayList<>(studentList); // Khởi tạo danh sách đầy đủ
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_student, parent, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        Student student = studentList.get(position);
        holder.bind(student);
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    @Override
    public Filter getFilter() {
        return studentFilter;
    }

    private Filter studentFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Student> filteredStudents = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredStudents.addAll(studentListFull); // Trả lại danh sách đầy đủ nếu không có điều kiện
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (Student student : studentListFull) {

                    if (student.getFullName().getFirst().toLowerCase().contains(filterPattern) ||
                            student.getFullName().getMidd().toLowerCase().contains(filterPattern) ||
                            student.getFullName().getLast().toLowerCase().contains(filterPattern)) {
                        filteredStudents.add(student);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredStudents;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            studentList.clear();
            studentList.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };

    public void sortByGPA() {
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return Double.compare(s1.getGpa(), s2.getGpa());
            }
        });
        notifyDataSetChanged();
    }

    public class StudentViewHolder extends RecyclerView.ViewHolder {
        private TextView idTextView, nameTextView, gpaTextView;
        private ImageView genderImageView;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            idTextView = itemView.findViewById(R.id.student_id);
            nameTextView = itemView.findViewById(R.id.student_name);
            gpaTextView = itemView.findViewById(R.id.student_gpa);
            genderImageView = itemView.findViewById(R.id.imageViewAvatar);
        }

        public void bind(final Student student) {
            idTextView.setText("ID: " + student.getId());
            nameTextView.setText(student.getFullName().getFirst() + " " + student.getFullName().getMidd() + " " + student.getFullName().getLast());
            gpaTextView.setText("GPA: " + student.getGpa());


            if (student.getGender().equalsIgnoreCase("Nam")) {
                genderImageView.setImageResource(R.drawable.male_icon); // Hình cho nam
            } else {
                genderImageView.setImageResource(R.drawable.female_icon); // Hình cho nữ
            }

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, StudentDetailActivity.class);
                    intent.putExtra("student", student);
                    context.startActivity(intent);
                }
            });
        }
    }
}

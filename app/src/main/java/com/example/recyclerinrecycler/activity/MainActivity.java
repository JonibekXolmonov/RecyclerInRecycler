package com.example.recyclerinrecycler.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerinrecycler.R;
import com.example.recyclerinrecycler.adapter.TeacherAdapter;
import com.example.recyclerinrecycler.model.Students;
import com.example.recyclerinrecycler.model.Teacher;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ArrayList<Teacher> teachers = new ArrayList<>();
    ArrayList<Students> students = new ArrayList<>();
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    void initViews() {
        recyclerView = findViewById(R.id.rv_teachers);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));

        fillStudents();
        fillTeachersList();

        refreshAdapter();
    }

    void refreshAdapter() {
        TeacherAdapter teacherAdapter = new TeacherAdapter(this, teachers);
        recyclerView.setAdapter(teacherAdapter);
    }


    void fillTeachersList() {
        for (int i = 1; i <= 10; i++) {
            if (i % 5 == 0)
                teachers.add(new Teacher(setDefaultName(), setDefaultSubject(), false, R.drawable.image_teacher, null));
            else
                teachers.add(new Teacher(setDefaultName(), setDefaultSubject(), true, R.drawable.image_teacher, students));
        }
    }

    void fillStudents() {
        for (int i = 1; i <= 5; i++) {
            String name = setDefaultName();
            students.add(new Students(name.substring(0, name.indexOf(" ")), setDefaultStatus()));
        }
    }

    private String setDefaultStatus() {
        String[] status = {"Junior", "Strong Junior", "Middle", "Strong Middle", "Senior", "Expert"};

        return status[new Random().nextInt(status.length)];
    }

    private String setDefaultSubject() {
        String[] names = {"Math", "English", "Physics", "Biology", "Discrete math", "Geology", "Philosophy"};

        return names[new Random().nextInt(names.length)];
    }

    private String setDefaultName() {
        String[] subjects = {"Jamshid Sobirov", "Jahongir Mannonov", "Jonibek Xolmonov", "Asliddin Kenjayev", "Sardor Ergashev", "Saidahmad Ataullayev", "Javohir Karimov"};

        return subjects[new Random().nextInt(subjects.length)];
    }
}
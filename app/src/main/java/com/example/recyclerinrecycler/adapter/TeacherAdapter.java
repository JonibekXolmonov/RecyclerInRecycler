package com.example.recyclerinrecycler.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.recyclerinrecycler.R;
import com.example.recyclerinrecycler.model.Students;
import com.example.recyclerinrecycler.model.Teacher;

import java.util.ArrayList;

public class TeacherAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final static int TYPE_ITEM_VIEW = 1;
    private final static int TYPE_ITEM_LIST = 2;

    Context context;
    ArrayList<Teacher> teachers;

    public TeacherAdapter(Context context, ArrayList<Teacher> teachers) {
        this.context = context;
        this.teachers = teachers;
    }

    @Override
    public int getItemViewType(int position) {
        Teacher teacher = teachers.get(position);

        if (teacher.getStudents() != null) {
            return TYPE_ITEM_LIST;
        }
        return TYPE_ITEM_VIEW;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_ITEM_LIST) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_for_professor, parent, false);
            return new TeacherProfessorViewHolder(view);
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_for_non_professor, parent, false);
        return new TeacherNonProfessorViewHolder(view);

    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Teacher teacher = teachers.get(position);

        if (holder instanceof TeacherProfessorViewHolder) {
            ((TeacherProfessorViewHolder) holder).fullName.setText(teacher.getName());
            ((TeacherProfessorViewHolder) holder).subject.setText(teacher.getSubject());
            ((TeacherProfessorViewHolder) holder).profile.setImageResource(teacher.getProfile());

            RecyclerView recyclerView = ((TeacherProfessorViewHolder) holder).recyclerView;
            recyclerView.setLayoutManager(new GridLayoutManager(context, 1, LinearLayoutManager.HORIZONTAL, false));

            ArrayList<Students> studentsList = teacher.getStudents();
            refreshStudentAdapter(recyclerView, studentsList);
        }

        if (holder instanceof TeacherNonProfessorViewHolder) {
            ((TeacherNonProfessorViewHolder) holder).fullName.setText(teacher.getName());
            ((TeacherNonProfessorViewHolder) holder).subject.setText(teacher.getSubject());
            ((TeacherNonProfessorViewHolder) holder).profile.setImageResource(teacher.getProfile());
        }
    }

    private void refreshStudentAdapter(RecyclerView recyclerView, ArrayList<Students> studentsList) {
        StudentAdapter adapter = new StudentAdapter(context, studentsList);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public int getItemCount() {
        return teachers.size();
    }

    static class TeacherProfessorViewHolder extends RecyclerView.ViewHolder {

        public View view;
        public TextView fullName, subject;
        public ImageView profile;
        public RecyclerView recyclerView;

        public TeacherProfessorViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;

            fullName = view.findViewById(R.id.tv_teacher_full_name);
            subject = view.findViewById(R.id.tv_subject);
            profile = view.findViewById(R.id.imv_teacher_profile);
            recyclerView = view.findViewById(R.id.rv_students);
        }
    }

    static class TeacherNonProfessorViewHolder extends RecyclerView.ViewHolder {

        public View view;
        public TextView fullName, subject;
        public ImageView profile;

        public TeacherNonProfessorViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;

            fullName = view.findViewById(R.id.tv_teacher_full_name_non);
            subject = view.findViewById(R.id.tv_subject_non);
            profile = view.findViewById(R.id.imv_teacher_profile_non);
        }
    }
}


package com.example.recyclerinrecycler.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerinrecycler.R;
import com.example.recyclerinrecycler.model.Students;

import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    ArrayList<Students> students = new ArrayList<>();
    Context context;

    public StudentAdapter(Context context, ArrayList<Students> students) {
        this.students = students;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_layout, parent, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Students student = students.get(position);
        if (holder instanceof StudentViewHolder) {
            ((StudentViewHolder) holder).name.setText(student.name);
            ((StudentViewHolder) holder).description.setText(student.status);
        }
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    static class StudentViewHolder extends RecyclerView.ViewHolder {

        public View view;
        public TextView name;
        public TextView description;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            name = view.findViewById(R.id.tv_student_name);
            description = view.findViewById(R.id.tv_student_description);
        }
    }
}

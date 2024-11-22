package com.example.lab_2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TasksAdapter extends RecyclerView.Adapter<TasksAdapter.TasksViewHolder> {

    private List<Task> toDoList;

    @Override
    public int getItemCount() {
        return toDoList.size();
    }

    public TasksAdapter(List<Task> toDoList) {
        this.toDoList = toDoList;
    }

    @NonNull
    @Override
    public TasksViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tasks_item, parent, false);
        return new TasksViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TasksViewHolder holder, int position) {
        Task task = toDoList.get(position);
        holder.titleTextView.setText(task.getTitle());
        holder.timeTextView.setText(task.getTime());


        holder.doneButton.setOnClickListener(v -> {
            toDoList.remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, toDoList.size());
        });
    }

    public static class TasksViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView;
        TextView timeTextView;
        Button doneButton;

        public TasksViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.task_title);
            timeTextView = itemView.findViewById(R.id.task_time);
            doneButton = itemView.findViewById(R.id.done_button);
        }
    }
}


package com.example.aulascare.AdapterAulasCare;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aulascare.ModelClassAulasCare.AllClassesRvModalClass;
import com.example.aulascare.R;

import java.util.ArrayList;

public class AllClassBottomRecyclerAdapter extends RecyclerView.Adapter<AllClassBottomRecyclerAdapter.ViewHolder> {
    ArrayList<AllClassesRvModalClass> allClassesRvModalClasses;

    public AllClassBottomRecyclerAdapter(ArrayList<AllClassesRvModalClass> allClassesRvModalClasses) {
        this.allClassesRvModalClasses = allClassesRvModalClasses;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.all_classesbottom_recyclerview_card, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AllClassesRvModalClass currentData = allClassesRvModalClasses.get(position);
        holder.classes.setText(currentData.getClasses());

    }

    @Override
    public int getItemCount() {
        return allClassesRvModalClasses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView classes;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            classes = itemView.findViewById(R.id.classtv);
        }
    }
}

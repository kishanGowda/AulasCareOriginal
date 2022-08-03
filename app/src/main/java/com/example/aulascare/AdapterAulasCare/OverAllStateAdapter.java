package com.example.aulascare.AdapterAulasCare;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aulascare.ModelClassAulasCare.OverAllStateModel;
import com.example.aulascare.R;

import java.util.ArrayList;

public class OverAllStateAdapter extends RecyclerView.Adapter<OverAllStateAdapter.ViewHolder> {
    ArrayList<OverAllStateModel>overAllStateModels;
    public OverAllStateAdapter(ArrayList<OverAllStateModel> overAllStateModels) {
        this.overAllStateModels=overAllStateModels;

    }

    @NonNull
    @Override
    public OverAllStateAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.over_all_item,parent,false);
        ViewHolder cvh = new ViewHolder(view);
        return cvh;
    }

    @Override
    public void onBindViewHolder(@NonNull OverAllStateAdapter.ViewHolder holder, int position) {
    OverAllStateModel overAllStateModel=this.overAllStateModels.get(position);
        holder.imageForCard.setImageResource(overAllStateModel.getImageForCard());
        holder.zeroText.setText(overAllStateModel.getZeroText());
        holder.subjectText.setText(overAllStateModel.getSubjectText());
        holder.lastWeek.setVisibility(View.VISIBLE);
        if (overAllStateModel.getLastWeek().charAt(0) == '-'){
            holder.lastWeek.setTextColor(Color.parseColor("#FF414D"));
        }
//        else {
//            holder.lastWeek.setTextColor(Color.parseColor(""));
//        }
        holder.lastWeek.setText(overAllStateModel.getLastWeek());
    }

    @Override
    public int getItemCount() {
        return overAllStateModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageForCard;
        TextView zeroText,subjectText;
        TextView lastWeek;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageForCard=itemView.findViewById(R.id.imageForCard);
            zeroText=itemView.findViewById(R.id.zeroText);
            subjectText=itemView.findViewById(R.id.subjectText);
            lastWeek=itemView.findViewById(R.id.last_count_textv);

        }
    }
}

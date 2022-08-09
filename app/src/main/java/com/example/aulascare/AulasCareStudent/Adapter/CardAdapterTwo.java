package com.example.aulascare.AulasCareStudent.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aulascare.AulasCareStudent.ModelClass.Vaccine;
import com.example.aulascare.R;

import java.util.ArrayList;

public class CardAdapterTwo extends RecyclerView.Adapter<CardAdapterTwo.CardViewHolder>{

    ArrayList<Vaccine> cardInfo;

    public CardAdapterTwo(ArrayList<Vaccine> cardInfo) {
        this.cardInfo = cardInfo;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vaccine,parent,false);
        CardViewHolder cvh = new CardViewHolder(view);
        return cvh;
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        Vaccine currentVaccine = this.cardInfo.get(position);

        holder.vaccineImage.setImageResource(currentVaccine.getVaccineImageResource());
        holder.vaccineName.setText(currentVaccine.getVaccineName());
        holder.vaccineDescription.setText(currentVaccine.getVaccineDescription());

        boolean isExpanded = cardInfo.get(position).isExpanded();
        holder.expandableLayout.setVisibility(isExpanded?View.VISIBLE:View.GONE);
        holder.dropDown.animate().rotationBy(isExpanded?180:0).setDuration(400);

    }

    @Override
    public int getItemCount() {
        return cardInfo.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {

        ImageView vaccineImage;
        TextView vaccineName;
        TextView vaccineDescription;
        ImageView dropDown;
        ConstraintLayout expandableLayout;
        public CardViewHolder(@NonNull View itemView) {
            super(itemView);

            vaccineImage = itemView.findViewById(R.id.vaccineImage);
            vaccineName = itemView.findViewById(R.id.vaccineName);
            vaccineDescription = itemView.findViewById(R.id.vaccineDescription);
            expandableLayout = itemView.findViewById(R.id.expandableLayout);
            dropDown = itemView.findViewById(R.id.imgMore);
            dropDown.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                     Vaccine clickedVaccine = cardInfo.get(getAdapterPosition());
                     clickedVaccine.setExpanded(!clickedVaccine.isExpanded());
                     notifyItemChanged(getAdapterPosition());
                }
            });

        }
    }
}

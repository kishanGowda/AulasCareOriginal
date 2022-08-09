package com.example.aulascare.AulasCareStudent.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aulascare.AulasCareStudent.ModelClass.VaccineCard;
import com.example.aulascare.R;

import java.util.ArrayList;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardViewHolder> {

    ArrayList<VaccineCard> vaccineCard;

    public CardAdapter(ArrayList<VaccineCard> vaccineCard) {
        this.vaccineCard = vaccineCard;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vaccine_card,parent,false);
        CardViewHolder cvh = new CardViewHolder(view);
        return cvh;

    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        VaccineCard currentVaccineCard = this.vaccineCard.get(position);

        holder.vaccineImage.setImageResource(currentVaccineCard.getImageResource());
        holder.vaccineName.setText(currentVaccineCard.getVaccineName());
        holder.vaccineDescription.setText(currentVaccineCard.getVaccineDescription());

    }

    @Override
    public int getItemCount() {
        return vaccineCard.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {

        public ImageView vaccineImage;
        public TextView vaccineName;
        public TextView vaccineDescription;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);

            vaccineImage = itemView.findViewById(R.id.vaccineImage);
            vaccineName = itemView.findViewById(R.id.vaccineName);
            vaccineDescription = itemView.findViewById(R.id.vaccineDescription);
        }
    }
}

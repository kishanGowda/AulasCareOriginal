package com.example.aulascare.AulasCareStudent.Adapter;








import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.aulascare.AulasCareStudent.ModelClass.VaccineDrive;
import com.example.aulascare.R;

import java.util.ArrayList;

public class CardAdapterDrive extends RecyclerView.Adapter<CardAdapterDrive.CardViewHolder>
{

    ArrayList<VaccineDrive> VaccineDrives;

    public CardAdapterDrive(ArrayList<VaccineDrive> VaccineDrives)
    {
        this.VaccineDrives = VaccineDrives;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vaccinationdrive_cards,parent,false);
        CardViewHolder cardViewHolder = new CardViewHolder(view);
        return cardViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        VaccineDrive currentVaccinecardDrive = this.VaccineDrives.get(position);



        holder.vaccineReg.setText(currentVaccinecardDrive.getVaccineReg());
        holder.totalVaccines.setText(currentVaccinecardDrive.getTotalVaccines());
        holder.perDayvaccine.setText(currentVaccinecardDrive.getPerDayvaccine());


    }

    @Override
    public int getItemCount() {
        return VaccineDrives.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {

        public TextView vaccineReg;
        public TextView totalVaccines;
        public TextView perDayvaccine;


        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            vaccineReg = itemView.findViewById(R.id.vaccineReg);
            totalVaccines = itemView.findViewById(R.id.totalVaccines);
            perDayvaccine = itemView.findViewById(R.id.perDayVaccine);

        }
    }
}



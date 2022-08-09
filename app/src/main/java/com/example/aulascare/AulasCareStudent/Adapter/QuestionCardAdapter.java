package com.example.aulascare.AulasCareStudent.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.aulascare.AulasCareStudent.ModelClass.QuestionCards;
import com.example.aulascare.R;

import java.util.ArrayList;

public class QuestionCardAdapter extends RecyclerView.Adapter<QuestionCardAdapter.CardViewHolder> {
    ArrayList<QuestionCards> questionCards;

    public QuestionCardAdapter(ArrayList<QuestionCards> registrations) {
        this.questionCards = registrations;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.question_cards, parent, false);
        CardViewHolder cardViewHolder = new CardViewHolder(view);
        return cardViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        QuestionCards currentVaccineCard = this.questionCards.get(position);


        holder.vaccineImage.setImageResource(currentVaccineCard.getVaccineImage());
        holder.aboutImageInfo.setText(currentVaccineCard.getAboutImageInfo());


    }

    @Override
    public int getItemCount() {
        return questionCards.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {

        public TextView aboutImageInfo;
        public ImageView vaccineImage;


        public CardViewHolder(@NonNull View itemView) {
            super(itemView);

            vaccineImage = itemView.findViewById(R.id.vaccineImage);
            aboutImageInfo = itemView.findViewById(R.id.aboutImageInfo);


        }
    }
}



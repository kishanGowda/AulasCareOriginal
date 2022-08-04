package com.example.aulascare.AulasCareFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aulascare.R;
import com.google.android.material.card.MaterialCardView;

public class AulasCareSupport extends Fragment {

View view;
MaterialCardView faqCard,supportCard;

    public AulasCareSupport() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =inflater.inflate(R.layout.fragment_aulas_care_support, container, false);
        setUpViews();
        NavController navController = NavHostFragment.findNavController(this);

        //faq question on touch

        faqCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavDirections navDirections=AulasCareSupportDirections.actionAulasCareSupportToFsqFragment();
                navController.navigate(navDirections);
            }
        });
        supportCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavDirections navDirections= AulasCareSupportDirections.actionAulasCareSupportToSupporFragment();
                navController.navigate(navDirections);
            }
        });
        return  view;

    }

    private void setUpViews() {
        faqCard=view.findViewById(R.id.faq_card);
        supportCard=view.findViewById(R.id.support_card);
    }
}
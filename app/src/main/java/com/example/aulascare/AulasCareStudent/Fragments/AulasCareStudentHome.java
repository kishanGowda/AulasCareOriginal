package com.example.aulascare.AulasCareStudent.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aulascare.AulasCareFragment.AulasCareSupportDirections;
import com.example.aulascare.AulasCareFragment.SupporFragmentDirections;
import com.example.aulascare.R;
import com.google.android.material.card.MaterialCardView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AulasCareStudentHome#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AulasCareStudentHome extends Fragment {
    MaterialCardView faqCard,supportCard,resourse;
    View view;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AulasCareStudentHome() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AulasCareStudentHome.
     */
    // TODO: Rename and change types and number of parameters
    public static AulasCareStudentHome newInstance(String param1, String param2) {
        AulasCareStudentHome fragment = new AulasCareStudentHome();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_aulas_care_student_home, container, false);
        NavController navController = NavHostFragment.findNavController(this);
        setUpViews();


        //faq question on touch

        faqCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavDirections navDirections= AulasCareStudentHomeDirections.actionAulasCareStudentHomeToFSQFragmentStudent();
                navController.navigate(navDirections);
            }
        });

        resourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("TAG", "onClick: ");
                NavDirections navDirections= AulasCareStudentHomeDirections.actionAulasCareStudentHomeToResoureseAulasCare();
                navController.navigate(navDirections);
            }
        });

        return  view;


    }

    private void setUpViews() {
        faqCard=view.findViewById(R.id.faq_card);
        supportCard=view.findViewById(R.id.support_card);
        resourse=view.findViewById(R.id.covid);
    }


}
package com.example.aulascare.AulasCareFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aulascare.ModelClassAulasCare.Vaccine;
import com.example.aulascare.R;

import java.util.ArrayList;

public class FsqFragment extends Fragment {
    ArrayList<Vaccine> cardInfo;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager cardLayoutManager;
    RecyclerView.Adapter cardAdapter;

    View view;

    public FsqFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_fsq, container, false);

//        createCard();
//        buildRecyclerView();
        return view;
    }

//    public void createCard() {
//        cardInfo = new ArrayList<>();
//
//        cardInfo.add(new Vaccine("Covishield", "Serum Institute of India", R.drawable.seruminstitute));
//        cardInfo.add(new Vaccine("Covaxin", "Bharat Biotech", R.drawable.covaxin));
//        cardInfo.add(new Vaccine("Sputnik V", "Gamaleya", R.drawable.sputnik));
//        cardInfo.add(new Vaccine("mRNA-1273", "Moderna", R.drawable.moderna));
//        cardInfo.add(new Vaccine("ZyCoV-D", "Zydus Cadila", R.drawable.zycovid));
//        cardInfo.add(new Vaccine("Ad26.COV2.S", "Johnson & Johnson’s Janssen", R.drawable.janssen));
//        cardInfo.add(new Vaccine("AZD1222", "Oxford/AstraZeneca", R.drawable.astrazeneca));
//    }

//    public void buildRecyclerView() {
//
//        recyclerView = view.findViewById(R.id.cardRecyclerView);
//        recyclerView.setHasFixedSize(true);
//        cardLayoutManager = new LinearLayoutManager(getApplicationContext());
//        recyclerView.setLayoutManager(cardLayoutManager);
//        cardAdapter = new CardAdapter(cardInfo);
//        recyclerView.setAdapter(cardAdapter);
//
//    }
}
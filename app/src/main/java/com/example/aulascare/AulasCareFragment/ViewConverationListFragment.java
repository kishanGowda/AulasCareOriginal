package com.example.aulascare.AulasCareFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aulascare.AdapterAulasCare.ConversetionAdapter;
import com.example.aulascare.ModelClassAulasCare.ConversetionModelClass;
import com.example.aulascare.ModelClassAulasCare.OverAllStateModel;
import com.example.aulascare.R;

import java.util.ArrayList;


public class ViewConverationListFragment extends Fragment {
    View view;
    RecyclerView recyclerViewConersation;
    LinearLayoutManager linearLayoutManager;
    ConversetionAdapter conversetionAdapter;
    ArrayList<ConversetionModelClass> conversetionModelClass;


    public ViewConverationListFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_view_converation_list, container, false);

        overAllMethod();

        return  view;
    }

    private void overAllMethod() {

        conversetionModelClass=new ArrayList<>();
        conversetionModelClass.add(new ConversetionModelClass("kk","knkn","djb","jbdh","hdh","svhvx",23));
        conversetionModelClass.add(new ConversetionModelClass("kk","knkn","djb","jbdh","hdh","svhvx",23));
        conversetionModelClass.add(new ConversetionModelClass("kk","knkn","djb","jbdh","hdh","svhvx",23));
        buildRecyclerViewConversetion();

    }


    public void buildRecyclerViewConversetion() {

        recyclerViewConersation = view.findViewById(R.id.openrv);
        recyclerViewConersation.setHasFixedSize(true);
        linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerViewConersation.setLayoutManager(linearLayoutManager);
        conversetionAdapter = new ConversetionAdapter(conversetionModelClass);
        recyclerViewConersation.setAdapter(conversetionAdapter);

    }

}
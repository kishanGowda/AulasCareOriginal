package com.example.aulascare.AulasCareFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.aulascare.AdapterAulasCare.CardAdapter;
import com.example.aulascare.Api.ApiClient;
import com.example.aulascare.Api.GetCareDataAdminResponse;
import com.example.aulascare.Api.LoginService;
import com.example.aulascare.ModelClassAulasCare.Vaccine;
import com.example.aulascare.R;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class FsqFragment extends Fragment {
    ArrayList<Vaccine> cardInfo;
    RecyclerView recyclerView;
    private static final String TAG = "FsqFragment";
    RecyclerView.LayoutManager cardLayoutManager;
    CardAdapter cardAdapter;
    LoginService loginService;
    Retrofit retrofit;
    View view;

    public FsqFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_fsq, container, false);

       apiInIt();
       method();
        return view;
    }

    public void apiInIt() {
        retrofit = ApiClient.getRetrofit();
        loginService= ApiClient.getApiService();
    }

    private void method() {
       
        Call<GetCareDataAdminResponse> call=loginService.GET_CARE_DATA_ADMIN_RESPONSE_CALL();
        call.enqueue(new Callback<GetCareDataAdminResponse>() {
            @Override
            public void onResponse(Call<GetCareDataAdminResponse> call, Response<GetCareDataAdminResponse> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(getActivity(), response.code(), Toast.LENGTH_SHORT).show();
                }
                else {
                    GetCareDataAdminResponse getCareDataAdminResponse = response.body();
                    cardInfo = new ArrayList<>();
                    for (int i=0;i<=getCareDataAdminResponse.faq.size()-1;i++) {
                        cardInfo.add(new Vaccine(getCareDataAdminResponse.faq.get(i).title, getCareDataAdminResponse.faq.get(i).body));
                    }
                    buildRecyclerView();
                }
            }

            @Override
            public void onFailure(Call<GetCareDataAdminResponse> call, Throwable t) {
                Log.i(TAG, String.valueOf(t.toString()));
            }
        });
    }



    public void buildRecyclerView() {

        recyclerView = view.findViewById(R.id.faq_rv);
        recyclerView.setHasFixedSize(true);
        cardLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(cardLayoutManager);
        cardAdapter = new CardAdapter(cardInfo);
        recyclerView.setAdapter(cardAdapter);

    }
}
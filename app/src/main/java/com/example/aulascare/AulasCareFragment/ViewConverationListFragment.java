package com.example.aulascare.AulasCareFragment;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aulascare.AdapterAulasCare.ConversetionAdapter;
import com.example.aulascare.Api.ApiClient;
import com.example.aulascare.Api.GetStatusAndChatResponse;
import com.example.aulascare.Api.LoginService;
import com.example.aulascare.ModelClassAulasCare.ConversetionModelClass;
import com.example.aulascare.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class ViewConverationListFragment extends Fragment {
    View view;
    Retrofit retrofit;
    RecyclerView recyclerViewConersation,closeRv;
    LinearLayoutManager linearLayoutManager,closeLiner;
    ConversetionAdapter conversetionAdapter;
    ImageView allfilterImg;
    LoginService loginService;
    CloseAdapter closeAdapter;
    private static final String TAG = "ViewConverationListFrag";
    HashMap<String,String> query;
    LinearLayout allClassLayout;
    ArrayList<ConversetionModelClass> conversetionModelClass,closeModel;


    public ViewConverationListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_view_converation_list, container, false);
        InitViews();
        overAllMethod();
        allfilterImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allfilterBottomSheet();
            }
        });
        overAllMethod();
        apiInIt();
        mathod();
        allClassLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view = getLayoutInflater().inflate(R.layout.all_class_bottomsheet, null);
                BottomSheetDialog bt = new BottomSheetDialog(getActivity(), R.style.AppBottomSheetDialogTheme);
                bt.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                bt.setContentView(view);
                bt.setCanceledOnTouchOutside(true);
                bt.getWindow().setGravity(Gravity.BOTTOM);
                bt.setCanceledOnTouchOutside(true);
                bt.show();
            }
        });



        return view;
    }

    private void allfilterBottomSheet() {
        view = getLayoutInflater().inflate(R.layout.allfilter_bottomsheet, null);
        TextView alltv = view.findViewById(R.id.all_tv);
        TextView teacherstv = view.findViewById(R.id.teachertv);
        TextView studentstv = view.findViewById(R.id.student_tv);
        TextView data_operatortv = view.findViewById(R.id.dataoperator_tv);
        TextView operatortv = view.findViewById(R.id.Operator_tv);
        TextView plannertv = view.findViewById(R.id.Planner_tv);

        ImageView allcheck = view.findViewById(R.id.all_checkimg);
        ImageView teachercheck = view.findViewById(R.id.teacher_check);
        ImageView studentcheck = view.findViewById(R.id.student_check);
        ImageView dataOperatorCheck = view.findViewById(R.id.dataoperator_check);
        ImageView operatorcheck = view.findViewById(R.id.Operator_check);
        ImageView plannercheck = view.findViewById(R.id.Planner_check);
        BottomSheetDialog bt = new BottomSheetDialog(getActivity(), R.style.AppBottomSheetDialogTheme);
        bt.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        bt.setContentView(view);
        bt.setCanceledOnTouchOutside(true);
        bt.getWindow().setGravity(Gravity.BOTTOM);
        bt.setCanceledOnTouchOutside(true);
        bt.show();
        alltv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alltv.setTypeface(ResourcesCompat.getFont(getContext(),R.font.roboto_bold));
                teacherstv.setTypeface(ResourcesCompat.getFont(getContext(),R.font.roboto));
                studentstv.setTypeface(ResourcesCompat.getFont(getContext(),R.font.roboto));
                data_operatortv.setTypeface(ResourcesCompat.getFont(getContext(),R.font.roboto));
                operatortv.setTypeface(ResourcesCompat.getFont(getContext(),R.font.roboto));
                plannertv.setTypeface(ResourcesCompat.getFont(getContext(),R.font.roboto));
                allcheck.setVisibility(View.VISIBLE);
                teachercheck.setVisibility(View.GONE);
                studentcheck.setVisibility(View.GONE);
                dataOperatorCheck.setVisibility(View.GONE);
                operatorcheck.setVisibility(View.GONE);
                plannercheck.setVisibility(View.GONE);
            }
        });
        teacherstv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alltv.setTypeface(ResourcesCompat.getFont(getContext(),R.font.roboto));
                teacherstv.setTypeface(ResourcesCompat.getFont(getContext(),R.font.roboto_bold));
                studentstv.setTypeface(ResourcesCompat.getFont(getContext(),R.font.roboto));
                data_operatortv.setTypeface(ResourcesCompat.getFont(getContext(),R.font.roboto));
                operatortv.setTypeface(ResourcesCompat.getFont(getContext(),R.font.roboto));
                plannertv.setTypeface(ResourcesCompat.getFont(getContext(),R.font.roboto));
                allcheck.setVisibility(View.GONE);
                teachercheck.setVisibility(View.VISIBLE);
                studentcheck.setVisibility(View.GONE);
                dataOperatorCheck.setVisibility(View.GONE);
                operatorcheck.setVisibility(View.GONE);
                plannercheck.setVisibility(View.GONE);
            }
        });
        studentstv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alltv.setTypeface(ResourcesCompat.getFont(getContext(),R.font.roboto));
                teacherstv.setTypeface(ResourcesCompat.getFont(getContext(),R.font.roboto));
                studentstv.setTypeface(ResourcesCompat.getFont(getContext(),R.font.roboto_bold));
                data_operatortv.setTypeface(ResourcesCompat.getFont(getContext(),R.font.roboto));
                operatortv.setTypeface(ResourcesCompat.getFont(getContext(),R.font.roboto));
                plannertv.setTypeface(ResourcesCompat.getFont(getContext(),R.font.roboto));
                allcheck.setVisibility(View.GONE);
                teachercheck.setVisibility(View.GONE);
                studentcheck.setVisibility(View.VISIBLE);
                dataOperatorCheck.setVisibility(View.GONE);
                operatorcheck.setVisibility(View.GONE);
                plannercheck.setVisibility(View.GONE);
                allClassLayout.setVisibility(View.VISIBLE);
            }
        });
        data_operatortv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alltv.setTypeface(ResourcesCompat.getFont(getContext(),R.font.roboto));
                teacherstv.setTypeface(ResourcesCompat.getFont(getContext(),R.font.roboto));
                studentstv.setTypeface(ResourcesCompat.getFont(getContext(),R.font.roboto));
                data_operatortv.setTypeface(ResourcesCompat.getFont(getContext(),R.font.roboto_bold));
                operatortv.setTypeface(ResourcesCompat.getFont(getContext(),R.font.roboto));
                plannertv.setTypeface(ResourcesCompat.getFont(getContext(),R.font.roboto));
                allcheck.setVisibility(View.GONE);
                teachercheck.setVisibility(View.GONE);
                studentcheck.setVisibility(View.GONE);
                dataOperatorCheck.setVisibility(View.VISIBLE);
                operatorcheck.setVisibility(View.GONE);
                plannercheck.setVisibility(View.GONE);
            }
        });
        operatortv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alltv.setTypeface(ResourcesCompat.getFont(getContext(),R.font.roboto));
                teacherstv.setTypeface(ResourcesCompat.getFont(getContext(),R.font.roboto));
                studentstv.setTypeface(ResourcesCompat.getFont(getContext(),R.font.roboto));
                data_operatortv.setTypeface(ResourcesCompat.getFont(getContext(),R.font.roboto));
                operatortv.setTypeface(ResourcesCompat.getFont(getContext(),R.font.roboto_bold));
                plannertv.setTypeface(ResourcesCompat.getFont(getContext(),R.font.roboto));
                allcheck.setVisibility(View.GONE);
                teachercheck.setVisibility(View.GONE);
                studentcheck.setVisibility(View.GONE);
                dataOperatorCheck.setVisibility(View.GONE);
                operatorcheck.setVisibility(View.VISIBLE);
                plannercheck.setVisibility(View.GONE);
            }
        });
        plannertv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alltv.setTypeface(ResourcesCompat.getFont(getContext(),R.font.roboto));
                teacherstv.setTypeface(ResourcesCompat.getFont(getContext(),R.font.roboto));
                studentstv.setTypeface(ResourcesCompat.getFont(getContext(),R.font.roboto));
                data_operatortv.setTypeface(ResourcesCompat.getFont(getContext(),R.font.roboto));
                operatortv.setTypeface(ResourcesCompat.getFont(getContext(),R.font.roboto));
                plannertv.setTypeface(ResourcesCompat.getFont(getContext(),R.font.roboto_bold));
                allcheck.setVisibility(View.GONE);
                teachercheck.setVisibility(View.GONE);
                studentcheck.setVisibility(View.GONE);
                dataOperatorCheck.setVisibility(View.GONE);
                operatorcheck.setVisibility(View.GONE);
                plannercheck.setVisibility(View.VISIBLE);
            }
        });
    }

    private void InitViews() {
        allfilterImg = view.findViewById(R.id.allfilterImg);
        allClassLayout = view.findViewById(R.id.allClasses_layout);

    }
    public void apiInIt() {
        retrofit = ApiClient.getRetrofit();
        loginService= ApiClient.getApiService();
    }


    private void overAllMethod() {

//        conversetionModelClass = new ArrayList<>();
//        conversetionModelClass.add(new ConversetionModelClass("kk", "knkn", "djb", "jbdh", "hdh", "svhvx", 23));
//        conversetionModelClass.add(new ConversetionModelClass("kk", "knkn", "djb", "jbdh", "hdh", "svhvx", 23));
//        conversetionModelClass.add(new ConversetionModelClass("kk", "knkn", "djb", "jbdh", "hdh", "svhvx", 23));
//        buildRecyclerViewConversetion();

    }


    public void buildRecyclerViewConversetion() {

        recyclerViewConersation = view.findViewById(R.id.openrv);
        recyclerViewConersation.setHasFixedSize(true);
        linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerViewConersation.setLayoutManager(linearLayoutManager);
        conversetionAdapter = new ConversetionAdapter(conversetionModelClass);
        recyclerViewConersation.setAdapter(conversetionAdapter);

    }

    public void buildRecyclerViewConversetionClose() {

        closeRv = view.findViewById(R.id.closerv);
         closeRv.setHasFixedSize(true);
        closeLiner = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
         closeRv.setLayoutManager(closeLiner);
        closeAdapter = new CloseAdapter(closeModel);
         closeRv.setAdapter(closeAdapter);

    }


    private void mathod() {
        query=new HashMap<>();

        Call<GetStatusAndChatResponse> call=loginService.GET_STATUS_AND_CHAT_RESPONSE_CALL(query);
        call.enqueue(new Callback<GetStatusAndChatResponse>() {
            @Override
            public void onResponse(Call<GetStatusAndChatResponse> call, Response<GetStatusAndChatResponse> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(getActivity(), response.code(), Toast.LENGTH_SHORT).show();
                }
                else {
                    GetStatusAndChatResponse getStatusAndChatResponse= response.body();
                    if(getStatusAndChatResponse.onlyOpen!=null){
                        conversetionModelClass = new ArrayList<>();
                        for (int i=0;i<=getStatusAndChatResponse.onlyOpen.size()-1;i++) {
                            conversetionModelClass.add(new ConversetionModelClass(getStatusAndChatResponse.onlyOpen.get(i).user_name, getStatusAndChatResponse.onlyOpen.get(i).user_role, String.valueOf(getStatusAndChatResponse.onlyOpen.get(i).userId), getStatusAndChatResponse.onlyOpen.get(i).createdAt, getStatusAndChatResponse.onlyOpen.get(i).user_image,getStatusAndChatResponse.onlyOpen.get(i).message , 23));
                        }
                        buildRecyclerViewConversetion();
                    }


                    if(getStatusAndChatResponse.onlyClose!=null){
                        closeModel = new ArrayList<>();
                        for (int i=0;i<=getStatusAndChatResponse.onlyClose.size()-1;i++) {
                            closeModel.add(new ConversetionModelClass(getStatusAndChatResponse.onlyClose.get(i).user_name, getStatusAndChatResponse.onlyClose.get(i).user_role, String.valueOf(getStatusAndChatResponse.onlyClose.get(i).userId), getStatusAndChatResponse.onlyClose.get(i).createdAt, getStatusAndChatResponse.onlyClose.get(i).user_image,getStatusAndChatResponse.onlyClose.get(i).message , 23));
                            Log.i(TAG, "onResponse: "+i);
                        }
                        buildRecyclerViewConversetionClose();
                    }

                }
            }

            @Override
            public void onFailure(Call<GetStatusAndChatResponse> call, Throwable t) {
                Log.i(TAG, String.valueOf(t.toString()));
            }
        });
    }


}
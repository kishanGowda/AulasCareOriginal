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
import android.widget.TextView;

import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aulascare.AdapterAulasCare.ConversetionAdapter;
import com.example.aulascare.AdapterAulasCare.OverAllStateAdapter;
import com.example.aulascare.Api.ApiClient;
import com.example.aulascare.Api.GetUserDetailsResponse;
import com.example.aulascare.Api.GetUserDetailsResponse;
import com.example.aulascare.Api.LoginService;
import com.example.aulascare.ModelClassAulasCare.ConversetionModelClass;
import com.example.aulascare.ModelClassAulasCare.OverAllStateModel;
import com.example.aulascare.ModelClassAulasCare.Vaccine;
import com.example.aulascare.R;
import com.example.aulascare.XYMarkerView;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.MPPointF;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.card.MaterialCardView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SupporFragment extends Fragment implements OnChartValueSelectedListener {


    View view;
    TextView viewAllText;
    BarChart mChart;
    GetUserDetailsResponse g;

    //
    // variable for our bar data set.
    BarDataSet barDataSet1, barDataSet2;
    // array list for storing entries.
    ArrayList barEntries;


    private static final String TAG = "SupporFragment";
    ImageView timefilter;
    RecyclerView recyclerView, recyclerViewConersation;
    MaterialCardView noSubject;
    LinearLayoutManager linearLayoutManager;
    OverAllStateAdapter adapter;
    ArrayList<ConversetionModelClass> conversetionModelClass;
    ConversetionAdapter conversetionAdapter;
    ArrayList<OverAllStateModel> overAllStateModels;
    LoginService loginService;
    Retrofit retrofit;
    ArrayList<String> labels;

    HashMap<String, String> query;

    public SupporFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_suppor, container, false);
        initViews();

        apiInIt();
        method();
        methodForBarGraph();



        overAllMethod();
        groupBarChart();

        int number = 100000000;
        double amounts = Double.parseDouble(String.valueOf(number));
        DecimalFormat formatter = new DecimalFormat("#,###.00");
        String ff = String.valueOf(formatter.format(amounts));
        Log.i(TAG, "onCreateView: " + ff);

        String k = "kishan";
        k = k.substring(1);
        Log.i(TAG, "onCreateView: " + k);
        timefilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               filterbottomsheet();
            }
        });
        NavController navController = NavHostFragment.findNavController(this);
        viewAllText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavDirections navDirections = SupporFragmentDirections.actionSupporFragmentToViewConverationListFragment();
                navController.navigate(navDirections);
            }
        });

        return view;
    }

    private void filterbottomsheet() {
        view = getLayoutInflater().inflate(R.layout.week_bottomsheet, null);
        TextView week = view.findViewById(R.id.o_week);
        TextView month = view.findViewById(R.id.o_month);
        ImageView weekTick = view.findViewById(R.id.week_tick);
        ImageView monthTick = view.findViewById(R.id.month_tick);
        BottomSheetDialog bt = new BottomSheetDialog(getActivity(), R.style.AppBottomSheetDialogTheme);
        bt.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        bt.setContentView(view);
        bt.setCanceledOnTouchOutside(true);
        bt.getWindow().setGravity(Gravity.BOTTOM);
        bt.setCanceledOnTouchOutside(true);
        bt.show();
        week.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                week.setTypeface(ResourcesCompat.getFont(getContext(),R.font.roboto_bold));
                month.setTypeface(ResourcesCompat.getFont(getContext(),R.font.roboto));
                weekTick.setVisibility(View.VISIBLE);
                monthTick.setVisibility(View.GONE);
            }
        });
        month.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                week.setTypeface(ResourcesCompat.getFont(getContext(),R.font.roboto));
                month.setTypeface(ResourcesCompat.getFont(getContext(),R.font.roboto_bold));
                weekTick.setVisibility(View.VISIBLE);
                monthTick.setVisibility(View.GONE);
            }
        });
    }

    private void initViews() {
        noSubject = view.findViewById(R.id.nodata);
        viewAllText = view.findViewById(R.id.viewall);
        mChart = view.findViewById(R.id.barchart);
        timefilter = view.findViewById(R.id.t_filter);

    }

    public void groupBarChart() {
        mChart = view.findViewById(R.id.barchart);
        mChart.setDrawBarShadow(false);
        mChart.getDescription().setEnabled(false);
        mChart.setPinchZoom(false);
        mChart.setTouchEnabled(true);
        mChart.setDrawGridBackground(false);
        mChart.setBackgroundColor(Color.WHITE);
        mChart.setDrawGridBackground(false);

        public void groupBarChart() {
            barDataSet1 = new BarDataSet(getBarEntriesOne(), "Live Classes Scheduled");
            barDataSet1.setColor(Color.parseColor("#99DED9"));
            barDataSet2 = new BarDataSet(getBarEntriesTwo(), "Completed");
            barDataSet2.setColor(Color.parseColor("#B2DFFF"));
//            barDataSet3 = new BarDataSet(getBarEntriesThree(), "Cancelled");
//            barDataSet3.setColor(Color.parseColor("#AEAEAE"));

            // below line is to add bar data set to our bar data.
            BarData data = new BarData(barDataSet1, barDataSet2);

            // after adding data to our bar data we
            // are setting that data to our bar chart.
            mChart.setData(data);

            // below line is to remove description
            // label of our bar chart.
            mChart.getDescription().setEnabled(false);

            // below line is to get x axis
            // of our bar chart.
            XAxis xAxis = mChart.getXAxis();

            // below line is to set value formatter to our x-axis and
            // we are adding our days to our x axis.
            xAxis.setValueFormatter(new IndexAxisValueFormatter(labels));

            // below line is to set center axis
            // labels to our bar chart.
            xAxis.setCenterAxisLabels(true);

            // below line is to set position
            // to our x-axis to bottom.

            xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
            // below line is to set granularity
            // to our x axis labels.
            xAxis.setGranularity(1);
            xAxis.setDrawGridLines(false);

            // below line is to enable
            // granularity to our x axis.
            xAxis.setGranularityEnabled(true);

            // below line is to make our
            // bar chart as draggable.
            mChart.setDragEnabled(true);

            // below line is to make visible
            // range for our bar chart.
            mChart.setVisibleXRangeMaximum(4);

            // below line is to add bar
            // space to our chart.
            float barSpace = 0f;

            // below line is use to add group
            // spacing to our bar chart.
            float groupSpace = 0.60f;

            // we are setting width of
            // bar in below line.
            data.setBarWidth(0.20f);

            // below line is to set minimum
            // axis to our chart.
            mChart.getXAxis().setAxisMinimum(0);

            // below line is to
            // animate our chart.
            mChart.animate();

            // below line is to group bars
            // and add spacing to it.
            mChart.groupBars(0, groupSpace, barSpace);

            // below line is to invalidate
            // our bar chart.
            mChart.invalidate();

            XYMarkerView mv = new XYMarkerView(getContext(),new IndexAxisValueFormatter() );
            mv.setChartView(mChart); // For bounds control
            mChart.setMarker(mv);

        }

        private ArrayList<BarEntry> getBarEntriesOne() {

            // creating a new array list
            barEntries = new ArrayList<>();

            // adding new entry to our array list with bar
            // entry and passing x and y axis value to it.
            for (int i = 0; i < g.summary.size(); i++) {
                barEntries.add(new BarEntry(Float.parseFloat(i + "f"), g.summary.get(i).closeCount));
            }

            return barEntries;
        }

        // array list for second set.
        private ArrayList<BarEntry> getBarEntriesTwo() {

            // creating a new array list
            barEntries = new ArrayList<>();

            // adding new entry to our array list with bar
            // entry and passing x and y axis value to it.
            for (int i = 0; i < g.summary.size(); i++) {
                barEntries.add(new BarEntry(Float.parseFloat(i + "f"), g.summary.get(i).openCount));
            }
            return barEntries;
        }










    public void buildRecyclerView() {

        recyclerView = view.findViewById(R.id.rview);
        recyclerView.setHasFixedSize(true);
        linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new OverAllStateAdapter(overAllStateModels);
        recyclerView.setAdapter(adapter);

    }

    public void buildRecyclerViewConversetion() {

        recyclerViewConersation = view.findViewById(R.id.rview_conver);
        recyclerViewConersation.setHasFixedSize(true);
        linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerViewConersation.setLayoutManager(linearLayoutManager);
        conversetionAdapter = new ConversetionAdapter(conversetionModelClass);
        recyclerViewConersation.setAdapter(conversetionAdapter);

    }

    ;

    @Override
    public void onValueSelected(Entry e, Highlight h) {
        if (e == null)
            return;
        mChart.getBarBounds((BarEntry) e);
        MPPointF position = mChart.getPosition(e, YAxis.AxisDependency.LEFT);
        Log.i("position", position.toString());

        Log.i("x-index",
                "low: " + mChart.getLowestVisibleX() + ", high: "
                        + mChart.getHighestVisibleX());

        MPPointF.recycleInstance(position);
    }

    @Override
    public void onNothingSelected() {

    }


    public void apiInIt() {
        retrofit = ApiClient.getRetrofit();
        loginService= ApiClient.getApiService();
    }

    private void method() {
    query=new HashMap<>();
        Call<GetUserDetailsResponse> call=loginService.GET_USER_DETAILS_RESPONSE_CALL(query);
        call.enqueue(new Callback<GetUserDetailsResponse>() {
            @Override
            public void onResponse(Call<GetUserDetailsResponse> call, Response<GetUserDetailsResponse> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(getActivity(), response.code(), Toast.LENGTH_SHORT).show();
                }
                else {
                    GetUserDetailsResponse getCareDataAdminResponse = response.body();

                    overAllStateModels=new ArrayList<>();
                    overAllStateModels.add(new OverAllStateModel(R.drawable.chat, String.valueOf(getCareDataAdminResponse.totalCount), "Total conversations", String.valueOf(String.valueOf(getCareDataAdminResponse.lastweekTotalCount) + "  From last week")));
                    overAllStateModels.add(new OverAllStateModel(R.drawable.closedconversations, String.valueOf(getCareDataAdminResponse.closeCount), "Closed conversations", String.valueOf(String.valueOf(getCareDataAdminResponse.lastWeekCloseCount)+ "  From last week")));
                    overAllStateModels.add(new OverAllStateModel(R.drawable.openconversations, String.valueOf(getCareDataAdminResponse.openCount), "Open conversations", String.valueOf(String.valueOf(getCareDataAdminResponse.lastWeekOpenCount)+ "  From last week")));
                    buildRecyclerView();

                    if(getCareDataAdminResponse.details!=null){
                        conversetionModelClass=new ArrayList<>();
                        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm aa");
                        labels = new ArrayList<>() ;
                        for (int i=0;i<=getCareDataAdminResponse.details.size()-1;i++){
                            conversetionModelClass.add(new ConversetionModelClass(getCareDataAdminResponse.details.get(i).user_name,getCareDataAdminResponse.details.get(i).user_role,"djb",getCareDataAdminResponse.details.get(i).chat_createdAt,getCareDataAdminResponse.details.get(i).user_image,"svhvx",23));

                        }
                        buildRecyclerViewConversetion();
                    }

                }
            }

            @Override
            public void onFailure(Call<GetUserDetailsResponse> call, Throwable t) {
                Log.i(TAG, String.valueOf(t.toString()));
            }
        });
    }

    private void methodForBarGraph() {
        query=new HashMap<>();
        query.put("type","month");
        Call<GetUserDetailsResponse> call=loginService.GET_USER_DETAILS_RESPONSE_CALL(query);
        call.enqueue(new Callback<GetUserDetailsResponse>() {
            @Override
            public void onResponse(Call<GetUserDetailsResponse> call, Response<GetUserDetailsResponse> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(getActivity(), response.code(), Toast.LENGTH_SHORT).show();
                }
               else {
                   g=response.body();
                    if (g.summary != null) {
                        labels=new ArrayList<>();
                        try{
                            for (int i=0;i<=g.summary.size()-1;i++){
                                labels.add(g.summary.get(i).month);
                                groupBarChart();
                            }

                        }catch (Exception e){
                            Log.i(TAG, "onResponse: "+e.getMessage());
                        }
                    }
                }
  }

            @Override
            public void onFailure(Call<GetUserDetailsResponse> call, Throwable t) {
                Log.i(TAG, String.valueOf(t.toString()));
            }
        });
    }

}
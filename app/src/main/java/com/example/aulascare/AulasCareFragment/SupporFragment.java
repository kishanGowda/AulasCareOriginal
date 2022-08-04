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

import com.example.aulascare.AdapterAulasCare.ConversetionAdapter;
import com.example.aulascare.AdapterAulasCare.OverAllStateAdapter;
import com.example.aulascare.ModelClassAulasCare.ConversetionModelClass;
import com.example.aulascare.ModelClassAulasCare.OverAllStateModel;
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
import java.util.ArrayList;

public class SupporFragment extends Fragment implements OnChartValueSelectedListener {


    View view;
    TextView viewAllText;
    BarChart mChart;
    private static final String TAG = "SupporFragment";
    ImageView timefilter;
    RecyclerView recyclerView, recyclerViewConersation;
    MaterialCardView noSubject;
    LinearLayoutManager linearLayoutManager;
    OverAllStateAdapter adapter;
    ArrayList<ConversetionModelClass> conversetionModelClass;
    ConversetionAdapter conversetionAdapter;
    ArrayList<OverAllStateModel> overAllStateModels;

    public SupporFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_suppor, container, false);
        initViews();

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


        mChart.setDrawBarShadow(false);
        mChart.setDrawValueAboveBar(true);


        String[] labels = {"11/07", "12/07", "13/07", "14/07", "15/07", "16/07", "17/07", ""};
        XAxis xAxis = mChart.getXAxis();
        xAxis.setCenterAxisLabels(true);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(true);
        xAxis.setTextColor(Color.BLACK);
        xAxis.setTextSize(12);
        xAxis.setAxisLineColor(Color.WHITE);
        xAxis.setAxisMinimum(1f);
        xAxis.setValueFormatter(new IndexAxisValueFormatter(labels));

        YAxis leftAxis = mChart.getAxisLeft();
        leftAxis.setTextColor(Color.BLACK);
        leftAxis.setTextSize(12);
        leftAxis.setAxisLineColor(Color.WHITE);
        leftAxis.setDrawGridLines(true);
        leftAxis.setGranularity(2);
        leftAxis.setLabelCount(8, true);
        leftAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);

        mChart.getAxisRight().setEnabled(true);
        mChart.getLegend().setEnabled(true);

        float[] valOne = {40, 40, 40, 82, 60};
        float[] valTwo = {25, 25, 45, 20, 20};


        ArrayList<BarEntry> barOne = new ArrayList<>();
        ArrayList<BarEntry> barTwo = new ArrayList<>();

        for (int i = 0; i < valOne.length; i++) {
            barOne.add(new BarEntry(i, valOne[i]));
            barTwo.add(new BarEntry(i, valTwo[i]));
//            barThree.add(new BarEntry(i, valThree[i]));
        }

        BarDataSet set1 = new BarDataSet(barOne, "barOne");
        set1.setColor(Color.argb(250, 152, 118, 230));
        BarDataSet set2 = new BarDataSet(barTwo, "barTwo");
        set2.setColor(Color.rgb(16, 137, 255));
//        BarDataSet set3 = new BarDataSet(barThree, "barTwo");
//        set3.setColor(Color.RED);

        set1.setHighlightEnabled(true);
        set2.setHighlightEnabled(true);
        // set3.setHighlightEnabled(true);
        set1.setDrawValues(true);
        set2.setDrawValues(true);
        //  set3.setDrawValues(true);

        ArrayList<IBarDataSet> dataSets = new ArrayList<IBarDataSet>();
        dataSets.add(set1);
        dataSets.add(set2);
        //   dataSets.add(set3);
        BarData data = new BarData(dataSets);
        float groupSpace = 0.2f;
        float barSpace = 0f;
        float barWidth = 0.3f;
        // (barSpace + barWidth) * 2 + groupSpace = 1
        data.setBarWidth(barWidth);
        // so that the entire chart is shown when scrolled from right to left
        xAxis.setAxisMaximum(labels.length - 0.5f);
        mChart.setData(data);
        mChart.setScaleEnabled(false);
        mChart.setVisibleXRangeMaximum(7f);
        mChart.groupBars(1f, groupSpace, barSpace);
        mChart.invalidate();


        XYMarkerView mv = new XYMarkerView(getContext(), new IndexAxisValueFormatter());
        mv.setChartView(mChart); // For bounds control
        mChart.setMarker(mv);

    }


    private void overAllMethod() {
        overAllStateModels = new ArrayList<>();
        overAllStateModels.add(new OverAllStateModel(R.drawable.chat, "0", "Total conversations", String.valueOf(-0 + "  From last week")));
        overAllStateModels.add(new OverAllStateModel(R.drawable.closedconversations, "0", "Closed conversations", String.valueOf(0 + "  From last week")));
        overAllStateModels.add(new OverAllStateModel(R.drawable.openconversations, "0", "Open conversations", String.valueOf(10 + "  From last week")));
        buildRecyclerView();

        conversetionModelClass = new ArrayList<>();
        conversetionModelClass.add(new ConversetionModelClass("kk", "knkn", "djb", "jbdh", "hdh", "svhvx", 23));
        conversetionModelClass.add(new ConversetionModelClass("kk", "knkn", "djb", "jbdh", "hdh", "svhvx", 23));
        conversetionModelClass.add(new ConversetionModelClass("kk", "knkn", "djb", "jbdh", "hdh", "svhvx", 23));
        buildRecyclerViewConversetion();

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
}
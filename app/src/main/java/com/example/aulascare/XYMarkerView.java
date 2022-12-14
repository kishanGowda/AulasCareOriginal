package com.example.aulascare;

import android.content.Context;
import android.widget.TextView;

import com.github.mikephil.charting.components.MarkerView;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.utils.MPPointF;

import java.text.DecimalFormat;

public class XYMarkerView extends MarkerView {

    private final TextView tvContent;
    private final TextView submit;
    private final TextView overDue;
    private final ValueFormatter xAxisValueFormatter;

    private final DecimalFormat format;

    public XYMarkerView(Context context, ValueFormatter xAxisValueFormatter) {
        super(context, R.layout.custom_marker_view);

        this.xAxisValueFormatter = xAxisValueFormatter;
        tvContent = findViewById(R.id.tvContent);
        submit=findViewById(R.id.submit_tv);
        overDue=findViewById(R.id.overDue);

        format = new DecimalFormat("###.0");
    }

    // runs every time the MarkerView is redrawn, can be used to update the
    // content (user-interface)
    @Override
    public void refreshContent(Entry e, Highlight highlight) {

//        tvContent.setText(String.format("Name: %s, Value: %s", xAxisValueFormatter.getFormattedValue(e.getX()), format.format(e.getY())));

        tvContent.setText(String.format(" DUE FOR SUBMISSION: %s", format.format(e.getY())));
        submit.setText(String.format("SUBMITTED    : %s",format.format(e.getY())));
       // overDue.setText(String.format("SUBMITTED   : %s",format.format(e.getY())));



        super.refreshContent(e, highlight);
    }

    @Override
    public MPPointF getOffset() {
        return new MPPointF(-(getWidth() / 2), -getHeight());
    }
}


package com.example.aulascare.AdapterAulasCare;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aulascare.ModelClassAulasCare.ConversetionModelClass;
import com.example.aulascare.R;

import java.util.ArrayList;

public class ConversetionAdapter extends RecyclerView.Adapter<ConversetionAdapter.ViewHolder> {
    ArrayList<ConversetionModelClass>conversetionModelClass;


    public ConversetionAdapter(ArrayList<ConversetionModelClass> conversetionModelClass) {
        this.conversetionModelClass=conversetionModelClass;
    }


    @NonNull
    @Override
    public ConversetionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.conversetion_item,parent,false);
    ViewHolder cvh = new ViewHolder(view);
        return cvh;
    }

    @Override
    public void onBindViewHolder(@NonNull ConversetionAdapter.ViewHolder holder, int position) {
    ConversetionModelClass conversetionModelClass=this.conversetionModelClass.get(position);
    holder.number.setText(conversetionModelClass.getNotificationNumber());
    holder.title.setText(conversetionModelClass.getTitle());
    holder.message.setText(conversetionModelClass.getSubTitle());
    holder.views.setText(conversetionModelClass.getViews());
    holder.time.setText(conversetionModelClass.getTime());
    }

    @Override
    public int getItemCount() {
        return conversetionModelClass.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView title,message,views,time,number;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.title);
            message=itemView.findViewById(R.id.subtitle);
            views=itemView.findViewById(R.id.view);
            time=itemView.findViewById(R.id.time);
            number=itemView.findViewById(R.id.number);
        }
    }


}

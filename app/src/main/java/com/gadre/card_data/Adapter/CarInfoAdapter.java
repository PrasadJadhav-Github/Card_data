package com.gadre.card_data.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gadre.card_data.Activities.CarDetailsActivity;
import com.gadre.card_data.Model.CarInfo;
import com.gadre.card_data.R;

import java.io.Serializable;
import java.util.List;

public class CarInfoAdapter extends RecyclerView.Adapter<CarInfoAdapter.DisplayCarViewModel> {
    private List<CarInfo> carInfoList;
    private Context context;

    public  CarInfoAdapter(List<CarInfo>carInfos,Context context){
        this.carInfoList=carInfos;
        this.context = context;
    }
    @NonNull
    @Override
    public CarInfoAdapter.DisplayCarViewModel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.carinfo_itemview,parent,false);
        return new DisplayCarViewModel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarInfoAdapter.DisplayCarViewModel holder, int position) {
    CarInfo carInfo =carInfoList.get(position);
        holder.idTextView.setText("ID: " + carInfo.getId());
        holder.markTextView.setText("Make: " + carInfo.getMake());
        holder.modelTextView.setText("Model: " + carInfo.getModel());
        holder.colorTextView.setText("Color: " + carInfo.getColor());

        holder.itemView.setOnClickListener(v->{
            Intent intent =new Intent(context, CarDetailsActivity.class);
            intent.putExtra("car_info",  carInfo);
            context.startActivity(intent);

        });

    }

    @Override
    public int getItemCount() {
        return carInfoList.size();
    }

    public class DisplayCarViewModel extends RecyclerView.ViewHolder {
        TextView idTextView;
        TextView markTextView;
        TextView modelTextView;
        TextView colorTextView;

        public DisplayCarViewModel(@NonNull View itemView) {
            super(itemView);
            idTextView =itemView.findViewById(R.id.idTextView);
            markTextView=itemView.findViewById(R.id.markTextView);
            modelTextView=itemView.findViewById(R.id.modelTextView);
            colorTextView=itemView.findViewById(R.id.colorTextView);
        }
    }
}

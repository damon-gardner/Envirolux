package edu.donnelly.nicholas.envirolux;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GeoAreaAdapter extends RecyclerView.Adapter<GeoAreaAdapter.ViewHolder> {

    EpaGeoAreaData[] epaGeoAreaData;

    GeoAreaAdapter(EpaGeoAreaData[] epaGeoAreaData) {
        this.epaGeoAreaData = epaGeoAreaData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View waterSuppliersView = inflater.inflate(R.layout.ll_water_suppliers, parent, false);
        ViewHolder viewHolder = new ViewHolder(waterSuppliersView, context);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d("EPA", "VH");
        EpaGeoAreaData epaGeoAreaDataItem = epaGeoAreaData[position];
        holder.tvWaterSuppliers.setText(epaGeoAreaDataItem.PWSID);
    }

    @Override
    public int getItemCount() {
        return epaGeoAreaData.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public LinearLayout llWaterSuppliers;
        public TextView tvWaterSuppliers;

        public ViewHolder(@NonNull View itemView, Context context) {
            super(itemView);
            llWaterSuppliers = (LinearLayout) itemView.findViewById(R.id.tv_ll_water_supplier);
            tvWaterSuppliers = (TextView) itemView.findViewById(R.id.textview);

           // this.context = context;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v)  {
            //TODO: Start the WaterViolation activity and pass it the pswid
            Log.d("EPA", "TESTING Onclick" + tvWaterSuppliers.getText().toString());
        }
    }

}


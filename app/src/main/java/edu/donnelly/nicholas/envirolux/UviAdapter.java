package edu.donnelly.nicholas.envirolux;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UviAdapter extends RecyclerView.Adapter<UviAdapter.ViewHolder> {

    EpaUviData[] uviData;
    String[] colorIndex = {"#FFFFFFFF","#C8E6C9", "#A5D6A7", "#FFF176", "#FFEE58", "#FFD600",
                           "#FB8C00", "#C62828", "#B71C1C", "#D50000", "#C51162"};

    public UviAdapter(EpaUviData[] uviData) {
        this.uviData = uviData;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View uviView = inflater.inflate(R.layout.ll_uvi, parent, false);
        ViewHolder viewHolder = new ViewHolder(uviView, context);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
         EpaUviData epaUviItem = uviData[position];
         holder.tvUviTime.setText(epaUviItem.getTime());
         holder.tvUviDate.setText(epaUviItem.getDay());
         holder.tvUviIndex.setText(epaUviItem.getUViIndex());
         holder.llUvi.setBackgroundColor(Color.parseColor(colorIndex[epaUviItem.UV_VALUE]));
    }

    @Override
    public int getItemCount() {
        return uviData.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public LinearLayout llUvi;
        public TextView tvUviTime;
        public TextView tvUviIndex;
        public TextView tvUviDate;
        Context context;

        public ViewHolder(@NonNull View itemView, Context context) {
            super(itemView);
            llUvi = (LinearLayout) itemView.findViewById(R.id.ll_uvi_view);
            tvUviTime = (TextView) itemView.findViewById(R.id.tv_uvi_time);
            tvUviDate = (TextView) itemView.findViewById(R.id.tv_uvi_date);
            tvUviIndex = (TextView) itemView.findViewById(R.id.tv_uvi_index);
            this.context = context;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            //TODO: Start an activity to display EPA Precautions
            Log.d("EPA", "TESTING Onclick");
            FragmentManager fm = ((FragmentActivity)context).getSupportFragmentManager();
            int index = Integer.parseInt(tvUviIndex.getText().toString());
            String message = EpaUviData.getProtectionMessage(index);
            UviDialogFragment alertDialog = UviDialogFragment.newInstance(message);
            alertDialog.show(fm, "test");
        }
    }
}

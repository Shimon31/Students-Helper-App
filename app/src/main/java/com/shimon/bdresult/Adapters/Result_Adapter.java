package com.shimon.bdresult.Adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.shimon.bdresult.R;
import com.shimon.bdresult.model.ResultCard;
import com.shimon.bdresult.view.activity.MainActivity;
import com.shimon.bdresult.view.activity.webViewActivity;
import com.shimon.bdresult.view.utils.Constant;

import java.util.List;

public class Result_Adapter extends RecyclerView.Adapter<Result_Adapter.ViewHolder> {

    List<ResultCard> resultCardList;
    Context context;

    public Result_Adapter(List<ResultCard> resultCardList, Context context) {
        this.resultCardList = resultCardList;
        this.context = context;
    }

    @NonNull
    @Override
    public Result_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.model_design_result_card, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Result_Adapter.ViewHolder holder, int position) {
         ResultCard resultCard = resultCardList.get(position);
         holder.cardView.setCardBackgroundColor(resultCard.getColor());
         holder.imageView.setImageDrawable(resultCard.getImageView());
         holder.titleTv.setText(resultCard.getTitle());

         holder.itemView.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 if (isOnline()){
                     OpenView(resultCard.getSiteLink());
                 }
                 else{
                     showPopupMessage();
                 }
             }
         });

    }

    private void OpenView(String siteURL) {
        Intent intent = new Intent(context, webViewActivity.class);
        intent.putExtra(Constant.URL,siteURL);
        context.startActivity(intent);
    }

    private void showPopupMessage() {
        new AlertDialog.Builder(context)
                .setTitle("No Internet..")
                .setMessage("Please check your internet connection...!")
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .setNegativeButton("Cancel", null)
                .setIcon(R.drawable.ic_baseline_signal_wifi_connected_no_internet_4_24)
                .show();
    }

    private boolean isOnline() {

        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        return networkInfo != null && networkInfo.isConnectedOrConnecting();

    }

    @Override
    public int getItemCount() {
        return resultCardList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        CardView cardView;
        TextView titleTv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.modelImageView);
            cardView = itemView.findViewById(R.id.modelCardView);
            titleTv = itemView.findViewById(R.id.modelTextView);
        }
    }
}


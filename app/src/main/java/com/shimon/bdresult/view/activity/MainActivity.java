package com.shimon.bdresult.view.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.shimon.bdresult.Adapters.Result_Adapter;
import com.shimon.bdresult.R;
import com.shimon.bdresult.model.ResultCard;
import com.shimon.bdresult.view.utils.Constant;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<ResultCard> resultCardList;
    private Result_Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
        setData();


    }


    private void setData() {

        resultCardList.add(new ResultCard(getResources().getDrawable(R.drawable.psc), Color.parseColor("#1C8D73"), Constant.PSC_TITLE, Constant.PSC_RESULT));
        resultCardList.add(new ResultCard(getResources().getDrawable(R.drawable.psc), Color.parseColor("#CDC25C"), Constant.PDC_Title, Constant.PSC_PDC_Site));
        resultCardList.add(new ResultCard(getResources().getDrawable(R.drawable.jsc), Color.parseColor("#FF6263"), Constant.JSC_TITLE, Constant.JSC_RESULT));
        resultCardList.add(new ResultCard(getResources().getDrawable(R.drawable.jsc), Color.parseColor("#207398"), Constant.SSC_TITLE, Constant.SSC_RESULT));
        resultCardList.add(new ResultCard(getResources().getDrawable(R.drawable.jsc), Color.parseColor("#50DBB4"), Constant.HSC_TITLE, Constant.HSC_RESULT));
        resultCardList.add(new ResultCard(getResources().getDrawable(R.drawable.nu), Color.parseColor("#8D3DAF"), Constant.NU_TITLE, Constant.NU_RESULT));
        resultCardList.add(new ResultCard(getResources().getDrawable(R.drawable.poly), Color.parseColor("#6A1B4D"), Constant.BEBT_TITLE, Constant.BEBT_RESULT));
        resultCardList.add(new ResultCard(getResources().getDrawable(R.drawable.mbbs), Color.parseColor("#242B2E"), Constant.MBBS_TITLE, Constant.MBBS_RESULT));
        adapter.notifyDataSetChanged();


    }

    private void initialize() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        resultCardList = new ArrayList<>();
        adapter = new Result_Adapter(resultCardList, this);
        recyclerView.setAdapter(adapter);
    }


/*    private void showPopupMessage() {
        new AlertDialog.Builder(this)
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


    public void openPSCWebView(View view) {

        if (isOnline()){
            OpenView(Constant.PSC_RESULT);
        }
        else{
           showPopupMessage();
        }


    }



    public void openJSCWebView(View view) {

        if (isOnline()){
            OpenView(Constant.JSC_site);
        }
        else {
            Toast.makeText(this, "Please Connect The Internet", Toast.LENGTH_SHORT).show();
        }



    }

    private boolean isOnline() {

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        return networkInfo != null && networkInfo.isConnectedOrConnecting();

    }

    private void OpenView(String siteURL) {
        Intent intent = new Intent(MainActivity.this, webViewActivity.class);
        intent.putExtra(Constant.URL,siteURL);
        startActivity(intent);
    }*/
}
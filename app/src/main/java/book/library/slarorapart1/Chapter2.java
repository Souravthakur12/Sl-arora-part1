package book.library.slarorapart1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.ArrayList;
import java.util.List;

import book.library.slarorapart1.R;

public class Chapter2 extends AppCompatActivity {

    RecyclerView recyclerView;
    public static List<PDFModel> list;

    AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter2);


        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {}
        });

        mAdView = findViewById(R.id.adView);



        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        recyclerView = findViewById(R.id.RV);

        list = new ArrayList<>();
        list.add(new PDFModel("Page No 1-10","https://drive.google.com/file/d/1JKbAc8byKzhLsOcXU7loXNbbaCCRIs38/view?usp=sharing"));
        list.add(new PDFModel("Page No 11-20","https://drive.google.com/file/d/1uXQmcNfJvKFUe1lIFlWBoek0yLvrZx3c/view?usp=sharing"));
        list.add(new PDFModel("Page No 21-30","https://drive.google.com/file/d/1E8Qu8Yi5TtHo4YzVZ-EfYb8RfIftPcXI/view?usp=sharing"));
        list.add(new PDFModel("Page No 31-40","https://drive.google.com/file/d/1Csl2_FCw01FEPx9Zl-g6cqrk6av36Vh2/view?usp=sharing"));
        list.add(new PDFModel("Page No 41-50","https://drive.google.com/file/d/1EtMGoAoFcRvboE7tC9XIuMErK3mxQuP6/view?usp=sharing"));
        list.add(new PDFModel("Page No 51-60","https://drive.google.com/file/d/1HbMSL8DJKFR9djJ1otVz3Rwatia6RyNH/view?usp=sharing"));
        list.add(new PDFModel("Page No 61-70","https://drive.google.com/file/d/1_vP2aX5rqNsWZWE6sVyEfEmEKpCtElrg/view?usp=sharing"));
        list.add(new PDFModel("Page No 71-80","https://drive.google.com/file/d/1Xb7qZd4f5DNn4QQbSHeTE1iubV6rOSOJ/view?usp=sharing"));
        list.add(new PDFModel("Page No 81-90","https://drive.google.com/file/d/10hO0WXyKL3PLZLybvr3Lh3AMai65gXV2/view?usp=sharing"));
        list.add(new PDFModel("Page No 91-100","https://drive.google.com/file/d/10IVSamBYGyCIvc-IcF5ggzkn3j2zmhTY/view?usp=sharing"));
        list.add(new PDFModel("Page No 101-107","https://drive.google.com/file/d/18xKCFrwteBt0XbCeIv7QFY_lInv_gr7C/view?usp=sharing"));

        recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        ItemClickListener itemClickListener = new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                Intent intent = new Intent(Chapter2.this, PDFActivity2.class);
                //intent.putExtra("url",list.get(position).getPdfUrl());
                intent.putExtra("position",position);
                startActivity(intent);
            }
        };

        PDFAdapter adapter = new PDFAdapter(list,this,itemClickListener);
        recyclerView.setAdapter(adapter);








    }





}
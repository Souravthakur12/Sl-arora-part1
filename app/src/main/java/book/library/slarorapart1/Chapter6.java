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

public class Chapter6 extends AppCompatActivity {

    RecyclerView recyclerView;
    public static List<PDFModel> list;

    AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter6);


        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {}
        });

        mAdView = findViewById(R.id.adView);



        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        recyclerView = findViewById(R.id.RV);

        list = new ArrayList<>();
        list.add(new PDFModel("Page No 1-10","https://drive.google.com/file/d/1rHA4JoYxCE9lPIKu-obqS8dVTJ7xprOp/view?usp=sharing"));
        list.add(new PDFModel("Page No 11-20", "https://drive.google.com/file/d/1UEEuTHweAdzXxORzY51D0yvMo2x3nNNB/view?usp=sharing"));
        list.add(new PDFModel("Page No 21-30","https://drive.google.com/file/d/1jJa5gx6WsU2vlMDbpa7oJNYhCiw79EWH/view?usp=sharing"));
        list.add(new PDFModel("Page No 31-40","https://drive.google.com/file/d/1MMgGL1LdjsHMAuFIMqa0ywcVdmz05rAD/view?usp=sharing"));
        list.add(new PDFModel("Page No 41-50","https://drive.google.com/file/d/13z234XvIb4oP0O2vQImyYUYRVGLMoaPu/view?usp=sharing"));
        list.add(new PDFModel("Page No 51-60","https://drive.google.com/file/d/1u4NjBPzlOjpbS2paAaaSe2liaA-9VgXE/view?usp=sharing"));
        list.add(new PDFModel("Page No 61-70","https://drive.google.com/file/d/1BJmwQkfBex6F6SKSCAndJoO-BUI_drkf/view?usp=sharing"));
        list.add(new PDFModel("Page No 71-78","https://drive.google.com/file/d/10t4PEXmtCIs9tjvBEvytgJShDx7in1bY/view?usp=sharing"));


        recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        ItemClickListener itemClickListener = new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                Intent intent = new Intent(Chapter6.this, PDFActivity6.class);
                //intent.putExtra("url",list.get(position).getPdfUrl());
                intent.putExtra("position",position);
                startActivity(intent);
            }
        };

        PDFAdapter adapter = new PDFAdapter(list,this,itemClickListener);
        recyclerView.setAdapter(adapter);








    }





}
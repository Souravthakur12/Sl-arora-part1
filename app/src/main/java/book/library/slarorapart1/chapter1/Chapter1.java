package book.library.slarorapart1.chapter1;

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

import book.library.slarorapart1.ItemClickListener;
import book.library.slarorapart1.PDFActivity;
import book.library.slarorapart1.PDFAdapter;
import book.library.slarorapart1.PDFModel;
import book.library.slarorapart1.R;
import com.google.android.gms.ads.InterstitialAd;

public class Chapter1 extends AppCompatActivity {

    RecyclerView recyclerView;
    public static List<PDFModel> list;

    private InterstitialAd mInterstitialAd;


    AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter1);



        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {}
        });

        mAdView = findViewById(R.id.adView);



        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-9954362795324309/9782724743");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        recyclerView = findViewById(R.id.RV);

        list = new ArrayList<>();
        list.add(new PDFModel("Page No 1-10","https://drive.google.com/file/d/10PoOii7Ti79enRJsIsnyGMOaheMotDVb/view?usp=sharing"));
        list.add(new PDFModel("Page No 11-20", "https://drive.google.com/file/d/1BSB5BCv9KBqT5j0WteikVNX1TH79IzNr/view?usp=sharing"));
        list.add(new PDFModel("Page No 21-30","https://drive.google.com/file/d/1bbEZyl1dJq-tgG5Z8PRQ2bWTCujsNPQ_/view?usp=sharing"));
        list.add(new PDFModel("Page No 31-40","https://drive.google.com/file/d/1itzQQa6-UhAqjp0myNFQC9AQ2FK6A5fT/view?usp=sharing"));
        list.add(new PDFModel("Page No 41-50","https://drive.google.com/file/d/1I3fVUkl5nTcP874M3XjC7COTGy_Odd9T/view?usp=sharing"));
        list.add(new PDFModel("Page No 51-60","https://drive.google.com/file/d/1Dq7_vMv6gCmLUZ8W0clZBw-dMXEpWFr6/view?usp=sharing"));
        list.add(new PDFModel("Page No 61-70","https://drive.google.com/file/d/1wKtNr9appYKLw02-TGxIRPuSavIN21m7/view?usp=sharing"));
        list.add(new PDFModel("Page No 71-80","https://drive.google.com/file/d/1u0xY7NCeG5omV3JeBcv3vCKvKXwnNbEk/view?usp=sharing"));
        list.add(new PDFModel("Page No 81-93","https://drive.google.com/file/d/1G2scV5gT8JHm1Jg3MYUIVI38Jaxt3y1p/view?usp=sharing"));

        recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        ItemClickListener itemClickListener = new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                Intent intent = new Intent(Chapter1.this, PDFActivity.class);
                //intent.putExtra("url",list.get(position).getPdfUrl());
                intent.putExtra("position",position);
                startActivity(intent);
            }
        };

        PDFAdapter adapter = new PDFAdapter(list,this,itemClickListener);
        recyclerView.setAdapter(adapter);








    }





}
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

public class Chapter5 extends AppCompatActivity {

    RecyclerView recyclerView;
    public static List<PDFModel> list;

    AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter5);


        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {}
        });

        mAdView = findViewById(R.id.adView);



        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        recyclerView = findViewById(R.id.RV);

        list = new ArrayList<>();
        list.add(new PDFModel("Page No 1-10","https://drive.google.com/file/d/1p4OPadjS-lZ2EpFmevvo1oteeh6VsPeT/view?usp=sharing"));
        list.add(new PDFModel("Page No 11-20", "https://drive.google.com/file/d/1ANiH7HItM-RVUTYT3fIequhmJQqcA4dF/view?usp=sharing"));
        list.add(new PDFModel("Page No 21-30","https://drive.google.com/file/d/1luyits-5jNG2JwWq0GfI3ZGnMbwzMJWe/view?usp=sharing"));
        list.add(new PDFModel("Page No 31-40","https://drive.google.com/file/d/194soVYLd4j4mf5N88o6zjYZRDnXzHv18/view?usp=sharing"));
        list.add(new PDFModel("Page No 41-50","https://drive.google.com/file/d/13hFWBc2xzd6W0ZWNa4umhq7mSLMrjkLW/view?usp=sharing"));
        list.add(new PDFModel("Page No 51-60","https://drive.google.com/file/d/1NTuVS8eHw3zIQidsbgrar8w4mnI1v0jz/view?usp=sharing"));
        list.add(new PDFModel("Page No 61-70","https://drive.google.com/file/d/1Ej6bPyb6PfTU7hu0jcPoDN2uVnxZ2tiw/view?usp=sharing"));
        list.add(new PDFModel("Page No 71-80","https://drive.google.com/file/d/1qsLsgfezOO9XtcJJkimpumJmu6iE_f2E/view?usp=sharing"));
        list.add(new PDFModel("Page No 81-90","https://drive.google.com/file/d/1BZCFtSuNgBegAb4MdxzUhG4bJokjDG5i/view?usp=sharing"));
        list.add(new PDFModel("Page No 91-99","https://drive.google.com/file/d/1BZLUZDeqRt8t9LbRSwvJKnwoYshbszja/view?usp=sharing"));

        recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        ItemClickListener itemClickListener = new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                Intent intent = new Intent(Chapter5.this,PDFActivity5.class);
                //intent.putExtra("url",list.get(position).getPdfUrl());
                intent.putExtra("position",position);
                startActivity(intent);
            }
        };

        PDFAdapter adapter = new PDFAdapter(list,this,itemClickListener);
        recyclerView.setAdapter(adapter);








    }





}
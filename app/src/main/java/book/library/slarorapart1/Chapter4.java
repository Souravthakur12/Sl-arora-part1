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

public class Chapter4 extends AppCompatActivity {

    RecyclerView recyclerView;
    public static List<PDFModel> list;

    AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter4);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {}
        });

        mAdView = findViewById(R.id.adView);



        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        recyclerView = findViewById(R.id.RV);

        list = new ArrayList<>();
        list.add(new PDFModel("Page No 1-10","https://drive.google.com/file/d/1W_J2ygX-TAVjFS3Rabb8Le5PVPdosjqs/view?usp=sharing"));
        list.add(new PDFModel("Page No 11-20", "https://drive.google.com/file/d/1nScBGVS7gRPG2zR2sd9y1rZOo3ox8LAr/view?usp=sharing"));
        list.add(new PDFModel("Page No 21-30","https://drive.google.com/file/d/12zy-FyPKXsW60t8RYs6sk2giZHmGWx-l/view?usp=sharing"));
        list.add(new PDFModel("Page No 31-40","https://drive.google.com/file/d/1cT764IHO3s0v9uKVUZjYS1aPOpTsk_4d/view?usp=sharing"));
        list.add(new PDFModel("Page No 41-50","https://drive.google.com/file/d/1BxBOCQc4nYTkJg0OEM4stm4PiMcTvfgk/view?usp=sharing"));
        list.add(new PDFModel("Page No 51-60","https://drive.google.com/file/d/1oPMKQWM43YxLPS6OMj83Hulc-y71FplF/view?usp=sharing"));
        list.add(new PDFModel("Page No 61-70","https://drive.google.com/file/d/1wrxix7jfSai0BF1Jx5wF0mnbXFn_S-fj/view?usp=sharing"));
        list.add(new PDFModel("Page No 71-80","https://drive.google.com/file/d/1x7Ry4zwAfzfD--MTqpH_YgoW2fsMfkDy/view?usp=sharing"));
        list.add(new PDFModel("Page No 81-90","https://drive.google.com/file/d/1pz5RWRSI7oBRJI3au14nNvkWOLEzlsBB/view?usp=sharing"));
        list.add(new PDFModel("Page No 91-100","https://drive.google.com/file/d/1RojfDi0g1acMxKxM6aye3kcz7vWwq659/view?usp=sharing"));
        list.add(new PDFModel("Page No 101-110","https://drive.google.com/file/d/1uPL1e1YJ5T6lAZIELbEwzVX05Ha1tTDq/view?usp=sharing"));
        list.add(new PDFModel("Page No 111-120","https://drive.google.com/file/d/1pI0OfRLMdPVjqVZXzj0FxlhZotpeU9xT/view?usp=sharing"));
        list.add(new PDFModel("Page No 121-130","https://drive.google.com/file/d/1_ymBSwAHxG0Qmd17zVlU_7OpTuVCc02h/view?usp=sharing"));
        list.add(new PDFModel("Page No 131-140","https://drive.google.com/file/d/1InKL_essx0mZkDYgv-HRoMg1vUOic_ZM/view?usp=sharing"));
        list.add(new PDFModel("Page No 141-150","https://drive.google.com/file/d/160OdkNg9ba-z3DjW1np4Ijyl-4w6lw0J/view?usp=sharing"));
        list.add(new PDFModel("Page No 151-160","https://drive.google.com/file/d/1F3Rg4ymQ5jnVpmFXh3TV--Hu_k6C4lhP/view?usp=sharing"));
        list.add(new PDFModel("Page No 161-174","https://drive.google.com/file/d/1rYMblMNPSfN4iYHHBFr3F0A8CkeUbVtq/view?usp=sharing"));



        recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        ItemClickListener itemClickListener = new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                Intent intent = new Intent(Chapter4.this, PDFActivity4.class);
                //intent.putExtra("url",list.get(position).getPdfUrl());
                intent.putExtra("position",position);
                startActivity(intent);
            }
        };

        PDFAdapter adapter = new PDFAdapter(list,this,itemClickListener);
        recyclerView.setAdapter(adapter);








    }





}
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

public class Chapter3 extends AppCompatActivity {

    RecyclerView recyclerView;
    public static List<PDFModel> list;

    AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter3);


        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {}
        });

        mAdView = findViewById(R.id.adView);



        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        recyclerView = findViewById(R.id.RV);

        list = new ArrayList<>();
        list.add(new PDFModel("Page No 1-10","https://drive.google.com/file/d/1oL2B2xRCWG_t0rOm3V81-mQ33Ir4TlhJ/view?usp=sharing"));
        list.add(new PDFModel("Page No 11-20", "https://drive.google.com/file/d/1HLlElJ4uiSdijQ778NlUZ2x3gl0sO75K/view?usp=sharing"));
        list.add(new PDFModel("Page No 21-30","https://drive.google.com/file/d/1t7fgiKkM1hp_G5Zt_bviivh1U8QxQIi7/view?usp=sharing"));
        list.add(new PDFModel("Page No 31-40","https://drive.google.com/file/d/1yb5ZKae_jVGgKOqdvSi__VDLN8Liq31o/view?usp=sharing"));
        list.add(new PDFModel("Page No 41-50","https://drive.google.com/file/d/107zzUdP9msfDxS9NyayNK6skVBEdV7e1/view?usp=sharing"));
        list.add(new PDFModel("Page No 51-60","https://drive.google.com/file/d/1g5YiQetelarT0qqmGl2k1Q9jscoDxuTt/view?usp=sharing"));
        list.add(new PDFModel("Page No 61-70","https://drive.google.com/file/d/1nNPRDODP7eltO-n1JPwbPzGWZ-0_Gzxo/view?usp=sharing"));
        list.add(new PDFModel("Page No 71-80","https://drive.google.com/file/d/1JtyptbG5hWzcpOpfDoqpuJk_U27FgSqZ/view?usp=sharing"));
        list.add(new PDFModel("Page No 81-90","https://drive.google.com/file/d/1rpoMh86mBAA_DV2jP2ljIorbQXUDEf3s/view?usp=sharing"));
        list.add(new PDFModel("Page No 91-100","https://drive.google.com/file/d/19HRwRroeBkhbQnULiXEulm26YHbeClHt/view?usp=sharing"));
        list.add(new PDFModel("Page No 101-110","https://drive.google.com/file/d/1Tk_nqwgE8GSGlMUBBcF-TLBMDCUh2hz0/view?usp=sharing"));
        list.add(new PDFModel("Page No 111-120","https://drive.google.com/file/d/1XTQECeeMl0susigRa7iC4jOqX2bbRkIF/view?usp=sharing"));
        list.add(new PDFModel("Page No 121-130","https://drive.google.com/file/d/1f3TBJTrK7fWRVw-ZjjSAvc_uHyYdWKzd/view?usp=sharing"));
        list.add(new PDFModel("Page No 131-140","https://drive.google.com/file/d/1ET1-EgLDQDdG97ArhB3WArIRSFjlL27T/view?usp=sharing"));
        list.add(new PDFModel("Page No 141-150","https://drive.google.com/file/d/1j1JIqB1IkdpqnxY030pQGIDN-j44vn2G/view?usp=sharing"));
        list.add(new PDFModel("Page No 151-160","https://drive.google.com/file/d/1wZtaJjJQN1zkW44rUSTXQFsj1ylh51MO/view?usp=sharing"));
        list.add(new PDFModel("Page No 161-170","https://drive.google.com/file/d/12KSazdMpot5ZQ28PpSiYq9Mr4UTKwk80/view?usp=sharing"));
        list.add(new PDFModel("Page No 171-180","https://drive.google.com/file/d/1iYRGvlnCjblwHUIdhSCe8VP3rbcfek9M/view?usp=sharing"));
        list.add(new PDFModel("Page No 181-190","https://drive.google.com/file/d/1r_QmaDYjK5SMJDf1wH4wHmw8IeOxQsNP/view?usp=sharing"));
        list.add(new PDFModel("Page No 191-200","https://drive.google.com/file/d/1CYlWvmX2d7bs_OOi5VzAi_gfc2K3kfuB/view?usp=sharing"));
        list.add(new PDFModel("Page No 201-210","https://drive.google.com/file/d/1v0pzslElE7khWfQ9LBWleSWOGBVKZnYI/view?usp=sharing"));
        list.add(new PDFModel("Page No 211-220","https://drive.google.com/file/d/1haZvpCHtshBEL6pUvTmYI5RPtEItc_mW/view?usp=sharing"));
        list.add(new PDFModel("Page No 221-230","https://drive.google.com/file/d/1EQ4Sf0TLsJH8kBBDePwd7XM1wwq1jS13/view?usp=sharing"));




        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        ItemClickListener itemClickListener = new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                Intent intent = new Intent(Chapter3.this, PDFActivity3.class);
                //intent.putExtra("url",list.get(position).getPdfUrl());
                intent.putExtra("position",position);
                startActivity(intent);
            }
        };

        PDFAdapter adapter = new PDFAdapter(list,this,itemClickListener);
        recyclerView.setAdapter(adapter);








    }





}
package book.library.slarorapart1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.IntentSender;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import book.library.slarorapart1.chapter1.Chapter1;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.appupdate.AppUpdateManagerFactory;
import com.google.android.play.core.tasks.OnSuccessListener;
import com.google.android.play.core.tasks.Task;

import static com.google.android.play.core.install.model.AppUpdateType.IMMEDIATE;
import static com.google.android.play.core.install.model.UpdateAvailability.UPDATE_AVAILABLE;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CardView ch1,ch2,ch3,ch4,ch5,ch6,ch7;

    private AdView mAdView;

    private InterstitialAd mInterstitialAd;

    private int REQUEST_CODE =1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {}
        });

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-9954362795324309/9782724743");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());









        ch1 = findViewById(R.id.chapter1);
        ch2 = findViewById(R.id.chapter2);
        ch3 = findViewById(R.id.chapter3);
        ch4 = findViewById(R.id.chapter4);
        ch5 = findViewById(R.id.chapter5);
        ch6 = findViewById(R.id.chapter6);
        ch7 = findViewById(R.id.chapter7);

        AppUpdateManager appUpdateManager = AppUpdateManagerFactory.create(MainActivity.this);

        Task<AppUpdateInfo> appUpdateInfoTask = appUpdateManager.getAppUpdateInfo();

        appUpdateInfoTask.addOnSuccessListener(new OnSuccessListener<AppUpdateInfo>() {
            @Override
            public void onSuccess(AppUpdateInfo result) {
                if (result.updateAvailability() == UPDATE_AVAILABLE && result.isUpdateTypeAllowed(IMMEDIATE)){
                    try {
                        appUpdateManager.startUpdateFlowForResult(result, IMMEDIATE,MainActivity.this,REQUEST_CODE);
                    } catch (IntentSender.SendIntentException e) {
                        e.printStackTrace();
                    }
                }
            }
        });






   //



    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode != RESULT_OK) {
                Log.d("u","Update flow failed! Result code: " + resultCode);
                // If the update is cancelled or fails,
                // you can request to start the update again.
            }
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){


            case R.id.share:

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                String sharbody ="" +
                        "Share this App With Friends \n" +
                        "Download this app Now:\n" +
                        "https://play.google.com/store/apps/details?id=book.library.slarorapart1";
                intent.putExtra(Intent.EXTRA_TEXT,sharbody);
                startActivity(Intent.createChooser(intent,"Share Using"));

                return true;


            case R.id.join_us:

                Uri uri = Uri.parse("https://t.me/Amazingappsforyou");
                startActivity(new Intent(Intent.ACTION_VIEW,uri));

                return true;


        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();

        ch1.setOnClickListener(this);
        ch2.setOnClickListener(this);
        ch3.setOnClickListener(this);
        ch4.setOnClickListener(this);
        ch5.setOnClickListener(this);
        ch6.setOnClickListener(this);
        ch7.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;

        switch (v.getId()){

            case R.id.chapter1 :intent = new Intent(this, Chapter1.class);
                mInterstitialAd.show();
            startActivity(intent);
            break;
            case R.id.chapter2 :intent = new Intent(this, Chapter2.class);
                mInterstitialAd.show();
                startActivity(intent);
                break;
            case R.id.chapter3 :intent = new Intent(this, Chapter3.class);
                mInterstitialAd.show();
                startActivity(intent);
                break;
            case R.id.chapter4 :intent = new Intent(this, Chapter4.class);
                mInterstitialAd.show();
                startActivity(intent);
                break;
            case R.id.chapter5 :intent = new Intent(this, Chapter5.class);
                mInterstitialAd.show();
                startActivity(intent);
                break;
            case R.id.chapter6 :intent = new Intent(this, Chapter6.class);
                mInterstitialAd.show();
                startActivity(intent);
                break;
            case R.id.chapter7:intent = new Intent(this, Chapter7.class);
                mInterstitialAd.show();
                startActivity(intent);
                break;

        }

    }
}
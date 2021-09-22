package umn.ac.id.week04_37399;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import umn.ac.id.week04_37399.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding bind;

    Intent secondIntent;
    Intent resultFromSecond;

    private String msgToSend;
    private String urlText;
    @SuppressLint("QueryPermissionsNeeded")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bind = ActivityMainBinding.inflate(LayoutInflater.from(this));
        setContentView(bind.getRoot());

        bind.btnBrowse.setOnClickListener(v -> {
            Log.d("hesoyam","Browse");
            urlText = bind.webpage.getText().toString();
            if(urlText.isEmpty()) urlText = "http://www.umn.ac.id";
            Intent browserIntent = new Intent(Intent.ACTION_VIEW);
            browserIntent.setData(Uri.parse(urlText));
            if(browserIntent.resolveActivity(getPackageManager())!=null)
                startActivity(browserIntent);
        });
        bind.btnSend.setOnClickListener(v -> {
            msgToSend = bind.textSending.getText().toString();
            secondIntent = new Intent(MainActivity.this, SecondActivity.class);
            secondIntent.putExtra("MsgFromMain", msgToSend);
            resultFromSecondActivity.launch(secondIntent);
        });
    }

    ActivityResultLauncher<Intent> resultFromSecondActivity = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode() == RESULT_OK){
                        resultFromSecond = result.getData();
                        bind.tvResultFromSecondary.
                                setText(resultFromSecond != null ?
                                        resultFromSecond.getStringExtra("MsgFromSecond") : "Null");
                    }
                }
            }
    );

}
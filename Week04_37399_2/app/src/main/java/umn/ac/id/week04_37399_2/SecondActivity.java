package umn.ac.id.week04_37399_2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button btnBackHome = findViewById(R.id.btn_back_home);
        btnBackHome.setOnClickListener(v -> {
            finish();
        });
    }


}
package umn.ac.id.week04_37399_2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnHalaman1, btnHalaman2;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnHalaman1 = findViewById(R.id.btn_hal_1);
        btnHalaman2 = findViewById(R.id.btn_hal_2);

        btnHalaman1.setOnClickListener(v -> {
            intent = new Intent(this, SecondActivity.class);
            startActivity(intent);
        });

        btnHalaman2.setOnClickListener(v -> {
            intent = new Intent(this,ThirdActivity.class);
            startActivity(intent);
        });
    }
}
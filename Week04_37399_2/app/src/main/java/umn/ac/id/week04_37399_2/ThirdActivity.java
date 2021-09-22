package umn.ac.id.week04_37399_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.Button;

public class ThirdActivity extends AppCompatActivity {

//    FrameLayout

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        Fragment firstFragment = new FirstFragment();
        fragmentTransaction.replace(R.id.third_activity_fragment01,firstFragment);

        Fragment secondFragment = new SecondFragment();
        fragmentTransaction.replace(R.id.third_activity_fragment02,secondFragment);
        fragmentTransaction.commit();

        Button btnBackToHome = findViewById(R.id.btn_back_home);
        btnBackToHome.setOnClickListener(v -> {
            finish();
        });
    }
}

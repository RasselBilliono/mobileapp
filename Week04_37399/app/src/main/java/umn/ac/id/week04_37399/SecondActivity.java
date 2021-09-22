package umn.ac.id.week04_37399;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import umn.ac.id.week04_37399.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {

    ActivitySecondBinding bind;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());

        Intent mainIntent = getIntent();
        String msgReceived = mainIntent.getStringExtra("MsgFromMain");
        if(!msgReceived.equals("")) bind.tvGetMsg.setText(msgReceived);

        bind.btnSendBack.setOnClickListener(v->sendBack());
    }
    private void sendBack(){
        String answer = bind.returnMsg.getText().toString();
        Intent replyIntent = new Intent();
        replyIntent.putExtra("MsgFromSecond", answer);
        setResult(RESULT_OK, replyIntent);
        finish();
    }
}

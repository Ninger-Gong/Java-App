package com.example.project2;

import android.content.Intent;
import android.graphics.Paint;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class WelcomeActivity extends AppCompatActivity {

    private Button JoinBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

    }
    public void openMainActivity(View view){
        Intent intent = new Intent(WelcomeActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
    }
}

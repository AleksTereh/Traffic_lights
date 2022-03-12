package ru.alekstereh.trafficlights;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private boolean start_stop = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout b_1 = findViewById(R.id.red);
        LinearLayout b_2 = findViewById(R.id.yellow);
        LinearLayout b_3 = findViewById(R.id.green);

    }

    public void clickStart(View view) {

        new Thread(() -> {
            while (start_stop) {
                try{
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }
}
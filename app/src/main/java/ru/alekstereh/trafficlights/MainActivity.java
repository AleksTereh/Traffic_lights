package ru.alekstereh.trafficlights;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private LinearLayout b_1, b_2, b_3;
    private boolean start_stop = false;
    private Button btn;
    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b_1 = findViewById(R.id.red);
        b_2 = findViewById(R.id.yellow);
        b_3 = findViewById(R.id.green);
        btn = findViewById(R.id.button);

    }

    public void clickStart(View view) {

        if (!start_stop) {
            start_stop = true;
            btn.setText("СТОП");

            new Thread(() -> {
                while (start_stop) {
                    counter++;
                    switch (counter) {
                        case 1:
                            b_1.setBackgroundColor(getResources().getColor(R.color.red1));
                            b_2.setBackgroundColor(getResources().getColor(R.color.gray));
                            b_3.setBackgroundColor(getResources().getColor(R.color.gray));
                            break;
                        case 2:
                            b_1.setBackgroundColor(getResources().getColor(R.color.gray));
                            b_2.setBackgroundColor(getResources().getColor(R.color.yellow1));
                            b_3.setBackgroundColor(getResources().getColor(R.color.gray));
                            break;
                        case 3:
                            b_1.setBackgroundColor(getResources().getColor(R.color.gray));
                            b_2.setBackgroundColor(getResources().getColor(R.color.gray));
                            b_3.setBackgroundColor(getResources().getColor(R.color.green1));
                            counter = 0;
                            break;
                    }
                    try {
                        Thread.sleep(4000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }).start();
        } else {
            start_stop = false;
            btn.setText("СТАРТ");
        }
    }
}
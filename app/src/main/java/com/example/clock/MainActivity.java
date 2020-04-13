package com.example.clock;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity {
    private Chronometer counter;
    Button start, pause, restart;
    private long timeWhenStopped = 0;
   private boolean running;
    private long pauseOffset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        counter = (Chronometer) findViewById(R.id.chronometer);
        counter.setFormat("Time: %s");

        start = (Button) findViewById(R.id.btnstart);
        pause = (Button) findViewById(R.id.btnPause);
        restart = (Button) findViewById(R.id.btnRestart);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!running) {
                    counter.setBase(SystemClock.elapsedRealtime() - pauseOffset);
                    counter.start();
                }
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!running){
                    counter.stop();
                    pauseOffset = SystemClock.elapsedRealtime() - counter.getBase();
                    running = false;
                }

            }
        });

        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter.setBase(SystemClock.elapsedRealtime());
                counter.start();
                pauseOffset = 0;
            }
        });

    }
    }





package com.example.a5yncopa7ion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    Button btnTempoUp;
    Button btnTempoDn;
    Button btnStartStop;
    TextView tvTempo;
    Button btnSubDiv;
    TextView subDiv;

    Metronome m;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("Life Cycle Event: ", "in onCreate()");

        final Metronome metronome = new Metronome(this);
        this.m = metronome;

        btnStartStop = findViewById(R.id.btnStartStop);
        btnTempoUp = findViewById(R.id.btnTempoUp);
        btnTempoDn = findViewById(R.id.btnTempoDn);
        tvTempo = findViewById(R.id.tvTempo);
        tvTempo.setText(String.valueOf(metronome.getBpm()));



        btnTempoUp.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                metronome.setBpm(metronome.getBpm() + 10);
                tvTempo.setText(String.valueOf(metronome.getBpm()));
                return true;
            }
        });

        btnTempoDn.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                metronome.setBpm(metronome.getBpm() - 10);
                tvTempo.setText(String.valueOf(metronome.getBpm()));
                return true;
            }
        });

        btnTempoUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                metronome.setBpm(metronome.getBpm() + 1);
                tvTempo.setText(String.valueOf(metronome.getBpm()));
                Log.d("TEMPO", "Tempo Up");
            }
        });

        btnTempoDn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                metronome.setBpm(metronome.getBpm() - 1);
                tvTempo.setText(String.valueOf(metronome.getBpm()));

            }
        });

        btnStartStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!metronome.isPlaying()) {
                    metronome.startClick();
                    //metronome.setPlaying(true);
                } else {
                    metronome.stopClick();
                    //metronome.setPlaying(false);
                }

            }
        });


    }

    public void showSetSubDiv(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.set_subdiv_menu);
        popup.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        //final Metronome metronome = new Metronome(this);
        //Button b = (Button) item;
        switch (item.getItemId()) {
            case R.id.none:
                m.setSubDiv(1);
                Toast.makeText(this, "none", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.eighths:
                m.setSubDiv(2);
                Toast.makeText(this, "2", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.tripEighths:
                m.setSubDiv(3);
                Toast.makeText(this, "3", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.sixteenths:
                m.setSubDiv(4);
                Toast.makeText(this, "4", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.quintSixteenths:
                m.setSubDiv(5);
                Toast.makeText(this, "5", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.tripSixteenths:
                m.setSubDiv(6);
                Toast.makeText(this, "6", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return false;

        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d("Life Cycle Event: ", "in onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d("Life Cycle Event: ", "in onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d("Life Cycle Event: ", "in onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d("Life Cycle Event: ", "in onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d("Life Cycle Event: ", "in onDestroy()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.d("Life Cycle Event: ", "in onRestart()");
    }
}

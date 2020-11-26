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
    TextView tvSignature;
    TextView tvSubDiv;
    TextView tvPolyOne;
    TextView tvPolyTwo;
    TextView tvPolyThree;
    TextView tvPolyFour;


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
        tvSubDiv = findViewById(R.id.btnSubDiv);
        tvSubDiv.setText("SubDiv\nnone");
        tvSignature = findViewById(R.id.btnSignature);
        tvSignature.setText(String.valueOf(m.getBeatsInMeasure()) + "\n4");
        tvPolyOne = findViewById(R.id.btnPoly1);
        tvPolyOne.setText("Poly 1\n" + String.valueOf(m.getPolyDiv(1)));
        tvPolyTwo = findViewById(R.id.btnPoly2);
        tvPolyTwo.setText("Poly 2\n" + String.valueOf(m.getPolyDiv(2)));
        tvPolyThree = findViewById(R.id.btnPoly3);
        tvPolyThree.setText("Poly 3\n" + String.valueOf(m.getPolyDiv(3)));
        tvPolyFour = findViewById(R.id.btnPoly4);
        tvPolyFour.setText("Poly 4\n" + String.valueOf(m.getPolyDiv(4)));



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

    public void showSetSignature(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.set_signature_menu);
        popup.show();
    }

    public void showSetPoly1(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.set_polyone_menu);
        popup.show();
    }

    public void showSetPoly2(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.set_polytwo_menu);
        popup.show();
    }

    public void showSetPoly3(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.set_polythree_menu);
        popup.show();
    }

    public void showSetPoly4(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.set_polyfour_menu);
        popup.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        //final Metronome metronome = new Metronome(this);
        //Button b = (Button) item;
        switch (item.getItemId()) {
            //Set Sub Division
            case R.id.none:
                m.setSubDiv(1);
                Toast.makeText(this, "none", Toast.LENGTH_SHORT).show();
                tvSubDiv.setText("SubDiv\n none");
                return true;
            case R.id.eighths:
                m.setSubDiv(2);
                Toast.makeText(this, "2", Toast.LENGTH_SHORT).show();
                tvSubDiv.setText("SubDiv\n" + String.valueOf(m.getSubDiv()));
                return true;
            case R.id.tripEighths:
                m.setSubDiv(3);
                Toast.makeText(this, "3", Toast.LENGTH_SHORT).show();
                tvSubDiv.setText("SubDiv\n" + String.valueOf(m.getSubDiv()));
                return true;
            case R.id.sixteenths:
                m.setSubDiv(4);
                Toast.makeText(this, "4", Toast.LENGTH_SHORT).show();
                tvSubDiv.setText("SubDiv\n" + String.valueOf(m.getSubDiv()));
                return true;
            case R.id.quintSixteenths:
                m.setSubDiv(5);
                Toast.makeText(this, "5", Toast.LENGTH_SHORT).show();
                tvSubDiv.setText("SubDiv\n" + String.valueOf(m.getSubDiv()));
                return true;
            case R.id.tripSixteenths:
                m.setSubDiv(6);
                Toast.makeText(this, "6", Toast.LENGTH_SHORT).show();
                tvSubDiv.setText("SubDiv\n" + String.valueOf(m.getSubDiv()));
                return true;
            case R.id.septSixteenths:
                m.setSubDiv(7);
                Toast.makeText(this, "7", Toast.LENGTH_SHORT).show();
                tvSubDiv.setText("SubDiv\n" + String.valueOf(m.getSubDiv()));
                return true;
            case R.id.thirtySeconds:
                m.setSubDiv(8);
                Toast.makeText(this, "8", Toast.LENGTH_SHORT).show();
                tvSubDiv.setText("SubDiv\n" + String.valueOf(m.getSubDiv()));
                return true;
            //Set Signature
            case R.id.sigTopOne:
                m.setBeatsInMeasure(1);
                Toast.makeText(this, "1", Toast.LENGTH_SHORT).show();
                tvSignature.setText(String.valueOf(m.getBeatsInMeasure()) + "\n4");
                return true;
            case R.id.sigTopTwo:
                m.setBeatsInMeasure(2);
                Toast.makeText(this, "2", Toast.LENGTH_SHORT).show();
                tvSignature.setText(String.valueOf(m.getBeatsInMeasure()) + "\n4");
                return true;
            case R.id.sigTopThree:
                m.setBeatsInMeasure(3);
                Toast.makeText(this, "3", Toast.LENGTH_SHORT).show();
                tvSignature.setText(String.valueOf(m.getBeatsInMeasure()) + "\n4");
                return true;
            case R.id.sigTopFour:
                m.setBeatsInMeasure(4);
                Toast.makeText(this, "4", Toast.LENGTH_SHORT).show();
                tvSignature.setText(String.valueOf(m.getBeatsInMeasure()) + "\n4");
                return true;
            case R.id.sigTopFive:
                m.setBeatsInMeasure(5);
                Toast.makeText(this, "5", Toast.LENGTH_SHORT).show();
                tvSignature.setText(String.valueOf(m.getBeatsInMeasure()) + "\n4");
                return true;
            case R.id.sigTopSix:
                m.setBeatsInMeasure(6);
                Toast.makeText(this, "6", Toast.LENGTH_SHORT).show();
                tvSignature.setText(String.valueOf(m.getBeatsInMeasure()) + "\n4");
                return true;
            case R.id.sigTopSeven:
                m.setBeatsInMeasure(7);
                Toast.makeText(this, "7", Toast.LENGTH_SHORT).show();
                tvSignature.setText(String.valueOf(m.getBeatsInMeasure()) + "\n4");
                return true;
            case R.id.sigTopEight:
                m.setBeatsInMeasure(8);
                Toast.makeText(this, "8", Toast.LENGTH_SHORT).show();
                tvSignature.setText(String.valueOf(m.getBeatsInMeasure()) + "\n4");
                return true;
            case R.id.sigTopNine:
                m.setBeatsInMeasure(9);
                Toast.makeText(this, "9", Toast.LENGTH_SHORT).show();
                tvSignature.setText(String.valueOf(m.getBeatsInMeasure()) + "\n4");
                return true;
            case R.id.sigTopTen:
                m.setBeatsInMeasure(10);
                Toast.makeText(this, "10", Toast.LENGTH_SHORT).show();
                tvSignature.setText(String.valueOf(m.getBeatsInMeasure()) + "\n4");
                return true;
            case R.id.sigTopEleven:
                m.setBeatsInMeasure(11);
                Toast.makeText(this, "11", Toast.LENGTH_SHORT).show();
                tvSignature.setText(String.valueOf(m.getBeatsInMeasure()) + "\n4");
                return true;
            case R.id.sigTopTwelve:
                m.setBeatsInMeasure(12);
                Toast.makeText(this, "12", Toast.LENGTH_SHORT).show();
                tvSignature.setText(String.valueOf(m.getBeatsInMeasure()) + "\n4");
                return true;
            case R.id.sigTopThirteen:
                m.setBeatsInMeasure(13);
                Toast.makeText(this, "13", Toast.LENGTH_SHORT).show();
                tvSignature.setText(String.valueOf(m.getBeatsInMeasure()) + "\n4");
                return true;
            case R.id.sigTopFourteen:
                m.setBeatsInMeasure(14);
                Toast.makeText(this, "14", Toast.LENGTH_SHORT).show();
                tvSignature.setText(String.valueOf(m.getBeatsInMeasure()) + "\n4");
                return true;
            case R.id.sigTopFifteen:
                m.setBeatsInMeasure(15);
                Toast.makeText(this, "15", Toast.LENGTH_SHORT).show();
                tvSignature.setText(String.valueOf(m.getBeatsInMeasure()) + "\n4");
                return true;
            case R.id.sigTopSixteen:
                m.setBeatsInMeasure(16);
                Toast.makeText(this, "16", Toast.LENGTH_SHORT).show();
                tvSignature.setText(String.valueOf(m.getBeatsInMeasure()) + "\n4");
                return true;
            case R.id.sigTopSeventeen:
                m.setBeatsInMeasure(17);
                Toast.makeText(this, "17", Toast.LENGTH_SHORT).show();
                tvSignature.setText(String.valueOf(m.getBeatsInMeasure()) + "\n4");
                return true;
            case R.id.sigTopEighteen:
                m.setBeatsInMeasure(18);
                Toast.makeText(this, "18", Toast.LENGTH_SHORT).show();
                tvSignature.setText(String.valueOf(m.getBeatsInMeasure()) + "\n4");
                return true;
            case R.id.sigTopNineteen:
                m.setBeatsInMeasure(19);
                Toast.makeText(this, "19", Toast.LENGTH_SHORT).show();
                tvSignature.setText(String.valueOf(m.getBeatsInMeasure()) + "\n4");
                return true;
            case R.id.sigTopTwenty:
                m.setBeatsInMeasure(20);
                Toast.makeText(this, "20", Toast.LENGTH_SHORT).show();
                tvSignature.setText(String.valueOf(m.getBeatsInMeasure()) + "\n4");
                return true;
            case R.id.sigTopTwentyOne:
                m.setBeatsInMeasure(21);
                Toast.makeText(this, "21", Toast.LENGTH_SHORT).show();
                tvSignature.setText(String.valueOf(m.getBeatsInMeasure()) + "\n4");
                return true;
            case R.id.sigTopTwentyTwo:
                m.setBeatsInMeasure(22);
                Toast.makeText(this, "22", Toast.LENGTH_SHORT).show();
                tvSignature.setText(String.valueOf(m.getBeatsInMeasure()) + "\n4");
                return true;
            case R.id.sigTopTwentyThree:
                m.setBeatsInMeasure(23);
                Toast.makeText(this, "23", Toast.LENGTH_SHORT).show();
                tvSignature.setText(String.valueOf(m.getBeatsInMeasure()) + "\n4");
                return true;
            case R.id.sigTopTwentyFour:
                m.setBeatsInMeasure(24);
                Toast.makeText(this, "24", Toast.LENGTH_SHORT).show();
                tvSignature.setText(String.valueOf(m.getBeatsInMeasure()) + "\n4");
                return true;
            //Set Poly One
            case R.id.polyOneOne:
                m.setPolyDiv(1,1);
                Toast.makeText(this, "1", Toast.LENGTH_SHORT).show();
                tvPolyOne.setText("Poly 1\noff");
                return true;
            case R.id.polyOneTwo:
                m.setPolyDiv(1,2);
                Toast.makeText(this, "2", Toast.LENGTH_SHORT).show();
                tvPolyOne.setText("Poly 1\n" + String.valueOf(m.getPolyDiv(1)));
                return true;
            case R.id.polyOneThree:
                m.setPolyDiv(1,3);
                Toast.makeText(this, "3", Toast.LENGTH_SHORT).show();
                tvPolyOne.setText("Poly 1\n" + String.valueOf(m.getPolyDiv(1)));
                return true;
            case R.id.polyOneFour:
                m.setPolyDiv(1,4);
                Toast.makeText(this, "4", Toast.LENGTH_SHORT).show();
                tvPolyOne.setText("Poly 1\n" + String.valueOf(m.getPolyDiv(1)));
                return true;
            case R.id.polyOneFive:
                m.setPolyDiv(1,5);
                Toast.makeText(this, "5", Toast.LENGTH_SHORT).show();
                tvPolyOne.setText("Poly 1\n" + String.valueOf(m.getPolyDiv(1)));
                return true;
            case R.id.polyOneSix:
                m.setPolyDiv(1,6);
                Toast.makeText(this, "6", Toast.LENGTH_SHORT).show();
                tvPolyOne.setText("Poly 1\n" + String.valueOf(m.getPolyDiv(1)));
                return true;
            case R.id.polyOneSeven:
                m.setPolyDiv(1,7);
                Toast.makeText(this, "7", Toast.LENGTH_SHORT).show();
                tvPolyOne.setText("Poly 1\n" + String.valueOf(m.getPolyDiv(1)));
                return true;
            case R.id.polyOneEight:
                m.setPolyDiv(1,8);
                Toast.makeText(this, "8", Toast.LENGTH_SHORT).show();
                tvPolyOne.setText("Poly 1\n" + String.valueOf(m.getPolyDiv(1)));
                return true;
            case R.id.polyOneNine:
                m.setPolyDiv(1,9);
                Toast.makeText(this, "9", Toast.LENGTH_SHORT).show();
                tvPolyOne.setText("Poly 1\n" + String.valueOf(m.getPolyDiv(1)));
                return true;
            case R.id.polyOneTen:
                m.setPolyDiv(1,10);
                Toast.makeText(this, "10", Toast.LENGTH_SHORT).show();
                tvPolyOne.setText("Poly 1\n" + String.valueOf(m.getPolyDiv(1)));
                return true;
            case R.id.polyOneEleven:
                m.setPolyDiv(1,11);
                Toast.makeText(this, "11", Toast.LENGTH_SHORT).show();
                tvPolyOne.setText("Poly 1\n" + String.valueOf(m.getPolyDiv(1)));
                return true;
            case R.id.polyOneTwelve:
                m.setPolyDiv(1,12);
                Toast.makeText(this, "12", Toast.LENGTH_SHORT).show();
                tvPolyOne.setText("Poly 1\n" + String.valueOf(m.getPolyDiv(1)));
                return true;
            case R.id.polyOneThirteen:
                m.setPolyDiv(1,13);
                Toast.makeText(this, "13", Toast.LENGTH_SHORT).show();
                tvPolyOne.setText("Poly 1\n" + String.valueOf(m.getPolyDiv(1)));
                return true;
            case R.id.polyOneFourteen:
                m.setPolyDiv(1,14);
                Toast.makeText(this, "14", Toast.LENGTH_SHORT).show();
                tvPolyOne.setText("Poly 1\n" + String.valueOf(m.getPolyDiv(1)));
                return true;
            case R.id.polyOneFifteen:
                m.setPolyDiv(1,15);
                Toast.makeText(this, "15", Toast.LENGTH_SHORT).show();
                tvPolyOne.setText("Poly 1\n" + String.valueOf(m.getPolyDiv(1)));
                return true;
            case R.id.polyOneSixteen:
                m.setPolyDiv(1,16);
                Toast.makeText(this, "16", Toast.LENGTH_SHORT).show();
                tvPolyOne.setText("Poly 1\n" + String.valueOf(m.getPolyDiv(1)));
                return true;
            case R.id.polyOneSeventeen:
                m.setPolyDiv(1,17);
                Toast.makeText(this, "17", Toast.LENGTH_SHORT).show();
                tvPolyOne.setText("Poly 1\n" + String.valueOf(m.getPolyDiv(1)));
                return true;
            case R.id.polyOneEighteen:
                m.setPolyDiv(1,18);
                Toast.makeText(this, "18", Toast.LENGTH_SHORT).show();
                tvPolyOne.setText("Poly 1\n" + String.valueOf(m.getPolyDiv(1)));
                return true;
            case R.id.polyOneNineteen:
                m.setPolyDiv(1,19);
                Toast.makeText(this, "19", Toast.LENGTH_SHORT).show();
                tvPolyOne.setText("Poly 1\n" + String.valueOf(m.getPolyDiv(1)));
                return true;
            case R.id.polyOneTwenty:
                m.setPolyDiv(1,20);
                Toast.makeText(this, "20", Toast.LENGTH_SHORT).show();
                tvPolyOne.setText("Poly 1\n" + String.valueOf(m.getPolyDiv(1)));
                return true;
            case R.id.polyOneTwentyOne:
                m.setPolyDiv(1,21);
                Toast.makeText(this, "21", Toast.LENGTH_SHORT).show();
                tvPolyOne.setText("Poly 1\n" + String.valueOf(m.getPolyDiv(1)));
                return true;
            case R.id.polyOneTwentyTwo:
                m.setPolyDiv(1,22);
                Toast.makeText(this, "22", Toast.LENGTH_SHORT).show();
                tvPolyOne.setText("Poly 1\n" + String.valueOf(m.getPolyDiv(1)));
                return true;
            case R.id.polyOneTwentyThree:
                m.setPolyDiv(1,23);
                Toast.makeText(this, "23", Toast.LENGTH_SHORT).show();
                tvPolyOne.setText("Poly 1\n" + String.valueOf(m.getPolyDiv(1)));
                return true;
            case R.id.polyOneTwentyFour:
                m.setPolyDiv(1,24);
                Toast.makeText(this, "24", Toast.LENGTH_SHORT).show();
                tvPolyOne.setText("Poly 1\n" + String.valueOf(m.getPolyDiv(1)));
                return true;
            //Set Poly Two
            case R.id.polyTwoOne:
                m.setPolyDiv(2,1);
                Toast.makeText(this, "1", Toast.LENGTH_SHORT).show();
                tvPolyTwo.setText("Poly 2\noff");
                return true;
            case R.id.polyTwoTwo:
                m.setPolyDiv(2,2);
                Toast.makeText(this, "2", Toast.LENGTH_SHORT).show();
                tvPolyTwo.setText("Poly 2\n" + String.valueOf(m.getPolyDiv(2)));
                return true;
            case R.id.polyTwoThree:
                m.setPolyDiv(2,3);
                Toast.makeText(this, "3", Toast.LENGTH_SHORT).show();
                tvPolyTwo.setText("Poly 2\n" + String.valueOf(m.getPolyDiv(2)));
                return true;
            case R.id.polyTwoFour:
                m.setPolyDiv(2,4);
                Toast.makeText(this, "4", Toast.LENGTH_SHORT).show();
                tvPolyTwo.setText("Poly 2\n" + String.valueOf(m.getPolyDiv(2)));
                return true;
            case R.id.polyTwoFive:
                m.setPolyDiv(2,5);
                Toast.makeText(this, "5", Toast.LENGTH_SHORT).show();
                tvPolyTwo.setText("Poly 2\n" + String.valueOf(m.getPolyDiv(2)));
                return true;
            case R.id.polyTwoSix:
                m.setPolyDiv(2,6);
                Toast.makeText(this, "6", Toast.LENGTH_SHORT).show();
                tvPolyTwo.setText("Poly 2\n" + String.valueOf(m.getPolyDiv(2)));
                return true;
            case R.id.polyTwoSeven:
                m.setPolyDiv(2,7);
                Toast.makeText(this, "7", Toast.LENGTH_SHORT).show();
                tvPolyTwo.setText("Poly 2\n" + String.valueOf(m.getPolyDiv(2)));
                return true;
            case R.id.polyTwoEight:
                m.setPolyDiv(2,8);
                Toast.makeText(this, "8", Toast.LENGTH_SHORT).show();
                tvPolyTwo.setText("Poly 2\n" + String.valueOf(m.getPolyDiv(2)));
                return true;
            case R.id.polyTwoNine:
                m.setPolyDiv(2,9);
                Toast.makeText(this, "9", Toast.LENGTH_SHORT).show();
                tvPolyTwo.setText("Poly 2\n" + String.valueOf(m.getPolyDiv(2)));
                return true;
            case R.id.polyTwoTen:
                m.setPolyDiv(2,10);
                Toast.makeText(this, "10", Toast.LENGTH_SHORT).show();
                tvPolyTwo.setText("Poly 2\n" + String.valueOf(m.getPolyDiv(2)));
                return true;
            case R.id.polyTwoEleven:
                m.setPolyDiv(2,11);
                Toast.makeText(this, "11", Toast.LENGTH_SHORT).show();
                tvPolyTwo.setText("Poly 2\n" + String.valueOf(m.getPolyDiv(2)));
                return true;
            case R.id.polyTwoTwelve:
                m.setPolyDiv(2,12);
                Toast.makeText(this, "12", Toast.LENGTH_SHORT).show();
                tvPolyTwo.setText("Poly 2\n" + String.valueOf(m.getPolyDiv(2)));
                return true;
            case R.id.polyTwoThirteen:
                m.setPolyDiv(2,13);
                Toast.makeText(this, "13", Toast.LENGTH_SHORT).show();
                tvPolyTwo.setText("Poly 2\n" + String.valueOf(m.getPolyDiv(2)));
                return true;
            case R.id.polyTwoFourteen:
                m.setPolyDiv(2,14);
                Toast.makeText(this, "14", Toast.LENGTH_SHORT).show();
                tvPolyTwo.setText("Poly 2\n" + String.valueOf(m.getPolyDiv(2)));
                return true;
            case R.id.polyTwoFifteen:
                m.setPolyDiv(2,15);
                Toast.makeText(this, "15", Toast.LENGTH_SHORT).show();
                tvPolyTwo.setText("Poly 2\n" + String.valueOf(m.getPolyDiv(2)));
                return true;
            case R.id.polyTwoSixteen:
                m.setPolyDiv(2,16);
                Toast.makeText(this, "16", Toast.LENGTH_SHORT).show();
                tvPolyTwo.setText("Poly 2\n" + String.valueOf(m.getPolyDiv(2)));
                return true;
            case R.id.polyTwoSeventeen:
                m.setPolyDiv(2,17);
                Toast.makeText(this, "17", Toast.LENGTH_SHORT).show();
                tvPolyTwo.setText("Poly 2\n" + String.valueOf(m.getPolyDiv(2)));
                return true;
            case R.id.polyTwoEighteen:
                m.setPolyDiv(2,18);
                Toast.makeText(this, "18", Toast.LENGTH_SHORT).show();
                tvPolyTwo.setText("Poly 2\n" + String.valueOf(m.getPolyDiv(2)));
                return true;
            case R.id.polyTwoNineteen:
                m.setPolyDiv(2,19);
                Toast.makeText(this, "19", Toast.LENGTH_SHORT).show();
                tvPolyTwo.setText("Poly 2\n" + String.valueOf(m.getPolyDiv(2)));
                return true;
            case R.id.polyTwoTwenty:
                m.setPolyDiv(2,20);
                Toast.makeText(this, "20", Toast.LENGTH_SHORT).show();
                tvPolyTwo.setText("Poly 2\n" + String.valueOf(m.getPolyDiv(2)));
                return true;
            case R.id.polyTwoTwentyOne:
                m.setPolyDiv(2,21);
                Toast.makeText(this, "21", Toast.LENGTH_SHORT).show();
                tvPolyTwo.setText("Poly 2\n" + String.valueOf(m.getPolyDiv(2)));
                return true;
            case R.id.polyTwoTwentyTwo:
                m.setPolyDiv(2,22);
                Toast.makeText(this, "22", Toast.LENGTH_SHORT).show();
                tvPolyTwo.setText("Poly 2\n" + String.valueOf(m.getPolyDiv(2)));
                return true;
            case R.id.polyTwoTwentyThree:
                m.setPolyDiv(2,23);
                Toast.makeText(this, "23", Toast.LENGTH_SHORT).show();
                tvPolyTwo.setText("Poly 2\n" + String.valueOf(m.getPolyDiv(2)));
                return true;
            case R.id.polyTwoTwentyFour:
                m.setPolyDiv(2,24);
                Toast.makeText(this, "24", Toast.LENGTH_SHORT).show();
                tvPolyTwo.setText("Poly 2\n" + String.valueOf(m.getPolyDiv(2)));
                return true;
            //Set Poly Three
            case R.id.polyThreeOne:
                m.setPolyDiv(3,1);
                Toast.makeText(this, "1", Toast.LENGTH_SHORT).show();
                tvPolyThree.setText("Poly 3\noff");
                return true;
            case R.id.polyThreeTwo:
                m.setPolyDiv(3,2);
                Toast.makeText(this, "2", Toast.LENGTH_SHORT).show();
                tvPolyThree.setText("Poly 3\n" + String.valueOf(m.getPolyDiv(3)));
                return true;
            case R.id.polyThreeThree:
                m.setPolyDiv(3,3);
                Toast.makeText(this, "3", Toast.LENGTH_SHORT).show();
                tvPolyThree.setText("Poly 3\n" + String.valueOf(m.getPolyDiv(3)));
                return true;
            case R.id.polyThreeFour:
                m.setPolyDiv(3,4);
                Toast.makeText(this, "4", Toast.LENGTH_SHORT).show();
                tvPolyThree.setText("Poly 3\n" + String.valueOf(m.getPolyDiv(3)));
                return true;
            case R.id.polyThreeFive:
                m.setPolyDiv(3,5);
                Toast.makeText(this, "5", Toast.LENGTH_SHORT).show();
                tvPolyThree.setText("Poly 3\n" + String.valueOf(m.getPolyDiv(3)));
                return true;
            case R.id.polyThreeSix:
                m.setPolyDiv(3,6);
                Toast.makeText(this, "6", Toast.LENGTH_SHORT).show();
                tvPolyThree.setText("Poly 3\n" + String.valueOf(m.getPolyDiv(3)));
                return true;
            case R.id.polyThreeSeven:
                m.setPolyDiv(3,7);
                Toast.makeText(this, "7", Toast.LENGTH_SHORT).show();
                tvPolyThree.setText("Poly 3\n" + String.valueOf(m.getPolyDiv(3)));
                return true;
            case R.id.polyThreeEight:
                m.setPolyDiv(3,8);
                Toast.makeText(this, "8", Toast.LENGTH_SHORT).show();
                tvPolyThree.setText("Poly 3\n" + String.valueOf(m.getPolyDiv(3)));
                return true;
            case R.id.polyThreeNine:
                m.setPolyDiv(1,9);
                Toast.makeText(this, "9", Toast.LENGTH_SHORT).show();
                tvPolyThree.setText("Poly 1\n" + String.valueOf(m.getPolyDiv(1)));
                return true;
            case R.id.polyThreeTen:
                m.setPolyDiv(3,10);
                Toast.makeText(this, "10", Toast.LENGTH_SHORT).show();
                tvPolyThree.setText("Poly 3\n" + String.valueOf(m.getPolyDiv(3)));
                return true;
            case R.id.polyThreeEleven:
                m.setPolyDiv(3,11);
                Toast.makeText(this, "11", Toast.LENGTH_SHORT).show();
                tvPolyThree.setText("Poly 3\n" + String.valueOf(m.getPolyDiv(3)));
                return true;
            case R.id.polyThreeTwelve:
                m.setPolyDiv(3,12);
                Toast.makeText(this, "12", Toast.LENGTH_SHORT).show();
                tvPolyThree.setText("Poly 3\n" + String.valueOf(m.getPolyDiv(3)));
                return true;
            case R.id.polyThreeThirteen:
                m.setPolyDiv(3,13);
                Toast.makeText(this, "13", Toast.LENGTH_SHORT).show();
                tvPolyThree.setText("Poly 3\n" + String.valueOf(m.getPolyDiv(3)));
                return true;
            case R.id.polyThreeFourteen:
                m.setPolyDiv(3,14);
                Toast.makeText(this, "14", Toast.LENGTH_SHORT).show();
                tvPolyThree.setText("Poly 3\n" + String.valueOf(m.getPolyDiv(3)));
                return true;
            case R.id.polyThreeFifteen:
                m.setPolyDiv(3,15);
                Toast.makeText(this, "15", Toast.LENGTH_SHORT).show();
                tvPolyThree.setText("Poly 3\n" + String.valueOf(m.getPolyDiv(3)));
                return true;
            case R.id.polyThreeSixteen:
                m.setPolyDiv(3,16);
                Toast.makeText(this, "16", Toast.LENGTH_SHORT).show();
                tvPolyThree.setText("Poly 3\n" + String.valueOf(m.getPolyDiv(3)));
                return true;
            case R.id.polyThreeSeventeen:
                m.setPolyDiv(3,17);
                Toast.makeText(this, "17", Toast.LENGTH_SHORT).show();
                tvPolyThree.setText("Poly 3\n" + String.valueOf(m.getPolyDiv(3)));
                return true;
            case R.id.polyThreeEighteen:
                m.setPolyDiv(3,18);
                Toast.makeText(this, "18", Toast.LENGTH_SHORT).show();
                tvPolyThree.setText("Poly 3\n" + String.valueOf(m.getPolyDiv(3)));
                return true;
            case R.id.polyThreeNineteen:
                m.setPolyDiv(3,19);
                Toast.makeText(this, "19", Toast.LENGTH_SHORT).show();
                tvPolyThree.setText("Poly 3\n" + String.valueOf(m.getPolyDiv(3)));
                return true;
            case R.id.polyThreeTwenty:
                m.setPolyDiv(3,20);
                Toast.makeText(this, "20", Toast.LENGTH_SHORT).show();
                tvPolyThree.setText("Poly 3\n" + String.valueOf(m.getPolyDiv(3)));
                return true;
            case R.id.polyThreeTwentyOne:
                m.setPolyDiv(3,21);
                Toast.makeText(this, "21", Toast.LENGTH_SHORT).show();
                tvPolyThree.setText("Poly 3\n" + String.valueOf(m.getPolyDiv(3)));
                return true;
            case R.id.polyThreeTwentyTwo:
                m.setPolyDiv(3,22);
                Toast.makeText(this, "22", Toast.LENGTH_SHORT).show();
                tvPolyThree.setText("Poly 3\n" + String.valueOf(m.getPolyDiv(3)));
                return true;
            case R.id.polyThreeTwentyThree:
                m.setPolyDiv(3,23);
                Toast.makeText(this, "23", Toast.LENGTH_SHORT).show();
                tvPolyThree.setText("Poly 3\n" + String.valueOf(m.getPolyDiv(3)));
                return true;
            case R.id.polyThreeTwentyFour:
                m.setPolyDiv(3,24);
                Toast.makeText(this, "24", Toast.LENGTH_SHORT).show();
                tvPolyThree.setText("Poly 3\n" + String.valueOf(m.getPolyDiv(3)));
                return true;
            //Set Poly Four
            case R.id.polyFourOne:
                m.setPolyDiv(4,1);
                Toast.makeText(this, "1", Toast.LENGTH_SHORT).show();
                tvPolyFour.setText("Poly 4\noff");
                return true;
            case R.id.polyFourTwo:
                m.setPolyDiv(4,2);
                Toast.makeText(this, "2", Toast.LENGTH_SHORT).show();
                tvPolyFour.setText("Poly 4\n" + String.valueOf(m.getPolyDiv(4)));
                return true;
            case R.id.polyFourThree:
                m.setPolyDiv(4,3);
                Toast.makeText(this, "3", Toast.LENGTH_SHORT).show();
                tvPolyFour.setText("Poly 4\n" + String.valueOf(m.getPolyDiv(4)));
                return true;
            case R.id.polyFourFour:
                m.setPolyDiv(4,4);
                Toast.makeText(this, "4", Toast.LENGTH_SHORT).show();
                tvPolyFour.setText("Poly 4\n" + String.valueOf(m.getPolyDiv(4)));
                return true;
            case R.id.polyFourFive:
                m.setPolyDiv(4,5);
                Toast.makeText(this, "5", Toast.LENGTH_SHORT).show();
                tvPolyFour.setText("Poly 4\n" + String.valueOf(m.getPolyDiv(4)));
                return true;
            case R.id.polyFourSix:
                m.setPolyDiv(4,6);
                Toast.makeText(this, "6", Toast.LENGTH_SHORT).show();
                tvPolyFour.setText("Poly 4\n" + String.valueOf(m.getPolyDiv(4)));
                return true;
            case R.id.polyFourSeven:
                m.setPolyDiv(4,7);
                Toast.makeText(this, "7", Toast.LENGTH_SHORT).show();
                tvPolyFour.setText("Poly 4\n" + String.valueOf(m.getPolyDiv(4)));
                return true;
            case R.id.polyFourEight:
                m.setPolyDiv(4,8);
                Toast.makeText(this, "8", Toast.LENGTH_SHORT).show();
                tvPolyFour.setText("Poly 4\n" + String.valueOf(m.getPolyDiv(4)));
                return true;
            case R.id.polyFourNine:
                m.setPolyDiv(4,9);
                Toast.makeText(this, "9", Toast.LENGTH_SHORT).show();
                tvPolyFour.setText("Poly 4\n" + String.valueOf(m.getPolyDiv(4)));
                return true;
            case R.id.polyFourTen:
                m.setPolyDiv(4,10);
                Toast.makeText(this, "10", Toast.LENGTH_SHORT).show();
                tvPolyFour.setText("Poly 4\n" + String.valueOf(m.getPolyDiv(4)));
                return true;
            case R.id.polyFourEleven:
                m.setPolyDiv(4,11);
                Toast.makeText(this, "11", Toast.LENGTH_SHORT).show();
                tvPolyFour.setText("Poly 4\n" + String.valueOf(m.getPolyDiv(4)));
                return true;
            case R.id.polyFourTwelve:
                m.setPolyDiv(4,12);
                Toast.makeText(this, "12", Toast.LENGTH_SHORT).show();
                tvPolyFour.setText("Poly 4\n" + String.valueOf(m.getPolyDiv(4)));
                return true;
            case R.id.polyFourThirteen:
                m.setPolyDiv(4,13);
                Toast.makeText(this, "13", Toast.LENGTH_SHORT).show();
                tvPolyFour.setText("Poly 4\n" + String.valueOf(m.getPolyDiv(4)));
                return true;
            case R.id.polyFourFourteen:
                m.setPolyDiv(4,14);
                Toast.makeText(this, "14", Toast.LENGTH_SHORT).show();
                tvPolyFour.setText("Poly 4\n" + String.valueOf(m.getPolyDiv(4)));
                return true;
            case R.id.polyFourFifteen:
                m.setPolyDiv(4,15);
                Toast.makeText(this, "15", Toast.LENGTH_SHORT).show();
                tvPolyFour.setText("Poly 4\n" + String.valueOf(m.getPolyDiv(4)));
                return true;
            case R.id.polyFourSixteen:
                m.setPolyDiv(4,16);
                Toast.makeText(this, "16", Toast.LENGTH_SHORT).show();
                tvPolyFour.setText("Poly 4\n" + String.valueOf(m.getPolyDiv(4)));
                return true;
            case R.id.polyFourSeventeen:
                m.setPolyDiv(4,17);
                Toast.makeText(this, "17", Toast.LENGTH_SHORT).show();
                tvPolyFour.setText("Poly 4\n" + String.valueOf(m.getPolyDiv(4)));
                return true;
            case R.id.polyFourEighteen:
                m.setPolyDiv(4,18);
                Toast.makeText(this, "18", Toast.LENGTH_SHORT).show();
                tvPolyFour.setText("Poly 4\n" + String.valueOf(m.getPolyDiv(4)));
                return true;
            case R.id.polyFourNineteen:
                m.setPolyDiv(4,19);
                Toast.makeText(this, "19", Toast.LENGTH_SHORT).show();
                tvPolyFour.setText("Poly 4\n" + String.valueOf(m.getPolyDiv(4)));
                return true;
            case R.id.polyFourTwenty:
                m.setPolyDiv(4,20);
                Toast.makeText(this, "20", Toast.LENGTH_SHORT).show();
                tvPolyFour.setText("Poly 4\n" + String.valueOf(m.getPolyDiv(4)));
                return true;
            case R.id.polyFourTwentyOne:
                m.setPolyDiv(4,21);
                Toast.makeText(this, "21", Toast.LENGTH_SHORT).show();
                tvPolyFour.setText("Poly 4\n" + String.valueOf(m.getPolyDiv(4)));
                return true;
            case R.id.polyFourTwentyTwo:
                m.setPolyDiv(4,22);
                Toast.makeText(this, "22", Toast.LENGTH_SHORT).show();
                tvPolyFour.setText("Poly 4\n" + String.valueOf(m.getPolyDiv(4)));
                return true;
            case R.id.polyFourTwentyThree:
                m.setPolyDiv(4,23);
                Toast.makeText(this, "23", Toast.LENGTH_SHORT).show();
                tvPolyFour.setText("Poly 4\n" + String.valueOf(m.getPolyDiv(4)));
                return true;
            case R.id.polyFourTwentyFour:
                m.setPolyDiv(4,24);
                Toast.makeText(this, "24", Toast.LENGTH_SHORT).show();
                tvPolyFour.setText("Poly 4\n" + String.valueOf(m.getPolyDiv(4)));
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

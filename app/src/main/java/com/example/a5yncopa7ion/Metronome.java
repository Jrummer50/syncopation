package com.example.a5yncopa7ion;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.os.Build;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

import android.media.SoundPool;


public class Metronome {
    protected int bpm = 60;
    protected int subDiv = 1;
    private int currentBeat = 1;
    private int beatsInMeasure = 4;
    private int bottomSig = 4;
    private int beatType = 4;
    private int currentSubDiv;
    private int subDivBeats;
    protected boolean playing = false;
    Timer timer;
    TimerTask task = null;
    Timer timer2;
    TimerTask task2 = null;
    Timer timer3;
    TimerTask task3 = null;
    Timer timer4;
    TimerTask task4 = null;
    Timer timer5;
    TimerTask task5 = null;
    Context context;
    private long length;

    private int poly1Start = 6;
    private int poly1Div = 1;//3;

    private int poly2Start = 4;
    private int poly2Div = 1;//5;

    private int poly3Start = 2;
    private int poly3Div = 1;//7;

    private int poly4Start = 0;
    private int poly4Div = 1;//11;


    private SoundPool soundPool;

    private int sound1, sound2, sound3, sound4, sound5, sound6;


    Metronome(Context context) {
        this.context = context;
        timer = new Timer();
        timer2 = new Timer();
        timer3 = new Timer();
        timer4 = new Timer();
        timer5 = new Timer();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build();

            this.soundPool = new SoundPool.Builder()
                    .setMaxStreams(10)
                    .setAudioAttributes(audioAttributes)
                    .build();
        } else {
            this.soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
        }

        this.sound2 = soundPool.load(context, R.raw.subdiv,1);
        this.sound1 = soundPool.load(context, R.raw.mainpulse,1);
        this.sound3 = soundPool.load(context, R.raw.polyone,1);
        this.sound4 = soundPool.load(context, R.raw.polytwo,1);
        this.sound5 = soundPool.load(context, R.raw.polythree,1);
        this.sound6 = soundPool.load(context, R.raw.polyfour,1);
    }


    protected int getBpm () {
        return this.bpm;
    }

    protected void setBpm (int bpm) {
        this.bpm = bpm;
    }

    protected int getSubDiv () {
        return this.subDiv;
    }

    protected void setSubDiv (int subDiv) {
        this.subDiv = subDiv;
    }

    protected int getCurrentSubDiv () {
        return this.currentSubDiv;
    }

    protected void setCurrentSubDiv (int currentSubDiv) {
        this.currentSubDiv = currentSubDiv;
    }

    protected void setSubDivBeats (int beatsInMeasure, int subDiv) {
        this.subDivBeats = beatsInMeasure * subDiv;
    }

    protected int incrCurrentSubDiv (int currentSubDiv) {
        this.currentSubDiv = currentSubDiv +1;
        return this.currentSubDiv;
    }

    protected int getBottomSig () {
        return this.bottomSig;
    }

    protected int getBeatsInMeasure () {
        return this.beatsInMeasure;
    }

    protected void setBeatsInMeasure (int beatsInMeasure) {
        this.beatsInMeasure = beatsInMeasure;
    }

    protected boolean isPlaying () {
        return playing;
    }

    protected void setPlaying (boolean playing) {
        this.playing = playing;
    }

    protected int getPolyDiv (int poly) {
        int retval = 0;
        switch (poly)
        {
            case 1:
                retval = poly1Div;
                break;
            case 2:
                retval = poly2Div;
                break;
            case 3:
                retval = poly3Div;
                break;
            case 4:
                retval = poly4Div;
                break;
            default:
                break;
        }
        return retval;
    }

    protected void setPolyDiv (int poly, int val) {
        switch (poly)
        {
            case 1:
                poly1Div = val;
                break;
            case 2:
                poly2Div = val;
                break;
            case 3:
                poly3Div = val;
                break;
            case 4:
                poly4Div = val;
                break;
            default:
                break;
        }
    }



    private void advanceSub () {
        //Log.d("Beat", String.valueOf(subDivBeats));
        //Log.d("Beat", String.valueOf(currentSubDiv));
        if (currentSubDiv == subDivBeats) {
            currentBeat = 1;
            setCurrentSubDiv(0);
        }

        if (getCurrentSubDiv() % getSubDiv() != 0) {
            Log.d("BEAT", String.valueOf("&"));
            soundPool.play(sound2, 1, 1, 0, 0, 1);
        } else {
            Log.d("BEAT", String.valueOf(currentBeat));
            soundPool.play(sound1, 1, 1, 0, 0, 1);
            ++currentBeat;
        }
        incrCurrentSubDiv(getCurrentSubDiv());

    }



    protected void startClick () {
        setPlaying(true);

        currentBeat = 1;
        setCurrentSubDiv(0);
        setSubDivBeats(getBeatsInMeasure(),getSubDiv());
        long pulse = (Math.round(60000/(float)bpm));
        long length = (Math.round(60000/(float)bpm))/subDiv;
        this.length = length;
        //Log.d("LENGTH", String.valueOf(length));

        task = new TimerTask() { public void run() { advanceSub(); } };

        if(poly1Div > 1){
            task2 = new TimerTask() { public void run() { soundPool.play(sound3, 1, 1, 0, 0, 1);; } };
        }

        if(poly2Div > 1){
            task3 = new TimerTask() { public void run() { soundPool.play(sound4, 1, 1, 0, 0, 1); } };
        }

        if(poly3Div > 1){
            task4 = new TimerTask() { public void run() { soundPool.play(sound5, 1, 1, 0, 0, 1); } };
        }

        if(poly4Div > 1){
            task5 = new TimerTask() { public void run() { soundPool.play(sound6, 1, 1, 0, 0, 1); } };
        }

        timer.scheduleAtFixedRate(task, 8, this.length);
        //timer2.scheduleAtFixedRate(task2, poly1Start, 4*length/5);

        if(poly1Div > 1){
            timer2.scheduleAtFixedRate(task2, poly1Start, beatsInMeasure*pulse/poly1Div);
        }

        if(poly2Div > 1){
            timer3.scheduleAtFixedRate(task3, poly2Start, beatsInMeasure*pulse/poly2Div);
        }

        if(poly3Div > 1){
            timer4.scheduleAtFixedRate(task4, poly3Start, beatsInMeasure*pulse/poly3Div);
        }

        if(poly4Div > 1){
            timer5.scheduleAtFixedRate(task5, poly4Start, beatsInMeasure*pulse/poly4Div);
        }

    }
    
    protected void stopClick () {
        task.cancel();
        if(task2 != null) {
            task2.cancel();
        }
        if(task3 != null) {
            task3.cancel();
        }
        if(task4 != null) {
            task4.cancel();
        }
        if(task5 != null) {
            task5.cancel();
        }
        task = null;
        task2 = null;
        task3 = null;
        task4 = null;
        task5 = null;
        setPlaying(false);
    }

}

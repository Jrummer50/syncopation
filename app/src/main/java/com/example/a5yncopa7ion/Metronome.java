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
    protected int subDiv = 4;
    private int currentBeat = 1;
    private int beatsInMeasure = 4;
    private int bottomSig = 4;
    private int beatType = 4;
    private int currentSubDiv;
    private int subDivBeats;
    protected volatile boolean playing = false;
    Timer timer;
    TimerTask task = null;
    Timer timer2;
    TimerTask task2 = null;
    Context context;
    private long length;


    private SoundPool soundPool;

    private volatile int sound1, sound2;


    Metronome(Context context) {
        this.context = context;
        timer = new Timer();

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
        //this.soundPool = soundPool;
        //this.sound1 = sound1;
        //this.sound2 = sound2;
        this.sound2 = soundPool.load(context, R.raw.subdiv,1);
        this.sound1 = soundPool.load(context, R.raw.mainpulse,1);
    }

    Metronome(int bpm, int subDiv, int beatsInMeasure) {
        this.bpm = bpm;
        this.subDiv = subDiv;
        this.beatsInMeasure = beatsInMeasure;
        timer = new Timer();
    }

    Metronome (SoundPool soundPool, int sound1, int sound2) {
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
        //this.soundPool = soundPool;
        //this.sound1 = sound1;
        //this.sound2 = sound2;
        this.sound1 = soundPool.load(context, R.raw.pulse,1);
    }

    protected void soundBuild() {
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
        //this.soundPool = soundPool;
        //this.sound1 = sound1;
        //this.sound2 = sound2;
        this.sound1 = soundPool.load(context, R.raw.pulse,1);
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

    /*private void advanceClick () {
        if (playing) {
            //System.out.println(currentBeat);
            Log.d("BEAT", String.valueOf(currentBeat));
            if (currentBeat == beatsInMeasure) {
                currentBeat = 1;
            } else {
                ++currentBeat;
            }
        }
    }*/

    private void advanceClick () {
        //System.out.println(currentBeat);
        soundPool.play(sound1, 1, 1, 0,0,1);
        Log.d("BEAT", String.valueOf(currentBeat));
        if (currentBeat == beatsInMeasure) {
            currentBeat = 1;
        } else {
            ++currentBeat;
        }
        /*if (subDiv > 1) {
            timer2.schedule(task2, length/2);
        }*/
    }

    private void advanceSub () {
        //Log.d("Beat", String.valueOf(subDivBeats));
        //Log.d("Beat", String.valueOf(currentSubDiv));
        //soundPool.play(sound1, 1, 1, 0, 0, 1);
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
        //soundBuild();
        currentBeat = 1;
        setCurrentSubDiv(0);
        setSubDivBeats(getBeatsInMeasure(),getSubDiv());
        long length = (Math.round(60000/(float)bpm))/subDiv;
        this.length = length;
        Log.d("LENGTH", String.valueOf(length));
        //task = new TimerTask() { public void run() { advanceClick(); } };
        task = new TimerTask() { public void run() { advanceSub(); } };
        timer.scheduleAtFixedRate(task, 1, this.length);
        //timer2.schedule(task2, length/2);
    }

    /*if (subDiv != 1) {
            subTask = new TimerTask() {
                @Override
                public void run() {
                    Log.d("BEAT", "&");
                }
            };
            for ( int count = 0; count < subDiv; ++count ) {
                if ( count != 1) {
                    timer.schedule(subTask,length/subDiv);
                }
            }
        }*/


    protected void stopClick () {
        task.cancel();
        task = null;
        setPlaying(false);
    }






}

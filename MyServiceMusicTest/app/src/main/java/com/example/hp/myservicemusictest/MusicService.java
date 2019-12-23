package com.example.hp.myservicemusictest;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

public class MusicService extends Service {
    private MediaPlayer mediaPlayer;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    // 생명주기 3가지 가져오기
    @Override
    public void onCreate() {
        android.util.Log.i("MusicService", "onCreate()");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        android.util.Log.i("MusicService", "onStartCommand()");
        super.onDestroy();
        mediaPlayer = MediaPlayer.create(this, R.raw.love_poem);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        android.util.Log.i("MusicService", "onDestroy()");
        mediaPlayer.stop();
        super.onDestroy();
    }
}
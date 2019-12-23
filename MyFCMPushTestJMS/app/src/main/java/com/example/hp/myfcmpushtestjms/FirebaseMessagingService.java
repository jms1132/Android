package com.example.hp.myfcmpushtestjms;


import android.annotation.SuppressLint;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.RemoteMessage;

public class FirebaseMessagingService extends com.google.firebase.messaging.FirebaseMessagingService {
    private static final String TAG = "FirebaseMessagingService";
    private String msg, title;

    @SuppressLint("LongLogTag")
    @Override //firebase 로부터 메시지를 받을 때 알려주는 핸들러함수
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.d(TAG, "onMessageReceived");
        title = remoteMessage.getNotification().getTitle();
        msg = remoteMessage.getNotification().getBody();

        //참고: FLAG_ACTIVITY_CLEAR_TOP
        //스택에 기존에 사용하던 Activity가 있다면 그 위의 스택을 전부 제거해 주고 호출한다.
        //0->1->2->3 일때 Activity 3에서 Activity 1을 호출할때 이 플래그를 설정하면
        //0->1 만 남게 된다. (2, 3은 제거)  이때 Activity 1은 onDestory() -> onCreate()가 호출된다.
        //삭제하고 다시 만들게 된다.

        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        //펜딩인텐트 (Pending Intent) 는 인텐트의 일종이다. 컴포넌트에서 다른 컴포넌트에게
        //작업을 요청하는 인텐트를 사전에 생성시키고 만든다는 점과 "특정 시점"에 자신이 아닌
        //다른 컴포넌트들이 펜딩인텐트를 사용하여 다른 컴포넌트에게 작업을 요청시키는 데
        //사용된다는 점이 차이점이다.
        //수행시킬 작업 및 인텐트(실행의도)와 및 그것을 수행하는 주체를 지정하기 위한 정보를
        //명시 할 수 있는 기능의 클래스라고 보면 된다.
        //A한테 이 B인텐트를 C시점에 실행하라고 해. 지금은 실행하지 말고.

        //Activity를 시작하는(여기서는 Activity는 MainActivity 말함) 인텐트를 생성함.
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, new Intent(this, MainActivity.class), 0);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(title)
                .setContentText(msg)
                .setAutoCancel(true)
                //통지메세지가 올 때 사운드 소리
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                //바이브레이션 1초동안진동
                .setVibrate(new long[]{1, 1000});

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, builder.build());
        builder.setContentIntent(pendingIntent);
    }
}




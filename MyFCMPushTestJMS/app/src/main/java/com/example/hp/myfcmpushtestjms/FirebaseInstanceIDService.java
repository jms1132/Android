package com.example.hp.myfcmpushtestjms;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class FirebaseInstanceIDService extends FirebaseInstanceIdService {
    private static final String TAG ="MyFirebaseIIDService";
    
    @Override
    public void onTokenRefresh() {

        String token = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, token);
    sendRegistrationToServer(token);

    }

    private void sendRegistrationToServer(String token) {
    // 나중에 서버에 정보를 보낼 때 사용함 : 지금 사용하지 않음
    }
}

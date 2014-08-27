package com.example.powertomusic;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.PowerManager;
import android.os.SystemClock;
import android.view.KeyEvent;


public class PowerToMusicReceiver extends BroadcastReceiver {

	@SuppressWarnings("deprecation")
	@Override
	public void onReceive(Context context, Intent intent) {
		boolean connected = intent.getAction() == "android.intent.action.ACTION_POWER_CONNECTED";
		boolean disconnected = !connected && intent.getAction() == "android.intent.action.ACTION_POWER_DISCONNECTED";
		PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
		AudioManager am = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);

		if (connected) {
			pm.wakeUp(SystemClock.uptimeMillis());
		}
		
		if ((connected || disconnected) && am.isWiredHeadsetOn()) 
		{
			Utils.sendMediaButton(context, KeyEvent.KEYCODE_MEDIA_PAUSE);
		}
		if (disconnected) {
			pm.goToSleep(SystemClock.uptimeMillis());
		}
			
	}
}

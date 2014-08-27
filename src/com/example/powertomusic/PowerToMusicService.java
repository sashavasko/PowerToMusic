package com.example.powertomusic;

import android.app.IntentService;
import android.content.Intent;
import android.view.KeyEvent;

public class PowerToMusicService extends IntentService {

	public PowerToMusicService(String name) {
		super(name);
	}

	public PowerToMusicService() {
		super("PowerToMusicService");
	}
	
	@Override
	protected void onHandleIntent(Intent intent) {
		if (intent.getAction() == "android.intent.action.ACTION_POWER_DISCONNECTED" || 
				intent.getAction() == "android.intent.action.ACTION_POWER_CONNECTED") {
			Utils.sendMediaButton(this, KeyEvent.KEYCODE_MEDIA_PAUSE);
		}
	}

}

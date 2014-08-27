package com.example.powertomusic;

import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;

public class Utils {

	public static void sendMediaButton(Context context, int keyCode) {
		KeyEvent keyEvent = new KeyEvent(KeyEvent.ACTION_DOWN, keyCode);
		Intent intent = new Intent(Intent.ACTION_MEDIA_BUTTON);
		intent.putExtra(Intent.EXTRA_KEY_EVENT, keyEvent);
		context.sendBroadcast(intent);

		keyEvent = new KeyEvent(KeyEvent.ACTION_UP, keyCode);
		intent = new Intent(Intent.ACTION_MEDIA_BUTTON);
		intent.putExtra(Intent.EXTRA_KEY_EVENT, keyEvent);
		context.sendBroadcast(intent);
	}
	

}

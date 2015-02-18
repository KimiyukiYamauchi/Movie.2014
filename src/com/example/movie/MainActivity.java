package com.example.movie;

import java.io.File;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends Activity 
	implements OnClickListener
{
	
	private VideoView vview = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		LinearLayout layout = new LinearLayout(this);
		layout.setBackgroundColor(Color.WHITE);
		layout.setOrientation(LinearLayout.VERTICAL);
		setContentView(layout);
		
		Button btn = new Button(this);
		btn.setText("PLAY VIDEO");
		btn.setTag("btn1");
		btn.setOnClickListener(this);
		layout.addView(btn);
		
		Button btn2 = new Button(this);
		btn2.setText("STOP VIDEO");
		btn2.setTag("btn2");
		btn2.setOnClickListener(this);
		layout.addView(btn2);
		
		vview = new VideoView(this);
		vview.requestFocus();
		vview.setMediaController(new MediaController(this));
		layout.addView(vview);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		String tag = (String)v.getTag();
		if(tag == "btn1"){
			File sdcard = Environment.getExternalStorageDirectory();
//			playVideo(sdcard + "/Movies/video1.mp4");
			playVideo(sdcard + "/video1.mp4");
		}else if(tag == "btn2"){
			stopVideo();
		}
	}

	private void playVideo(String path){
		vview.setVideoPath(path);
		vview.start();
	}
	private void stopVideo(){
		vview.stopPlayback();
	}
}

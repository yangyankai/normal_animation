package com.yaong.stretch_buttons;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends Activity {
	ImageButton btnMore;
	ImageButton btnSet;
	ImageButton btnAbout;
	ImageButton btnHelp;
	ImageButton btnMusic;
	ImageButton btnExit;
	
	private final static int PLAY = 0;
	private final static int MORE = 1;
	private final static int TOP=2;
	private final static int SET=3;
	private final static int ABOUT=4;
	private final static int HELP=5;
	private final static int MUSIC=6;
	private final static int EXIT=7;
	private float density ;
	private boolean bOpen ; 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		bOpen = false ;
		DisplayMetrics dm = new DisplayMetrics();  
		dm = getResources().getDisplayMetrics();  
		density  = dm.density;
		btnMore = (ImageButton) findViewById(R.id.btn_start_more);
		btnMore.setOnClickListener(new OnButtonClickListenrer(MORE));
		btnSet = (ImageButton) findViewById(R.id.btn_start_set);
		btnSet.setOnClickListener(new OnButtonClickListenrer(SET));
		btnAbout = (ImageButton) findViewById(R.id.btn_start_about);
		
		btnAbout.setOnClickListener(new OnButtonClickListenrer(ABOUT));
		btnHelp = (ImageButton) findViewById(R.id.btn_start_help);
		btnHelp.setOnClickListener(new OnButtonClickListenrer(HELP));
		btnMusic = (ImageButton) findViewById(R.id.btn_start_music);
		btnMusic.setOnClickListener(new OnButtonClickListenrer(MUSIC));
		
		btnAbout.setVisibility(View.INVISIBLE);
		btnHelp.setVisibility(View.INVISIBLE);
		btnMusic.setVisibility(View.INVISIBLE);
        btnMore.setVisibility(View.INVISIBLE);
	}

	class OnButtonClickListenrer implements Button.OnClickListener {
		int iButtonClass;

		public OnButtonClickListenrer(int iButtonClass) {
			this.iButtonClass = iButtonClass;
		}

		@Override
		public void onClick(View v) {
			switch (iButtonClass) {
			case MORE:
				Log.e("cc", "click - more");
				break;
			case PLAY:
				Log.e("cc", "click - play");
				break;
			case TOP:
				Log.e("cc", "click - top");
				break;
			case SET:
				if (bOpen) {
					Log.e("cc", "click - set close");
					TranslateAnimation ta1 = new TranslateAnimation(Animation.ABSOLUTE, 0, Animation.ABSOLUTE, 0, Animation.RELATIVE_TO_SELF, 0, Animation.ABSOLUTE, 220*density);
					ta1.setFillAfter(true);
					ta1.setDuration(300);
					btnMore.startAnimation(ta1);
					btnMore.setVisibility(View.INVISIBLE);
					btnMore.setEnabled(false);
					TranslateAnimation ta2 = new TranslateAnimation(Animation.ABSOLUTE, 0, Animation.ABSOLUTE, 0, Animation.RELATIVE_TO_SELF, 0, Animation.ABSOLUTE, 170*density);
					ta2.setFillAfter(true);
					ta2.setDuration(300);
					btnMusic.startAnimation(ta2);
					btnMusic.setVisibility(View.INVISIBLE);
					btnMusic.setEnabled(false);
					TranslateAnimation ta3 = new TranslateAnimation(Animation.ABSOLUTE, 0, Animation.ABSOLUTE, 0, Animation.RELATIVE_TO_SELF, 0, Animation.ABSOLUTE, 120*density);
					ta3.setFillAfter(true);
					ta3.setDuration(300);
					btnHelp.startAnimation(ta3);
					btnHelp.setVisibility(View.INVISIBLE);
					btnHelp.setEnabled(false);
					TranslateAnimation ta4 = new TranslateAnimation(Animation.ABSOLUTE, 0, Animation.ABSOLUTE, 0, Animation.RELATIVE_TO_SELF, 0, Animation.ABSOLUTE, 70*density);
					ta4.setFillAfter(true);
					ta4.setDuration(300);
					btnAbout.startAnimation(ta4);
					btnAbout.setVisibility(View.INVISIBLE);
					btnAbout.setEnabled(false);
					bOpen = false ;
				} else {
					Log.e("cc", "click - set open");
					TranslateAnimation ta1 = new TranslateAnimation(Animation.ABSOLUTE, 0, Animation.ABSOLUTE, 0, Animation.ABSOLUTE, 220*density, Animation.RELATIVE_TO_SELF, 0);
					ta1.setFillAfter(true);
					ta1.setDuration(300);
					btnMore.startAnimation(ta1);
					btnMore.setVisibility(View.VISIBLE);
					btnMore.setEnabled(true);
					TranslateAnimation ta2 = new TranslateAnimation(Animation.ABSOLUTE, 0, Animation.ABSOLUTE, 0, Animation.ABSOLUTE, 170*density, Animation.RELATIVE_TO_SELF,0);
					ta2.setFillAfter(true);
					ta2.setDuration(300);
					btnMusic.startAnimation(ta2);
					btnMusic.setVisibility(View.VISIBLE);
					btnMusic.setEnabled(true);
					TranslateAnimation ta3 = new TranslateAnimation(Animation.ABSOLUTE, 0, Animation.ABSOLUTE, 0, Animation.ABSOLUTE, 120*density, Animation.RELATIVE_TO_SELF,0);
					ta3.setFillAfter(true);
					ta3.setDuration(300);
					btnHelp.startAnimation(ta3);
					btnHelp.setVisibility(View.VISIBLE);
					btnHelp.setEnabled(true);
					TranslateAnimation ta4 = new TranslateAnimation(Animation.ABSOLUTE, 0, Animation.ABSOLUTE, 0, Animation.ABSOLUTE, 70*density, Animation.RELATIVE_TO_SELF,0);
					ta4.setFillAfter(true);
					ta4.setDuration(300);
					btnAbout.startAnimation(ta4);
					btnAbout.setVisibility(View.VISIBLE);
					btnAbout.setEnabled(true);
					bOpen = true ;
				}
				break ;
			case ABOUT:
				Log.e("cc", "click - about");	
				
				break ;
			case HELP:
				Log.e("cc", "click - help");
				break ;
			case MUSIC:
				Log.e("cc", "click - music ");
				break ;
			case EXIT:
				Log.e("cc", "click - exit ");
				break ;
			default:
				break;
			}
		}

	}
	

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}

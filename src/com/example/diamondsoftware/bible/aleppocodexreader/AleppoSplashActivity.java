package com.example.diamondsoftware.bible.aleppocodexreader;
/*
 * Code by M Robertson, UK 2013
 * maracx@gmail.com
 */

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class AleppoSplashActivity extends AleppoActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_aleppo_splash);
		
		TextView logo1 = (TextView) findViewById(R.id.TextViewTopTitle);
		Animation fade1 = AnimationUtils.loadAnimation(this,  R.anim.fade_in);
		logo1.startAnimation(fade1);
		fade1.setAnimationListener(new AnimationListener()
	    {   public void onAnimationEnd(Animation animation) 
	        {   
	            Intent intent = new Intent(AleppoSplashActivity.this, AleppoMainMenuActivity.class);
	            startActivity(intent);      
	            finish();
	        }
	
		@Override
		public void onAnimationRepeat(Animation arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onAnimationStart(Animation arg0) {
			// TODO Auto-generated method stub
			
		}});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.aleppo, menu);
		return true;
	}

	@Override
	public void onPause() {
		super.onPause();
		TextView logo1 = (TextView) findViewById(R.id.TextViewTopTitle);
		logo1.clearAnimation();
	}
	
}

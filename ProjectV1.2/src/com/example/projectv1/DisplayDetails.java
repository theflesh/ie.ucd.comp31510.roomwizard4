package com.example.projectv1;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class DisplayDetails extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_details);
		
		TextView content = new TextView(this);
		content = (TextView) findViewById(R.id.detailsContent);

		Bundle submitted = getIntent().getExtras();
		String uid = submitted.getString("uid");
		String display;
		
		if(!uid.equals("")){
			
			String summary = submitted.getString("summary");
			String start   = submitted.getString("start");
			String end     = submitted.getString("end");
			String url     = submitted.getString("url");
			
			display = "Summary: " + summary + " \n" +
					"Time: " + start + " - " + end + " \n" +
							"URL: " + url + "\n";
		}
		else{
			display = "The room is not occupied at that time"; 
		}
		content.setText(display);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_display_details, menu);
		return true;
	}
	public void buttonClick(View v)
	{
		switch(v.getId())
		{
		case R.id.back_from_details:
			finish();
			break;
		}
	}
}
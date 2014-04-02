package com.dd.timetable;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends Activity{
	Button update, viewall, viewsch;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);
		
		
		update = (Button)findViewById(R.id.button1);
		viewall = (Button)findViewById(R.id.button2);
		viewsch = (Button)findViewById(R.id.button3);
		
		update.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent("com.dd.timetable.Update");
				startActivity(i);
			}
		});
		
		viewall.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent("com.dd.timetable.ViewAll");
				startActivity(i);
			}
		});
		
        viewsch.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent("com.dd.timetable.SelectSchool");
				startActivity(i);
			}
		});
		
	}
	
}

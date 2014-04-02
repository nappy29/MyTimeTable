package com.dd.timetable;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SelectDay extends Activity{
	public static String daystring;
String schs, lvls;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.select_day);
		schs = SelectSchool.schoolstring;
		lvls = SelectLevel.levelstring;
		TextView schday, lvlstr;
		schday = (TextView)findViewById(R.id.schd);
		lvlstr = (TextView)findViewById(R.id.levels);
		schday.setText(schs);
		lvlstr.setText(lvls);
		Button mon, tue;
		tue=(Button)findViewById(R.id.tue);
		tue.setOnClickListener(new View.OnClickListener() {
		
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				daystring = "Tuesday";
				Intent tueintent = new Intent("com.dd.timetable.DisplayTimeTable");
				startActivity(tueintent);
			}
		});
		mon=(Button)findViewById(R.id.monday);
		mon.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				daystring = "Monday";
				Intent monintent = new Intent("com.dd.timetable.DisplayTimeTable");
				startActivity(monintent);
			}
		});
	}
	

}

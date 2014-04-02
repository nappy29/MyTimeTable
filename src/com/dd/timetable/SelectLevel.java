package com.dd.timetable;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SelectLevel extends Activity{
String schs;
public static String levelstring;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.select_level);
		schs = SelectSchool.schoolstring;
		
		TextView ss;
		ss = (TextView)findViewById(R.id.sch);
		ss.setText(schs);
		
		Button fre, soph;
		fre = (Button)findViewById(R.id.fresh);
		fre.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				levelstring = "Freshman";
				Intent i = new Intent("com.dd.timetable.SelectDay");
				startActivity(i);
				
			}
		});
		soph = (Button)findViewById(R.id.sophm);
		soph.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				levelstring = "Sophomore";
				Intent i = new Intent("com.dd.timetable.SelectDay");
				startActivity(i);
			}
		});
	}
	

}

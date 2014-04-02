package com.dd.timetable;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.app.Activity;
import android.content.Intent;

public class SelectSchool extends Activity {
	Button it, eng;
	public static String schoolstring;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_school);
        it = (Button)findViewById(R.id.itId);
        eng = (Button)findViewById(R.id.engId);
        
        it.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				schoolstring = "School of IT";
				Intent s = new Intent("com.dd.timetable.SelectLevel");
				startActivity(s);
			}
		});
        
       eng.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
	            schoolstring = "School of ENG";
				Intent s = new Intent("com.dd.timetable.SelectLevel");
				startActivity(s);
			}
		});
    }
}

  

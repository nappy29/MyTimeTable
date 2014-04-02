package com.dd.timetable;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ViewAll extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.viewall);
		TextView display;
		display = (TextView)findViewById(R.id.displaySql);
		
		DbControl view = new DbControl(this);
		view.open();
		String show = view.getinfo();
		view.close();
		
		display.setText(show);
	}

	
}

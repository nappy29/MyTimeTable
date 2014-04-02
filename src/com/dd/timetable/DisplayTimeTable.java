package com.dd.timetable;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayTimeTable extends Activity{

	String schshow, lvlshow, dayshow;
	TextView schsw, lvlsw, daysw, disinfo;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.display_time_table);
		schsw = (TextView)findViewById(R.id.schdd);
		lvlsw = (TextView)findViewById(R.id.ldd);
		daysw = (TextView)findViewById(R.id.dayd);
		disinfo = (TextView)findViewById(R.id.info);
		schshow = SelectSchool.schoolstring;
		lvlshow = SelectLevel.levelstring;
		dayshow = SelectDay.daystring;
		schsw.setText(schshow);
		lvlsw.setText(lvlshow);
		daysw.setText(dayshow);
		DbControl h = new DbControl(this);
		h.open();
		String que = h.showCourses(schshow, lvlshow, dayshow);
		h.close();
		disinfo.setText(que);
	}

}

package com.dd.timetable;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Update extends Activity implements OnClickListener{
	EditText sch, lvl, day, crs;
	Button upd;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.update);
		
		
		sch = (EditText)findViewById(R.id.editText1);
		lvl = (EditText)findViewById(R.id.editText2);
		day = (EditText)findViewById(R.id.editText3);
		crs = (EditText)findViewById(R.id.editText4);
		upd = (Button)findViewById(R.id.updateid);
		
		 upd.setOnClickListener(this);
	}
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		String school = sch.getText().toString();
		String level = lvl.getText().toString();
		String Day = day.getText().toString();
		String Crs = crs.getText().toString();
		
		boolean diw = true;
			try {
				
				DbControl insert = new DbControl(this);
				insert.open();
				insert.enterInfo(school, level, Day, Crs);
				insert.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				diw = false;
				if(!diw){
					Dialog d = new Dialog(this);
					d.setTitle("did it work");
					TextView tv = new TextView(this);
					tv.setText("bad");
					d.setContentView(tv);
					d.show();
				}
			}finally{
				if(diw){
				Dialog d = new Dialog(this);
				d.setTitle("did it work");
				TextView tv = new TextView(this);
				tv.setText("good");
				d.setContentView(tv);
				d.show();
			}
	}
}
}

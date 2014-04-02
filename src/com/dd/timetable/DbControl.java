package com.dd.timetable;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbControl {

	
	public static final String DATABASE_TABLE = "timetable";
	public static final String KEY_ID = "_id";
	public static final String KEY_SCHOOL = "school";
	public static final String KEY_LEVEL = "level";
	public static final String KEY_DAY = "day";
	public static final String KEY_COURSE = "course";
	
	private static final String DATABASE_NAME = "timetableDB";
	private static final int DATABASE_VERSION = 1;
	
	public static final String SqlCrTable = "CREATE TABLE " + DATABASE_TABLE + " ("
			+ KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
			KEY_SCHOOL + " TEXT, "
			+ KEY_LEVEL + " TEXT,"
			+ KEY_DAY + " TEXT, "
			+ KEY_COURSE + " TEXT "
					+ ")";
	private Context ourContext;
	private Helper ourHelper;
	private SQLiteDatabase ourDatabase;
	public class Helper extends SQLiteOpenHelper{

		public Helper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
	       db.execSQL(SqlCrTable);
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
			onCreate(db);
		}
		
	}
	public DbControl(Context c){
		ourContext = c;
	}
	public DbControl open(){
		ourHelper = new Helper(ourContext);
		ourDatabase = ourHelper.getWritableDatabase();
		return this;
	}
	public void close(){
		ourHelper.close();
	}
	public void enterInfo(String school, String level, String day, String crs) {
		// TODO Auto-generated method stub
		ContentValues cv = new ContentValues();
		cv.put(KEY_SCHOOL, school);
		cv.put(KEY_LEVEL, level);
		cv.put(KEY_DAY, day);
		cv.put(KEY_COURSE, crs);
		
		ourDatabase.insert(DATABASE_TABLE, null, cv);
	}
	public String getinfo() {
		// TODO Auto-generated method stub
		String[] columns = new String[]{KEY_ID, KEY_SCHOOL, KEY_LEVEL, KEY_DAY, KEY_COURSE};
		Cursor c = ourDatabase.query(DATABASE_TABLE, columns, null, null, null, null, null, null);
		
		int iRowid = c.getColumnIndex(KEY_ID);
		int iRowsch = c.getColumnIndex(KEY_SCHOOL);
		int iRowlvl = c.getColumnIndex(KEY_LEVEL);
		int iRowdy = c.getColumnIndex(KEY_DAY);
		int iRowcrs = c.getColumnIndex(KEY_COURSE);
		String result = " ";
		
		for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
			
			result = result + c.getString(iRowid) + " " + c.getString(iRowsch) + " " + c.getString(iRowlvl) + " " + c.getString(iRowdy)
					+ " " + c.getString(iRowcrs) + "\n";
		}
		return result;
		
	}
	public String showCourses(String schshow, String lvlshow, String dayshow) {
		// TODO Auto-generated method stub
		String[] columns1 = new String[]{KEY_COURSE};
		
		String whe = KEY_SCHOOL + " = '" + schshow + "' AND " + KEY_LEVEL + " = '" + lvlshow + "' AND " + KEY_DAY + " = '" + dayshow + "' ";
		
		Cursor v = ourDatabase.query(DATABASE_TABLE, columns1, whe, null, null, null, null);
		int iRowcr1s = v.getColumnIndex(KEY_COURSE);
		String res = " ";
		
		for(v.moveToFirst(); !v.isAfterLast(); v.moveToNext()){
			
			res = res + v.getString(iRowcr1s) + "\n";
		}
		return res;
		
	}
	
}

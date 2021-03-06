package pt.up.fe.nuieee.whatsup.settings;

import pt.up.fe.nuieee.whatsup.R;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentActivity;

public class Settings {

	private static final String FIRST_TIME = "first_time";
	private static final String STUDENT_BRANCH_NAME = "studentBranch";
	
	private static SharedPreferences getPreferences(Context context) {
		return context.getSharedPreferences(context.getString(R.string.app_name), 0);
	}
	
	public static boolean isFirstTime(Context context) 
	{
		SharedPreferences preferences = getPreferences(context);
		return preferences.getBoolean(FIRST_TIME, true);
	}
	
	public static void setFirstTimeToFalse(Context context) 
	{
		SharedPreferences preferences = getPreferences(context);
		preferences.edit().putBoolean(FIRST_TIME, false).commit();
	}

	public static String getStudentBranchName(Context context) {
		return getPreferences(context).getString(STUDENT_BRANCH_NAME, "");
	}
	
	

}

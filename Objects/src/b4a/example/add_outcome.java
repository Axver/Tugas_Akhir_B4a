package b4a.example;


import anywheresoftware.b4a.B4AMenuItem;
import android.app.Activity;
import android.os.Bundle;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.B4AActivity;
import anywheresoftware.b4a.ObjectWrapper;
import anywheresoftware.b4a.objects.ActivityWrapper;
import java.lang.reflect.InvocationTargetException;
import anywheresoftware.b4a.B4AUncaughtException;
import anywheresoftware.b4a.debug.*;
import java.lang.ref.WeakReference;

public class add_outcome extends Activity implements B4AActivity{
	public static add_outcome mostCurrent;
	static boolean afterFirstLayout;
	static boolean isFirst = true;
    private static boolean processGlobalsRun = false;
	BALayout layout;
	public static BA processBA;
	BA activityBA;
    ActivityWrapper _activity;
    java.util.ArrayList<B4AMenuItem> menuItems;
	public static final boolean fullScreen = true;
	public static final boolean includeTitle = false;
    public static WeakReference<Activity> previousOne;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        mostCurrent = this;
		if (processBA == null) {
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.add_outcome");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (add_outcome).");
				p.finish();
			}
		}
        processBA.setActivityPaused(true);
        processBA.runHook("oncreate", this, null);
		if (!includeTitle) {
        	this.getWindow().requestFeature(android.view.Window.FEATURE_NO_TITLE);
        }
        if (fullScreen) {
        	getWindow().setFlags(android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN,   
        			android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
		
        processBA.sharedProcessBA.activityBA = null;
		layout = new BALayout(this);
		setContentView(layout);
		afterFirstLayout = false;
        WaitForLayout wl = new WaitForLayout();
        if (anywheresoftware.b4a.objects.ServiceHelper.StarterHelper.startFromActivity(processBA, wl, false))
		    BA.handler.postDelayed(wl, 5);

	}
	static class WaitForLayout implements Runnable {
		public void run() {
			if (afterFirstLayout)
				return;
			if (mostCurrent == null)
				return;
            
			if (mostCurrent.layout.getWidth() == 0) {
				BA.handler.postDelayed(this, 5);
				return;
			}
			mostCurrent.layout.getLayoutParams().height = mostCurrent.layout.getHeight();
			mostCurrent.layout.getLayoutParams().width = mostCurrent.layout.getWidth();
			afterFirstLayout = true;
			mostCurrent.afterFirstLayout();
		}
	}
	private void afterFirstLayout() {
        if (this != mostCurrent)
			return;
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.add_outcome");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.add_outcome", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (add_outcome) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (add_outcome) Resume **");
        processBA.raiseEvent(null, "activity_resume");
        if (android.os.Build.VERSION.SDK_INT >= 11) {
			try {
				android.app.Activity.class.getMethod("invalidateOptionsMenu").invoke(this,(Object[]) null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	public void addMenuItem(B4AMenuItem item) {
		if (menuItems == null)
			menuItems = new java.util.ArrayList<B4AMenuItem>();
		menuItems.add(item);
	}
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		super.onCreateOptionsMenu(menu);
        try {
            if (processBA.subExists("activity_actionbarhomeclick")) {
                Class.forName("android.app.ActionBar").getMethod("setHomeButtonEnabled", boolean.class).invoke(
                    getClass().getMethod("getActionBar").invoke(this), true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (processBA.runHook("oncreateoptionsmenu", this, new Object[] {menu}))
            return true;
		if (menuItems == null)
			return false;
		for (B4AMenuItem bmi : menuItems) {
			android.view.MenuItem mi = menu.add(bmi.title);
			if (bmi.drawable != null)
				mi.setIcon(bmi.drawable);
            if (android.os.Build.VERSION.SDK_INT >= 11) {
				try {
                    if (bmi.addToBar) {
				        android.view.MenuItem.class.getMethod("setShowAsAction", int.class).invoke(mi, 1);
                    }
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			mi.setOnMenuItemClickListener(new B4AMenuItemsClickListener(bmi.eventName.toLowerCase(BA.cul)));
		}
        
		return true;
	}   
 @Override
 public boolean onOptionsItemSelected(android.view.MenuItem item) {
    if (item.getItemId() == 16908332) {
        processBA.raiseEvent(null, "activity_actionbarhomeclick");
        return true;
    }
    else
        return super.onOptionsItemSelected(item); 
}
@Override
 public boolean onPrepareOptionsMenu(android.view.Menu menu) {
    super.onPrepareOptionsMenu(menu);
    processBA.runHook("onprepareoptionsmenu", this, new Object[] {menu});
    return true;
    
 }
 protected void onStart() {
    super.onStart();
    processBA.runHook("onstart", this, null);
}
 protected void onStop() {
    super.onStop();
    processBA.runHook("onstop", this, null);
}
    public void onWindowFocusChanged(boolean hasFocus) {
       super.onWindowFocusChanged(hasFocus);
       if (processBA.subExists("activity_windowfocuschanged"))
           processBA.raiseEvent2(null, true, "activity_windowfocuschanged", false, hasFocus);
    }
	private class B4AMenuItemsClickListener implements android.view.MenuItem.OnMenuItemClickListener {
		private final String eventName;
		public B4AMenuItemsClickListener(String eventName) {
			this.eventName = eventName;
		}
		public boolean onMenuItemClick(android.view.MenuItem item) {
			processBA.raiseEventFromUI(item.getTitle(), eventName + "_click");
			return true;
		}
	}
    public static Class<?> getObject() {
		return add_outcome.class;
	}
    private Boolean onKeySubExist = null;
    private Boolean onKeyUpSubExist = null;
	@Override
	public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeydown", this, new Object[] {keyCode, event}))
            return true;
		if (onKeySubExist == null)
			onKeySubExist = processBA.subExists("activity_keypress");
		if (onKeySubExist) {
			if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK &&
					android.os.Build.VERSION.SDK_INT >= 18) {
				HandleKeyDelayed hk = new HandleKeyDelayed();
				hk.kc = keyCode;
				BA.handler.post(hk);
				return true;
			}
			else {
				boolean res = new HandleKeyDelayed().runDirectly(keyCode);
				if (res)
					return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}
	private class HandleKeyDelayed implements Runnable {
		int kc;
		public void run() {
			runDirectly(kc);
		}
		public boolean runDirectly(int keyCode) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keypress", false, keyCode);
			if (res == null || res == true) {
                return true;
            }
            else if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK) {
				finish();
				return true;
			}
            return false;
		}
		
	}
    @Override
	public boolean onKeyUp(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeyup", this, new Object[] {keyCode, event}))
            return true;
		if (onKeyUpSubExist == null)
			onKeyUpSubExist = processBA.subExists("activity_keyup");
		if (onKeyUpSubExist) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keyup", false, keyCode);
			if (res == null || res == true)
				return true;
		}
		return super.onKeyUp(keyCode, event);
	}
	@Override
	public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
		this.setIntent(intent);
        processBA.runHook("onnewintent", this, new Object[] {intent});
	}
    @Override 
	public void onPause() {
		super.onPause();
        if (_activity == null)
            return;
        if (this != mostCurrent)
			return;
		anywheresoftware.b4a.Msgbox.dismiss(true);
        BA.LogInfo("** Activity (add_outcome) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        if (mostCurrent != null)
            processBA.raiseEvent2(_activity, true, "activity_pause", false, activityBA.activity.isFinishing());		
        processBA.setActivityPaused(true);
        mostCurrent = null;
        if (!activityBA.activity.isFinishing())
			previousOne = new WeakReference<Activity>(this);
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        processBA.runHook("onpause", this, null);
	}

	@Override
	public void onDestroy() {
        super.onDestroy();
		previousOne = null;
        processBA.runHook("ondestroy", this, null);
	}
    @Override 
	public void onResume() {
		super.onResume();
        mostCurrent = this;
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (activityBA != null) { //will be null during activity create (which waits for AfterLayout).
        	ResumeMessage rm = new ResumeMessage(mostCurrent);
        	BA.handler.post(rm);
        }
        processBA.runHook("onresume", this, null);
	}
    private static class ResumeMessage implements Runnable {
    	private final WeakReference<Activity> activity;
    	public ResumeMessage(Activity activity) {
    		this.activity = new WeakReference<Activity>(activity);
    	}
		public void run() {
            add_outcome mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (add_outcome) Resume **");
            if (mc != mostCurrent)
                return;
		    processBA.raiseEvent(mc._activity, "activity_resume", (Object[])null);
		}
    }
	@Override
	protected void onActivityResult(int requestCode, int resultCode,
	      android.content.Intent data) {
		processBA.onActivityResult(requestCode, resultCode, data);
        processBA.runHook("onactivityresult", this, new Object[] {requestCode, resultCode});
	}
	private static void initializeGlobals() {
		processBA.raiseEvent2(null, true, "globals", false, (Object[])null);
	}
    public void onRequestPermissionsResult(int requestCode,
        String permissions[], int[] grantResults) {
        for (int i = 0;i < permissions.length;i++) {
            Object[] o = new Object[] {permissions[i], grantResults[i] == 0};
            processBA.raiseEventFromDifferentThread(null,null, 0, "activity_permissionresult", true, o);
        }
            
    }



public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public anywheresoftware.b4a.keywords.Common __c = null;
public static String _domain = "";
public anywheresoftware.b4a.samples.httputils2.httpjob _job2 = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edittext1 = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edittext2 = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edittext3 = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edittext4 = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edittext5 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _button1 = null;
public anywheresoftware.b4a.samples.httputils2.httputils2service _httputils2service = null;
public b4a.example.main _main = null;
public b4a.example.starter _starter = null;
public b4a.example.dashboard _dashboard = null;
public b4a.example.birth _birth = null;
public b4a.example.add_birth _add_birth = null;
public b4a.example.mortality _mortality = null;
public b4a.example.add_mortality _add_mortality = null;
public b4a.example.outcome _outcome = null;
public b4a.example.family_card _family_card = null;
public b4a.example.citizen _citizen = null;
public b4a.example.land_by_owner _land_by_owner = null;
public b4a.example.building_id _building_id = null;
public b4a.example.building_owner _building_owner = null;
public b4a.example.buildings _buildings = null;
public b4a.example.owner_states _owner_states = null;
public b4a.example.owners _owners = null;
public b4a.example.lands _lands = null;
public b4a.example.lands_id _lands_id = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="add_outcome";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create"))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=6750208;
 //BA.debugLineNum = 6750208;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=6750210;
 //BA.debugLineNum = 6750210;BA.debugLine="Activity.LoadLayout(\"add_outcome\")";
mostCurrent._activity.LoadLayout("add_outcome",mostCurrent.activityBA);
RDebugUtils.currentLine=6750212;
 //BA.debugLineNum = 6750212;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="add_outcome";
RDebugUtils.currentLine=6881280;
 //BA.debugLineNum = 6881280;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=6881282;
 //BA.debugLineNum = 6881282;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="add_outcome";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume"))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=6815744;
 //BA.debugLineNum = 6815744;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=6815746;
 //BA.debugLineNum = 6815746;BA.debugLine="End Sub";
return "";
}
public static String  _button1_click() throws Exception{
RDebugUtils.currentModule="add_outcome";
if (Debug.shouldDelegate(mostCurrent.activityBA, "button1_click"))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "button1_click", null));}
String _citizen_id = "";
String _from = "";
String _destination = "";
String _status = "";
RDebugUtils.currentLine=6946816;
 //BA.debugLineNum = 6946816;BA.debugLine="Sub Button1_Click";
RDebugUtils.currentLine=6946818;
 //BA.debugLineNum = 6946818;BA.debugLine="Dim citizen_id As String";
_citizen_id = "";
RDebugUtils.currentLine=6946819;
 //BA.debugLineNum = 6946819;BA.debugLine="Dim from As String";
_from = "";
RDebugUtils.currentLine=6946820;
 //BA.debugLineNum = 6946820;BA.debugLine="Dim destination As String";
_destination = "";
RDebugUtils.currentLine=6946821;
 //BA.debugLineNum = 6946821;BA.debugLine="Dim status As String";
_status = "";
RDebugUtils.currentLine=6946823;
 //BA.debugLineNum = 6946823;BA.debugLine="citizen_id=EditText1.Text";
_citizen_id = mostCurrent._edittext1.getText();
RDebugUtils.currentLine=6946824;
 //BA.debugLineNum = 6946824;BA.debugLine="from=EditText2.Text";
_from = mostCurrent._edittext2.getText();
RDebugUtils.currentLine=6946825;
 //BA.debugLineNum = 6946825;BA.debugLine="destination=EditText3.Text";
_destination = mostCurrent._edittext3.getText();
RDebugUtils.currentLine=6946826;
 //BA.debugLineNum = 6946826;BA.debugLine="status=EditText4.Text";
_status = mostCurrent._edittext4.getText();
RDebugUtils.currentLine=6946829;
 //BA.debugLineNum = 6946829;BA.debugLine="job2.Initialize(\"Job2\", Me)";
mostCurrent._job2._initialize(processBA,"Job2",add_outcome.getObject());
RDebugUtils.currentLine=6946830;
 //BA.debugLineNum = 6946830;BA.debugLine="job2.PostString(domain&\"ta_v2/endpoint/addOutcome";
mostCurrent._job2._poststring(mostCurrent._domain+"ta_v2/endpoint/addOutcome.php","citizen_id="+_citizen_id+"&from="+_from+"&destination="+_destination+"&status="+_status);
RDebugUtils.currentLine=6946831;
 //BA.debugLineNum = 6946831;BA.debugLine="ProgressDialogShow(\"Loading...\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,BA.ObjectToCharSequence("Loading..."));
RDebugUtils.currentLine=6946832;
 //BA.debugLineNum = 6946832;BA.debugLine="End Sub";
return "";
}
public static String  _button3_click() throws Exception{
RDebugUtils.currentModule="add_outcome";
if (Debug.shouldDelegate(mostCurrent.activityBA, "button3_click"))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "button3_click", null));}
RDebugUtils.currentLine=7143424;
 //BA.debugLineNum = 7143424;BA.debugLine="Sub Button3_Click";
RDebugUtils.currentLine=7143426;
 //BA.debugLineNum = 7143426;BA.debugLine="End Sub";
return "";
}
public static String  _jobdone(anywheresoftware.b4a.samples.httputils2.httpjob _job) throws Exception{
RDebugUtils.currentModule="add_outcome";
if (Debug.shouldDelegate(mostCurrent.activityBA, "jobdone"))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "jobdone", new Object[] {_job}));}
RDebugUtils.currentLine=7012352;
 //BA.debugLineNum = 7012352;BA.debugLine="Sub JobDone (Job As HttpJob)";
RDebugUtils.currentLine=7012354;
 //BA.debugLineNum = 7012354;BA.debugLine="Log(\"JobName = \" & Job.JobName & \", Success = \" &";
anywheresoftware.b4a.keywords.Common.Log("JobName = "+_job._jobname+", Success = "+BA.ObjectToString(_job._success));
RDebugUtils.currentLine=7012355;
 //BA.debugLineNum = 7012355;BA.debugLine="If Job.Success = True Then";
if (_job._success==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=7012358;
 //BA.debugLineNum = 7012358;BA.debugLine="Select Job.JobName";
switch (BA.switchObjectToInt(_job._jobname,"Job2")) {
case 0: {
RDebugUtils.currentLine=7012361;
 //BA.debugLineNum = 7012361;BA.debugLine="Log(Job.GetString)";
anywheresoftware.b4a.keywords.Common.Log(_job._getstring());
RDebugUtils.currentLine=7012362;
 //BA.debugLineNum = 7012362;BA.debugLine="If Job.GetString=\"Success\" Then";
if ((_job._getstring()).equals("Success")) { 
RDebugUtils.currentLine=7012363;
 //BA.debugLineNum = 7012363;BA.debugLine="StartActivity(\"outcome\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("outcome"));
 }else {
RDebugUtils.currentLine=7012365;
 //BA.debugLineNum = 7012365;BA.debugLine="Log(\"Failed To Input Data\")";
anywheresoftware.b4a.keywords.Common.Log("Failed To Input Data");
 };
RDebugUtils.currentLine=7012372;
 //BA.debugLineNum = 7012372;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
 break; }
}
;
 }else {
RDebugUtils.currentLine=7012377;
 //BA.debugLineNum = 7012377;BA.debugLine="Log(\"Error: \" & Job.ErrorMessage)";
anywheresoftware.b4a.keywords.Common.Log("Error: "+_job._errormessage);
RDebugUtils.currentLine=7012378;
 //BA.debugLineNum = 7012378;BA.debugLine="ToastMessageShow(\"Error: \" & Job.ErrorMessage, T";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Error: "+_job._errormessage),anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=7012380;
 //BA.debugLineNum = 7012380;BA.debugLine="Job.Release";
_job._release();
RDebugUtils.currentLine=7012381;
 //BA.debugLineNum = 7012381;BA.debugLine="End Sub";
return "";
}
public static String  _label3_click() throws Exception{
RDebugUtils.currentModule="add_outcome";
if (Debug.shouldDelegate(mostCurrent.activityBA, "label3_click"))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "label3_click", null));}
RDebugUtils.currentLine=7077888;
 //BA.debugLineNum = 7077888;BA.debugLine="Sub Label3_Click";
RDebugUtils.currentLine=7077889;
 //BA.debugLineNum = 7077889;BA.debugLine="StartActivity(\"dashboard\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("dashboard"));
RDebugUtils.currentLine=7077890;
 //BA.debugLineNum = 7077890;BA.debugLine="End Sub";
return "";
}
}
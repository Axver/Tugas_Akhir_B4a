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

public class family_card extends Activity implements B4AActivity{
	public static family_card mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.family_card");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (family_card).");
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
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.family_card");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.family_card", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (family_card) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (family_card) Resume **");
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
		return family_card.class;
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
        BA.LogInfo("** Activity (family_card) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
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
            family_card mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (family_card) Resume **");
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
public anywheresoftware.b4a.objects.PanelWrapper _pnlinput = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlselect = null;
public anywheresoftware.b4a.objects.PanelWrapper _panelmain = null;
public static String _domain = "";
public static float _mh1 = 0f;
public static float _mh2 = 0f;
public static float _mw1 = 0f;
public static float _mw2 = 0f;
public anywheresoftware.b4a.samples.httputils2.httpjob _job2 = null;
public static String _citizen_name_g = "";
public static String _clan_g = "";
public static String _gender_g = "";
public static String _phone_g = "";
public static String _status_g = "";
public anywheresoftware.b4a.objects.LabelWrapper _label10 = null;
public anywheresoftware.b4a.objects.LabelWrapper _label11 = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edittext1 = null;
public anywheresoftware.b4a.objects.ListViewWrapper _listview1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _label12 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _button1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _label1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _label2 = null;
public anywheresoftware.b4a.objects.LabelWrapper _label3 = null;
public anywheresoftware.b4a.objects.LabelWrapper _label4 = null;
public anywheresoftware.b4a.objects.LabelWrapper _label5 = null;
public anywheresoftware.b4a.samples.httputils2.httputils2service _httputils2service = null;
public b4a.example.main _main = null;
public b4a.example.starter _starter = null;
public b4a.example.dashboard _dashboard = null;
public b4a.example.birth _birth = null;
public b4a.example.add_birth _add_birth = null;
public b4a.example.mortality _mortality = null;
public b4a.example.add_mortality _add_mortality = null;
public b4a.example.outcome _outcome = null;
public b4a.example.add_outcome _add_outcome = null;
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
RDebugUtils.currentModule="family_card";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create"))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=7340032;
 //BA.debugLineNum = 7340032;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=7340034;
 //BA.debugLineNum = 7340034;BA.debugLine="Activity.LoadLayout(\"family_card\")";
mostCurrent._activity.LoadLayout("family_card",mostCurrent.activityBA);
RDebugUtils.currentLine=7340039;
 //BA.debugLineNum = 7340039;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="family_card";
RDebugUtils.currentLine=7471104;
 //BA.debugLineNum = 7471104;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=7471106;
 //BA.debugLineNum = 7471106;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="family_card";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume"))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=7405568;
 //BA.debugLineNum = 7405568;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=7405569;
 //BA.debugLineNum = 7405569;BA.debugLine="job2.Initialize(\"Job2\", Me)";
mostCurrent._job2._initialize(processBA,"Job2",family_card.getObject());
RDebugUtils.currentLine=7405570;
 //BA.debugLineNum = 7405570;BA.debugLine="job2.PostString(domain&\"ta_v2/endpoint/countFcn.p";
mostCurrent._job2._poststring(mostCurrent._domain+"ta_v2/endpoint/countFcn.php","send=test"+"&data=test");
RDebugUtils.currentLine=7405571;
 //BA.debugLineNum = 7405571;BA.debugLine="ProgressDialogShow(\"Loading...\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,BA.ObjectToCharSequence("Loading..."));
RDebugUtils.currentLine=7405572;
 //BA.debugLineNum = 7405572;BA.debugLine="End Sub";
return "";
}
public static String  _button1_click() throws Exception{
RDebugUtils.currentModule="family_card";
if (Debug.shouldDelegate(mostCurrent.activityBA, "button1_click"))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "button1_click", null));}
String _fc_number = "";
int _size = 0;
int _x = 0;
RDebugUtils.currentLine=7602176;
 //BA.debugLineNum = 7602176;BA.debugLine="Sub Button1_Click";
RDebugUtils.currentLine=7602177;
 //BA.debugLineNum = 7602177;BA.debugLine="Dim fc_number As String";
_fc_number = "";
RDebugUtils.currentLine=7602178;
 //BA.debugLineNum = 7602178;BA.debugLine="fc_number=EditText1.Text";
_fc_number = mostCurrent._edittext1.getText();
RDebugUtils.currentLine=7602180;
 //BA.debugLineNum = 7602180;BA.debugLine="job2.Initialize(\"Job3\", Me)";
mostCurrent._job2._initialize(processBA,"Job3",family_card.getObject());
RDebugUtils.currentLine=7602181;
 //BA.debugLineNum = 7602181;BA.debugLine="job2.PostString(domain&\"ta_v2/endpoint/fcn_search";
mostCurrent._job2._poststring(mostCurrent._domain+"ta_v2/endpoint/fcn_search.php","family_no="+_fc_number);
RDebugUtils.currentLine=7602182;
 //BA.debugLineNum = 7602182;BA.debugLine="ProgressDialogShow(\"Loading...\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,BA.ObjectToCharSequence("Loading..."));
RDebugUtils.currentLine=7602184;
 //BA.debugLineNum = 7602184;BA.debugLine="Dim Size As Int";
_size = 0;
RDebugUtils.currentLine=7602185;
 //BA.debugLineNum = 7602185;BA.debugLine="Size=ListView1.Size";
_size = mostCurrent._listview1.getSize();
RDebugUtils.currentLine=7602186;
 //BA.debugLineNum = 7602186;BA.debugLine="Log(\"Jumlah Data: \" & Size)";
anywheresoftware.b4a.keywords.Common.Log("Jumlah Data: "+BA.NumberToString(_size));
RDebugUtils.currentLine=7602188;
 //BA.debugLineNum = 7602188;BA.debugLine="For x= Size To 0 Step -1";
{
final int step9 = -1;
final int limit9 = (int) (0);
_x = _size ;
for (;_x >= limit9 ;_x = _x + step9 ) {
RDebugUtils.currentLine=7602189;
 //BA.debugLineNum = 7602189;BA.debugLine="If x==0 Then";
if (_x==0) { 
 }else {
RDebugUtils.currentLine=7602192;
 //BA.debugLineNum = 7602192;BA.debugLine="ListView1.RemoveAt(x-1)";
mostCurrent._listview1.RemoveAt((int) (_x-1));
 };
 }
};
RDebugUtils.currentLine=7602195;
 //BA.debugLineNum = 7602195;BA.debugLine="End Sub";
return "";
}
public static String  _jobdone(anywheresoftware.b4a.samples.httputils2.httpjob _job) throws Exception{
RDebugUtils.currentModule="family_card";
if (Debug.shouldDelegate(mostCurrent.activityBA, "jobdone"))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "jobdone", new Object[] {_job}));}
anywheresoftware.b4a.objects.collections.JSONParser _parser = null;
anywheresoftware.b4a.objects.collections.Map _root = null;
anywheresoftware.b4a.objects.collections.List _features = null;
anywheresoftware.b4a.objects.collections.Map _colfeatures = null;
anywheresoftware.b4a.objects.collections.Map _properties = null;
String _fcn = "";
String _fcc = "";
String _citizen_id = "";
String _name = "";
String _count = "";
String _nik = "";
String _clan_name = "";
String _citizen_name = "";
String _gender = "";
String _phone = "";
String _status_name = "";
String _born_date = "";
RDebugUtils.currentLine=7536640;
 //BA.debugLineNum = 7536640;BA.debugLine="Sub JobDone (Job As HttpJob)";
RDebugUtils.currentLine=7536642;
 //BA.debugLineNum = 7536642;BA.debugLine="Log(\"JobName = \" & Job.JobName & \", Success = \" &";
anywheresoftware.b4a.keywords.Common.Log("JobName = "+_job._jobname+", Success = "+BA.ObjectToString(_job._success));
RDebugUtils.currentLine=7536643;
 //BA.debugLineNum = 7536643;BA.debugLine="If Job.Success = True Then";
if (_job._success==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=7536644;
 //BA.debugLineNum = 7536644;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
RDebugUtils.currentLine=7536645;
 //BA.debugLineNum = 7536645;BA.debugLine="Select Job.JobName";
switch (BA.switchObjectToInt(_job._jobname,"Job2","Job3","Job4")) {
case 0: {
RDebugUtils.currentLine=7536647;
 //BA.debugLineNum = 7536647;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=7536648;
 //BA.debugLineNum = 7536648;BA.debugLine="parser.Initialize(Job.GetString)";
_parser.Initialize(_job._getstring());
RDebugUtils.currentLine=7536649;
 //BA.debugLineNum = 7536649;BA.debugLine="Dim root As Map = parser.NextObject";
_root = new anywheresoftware.b4a.objects.collections.Map();
_root = _parser.NextObject();
RDebugUtils.currentLine=7536650;
 //BA.debugLineNum = 7536650;BA.debugLine="Dim features As List = root.Get(\"features\")";
_features = new anywheresoftware.b4a.objects.collections.List();
_features.setObject((java.util.List)(_root.Get((Object)("features"))));
RDebugUtils.currentLine=7536651;
 //BA.debugLineNum = 7536651;BA.debugLine="For Each colfeatures As Map In features";
_colfeatures = new anywheresoftware.b4a.objects.collections.Map();
{
final anywheresoftware.b4a.BA.IterableList group10 = _features;
final int groupLen10 = group10.getSize()
;int index10 = 0;
;
for (; index10 < groupLen10;index10++){
_colfeatures.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(group10.Get(index10)));
RDebugUtils.currentLine=7536652;
 //BA.debugLineNum = 7536652;BA.debugLine="Dim properties As Map = colfeatures.Get(\"prop";
_properties = new anywheresoftware.b4a.objects.collections.Map();
_properties.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_colfeatures.Get((Object)("properties"))));
RDebugUtils.currentLine=7536653;
 //BA.debugLineNum = 7536653;BA.debugLine="Dim fcn As String = properties.Get(\"fcn\")";
_fcn = BA.ObjectToString(_properties.Get((Object)("fcn")));
RDebugUtils.currentLine=7536654;
 //BA.debugLineNum = 7536654;BA.debugLine="Dim fcc As String = properties.Get(\"fcc\")";
_fcc = BA.ObjectToString(_properties.Get((Object)("fcc")));
RDebugUtils.currentLine=7536656;
 //BA.debugLineNum = 7536656;BA.debugLine="Label10.Text=fcn";
mostCurrent._label10.setText(BA.ObjectToCharSequence(_fcn));
RDebugUtils.currentLine=7536657;
 //BA.debugLineNum = 7536657;BA.debugLine="Label11.Text=fcc";
mostCurrent._label11.setText(BA.ObjectToCharSequence(_fcc));
 }
};
 break; }
case 1: {
RDebugUtils.currentLine=7536660;
 //BA.debugLineNum = 7536660;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=7536661;
 //BA.debugLineNum = 7536661;BA.debugLine="parser.Initialize(Job.GetString)";
_parser.Initialize(_job._getstring());
RDebugUtils.currentLine=7536662;
 //BA.debugLineNum = 7536662;BA.debugLine="Dim root As Map = parser.NextObject";
_root = new anywheresoftware.b4a.objects.collections.Map();
_root = _parser.NextObject();
RDebugUtils.currentLine=7536663;
 //BA.debugLineNum = 7536663;BA.debugLine="Dim features As List = root.Get(\"features\")";
_features = new anywheresoftware.b4a.objects.collections.List();
_features.setObject((java.util.List)(_root.Get((Object)("features"))));
RDebugUtils.currentLine=7536664;
 //BA.debugLineNum = 7536664;BA.debugLine="For Each colfeatures As Map In features";
_colfeatures = new anywheresoftware.b4a.objects.collections.Map();
{
final anywheresoftware.b4a.BA.IterableList group22 = _features;
final int groupLen22 = group22.getSize()
;int index22 = 0;
;
for (; index22 < groupLen22;index22++){
_colfeatures.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(group22.Get(index22)));
RDebugUtils.currentLine=7536665;
 //BA.debugLineNum = 7536665;BA.debugLine="Dim properties As Map = colfeatures.Get(\"prop";
_properties = new anywheresoftware.b4a.objects.collections.Map();
_properties.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_colfeatures.Get((Object)("properties"))));
RDebugUtils.currentLine=7536666;
 //BA.debugLineNum = 7536666;BA.debugLine="Dim citizen_id As String = properties.Get(\"ci";
_citizen_id = BA.ObjectToString(_properties.Get((Object)("citizen_id")));
RDebugUtils.currentLine=7536667;
 //BA.debugLineNum = 7536667;BA.debugLine="Dim name As String = properties.Get(\"name\")";
_name = BA.ObjectToString(_properties.Get((Object)("name")));
RDebugUtils.currentLine=7536668;
 //BA.debugLineNum = 7536668;BA.debugLine="Dim count As String = properties.Get(\"count\")";
_count = BA.ObjectToString(_properties.Get((Object)("count")));
RDebugUtils.currentLine=7536669;
 //BA.debugLineNum = 7536669;BA.debugLine="ListView1.AddSingleLine(citizen_id)";
mostCurrent._listview1.AddSingleLine(BA.ObjectToCharSequence(_citizen_id));
RDebugUtils.currentLine=7536670;
 //BA.debugLineNum = 7536670;BA.debugLine="ListView1.SingleLineLayout.Label.TextSize=20";
mostCurrent._listview1.getSingleLineLayout().Label.setTextSize((float) (20));
RDebugUtils.currentLine=7536671;
 //BA.debugLineNum = 7536671;BA.debugLine="ListView1.SingleLineLayout.ItemHeight = 24dip";
mostCurrent._listview1.getSingleLineLayout().setItemHeight(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (24)));
RDebugUtils.currentLine=7536672;
 //BA.debugLineNum = 7536672;BA.debugLine="ListView1.SingleLineLayout.Label.TextColor =";
mostCurrent._listview1.getSingleLineLayout().Label.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=7536673;
 //BA.debugLineNum = 7536673;BA.debugLine="ListView1.SingleLineLayout.Label.Gravity=Grav";
mostCurrent._listview1.getSingleLineLayout().Label.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_HORIZONTAL);
 }
};
 break; }
case 2: {
RDebugUtils.currentLine=7536678;
 //BA.debugLineNum = 7536678;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=7536679;
 //BA.debugLineNum = 7536679;BA.debugLine="Log(Job.GetString)";
anywheresoftware.b4a.keywords.Common.Log(_job._getstring());
RDebugUtils.currentLine=7536680;
 //BA.debugLineNum = 7536680;BA.debugLine="parser.Initialize(Job.GetString)";
_parser.Initialize(_job._getstring());
RDebugUtils.currentLine=7536681;
 //BA.debugLineNum = 7536681;BA.debugLine="Dim root As Map = parser.NextObject";
_root = new anywheresoftware.b4a.objects.collections.Map();
_root = _parser.NextObject();
RDebugUtils.currentLine=7536682;
 //BA.debugLineNum = 7536682;BA.debugLine="Dim nik As String = root.Get(\"nik\")";
_nik = BA.ObjectToString(_root.Get((Object)("nik")));
RDebugUtils.currentLine=7536683;
 //BA.debugLineNum = 7536683;BA.debugLine="Dim clan_name As String = root.Get(\"clan_name\"";
_clan_name = BA.ObjectToString(_root.Get((Object)("clan_name")));
RDebugUtils.currentLine=7536684;
 //BA.debugLineNum = 7536684;BA.debugLine="Dim citizen_name As String = root.Get(\"citizen";
_citizen_name = BA.ObjectToString(_root.Get((Object)("citizen_name")));
RDebugUtils.currentLine=7536685;
 //BA.debugLineNum = 7536685;BA.debugLine="Dim gender As String = root.Get(\"gender\")";
_gender = BA.ObjectToString(_root.Get((Object)("gender")));
RDebugUtils.currentLine=7536686;
 //BA.debugLineNum = 7536686;BA.debugLine="Dim phone As String = root.Get(\"phone\")";
_phone = BA.ObjectToString(_root.Get((Object)("phone")));
RDebugUtils.currentLine=7536687;
 //BA.debugLineNum = 7536687;BA.debugLine="Dim status_name As String = root.Get(\"status_n";
_status_name = BA.ObjectToString(_root.Get((Object)("status_name")));
RDebugUtils.currentLine=7536688;
 //BA.debugLineNum = 7536688;BA.debugLine="Dim born_date As String = root.Get(\"born_date\"";
_born_date = BA.ObjectToString(_root.Get((Object)("born_date")));
RDebugUtils.currentLine=7536690;
 //BA.debugLineNum = 7536690;BA.debugLine="citizen_name_g=citizen_name";
mostCurrent._citizen_name_g = _citizen_name;
RDebugUtils.currentLine=7536691;
 //BA.debugLineNum = 7536691;BA.debugLine="gender_g=gender";
mostCurrent._gender_g = _gender;
RDebugUtils.currentLine=7536692;
 //BA.debugLineNum = 7536692;BA.debugLine="phone_g=phone";
mostCurrent._phone_g = _phone;
RDebugUtils.currentLine=7536693;
 //BA.debugLineNum = 7536693;BA.debugLine="status_g=status_name";
mostCurrent._status_g = _status_name;
RDebugUtils.currentLine=7536694;
 //BA.debugLineNum = 7536694;BA.debugLine="Label12.Text=count";
mostCurrent._label12.setText(BA.ObjectToCharSequence(_count));
 break; }
}
;
 }else {
RDebugUtils.currentLine=7536701;
 //BA.debugLineNum = 7536701;BA.debugLine="Log(\"Error: \" & Job.ErrorMessage)";
anywheresoftware.b4a.keywords.Common.Log("Error: "+_job._errormessage);
RDebugUtils.currentLine=7536702;
 //BA.debugLineNum = 7536702;BA.debugLine="ToastMessageShow(\"Error: \" & Job.ErrorMessage, T";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Error: "+_job._errormessage),anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=7536704;
 //BA.debugLineNum = 7536704;BA.debugLine="Job.Release";
_job._release();
RDebugUtils.currentLine=7536705;
 //BA.debugLineNum = 7536705;BA.debugLine="End Sub";
return "";
}
public static String  _listview1_itemclick(int _position,Object _value) throws Exception{
RDebugUtils.currentModule="family_card";
if (Debug.shouldDelegate(mostCurrent.activityBA, "listview1_itemclick"))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "listview1_itemclick", new Object[] {_position,_value}));}
RDebugUtils.currentLine=7667712;
 //BA.debugLineNum = 7667712;BA.debugLine="Sub ListView1_ItemClick (Position As Int, Value As";
RDebugUtils.currentLine=7667713;
 //BA.debugLineNum = 7667713;BA.debugLine="Button1.Visible=False";
mostCurrent._button1.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=7667714;
 //BA.debugLineNum = 7667714;BA.debugLine="job2.Initialize(\"Job4\", Me)";
mostCurrent._job2._initialize(processBA,"Job4",family_card.getObject());
RDebugUtils.currentLine=7667715;
 //BA.debugLineNum = 7667715;BA.debugLine="job2.PostString(domain&\"ta_v2/endpoint/citizen_by";
mostCurrent._job2._poststring(mostCurrent._domain+"ta_v2/endpoint/citizen_by_nik.php","citizen_id="+BA.ObjectToString(_value));
RDebugUtils.currentLine=7667716;
 //BA.debugLineNum = 7667716;BA.debugLine="ProgressDialogShow(\"Loading...\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,BA.ObjectToCharSequence("Loading..."));
RDebugUtils.currentLine=7667717;
 //BA.debugLineNum = 7667717;BA.debugLine="PanPop(\"fcpanel.bal\", 20, 10,Value)";
_panpop("fcpanel.bal",(int) (20),(int) (10),BA.ObjectToString(_value));
RDebugUtils.currentLine=7667719;
 //BA.debugLineNum = 7667719;BA.debugLine="Log(\"Data yang diklik: \" & Value)";
anywheresoftware.b4a.keywords.Common.Log("Data yang diklik: "+BA.ObjectToString(_value));
RDebugUtils.currentLine=7667720;
 //BA.debugLineNum = 7667720;BA.debugLine="Label1.Text=\"Name:\"&citizen_name_g";
mostCurrent._label1.setText(BA.ObjectToCharSequence("Name:"+mostCurrent._citizen_name_g));
RDebugUtils.currentLine=7667721;
 //BA.debugLineNum = 7667721;BA.debugLine="Label2.Text=\"Phone:\"&phone_g";
mostCurrent._label2.setText(BA.ObjectToCharSequence("Phone:"+mostCurrent._phone_g));
RDebugUtils.currentLine=7667722;
 //BA.debugLineNum = 7667722;BA.debugLine="Label3.Text=\"Gender:\"&gender_g";
mostCurrent._label3.setText(BA.ObjectToCharSequence("Gender:"+mostCurrent._gender_g));
RDebugUtils.currentLine=7667723;
 //BA.debugLineNum = 7667723;BA.debugLine="Label4.Text=\"Status:\"&status_g";
mostCurrent._label4.setText(BA.ObjectToCharSequence("Status:"+mostCurrent._status_g));
RDebugUtils.currentLine=7667724;
 //BA.debugLineNum = 7667724;BA.debugLine="Label5.Text=\"Clan:\"&clan_g";
mostCurrent._label5.setText(BA.ObjectToCharSequence("Clan:"+mostCurrent._clan_g));
RDebugUtils.currentLine=7667725;
 //BA.debugLineNum = 7667725;BA.debugLine="End Sub";
return "";
}
public static String  _panpop(String _mlayout,int _hc,int _wc,String _nik) throws Exception{
RDebugUtils.currentModule="family_card";
if (Debug.shouldDelegate(mostCurrent.activityBA, "panpop"))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "panpop", new Object[] {_mlayout,_hc,_wc,_nik}));}
RDebugUtils.currentLine=7733248;
 //BA.debugLineNum = 7733248;BA.debugLine="Sub PanPop (mlayout As String, hc As Int, wc As In";
RDebugUtils.currentLine=7733250;
 //BA.debugLineNum = 7733250;BA.debugLine="pnlSelect.Initialize ( \"Select\")";
mostCurrent._pnlselect.Initialize(mostCurrent.activityBA,"Select");
RDebugUtils.currentLine=7733251;
 //BA.debugLineNum = 7733251;BA.debugLine="pnlInput.Initialize (\"\")";
mostCurrent._pnlinput.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=7733252;
 //BA.debugLineNum = 7733252;BA.debugLine="pnlInput.LoadLayout ( mlayout )";
mostCurrent._pnlinput.LoadLayout(_mlayout,mostCurrent.activityBA);
RDebugUtils.currentLine=7733254;
 //BA.debugLineNum = 7733254;BA.debugLine="pnlSelect.BringToFront";
mostCurrent._pnlselect.BringToFront();
RDebugUtils.currentLine=7733255;
 //BA.debugLineNum = 7733255;BA.debugLine="pnlSelect.Color  = Colors.ARGB (150,0,0,0)";
mostCurrent._pnlselect.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (150),(int) (0),(int) (0),(int) (0)));
RDebugUtils.currentLine=7733256;
 //BA.debugLineNum = 7733256;BA.debugLine="Activity.AddView (pnlSelect, 0, 0,   100%x, 100%y";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._pnlselect.getObject()),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
RDebugUtils.currentLine=7733257;
 //BA.debugLineNum = 7733257;BA.debugLine="mh1=(pnlSelect.Height/2) - (PanelMain.Height/2) +";
_mh1 = (float) ((mostCurrent._pnlselect.getHeight()/(double)2)-(mostCurrent._panelmain.getHeight()/(double)2)+_hc);
RDebugUtils.currentLine=7733258;
 //BA.debugLineNum = 7733258;BA.debugLine="mw1=pnlSelect.Width/2 - (PanelMain.Width/2) + wc";
_mw1 = (float) (mostCurrent._pnlselect.getWidth()/(double)2-(mostCurrent._panelmain.getWidth()/(double)2)+_wc);
RDebugUtils.currentLine=7733259;
 //BA.debugLineNum = 7733259;BA.debugLine="mh2=PanelMain.Height";
_mh2 = (float) (mostCurrent._panelmain.getHeight());
RDebugUtils.currentLine=7733260;
 //BA.debugLineNum = 7733260;BA.debugLine="mw2=PanelMain.Width";
_mw2 = (float) (mostCurrent._panelmain.getWidth());
RDebugUtils.currentLine=7733261;
 //BA.debugLineNum = 7733261;BA.debugLine="pnlSelect.AddView (pnlInput, mw1, mh1, mw2, mh2)";
mostCurrent._pnlselect.AddView((android.view.View)(mostCurrent._pnlinput.getObject()),(int) (_mw1),(int) (_mh1),(int) (_mw2),(int) (_mh2));
RDebugUtils.currentLine=7733269;
 //BA.debugLineNum = 7733269;BA.debugLine="End Sub";
return "";
}
public static String  _select_click() throws Exception{
RDebugUtils.currentModule="family_card";
if (Debug.shouldDelegate(mostCurrent.activityBA, "select_click"))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "select_click", null));}
RDebugUtils.currentLine=7798784;
 //BA.debugLineNum = 7798784;BA.debugLine="Sub Select_Click ' Stop clicks on Select panel get";
RDebugUtils.currentLine=7798786;
 //BA.debugLineNum = 7798786;BA.debugLine="pnlSelect.RemoveView";
mostCurrent._pnlselect.RemoveView();
RDebugUtils.currentLine=7798787;
 //BA.debugLineNum = 7798787;BA.debugLine="Button1.Visible=True";
mostCurrent._button1.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=7798788;
 //BA.debugLineNum = 7798788;BA.debugLine="End Sub";
return "";
}
}
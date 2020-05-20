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

public class citizen extends Activity implements B4AActivity{
	public static citizen mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.citizen");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (citizen).");
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
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.citizen");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.citizen", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (citizen) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (citizen) Resume **");
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
		return citizen.class;
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
        BA.LogInfo("** Activity (citizen) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
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
            citizen mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (citizen) Resume **");
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
public anywheresoftware.b4a.objects.PanelWrapper _panelmain1 = null;
public static float _mh1 = 0f;
public static float _mh2 = 0f;
public static float _mw1 = 0f;
public static float _mw2 = 0f;
public static String _domain = "";
public anywheresoftware.b4a.samples.httputils2.httpjob _job2 = null;
public anywheresoftware.b4a.objects.WebViewWrapper _wv1 = null;
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
public anywheresoftware.b4a.objects.ScrollViewWrapper _scrollview1 = null;
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
public b4a.example.family_card _family_card = null;
public b4a.example.land_by_owner _land_by_owner = null;
public b4a.example.building_id _building_id = null;
public b4a.example.building_owner _building_owner = null;
public b4a.example.buildings _buildings = null;
public b4a.example.owner_states _owner_states = null;
public b4a.example.owners _owners = null;
public b4a.example.lands _lands = null;
public b4a.example.lands_id _lands_id = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="citizen";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create"))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=7995392;
 //BA.debugLineNum = 7995392;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=7995394;
 //BA.debugLineNum = 7995394;BA.debugLine="Activity.LoadLayout(\"citizen\")";
mostCurrent._activity.LoadLayout("citizen",mostCurrent.activityBA);
RDebugUtils.currentLine=7995395;
 //BA.debugLineNum = 7995395;BA.debugLine="job2.Initialize(\"Job2\", Me)";
mostCurrent._job2._initialize(processBA,"Job2",citizen.getObject());
RDebugUtils.currentLine=7995396;
 //BA.debugLineNum = 7995396;BA.debugLine="job2.PostString(domain&\"ta_v2/endpoint/countFcn.p";
mostCurrent._job2._poststring(mostCurrent._domain+"ta_v2/endpoint/countFcn.php","send=test"+"&data=test");
RDebugUtils.currentLine=7995397;
 //BA.debugLineNum = 7995397;BA.debugLine="ProgressDialogShow(\"Loading...\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,BA.ObjectToCharSequence("Loading..."));
RDebugUtils.currentLine=7995399;
 //BA.debugLineNum = 7995399;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="citizen";
RDebugUtils.currentLine=8126464;
 //BA.debugLineNum = 8126464;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=8126466;
 //BA.debugLineNum = 8126466;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="citizen";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume"))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=8060928;
 //BA.debugLineNum = 8060928;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=8060929;
 //BA.debugLineNum = 8060929;BA.debugLine="job2.Initialize(\"Job2\", Me)";
mostCurrent._job2._initialize(processBA,"Job2",citizen.getObject());
RDebugUtils.currentLine=8060930;
 //BA.debugLineNum = 8060930;BA.debugLine="job2.PostString(domain&\"ta_v2/endpoint/countFcn.p";
mostCurrent._job2._poststring(mostCurrent._domain+"ta_v2/endpoint/countFcn.php","send=test"+"&data=test");
RDebugUtils.currentLine=8060931;
 //BA.debugLineNum = 8060931;BA.debugLine="ProgressDialogShow(\"Loading...\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,BA.ObjectToCharSequence("Loading..."));
RDebugUtils.currentLine=8060932;
 //BA.debugLineNum = 8060932;BA.debugLine="End Sub";
return "";
}
public static String  _button1_click() throws Exception{
RDebugUtils.currentModule="citizen";
if (Debug.shouldDelegate(mostCurrent.activityBA, "button1_click"))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "button1_click", null));}
String _citizen_id = "";
int _size = 0;
int _x = 0;
RDebugUtils.currentLine=8257536;
 //BA.debugLineNum = 8257536;BA.debugLine="Sub Button1_Click";
RDebugUtils.currentLine=8257537;
 //BA.debugLineNum = 8257537;BA.debugLine="Dim citizen_id As String";
_citizen_id = "";
RDebugUtils.currentLine=8257538;
 //BA.debugLineNum = 8257538;BA.debugLine="citizen_id=EditText1.Text";
_citizen_id = mostCurrent._edittext1.getText();
RDebugUtils.currentLine=8257540;
 //BA.debugLineNum = 8257540;BA.debugLine="job2.Initialize(\"Job3\", Me)";
mostCurrent._job2._initialize(processBA,"Job3",citizen.getObject());
RDebugUtils.currentLine=8257541;
 //BA.debugLineNum = 8257541;BA.debugLine="job2.PostString(domain&\"ta_v2/endpoint/citizen_se";
mostCurrent._job2._poststring(mostCurrent._domain+"ta_v2/endpoint/citizen_search.php","citizen_id="+_citizen_id);
RDebugUtils.currentLine=8257542;
 //BA.debugLineNum = 8257542;BA.debugLine="ProgressDialogShow(\"Loading...\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,BA.ObjectToCharSequence("Loading..."));
RDebugUtils.currentLine=8257543;
 //BA.debugLineNum = 8257543;BA.debugLine="Dim Size As Int";
_size = 0;
RDebugUtils.currentLine=8257544;
 //BA.debugLineNum = 8257544;BA.debugLine="Size=ListView1.Size";
_size = mostCurrent._listview1.getSize();
RDebugUtils.currentLine=8257545;
 //BA.debugLineNum = 8257545;BA.debugLine="Log(\"Jumlah Data: \" & Size)";
anywheresoftware.b4a.keywords.Common.Log("Jumlah Data: "+BA.NumberToString(_size));
RDebugUtils.currentLine=8257547;
 //BA.debugLineNum = 8257547;BA.debugLine="For x= Size To 0 Step -1";
{
final int step9 = -1;
final int limit9 = (int) (0);
_x = _size ;
for (;_x >= limit9 ;_x = _x + step9 ) {
RDebugUtils.currentLine=8257548;
 //BA.debugLineNum = 8257548;BA.debugLine="If x==0 Then";
if (_x==0) { 
 }else {
RDebugUtils.currentLine=8257551;
 //BA.debugLineNum = 8257551;BA.debugLine="ListView1.RemoveAt(x-1)";
mostCurrent._listview1.RemoveAt((int) (_x-1));
 };
 }
};
RDebugUtils.currentLine=8257554;
 //BA.debugLineNum = 8257554;BA.debugLine="End Sub";
return "";
}
public static String  _jobdone(anywheresoftware.b4a.samples.httputils2.httpjob _job) throws Exception{
RDebugUtils.currentModule="citizen";
if (Debug.shouldDelegate(mostCurrent.activityBA, "jobdone"))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "jobdone", new Object[] {_job}));}
anywheresoftware.b4a.objects.collections.JSONParser _parser = null;
anywheresoftware.b4a.objects.collections.Map _root = null;
anywheresoftware.b4a.objects.collections.List _features = null;
anywheresoftware.b4a.objects.collections.Map _colfeatures = null;
anywheresoftware.b4a.objects.collections.Map _properties = null;
String _fcn = "";
String _fcc = "";
String _nik = "";
String _clan_name = "";
String _citizen_name = "";
String _address = "";
String _gender = "";
String _phone = "";
String _cs_name = "";
String _born_date = "";
String _status_name = "";
RDebugUtils.currentLine=8192000;
 //BA.debugLineNum = 8192000;BA.debugLine="Sub JobDone (Job As HttpJob)";
RDebugUtils.currentLine=8192002;
 //BA.debugLineNum = 8192002;BA.debugLine="Log(\"JobName = \" & Job.JobName & \", Success = \" &";
anywheresoftware.b4a.keywords.Common.Log("JobName = "+_job._jobname+", Success = "+BA.ObjectToString(_job._success));
RDebugUtils.currentLine=8192003;
 //BA.debugLineNum = 8192003;BA.debugLine="If Job.Success = True Then";
if (_job._success==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=8192004;
 //BA.debugLineNum = 8192004;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
RDebugUtils.currentLine=8192006;
 //BA.debugLineNum = 8192006;BA.debugLine="Select Job.JobName";
switch (BA.switchObjectToInt(_job._jobname,"Job2","Job3","Job4")) {
case 0: {
RDebugUtils.currentLine=8192008;
 //BA.debugLineNum = 8192008;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=8192009;
 //BA.debugLineNum = 8192009;BA.debugLine="parser.Initialize(Job.GetString)";
_parser.Initialize(_job._getstring());
RDebugUtils.currentLine=8192010;
 //BA.debugLineNum = 8192010;BA.debugLine="Dim root As Map = parser.NextObject";
_root = new anywheresoftware.b4a.objects.collections.Map();
_root = _parser.NextObject();
RDebugUtils.currentLine=8192011;
 //BA.debugLineNum = 8192011;BA.debugLine="Dim features As List = root.Get(\"features\")";
_features = new anywheresoftware.b4a.objects.collections.List();
_features.setObject((java.util.List)(_root.Get((Object)("features"))));
RDebugUtils.currentLine=8192012;
 //BA.debugLineNum = 8192012;BA.debugLine="For Each colfeatures As Map In features";
_colfeatures = new anywheresoftware.b4a.objects.collections.Map();
{
final anywheresoftware.b4a.BA.IterableList group10 = _features;
final int groupLen10 = group10.getSize()
;int index10 = 0;
;
for (; index10 < groupLen10;index10++){
_colfeatures.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(group10.Get(index10)));
RDebugUtils.currentLine=8192013;
 //BA.debugLineNum = 8192013;BA.debugLine="Dim properties As Map = colfeatures.Get(\"prop";
_properties = new anywheresoftware.b4a.objects.collections.Map();
_properties.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_colfeatures.Get((Object)("properties"))));
RDebugUtils.currentLine=8192014;
 //BA.debugLineNum = 8192014;BA.debugLine="Dim fcn As String = properties.Get(\"fcn\")";
_fcn = BA.ObjectToString(_properties.Get((Object)("fcn")));
RDebugUtils.currentLine=8192015;
 //BA.debugLineNum = 8192015;BA.debugLine="Dim fcc As String = properties.Get(\"fcc\")";
_fcc = BA.ObjectToString(_properties.Get((Object)("fcc")));
RDebugUtils.currentLine=8192017;
 //BA.debugLineNum = 8192017;BA.debugLine="Label10.Text=fcn";
mostCurrent._label10.setText(BA.ObjectToCharSequence(_fcn));
RDebugUtils.currentLine=8192018;
 //BA.debugLineNum = 8192018;BA.debugLine="Label11.Text=fcc";
mostCurrent._label11.setText(BA.ObjectToCharSequence(_fcc));
 }
};
RDebugUtils.currentLine=8192020;
 //BA.debugLineNum = 8192020;BA.debugLine="Job.Release";
_job._release();
 break; }
case 1: {
RDebugUtils.currentLine=8192022;
 //BA.debugLineNum = 8192022;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=8192023;
 //BA.debugLineNum = 8192023;BA.debugLine="parser.Initialize(Job.GetString)";
_parser.Initialize(_job._getstring());
RDebugUtils.currentLine=8192024;
 //BA.debugLineNum = 8192024;BA.debugLine="Dim root As Map = parser.NextObject";
_root = new anywheresoftware.b4a.objects.collections.Map();
_root = _parser.NextObject();
RDebugUtils.currentLine=8192025;
 //BA.debugLineNum = 8192025;BA.debugLine="Dim features As List = root.Get(\"features\")";
_features = new anywheresoftware.b4a.objects.collections.List();
_features.setObject((java.util.List)(_root.Get((Object)("features"))));
RDebugUtils.currentLine=8192026;
 //BA.debugLineNum = 8192026;BA.debugLine="For Each colfeatures As Map In features";
_colfeatures = new anywheresoftware.b4a.objects.collections.Map();
{
final anywheresoftware.b4a.BA.IterableList group23 = _features;
final int groupLen23 = group23.getSize()
;int index23 = 0;
;
for (; index23 < groupLen23;index23++){
_colfeatures.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(group23.Get(index23)));
RDebugUtils.currentLine=8192027;
 //BA.debugLineNum = 8192027;BA.debugLine="Dim properties As Map = colfeatures.Get(\"prop";
_properties = new anywheresoftware.b4a.objects.collections.Map();
_properties.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_colfeatures.Get((Object)("properties"))));
RDebugUtils.currentLine=8192028;
 //BA.debugLineNum = 8192028;BA.debugLine="Dim nik As String = properties.Get(\"nik\")";
_nik = BA.ObjectToString(_properties.Get((Object)("nik")));
RDebugUtils.currentLine=8192029;
 //BA.debugLineNum = 8192029;BA.debugLine="Dim clan_name As String = properties.Get(\"cla";
_clan_name = BA.ObjectToString(_properties.Get((Object)("clan_name")));
RDebugUtils.currentLine=8192030;
 //BA.debugLineNum = 8192030;BA.debugLine="Dim citizen_name As String = properties.Get(\"";
_citizen_name = BA.ObjectToString(_properties.Get((Object)("citizen_name")));
RDebugUtils.currentLine=8192031;
 //BA.debugLineNum = 8192031;BA.debugLine="Dim address As String = properties.Get(\"addre";
_address = BA.ObjectToString(_properties.Get((Object)("address")));
RDebugUtils.currentLine=8192032;
 //BA.debugLineNum = 8192032;BA.debugLine="Dim gender As String = properties.Get(\"gender";
_gender = BA.ObjectToString(_properties.Get((Object)("gender")));
RDebugUtils.currentLine=8192033;
 //BA.debugLineNum = 8192033;BA.debugLine="Dim phone As String = properties.Get(\"phone\")";
_phone = BA.ObjectToString(_properties.Get((Object)("phone")));
RDebugUtils.currentLine=8192034;
 //BA.debugLineNum = 8192034;BA.debugLine="Dim cs_name As String = properties.Get(\"cs_na";
_cs_name = BA.ObjectToString(_properties.Get((Object)("cs_name")));
RDebugUtils.currentLine=8192035;
 //BA.debugLineNum = 8192035;BA.debugLine="Dim born_date As String = properties.Get(\"bor";
_born_date = BA.ObjectToString(_properties.Get((Object)("born_date")));
 }
};
RDebugUtils.currentLine=8192040;
 //BA.debugLineNum = 8192040;BA.debugLine="ListView1.AddSingleLine(nik)";
mostCurrent._listview1.AddSingleLine(BA.ObjectToCharSequence(_nik));
RDebugUtils.currentLine=8192041;
 //BA.debugLineNum = 8192041;BA.debugLine="ListView1.AddSingleLine(\"Land Owning\")";
mostCurrent._listview1.AddSingleLine(BA.ObjectToCharSequence("Land Owning"));
RDebugUtils.currentLine=8192042;
 //BA.debugLineNum = 8192042;BA.debugLine="ListView1.AddSingleLine(\"Building Owning\")";
mostCurrent._listview1.AddSingleLine(BA.ObjectToCharSequence("Building Owning"));
RDebugUtils.currentLine=8192043;
 //BA.debugLineNum = 8192043;BA.debugLine="ListView1.SingleLineLayout.Label.TextSize=20";
mostCurrent._listview1.getSingleLineLayout().Label.setTextSize((float) (20));
RDebugUtils.currentLine=8192044;
 //BA.debugLineNum = 8192044;BA.debugLine="ListView1.SingleLineLayout.ItemHeight = 24dip";
mostCurrent._listview1.getSingleLineLayout().setItemHeight(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (24)));
RDebugUtils.currentLine=8192045;
 //BA.debugLineNum = 8192045;BA.debugLine="ListView1.SingleLineLayout.Label.TextColor = C";
mostCurrent._listview1.getSingleLineLayout().Label.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=8192046;
 //BA.debugLineNum = 8192046;BA.debugLine="ListView1.SingleLineLayout.Label.Gravity=Gravi";
mostCurrent._listview1.getSingleLineLayout().Label.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_HORIZONTAL);
 break; }
case 2: {
RDebugUtils.currentLine=8192049;
 //BA.debugLineNum = 8192049;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=8192050;
 //BA.debugLineNum = 8192050;BA.debugLine="Log(Job.GetString)";
anywheresoftware.b4a.keywords.Common.Log(_job._getstring());
RDebugUtils.currentLine=8192051;
 //BA.debugLineNum = 8192051;BA.debugLine="parser.Initialize(Job.GetString)";
_parser.Initialize(_job._getstring());
RDebugUtils.currentLine=8192052;
 //BA.debugLineNum = 8192052;BA.debugLine="Dim root As Map = parser.NextObject";
_root = new anywheresoftware.b4a.objects.collections.Map();
_root = _parser.NextObject();
RDebugUtils.currentLine=8192053;
 //BA.debugLineNum = 8192053;BA.debugLine="Dim nik As String = root.Get(\"nik\")";
_nik = BA.ObjectToString(_root.Get((Object)("nik")));
RDebugUtils.currentLine=8192054;
 //BA.debugLineNum = 8192054;BA.debugLine="Dim clan_name As String = root.Get(\"clan_name\"";
_clan_name = BA.ObjectToString(_root.Get((Object)("clan_name")));
RDebugUtils.currentLine=8192055;
 //BA.debugLineNum = 8192055;BA.debugLine="Dim citizen_name As String = root.Get(\"citizen";
_citizen_name = BA.ObjectToString(_root.Get((Object)("citizen_name")));
RDebugUtils.currentLine=8192056;
 //BA.debugLineNum = 8192056;BA.debugLine="Dim gender As String = root.Get(\"gender\")";
_gender = BA.ObjectToString(_root.Get((Object)("gender")));
RDebugUtils.currentLine=8192057;
 //BA.debugLineNum = 8192057;BA.debugLine="Dim phone As String = root.Get(\"phone\")";
_phone = BA.ObjectToString(_root.Get((Object)("phone")));
RDebugUtils.currentLine=8192058;
 //BA.debugLineNum = 8192058;BA.debugLine="Dim status_name As String = root.Get(\"status_n";
_status_name = BA.ObjectToString(_root.Get((Object)("status_name")));
RDebugUtils.currentLine=8192059;
 //BA.debugLineNum = 8192059;BA.debugLine="Dim born_date As String = root.Get(\"born_date\"";
_born_date = BA.ObjectToString(_root.Get((Object)("born_date")));
RDebugUtils.currentLine=8192061;
 //BA.debugLineNum = 8192061;BA.debugLine="citizen_name_g=citizen_name";
mostCurrent._citizen_name_g = _citizen_name;
RDebugUtils.currentLine=8192062;
 //BA.debugLineNum = 8192062;BA.debugLine="gender_g=gender";
mostCurrent._gender_g = _gender;
RDebugUtils.currentLine=8192063;
 //BA.debugLineNum = 8192063;BA.debugLine="phone_g=phone";
mostCurrent._phone_g = _phone;
RDebugUtils.currentLine=8192064;
 //BA.debugLineNum = 8192064;BA.debugLine="status_g=status_name";
mostCurrent._status_g = _status_name;
RDebugUtils.currentLine=8192067;
 //BA.debugLineNum = 8192067;BA.debugLine="Job.Release";
_job._release();
 break; }
}
;
 }else {
RDebugUtils.currentLine=8192070;
 //BA.debugLineNum = 8192070;BA.debugLine="Log(\"Error: \" & Job.ErrorMessage)";
anywheresoftware.b4a.keywords.Common.Log("Error: "+_job._errormessage);
RDebugUtils.currentLine=8192071;
 //BA.debugLineNum = 8192071;BA.debugLine="ToastMessageShow(\"Error: \" & Job.ErrorMessage, T";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Error: "+_job._errormessage),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=8192072;
 //BA.debugLineNum = 8192072;BA.debugLine="Job.Release";
_job._release();
 };
RDebugUtils.currentLine=8192075;
 //BA.debugLineNum = 8192075;BA.debugLine="End Sub";
return "";
}
public static String  _listview1_itemclick(int _position,Object _value) throws Exception{
RDebugUtils.currentModule="citizen";
if (Debug.shouldDelegate(mostCurrent.activityBA, "listview1_itemclick"))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "listview1_itemclick", new Object[] {_position,_value}));}
RDebugUtils.currentLine=8454144;
 //BA.debugLineNum = 8454144;BA.debugLine="Sub ListView1_ItemClick (Position As Int, Value As";
RDebugUtils.currentLine=8454145;
 //BA.debugLineNum = 8454145;BA.debugLine="Button1.Visible=False";
mostCurrent._button1.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=8454151;
 //BA.debugLineNum = 8454151;BA.debugLine="Log(\"Data yang diklik: \" & Value)";
anywheresoftware.b4a.keywords.Common.Log("Data yang diklik: "+BA.ObjectToString(_value));
RDebugUtils.currentLine=8454153;
 //BA.debugLineNum = 8454153;BA.debugLine="If Value==\"Land Owning\" Then";
if ((_value).equals((Object)("Land Owning"))) { 
 }else 
{RDebugUtils.currentLine=8454155;
 //BA.debugLineNum = 8454155;BA.debugLine="Else If Value==\"Building Owning\" Then";
if ((_value).equals((Object)("Building Owning"))) { 
RDebugUtils.currentLine=8454156;
 //BA.debugLineNum = 8454156;BA.debugLine="PanPopBuilding(\"cpanel_building.bal\", 0, 0,Value";
_panpopbuilding("cpanel_building.bal",(int) (0),(int) (0),BA.ObjectToString(_value));
 }else {
RDebugUtils.currentLine=8454159;
 //BA.debugLineNum = 8454159;BA.debugLine="job2.Initialize(\"Job4\", Me)";
mostCurrent._job2._initialize(processBA,"Job4",citizen.getObject());
RDebugUtils.currentLine=8454160;
 //BA.debugLineNum = 8454160;BA.debugLine="job2.PostString(domain&\"ta_v2/endpoint/citizen_b";
mostCurrent._job2._poststring(mostCurrent._domain+"ta_v2/endpoint/citizen_by_nik.php","citizen_id="+BA.ObjectToString(_value));
RDebugUtils.currentLine=8454161;
 //BA.debugLineNum = 8454161;BA.debugLine="ProgressDialogShow(\"Loading...\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,BA.ObjectToCharSequence("Loading..."));
RDebugUtils.currentLine=8454162;
 //BA.debugLineNum = 8454162;BA.debugLine="Label1.Text=\"Name:\"&citizen_name_g";
mostCurrent._label1.setText(BA.ObjectToCharSequence("Name:"+mostCurrent._citizen_name_g));
RDebugUtils.currentLine=8454163;
 //BA.debugLineNum = 8454163;BA.debugLine="Label2.Text=\"Phone:\"&phone_g";
mostCurrent._label2.setText(BA.ObjectToCharSequence("Phone:"+mostCurrent._phone_g));
RDebugUtils.currentLine=8454164;
 //BA.debugLineNum = 8454164;BA.debugLine="Label3.Text=\"Gender:\"&gender_g";
mostCurrent._label3.setText(BA.ObjectToCharSequence("Gender:"+mostCurrent._gender_g));
RDebugUtils.currentLine=8454165;
 //BA.debugLineNum = 8454165;BA.debugLine="Label4.Text=\"Status:\"&status_g";
mostCurrent._label4.setText(BA.ObjectToCharSequence("Status:"+mostCurrent._status_g));
RDebugUtils.currentLine=8454166;
 //BA.debugLineNum = 8454166;BA.debugLine="Label5.Text=\"Clan:\"&clan_g";
mostCurrent._label5.setText(BA.ObjectToCharSequence("Clan:"+mostCurrent._clan_g));
RDebugUtils.currentLine=8454167;
 //BA.debugLineNum = 8454167;BA.debugLine="ProgressDialogShow(\"Loading...\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,BA.ObjectToCharSequence("Loading..."));
RDebugUtils.currentLine=8454168;
 //BA.debugLineNum = 8454168;BA.debugLine="PanPop(\"cpanel.bal\", 40, 20,Value)";
_panpop("cpanel.bal",(int) (40),(int) (20),BA.ObjectToString(_value));
 }}
;
RDebugUtils.currentLine=8454177;
 //BA.debugLineNum = 8454177;BA.debugLine="End Sub";
return "";
}
public static String  _panpopbuilding(String _mlayout,int _hc,int _wc,String _nik) throws Exception{
RDebugUtils.currentModule="citizen";
if (Debug.shouldDelegate(mostCurrent.activityBA, "panpopbuilding"))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "panpopbuilding", new Object[] {_mlayout,_hc,_wc,_nik}));}
String _citizen_id = "";
RDebugUtils.currentLine=13107200;
 //BA.debugLineNum = 13107200;BA.debugLine="Sub PanPopBuilding (mlayout As String, hc As Int,";
RDebugUtils.currentLine=13107201;
 //BA.debugLineNum = 13107201;BA.debugLine="Dim citizen_id As String";
_citizen_id = "";
RDebugUtils.currentLine=13107202;
 //BA.debugLineNum = 13107202;BA.debugLine="citizen_id=EditText1.Text";
_citizen_id = mostCurrent._edittext1.getText();
RDebugUtils.currentLine=13107203;
 //BA.debugLineNum = 13107203;BA.debugLine="pnlSelect.Initialize ( \"Select\")";
mostCurrent._pnlselect.Initialize(mostCurrent.activityBA,"Select");
RDebugUtils.currentLine=13107204;
 //BA.debugLineNum = 13107204;BA.debugLine="pnlInput.Initialize (\"\")";
mostCurrent._pnlinput.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=13107205;
 //BA.debugLineNum = 13107205;BA.debugLine="pnlInput.LoadLayout ( mlayout )";
mostCurrent._pnlinput.LoadLayout(_mlayout,mostCurrent.activityBA);
RDebugUtils.currentLine=13107207;
 //BA.debugLineNum = 13107207;BA.debugLine="pnlSelect.BringToFront";
mostCurrent._pnlselect.BringToFront();
RDebugUtils.currentLine=13107208;
 //BA.debugLineNum = 13107208;BA.debugLine="pnlSelect.Color  = Colors.ARGB (150,0,0,0)";
mostCurrent._pnlselect.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (150),(int) (0),(int) (0),(int) (0)));
RDebugUtils.currentLine=13107209;
 //BA.debugLineNum = 13107209;BA.debugLine="Activity.AddView (pnlSelect, 0, 0,   100%x, 100%y";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._pnlselect.getObject()),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
RDebugUtils.currentLine=13107210;
 //BA.debugLineNum = 13107210;BA.debugLine="mh1=(pnlSelect.Height/2) - (PanelMain1.Height/2)";
_mh1 = (float) ((mostCurrent._pnlselect.getHeight()/(double)2)-(mostCurrent._panelmain1.getHeight()/(double)2)+_hc);
RDebugUtils.currentLine=13107211;
 //BA.debugLineNum = 13107211;BA.debugLine="mw1=pnlSelect.Width/2 - (PanelMain1.Width/2) + wc";
_mw1 = (float) (mostCurrent._pnlselect.getWidth()/(double)2-(mostCurrent._panelmain1.getWidth()/(double)2)+_wc);
RDebugUtils.currentLine=13107212;
 //BA.debugLineNum = 13107212;BA.debugLine="mh2=pnlSelect.Height-50dip";
_mh2 = (float) (mostCurrent._pnlselect.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)));
RDebugUtils.currentLine=13107213;
 //BA.debugLineNum = 13107213;BA.debugLine="mw2=pnlSelect.Width-50dip";
_mw2 = (float) (mostCurrent._pnlselect.getWidth()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)));
RDebugUtils.currentLine=13107215;
 //BA.debugLineNum = 13107215;BA.debugLine="wv1.LoadURL(domain&\"ta_v2/endpoint/view/land_owne";
mostCurrent._wv1.LoadUrl(mostCurrent._domain+"ta_v2/endpoint/view/land_owner.php?owner_id="+_citizen_id);
RDebugUtils.currentLine=13107225;
 //BA.debugLineNum = 13107225;BA.debugLine="End Sub";
return "";
}
public static String  _panpop(String _mlayout,int _hc,int _wc,String _nik) throws Exception{
RDebugUtils.currentModule="citizen";
if (Debug.shouldDelegate(mostCurrent.activityBA, "panpop"))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "panpop", new Object[] {_mlayout,_hc,_wc,_nik}));}
RDebugUtils.currentLine=8323072;
 //BA.debugLineNum = 8323072;BA.debugLine="Sub PanPop (mlayout As String, hc As Int, wc As In";
RDebugUtils.currentLine=8323074;
 //BA.debugLineNum = 8323074;BA.debugLine="pnlSelect.Initialize ( \"Select\")";
mostCurrent._pnlselect.Initialize(mostCurrent.activityBA,"Select");
RDebugUtils.currentLine=8323075;
 //BA.debugLineNum = 8323075;BA.debugLine="pnlInput.Initialize (\"\")";
mostCurrent._pnlinput.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=8323076;
 //BA.debugLineNum = 8323076;BA.debugLine="pnlInput.LoadLayout ( mlayout )";
mostCurrent._pnlinput.LoadLayout(_mlayout,mostCurrent.activityBA);
RDebugUtils.currentLine=8323078;
 //BA.debugLineNum = 8323078;BA.debugLine="pnlSelect.BringToFront";
mostCurrent._pnlselect.BringToFront();
RDebugUtils.currentLine=8323079;
 //BA.debugLineNum = 8323079;BA.debugLine="pnlSelect.Color  = Colors.ARGB (150,0,0,0)";
mostCurrent._pnlselect.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (150),(int) (0),(int) (0),(int) (0)));
RDebugUtils.currentLine=8323080;
 //BA.debugLineNum = 8323080;BA.debugLine="Activity.AddView (pnlSelect, 0, 0,   100%x, 100%y";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._pnlselect.getObject()),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
RDebugUtils.currentLine=8323081;
 //BA.debugLineNum = 8323081;BA.debugLine="mh1=(pnlSelect.Height/2) - (PanelMain.Height/2) +";
_mh1 = (float) ((mostCurrent._pnlselect.getHeight()/(double)2)-(mostCurrent._panelmain.getHeight()/(double)2)+_hc);
RDebugUtils.currentLine=8323082;
 //BA.debugLineNum = 8323082;BA.debugLine="mw1=pnlSelect.Width/2 - (PanelMain.Width/2) + wc";
_mw1 = (float) (mostCurrent._pnlselect.getWidth()/(double)2-(mostCurrent._panelmain.getWidth()/(double)2)+_wc);
RDebugUtils.currentLine=8323083;
 //BA.debugLineNum = 8323083;BA.debugLine="mh2=PanelMain.Height";
_mh2 = (float) (mostCurrent._panelmain.getHeight());
RDebugUtils.currentLine=8323084;
 //BA.debugLineNum = 8323084;BA.debugLine="mw2=PanelMain.Width";
_mw2 = (float) (mostCurrent._panelmain.getWidth());
RDebugUtils.currentLine=8323085;
 //BA.debugLineNum = 8323085;BA.debugLine="pnlSelect.AddView (pnlInput, mw1, mh1, mw2, mh2)";
mostCurrent._pnlselect.AddView((android.view.View)(mostCurrent._pnlinput.getObject()),(int) (_mw1),(int) (_mh1),(int) (_mw2),(int) (_mh2));
RDebugUtils.currentLine=8323088;
 //BA.debugLineNum = 8323088;BA.debugLine="ProgressDialogShow(\"Loading...\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,BA.ObjectToCharSequence("Loading..."));
RDebugUtils.currentLine=8323089;
 //BA.debugLineNum = 8323089;BA.debugLine="Label1.Text=\"Name:\"&citizen_name_g";
mostCurrent._label1.setText(BA.ObjectToCharSequence("Name:"+mostCurrent._citizen_name_g));
RDebugUtils.currentLine=8323090;
 //BA.debugLineNum = 8323090;BA.debugLine="Label2.Text=\"Phone:\"&phone_g";
mostCurrent._label2.setText(BA.ObjectToCharSequence("Phone:"+mostCurrent._phone_g));
RDebugUtils.currentLine=8323091;
 //BA.debugLineNum = 8323091;BA.debugLine="Label3.Text=\"Gender:\"&gender_g";
mostCurrent._label3.setText(BA.ObjectToCharSequence("Gender:"+mostCurrent._gender_g));
RDebugUtils.currentLine=8323092;
 //BA.debugLineNum = 8323092;BA.debugLine="Label4.Text=\"Status:\"&status_g";
mostCurrent._label4.setText(BA.ObjectToCharSequence("Status:"+mostCurrent._status_g));
RDebugUtils.currentLine=8323093;
 //BA.debugLineNum = 8323093;BA.debugLine="Label5.Text=\"Clan:\"&clan_g";
mostCurrent._label5.setText(BA.ObjectToCharSequence("Clan:"+mostCurrent._clan_g));
RDebugUtils.currentLine=8323100;
 //BA.debugLineNum = 8323100;BA.debugLine="End Sub";
return "";
}
public static String  _select_click() throws Exception{
RDebugUtils.currentModule="citizen";
if (Debug.shouldDelegate(mostCurrent.activityBA, "select_click"))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "select_click", null));}
RDebugUtils.currentLine=8388608;
 //BA.debugLineNum = 8388608;BA.debugLine="Sub Select_Click ' Stop clicks on Select panel get";
RDebugUtils.currentLine=8388610;
 //BA.debugLineNum = 8388610;BA.debugLine="pnlSelect.RemoveView";
mostCurrent._pnlselect.RemoveView();
RDebugUtils.currentLine=8388611;
 //BA.debugLineNum = 8388611;BA.debugLine="Button1.Visible=True";
mostCurrent._button1.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=8388612;
 //BA.debugLineNum = 8388612;BA.debugLine="End Sub";
return "";
}
}
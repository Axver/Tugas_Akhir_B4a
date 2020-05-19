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

public class building_id extends Activity implements B4AActivity{
	public static building_id mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.building_id");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (building_id).");
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
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.building_id");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.building_id", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (building_id) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (building_id) Resume **");
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
		return building_id.class;
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
        BA.LogInfo("** Activity (building_id) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
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
            building_id mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (building_id) Resume **");
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
public anywheresoftware.b4a.objects.WebViewWrapper _webview1 = null;
public static String _domain = "";
public anywheresoftware.b4a.samples.httputils2.httpjob _job2 = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edittext1 = null;
public anywheresoftware.b4a.objects.ListViewWrapper _listview1 = null;
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
public b4a.example.citizen _citizen = null;
public b4a.example.lands_id _lands_id = null;
public b4a.example.lands _lands = null;
public b4a.example.land_by_owner _land_by_owner = null;
public b4a.example.building_owner _building_owner = null;
public b4a.example.buildings _buildings = null;
public b4a.example.owner_states _owner_states = null;
public b4a.example.owners _owners = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="building_id";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create"))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=9830400;
 //BA.debugLineNum = 9830400;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=9830402;
 //BA.debugLineNum = 9830402;BA.debugLine="Activity.LoadLayout(\"building_id\")";
mostCurrent._activity.LoadLayout("building_id",mostCurrent.activityBA);
RDebugUtils.currentLine=9830404;
 //BA.debugLineNum = 9830404;BA.debugLine="WebView1.LoadUrl(domain&\"ta_v2/endpoint/view/laye";
mostCurrent._webview1.LoadUrl(mostCurrent._domain+"ta_v2/endpoint/view/layers.php?request=all");
RDebugUtils.currentLine=9830405;
 //BA.debugLineNum = 9830405;BA.debugLine="ProgressDialogShow(\"Loading...\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,BA.ObjectToCharSequence("Loading..."));
RDebugUtils.currentLine=9830408;
 //BA.debugLineNum = 9830408;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="building_id";
RDebugUtils.currentLine=9961472;
 //BA.debugLineNum = 9961472;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=9961474;
 //BA.debugLineNum = 9961474;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="building_id";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume"))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=9895936;
 //BA.debugLineNum = 9895936;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=9895938;
 //BA.debugLineNum = 9895938;BA.debugLine="End Sub";
return "";
}
public static String  _button1_click() throws Exception{
RDebugUtils.currentModule="building_id";
if (Debug.shouldDelegate(mostCurrent.activityBA, "button1_click"))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "button1_click", null));}
String _tax_number = "";
RDebugUtils.currentLine=10092544;
 //BA.debugLineNum = 10092544;BA.debugLine="Sub Button1_Click";
RDebugUtils.currentLine=10092545;
 //BA.debugLineNum = 10092545;BA.debugLine="Dim tax_number As String";
_tax_number = "";
RDebugUtils.currentLine=10092546;
 //BA.debugLineNum = 10092546;BA.debugLine="tax_number= EditText1.Text";
_tax_number = mostCurrent._edittext1.getText();
RDebugUtils.currentLine=10092548;
 //BA.debugLineNum = 10092548;BA.debugLine="WebView1.LoadUrl(domain&\"ta_v2/endpoint/view/land";
mostCurrent._webview1.LoadUrl(mostCurrent._domain+"ta_v2/endpoint/view/land_tax_view.php?tax_number="+_tax_number);
RDebugUtils.currentLine=10092549;
 //BA.debugLineNum = 10092549;BA.debugLine="ProgressDialogShow(\"Loading...\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,BA.ObjectToCharSequence("Loading..."));
RDebugUtils.currentLine=10092551;
 //BA.debugLineNum = 10092551;BA.debugLine="job2.Initialize(\"Job2\", Me)";
mostCurrent._job2._initialize(processBA,"Job2",building_id.getObject());
RDebugUtils.currentLine=10092552;
 //BA.debugLineNum = 10092552;BA.debugLine="job2.PostString(domain&\"ta_v2/endpoint/land_tax.p";
mostCurrent._job2._poststring(mostCurrent._domain+"ta_v2/endpoint/land_tax.php","tax_number="+_tax_number);
RDebugUtils.currentLine=10092553;
 //BA.debugLineNum = 10092553;BA.debugLine="ProgressDialogShow(\"Loading...\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,BA.ObjectToCharSequence("Loading..."));
RDebugUtils.currentLine=10092554;
 //BA.debugLineNum = 10092554;BA.debugLine="End Sub";
return "";
}
public static String  _jobdone(anywheresoftware.b4a.samples.httputils2.httpjob _job) throws Exception{
RDebugUtils.currentModule="building_id";
if (Debug.shouldDelegate(mostCurrent.activityBA, "jobdone"))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "jobdone", new Object[] {_job}));}
anywheresoftware.b4a.objects.collections.JSONParser _parser = null;
anywheresoftware.b4a.objects.collections.Map _root = null;
anywheresoftware.b4a.objects.collections.List _features = null;
anywheresoftware.b4a.objects.collections.Map _colfeatures = null;
anywheresoftware.b4a.objects.collections.Map _geometry = null;
anywheresoftware.b4a.objects.collections.List _coordinates = null;
anywheresoftware.b4a.objects.collections.List _colcoordinates = null;
anywheresoftware.b4a.objects.collections.List _colcolcoordinates = null;
anywheresoftware.b4a.objects.collections.List _colcolcolcoordinates = null;
double _colcolcolcolcoordinates = 0;
String _type = "";
anywheresoftware.b4a.objects.collections.Map _properties = null;
String _clan_name = "";
String _owner_name = "";
String _gender = "";
String _land_owner = "";
String _phone = "";
String _tax_number = "";
String _status_name = "";
String _x = "";
String _y = "";
String _land_id = "";
String _born_date = "";
RDebugUtils.currentLine=10158080;
 //BA.debugLineNum = 10158080;BA.debugLine="Sub JobDone (Job As HttpJob)";
RDebugUtils.currentLine=10158082;
 //BA.debugLineNum = 10158082;BA.debugLine="Log(\"JobName = \" & Job.JobName & \", Success = \" &";
anywheresoftware.b4a.keywords.Common.Log("JobName = "+_job._jobname+", Success = "+BA.ObjectToString(_job._success));
RDebugUtils.currentLine=10158083;
 //BA.debugLineNum = 10158083;BA.debugLine="If Job.Success = True Then";
if (_job._success==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=10158084;
 //BA.debugLineNum = 10158084;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
RDebugUtils.currentLine=10158085;
 //BA.debugLineNum = 10158085;BA.debugLine="Select Job.JobName";
switch (BA.switchObjectToInt(_job._jobname,"Job2")) {
case 0: {
RDebugUtils.currentLine=10158087;
 //BA.debugLineNum = 10158087;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=10158088;
 //BA.debugLineNum = 10158088;BA.debugLine="parser.Initialize(Job.GetString)";
_parser.Initialize(_job._getstring());
RDebugUtils.currentLine=10158089;
 //BA.debugLineNum = 10158089;BA.debugLine="Log(Job.GetString)";
anywheresoftware.b4a.keywords.Common.Log(_job._getstring());
RDebugUtils.currentLine=10158090;
 //BA.debugLineNum = 10158090;BA.debugLine="Dim root As Map = parser.NextObject";
_root = new anywheresoftware.b4a.objects.collections.Map();
_root = _parser.NextObject();
RDebugUtils.currentLine=10158091;
 //BA.debugLineNum = 10158091;BA.debugLine="Dim features As List = root.Get(\"features\")";
_features = new anywheresoftware.b4a.objects.collections.List();
_features.setObject((java.util.List)(_root.Get((Object)("features"))));
RDebugUtils.currentLine=10158092;
 //BA.debugLineNum = 10158092;BA.debugLine="For Each colfeatures As Map In features";
_colfeatures = new anywheresoftware.b4a.objects.collections.Map();
{
final anywheresoftware.b4a.BA.IterableList group11 = _features;
final int groupLen11 = group11.getSize()
;int index11 = 0;
;
for (; index11 < groupLen11;index11++){
_colfeatures.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(group11.Get(index11)));
RDebugUtils.currentLine=10158093;
 //BA.debugLineNum = 10158093;BA.debugLine="Dim geometry As Map = colfeatures.Get(\"geomet";
_geometry = new anywheresoftware.b4a.objects.collections.Map();
_geometry.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_colfeatures.Get((Object)("geometry"))));
RDebugUtils.currentLine=10158094;
 //BA.debugLineNum = 10158094;BA.debugLine="Dim coordinates As List = geometry.Get(\"coord";
_coordinates = new anywheresoftware.b4a.objects.collections.List();
_coordinates.setObject((java.util.List)(_geometry.Get((Object)("coordinates"))));
RDebugUtils.currentLine=10158095;
 //BA.debugLineNum = 10158095;BA.debugLine="For Each colcoordinates As List In coordinate";
_colcoordinates = new anywheresoftware.b4a.objects.collections.List();
{
final anywheresoftware.b4a.BA.IterableList group14 = _coordinates;
final int groupLen14 = group14.getSize()
;int index14 = 0;
;
for (; index14 < groupLen14;index14++){
_colcoordinates.setObject((java.util.List)(group14.Get(index14)));
RDebugUtils.currentLine=10158096;
 //BA.debugLineNum = 10158096;BA.debugLine="For Each colcolcoordinates As List In colcoo";
_colcolcoordinates = new anywheresoftware.b4a.objects.collections.List();
{
final anywheresoftware.b4a.BA.IterableList group15 = _colcoordinates;
final int groupLen15 = group15.getSize()
;int index15 = 0;
;
for (; index15 < groupLen15;index15++){
_colcolcoordinates.setObject((java.util.List)(group15.Get(index15)));
RDebugUtils.currentLine=10158097;
 //BA.debugLineNum = 10158097;BA.debugLine="For Each colcolcolcoordinates As List In co";
_colcolcolcoordinates = new anywheresoftware.b4a.objects.collections.List();
{
final anywheresoftware.b4a.BA.IterableList group16 = _colcolcoordinates;
final int groupLen16 = group16.getSize()
;int index16 = 0;
;
for (; index16 < groupLen16;index16++){
_colcolcolcoordinates.setObject((java.util.List)(group16.Get(index16)));
RDebugUtils.currentLine=10158098;
 //BA.debugLineNum = 10158098;BA.debugLine="For Each colcolcolcolcoordinates As Double";
{
final anywheresoftware.b4a.BA.IterableList group17 = _colcolcolcoordinates;
final int groupLen17 = group17.getSize()
;int index17 = 0;
;
for (; index17 < groupLen17;index17++){
_colcolcolcolcoordinates = (double)(BA.ObjectToNumber(group17.Get(index17)));
 }
};
 }
};
 }
};
 }
};
RDebugUtils.currentLine=10158103;
 //BA.debugLineNum = 10158103;BA.debugLine="Dim Type As String = geometry.Get(\"type\")";
_type = BA.ObjectToString(_geometry.Get((Object)("type")));
RDebugUtils.currentLine=10158104;
 //BA.debugLineNum = 10158104;BA.debugLine="Dim Type As String = colfeatures.Get(\"type\")";
_type = BA.ObjectToString(_colfeatures.Get((Object)("type")));
RDebugUtils.currentLine=10158105;
 //BA.debugLineNum = 10158105;BA.debugLine="Dim properties As Map = colfeatures.Get(\"prop";
_properties = new anywheresoftware.b4a.objects.collections.Map();
_properties.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_colfeatures.Get((Object)("properties"))));
RDebugUtils.currentLine=10158106;
 //BA.debugLineNum = 10158106;BA.debugLine="Dim clan_name As String = properties.Get(\"cla";
_clan_name = BA.ObjectToString(_properties.Get((Object)("clan_name")));
RDebugUtils.currentLine=10158107;
 //BA.debugLineNum = 10158107;BA.debugLine="Dim owner_name As String = properties.Get(\"ow";
_owner_name = BA.ObjectToString(_properties.Get((Object)("owner_name")));
RDebugUtils.currentLine=10158108;
 //BA.debugLineNum = 10158108;BA.debugLine="Dim gender As String = properties.Get(\"gender";
_gender = BA.ObjectToString(_properties.Get((Object)("gender")));
RDebugUtils.currentLine=10158109;
 //BA.debugLineNum = 10158109;BA.debugLine="Dim land_owner As String = properties.Get(\"la";
_land_owner = BA.ObjectToString(_properties.Get((Object)("land_owner")));
RDebugUtils.currentLine=10158110;
 //BA.debugLineNum = 10158110;BA.debugLine="Dim phone As String = properties.Get(\"phone\")";
_phone = BA.ObjectToString(_properties.Get((Object)("phone")));
RDebugUtils.currentLine=10158111;
 //BA.debugLineNum = 10158111;BA.debugLine="Dim tax_number As String = properties.Get(\"ta";
_tax_number = BA.ObjectToString(_properties.Get((Object)("tax_number")));
RDebugUtils.currentLine=10158112;
 //BA.debugLineNum = 10158112;BA.debugLine="Dim status_name As String = properties.Get(\"s";
_status_name = BA.ObjectToString(_properties.Get((Object)("status_name")));
RDebugUtils.currentLine=10158113;
 //BA.debugLineNum = 10158113;BA.debugLine="Dim x As String = properties.Get(\"x\")";
_x = BA.ObjectToString(_properties.Get((Object)("x")));
RDebugUtils.currentLine=10158114;
 //BA.debugLineNum = 10158114;BA.debugLine="Dim y As String = properties.Get(\"y\")";
_y = BA.ObjectToString(_properties.Get((Object)("y")));
RDebugUtils.currentLine=10158115;
 //BA.debugLineNum = 10158115;BA.debugLine="Dim land_id As String = properties.Get(\"land_";
_land_id = BA.ObjectToString(_properties.Get((Object)("land_id")));
RDebugUtils.currentLine=10158116;
 //BA.debugLineNum = 10158116;BA.debugLine="Dim born_date As String = properties.Get(\"bor";
_born_date = BA.ObjectToString(_properties.Get((Object)("born_date")));
RDebugUtils.currentLine=10158119;
 //BA.debugLineNum = 10158119;BA.debugLine="ListView1.AddSingleLine(\"Information\")";
mostCurrent._listview1.AddSingleLine(BA.ObjectToCharSequence("Information"));
RDebugUtils.currentLine=10158120;
 //BA.debugLineNum = 10158120;BA.debugLine="ListView1.SingleLineLayout.Label.TextSize = 1";
mostCurrent._listview1.getSingleLineLayout().Label.setTextSize((float) (12));
RDebugUtils.currentLine=10158121;
 //BA.debugLineNum = 10158121;BA.debugLine="ListView1.SingleLineLayout.Label.TextColor =";
mostCurrent._listview1.getSingleLineLayout().Label.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=10158122;
 //BA.debugLineNum = 10158122;BA.debugLine="ListView1.AddSingleLine(\"Clan Name:\"&clan_nam";
mostCurrent._listview1.AddSingleLine(BA.ObjectToCharSequence("Clan Name:"+_clan_name));
RDebugUtils.currentLine=10158123;
 //BA.debugLineNum = 10158123;BA.debugLine="ListView1.AddSingleLine(\"Owner Name:\"&owner_n";
mostCurrent._listview1.AddSingleLine(BA.ObjectToCharSequence("Owner Name:"+_owner_name));
RDebugUtils.currentLine=10158124;
 //BA.debugLineNum = 10158124;BA.debugLine="ListView1.AddSingleLine(\"Gender:\"&gender)";
mostCurrent._listview1.AddSingleLine(BA.ObjectToCharSequence("Gender:"+_gender));
RDebugUtils.currentLine=10158125;
 //BA.debugLineNum = 10158125;BA.debugLine="ListView1.AddSingleLine(\"Land Owner:\"&land_ow";
mostCurrent._listview1.AddSingleLine(BA.ObjectToCharSequence("Land Owner:"+_land_owner));
RDebugUtils.currentLine=10158126;
 //BA.debugLineNum = 10158126;BA.debugLine="ListView1.AddSingleLine(\"Phone:\"&phone)";
mostCurrent._listview1.AddSingleLine(BA.ObjectToCharSequence("Phone:"+_phone));
RDebugUtils.currentLine=10158127;
 //BA.debugLineNum = 10158127;BA.debugLine="ListView1.AddSingleLine(\"Tax Number:\"&tax_num";
mostCurrent._listview1.AddSingleLine(BA.ObjectToCharSequence("Tax Number:"+_tax_number));
RDebugUtils.currentLine=10158128;
 //BA.debugLineNum = 10158128;BA.debugLine="ListView1.AddSingleLine(\"Status:\"&status_name";
mostCurrent._listview1.AddSingleLine(BA.ObjectToCharSequence("Status:"+_status_name));
RDebugUtils.currentLine=10158129;
 //BA.debugLineNum = 10158129;BA.debugLine="ListView1.AddSingleLine(\"Land Id:\"&land_id)";
mostCurrent._listview1.AddSingleLine(BA.ObjectToCharSequence("Land Id:"+_land_id));
RDebugUtils.currentLine=10158130;
 //BA.debugLineNum = 10158130;BA.debugLine="ListView1.AddSingleLine(\"Coordinates:\"&x&\"||\"";
mostCurrent._listview1.AddSingleLine(BA.ObjectToCharSequence("Coordinates:"+_x+"||"+_y));
 }
};
RDebugUtils.currentLine=10158132;
 //BA.debugLineNum = 10158132;BA.debugLine="Dim Type As String = root.Get(\"type\")";
_type = BA.ObjectToString(_root.Get((Object)("type")));
 break; }
}
;
 }else {
RDebugUtils.currentLine=10158144;
 //BA.debugLineNum = 10158144;BA.debugLine="Log(\"Error: \" & Job.ErrorMessage)";
anywheresoftware.b4a.keywords.Common.Log("Error: "+_job._errormessage);
RDebugUtils.currentLine=10158145;
 //BA.debugLineNum = 10158145;BA.debugLine="ToastMessageShow(\"Error: \" & Job.ErrorMessage, T";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Error: "+_job._errormessage),anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=10158147;
 //BA.debugLineNum = 10158147;BA.debugLine="Job.Release";
_job._release();
RDebugUtils.currentLine=10158148;
 //BA.debugLineNum = 10158148;BA.debugLine="End Sub";
return "";
}
public static String  _webview1_pagefinished(String _strurl) throws Exception{
RDebugUtils.currentModule="building_id";
if (Debug.shouldDelegate(mostCurrent.activityBA, "webview1_pagefinished"))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "webview1_pagefinished", new Object[] {_strurl}));}
RDebugUtils.currentLine=10027008;
 //BA.debugLineNum = 10027008;BA.debugLine="Sub webview1_PageFinished (StrUrl As String)";
RDebugUtils.currentLine=10027009;
 //BA.debugLineNum = 10027009;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
RDebugUtils.currentLine=10027011;
 //BA.debugLineNum = 10027011;BA.debugLine="End Sub";
return "";
}
}
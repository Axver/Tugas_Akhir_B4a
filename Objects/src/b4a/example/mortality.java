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

public class mortality extends Activity implements B4AActivity{
	public static mortality mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.mortality");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (mortality).");
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
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.mortality");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.mortality", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (mortality) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (mortality) Resume **");
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
		return mortality.class;
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
        BA.LogInfo("** Activity (mortality) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
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
            mortality mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (mortality) Resume **");
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
public anywheresoftware.b4a.objects.ScrollViewWrapper _sv = null;
public anywheresoftware.b4a.objects.PanelWrapper _header = null;
public anywheresoftware.b4a.objects.PanelWrapper _table = null;
public static int _numberofcolumns = 0;
public static int _rowheight = 0;
public static int _columnwidth = 0;
public static int _headercolor = 0;
public static int _tablecolor = 0;
public static int _fontcolor = 0;
public static int _headerfontcolor = 0;
public static float _fontsize = 0f;
public static int _alignment = 0;
public static int _selectedrow = 0;
public static int _selectedrowcolor = 0;
public anywheresoftware.b4a.objects.PanelWrapper _panel7 = null;
public anywheresoftware.b4a.samples.httputils2.httputils2service _httputils2service = null;
public b4a.example.main _main = null;
public b4a.example.starter _starter = null;
public b4a.example.dashboard _dashboard = null;
public b4a.example.birth _birth = null;
public b4a.example.add_birth _add_birth = null;
public b4a.example.add_mortality _add_mortality = null;
public b4a.example.outcome _outcome = null;
public b4a.example.add_outcome _add_outcome = null;
public b4a.example.family_card _family_card = null;
public b4a.example.citizen _citizen = null;
public b4a.example.lands_id _lands_id = null;
public b4a.example.lands _lands = null;
public b4a.example.land_by_owner _land_by_owner = null;
public b4a.example.building_id _building_id = null;
public b4a.example.building_owner _building_owner = null;
public b4a.example.buildings _buildings = null;
public b4a.example.owner_states _owner_states = null;
public b4a.example.owners _owners = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="mortality";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create"))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=3866624;
 //BA.debugLineNum = 3866624;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=3866627;
 //BA.debugLineNum = 3866627;BA.debugLine="Activity.LoadLayout(\"mortality\")";
mostCurrent._activity.LoadLayout("mortality",mostCurrent.activityBA);
RDebugUtils.currentLine=3866628;
 //BA.debugLineNum = 3866628;BA.debugLine="SV.Initialize(0)";
mostCurrent._sv.Initialize(mostCurrent.activityBA,(int) (0));
RDebugUtils.currentLine=3866629;
 //BA.debugLineNum = 3866629;BA.debugLine="Table = SV.Panel";
mostCurrent._table = mostCurrent._sv.getPanel();
RDebugUtils.currentLine=3866630;
 //BA.debugLineNum = 3866630;BA.debugLine="Table.Color = TableColor";
mostCurrent._table.setColor(_tablecolor);
RDebugUtils.currentLine=3866632;
 //BA.debugLineNum = 3866632;BA.debugLine="Panel7.AddView(SV, 5%x, 10%y, 90%x, 80%y)";
mostCurrent._panel7.AddView((android.view.View)(mostCurrent._sv.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (5),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (10),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (90),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (80),mostCurrent.activityBA));
RDebugUtils.currentLine=3866633;
 //BA.debugLineNum = 3866633;BA.debugLine="ColumnWidth = SV.Width / NumberOfColumns";
_columnwidth = (int) (mostCurrent._sv.getWidth()/(double)_numberofcolumns);
RDebugUtils.currentLine=3866634;
 //BA.debugLineNum = 3866634;BA.debugLine="SelectedRow = -1";
_selectedrow = (int) (-1);
RDebugUtils.currentLine=3866636;
 //BA.debugLineNum = 3866636;BA.debugLine="SetHeader(Array As String(\"Id\", \"Citizen\", \"Age\",";
_setheader(new String[]{"Id","Citizen","Age","Cause Of Death"});
RDebugUtils.currentLine=3866637;
 //BA.debugLineNum = 3866637;BA.debugLine="job2.Initialize(\"Job2\", Me)";
mostCurrent._job2._initialize(processBA,"Job2",mortality.getObject());
RDebugUtils.currentLine=3866639;
 //BA.debugLineNum = 3866639;BA.debugLine="job2.PostString(domain&\"ta_v2/endpoint/mortality.";
mostCurrent._job2._poststring(mostCurrent._domain+"ta_v2/endpoint/mortality.php","send=test"+"&data=test");
RDebugUtils.currentLine=3866640;
 //BA.debugLineNum = 3866640;BA.debugLine="ProgressDialogShow(\"Loading...\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,BA.ObjectToCharSequence("Loading..."));
RDebugUtils.currentLine=3866650;
 //BA.debugLineNum = 3866650;BA.debugLine="End Sub";
return "";
}
public static String  _setheader(String[] _values) throws Exception{
RDebugUtils.currentModule="mortality";
if (Debug.shouldDelegate(mostCurrent.activityBA, "setheader"))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "setheader", new Object[] {_values}));}
int _i = 0;
anywheresoftware.b4a.objects.LabelWrapper _l = null;
RDebugUtils.currentLine=4390912;
 //BA.debugLineNum = 4390912;BA.debugLine="Sub SetHeader(Values() As String)";
RDebugUtils.currentLine=4390913;
 //BA.debugLineNum = 4390913;BA.debugLine="If Header.IsInitialized Then Return 'should only";
if (mostCurrent._header.IsInitialized()) { 
if (true) return "";};
RDebugUtils.currentLine=4390914;
 //BA.debugLineNum = 4390914;BA.debugLine="Header.Initialize(\"\")";
mostCurrent._header.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=4390915;
 //BA.debugLineNum = 4390915;BA.debugLine="For i = 0 To NumberOfColumns - 1";
{
final int step3 = 1;
final int limit3 = (int) (_numberofcolumns-1);
_i = (int) (0) ;
for (;_i <= limit3 ;_i = _i + step3 ) {
RDebugUtils.currentLine=4390916;
 //BA.debugLineNum = 4390916;BA.debugLine="Dim l As Label";
_l = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=4390917;
 //BA.debugLineNum = 4390917;BA.debugLine="l.Initialize(\"header\")";
_l.Initialize(mostCurrent.activityBA,"header");
RDebugUtils.currentLine=4390918;
 //BA.debugLineNum = 4390918;BA.debugLine="l.Text = Values(i)";
_l.setText(BA.ObjectToCharSequence(_values[_i]));
RDebugUtils.currentLine=4390919;
 //BA.debugLineNum = 4390919;BA.debugLine="l.Gravity = Gravity.CENTER";
_l.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=4390920;
 //BA.debugLineNum = 4390920;BA.debugLine="l.TextSize = FontSize";
_l.setTextSize(_fontsize);
RDebugUtils.currentLine=4390921;
 //BA.debugLineNum = 4390921;BA.debugLine="l.Color = HeaderColor";
_l.setColor(_headercolor);
RDebugUtils.currentLine=4390922;
 //BA.debugLineNum = 4390922;BA.debugLine="l.TextColor = HeaderFontColor";
_l.setTextColor(_headerfontcolor);
RDebugUtils.currentLine=4390923;
 //BA.debugLineNum = 4390923;BA.debugLine="l.Tag = i";
_l.setTag((Object)(_i));
RDebugUtils.currentLine=4390924;
 //BA.debugLineNum = 4390924;BA.debugLine="Header.AddView(l, ColumnWidth * i, 0, ColumnWidt";
mostCurrent._header.AddView((android.view.View)(_l.getObject()),(int) (_columnwidth*_i),(int) (0),_columnwidth,_rowheight);
 }
};
RDebugUtils.currentLine=4390926;
 //BA.debugLineNum = 4390926;BA.debugLine="Activity.AddView(Header, SV.Left, SV.Top+200, SV.";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._header.getObject()),mostCurrent._sv.getLeft(),(int) (mostCurrent._sv.getTop()+200),mostCurrent._sv.getWidth(),_rowheight);
RDebugUtils.currentLine=4390927;
 //BA.debugLineNum = 4390927;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="mortality";
RDebugUtils.currentLine=3997696;
 //BA.debugLineNum = 3997696;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=3997698;
 //BA.debugLineNum = 3997698;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="mortality";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume"))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=3932160;
 //BA.debugLineNum = 3932160;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=3932161;
 //BA.debugLineNum = 3932161;BA.debugLine="ClearAll";
_clearall();
RDebugUtils.currentLine=3932162;
 //BA.debugLineNum = 3932162;BA.debugLine="job2.Initialize(\"Job2\", Me)";
mostCurrent._job2._initialize(processBA,"Job2",mortality.getObject());
RDebugUtils.currentLine=3932163;
 //BA.debugLineNum = 3932163;BA.debugLine="job2.PostString(domain&\"ta_v2/endpoint/mortality.";
mostCurrent._job2._poststring(mostCurrent._domain+"ta_v2/endpoint/mortality.php","send=test"+"&data=test");
RDebugUtils.currentLine=3932164;
 //BA.debugLineNum = 3932164;BA.debugLine="ProgressDialogShow(\"Loading...\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,BA.ObjectToCharSequence("Loading..."));
RDebugUtils.currentLine=3932165;
 //BA.debugLineNum = 3932165;BA.debugLine="End Sub";
return "";
}
public static String  _clearall() throws Exception{
RDebugUtils.currentModule="mortality";
if (Debug.shouldDelegate(mostCurrent.activityBA, "clearall"))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "clearall", null));}
int _i = 0;
RDebugUtils.currentLine=4653056;
 //BA.debugLineNum = 4653056;BA.debugLine="Sub ClearAll";
RDebugUtils.currentLine=4653057;
 //BA.debugLineNum = 4653057;BA.debugLine="For i = Table.NumberOfViews -1 To 0 Step -1";
{
final int step1 = -1;
final int limit1 = (int) (0);
_i = (int) (mostCurrent._table.getNumberOfViews()-1) ;
for (;_i >= limit1 ;_i = _i + step1 ) {
RDebugUtils.currentLine=4653058;
 //BA.debugLineNum = 4653058;BA.debugLine="Table.RemoveViewAt(i)";
mostCurrent._table.RemoveViewAt(_i);
 }
};
RDebugUtils.currentLine=4653060;
 //BA.debugLineNum = 4653060;BA.debugLine="Table.Height = 0";
mostCurrent._table.setHeight((int) (0));
RDebugUtils.currentLine=4653061;
 //BA.debugLineNum = 4653061;BA.debugLine="SelectedRow = -1";
_selectedrow = (int) (-1);
RDebugUtils.currentLine=4653062;
 //BA.debugLineNum = 4653062;BA.debugLine="End Sub";
return "";
}
public static String  _addrow(String[] _values) throws Exception{
RDebugUtils.currentModule="mortality";
if (Debug.shouldDelegate(mostCurrent.activityBA, "addrow"))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "addrow", new Object[] {_values}));}
int _lastrow = 0;
int _i = 0;
anywheresoftware.b4a.objects.LabelWrapper _l = null;
b4a.example.birth._rowcol _rc = null;
RDebugUtils.currentLine=4325376;
 //BA.debugLineNum = 4325376;BA.debugLine="Sub AddRow(Values() As String)";
RDebugUtils.currentLine=4325377;
 //BA.debugLineNum = 4325377;BA.debugLine="If Values.Length <> NumberOfColumns Then";
if (_values.length!=_numberofcolumns) { 
RDebugUtils.currentLine=4325378;
 //BA.debugLineNum = 4325378;BA.debugLine="Log(\"Wrong number of values.\")";
anywheresoftware.b4a.keywords.Common.Log("Wrong number of values.");
RDebugUtils.currentLine=4325379;
 //BA.debugLineNum = 4325379;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=4325381;
 //BA.debugLineNum = 4325381;BA.debugLine="Dim lastRow As Int";
_lastrow = 0;
RDebugUtils.currentLine=4325382;
 //BA.debugLineNum = 4325382;BA.debugLine="lastRow = NumberOfRows";
_lastrow = _numberofrows();
RDebugUtils.currentLine=4325383;
 //BA.debugLineNum = 4325383;BA.debugLine="For i = 0 To NumberOfColumns - 1";
{
final int step7 = 1;
final int limit7 = (int) (_numberofcolumns-1);
_i = (int) (0) ;
for (;_i <= limit7 ;_i = _i + step7 ) {
RDebugUtils.currentLine=4325384;
 //BA.debugLineNum = 4325384;BA.debugLine="Dim l As Label";
_l = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=4325385;
 //BA.debugLineNum = 4325385;BA.debugLine="l.Initialize(\"cell\")";
_l.Initialize(mostCurrent.activityBA,"cell");
RDebugUtils.currentLine=4325386;
 //BA.debugLineNum = 4325386;BA.debugLine="l.Text = Values(i)";
_l.setText(BA.ObjectToCharSequence(_values[_i]));
RDebugUtils.currentLine=4325387;
 //BA.debugLineNum = 4325387;BA.debugLine="l.Gravity = Alignment";
_l.setGravity(_alignment);
RDebugUtils.currentLine=4325388;
 //BA.debugLineNum = 4325388;BA.debugLine="l.TextSize = FontSize";
_l.setTextSize(_fontsize);
RDebugUtils.currentLine=4325389;
 //BA.debugLineNum = 4325389;BA.debugLine="l.TextColor = FontColor";
_l.setTextColor(_fontcolor);
RDebugUtils.currentLine=4325390;
 //BA.debugLineNum = 4325390;BA.debugLine="Dim rc As RowCol";
_rc = new b4a.example.birth._rowcol();
RDebugUtils.currentLine=4325391;
 //BA.debugLineNum = 4325391;BA.debugLine="rc.Initialize";
_rc.Initialize();
RDebugUtils.currentLine=4325392;
 //BA.debugLineNum = 4325392;BA.debugLine="rc.Col = i";
_rc.Col = _i;
RDebugUtils.currentLine=4325393;
 //BA.debugLineNum = 4325393;BA.debugLine="rc.Row = lastRow";
_rc.Row = _lastrow;
RDebugUtils.currentLine=4325394;
 //BA.debugLineNum = 4325394;BA.debugLine="l.Tag = rc";
_l.setTag((Object)(_rc));
RDebugUtils.currentLine=4325395;
 //BA.debugLineNum = 4325395;BA.debugLine="Table.AddView(l, ColumnWidth * i, RowHeight * la";
mostCurrent._table.AddView((android.view.View)(_l.getObject()),(int) (_columnwidth*_i),(int) (_rowheight*_lastrow),_columnwidth,_rowheight);
 }
};
RDebugUtils.currentLine=4325397;
 //BA.debugLineNum = 4325397;BA.debugLine="Table.Height = NumberOfRows * RowHeight";
mostCurrent._table.setHeight((int) (_numberofrows()*_rowheight));
RDebugUtils.currentLine=4325398;
 //BA.debugLineNum = 4325398;BA.debugLine="End Sub";
return "";
}
public static int  _numberofrows() throws Exception{
RDebugUtils.currentModule="mortality";
if (Debug.shouldDelegate(mostCurrent.activityBA, "numberofrows"))
	 {return ((Integer) Debug.delegate(mostCurrent.activityBA, "numberofrows", null));}
RDebugUtils.currentLine=4456448;
 //BA.debugLineNum = 4456448;BA.debugLine="Sub NumberOfRows As Int";
RDebugUtils.currentLine=4456449;
 //BA.debugLineNum = 4456449;BA.debugLine="Return Table.NumberOfViews / NumberOfColumns";
if (true) return (int) (mostCurrent._table.getNumberOfViews()/(double)_numberofcolumns);
RDebugUtils.currentLine=4456450;
 //BA.debugLineNum = 4456450;BA.debugLine="End Sub";
return 0;
}
public static String  _cell_click() throws Exception{
RDebugUtils.currentModule="mortality";
if (Debug.shouldDelegate(mostCurrent.activityBA, "cell_click"))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "cell_click", null));}
b4a.example.birth._rowcol _rc = null;
anywheresoftware.b4a.objects.LabelWrapper _l = null;
RDebugUtils.currentLine=4063232;
 //BA.debugLineNum = 4063232;BA.debugLine="Sub Cell_Click";
RDebugUtils.currentLine=4063233;
 //BA.debugLineNum = 4063233;BA.debugLine="Dim rc As RowCol";
_rc = new b4a.example.birth._rowcol();
RDebugUtils.currentLine=4063234;
 //BA.debugLineNum = 4063234;BA.debugLine="Dim l As Label";
_l = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=4063235;
 //BA.debugLineNum = 4063235;BA.debugLine="l = Sender";
_l.setObject((android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=4063236;
 //BA.debugLineNum = 4063236;BA.debugLine="rc = l.Tag";
_rc = (b4a.example.birth._rowcol)(_l.getTag());
RDebugUtils.currentLine=4063237;
 //BA.debugLineNum = 4063237;BA.debugLine="SelectRow(rc.Row)";
_selectrow(_rc.Row);
RDebugUtils.currentLine=4063238;
 //BA.debugLineNum = 4063238;BA.debugLine="Activity.Title = \"Cell clicked: (\" & rc.Row & \",";
mostCurrent._activity.setTitle(BA.ObjectToCharSequence("Cell clicked: ("+BA.NumberToString(_rc.Row)+", "+BA.NumberToString(_rc.Col)+")"));
RDebugUtils.currentLine=4063239;
 //BA.debugLineNum = 4063239;BA.debugLine="End Sub";
return "";
}
public static String  _selectrow(int _row) throws Exception{
RDebugUtils.currentModule="mortality";
if (Debug.shouldDelegate(mostCurrent.activityBA, "selectrow"))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "selectrow", new Object[] {_row}));}
int _col = 0;
RDebugUtils.currentLine=4194304;
 //BA.debugLineNum = 4194304;BA.debugLine="Sub SelectRow(Row As Int)";
RDebugUtils.currentLine=4194306;
 //BA.debugLineNum = 4194306;BA.debugLine="If SelectedRow > -1 Then";
if (_selectedrow>-1) { 
RDebugUtils.currentLine=4194307;
 //BA.debugLineNum = 4194307;BA.debugLine="For col = 0 To NumberOfColumns - 1";
{
final int step2 = 1;
final int limit2 = (int) (_numberofcolumns-1);
_col = (int) (0) ;
for (;_col <= limit2 ;_col = _col + step2 ) {
RDebugUtils.currentLine=4194308;
 //BA.debugLineNum = 4194308;BA.debugLine="GetView(SelectedRow, col).Color = Colors.Transp";
_getview(_selectedrow,_col).setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
 }
};
 };
RDebugUtils.currentLine=4194311;
 //BA.debugLineNum = 4194311;BA.debugLine="SelectedRow = Row";
_selectedrow = _row;
RDebugUtils.currentLine=4194312;
 //BA.debugLineNum = 4194312;BA.debugLine="For col = 0 To NumberOfColumns - 1";
{
final int step7 = 1;
final int limit7 = (int) (_numberofcolumns-1);
_col = (int) (0) ;
for (;_col <= limit7 ;_col = _col + step7 ) {
RDebugUtils.currentLine=4194313;
 //BA.debugLineNum = 4194313;BA.debugLine="GetView(Row, col).Color = SelectedRowColor";
_getview(_row,_col).setColor(_selectedrowcolor);
 }
};
RDebugUtils.currentLine=4194315;
 //BA.debugLineNum = 4194315;BA.debugLine="End Sub";
return "";
}
public static String  _getcell(int _row,int _col) throws Exception{
RDebugUtils.currentModule="mortality";
if (Debug.shouldDelegate(mostCurrent.activityBA, "getcell"))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "getcell", new Object[] {_row,_col}));}
RDebugUtils.currentLine=4587520;
 //BA.debugLineNum = 4587520;BA.debugLine="Sub GetCell(Row As Int, Col As Int) As String";
RDebugUtils.currentLine=4587521;
 //BA.debugLineNum = 4587521;BA.debugLine="Return GetView(Row, Col).Text";
if (true) return _getview(_row,_col).getText();
RDebugUtils.currentLine=4587522;
 //BA.debugLineNum = 4587522;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.LabelWrapper  _getview(int _row,int _col) throws Exception{
RDebugUtils.currentModule="mortality";
if (Debug.shouldDelegate(mostCurrent.activityBA, "getview"))
	 {return ((anywheresoftware.b4a.objects.LabelWrapper) Debug.delegate(mostCurrent.activityBA, "getview", new Object[] {_row,_col}));}
anywheresoftware.b4a.objects.LabelWrapper _l = null;
RDebugUtils.currentLine=4259840;
 //BA.debugLineNum = 4259840;BA.debugLine="Sub GetView(Row As Int, Col As Int) As Label";
RDebugUtils.currentLine=4259841;
 //BA.debugLineNum = 4259841;BA.debugLine="Dim l As Label";
_l = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=4259842;
 //BA.debugLineNum = 4259842;BA.debugLine="l = Table.GetView(Row * NumberOfColumns + Col)";
_l.setObject((android.widget.TextView)(mostCurrent._table.GetView((int) (_row*_numberofcolumns+_col)).getObject()));
RDebugUtils.currentLine=4259843;
 //BA.debugLineNum = 4259843;BA.debugLine="Return l";
if (true) return _l;
RDebugUtils.currentLine=4259844;
 //BA.debugLineNum = 4259844;BA.debugLine="End Sub";
return null;
}
public static String  _header_click() throws Exception{
RDebugUtils.currentModule="mortality";
if (Debug.shouldDelegate(mostCurrent.activityBA, "header_click"))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "header_click", null));}
anywheresoftware.b4a.objects.LabelWrapper _l = null;
int _col = 0;
RDebugUtils.currentLine=4128768;
 //BA.debugLineNum = 4128768;BA.debugLine="Sub Header_Click";
RDebugUtils.currentLine=4128769;
 //BA.debugLineNum = 4128769;BA.debugLine="Dim l As Label";
_l = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=4128770;
 //BA.debugLineNum = 4128770;BA.debugLine="Dim col As Int";
_col = 0;
RDebugUtils.currentLine=4128771;
 //BA.debugLineNum = 4128771;BA.debugLine="l = Sender";
_l.setObject((android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=4128772;
 //BA.debugLineNum = 4128772;BA.debugLine="col = l.Tag";
_col = (int)(BA.ObjectToNumber(_l.getTag()));
RDebugUtils.currentLine=4128773;
 //BA.debugLineNum = 4128773;BA.debugLine="Activity.Title = \"Header clicked: \" & col";
mostCurrent._activity.setTitle(BA.ObjectToCharSequence("Header clicked: "+BA.NumberToString(_col)));
RDebugUtils.currentLine=4128774;
 //BA.debugLineNum = 4128774;BA.debugLine="End Sub";
return "";
}
public static String  _jobdone(anywheresoftware.b4a.samples.httputils2.httpjob _job) throws Exception{
RDebugUtils.currentModule="mortality";
if (Debug.shouldDelegate(mostCurrent.activityBA, "jobdone"))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "jobdone", new Object[] {_job}));}
int _i = 0;
anywheresoftware.b4a.objects.collections.JSONParser _parser = null;
anywheresoftware.b4a.objects.collections.Map _root = null;
anywheresoftware.b4a.objects.collections.List _features = null;
anywheresoftware.b4a.objects.collections.Map _colfeatures = null;
anywheresoftware.b4a.objects.collections.Map _properties = null;
String _date = "";
String _citizen_id = "";
String _cause_date = "";
String _age = "";
RDebugUtils.currentLine=4718592;
 //BA.debugLineNum = 4718592;BA.debugLine="Sub JobDone (Job As HttpJob)";
RDebugUtils.currentLine=4718594;
 //BA.debugLineNum = 4718594;BA.debugLine="Log(\"JobName = \" & Job.JobName & \", Success = \" &";
anywheresoftware.b4a.keywords.Common.Log("JobName = "+_job._jobname+", Success = "+BA.ObjectToString(_job._success));
RDebugUtils.currentLine=4718595;
 //BA.debugLineNum = 4718595;BA.debugLine="If Job.Success = True Then";
if (_job._success==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=4718596;
 //BA.debugLineNum = 4718596;BA.debugLine="ClearAll";
_clearall();
RDebugUtils.currentLine=4718597;
 //BA.debugLineNum = 4718597;BA.debugLine="Dim i As Int";
_i = 0;
RDebugUtils.currentLine=4718598;
 //BA.debugLineNum = 4718598;BA.debugLine="i=1";
_i = (int) (1);
RDebugUtils.currentLine=4718600;
 //BA.debugLineNum = 4718600;BA.debugLine="Select Job.JobName";
switch (BA.switchObjectToInt(_job._jobname,"Job2")) {
case 0: {
RDebugUtils.currentLine=4718602;
 //BA.debugLineNum = 4718602;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=4718603;
 //BA.debugLineNum = 4718603;BA.debugLine="parser.Initialize(Job.GetString)";
_parser.Initialize(_job._getstring());
RDebugUtils.currentLine=4718604;
 //BA.debugLineNum = 4718604;BA.debugLine="Dim root As Map = parser.NextObject";
_root = new anywheresoftware.b4a.objects.collections.Map();
_root = _parser.NextObject();
RDebugUtils.currentLine=4718605;
 //BA.debugLineNum = 4718605;BA.debugLine="Dim features As List = root.Get(\"features\")";
_features = new anywheresoftware.b4a.objects.collections.List();
_features.setObject((java.util.List)(_root.Get((Object)("features"))));
RDebugUtils.currentLine=4718606;
 //BA.debugLineNum = 4718606;BA.debugLine="For Each colfeatures As Map In features";
_colfeatures = new anywheresoftware.b4a.objects.collections.Map();
{
final anywheresoftware.b4a.BA.IterableList group12 = _features;
final int groupLen12 = group12.getSize()
;int index12 = 0;
;
for (; index12 < groupLen12;index12++){
_colfeatures.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(group12.Get(index12)));
RDebugUtils.currentLine=4718607;
 //BA.debugLineNum = 4718607;BA.debugLine="Dim properties As Map = colfeatures.Get(\"prop";
_properties = new anywheresoftware.b4a.objects.collections.Map();
_properties.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_colfeatures.Get((Object)("properties"))));
RDebugUtils.currentLine=4718608;
 //BA.debugLineNum = 4718608;BA.debugLine="Dim date As String = properties.Get(\"date\")";
_date = BA.ObjectToString(_properties.Get((Object)("date")));
RDebugUtils.currentLine=4718609;
 //BA.debugLineNum = 4718609;BA.debugLine="Dim citizen_id As String = properties.Get(\"ci";
_citizen_id = BA.ObjectToString(_properties.Get((Object)("citizen_id")));
RDebugUtils.currentLine=4718610;
 //BA.debugLineNum = 4718610;BA.debugLine="Dim cause_date As String = properties.Get(\"ca";
_cause_date = BA.ObjectToString(_properties.Get((Object)("cause_date")));
RDebugUtils.currentLine=4718611;
 //BA.debugLineNum = 4718611;BA.debugLine="Dim age As String = properties.Get(\"age\")";
_age = BA.ObjectToString(_properties.Get((Object)("age")));
RDebugUtils.currentLine=4718612;
 //BA.debugLineNum = 4718612;BA.debugLine="AddRow(Array As String(i, citizen_id, age, ca";
_addrow(new String[]{BA.NumberToString(_i),_citizen_id,_age,_cause_date});
RDebugUtils.currentLine=4718613;
 //BA.debugLineNum = 4718613;BA.debugLine="i=i+1";
_i = (int) (_i+1);
 }
};
RDebugUtils.currentLine=4718619;
 //BA.debugLineNum = 4718619;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
 break; }
}
;
 }else {
RDebugUtils.currentLine=4718624;
 //BA.debugLineNum = 4718624;BA.debugLine="Log(\"Error: \" & Job.ErrorMessage)";
anywheresoftware.b4a.keywords.Common.Log("Error: "+_job._errormessage);
RDebugUtils.currentLine=4718625;
 //BA.debugLineNum = 4718625;BA.debugLine="ToastMessageShow(\"Error: \" & Job.ErrorMessage, T";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Error: "+_job._errormessage),anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=4718627;
 //BA.debugLineNum = 4718627;BA.debugLine="Job.Release";
_job._release();
RDebugUtils.currentLine=4718628;
 //BA.debugLineNum = 4718628;BA.debugLine="End Sub";
return "";
}
public static String  _label3_click() throws Exception{
RDebugUtils.currentModule="mortality";
if (Debug.shouldDelegate(mostCurrent.activityBA, "label3_click"))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "label3_click", null));}
RDebugUtils.currentLine=4849664;
 //BA.debugLineNum = 4849664;BA.debugLine="Sub Label3_Click";
RDebugUtils.currentLine=4849665;
 //BA.debugLineNum = 4849665;BA.debugLine="StartActivity(\"dashboard\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("dashboard"));
RDebugUtils.currentLine=4849666;
 //BA.debugLineNum = 4849666;BA.debugLine="End Sub";
return "";
}
public static String  _label7_click() throws Exception{
RDebugUtils.currentModule="mortality";
if (Debug.shouldDelegate(mostCurrent.activityBA, "label7_click"))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "label7_click", null));}
RDebugUtils.currentLine=4784128;
 //BA.debugLineNum = 4784128;BA.debugLine="Sub Label7_Click";
RDebugUtils.currentLine=4784129;
 //BA.debugLineNum = 4784129;BA.debugLine="StartActivity(\"add_mortality\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("add_mortality"));
RDebugUtils.currentLine=4784130;
 //BA.debugLineNum = 4784130;BA.debugLine="End Sub";
return "";
}
public static String  _setcell(int _row,int _col,String _value) throws Exception{
RDebugUtils.currentModule="mortality";
if (Debug.shouldDelegate(mostCurrent.activityBA, "setcell"))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "setcell", new Object[] {_row,_col,_value}));}
RDebugUtils.currentLine=4521984;
 //BA.debugLineNum = 4521984;BA.debugLine="Sub SetCell(Row As Int, Col As Int, Value As Strin";
RDebugUtils.currentLine=4521985;
 //BA.debugLineNum = 4521985;BA.debugLine="GetView(Row, Col).Text = Value";
_getview(_row,_col).setText(BA.ObjectToCharSequence(_value));
RDebugUtils.currentLine=4521986;
 //BA.debugLineNum = 4521986;BA.debugLine="End Sub";
return "";
}
}
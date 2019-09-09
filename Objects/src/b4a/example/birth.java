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

public class birth extends Activity implements B4AActivity{
	public static birth mostCurrent;
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
			processBA = new BA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.birth");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (birth).");
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
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.birth");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.birth", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (birth) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (birth) Resume **");
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
		return birth.class;
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
        BA.LogInfo("** Activity (birth) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
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
            birth mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (birth) Resume **");
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
public b4a.example.add_birth _add_birth = null;
public b4a.example.mortality _mortality = null;
public b4a.example.add_mortality _add_mortality = null;
public b4a.example.outcome _outcome = null;
public b4a.example.add_outcome _add_outcome = null;
public b4a.example.family_card _family_card = null;
public b4a.example.citizen _citizen = null;
public static class _rowcol{
public boolean IsInitialized;
public int Row;
public int Col;
public void Initialize() {
IsInitialized = true;
Row = 0;
Col = 0;
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}

public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public static String  _activity_create(boolean _firsttime) throws Exception{
 //BA.debugLineNum = 45;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 48;BA.debugLine="Activity.LoadLayout(\"birth\")";
mostCurrent._activity.LoadLayout("birth",mostCurrent.activityBA);
 //BA.debugLineNum = 49;BA.debugLine="SV.Initialize(0)";
mostCurrent._sv.Initialize(mostCurrent.activityBA,(int) (0));
 //BA.debugLineNum = 50;BA.debugLine="Table = SV.Panel";
mostCurrent._table = mostCurrent._sv.getPanel();
 //BA.debugLineNum = 51;BA.debugLine="Table.Color = TableColor";
mostCurrent._table.setColor(_tablecolor);
 //BA.debugLineNum = 53;BA.debugLine="Panel7.AddView(SV, 5%x, 10%y, 90%x, 80%y)";
mostCurrent._panel7.AddView((android.view.View)(mostCurrent._sv.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (5),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (10),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (90),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (80),mostCurrent.activityBA));
 //BA.debugLineNum = 54;BA.debugLine="ColumnWidth = SV.Width / NumberOfColumns";
_columnwidth = (int) (mostCurrent._sv.getWidth()/(double)_numberofcolumns);
 //BA.debugLineNum = 55;BA.debugLine="SelectedRow = -1";
_selectedrow = (int) (-1);
 //BA.debugLineNum = 57;BA.debugLine="SetHeader(Array As String(\"Id\", \"Reporter\", \"Type";
_setheader(new String[]{"Id","Reporter","Type Of Birth","Weight"});
 //BA.debugLineNum = 58;BA.debugLine="job2.Initialize(\"Job2\", Me)";
mostCurrent._job2._initialize(processBA,"Job2",birth.getObject());
 //BA.debugLineNum = 60;BA.debugLine="job2.PostString(domain&\"ta_v2/endpoint/birthData.";
mostCurrent._job2._poststring(mostCurrent._domain+"ta_v2/endpoint/birthData.php","send=test"+"&data=test");
 //BA.debugLineNum = 61;BA.debugLine="ProgressDialogShow(\"Loading...\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,BA.ObjectToCharSequence("Loading..."));
 //BA.debugLineNum = 71;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 80;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 82;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 73;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 74;BA.debugLine="ClearAll";
_clearall();
 //BA.debugLineNum = 75;BA.debugLine="job2.Initialize(\"Job2\", Me)";
mostCurrent._job2._initialize(processBA,"Job2",birth.getObject());
 //BA.debugLineNum = 76;BA.debugLine="job2.PostString(domain&\"ta_v2/endpoint/birthData.";
mostCurrent._job2._poststring(mostCurrent._domain+"ta_v2/endpoint/birthData.php","send=test"+"&data=test");
 //BA.debugLineNum = 77;BA.debugLine="ProgressDialogShow(\"Loading...\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,BA.ObjectToCharSequence("Loading..."));
 //BA.debugLineNum = 78;BA.debugLine="End Sub";
return "";
}
public static String  _addrow(String[] _values) throws Exception{
int _lastrow = 0;
int _i = 0;
anywheresoftware.b4a.objects.LabelWrapper _l = null;
b4a.example.birth._rowcol _rc = null;
 //BA.debugLineNum = 117;BA.debugLine="Sub AddRow(Values() As String)";
 //BA.debugLineNum = 118;BA.debugLine="If Values.Length <> NumberOfColumns Then";
if (_values.length!=_numberofcolumns) { 
 //BA.debugLineNum = 119;BA.debugLine="Log(\"Wrong number of values.\")";
anywheresoftware.b4a.keywords.Common.Log("Wrong number of values.");
 //BA.debugLineNum = 120;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 122;BA.debugLine="Dim lastRow As Int";
_lastrow = 0;
 //BA.debugLineNum = 123;BA.debugLine="lastRow = NumberOfRows";
_lastrow = _numberofrows();
 //BA.debugLineNum = 124;BA.debugLine="For i = 0 To NumberOfColumns - 1";
{
final int step7 = 1;
final int limit7 = (int) (_numberofcolumns-1);
_i = (int) (0) ;
for (;_i <= limit7 ;_i = _i + step7 ) {
 //BA.debugLineNum = 125;BA.debugLine="Dim l As Label";
_l = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 126;BA.debugLine="l.Initialize(\"cell\")";
_l.Initialize(mostCurrent.activityBA,"cell");
 //BA.debugLineNum = 127;BA.debugLine="l.Text = Values(i)";
_l.setText(BA.ObjectToCharSequence(_values[_i]));
 //BA.debugLineNum = 128;BA.debugLine="l.Gravity = Alignment";
_l.setGravity(_alignment);
 //BA.debugLineNum = 129;BA.debugLine="l.TextSize = FontSize";
_l.setTextSize(_fontsize);
 //BA.debugLineNum = 130;BA.debugLine="l.TextColor = FontColor";
_l.setTextColor(_fontcolor);
 //BA.debugLineNum = 131;BA.debugLine="Dim rc As RowCol";
_rc = new b4a.example.birth._rowcol();
 //BA.debugLineNum = 132;BA.debugLine="rc.Initialize";
_rc.Initialize();
 //BA.debugLineNum = 133;BA.debugLine="rc.Col = i";
_rc.Col = _i;
 //BA.debugLineNum = 134;BA.debugLine="rc.Row = lastRow";
_rc.Row = _lastrow;
 //BA.debugLineNum = 135;BA.debugLine="l.Tag = rc";
_l.setTag((Object)(_rc));
 //BA.debugLineNum = 136;BA.debugLine="Table.AddView(l, ColumnWidth * i, RowHeight * la";
mostCurrent._table.AddView((android.view.View)(_l.getObject()),(int) (_columnwidth*_i),(int) (_rowheight*_lastrow),_columnwidth,_rowheight);
 }
};
 //BA.debugLineNum = 138;BA.debugLine="Table.Height = NumberOfRows * RowHeight";
mostCurrent._table.setHeight((int) (_numberofrows()*_rowheight));
 //BA.debugLineNum = 139;BA.debugLine="End Sub";
return "";
}
public static String  _cell_click() throws Exception{
b4a.example.birth._rowcol _rc = null;
anywheresoftware.b4a.objects.LabelWrapper _l = null;
 //BA.debugLineNum = 84;BA.debugLine="Sub Cell_Click";
 //BA.debugLineNum = 85;BA.debugLine="Dim rc As RowCol";
_rc = new b4a.example.birth._rowcol();
 //BA.debugLineNum = 86;BA.debugLine="Dim l As Label";
_l = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 87;BA.debugLine="l = Sender";
_l.setObject((android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
 //BA.debugLineNum = 88;BA.debugLine="rc = l.Tag";
_rc = (b4a.example.birth._rowcol)(_l.getTag());
 //BA.debugLineNum = 89;BA.debugLine="SelectRow(rc.Row)";
_selectrow(_rc.Row);
 //BA.debugLineNum = 90;BA.debugLine="Activity.Title = \"Cell clicked: (\" & rc.Row & \",";
mostCurrent._activity.setTitle(BA.ObjectToCharSequence("Cell clicked: ("+BA.NumberToString(_rc.Row)+", "+BA.NumberToString(_rc.Col)+")"));
 //BA.debugLineNum = 91;BA.debugLine="End Sub";
return "";
}
public static String  _clearall() throws Exception{
int _i = 0;
 //BA.debugLineNum = 166;BA.debugLine="Sub ClearAll";
 //BA.debugLineNum = 167;BA.debugLine="For i = Table.NumberOfViews -1 To 0 Step -1";
{
final int step1 = -1;
final int limit1 = (int) (0);
_i = (int) (mostCurrent._table.getNumberOfViews()-1) ;
for (;_i >= limit1 ;_i = _i + step1 ) {
 //BA.debugLineNum = 168;BA.debugLine="Table.RemoveViewAt(i)";
mostCurrent._table.RemoveViewAt(_i);
 }
};
 //BA.debugLineNum = 170;BA.debugLine="Table.Height = 0";
mostCurrent._table.setHeight((int) (0));
 //BA.debugLineNum = 171;BA.debugLine="SelectedRow = -1";
_selectedrow = (int) (-1);
 //BA.debugLineNum = 172;BA.debugLine="End Sub";
return "";
}
public static String  _getcell(int _row,int _col) throws Exception{
 //BA.debugLineNum = 163;BA.debugLine="Sub GetCell(Row As Int, Col As Int) As String";
 //BA.debugLineNum = 164;BA.debugLine="Return GetView(Row, Col).Text";
if (true) return _getview(_row,_col).getText();
 //BA.debugLineNum = 165;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.LabelWrapper  _getview(int _row,int _col) throws Exception{
anywheresoftware.b4a.objects.LabelWrapper _l = null;
 //BA.debugLineNum = 112;BA.debugLine="Sub GetView(Row As Int, Col As Int) As Label";
 //BA.debugLineNum = 113;BA.debugLine="Dim l As Label";
_l = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 114;BA.debugLine="l = Table.GetView(Row * NumberOfColumns + Col)";
_l.setObject((android.widget.TextView)(mostCurrent._table.GetView((int) (_row*_numberofcolumns+_col)).getObject()));
 //BA.debugLineNum = 115;BA.debugLine="Return l";
if (true) return _l;
 //BA.debugLineNum = 116;BA.debugLine="End Sub";
return null;
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 13;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 16;BA.debugLine="Dim domain As String";
mostCurrent._domain = "";
 //BA.debugLineNum = 17;BA.debugLine="Dim job2 As HttpJob";
mostCurrent._job2 = new anywheresoftware.b4a.samples.httputils2.httpjob();
 //BA.debugLineNum = 18;BA.debugLine="domain=\"http://e0e5aadb.ngrok.io/\"";
mostCurrent._domain = "http://e0e5aadb.ngrok.io/";
 //BA.debugLineNum = 20;BA.debugLine="Dim SV As ScrollView";
mostCurrent._sv = new anywheresoftware.b4a.objects.ScrollViewWrapper();
 //BA.debugLineNum = 21;BA.debugLine="Dim Header As Panel";
mostCurrent._header = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 22;BA.debugLine="Dim Table As Panel";
mostCurrent._table = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 23;BA.debugLine="Dim NumberOfColumns, RowHeight, ColumnWidth As In";
_numberofcolumns = 0;
_rowheight = 0;
_columnwidth = 0;
 //BA.debugLineNum = 24;BA.debugLine="Dim HeaderColor, TableColor, FontColor, HeaderFon";
_headercolor = 0;
_tablecolor = 0;
_fontcolor = 0;
_headerfontcolor = 0;
 //BA.debugLineNum = 25;BA.debugLine="Dim FontSize As Float";
_fontsize = 0f;
 //BA.debugLineNum = 26;BA.debugLine="Type RowCol (Row As Int, Col As Int)";
;
 //BA.debugLineNum = 27;BA.debugLine="Dim Alignment As Int";
_alignment = 0;
 //BA.debugLineNum = 28;BA.debugLine="Dim SelectedRow As Int";
_selectedrow = 0;
 //BA.debugLineNum = 29;BA.debugLine="Dim SelectedRowColor As Int";
_selectedrowcolor = 0;
 //BA.debugLineNum = 32;BA.debugLine="HeaderColor = Colors.Red";
_headercolor = anywheresoftware.b4a.keywords.Common.Colors.Red;
 //BA.debugLineNum = 33;BA.debugLine="NumberOfColumns = 4";
_numberofcolumns = (int) (4);
 //BA.debugLineNum = 34;BA.debugLine="RowHeight = 30dip";
_rowheight = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30));
 //BA.debugLineNum = 35;BA.debugLine="TableColor = Colors.White";
_tablecolor = anywheresoftware.b4a.keywords.Common.Colors.White;
 //BA.debugLineNum = 36;BA.debugLine="FontColor = Colors.Black";
_fontcolor = anywheresoftware.b4a.keywords.Common.Colors.Black;
 //BA.debugLineNum = 37;BA.debugLine="HeaderFontColor = Colors.Black";
_headerfontcolor = anywheresoftware.b4a.keywords.Common.Colors.Black;
 //BA.debugLineNum = 38;BA.debugLine="FontSize = 14";
_fontsize = (float) (14);
 //BA.debugLineNum = 39;BA.debugLine="Alignment = Gravity.CENTER 'change to Gravity.LEF";
_alignment = anywheresoftware.b4a.keywords.Common.Gravity.CENTER;
 //BA.debugLineNum = 40;BA.debugLine="SelectedRowColor = Colors.Blue";
_selectedrowcolor = anywheresoftware.b4a.keywords.Common.Colors.Blue;
 //BA.debugLineNum = 42;BA.debugLine="Private Panel7 As Panel";
mostCurrent._panel7 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 43;BA.debugLine="End Sub";
return "";
}
public static String  _header_click() throws Exception{
anywheresoftware.b4a.objects.LabelWrapper _l = null;
int _col = 0;
 //BA.debugLineNum = 93;BA.debugLine="Sub Header_Click";
 //BA.debugLineNum = 94;BA.debugLine="Dim l As Label";
_l = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 95;BA.debugLine="Dim col As Int";
_col = 0;
 //BA.debugLineNum = 96;BA.debugLine="l = Sender";
_l.setObject((android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
 //BA.debugLineNum = 97;BA.debugLine="col = l.Tag";
_col = (int)(BA.ObjectToNumber(_l.getTag()));
 //BA.debugLineNum = 98;BA.debugLine="Activity.Title = \"Header clicked: \" & col";
mostCurrent._activity.setTitle(BA.ObjectToCharSequence("Header clicked: "+BA.NumberToString(_col)));
 //BA.debugLineNum = 99;BA.debugLine="End Sub";
return "";
}
public static String  _jobdone(anywheresoftware.b4a.samples.httputils2.httpjob _job) throws Exception{
anywheresoftware.b4a.objects.collections.JSONParser _parser = null;
anywheresoftware.b4a.objects.collections.Map _root = null;
anywheresoftware.b4a.objects.collections.List _features = null;
anywheresoftware.b4a.objects.collections.Map _colfeatures = null;
anywheresoftware.b4a.objects.collections.Map _properties = null;
String _citizen_id = "";
String _no_kelahiran = "";
String _type_of_birth = "";
String _weight = "";
String _nik_pelapor = "";
 //BA.debugLineNum = 174;BA.debugLine="Sub JobDone (Job As HttpJob)";
 //BA.debugLineNum = 176;BA.debugLine="Log(\"JobName = \" & Job.JobName & \", Success = \" &";
anywheresoftware.b4a.keywords.Common.Log("JobName = "+_job._jobname+", Success = "+BA.ObjectToString(_job._success));
 //BA.debugLineNum = 177;BA.debugLine="If Job.Success = True Then";
if (_job._success==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 178;BA.debugLine="ClearAll";
_clearall();
 //BA.debugLineNum = 180;BA.debugLine="Select Job.JobName";
switch (BA.switchObjectToInt(_job._jobname,"Job2")) {
case 0: {
 //BA.debugLineNum = 182;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
 //BA.debugLineNum = 183;BA.debugLine="parser.Initialize(Job.GetString)";
_parser.Initialize(_job._getstring());
 //BA.debugLineNum = 184;BA.debugLine="Dim root As Map = parser.NextObject";
_root = new anywheresoftware.b4a.objects.collections.Map();
_root = _parser.NextObject();
 //BA.debugLineNum = 185;BA.debugLine="Dim features As List = root.Get(\"features\")";
_features = new anywheresoftware.b4a.objects.collections.List();
_features.setObject((java.util.List)(_root.Get((Object)("features"))));
 //BA.debugLineNum = 187;BA.debugLine="For Each colfeatures As Map In features";
_colfeatures = new anywheresoftware.b4a.objects.collections.Map();
{
final anywheresoftware.b4a.BA.IterableList group10 = _features;
final int groupLen10 = group10.getSize()
;int index10 = 0;
;
for (; index10 < groupLen10;index10++){
_colfeatures.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(group10.Get(index10)));
 //BA.debugLineNum = 188;BA.debugLine="Dim properties As Map = colfeatures.Get(\"prop";
_properties = new anywheresoftware.b4a.objects.collections.Map();
_properties.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_colfeatures.Get((Object)("properties"))));
 //BA.debugLineNum = 189;BA.debugLine="Dim citizen_id As String = properties.Get(\"ci";
_citizen_id = BA.ObjectToString(_properties.Get((Object)("citizen_id")));
 //BA.debugLineNum = 190;BA.debugLine="Dim no_kelahiran As String = properties.Get(\"";
_no_kelahiran = BA.ObjectToString(_properties.Get((Object)("no_kelahiran")));
 //BA.debugLineNum = 191;BA.debugLine="Dim type_of_birth As String = properties.Get(";
_type_of_birth = BA.ObjectToString(_properties.Get((Object)("type_of_birth")));
 //BA.debugLineNum = 192;BA.debugLine="Dim weight As String = properties.Get(\"weight";
_weight = BA.ObjectToString(_properties.Get((Object)("weight")));
 //BA.debugLineNum = 193;BA.debugLine="Dim nik_pelapor As String = properties.Get(\"n";
_nik_pelapor = BA.ObjectToString(_properties.Get((Object)("nik_pelapor")));
 //BA.debugLineNum = 194;BA.debugLine="AddRow(Array As String(citizen_id, nik_pelapo";
_addrow(new String[]{_citizen_id,_nik_pelapor,_type_of_birth,_weight});
 }
};
 //BA.debugLineNum = 199;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
 break; }
}
;
 }else {
 //BA.debugLineNum = 204;BA.debugLine="Log(\"Error: \" & Job.ErrorMessage)";
anywheresoftware.b4a.keywords.Common.Log("Error: "+_job._errormessage);
 //BA.debugLineNum = 205;BA.debugLine="ToastMessageShow(\"Error: \" & Job.ErrorMessage, T";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Error: "+_job._errormessage),anywheresoftware.b4a.keywords.Common.True);
 };
 //BA.debugLineNum = 207;BA.debugLine="Job.Release";
_job._release();
 //BA.debugLineNum = 208;BA.debugLine="End Sub";
return "";
}
public static String  _label3_click() throws Exception{
 //BA.debugLineNum = 215;BA.debugLine="Sub Label3_Click";
 //BA.debugLineNum = 216;BA.debugLine="StartActivity(\"dashboard\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("dashboard"));
 //BA.debugLineNum = 217;BA.debugLine="End Sub";
return "";
}
public static String  _label7_click() throws Exception{
 //BA.debugLineNum = 211;BA.debugLine="Sub Label7_Click";
 //BA.debugLineNum = 212;BA.debugLine="StartActivity(\"add_birth\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("add_birth"));
 //BA.debugLineNum = 213;BA.debugLine="End Sub";
return "";
}
public static int  _numberofrows() throws Exception{
 //BA.debugLineNum = 156;BA.debugLine="Sub NumberOfRows As Int";
 //BA.debugLineNum = 157;BA.debugLine="Return Table.NumberOfViews / NumberOfColumns";
if (true) return (int) (mostCurrent._table.getNumberOfViews()/(double)_numberofcolumns);
 //BA.debugLineNum = 158;BA.debugLine="End Sub";
return 0;
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 7;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 11;BA.debugLine="End Sub";
return "";
}
public static String  _selectrow(int _row) throws Exception{
int _col = 0;
 //BA.debugLineNum = 100;BA.debugLine="Sub SelectRow(Row As Int)";
 //BA.debugLineNum = 102;BA.debugLine="If SelectedRow > -1 Then";
if (_selectedrow>-1) { 
 //BA.debugLineNum = 103;BA.debugLine="For col = 0 To NumberOfColumns - 1";
{
final int step2 = 1;
final int limit2 = (int) (_numberofcolumns-1);
_col = (int) (0) ;
for (;_col <= limit2 ;_col = _col + step2 ) {
 //BA.debugLineNum = 104;BA.debugLine="GetView(SelectedRow, col).Color = Colors.Transp";
_getview(_selectedrow,_col).setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
 }
};
 };
 //BA.debugLineNum = 107;BA.debugLine="SelectedRow = Row";
_selectedrow = _row;
 //BA.debugLineNum = 108;BA.debugLine="For col = 0 To NumberOfColumns - 1";
{
final int step7 = 1;
final int limit7 = (int) (_numberofcolumns-1);
_col = (int) (0) ;
for (;_col <= limit7 ;_col = _col + step7 ) {
 //BA.debugLineNum = 109;BA.debugLine="GetView(Row, col).Color = SelectedRowColor";
_getview(_row,_col).setColor(_selectedrowcolor);
 }
};
 //BA.debugLineNum = 111;BA.debugLine="End Sub";
return "";
}
public static String  _setcell(int _row,int _col,String _value) throws Exception{
 //BA.debugLineNum = 160;BA.debugLine="Sub SetCell(Row As Int, Col As Int, Value As Strin";
 //BA.debugLineNum = 161;BA.debugLine="GetView(Row, Col).Text = Value";
_getview(_row,_col).setText(BA.ObjectToCharSequence(_value));
 //BA.debugLineNum = 162;BA.debugLine="End Sub";
return "";
}
public static String  _setheader(String[] _values) throws Exception{
int _i = 0;
anywheresoftware.b4a.objects.LabelWrapper _l = null;
 //BA.debugLineNum = 140;BA.debugLine="Sub SetHeader(Values() As String)";
 //BA.debugLineNum = 141;BA.debugLine="If Header.IsInitialized Then Return 'should only";
if (mostCurrent._header.IsInitialized()) { 
if (true) return "";};
 //BA.debugLineNum = 142;BA.debugLine="Header.Initialize(\"\")";
mostCurrent._header.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 143;BA.debugLine="For i = 0 To NumberOfColumns - 1";
{
final int step3 = 1;
final int limit3 = (int) (_numberofcolumns-1);
_i = (int) (0) ;
for (;_i <= limit3 ;_i = _i + step3 ) {
 //BA.debugLineNum = 144;BA.debugLine="Dim l As Label";
_l = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 145;BA.debugLine="l.Initialize(\"header\")";
_l.Initialize(mostCurrent.activityBA,"header");
 //BA.debugLineNum = 146;BA.debugLine="l.Text = Values(i)";
_l.setText(BA.ObjectToCharSequence(_values[_i]));
 //BA.debugLineNum = 147;BA.debugLine="l.Gravity = Gravity.CENTER";
_l.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
 //BA.debugLineNum = 148;BA.debugLine="l.TextSize = FontSize";
_l.setTextSize(_fontsize);
 //BA.debugLineNum = 149;BA.debugLine="l.Color = HeaderColor";
_l.setColor(_headercolor);
 //BA.debugLineNum = 150;BA.debugLine="l.TextColor = HeaderFontColor";
_l.setTextColor(_headerfontcolor);
 //BA.debugLineNum = 151;BA.debugLine="l.Tag = i";
_l.setTag((Object)(_i));
 //BA.debugLineNum = 152;BA.debugLine="Header.AddView(l, ColumnWidth * i, 0, ColumnWidt";
mostCurrent._header.AddView((android.view.View)(_l.getObject()),(int) (_columnwidth*_i),(int) (0),_columnwidth,_rowheight);
 }
};
 //BA.debugLineNum = 154;BA.debugLine="Activity.AddView(Header, SV.Left, SV.Top+200, SV.";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._header.getObject()),mostCurrent._sv.getLeft(),(int) (mostCurrent._sv.getTop()+200),mostCurrent._sv.getWidth(),_rowheight);
 //BA.debugLineNum = 155;BA.debugLine="End Sub";
return "";
}
}

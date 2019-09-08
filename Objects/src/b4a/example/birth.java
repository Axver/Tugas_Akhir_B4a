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
int _i = 0;
 //BA.debugLineNum = 41;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 43;BA.debugLine="Activity.LoadLayout(\"birth\")";
mostCurrent._activity.LoadLayout("birth",mostCurrent.activityBA);
 //BA.debugLineNum = 44;BA.debugLine="SV.Initialize(0)";
mostCurrent._sv.Initialize(mostCurrent.activityBA,(int) (0));
 //BA.debugLineNum = 45;BA.debugLine="Table = SV.Panel";
mostCurrent._table = mostCurrent._sv.getPanel();
 //BA.debugLineNum = 46;BA.debugLine="Table.Color = TableColor";
mostCurrent._table.setColor(_tablecolor);
 //BA.debugLineNum = 48;BA.debugLine="Panel7.AddView(SV, 5%x, 10%y, 90%x, 80%y)";
mostCurrent._panel7.AddView((android.view.View)(mostCurrent._sv.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (5),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (10),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (90),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (80),mostCurrent.activityBA));
 //BA.debugLineNum = 49;BA.debugLine="ColumnWidth = SV.Width / NumberOfColumns";
_columnwidth = (int) (mostCurrent._sv.getWidth()/(double)_numberofcolumns);
 //BA.debugLineNum = 50;BA.debugLine="SelectedRow = -1";
_selectedrow = (int) (-1);
 //BA.debugLineNum = 52;BA.debugLine="SetHeader(Array As String(\"Col1\", \"Col2\", \"Col3\",";
_setheader(new String[]{"Col1","Col2","Col3","Col4"});
 //BA.debugLineNum = 54;BA.debugLine="For i = 1 To 100";
{
final int step9 = 1;
final int limit9 = (int) (100);
_i = (int) (1) ;
for (;_i <= limit9 ;_i = _i + step9 ) {
 //BA.debugLineNum = 55;BA.debugLine="AddRow(Array As String(i, \"Some text\", i * 2, \"a";
_addrow(new String[]{BA.NumberToString(_i),"Some text",BA.NumberToString(_i*2),"abc"});
 }
};
 //BA.debugLineNum = 58;BA.debugLine="SetCell(0, 3, \"New value\")";
_setcell((int) (0),(int) (3),"New value");
 //BA.debugLineNum = 60;BA.debugLine="Log(\"Cell (1, 2) value = \" & GetCell(1, 2))";
anywheresoftware.b4a.keywords.Common.Log("Cell (1, 2) value = "+_getcell((int) (1),(int) (2)));
 //BA.debugLineNum = 62;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 68;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 70;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 64;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 66;BA.debugLine="End Sub";
return "";
}
public static String  _addrow(String[] _values) throws Exception{
int _lastrow = 0;
int _i = 0;
anywheresoftware.b4a.objects.LabelWrapper _l = null;
b4a.example.birth._rowcol _rc = null;
 //BA.debugLineNum = 105;BA.debugLine="Sub AddRow(Values() As String)";
 //BA.debugLineNum = 106;BA.debugLine="If Values.Length <> NumberOfColumns Then";
if (_values.length!=_numberofcolumns) { 
 //BA.debugLineNum = 107;BA.debugLine="Log(\"Wrong number of values.\")";
anywheresoftware.b4a.keywords.Common.Log("Wrong number of values.");
 //BA.debugLineNum = 108;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 110;BA.debugLine="Dim lastRow As Int";
_lastrow = 0;
 //BA.debugLineNum = 111;BA.debugLine="lastRow = NumberOfRows";
_lastrow = _numberofrows();
 //BA.debugLineNum = 112;BA.debugLine="For i = 0 To NumberOfColumns - 1";
{
final int step7 = 1;
final int limit7 = (int) (_numberofcolumns-1);
_i = (int) (0) ;
for (;_i <= limit7 ;_i = _i + step7 ) {
 //BA.debugLineNum = 113;BA.debugLine="Dim l As Label";
_l = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 114;BA.debugLine="l.Initialize(\"cell\")";
_l.Initialize(mostCurrent.activityBA,"cell");
 //BA.debugLineNum = 115;BA.debugLine="l.Text = Values(i)";
_l.setText(BA.ObjectToCharSequence(_values[_i]));
 //BA.debugLineNum = 116;BA.debugLine="l.Gravity = Alignment";
_l.setGravity(_alignment);
 //BA.debugLineNum = 117;BA.debugLine="l.TextSize = FontSize";
_l.setTextSize(_fontsize);
 //BA.debugLineNum = 118;BA.debugLine="l.TextColor = FontColor";
_l.setTextColor(_fontcolor);
 //BA.debugLineNum = 119;BA.debugLine="Dim rc As RowCol";
_rc = new b4a.example.birth._rowcol();
 //BA.debugLineNum = 120;BA.debugLine="rc.Initialize";
_rc.Initialize();
 //BA.debugLineNum = 121;BA.debugLine="rc.Col = i";
_rc.Col = _i;
 //BA.debugLineNum = 122;BA.debugLine="rc.Row = lastRow";
_rc.Row = _lastrow;
 //BA.debugLineNum = 123;BA.debugLine="l.Tag = rc";
_l.setTag((Object)(_rc));
 //BA.debugLineNum = 124;BA.debugLine="Table.AddView(l, ColumnWidth * i, RowHeight * la";
mostCurrent._table.AddView((android.view.View)(_l.getObject()),(int) (_columnwidth*_i),(int) (_rowheight*_lastrow),_columnwidth,_rowheight);
 }
};
 //BA.debugLineNum = 126;BA.debugLine="Table.Height = NumberOfRows * RowHeight";
mostCurrent._table.setHeight((int) (_numberofrows()*_rowheight));
 //BA.debugLineNum = 127;BA.debugLine="End Sub";
return "";
}
public static String  _cell_click() throws Exception{
b4a.example.birth._rowcol _rc = null;
anywheresoftware.b4a.objects.LabelWrapper _l = null;
 //BA.debugLineNum = 72;BA.debugLine="Sub Cell_Click";
 //BA.debugLineNum = 73;BA.debugLine="Dim rc As RowCol";
_rc = new b4a.example.birth._rowcol();
 //BA.debugLineNum = 74;BA.debugLine="Dim l As Label";
_l = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 75;BA.debugLine="l = Sender";
_l.setObject((android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
 //BA.debugLineNum = 76;BA.debugLine="rc = l.Tag";
_rc = (b4a.example.birth._rowcol)(_l.getTag());
 //BA.debugLineNum = 77;BA.debugLine="SelectRow(rc.Row)";
_selectrow(_rc.Row);
 //BA.debugLineNum = 78;BA.debugLine="Activity.Title = \"Cell clicked: (\" & rc.Row & \",";
mostCurrent._activity.setTitle(BA.ObjectToCharSequence("Cell clicked: ("+BA.NumberToString(_rc.Row)+", "+BA.NumberToString(_rc.Col)+")"));
 //BA.debugLineNum = 79;BA.debugLine="End Sub";
return "";
}
public static String  _clearall() throws Exception{
int _i = 0;
 //BA.debugLineNum = 154;BA.debugLine="Sub ClearAll";
 //BA.debugLineNum = 155;BA.debugLine="For i = Table.NumberOfViews -1 To 0 Step -1";
{
final int step1 = -1;
final int limit1 = (int) (0);
_i = (int) (mostCurrent._table.getNumberOfViews()-1) ;
for (;_i >= limit1 ;_i = _i + step1 ) {
 //BA.debugLineNum = 156;BA.debugLine="Table.RemoveViewAt(i)";
mostCurrent._table.RemoveViewAt(_i);
 }
};
 //BA.debugLineNum = 158;BA.debugLine="Table.Height = 0";
mostCurrent._table.setHeight((int) (0));
 //BA.debugLineNum = 159;BA.debugLine="SelectedRow = -1";
_selectedrow = (int) (-1);
 //BA.debugLineNum = 160;BA.debugLine="End Sub";
return "";
}
public static String  _getcell(int _row,int _col) throws Exception{
 //BA.debugLineNum = 151;BA.debugLine="Sub GetCell(Row As Int, Col As Int) As String";
 //BA.debugLineNum = 152;BA.debugLine="Return GetView(Row, Col).Text";
if (true) return _getview(_row,_col).getText();
 //BA.debugLineNum = 153;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.LabelWrapper  _getview(int _row,int _col) throws Exception{
anywheresoftware.b4a.objects.LabelWrapper _l = null;
 //BA.debugLineNum = 100;BA.debugLine="Sub GetView(Row As Int, Col As Int) As Label";
 //BA.debugLineNum = 101;BA.debugLine="Dim l As Label";
_l = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 102;BA.debugLine="l = Table.GetView(Row * NumberOfColumns + Col)";
_l.setObject((android.widget.TextView)(mostCurrent._table.GetView((int) (_row*_numberofcolumns+_col)).getObject()));
 //BA.debugLineNum = 103;BA.debugLine="Return l";
if (true) return _l;
 //BA.debugLineNum = 104;BA.debugLine="End Sub";
return null;
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 16;BA.debugLine="Dim SV As ScrollView";
mostCurrent._sv = new anywheresoftware.b4a.objects.ScrollViewWrapper();
 //BA.debugLineNum = 17;BA.debugLine="Dim Header As Panel";
mostCurrent._header = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 18;BA.debugLine="Dim Table As Panel";
mostCurrent._table = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 19;BA.debugLine="Dim NumberOfColumns, RowHeight, ColumnWidth As In";
_numberofcolumns = 0;
_rowheight = 0;
_columnwidth = 0;
 //BA.debugLineNum = 20;BA.debugLine="Dim HeaderColor, TableColor, FontColor, HeaderFon";
_headercolor = 0;
_tablecolor = 0;
_fontcolor = 0;
_headerfontcolor = 0;
 //BA.debugLineNum = 21;BA.debugLine="Dim FontSize As Float";
_fontsize = 0f;
 //BA.debugLineNum = 22;BA.debugLine="Type RowCol (Row As Int, Col As Int)";
;
 //BA.debugLineNum = 23;BA.debugLine="Dim Alignment As Int";
_alignment = 0;
 //BA.debugLineNum = 24;BA.debugLine="Dim SelectedRow As Int";
_selectedrow = 0;
 //BA.debugLineNum = 25;BA.debugLine="Dim SelectedRowColor As Int";
_selectedrowcolor = 0;
 //BA.debugLineNum = 28;BA.debugLine="HeaderColor = Colors.Gray";
_headercolor = anywheresoftware.b4a.keywords.Common.Colors.Gray;
 //BA.debugLineNum = 29;BA.debugLine="NumberOfColumns = 4";
_numberofcolumns = (int) (4);
 //BA.debugLineNum = 30;BA.debugLine="RowHeight = 30dip";
_rowheight = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30));
 //BA.debugLineNum = 31;BA.debugLine="TableColor = Colors.White";
_tablecolor = anywheresoftware.b4a.keywords.Common.Colors.White;
 //BA.debugLineNum = 32;BA.debugLine="FontColor = Colors.Black";
_fontcolor = anywheresoftware.b4a.keywords.Common.Colors.Black;
 //BA.debugLineNum = 33;BA.debugLine="HeaderFontColor = Colors.White";
_headerfontcolor = anywheresoftware.b4a.keywords.Common.Colors.White;
 //BA.debugLineNum = 34;BA.debugLine="FontSize = 14";
_fontsize = (float) (14);
 //BA.debugLineNum = 35;BA.debugLine="Alignment = Gravity.CENTER 'change to Gravity.LEF";
_alignment = anywheresoftware.b4a.keywords.Common.Gravity.CENTER;
 //BA.debugLineNum = 36;BA.debugLine="SelectedRowColor = Colors.Blue";
_selectedrowcolor = anywheresoftware.b4a.keywords.Common.Colors.Blue;
 //BA.debugLineNum = 38;BA.debugLine="Private Panel7 As Panel";
mostCurrent._panel7 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 39;BA.debugLine="End Sub";
return "";
}
public static String  _header_click() throws Exception{
anywheresoftware.b4a.objects.LabelWrapper _l = null;
int _col = 0;
 //BA.debugLineNum = 81;BA.debugLine="Sub Header_Click";
 //BA.debugLineNum = 82;BA.debugLine="Dim l As Label";
_l = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 83;BA.debugLine="Dim col As Int";
_col = 0;
 //BA.debugLineNum = 84;BA.debugLine="l = Sender";
_l.setObject((android.widget.TextView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
 //BA.debugLineNum = 85;BA.debugLine="col = l.Tag";
_col = (int)(BA.ObjectToNumber(_l.getTag()));
 //BA.debugLineNum = 86;BA.debugLine="Activity.Title = \"Header clicked: \" & col";
mostCurrent._activity.setTitle(BA.ObjectToCharSequence("Header clicked: "+BA.NumberToString(_col)));
 //BA.debugLineNum = 87;BA.debugLine="End Sub";
return "";
}
public static int  _numberofrows() throws Exception{
 //BA.debugLineNum = 144;BA.debugLine="Sub NumberOfRows As Int";
 //BA.debugLineNum = 145;BA.debugLine="Return Table.NumberOfViews / NumberOfColumns";
if (true) return (int) (mostCurrent._table.getNumberOfViews()/(double)_numberofcolumns);
 //BA.debugLineNum = 146;BA.debugLine="End Sub";
return 0;
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return "";
}
public static String  _selectrow(int _row) throws Exception{
int _col = 0;
 //BA.debugLineNum = 88;BA.debugLine="Sub SelectRow(Row As Int)";
 //BA.debugLineNum = 90;BA.debugLine="If SelectedRow > -1 Then";
if (_selectedrow>-1) { 
 //BA.debugLineNum = 91;BA.debugLine="For col = 0 To NumberOfColumns - 1";
{
final int step2 = 1;
final int limit2 = (int) (_numberofcolumns-1);
_col = (int) (0) ;
for (;_col <= limit2 ;_col = _col + step2 ) {
 //BA.debugLineNum = 92;BA.debugLine="GetView(SelectedRow, col).Color = Colors.Transp";
_getview(_selectedrow,_col).setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
 }
};
 };
 //BA.debugLineNum = 95;BA.debugLine="SelectedRow = Row";
_selectedrow = _row;
 //BA.debugLineNum = 96;BA.debugLine="For col = 0 To NumberOfColumns - 1";
{
final int step7 = 1;
final int limit7 = (int) (_numberofcolumns-1);
_col = (int) (0) ;
for (;_col <= limit7 ;_col = _col + step7 ) {
 //BA.debugLineNum = 97;BA.debugLine="GetView(Row, col).Color = SelectedRowColor";
_getview(_row,_col).setColor(_selectedrowcolor);
 }
};
 //BA.debugLineNum = 99;BA.debugLine="End Sub";
return "";
}
public static String  _setcell(int _row,int _col,String _value) throws Exception{
 //BA.debugLineNum = 148;BA.debugLine="Sub SetCell(Row As Int, Col As Int, Value As Strin";
 //BA.debugLineNum = 149;BA.debugLine="GetView(Row, Col).Text = Value";
_getview(_row,_col).setText(BA.ObjectToCharSequence(_value));
 //BA.debugLineNum = 150;BA.debugLine="End Sub";
return "";
}
public static String  _setheader(String[] _values) throws Exception{
int _i = 0;
anywheresoftware.b4a.objects.LabelWrapper _l = null;
 //BA.debugLineNum = 128;BA.debugLine="Sub SetHeader(Values() As String)";
 //BA.debugLineNum = 129;BA.debugLine="If Header.IsInitialized Then Return 'should only";
if (mostCurrent._header.IsInitialized()) { 
if (true) return "";};
 //BA.debugLineNum = 130;BA.debugLine="Header.Initialize(\"\")";
mostCurrent._header.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 131;BA.debugLine="For i = 0 To NumberOfColumns - 1";
{
final int step3 = 1;
final int limit3 = (int) (_numberofcolumns-1);
_i = (int) (0) ;
for (;_i <= limit3 ;_i = _i + step3 ) {
 //BA.debugLineNum = 132;BA.debugLine="Dim l As Label";
_l = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 133;BA.debugLine="l.Initialize(\"header\")";
_l.Initialize(mostCurrent.activityBA,"header");
 //BA.debugLineNum = 134;BA.debugLine="l.Text = Values(i)";
_l.setText(BA.ObjectToCharSequence(_values[_i]));
 //BA.debugLineNum = 135;BA.debugLine="l.Gravity = Gravity.CENTER";
_l.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
 //BA.debugLineNum = 136;BA.debugLine="l.TextSize = FontSize";
_l.setTextSize(_fontsize);
 //BA.debugLineNum = 137;BA.debugLine="l.Color = HeaderColor";
_l.setColor(_headercolor);
 //BA.debugLineNum = 138;BA.debugLine="l.TextColor = HeaderFontColor";
_l.setTextColor(_headerfontcolor);
 //BA.debugLineNum = 139;BA.debugLine="l.Tag = i";
_l.setTag((Object)(_i));
 //BA.debugLineNum = 140;BA.debugLine="Header.AddView(l, ColumnWidth * i, 0, ColumnWidt";
mostCurrent._header.AddView((android.view.View)(_l.getObject()),(int) (_columnwidth*_i),(int) (0),_columnwidth,_rowheight);
 }
};
 //BA.debugLineNum = 142;BA.debugLine="Activity.AddView(Header, SV.Left, SV.Top+200, SV.";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._header.getObject()),mostCurrent._sv.getLeft(),(int) (mostCurrent._sv.getTop()+200),mostCurrent._sv.getWidth(),_rowheight);
 //BA.debugLineNum = 143;BA.debugLine="End Sub";
return "";
}
}

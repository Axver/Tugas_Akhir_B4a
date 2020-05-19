package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class birth_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (birth) ","birth",3,birth.mostCurrent.activityBA,birth.mostCurrent,45);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.birth.remoteMe.runUserSub(false, "birth","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 45;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(4096);
 BA.debugLineNum = 48;BA.debugLine="Activity.LoadLayout(\"birth\")";
Debug.ShouldStop(32768);
birth.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("birth")),birth.mostCurrent.activityBA);
 BA.debugLineNum = 49;BA.debugLine="SV.Initialize(0)";
Debug.ShouldStop(65536);
birth.mostCurrent._sv.runVoidMethod ("Initialize",birth.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, 0)));
 BA.debugLineNum = 50;BA.debugLine="Table = SV.Panel";
Debug.ShouldStop(131072);
birth.mostCurrent._table = birth.mostCurrent._sv.runMethod(false,"getPanel");
 BA.debugLineNum = 51;BA.debugLine="Table.Color = TableColor";
Debug.ShouldStop(262144);
birth.mostCurrent._table.runVoidMethod ("setColor",birth._tablecolor);
 BA.debugLineNum = 53;BA.debugLine="Panel7.AddView(SV, 5%x, 10%y, 90%x, 80%y)";
Debug.ShouldStop(1048576);
birth.mostCurrent._panel7.runVoidMethod ("AddView",(Object)((birth.mostCurrent._sv.getObject())),(Object)(birth.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 5)),birth.mostCurrent.activityBA)),(Object)(birth.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 10)),birth.mostCurrent.activityBA)),(Object)(birth.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 90)),birth.mostCurrent.activityBA)),(Object)(birth.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 80)),birth.mostCurrent.activityBA)));
 BA.debugLineNum = 54;BA.debugLine="ColumnWidth = SV.Width / NumberOfColumns";
Debug.ShouldStop(2097152);
birth._columnwidth = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {birth.mostCurrent._sv.runMethod(true,"getWidth"),birth._numberofcolumns}, "/",0, 0));
 BA.debugLineNum = 55;BA.debugLine="SelectedRow = -1";
Debug.ShouldStop(4194304);
birth._selectedrow = BA.numberCast(int.class, -(double) (0 + 1));
 BA.debugLineNum = 57;BA.debugLine="SetHeader(Array As String(\"Id\", \"Reporter\", \"Type";
Debug.ShouldStop(16777216);
_setheader(RemoteObject.createNewArray("String",new int[] {4},new Object[] {BA.ObjectToString("Id"),BA.ObjectToString("Reporter"),BA.ObjectToString("Type Of Birth"),RemoteObject.createImmutable("Weight")}));
 BA.debugLineNum = 58;BA.debugLine="job2.Initialize(\"Job2\", Me)";
Debug.ShouldStop(33554432);
birth.mostCurrent._job2.runVoidMethod ("_initialize",birth.processBA,(Object)(BA.ObjectToString("Job2")),(Object)(birth.getObject()));
 BA.debugLineNum = 60;BA.debugLine="job2.PostString(domain&\"ta_v2/endpoint/birthData.";
Debug.ShouldStop(134217728);
birth.mostCurrent._job2.runVoidMethod ("_poststring",(Object)(RemoteObject.concat(birth.mostCurrent._domain,RemoteObject.createImmutable("ta_v2/endpoint/birthData.php"))),(Object)(RemoteObject.concat(RemoteObject.createImmutable("send=test"),RemoteObject.createImmutable("&data=test"))));
 BA.debugLineNum = 61;BA.debugLine="ProgressDialogShow(\"Loading...\")";
Debug.ShouldStop(268435456);
birth.mostCurrent.__c.runVoidMethod ("ProgressDialogShow",birth.mostCurrent.activityBA,(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Loading..."))));
 BA.debugLineNum = 71;BA.debugLine="End Sub";
Debug.ShouldStop(64);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (birth) ","birth",3,birth.mostCurrent.activityBA,birth.mostCurrent,80);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.birth.remoteMe.runUserSub(false, "birth","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 80;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(32768);
 BA.debugLineNum = 82;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (birth) ","birth",3,birth.mostCurrent.activityBA,birth.mostCurrent,73);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.birth.remoteMe.runUserSub(false, "birth","activity_resume");}
 BA.debugLineNum = 73;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(256);
 BA.debugLineNum = 74;BA.debugLine="ClearAll";
Debug.ShouldStop(512);
_clearall();
 BA.debugLineNum = 75;BA.debugLine="job2.Initialize(\"Job2\", Me)";
Debug.ShouldStop(1024);
birth.mostCurrent._job2.runVoidMethod ("_initialize",birth.processBA,(Object)(BA.ObjectToString("Job2")),(Object)(birth.getObject()));
 BA.debugLineNum = 76;BA.debugLine="job2.PostString(domain&\"ta_v2/endpoint/birthData.";
Debug.ShouldStop(2048);
birth.mostCurrent._job2.runVoidMethod ("_poststring",(Object)(RemoteObject.concat(birth.mostCurrent._domain,RemoteObject.createImmutable("ta_v2/endpoint/birthData.php"))),(Object)(RemoteObject.concat(RemoteObject.createImmutable("send=test"),RemoteObject.createImmutable("&data=test"))));
 BA.debugLineNum = 77;BA.debugLine="ProgressDialogShow(\"Loading...\")";
Debug.ShouldStop(4096);
birth.mostCurrent.__c.runVoidMethod ("ProgressDialogShow",birth.mostCurrent.activityBA,(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Loading..."))));
 BA.debugLineNum = 78;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _addrow(RemoteObject _values) throws Exception{
try {
		Debug.PushSubsStack("AddRow (birth) ","birth",3,birth.mostCurrent.activityBA,birth.mostCurrent,117);
if (RapidSub.canDelegate("addrow")) { return b4a.example.birth.remoteMe.runUserSub(false, "birth","addrow", _values);}
RemoteObject _lastrow = RemoteObject.createImmutable(0);
int _i = 0;
RemoteObject _l = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _rc = RemoteObject.declareNull("b4a.example.birth._rowcol");
Debug.locals.put("Values", _values);
 BA.debugLineNum = 117;BA.debugLine="Sub AddRow(Values() As String)";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 118;BA.debugLine="If Values.Length <> NumberOfColumns Then";
Debug.ShouldStop(2097152);
if (RemoteObject.solveBoolean("!",_values.getField(true,"length"),BA.numberCast(double.class, birth._numberofcolumns))) { 
 BA.debugLineNum = 119;BA.debugLine="Log(\"Wrong number of values.\")";
Debug.ShouldStop(4194304);
birth.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.createImmutable("Wrong number of values.")));
 BA.debugLineNum = 120;BA.debugLine="Return";
Debug.ShouldStop(8388608);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 122;BA.debugLine="Dim lastRow As Int";
Debug.ShouldStop(33554432);
_lastrow = RemoteObject.createImmutable(0);Debug.locals.put("lastRow", _lastrow);
 BA.debugLineNum = 123;BA.debugLine="lastRow = NumberOfRows";
Debug.ShouldStop(67108864);
_lastrow = _numberofrows();Debug.locals.put("lastRow", _lastrow);
 BA.debugLineNum = 124;BA.debugLine="For i = 0 To NumberOfColumns - 1";
Debug.ShouldStop(134217728);
{
final int step7 = 1;
final int limit7 = RemoteObject.solve(new RemoteObject[] {birth._numberofcolumns,RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step7 > 0 && _i <= limit7) || (step7 < 0 && _i >= limit7) ;_i = ((int)(0 + _i + step7))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 125;BA.debugLine="Dim l As Label";
Debug.ShouldStop(268435456);
_l = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("l", _l);
 BA.debugLineNum = 126;BA.debugLine="l.Initialize(\"cell\")";
Debug.ShouldStop(536870912);
_l.runVoidMethod ("Initialize",birth.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("cell")));
 BA.debugLineNum = 127;BA.debugLine="l.Text = Values(i)";
Debug.ShouldStop(1073741824);
_l.runMethod(true,"setText",BA.ObjectToCharSequence(_values.getArrayElement(true,BA.numberCast(int.class, _i))));
 BA.debugLineNum = 128;BA.debugLine="l.Gravity = Alignment";
Debug.ShouldStop(-2147483648);
_l.runMethod(true,"setGravity",birth._alignment);
 BA.debugLineNum = 129;BA.debugLine="l.TextSize = FontSize";
Debug.ShouldStop(1);
_l.runMethod(true,"setTextSize",birth._fontsize);
 BA.debugLineNum = 130;BA.debugLine="l.TextColor = FontColor";
Debug.ShouldStop(2);
_l.runMethod(true,"setTextColor",birth._fontcolor);
 BA.debugLineNum = 131;BA.debugLine="Dim rc As RowCol";
Debug.ShouldStop(4);
_rc = RemoteObject.createNew ("b4a.example.birth._rowcol");Debug.locals.put("rc", _rc);
 BA.debugLineNum = 132;BA.debugLine="rc.Initialize";
Debug.ShouldStop(8);
_rc.runVoidMethod ("Initialize");
 BA.debugLineNum = 133;BA.debugLine="rc.Col = i";
Debug.ShouldStop(16);
_rc.setField ("Col",BA.numberCast(int.class, _i));
 BA.debugLineNum = 134;BA.debugLine="rc.Row = lastRow";
Debug.ShouldStop(32);
_rc.setField ("Row",_lastrow);
 BA.debugLineNum = 135;BA.debugLine="l.Tag = rc";
Debug.ShouldStop(64);
_l.runMethod(false,"setTag",(_rc));
 BA.debugLineNum = 136;BA.debugLine="Table.AddView(l, ColumnWidth * i, RowHeight * la";
Debug.ShouldStop(128);
birth.mostCurrent._table.runVoidMethod ("AddView",(Object)((_l.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {birth._columnwidth,RemoteObject.createImmutable(_i)}, "*",0, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {birth._rowheight,_lastrow}, "*",0, 1)),(Object)(birth._columnwidth),(Object)(birth._rowheight));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 138;BA.debugLine="Table.Height = NumberOfRows * RowHeight";
Debug.ShouldStop(512);
birth.mostCurrent._table.runMethod(true,"setHeight",RemoteObject.solve(new RemoteObject[] {_numberofrows(),birth._rowheight}, "*",0, 1));
 BA.debugLineNum = 139;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _cell_click() throws Exception{
try {
		Debug.PushSubsStack("Cell_Click (birth) ","birth",3,birth.mostCurrent.activityBA,birth.mostCurrent,84);
if (RapidSub.canDelegate("cell_click")) { return b4a.example.birth.remoteMe.runUserSub(false, "birth","cell_click");}
RemoteObject _rc = RemoteObject.declareNull("b4a.example.birth._rowcol");
RemoteObject _l = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
 BA.debugLineNum = 84;BA.debugLine="Sub Cell_Click";
Debug.ShouldStop(524288);
 BA.debugLineNum = 85;BA.debugLine="Dim rc As RowCol";
Debug.ShouldStop(1048576);
_rc = RemoteObject.createNew ("b4a.example.birth._rowcol");Debug.locals.put("rc", _rc);
 BA.debugLineNum = 86;BA.debugLine="Dim l As Label";
Debug.ShouldStop(2097152);
_l = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("l", _l);
 BA.debugLineNum = 87;BA.debugLine="l = Sender";
Debug.ShouldStop(4194304);
_l.setObject(birth.mostCurrent.__c.runMethod(false,"Sender",birth.mostCurrent.activityBA));
 BA.debugLineNum = 88;BA.debugLine="rc = l.Tag";
Debug.ShouldStop(8388608);
_rc = (_l.runMethod(false,"getTag"));Debug.locals.put("rc", _rc);
 BA.debugLineNum = 89;BA.debugLine="SelectRow(rc.Row)";
Debug.ShouldStop(16777216);
_selectrow(_rc.getField(true,"Row"));
 BA.debugLineNum = 90;BA.debugLine="Activity.Title = \"Cell clicked: (\" & rc.Row & \",";
Debug.ShouldStop(33554432);
birth.mostCurrent._activity.runMethod(false,"setTitle",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Cell clicked: ("),_rc.getField(true,"Row"),RemoteObject.createImmutable(", "),_rc.getField(true,"Col"),RemoteObject.createImmutable(")"))));
 BA.debugLineNum = 91;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _clearall() throws Exception{
try {
		Debug.PushSubsStack("ClearAll (birth) ","birth",3,birth.mostCurrent.activityBA,birth.mostCurrent,166);
if (RapidSub.canDelegate("clearall")) { return b4a.example.birth.remoteMe.runUserSub(false, "birth","clearall");}
int _i = 0;
 BA.debugLineNum = 166;BA.debugLine="Sub ClearAll";
Debug.ShouldStop(32);
 BA.debugLineNum = 167;BA.debugLine="For i = Table.NumberOfViews -1 To 0 Step -1";
Debug.ShouldStop(64);
{
final int step1 = -1;
final int limit1 = 0;
_i = RemoteObject.solve(new RemoteObject[] {birth.mostCurrent._table.runMethod(true,"getNumberOfViews"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue() ;
for (;(step1 > 0 && _i <= limit1) || (step1 < 0 && _i >= limit1) ;_i = ((int)(0 + _i + step1))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 168;BA.debugLine="Table.RemoveViewAt(i)";
Debug.ShouldStop(128);
birth.mostCurrent._table.runVoidMethod ("RemoveViewAt",(Object)(BA.numberCast(int.class, _i)));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 170;BA.debugLine="Table.Height = 0";
Debug.ShouldStop(512);
birth.mostCurrent._table.runMethod(true,"setHeight",BA.numberCast(int.class, 0));
 BA.debugLineNum = 171;BA.debugLine="SelectedRow = -1";
Debug.ShouldStop(1024);
birth._selectedrow = BA.numberCast(int.class, -(double) (0 + 1));
 BA.debugLineNum = 172;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getcell(RemoteObject _row,RemoteObject _col) throws Exception{
try {
		Debug.PushSubsStack("GetCell (birth) ","birth",3,birth.mostCurrent.activityBA,birth.mostCurrent,163);
if (RapidSub.canDelegate("getcell")) { return b4a.example.birth.remoteMe.runUserSub(false, "birth","getcell", _row, _col);}
Debug.locals.put("Row", _row);
Debug.locals.put("Col", _col);
 BA.debugLineNum = 163;BA.debugLine="Sub GetCell(Row As Int, Col As Int) As String";
Debug.ShouldStop(4);
 BA.debugLineNum = 164;BA.debugLine="Return GetView(Row, Col).Text";
Debug.ShouldStop(8);
if (true) return _getview(_row,_col).runMethod(true,"getText");
 BA.debugLineNum = 165;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getview(RemoteObject _row,RemoteObject _col) throws Exception{
try {
		Debug.PushSubsStack("GetView (birth) ","birth",3,birth.mostCurrent.activityBA,birth.mostCurrent,112);
if (RapidSub.canDelegate("getview")) { return b4a.example.birth.remoteMe.runUserSub(false, "birth","getview", _row, _col);}
RemoteObject _l = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
Debug.locals.put("Row", _row);
Debug.locals.put("Col", _col);
 BA.debugLineNum = 112;BA.debugLine="Sub GetView(Row As Int, Col As Int) As Label";
Debug.ShouldStop(32768);
 BA.debugLineNum = 113;BA.debugLine="Dim l As Label";
Debug.ShouldStop(65536);
_l = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("l", _l);
 BA.debugLineNum = 114;BA.debugLine="l = Table.GetView(Row * NumberOfColumns + Col)";
Debug.ShouldStop(131072);
_l.setObject(birth.mostCurrent._table.runMethod(false,"GetView",(Object)(RemoteObject.solve(new RemoteObject[] {_row,birth._numberofcolumns,_col}, "*+",1, 1))).getObject());
 BA.debugLineNum = 115;BA.debugLine="Return l";
Debug.ShouldStop(262144);
if (true) return _l;
 BA.debugLineNum = 116;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 13;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 16;BA.debugLine="Dim domain As String";
birth.mostCurrent._domain = RemoteObject.createImmutable("");
 //BA.debugLineNum = 17;BA.debugLine="Dim job2 As HttpJob";
birth.mostCurrent._job2 = RemoteObject.createNew ("anywheresoftware.b4a.samples.httputils2.httpjob");
 //BA.debugLineNum = 18;BA.debugLine="domain=\"https://b9312448.ngrok.io/\"";
birth.mostCurrent._domain = BA.ObjectToString("https://b9312448.ngrok.io/");
 //BA.debugLineNum = 20;BA.debugLine="Dim SV As ScrollView";
birth.mostCurrent._sv = RemoteObject.createNew ("anywheresoftware.b4a.objects.ScrollViewWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Dim Header As Panel";
birth.mostCurrent._header = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 22;BA.debugLine="Dim Table As Panel";
birth.mostCurrent._table = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 23;BA.debugLine="Dim NumberOfColumns, RowHeight, ColumnWidth As In";
birth._numberofcolumns = RemoteObject.createImmutable(0);
birth._rowheight = RemoteObject.createImmutable(0);
birth._columnwidth = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 24;BA.debugLine="Dim HeaderColor, TableColor, FontColor, HeaderFon";
birth._headercolor = RemoteObject.createImmutable(0);
birth._tablecolor = RemoteObject.createImmutable(0);
birth._fontcolor = RemoteObject.createImmutable(0);
birth._headerfontcolor = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 25;BA.debugLine="Dim FontSize As Float";
birth._fontsize = RemoteObject.createImmutable(0f);
 //BA.debugLineNum = 26;BA.debugLine="Type RowCol (Row As Int, Col As Int)";
;
 //BA.debugLineNum = 27;BA.debugLine="Dim Alignment As Int";
birth._alignment = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 28;BA.debugLine="Dim SelectedRow As Int";
birth._selectedrow = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 29;BA.debugLine="Dim SelectedRowColor As Int";
birth._selectedrowcolor = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 32;BA.debugLine="HeaderColor = Colors.Red";
birth._headercolor = birth.mostCurrent.__c.getField(false,"Colors").getField(true,"Red");
 //BA.debugLineNum = 33;BA.debugLine="NumberOfColumns = 4";
birth._numberofcolumns = BA.numberCast(int.class, 4);
 //BA.debugLineNum = 34;BA.debugLine="RowHeight = 30dip";
birth._rowheight = birth.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30)));
 //BA.debugLineNum = 35;BA.debugLine="TableColor = Colors.White";
birth._tablecolor = birth.mostCurrent.__c.getField(false,"Colors").getField(true,"White");
 //BA.debugLineNum = 36;BA.debugLine="FontColor = Colors.Black";
birth._fontcolor = birth.mostCurrent.__c.getField(false,"Colors").getField(true,"Black");
 //BA.debugLineNum = 37;BA.debugLine="HeaderFontColor = Colors.Black";
birth._headerfontcolor = birth.mostCurrent.__c.getField(false,"Colors").getField(true,"Black");
 //BA.debugLineNum = 38;BA.debugLine="FontSize = 14";
birth._fontsize = BA.numberCast(float.class, 14);
 //BA.debugLineNum = 39;BA.debugLine="Alignment = Gravity.CENTER 'change to Gravity.LEF";
birth._alignment = birth.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER");
 //BA.debugLineNum = 40;BA.debugLine="SelectedRowColor = Colors.Blue";
birth._selectedrowcolor = birth.mostCurrent.__c.getField(false,"Colors").getField(true,"Blue");
 //BA.debugLineNum = 42;BA.debugLine="Private Panel7 As Panel";
birth.mostCurrent._panel7 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 43;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _header_click() throws Exception{
try {
		Debug.PushSubsStack("Header_Click (birth) ","birth",3,birth.mostCurrent.activityBA,birth.mostCurrent,93);
if (RapidSub.canDelegate("header_click")) { return b4a.example.birth.remoteMe.runUserSub(false, "birth","header_click");}
RemoteObject _l = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _col = RemoteObject.createImmutable(0);
 BA.debugLineNum = 93;BA.debugLine="Sub Header_Click";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 94;BA.debugLine="Dim l As Label";
Debug.ShouldStop(536870912);
_l = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("l", _l);
 BA.debugLineNum = 95;BA.debugLine="Dim col As Int";
Debug.ShouldStop(1073741824);
_col = RemoteObject.createImmutable(0);Debug.locals.put("col", _col);
 BA.debugLineNum = 96;BA.debugLine="l = Sender";
Debug.ShouldStop(-2147483648);
_l.setObject(birth.mostCurrent.__c.runMethod(false,"Sender",birth.mostCurrent.activityBA));
 BA.debugLineNum = 97;BA.debugLine="col = l.Tag";
Debug.ShouldStop(1);
_col = BA.numberCast(int.class, _l.runMethod(false,"getTag"));Debug.locals.put("col", _col);
 BA.debugLineNum = 98;BA.debugLine="Activity.Title = \"Header clicked: \" & col";
Debug.ShouldStop(2);
birth.mostCurrent._activity.runMethod(false,"setTitle",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Header clicked: "),_col)));
 BA.debugLineNum = 99;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _jobdone(RemoteObject _job) throws Exception{
try {
		Debug.PushSubsStack("JobDone (birth) ","birth",3,birth.mostCurrent.activityBA,birth.mostCurrent,174);
if (RapidSub.canDelegate("jobdone")) { return b4a.example.birth.remoteMe.runUserSub(false, "birth","jobdone", _job);}
RemoteObject _parser = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser");
RemoteObject _root = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _features = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _colfeatures = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _properties = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _citizen_id = RemoteObject.createImmutable("");
RemoteObject _no_kelahiran = RemoteObject.createImmutable("");
RemoteObject _type_of_birth = RemoteObject.createImmutable("");
RemoteObject _weight = RemoteObject.createImmutable("");
RemoteObject _nik_pelapor = RemoteObject.createImmutable("");
Debug.locals.put("Job", _job);
 BA.debugLineNum = 174;BA.debugLine="Sub JobDone (Job As HttpJob)";
Debug.ShouldStop(8192);
 BA.debugLineNum = 176;BA.debugLine="Log(\"JobName = \" & Job.JobName & \", Success = \" &";
Debug.ShouldStop(32768);
birth.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("JobName = "),_job.getField(true,"_jobname"),RemoteObject.createImmutable(", Success = "),_job.getField(true,"_success"))));
 BA.debugLineNum = 177;BA.debugLine="If Job.Success = True Then";
Debug.ShouldStop(65536);
if (RemoteObject.solveBoolean("=",_job.getField(true,"_success"),birth.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 178;BA.debugLine="ClearAll";
Debug.ShouldStop(131072);
_clearall();
 BA.debugLineNum = 180;BA.debugLine="Select Job.JobName";
Debug.ShouldStop(524288);
switch (BA.switchObjectToInt(_job.getField(true,"_jobname"),BA.ObjectToString("Job2"))) {
case 0: {
 BA.debugLineNum = 182;BA.debugLine="Dim parser As JSONParser";
Debug.ShouldStop(2097152);
_parser = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("parser", _parser);
 BA.debugLineNum = 183;BA.debugLine="parser.Initialize(Job.GetString)";
Debug.ShouldStop(4194304);
_parser.runVoidMethod ("Initialize",(Object)(_job.runMethod(true,"_getstring")));
 BA.debugLineNum = 184;BA.debugLine="Dim root As Map = parser.NextObject";
Debug.ShouldStop(8388608);
_root = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_root = _parser.runMethod(false,"NextObject");Debug.locals.put("root", _root);Debug.locals.put("root", _root);
 BA.debugLineNum = 185;BA.debugLine="Dim features As List = root.Get(\"features\")";
Debug.ShouldStop(16777216);
_features = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_features.setObject(_root.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("features")))));Debug.locals.put("features", _features);
 BA.debugLineNum = 187;BA.debugLine="For Each colfeatures As Map In features";
Debug.ShouldStop(67108864);
_colfeatures = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
{
final RemoteObject group10 = _features;
final int groupLen10 = group10.runMethod(true,"getSize").<Integer>get()
;int index10 = 0;
;
for (; index10 < groupLen10;index10++){
_colfeatures.setObject(group10.runMethod(false,"Get",index10));
Debug.locals.put("colfeatures", _colfeatures);
 BA.debugLineNum = 188;BA.debugLine="Dim properties As Map = colfeatures.Get(\"prop";
Debug.ShouldStop(134217728);
_properties = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_properties.setObject(_colfeatures.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("properties")))));Debug.locals.put("properties", _properties);
 BA.debugLineNum = 189;BA.debugLine="Dim citizen_id As String = properties.Get(\"ci";
Debug.ShouldStop(268435456);
_citizen_id = BA.ObjectToString(_properties.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("citizen_id")))));Debug.locals.put("citizen_id", _citizen_id);Debug.locals.put("citizen_id", _citizen_id);
 BA.debugLineNum = 190;BA.debugLine="Dim no_kelahiran As String = properties.Get(\"";
Debug.ShouldStop(536870912);
_no_kelahiran = BA.ObjectToString(_properties.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("no_kelahiran")))));Debug.locals.put("no_kelahiran", _no_kelahiran);Debug.locals.put("no_kelahiran", _no_kelahiran);
 BA.debugLineNum = 191;BA.debugLine="Dim type_of_birth As String = properties.Get(";
Debug.ShouldStop(1073741824);
_type_of_birth = BA.ObjectToString(_properties.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("type_of_birth")))));Debug.locals.put("type_of_birth", _type_of_birth);Debug.locals.put("type_of_birth", _type_of_birth);
 BA.debugLineNum = 192;BA.debugLine="Dim weight As String = properties.Get(\"weight";
Debug.ShouldStop(-2147483648);
_weight = BA.ObjectToString(_properties.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("weight")))));Debug.locals.put("weight", _weight);Debug.locals.put("weight", _weight);
 BA.debugLineNum = 193;BA.debugLine="Dim nik_pelapor As String = properties.Get(\"n";
Debug.ShouldStop(1);
_nik_pelapor = BA.ObjectToString(_properties.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("nik_pelapor")))));Debug.locals.put("nik_pelapor", _nik_pelapor);Debug.locals.put("nik_pelapor", _nik_pelapor);
 BA.debugLineNum = 194;BA.debugLine="AddRow(Array As String(citizen_id, nik_pelapo";
Debug.ShouldStop(2);
_addrow(RemoteObject.createNewArray("String",new int[] {4},new Object[] {_citizen_id,_nik_pelapor,_type_of_birth,_weight}));
 }
}Debug.locals.put("colfeatures", _colfeatures);
;
 BA.debugLineNum = 199;BA.debugLine="ProgressDialogHide";
Debug.ShouldStop(64);
birth.mostCurrent.__c.runVoidMethod ("ProgressDialogHide");
 break; }
}
;
 }else {
 BA.debugLineNum = 204;BA.debugLine="Log(\"Error: \" & Job.ErrorMessage)";
Debug.ShouldStop(2048);
birth.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("Error: "),_job.getField(true,"_errormessage"))));
 BA.debugLineNum = 205;BA.debugLine="ToastMessageShow(\"Error: \" & Job.ErrorMessage, T";
Debug.ShouldStop(4096);
birth.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Error: "),_job.getField(true,"_errormessage")))),(Object)(birth.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 207;BA.debugLine="Job.Release";
Debug.ShouldStop(16384);
_job.runVoidMethod ("_release");
 BA.debugLineNum = 208;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _label3_click() throws Exception{
try {
		Debug.PushSubsStack("Label3_Click (birth) ","birth",3,birth.mostCurrent.activityBA,birth.mostCurrent,215);
if (RapidSub.canDelegate("label3_click")) { return b4a.example.birth.remoteMe.runUserSub(false, "birth","label3_click");}
 BA.debugLineNum = 215;BA.debugLine="Sub Label3_Click";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 216;BA.debugLine="StartActivity(\"dashboard\")";
Debug.ShouldStop(8388608);
birth.mostCurrent.__c.runVoidMethod ("StartActivity",birth.processBA,(Object)((RemoteObject.createImmutable("dashboard"))));
 BA.debugLineNum = 217;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _label7_click() throws Exception{
try {
		Debug.PushSubsStack("Label7_Click (birth) ","birth",3,birth.mostCurrent.activityBA,birth.mostCurrent,211);
if (RapidSub.canDelegate("label7_click")) { return b4a.example.birth.remoteMe.runUserSub(false, "birth","label7_click");}
 BA.debugLineNum = 211;BA.debugLine="Sub Label7_Click";
Debug.ShouldStop(262144);
 BA.debugLineNum = 212;BA.debugLine="StartActivity(\"add_birth\")";
Debug.ShouldStop(524288);
birth.mostCurrent.__c.runVoidMethod ("StartActivity",birth.processBA,(Object)((RemoteObject.createImmutable("add_birth"))));
 BA.debugLineNum = 213;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _numberofrows() throws Exception{
try {
		Debug.PushSubsStack("NumberOfRows (birth) ","birth",3,birth.mostCurrent.activityBA,birth.mostCurrent,156);
if (RapidSub.canDelegate("numberofrows")) { return b4a.example.birth.remoteMe.runUserSub(false, "birth","numberofrows");}
 BA.debugLineNum = 156;BA.debugLine="Sub NumberOfRows As Int";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 157;BA.debugLine="Return Table.NumberOfViews / NumberOfColumns";
Debug.ShouldStop(268435456);
if (true) return BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {birth.mostCurrent._table.runMethod(true,"getNumberOfViews"),birth._numberofcolumns}, "/",0, 0));
 BA.debugLineNum = 158;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable(0);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 7;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 11;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _selectrow(RemoteObject _row) throws Exception{
try {
		Debug.PushSubsStack("SelectRow (birth) ","birth",3,birth.mostCurrent.activityBA,birth.mostCurrent,100);
if (RapidSub.canDelegate("selectrow")) { return b4a.example.birth.remoteMe.runUserSub(false, "birth","selectrow", _row);}
int _col = 0;
Debug.locals.put("Row", _row);
 BA.debugLineNum = 100;BA.debugLine="Sub SelectRow(Row As Int)";
Debug.ShouldStop(8);
 BA.debugLineNum = 102;BA.debugLine="If SelectedRow > -1 Then";
Debug.ShouldStop(32);
if (RemoteObject.solveBoolean(">",birth._selectedrow,BA.numberCast(double.class, -(double) (0 + 1)))) { 
 BA.debugLineNum = 103;BA.debugLine="For col = 0 To NumberOfColumns - 1";
Debug.ShouldStop(64);
{
final int step2 = 1;
final int limit2 = RemoteObject.solve(new RemoteObject[] {birth._numberofcolumns,RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_col = 0 ;
for (;(step2 > 0 && _col <= limit2) || (step2 < 0 && _col >= limit2) ;_col = ((int)(0 + _col + step2))  ) {
Debug.locals.put("col", _col);
 BA.debugLineNum = 104;BA.debugLine="GetView(SelectedRow, col).Color = Colors.Transp";
Debug.ShouldStop(128);
_getview(birth._selectedrow,BA.numberCast(int.class, _col)).runVoidMethod ("setColor",birth.mostCurrent.__c.getField(false,"Colors").getField(true,"Transparent"));
 }
}Debug.locals.put("col", _col);
;
 };
 BA.debugLineNum = 107;BA.debugLine="SelectedRow = Row";
Debug.ShouldStop(1024);
birth._selectedrow = _row;
 BA.debugLineNum = 108;BA.debugLine="For col = 0 To NumberOfColumns - 1";
Debug.ShouldStop(2048);
{
final int step7 = 1;
final int limit7 = RemoteObject.solve(new RemoteObject[] {birth._numberofcolumns,RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_col = 0 ;
for (;(step7 > 0 && _col <= limit7) || (step7 < 0 && _col >= limit7) ;_col = ((int)(0 + _col + step7))  ) {
Debug.locals.put("col", _col);
 BA.debugLineNum = 109;BA.debugLine="GetView(Row, col).Color = SelectedRowColor";
Debug.ShouldStop(4096);
_getview(_row,BA.numberCast(int.class, _col)).runVoidMethod ("setColor",birth._selectedrowcolor);
 }
}Debug.locals.put("col", _col);
;
 BA.debugLineNum = 111;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _setcell(RemoteObject _row,RemoteObject _col,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("SetCell (birth) ","birth",3,birth.mostCurrent.activityBA,birth.mostCurrent,160);
if (RapidSub.canDelegate("setcell")) { return b4a.example.birth.remoteMe.runUserSub(false, "birth","setcell", _row, _col, _value);}
Debug.locals.put("Row", _row);
Debug.locals.put("Col", _col);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 160;BA.debugLine="Sub SetCell(Row As Int, Col As Int, Value As Strin";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 161;BA.debugLine="GetView(Row, Col).Text = Value";
Debug.ShouldStop(1);
_getview(_row,_col).runMethod(true,"setText",BA.ObjectToCharSequence(_value));
 BA.debugLineNum = 162;BA.debugLine="End Sub";
Debug.ShouldStop(2);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _setheader(RemoteObject _values) throws Exception{
try {
		Debug.PushSubsStack("SetHeader (birth) ","birth",3,birth.mostCurrent.activityBA,birth.mostCurrent,140);
if (RapidSub.canDelegate("setheader")) { return b4a.example.birth.remoteMe.runUserSub(false, "birth","setheader", _values);}
int _i = 0;
RemoteObject _l = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
Debug.locals.put("Values", _values);
 BA.debugLineNum = 140;BA.debugLine="Sub SetHeader(Values() As String)";
Debug.ShouldStop(2048);
 BA.debugLineNum = 141;BA.debugLine="If Header.IsInitialized Then Return 'should only";
Debug.ShouldStop(4096);
if (birth.mostCurrent._header.runMethod(true,"IsInitialized").<Boolean>get().booleanValue()) { 
if (true) return RemoteObject.createImmutable("");};
 BA.debugLineNum = 142;BA.debugLine="Header.Initialize(\"\")";
Debug.ShouldStop(8192);
birth.mostCurrent._header.runVoidMethod ("Initialize",birth.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 143;BA.debugLine="For i = 0 To NumberOfColumns - 1";
Debug.ShouldStop(16384);
{
final int step3 = 1;
final int limit3 = RemoteObject.solve(new RemoteObject[] {birth._numberofcolumns,RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step3 > 0 && _i <= limit3) || (step3 < 0 && _i >= limit3) ;_i = ((int)(0 + _i + step3))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 144;BA.debugLine="Dim l As Label";
Debug.ShouldStop(32768);
_l = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("l", _l);
 BA.debugLineNum = 145;BA.debugLine="l.Initialize(\"header\")";
Debug.ShouldStop(65536);
_l.runVoidMethod ("Initialize",birth.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("header")));
 BA.debugLineNum = 146;BA.debugLine="l.Text = Values(i)";
Debug.ShouldStop(131072);
_l.runMethod(true,"setText",BA.ObjectToCharSequence(_values.getArrayElement(true,BA.numberCast(int.class, _i))));
 BA.debugLineNum = 147;BA.debugLine="l.Gravity = Gravity.CENTER";
Debug.ShouldStop(262144);
_l.runMethod(true,"setGravity",birth.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 148;BA.debugLine="l.TextSize = FontSize";
Debug.ShouldStop(524288);
_l.runMethod(true,"setTextSize",birth._fontsize);
 BA.debugLineNum = 149;BA.debugLine="l.Color = HeaderColor";
Debug.ShouldStop(1048576);
_l.runVoidMethod ("setColor",birth._headercolor);
 BA.debugLineNum = 150;BA.debugLine="l.TextColor = HeaderFontColor";
Debug.ShouldStop(2097152);
_l.runMethod(true,"setTextColor",birth._headerfontcolor);
 BA.debugLineNum = 151;BA.debugLine="l.Tag = i";
Debug.ShouldStop(4194304);
_l.runMethod(false,"setTag",RemoteObject.createImmutable((_i)));
 BA.debugLineNum = 152;BA.debugLine="Header.AddView(l, ColumnWidth * i, 0, ColumnWidt";
Debug.ShouldStop(8388608);
birth.mostCurrent._header.runVoidMethod ("AddView",(Object)((_l.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {birth._columnwidth,RemoteObject.createImmutable(_i)}, "*",0, 1)),(Object)(BA.numberCast(int.class, 0)),(Object)(birth._columnwidth),(Object)(birth._rowheight));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 154;BA.debugLine="Activity.AddView(Header, SV.Left, SV.Top+200, SV.";
Debug.ShouldStop(33554432);
birth.mostCurrent._activity.runVoidMethod ("AddView",(Object)((birth.mostCurrent._header.getObject())),(Object)(birth.mostCurrent._sv.runMethod(true,"getLeft")),(Object)(RemoteObject.solve(new RemoteObject[] {birth.mostCurrent._sv.runMethod(true,"getTop"),RemoteObject.createImmutable(200)}, "+",1, 1)),(Object)(birth.mostCurrent._sv.runMethod(true,"getWidth")),(Object)(birth._rowheight));
 BA.debugLineNum = 155;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}
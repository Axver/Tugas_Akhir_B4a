package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class outcome_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (outcome) ","outcome",7,outcome.mostCurrent.activityBA,outcome.mostCurrent,45);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.outcome.remoteMe.runUserSub(false, "outcome","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 45;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(4096);
 BA.debugLineNum = 48;BA.debugLine="Activity.LoadLayout(\"outcome\")";
Debug.ShouldStop(32768);
outcome.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("outcome")),outcome.mostCurrent.activityBA);
 BA.debugLineNum = 49;BA.debugLine="SV.Initialize(0)";
Debug.ShouldStop(65536);
outcome.mostCurrent._sv.runVoidMethod ("Initialize",outcome.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, 0)));
 BA.debugLineNum = 50;BA.debugLine="Table = SV.Panel";
Debug.ShouldStop(131072);
outcome.mostCurrent._table = outcome.mostCurrent._sv.runMethod(false,"getPanel");
 BA.debugLineNum = 51;BA.debugLine="Table.Color = TableColor";
Debug.ShouldStop(262144);
outcome.mostCurrent._table.runVoidMethod ("setColor",outcome._tablecolor);
 BA.debugLineNum = 53;BA.debugLine="Panel7.AddView(SV, 5%x, 10%y, 90%x, 80%y)";
Debug.ShouldStop(1048576);
outcome.mostCurrent._panel7.runVoidMethod ("AddView",(Object)((outcome.mostCurrent._sv.getObject())),(Object)(outcome.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 5)),outcome.mostCurrent.activityBA)),(Object)(outcome.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 10)),outcome.mostCurrent.activityBA)),(Object)(outcome.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 90)),outcome.mostCurrent.activityBA)),(Object)(outcome.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 80)),outcome.mostCurrent.activityBA)));
 BA.debugLineNum = 54;BA.debugLine="ColumnWidth = SV.Width / NumberOfColumns";
Debug.ShouldStop(2097152);
outcome._columnwidth = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {outcome.mostCurrent._sv.runMethod(true,"getWidth"),outcome._numberofcolumns}, "/",0, 0));
 BA.debugLineNum = 55;BA.debugLine="SelectedRow = -1";
Debug.ShouldStop(4194304);
outcome._selectedrow = BA.numberCast(int.class, -(double) (0 + 1));
 BA.debugLineNum = 57;BA.debugLine="SetHeader(Array As String(\"Id\", \"Citizen\", \"From\"";
Debug.ShouldStop(16777216);
_setheader(RemoteObject.createNewArray("String",new int[] {4},new Object[] {BA.ObjectToString("Id"),BA.ObjectToString("Citizen"),BA.ObjectToString("From"),RemoteObject.createImmutable("Destination")}));
 BA.debugLineNum = 58;BA.debugLine="job2.Initialize(\"Job2\", Me)";
Debug.ShouldStop(33554432);
outcome.mostCurrent._job2.runVoidMethod ("_initialize",outcome.processBA,(Object)(BA.ObjectToString("Job2")),(Object)(outcome.getObject()));
 BA.debugLineNum = 60;BA.debugLine="job2.PostString(domain&\"ta_v2/endpoint/outcome.ph";
Debug.ShouldStop(134217728);
outcome.mostCurrent._job2.runVoidMethod ("_poststring",(Object)(RemoteObject.concat(outcome.mostCurrent._domain,RemoteObject.createImmutable("ta_v2/endpoint/outcome.php"))),(Object)(RemoteObject.concat(RemoteObject.createImmutable("send=test"),RemoteObject.createImmutable("&data=test"))));
 BA.debugLineNum = 61;BA.debugLine="ProgressDialogShow(\"Loading...\")";
Debug.ShouldStop(268435456);
outcome.mostCurrent.__c.runVoidMethod ("ProgressDialogShow",outcome.mostCurrent.activityBA,(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Loading..."))));
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
		Debug.PushSubsStack("Activity_Pause (outcome) ","outcome",7,outcome.mostCurrent.activityBA,outcome.mostCurrent,80);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.outcome.remoteMe.runUserSub(false, "outcome","activity_pause", _userclosed);}
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
		Debug.PushSubsStack("Activity_Resume (outcome) ","outcome",7,outcome.mostCurrent.activityBA,outcome.mostCurrent,73);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.outcome.remoteMe.runUserSub(false, "outcome","activity_resume");}
 BA.debugLineNum = 73;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(256);
 BA.debugLineNum = 74;BA.debugLine="ClearAll";
Debug.ShouldStop(512);
_clearall();
 BA.debugLineNum = 75;BA.debugLine="job2.Initialize(\"Job2\", Me)";
Debug.ShouldStop(1024);
outcome.mostCurrent._job2.runVoidMethod ("_initialize",outcome.processBA,(Object)(BA.ObjectToString("Job2")),(Object)(outcome.getObject()));
 BA.debugLineNum = 76;BA.debugLine="job2.PostString(domain&\"ta_v2/endpoint/outcome.ph";
Debug.ShouldStop(2048);
outcome.mostCurrent._job2.runVoidMethod ("_poststring",(Object)(RemoteObject.concat(outcome.mostCurrent._domain,RemoteObject.createImmutable("ta_v2/endpoint/outcome.php"))),(Object)(RemoteObject.concat(RemoteObject.createImmutable("send=test"),RemoteObject.createImmutable("&data=test"))));
 BA.debugLineNum = 77;BA.debugLine="ProgressDialogShow(\"Loading...\")";
Debug.ShouldStop(4096);
outcome.mostCurrent.__c.runVoidMethod ("ProgressDialogShow",outcome.mostCurrent.activityBA,(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Loading..."))));
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
		Debug.PushSubsStack("AddRow (outcome) ","outcome",7,outcome.mostCurrent.activityBA,outcome.mostCurrent,117);
if (RapidSub.canDelegate("addrow")) { return b4a.example.outcome.remoteMe.runUserSub(false, "outcome","addrow", _values);}
RemoteObject _lastrow = RemoteObject.createImmutable(0);
int _i = 0;
RemoteObject _l = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _rc = RemoteObject.declareNull("b4a.example.birth._rowcol");
Debug.locals.put("Values", _values);
 BA.debugLineNum = 117;BA.debugLine="Sub AddRow(Values() As String)";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 118;BA.debugLine="If Values.Length <> NumberOfColumns Then";
Debug.ShouldStop(2097152);
if (RemoteObject.solveBoolean("!",_values.getField(true,"length"),BA.numberCast(double.class, outcome._numberofcolumns))) { 
 BA.debugLineNum = 119;BA.debugLine="Log(\"Wrong number of values.\")";
Debug.ShouldStop(4194304);
outcome.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.createImmutable("Wrong number of values.")));
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
final int limit7 = RemoteObject.solve(new RemoteObject[] {outcome._numberofcolumns,RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step7 > 0 && _i <= limit7) || (step7 < 0 && _i >= limit7) ;_i = ((int)(0 + _i + step7))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 125;BA.debugLine="Dim l As Label";
Debug.ShouldStop(268435456);
_l = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("l", _l);
 BA.debugLineNum = 126;BA.debugLine="l.Initialize(\"cell\")";
Debug.ShouldStop(536870912);
_l.runVoidMethod ("Initialize",outcome.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("cell")));
 BA.debugLineNum = 127;BA.debugLine="l.Text = Values(i)";
Debug.ShouldStop(1073741824);
_l.runMethod(true,"setText",BA.ObjectToCharSequence(_values.getArrayElement(true,BA.numberCast(int.class, _i))));
 BA.debugLineNum = 128;BA.debugLine="l.Gravity = Alignment";
Debug.ShouldStop(-2147483648);
_l.runMethod(true,"setGravity",outcome._alignment);
 BA.debugLineNum = 129;BA.debugLine="l.TextSize = FontSize";
Debug.ShouldStop(1);
_l.runMethod(true,"setTextSize",outcome._fontsize);
 BA.debugLineNum = 130;BA.debugLine="l.TextColor = FontColor";
Debug.ShouldStop(2);
_l.runMethod(true,"setTextColor",outcome._fontcolor);
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
outcome.mostCurrent._table.runVoidMethod ("AddView",(Object)((_l.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {outcome._columnwidth,RemoteObject.createImmutable(_i)}, "*",0, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {outcome._rowheight,_lastrow}, "*",0, 1)),(Object)(outcome._columnwidth),(Object)(outcome._rowheight));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 138;BA.debugLine="Table.Height = NumberOfRows * RowHeight";
Debug.ShouldStop(512);
outcome.mostCurrent._table.runMethod(true,"setHeight",RemoteObject.solve(new RemoteObject[] {_numberofrows(),outcome._rowheight}, "*",0, 1));
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
		Debug.PushSubsStack("Cell_Click (outcome) ","outcome",7,outcome.mostCurrent.activityBA,outcome.mostCurrent,84);
if (RapidSub.canDelegate("cell_click")) { return b4a.example.outcome.remoteMe.runUserSub(false, "outcome","cell_click");}
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
_l.setObject(outcome.mostCurrent.__c.runMethod(false,"Sender",outcome.mostCurrent.activityBA));
 BA.debugLineNum = 88;BA.debugLine="rc = l.Tag";
Debug.ShouldStop(8388608);
_rc = (_l.runMethod(false,"getTag"));Debug.locals.put("rc", _rc);
 BA.debugLineNum = 89;BA.debugLine="SelectRow(rc.Row)";
Debug.ShouldStop(16777216);
_selectrow(_rc.getField(true,"Row"));
 BA.debugLineNum = 90;BA.debugLine="Activity.Title = \"Cell clicked: (\" & rc.Row & \",";
Debug.ShouldStop(33554432);
outcome.mostCurrent._activity.runMethod(false,"setTitle",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Cell clicked: ("),_rc.getField(true,"Row"),RemoteObject.createImmutable(", "),_rc.getField(true,"Col"),RemoteObject.createImmutable(")"))));
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
		Debug.PushSubsStack("ClearAll (outcome) ","outcome",7,outcome.mostCurrent.activityBA,outcome.mostCurrent,166);
if (RapidSub.canDelegate("clearall")) { return b4a.example.outcome.remoteMe.runUserSub(false, "outcome","clearall");}
int _i = 0;
 BA.debugLineNum = 166;BA.debugLine="Sub ClearAll";
Debug.ShouldStop(32);
 BA.debugLineNum = 167;BA.debugLine="For i = Table.NumberOfViews -1 To 0 Step -1";
Debug.ShouldStop(64);
{
final int step1 = -1;
final int limit1 = 0;
_i = RemoteObject.solve(new RemoteObject[] {outcome.mostCurrent._table.runMethod(true,"getNumberOfViews"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue() ;
for (;(step1 > 0 && _i <= limit1) || (step1 < 0 && _i >= limit1) ;_i = ((int)(0 + _i + step1))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 168;BA.debugLine="Table.RemoveViewAt(i)";
Debug.ShouldStop(128);
outcome.mostCurrent._table.runVoidMethod ("RemoveViewAt",(Object)(BA.numberCast(int.class, _i)));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 170;BA.debugLine="Table.Height = 0";
Debug.ShouldStop(512);
outcome.mostCurrent._table.runMethod(true,"setHeight",BA.numberCast(int.class, 0));
 BA.debugLineNum = 171;BA.debugLine="SelectedRow = -1";
Debug.ShouldStop(1024);
outcome._selectedrow = BA.numberCast(int.class, -(double) (0 + 1));
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
		Debug.PushSubsStack("GetCell (outcome) ","outcome",7,outcome.mostCurrent.activityBA,outcome.mostCurrent,163);
if (RapidSub.canDelegate("getcell")) { return b4a.example.outcome.remoteMe.runUserSub(false, "outcome","getcell", _row, _col);}
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
		Debug.PushSubsStack("GetView (outcome) ","outcome",7,outcome.mostCurrent.activityBA,outcome.mostCurrent,112);
if (RapidSub.canDelegate("getview")) { return b4a.example.outcome.remoteMe.runUserSub(false, "outcome","getview", _row, _col);}
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
_l.setObject(outcome.mostCurrent._table.runMethod(false,"GetView",(Object)(RemoteObject.solve(new RemoteObject[] {_row,outcome._numberofcolumns,_col}, "*+",1, 1))).getObject());
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
outcome.mostCurrent._domain = RemoteObject.createImmutable("");
 //BA.debugLineNum = 17;BA.debugLine="Dim job2 As HttpJob";
outcome.mostCurrent._job2 = RemoteObject.createNew ("anywheresoftware.b4a.samples.httputils2.httpjob");
 //BA.debugLineNum = 18;BA.debugLine="domain=\"http://a56cb1fd.ngrok.io/\"";
outcome.mostCurrent._domain = BA.ObjectToString("http://a56cb1fd.ngrok.io/");
 //BA.debugLineNum = 20;BA.debugLine="Dim SV As ScrollView";
outcome.mostCurrent._sv = RemoteObject.createNew ("anywheresoftware.b4a.objects.ScrollViewWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Dim Header As Panel";
outcome.mostCurrent._header = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 22;BA.debugLine="Dim Table As Panel";
outcome.mostCurrent._table = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 23;BA.debugLine="Dim NumberOfColumns, RowHeight, ColumnWidth As In";
outcome._numberofcolumns = RemoteObject.createImmutable(0);
outcome._rowheight = RemoteObject.createImmutable(0);
outcome._columnwidth = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 24;BA.debugLine="Dim HeaderColor, TableColor, FontColor, HeaderFon";
outcome._headercolor = RemoteObject.createImmutable(0);
outcome._tablecolor = RemoteObject.createImmutable(0);
outcome._fontcolor = RemoteObject.createImmutable(0);
outcome._headerfontcolor = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 25;BA.debugLine="Dim FontSize As Float";
outcome._fontsize = RemoteObject.createImmutable(0f);
 //BA.debugLineNum = 27;BA.debugLine="Dim Alignment As Int";
outcome._alignment = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 28;BA.debugLine="Dim SelectedRow As Int";
outcome._selectedrow = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 29;BA.debugLine="Dim SelectedRowColor As Int";
outcome._selectedrowcolor = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 32;BA.debugLine="HeaderColor = Colors.Green";
outcome._headercolor = outcome.mostCurrent.__c.getField(false,"Colors").getField(true,"Green");
 //BA.debugLineNum = 33;BA.debugLine="NumberOfColumns = 4";
outcome._numberofcolumns = BA.numberCast(int.class, 4);
 //BA.debugLineNum = 34;BA.debugLine="RowHeight = 30dip";
outcome._rowheight = outcome.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30)));
 //BA.debugLineNum = 35;BA.debugLine="TableColor = Colors.White";
outcome._tablecolor = outcome.mostCurrent.__c.getField(false,"Colors").getField(true,"White");
 //BA.debugLineNum = 36;BA.debugLine="FontColor = Colors.Black";
outcome._fontcolor = outcome.mostCurrent.__c.getField(false,"Colors").getField(true,"Black");
 //BA.debugLineNum = 37;BA.debugLine="HeaderFontColor = Colors.White";
outcome._headerfontcolor = outcome.mostCurrent.__c.getField(false,"Colors").getField(true,"White");
 //BA.debugLineNum = 38;BA.debugLine="FontSize = 14";
outcome._fontsize = BA.numberCast(float.class, 14);
 //BA.debugLineNum = 39;BA.debugLine="Alignment = Gravity.CENTER 'change to Gravity.LEF";
outcome._alignment = outcome.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER");
 //BA.debugLineNum = 40;BA.debugLine="SelectedRowColor = Colors.Blue";
outcome._selectedrowcolor = outcome.mostCurrent.__c.getField(false,"Colors").getField(true,"Blue");
 //BA.debugLineNum = 42;BA.debugLine="Private Panel7 As Panel";
outcome.mostCurrent._panel7 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 43;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _header_click() throws Exception{
try {
		Debug.PushSubsStack("Header_Click (outcome) ","outcome",7,outcome.mostCurrent.activityBA,outcome.mostCurrent,93);
if (RapidSub.canDelegate("header_click")) { return b4a.example.outcome.remoteMe.runUserSub(false, "outcome","header_click");}
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
_l.setObject(outcome.mostCurrent.__c.runMethod(false,"Sender",outcome.mostCurrent.activityBA));
 BA.debugLineNum = 97;BA.debugLine="col = l.Tag";
Debug.ShouldStop(1);
_col = BA.numberCast(int.class, _l.runMethod(false,"getTag"));Debug.locals.put("col", _col);
 BA.debugLineNum = 98;BA.debugLine="Activity.Title = \"Header clicked: \" & col";
Debug.ShouldStop(2);
outcome.mostCurrent._activity.runMethod(false,"setTitle",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Header clicked: "),_col)));
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
		Debug.PushSubsStack("JobDone (outcome) ","outcome",7,outcome.mostCurrent.activityBA,outcome.mostCurrent,174);
if (RapidSub.canDelegate("jobdone")) { return b4a.example.outcome.remoteMe.runUserSub(false, "outcome","jobdone", _job);}
RemoteObject _i = RemoteObject.createImmutable(0);
RemoteObject _parser = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser");
RemoteObject _root = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _features = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _colfeatures = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _properties = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _citizen_id = RemoteObject.createImmutable("");
RemoteObject _destination = RemoteObject.createImmutable("");
RemoteObject _from = RemoteObject.createImmutable("");
RemoteObject _status = RemoteObject.createImmutable("");
Debug.locals.put("Job", _job);
 BA.debugLineNum = 174;BA.debugLine="Sub JobDone (Job As HttpJob)";
Debug.ShouldStop(8192);
 BA.debugLineNum = 176;BA.debugLine="Log(\"JobName = \" & Job.JobName & \", Success = \" &";
Debug.ShouldStop(32768);
outcome.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("JobName = "),_job.getField(true,"_jobname"),RemoteObject.createImmutable(", Success = "),_job.getField(true,"_success"))));
 BA.debugLineNum = 177;BA.debugLine="If Job.Success = True Then";
Debug.ShouldStop(65536);
if (RemoteObject.solveBoolean("=",_job.getField(true,"_success"),outcome.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 178;BA.debugLine="ClearAll";
Debug.ShouldStop(131072);
_clearall();
 BA.debugLineNum = 179;BA.debugLine="Dim i As Int";
Debug.ShouldStop(262144);
_i = RemoteObject.createImmutable(0);Debug.locals.put("i", _i);
 BA.debugLineNum = 180;BA.debugLine="i=1";
Debug.ShouldStop(524288);
_i = BA.numberCast(int.class, 1);Debug.locals.put("i", _i);
 BA.debugLineNum = 182;BA.debugLine="Select Job.JobName";
Debug.ShouldStop(2097152);
switch (BA.switchObjectToInt(_job.getField(true,"_jobname"),BA.ObjectToString("Job2"))) {
case 0: {
 BA.debugLineNum = 184;BA.debugLine="Dim parser As JSONParser";
Debug.ShouldStop(8388608);
_parser = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("parser", _parser);
 BA.debugLineNum = 185;BA.debugLine="parser.Initialize(Job.GetString)";
Debug.ShouldStop(16777216);
_parser.runVoidMethod ("Initialize",(Object)(_job.runMethod(true,"_getstring")));
 BA.debugLineNum = 186;BA.debugLine="Dim root As Map = parser.NextObject";
Debug.ShouldStop(33554432);
_root = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_root = _parser.runMethod(false,"NextObject");Debug.locals.put("root", _root);Debug.locals.put("root", _root);
 BA.debugLineNum = 187;BA.debugLine="Dim features As List = root.Get(\"features\")";
Debug.ShouldStop(67108864);
_features = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_features.setObject(_root.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("features")))));Debug.locals.put("features", _features);
 BA.debugLineNum = 188;BA.debugLine="For Each colfeatures As Map In features";
Debug.ShouldStop(134217728);
_colfeatures = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
{
final RemoteObject group12 = _features;
final int groupLen12 = group12.runMethod(true,"getSize").<Integer>get()
;int index12 = 0;
;
for (; index12 < groupLen12;index12++){
_colfeatures.setObject(group12.runMethod(false,"Get",index12));
Debug.locals.put("colfeatures", _colfeatures);
 BA.debugLineNum = 189;BA.debugLine="Dim properties As Map = colfeatures.Get(\"prop";
Debug.ShouldStop(268435456);
_properties = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_properties.setObject(_colfeatures.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("properties")))));Debug.locals.put("properties", _properties);
 BA.debugLineNum = 190;BA.debugLine="Dim citizen_id As String = properties.Get(\"ci";
Debug.ShouldStop(536870912);
_citizen_id = BA.ObjectToString(_properties.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("citizen_id")))));Debug.locals.put("citizen_id", _citizen_id);Debug.locals.put("citizen_id", _citizen_id);
 BA.debugLineNum = 191;BA.debugLine="Dim destination As String = properties.Get(\"d";
Debug.ShouldStop(1073741824);
_destination = BA.ObjectToString(_properties.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("destination")))));Debug.locals.put("destination", _destination);Debug.locals.put("destination", _destination);
 BA.debugLineNum = 192;BA.debugLine="Dim from As String = properties.Get(\"from\")";
Debug.ShouldStop(-2147483648);
_from = BA.ObjectToString(_properties.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("from")))));Debug.locals.put("from", _from);Debug.locals.put("from", _from);
 BA.debugLineNum = 193;BA.debugLine="Dim status As String = properties.Get(\"status";
Debug.ShouldStop(1);
_status = BA.ObjectToString(_properties.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("status")))));Debug.locals.put("status", _status);Debug.locals.put("status", _status);
 BA.debugLineNum = 194;BA.debugLine="AddRow(Array As String(i, citizen_id, from, d";
Debug.ShouldStop(2);
_addrow(RemoteObject.createNewArray("String",new int[] {4},new Object[] {BA.NumberToString(_i),_citizen_id,_from,_destination}));
 BA.debugLineNum = 195;BA.debugLine="i=i+1";
Debug.ShouldStop(4);
_i = RemoteObject.solve(new RemoteObject[] {_i,RemoteObject.createImmutable(1)}, "+",1, 1);Debug.locals.put("i", _i);
 }
}Debug.locals.put("colfeatures", _colfeatures);
;
 BA.debugLineNum = 203;BA.debugLine="ProgressDialogHide";
Debug.ShouldStop(1024);
outcome.mostCurrent.__c.runVoidMethod ("ProgressDialogHide");
 break; }
}
;
 }else {
 BA.debugLineNum = 208;BA.debugLine="Log(\"Error: \" & Job.ErrorMessage)";
Debug.ShouldStop(32768);
outcome.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("Error: "),_job.getField(true,"_errormessage"))));
 BA.debugLineNum = 209;BA.debugLine="ToastMessageShow(\"Error: \" & Job.ErrorMessage, T";
Debug.ShouldStop(65536);
outcome.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Error: "),_job.getField(true,"_errormessage")))),(Object)(outcome.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 211;BA.debugLine="Job.Release";
Debug.ShouldStop(262144);
_job.runVoidMethod ("_release");
 BA.debugLineNum = 212;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
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
		Debug.PushSubsStack("Label3_Click (outcome) ","outcome",7,outcome.mostCurrent.activityBA,outcome.mostCurrent,219);
if (RapidSub.canDelegate("label3_click")) { return b4a.example.outcome.remoteMe.runUserSub(false, "outcome","label3_click");}
 BA.debugLineNum = 219;BA.debugLine="Sub Label3_Click";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 220;BA.debugLine="StartActivity(\"dashboard\")";
Debug.ShouldStop(134217728);
outcome.mostCurrent.__c.runVoidMethod ("StartActivity",outcome.processBA,(Object)((RemoteObject.createImmutable("dashboard"))));
 BA.debugLineNum = 221;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
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
		Debug.PushSubsStack("Label7_Click (outcome) ","outcome",7,outcome.mostCurrent.activityBA,outcome.mostCurrent,215);
if (RapidSub.canDelegate("label7_click")) { return b4a.example.outcome.remoteMe.runUserSub(false, "outcome","label7_click");}
 BA.debugLineNum = 215;BA.debugLine="Sub Label7_Click";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 216;BA.debugLine="StartActivity(\"add_outcome\")";
Debug.ShouldStop(8388608);
outcome.mostCurrent.__c.runVoidMethod ("StartActivity",outcome.processBA,(Object)((RemoteObject.createImmutable("add_outcome"))));
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
public static RemoteObject  _numberofrows() throws Exception{
try {
		Debug.PushSubsStack("NumberOfRows (outcome) ","outcome",7,outcome.mostCurrent.activityBA,outcome.mostCurrent,156);
if (RapidSub.canDelegate("numberofrows")) { return b4a.example.outcome.remoteMe.runUserSub(false, "outcome","numberofrows");}
 BA.debugLineNum = 156;BA.debugLine="Sub NumberOfRows As Int";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 157;BA.debugLine="Return Table.NumberOfViews / NumberOfColumns";
Debug.ShouldStop(268435456);
if (true) return BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {outcome.mostCurrent._table.runMethod(true,"getNumberOfViews"),outcome._numberofcolumns}, "/",0, 0));
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
		Debug.PushSubsStack("SelectRow (outcome) ","outcome",7,outcome.mostCurrent.activityBA,outcome.mostCurrent,100);
if (RapidSub.canDelegate("selectrow")) { return b4a.example.outcome.remoteMe.runUserSub(false, "outcome","selectrow", _row);}
int _col = 0;
Debug.locals.put("Row", _row);
 BA.debugLineNum = 100;BA.debugLine="Sub SelectRow(Row As Int)";
Debug.ShouldStop(8);
 BA.debugLineNum = 102;BA.debugLine="If SelectedRow > -1 Then";
Debug.ShouldStop(32);
if (RemoteObject.solveBoolean(">",outcome._selectedrow,BA.numberCast(double.class, -(double) (0 + 1)))) { 
 BA.debugLineNum = 103;BA.debugLine="For col = 0 To NumberOfColumns - 1";
Debug.ShouldStop(64);
{
final int step2 = 1;
final int limit2 = RemoteObject.solve(new RemoteObject[] {outcome._numberofcolumns,RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_col = 0 ;
for (;(step2 > 0 && _col <= limit2) || (step2 < 0 && _col >= limit2) ;_col = ((int)(0 + _col + step2))  ) {
Debug.locals.put("col", _col);
 BA.debugLineNum = 104;BA.debugLine="GetView(SelectedRow, col).Color = Colors.Transp";
Debug.ShouldStop(128);
_getview(outcome._selectedrow,BA.numberCast(int.class, _col)).runVoidMethod ("setColor",outcome.mostCurrent.__c.getField(false,"Colors").getField(true,"Transparent"));
 }
}Debug.locals.put("col", _col);
;
 };
 BA.debugLineNum = 107;BA.debugLine="SelectedRow = Row";
Debug.ShouldStop(1024);
outcome._selectedrow = _row;
 BA.debugLineNum = 108;BA.debugLine="For col = 0 To NumberOfColumns - 1";
Debug.ShouldStop(2048);
{
final int step7 = 1;
final int limit7 = RemoteObject.solve(new RemoteObject[] {outcome._numberofcolumns,RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_col = 0 ;
for (;(step7 > 0 && _col <= limit7) || (step7 < 0 && _col >= limit7) ;_col = ((int)(0 + _col + step7))  ) {
Debug.locals.put("col", _col);
 BA.debugLineNum = 109;BA.debugLine="GetView(Row, col).Color = SelectedRowColor";
Debug.ShouldStop(4096);
_getview(_row,BA.numberCast(int.class, _col)).runVoidMethod ("setColor",outcome._selectedrowcolor);
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
		Debug.PushSubsStack("SetCell (outcome) ","outcome",7,outcome.mostCurrent.activityBA,outcome.mostCurrent,160);
if (RapidSub.canDelegate("setcell")) { return b4a.example.outcome.remoteMe.runUserSub(false, "outcome","setcell", _row, _col, _value);}
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
		Debug.PushSubsStack("SetHeader (outcome) ","outcome",7,outcome.mostCurrent.activityBA,outcome.mostCurrent,140);
if (RapidSub.canDelegate("setheader")) { return b4a.example.outcome.remoteMe.runUserSub(false, "outcome","setheader", _values);}
int _i = 0;
RemoteObject _l = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
Debug.locals.put("Values", _values);
 BA.debugLineNum = 140;BA.debugLine="Sub SetHeader(Values() As String)";
Debug.ShouldStop(2048);
 BA.debugLineNum = 141;BA.debugLine="If Header.IsInitialized Then Return 'should only";
Debug.ShouldStop(4096);
if (outcome.mostCurrent._header.runMethod(true,"IsInitialized").<Boolean>get().booleanValue()) { 
if (true) return RemoteObject.createImmutable("");};
 BA.debugLineNum = 142;BA.debugLine="Header.Initialize(\"\")";
Debug.ShouldStop(8192);
outcome.mostCurrent._header.runVoidMethod ("Initialize",outcome.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 143;BA.debugLine="For i = 0 To NumberOfColumns - 1";
Debug.ShouldStop(16384);
{
final int step3 = 1;
final int limit3 = RemoteObject.solve(new RemoteObject[] {outcome._numberofcolumns,RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step3 > 0 && _i <= limit3) || (step3 < 0 && _i >= limit3) ;_i = ((int)(0 + _i + step3))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 144;BA.debugLine="Dim l As Label";
Debug.ShouldStop(32768);
_l = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("l", _l);
 BA.debugLineNum = 145;BA.debugLine="l.Initialize(\"header\")";
Debug.ShouldStop(65536);
_l.runVoidMethod ("Initialize",outcome.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("header")));
 BA.debugLineNum = 146;BA.debugLine="l.Text = Values(i)";
Debug.ShouldStop(131072);
_l.runMethod(true,"setText",BA.ObjectToCharSequence(_values.getArrayElement(true,BA.numberCast(int.class, _i))));
 BA.debugLineNum = 147;BA.debugLine="l.Gravity = Gravity.CENTER";
Debug.ShouldStop(262144);
_l.runMethod(true,"setGravity",outcome.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 148;BA.debugLine="l.TextSize = FontSize";
Debug.ShouldStop(524288);
_l.runMethod(true,"setTextSize",outcome._fontsize);
 BA.debugLineNum = 149;BA.debugLine="l.Color = HeaderColor";
Debug.ShouldStop(1048576);
_l.runVoidMethod ("setColor",outcome._headercolor);
 BA.debugLineNum = 150;BA.debugLine="l.TextColor = HeaderFontColor";
Debug.ShouldStop(2097152);
_l.runMethod(true,"setTextColor",outcome._headerfontcolor);
 BA.debugLineNum = 151;BA.debugLine="l.Tag = i";
Debug.ShouldStop(4194304);
_l.runMethod(false,"setTag",RemoteObject.createImmutable((_i)));
 BA.debugLineNum = 152;BA.debugLine="Header.AddView(l, ColumnWidth * i, 0, ColumnWidt";
Debug.ShouldStop(8388608);
outcome.mostCurrent._header.runVoidMethod ("AddView",(Object)((_l.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {outcome._columnwidth,RemoteObject.createImmutable(_i)}, "*",0, 1)),(Object)(BA.numberCast(int.class, 0)),(Object)(outcome._columnwidth),(Object)(outcome._rowheight));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 154;BA.debugLine="Activity.AddView(Header, SV.Left, SV.Top+200, SV.";
Debug.ShouldStop(33554432);
outcome.mostCurrent._activity.runVoidMethod ("AddView",(Object)((outcome.mostCurrent._header.getObject())),(Object)(outcome.mostCurrent._sv.runMethod(true,"getLeft")),(Object)(RemoteObject.solve(new RemoteObject[] {outcome.mostCurrent._sv.runMethod(true,"getTop"),RemoteObject.createImmutable(200)}, "+",1, 1)),(Object)(outcome.mostCurrent._sv.runMethod(true,"getWidth")),(Object)(outcome._rowheight));
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
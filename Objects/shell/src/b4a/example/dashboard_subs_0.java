package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class dashboard_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (dashboard) ","dashboard",2,dashboard.mostCurrent.activityBA,dashboard.mostCurrent,28);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.dashboard.remoteMe.runUserSub(false, "dashboard","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 28;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 30;BA.debugLine="Activity.LoadLayout(\"dashboard\")";
Debug.ShouldStop(536870912);
dashboard.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("dashboard")),dashboard.mostCurrent.activityBA);
 BA.debugLineNum = 31;BA.debugLine="job2.Initialize(\"Job2\", Me)";
Debug.ShouldStop(1073741824);
dashboard.mostCurrent._job2.runVoidMethod ("_initialize",dashboard.processBA,(Object)(BA.ObjectToString("Job2")),(Object)(dashboard.getObject()));
 BA.debugLineNum = 32;BA.debugLine="job2.PostString(domain&\"ta_v2/endpoint/countAll.p";
Debug.ShouldStop(-2147483648);
dashboard.mostCurrent._job2.runVoidMethod ("_poststring",(Object)(RemoteObject.concat(dashboard.mostCurrent._domain,RemoteObject.createImmutable("ta_v2/endpoint/countAll.php"))),(Object)(RemoteObject.concat(RemoteObject.createImmutable("send=test"),RemoteObject.createImmutable("&data=test"))));
 BA.debugLineNum = 33;BA.debugLine="ProgressDialogShow(\"Loading...\")";
Debug.ShouldStop(1);
dashboard.mostCurrent.__c.runVoidMethod ("ProgressDialogShow",dashboard.mostCurrent.activityBA,(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Loading..."))));
 BA.debugLineNum = 34;BA.debugLine="WebView1.LoadUrl(domain&\"ta_v2/endpoint/view/laye";
Debug.ShouldStop(2);
dashboard.mostCurrent._webview1.runVoidMethod ("LoadUrl",(Object)(RemoteObject.concat(dashboard.mostCurrent._domain,RemoteObject.createImmutable("ta_v2/endpoint/view/layers.php?request=all"))));
 BA.debugLineNum = 36;BA.debugLine="End Sub";
Debug.ShouldStop(8);
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
		Debug.PushSubsStack("Activity_Pause (dashboard) ","dashboard",2,dashboard.mostCurrent.activityBA,dashboard.mostCurrent,45);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.dashboard.remoteMe.runUserSub(false, "dashboard","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 45;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(4096);
 BA.debugLineNum = 47;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
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
		Debug.PushSubsStack("Activity_Resume (dashboard) ","dashboard",2,dashboard.mostCurrent.activityBA,dashboard.mostCurrent,38);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.dashboard.remoteMe.runUserSub(false, "dashboard","activity_resume");}
 BA.debugLineNum = 38;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(32);
 BA.debugLineNum = 43;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _button1_click() throws Exception{
try {
		Debug.PushSubsStack("Button1_Click (dashboard) ","dashboard",2,dashboard.mostCurrent.activityBA,dashboard.mostCurrent,84);
if (RapidSub.canDelegate("button1_click")) { return b4a.example.dashboard.remoteMe.runUserSub(false, "dashboard","button1_click");}
 BA.debugLineNum = 84;BA.debugLine="Sub Button1_Click";
Debug.ShouldStop(524288);
 BA.debugLineNum = 85;BA.debugLine="StartActivity(\"birth\")";
Debug.ShouldStop(1048576);
dashboard.mostCurrent.__c.runVoidMethod ("StartActivity",dashboard.processBA,(Object)((RemoteObject.createImmutable("birth"))));
 BA.debugLineNum = 86;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _button10_click() throws Exception{
try {
		Debug.PushSubsStack("Button10_Click (dashboard) ","dashboard",2,dashboard.mostCurrent.activityBA,dashboard.mostCurrent,120);
if (RapidSub.canDelegate("button10_click")) { return b4a.example.dashboard.remoteMe.runUserSub(false, "dashboard","button10_click");}
 BA.debugLineNum = 120;BA.debugLine="Sub Button10_Click";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 121;BA.debugLine="StartActivity(\"land_by_owner\")";
Debug.ShouldStop(16777216);
dashboard.mostCurrent.__c.runVoidMethod ("StartActivity",dashboard.processBA,(Object)((RemoteObject.createImmutable("land_by_owner"))));
 BA.debugLineNum = 122;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _button11_click() throws Exception{
try {
		Debug.PushSubsStack("Button11_Click (dashboard) ","dashboard",2,dashboard.mostCurrent.activityBA,dashboard.mostCurrent,124);
if (RapidSub.canDelegate("button11_click")) { return b4a.example.dashboard.remoteMe.runUserSub(false, "dashboard","button11_click");}
 BA.debugLineNum = 124;BA.debugLine="Sub Button11_Click";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 125;BA.debugLine="StartActivity(\"buildings\")";
Debug.ShouldStop(268435456);
dashboard.mostCurrent.__c.runVoidMethod ("StartActivity",dashboard.processBA,(Object)((RemoteObject.createImmutable("buildings"))));
 BA.debugLineNum = 126;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _button12_click() throws Exception{
try {
		Debug.PushSubsStack("Button12_Click (dashboard) ","dashboard",2,dashboard.mostCurrent.activityBA,dashboard.mostCurrent,129);
if (RapidSub.canDelegate("button12_click")) { return b4a.example.dashboard.remoteMe.runUserSub(false, "dashboard","button12_click");}
 BA.debugLineNum = 129;BA.debugLine="Sub Button12_Click";
Debug.ShouldStop(1);
 BA.debugLineNum = 130;BA.debugLine="StartActivity(\"building_id\")";
Debug.ShouldStop(2);
dashboard.mostCurrent.__c.runVoidMethod ("StartActivity",dashboard.processBA,(Object)((RemoteObject.createImmutable("building_id"))));
 BA.debugLineNum = 131;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _button13_click() throws Exception{
try {
		Debug.PushSubsStack("Button13_Click (dashboard) ","dashboard",2,dashboard.mostCurrent.activityBA,dashboard.mostCurrent,134);
if (RapidSub.canDelegate("button13_click")) { return b4a.example.dashboard.remoteMe.runUserSub(false, "dashboard","button13_click");}
 BA.debugLineNum = 134;BA.debugLine="Sub Button13_Click";
Debug.ShouldStop(32);
 BA.debugLineNum = 135;BA.debugLine="StartActivity(\"building_owner\")";
Debug.ShouldStop(64);
dashboard.mostCurrent.__c.runVoidMethod ("StartActivity",dashboard.processBA,(Object)((RemoteObject.createImmutable("building_owner"))));
 BA.debugLineNum = 136;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _button2_click() throws Exception{
try {
		Debug.PushSubsStack("Button2_Click (dashboard) ","dashboard",2,dashboard.mostCurrent.activityBA,dashboard.mostCurrent,92);
if (RapidSub.canDelegate("button2_click")) { return b4a.example.dashboard.remoteMe.runUserSub(false, "dashboard","button2_click");}
 BA.debugLineNum = 92;BA.debugLine="Sub Button2_Click";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 93;BA.debugLine="StartActivity(\"mortality\")";
Debug.ShouldStop(268435456);
dashboard.mostCurrent.__c.runVoidMethod ("StartActivity",dashboard.processBA,(Object)((RemoteObject.createImmutable("mortality"))));
 BA.debugLineNum = 94;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _button3_click() throws Exception{
try {
		Debug.PushSubsStack("Button3_Click (dashboard) ","dashboard",2,dashboard.mostCurrent.activityBA,dashboard.mostCurrent,96);
if (RapidSub.canDelegate("button3_click")) { return b4a.example.dashboard.remoteMe.runUserSub(false, "dashboard","button3_click");}
 BA.debugLineNum = 96;BA.debugLine="Sub Button3_Click";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 97;BA.debugLine="StartActivity(\"outcome\")";
Debug.ShouldStop(1);
dashboard.mostCurrent.__c.runVoidMethod ("StartActivity",dashboard.processBA,(Object)((RemoteObject.createImmutable("outcome"))));
 BA.debugLineNum = 98;BA.debugLine="End Sub";
Debug.ShouldStop(2);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _button4_click() throws Exception{
try {
		Debug.PushSubsStack("Button4_Click (dashboard) ","dashboard",2,dashboard.mostCurrent.activityBA,dashboard.mostCurrent,100);
if (RapidSub.canDelegate("button4_click")) { return b4a.example.dashboard.remoteMe.runUserSub(false, "dashboard","button4_click");}
 BA.debugLineNum = 100;BA.debugLine="Sub Button4_Click";
Debug.ShouldStop(8);
 BA.debugLineNum = 101;BA.debugLine="StartActivity(\"family_card\")";
Debug.ShouldStop(16);
dashboard.mostCurrent.__c.runVoidMethod ("StartActivity",dashboard.processBA,(Object)((RemoteObject.createImmutable("family_card"))));
 BA.debugLineNum = 102;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _button5_click() throws Exception{
try {
		Debug.PushSubsStack("Button5_Click (dashboard) ","dashboard",2,dashboard.mostCurrent.activityBA,dashboard.mostCurrent,104);
if (RapidSub.canDelegate("button5_click")) { return b4a.example.dashboard.remoteMe.runUserSub(false, "dashboard","button5_click");}
 BA.debugLineNum = 104;BA.debugLine="Sub Button5_Click";
Debug.ShouldStop(128);
 BA.debugLineNum = 105;BA.debugLine="StartActivity(\"citizen\")";
Debug.ShouldStop(256);
dashboard.mostCurrent.__c.runVoidMethod ("StartActivity",dashboard.processBA,(Object)((RemoteObject.createImmutable("citizen"))));
 BA.debugLineNum = 106;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _button7_click() throws Exception{
try {
		Debug.PushSubsStack("Button7_Click (dashboard) ","dashboard",2,dashboard.mostCurrent.activityBA,dashboard.mostCurrent,108);
if (RapidSub.canDelegate("button7_click")) { return b4a.example.dashboard.remoteMe.runUserSub(false, "dashboard","button7_click");}
 BA.debugLineNum = 108;BA.debugLine="Sub Button7_Click";
Debug.ShouldStop(2048);
 BA.debugLineNum = 109;BA.debugLine="StartActivity(\"owners\")";
Debug.ShouldStop(4096);
dashboard.mostCurrent.__c.runVoidMethod ("StartActivity",dashboard.processBA,(Object)((RemoteObject.createImmutable("owners"))));
 BA.debugLineNum = 110;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _button8_click() throws Exception{
try {
		Debug.PushSubsStack("Button8_Click (dashboard) ","dashboard",2,dashboard.mostCurrent.activityBA,dashboard.mostCurrent,112);
if (RapidSub.canDelegate("button8_click")) { return b4a.example.dashboard.remoteMe.runUserSub(false, "dashboard","button8_click");}
 BA.debugLineNum = 112;BA.debugLine="Sub Button8_Click";
Debug.ShouldStop(32768);
 BA.debugLineNum = 113;BA.debugLine="StartActivity(\"lands\")";
Debug.ShouldStop(65536);
dashboard.mostCurrent.__c.runVoidMethod ("StartActivity",dashboard.processBA,(Object)((RemoteObject.createImmutable("lands"))));
 BA.debugLineNum = 114;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _button9_click() throws Exception{
try {
		Debug.PushSubsStack("Button9_Click (dashboard) ","dashboard",2,dashboard.mostCurrent.activityBA,dashboard.mostCurrent,116);
if (RapidSub.canDelegate("button9_click")) { return b4a.example.dashboard.remoteMe.runUserSub(false, "dashboard","button9_click");}
 BA.debugLineNum = 116;BA.debugLine="Sub Button9_Click";
Debug.ShouldStop(524288);
 BA.debugLineNum = 117;BA.debugLine="StartActivity(\"lands_id\")";
Debug.ShouldStop(1048576);
dashboard.mostCurrent.__c.runVoidMethod ("StartActivity",dashboard.processBA,(Object)((RemoteObject.createImmutable("lands_id"))));
 BA.debugLineNum = 118;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 15;BA.debugLine="Dim domain As String";
dashboard.mostCurrent._domain = RemoteObject.createImmutable("");
 //BA.debugLineNum = 16;BA.debugLine="Dim job2 As HttpJob";
dashboard.mostCurrent._job2 = RemoteObject.createNew ("anywheresoftware.b4a.samples.httputils2.httpjob");
 //BA.debugLineNum = 17;BA.debugLine="domain=\"http://a56cb1fd.ngrok.io/\"";
dashboard.mostCurrent._domain = BA.ObjectToString("http://a56cb1fd.ngrok.io/");
 //BA.debugLineNum = 19;BA.debugLine="Private Label10 As Label";
dashboard.mostCurrent._label10 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 20;BA.debugLine="Private Label11 As Label";
dashboard.mostCurrent._label11 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Private Label12 As Label";
dashboard.mostCurrent._label12 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 22;BA.debugLine="Private Button1 As Button";
dashboard.mostCurrent._button1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 23;BA.debugLine="Private Button4 As Button";
dashboard.mostCurrent._button4 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Private Button5 As Button";
dashboard.mostCurrent._button5 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 25;BA.debugLine="Private WebView1 As WebView";
dashboard.mostCurrent._webview1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.WebViewWrapper");
 //BA.debugLineNum = 26;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _jobdone(RemoteObject _job) throws Exception{
try {
		Debug.PushSubsStack("JobDone (dashboard) ","dashboard",2,dashboard.mostCurrent.activityBA,dashboard.mostCurrent,49);
if (RapidSub.canDelegate("jobdone")) { return b4a.example.dashboard.remoteMe.runUserSub(false, "dashboard","jobdone", _job);}
RemoteObject _parser = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser");
RemoteObject _root = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _features = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _colfeatures = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _properties = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _citizen1 = RemoteObject.createImmutable("");
RemoteObject _land = RemoteObject.createImmutable("");
RemoteObject _building = RemoteObject.createImmutable("");
Debug.locals.put("Job", _job);
 BA.debugLineNum = 49;BA.debugLine="Sub JobDone (Job As HttpJob)";
Debug.ShouldStop(65536);
 BA.debugLineNum = 50;BA.debugLine="ProgressDialogHide";
Debug.ShouldStop(131072);
dashboard.mostCurrent.__c.runVoidMethod ("ProgressDialogHide");
 BA.debugLineNum = 51;BA.debugLine="Log(\"JobName = \" & Job.JobName & \", Success = \" &";
Debug.ShouldStop(262144);
dashboard.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("JobName = "),_job.getField(true,"_jobname"),RemoteObject.createImmutable(", Success = "),_job.getField(true,"_success"))));
 BA.debugLineNum = 52;BA.debugLine="If Job.Success = True Then";
Debug.ShouldStop(524288);
if (RemoteObject.solveBoolean("=",_job.getField(true,"_success"),dashboard.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 55;BA.debugLine="Select Job.JobName";
Debug.ShouldStop(4194304);
switch (BA.switchObjectToInt(_job.getField(true,"_jobname"),BA.ObjectToString("Job2"))) {
case 0: {
 BA.debugLineNum = 57;BA.debugLine="Dim parser As JSONParser";
Debug.ShouldStop(16777216);
_parser = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("parser", _parser);
 BA.debugLineNum = 58;BA.debugLine="parser.Initialize(Job.GetString)";
Debug.ShouldStop(33554432);
_parser.runVoidMethod ("Initialize",(Object)(_job.runMethod(true,"_getstring")));
 BA.debugLineNum = 59;BA.debugLine="Log(Job.GetString)";
Debug.ShouldStop(67108864);
dashboard.mostCurrent.__c.runVoidMethod ("Log",(Object)(_job.runMethod(true,"_getstring")));
 BA.debugLineNum = 60;BA.debugLine="Dim root As Map = parser.NextObject";
Debug.ShouldStop(134217728);
_root = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_root = _parser.runMethod(false,"NextObject");Debug.locals.put("root", _root);Debug.locals.put("root", _root);
 BA.debugLineNum = 61;BA.debugLine="Dim features As List = root.Get(\"features\")";
Debug.ShouldStop(268435456);
_features = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_features.setObject(_root.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("features")))));Debug.locals.put("features", _features);
 BA.debugLineNum = 62;BA.debugLine="For Each colfeatures As Map In features";
Debug.ShouldStop(536870912);
_colfeatures = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
{
final RemoteObject group11 = _features;
final int groupLen11 = group11.runMethod(true,"getSize").<Integer>get()
;int index11 = 0;
;
for (; index11 < groupLen11;index11++){
_colfeatures.setObject(group11.runMethod(false,"Get",index11));
Debug.locals.put("colfeatures", _colfeatures);
 BA.debugLineNum = 63;BA.debugLine="Dim properties As Map = colfeatures.Get(\"prop";
Debug.ShouldStop(1073741824);
_properties = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_properties.setObject(_colfeatures.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("properties")))));Debug.locals.put("properties", _properties);
 BA.debugLineNum = 64;BA.debugLine="Dim citizen1 As String = properties.Get(\"citi";
Debug.ShouldStop(-2147483648);
_citizen1 = BA.ObjectToString(_properties.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("citizen")))));Debug.locals.put("citizen1", _citizen1);Debug.locals.put("citizen1", _citizen1);
 BA.debugLineNum = 65;BA.debugLine="Dim land As String = properties.Get(\"land\")";
Debug.ShouldStop(1);
_land = BA.ObjectToString(_properties.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("land")))));Debug.locals.put("land", _land);Debug.locals.put("land", _land);
 BA.debugLineNum = 66;BA.debugLine="Dim building As String = properties.Get(\"buil";
Debug.ShouldStop(2);
_building = BA.ObjectToString(_properties.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("building")))));Debug.locals.put("building", _building);Debug.locals.put("building", _building);
 BA.debugLineNum = 67;BA.debugLine="Log(building)";
Debug.ShouldStop(4);
dashboard.mostCurrent.__c.runVoidMethod ("Log",(Object)(_building));
 BA.debugLineNum = 68;BA.debugLine="Label10.Text=land";
Debug.ShouldStop(8);
dashboard.mostCurrent._label10.runMethod(true,"setText",BA.ObjectToCharSequence(_land));
 BA.debugLineNum = 69;BA.debugLine="Label11.Text=building";
Debug.ShouldStop(16);
dashboard.mostCurrent._label11.runMethod(true,"setText",BA.ObjectToCharSequence(_building));
 BA.debugLineNum = 70;BA.debugLine="Label12.Text=citizen1";
Debug.ShouldStop(32);
dashboard.mostCurrent._label12.runMethod(true,"setText",BA.ObjectToCharSequence(_citizen1));
 }
}Debug.locals.put("colfeatures", _colfeatures);
;
 BA.debugLineNum = 73;BA.debugLine="Job.Release";
Debug.ShouldStop(256);
_job.runVoidMethod ("_release");
 break; }
}
;
 }else {
 BA.debugLineNum = 76;BA.debugLine="Log(\"Error: \" & Job.ErrorMessage)";
Debug.ShouldStop(2048);
dashboard.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("Error: "),_job.getField(true,"_errormessage"))));
 BA.debugLineNum = 77;BA.debugLine="ToastMessageShow(\"Error: \" & Job.ErrorMessage, T";
Debug.ShouldStop(4096);
dashboard.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Error: "),_job.getField(true,"_errormessage")))),(Object)(dashboard.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 78;BA.debugLine="Job.Release";
Debug.ShouldStop(8192);
_job.runVoidMethod ("_release");
 };
 BA.debugLineNum = 81;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
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
		Debug.PushSubsStack("Label3_Click (dashboard) ","dashboard",2,dashboard.mostCurrent.activityBA,dashboard.mostCurrent,88);
if (RapidSub.canDelegate("label3_click")) { return b4a.example.dashboard.remoteMe.runUserSub(false, "dashboard","label3_click");}
 BA.debugLineNum = 88;BA.debugLine="Sub Label3_Click";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 89;BA.debugLine="StartActivity(\"dashboard\")";
Debug.ShouldStop(16777216);
dashboard.mostCurrent.__c.runVoidMethod ("StartActivity",dashboard.processBA,(Object)((RemoteObject.createImmutable("dashboard"))));
 BA.debugLineNum = 90;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}
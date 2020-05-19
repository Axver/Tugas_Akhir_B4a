package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class citizen_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (citizen) ","citizen",10,citizen.mostCurrent.activityBA,citizen.mostCurrent,31);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.citizen.remoteMe.runUserSub(false, "citizen","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 31;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 33;BA.debugLine="Activity.LoadLayout(\"citizen\")";
Debug.ShouldStop(1);
citizen.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("citizen")),citizen.mostCurrent.activityBA);
 BA.debugLineNum = 34;BA.debugLine="job2.Initialize(\"Job2\", Me)";
Debug.ShouldStop(2);
citizen.mostCurrent._job2.runVoidMethod ("_initialize",citizen.processBA,(Object)(BA.ObjectToString("Job2")),(Object)(citizen.getObject()));
 BA.debugLineNum = 35;BA.debugLine="job2.PostString(domain&\"ta_v2/endpoint/countFcn.p";
Debug.ShouldStop(4);
citizen.mostCurrent._job2.runVoidMethod ("_poststring",(Object)(RemoteObject.concat(citizen.mostCurrent._domain,RemoteObject.createImmutable("ta_v2/endpoint/countFcn.php"))),(Object)(RemoteObject.concat(RemoteObject.createImmutable("send=test"),RemoteObject.createImmutable("&data=test"))));
 BA.debugLineNum = 36;BA.debugLine="ProgressDialogShow(\"Loading...\")";
Debug.ShouldStop(8);
citizen.mostCurrent.__c.runVoidMethod ("ProgressDialogShow",citizen.mostCurrent.activityBA,(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Loading..."))));
 BA.debugLineNum = 38;BA.debugLine="End Sub";
Debug.ShouldStop(32);
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
		Debug.PushSubsStack("Activity_Pause (citizen) ","citizen",10,citizen.mostCurrent.activityBA,citizen.mostCurrent,46);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.citizen.remoteMe.runUserSub(false, "citizen","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 46;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(8192);
 BA.debugLineNum = 48;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
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
		Debug.PushSubsStack("Activity_Resume (citizen) ","citizen",10,citizen.mostCurrent.activityBA,citizen.mostCurrent,40);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.citizen.remoteMe.runUserSub(false, "citizen","activity_resume");}
 BA.debugLineNum = 40;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(128);
 BA.debugLineNum = 41;BA.debugLine="job2.Initialize(\"Job2\", Me)";
Debug.ShouldStop(256);
citizen.mostCurrent._job2.runVoidMethod ("_initialize",citizen.processBA,(Object)(BA.ObjectToString("Job2")),(Object)(citizen.getObject()));
 BA.debugLineNum = 42;BA.debugLine="job2.PostString(domain&\"ta_v2/endpoint/countFcn.p";
Debug.ShouldStop(512);
citizen.mostCurrent._job2.runVoidMethod ("_poststring",(Object)(RemoteObject.concat(citizen.mostCurrent._domain,RemoteObject.createImmutable("ta_v2/endpoint/countFcn.php"))),(Object)(RemoteObject.concat(RemoteObject.createImmutable("send=test"),RemoteObject.createImmutable("&data=test"))));
 BA.debugLineNum = 43;BA.debugLine="ProgressDialogShow(\"Loading...\")";
Debug.ShouldStop(1024);
citizen.mostCurrent.__c.runVoidMethod ("ProgressDialogShow",citizen.mostCurrent.activityBA,(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Loading..."))));
 BA.debugLineNum = 44;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
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
		Debug.PushSubsStack("Button1_Click (citizen) ","citizen",10,citizen.mostCurrent.activityBA,citizen.mostCurrent,111);
if (RapidSub.canDelegate("button1_click")) { return b4a.example.citizen.remoteMe.runUserSub(false, "citizen","button1_click");}
RemoteObject _citizen_id = RemoteObject.createImmutable("");
RemoteObject _size = RemoteObject.createImmutable(0);
int _x = 0;
 BA.debugLineNum = 111;BA.debugLine="Sub Button1_Click";
Debug.ShouldStop(16384);
 BA.debugLineNum = 112;BA.debugLine="Dim citizen_id As String";
Debug.ShouldStop(32768);
_citizen_id = RemoteObject.createImmutable("");Debug.locals.put("citizen_id", _citizen_id);
 BA.debugLineNum = 113;BA.debugLine="citizen_id=EditText1.Text";
Debug.ShouldStop(65536);
_citizen_id = citizen.mostCurrent._edittext1.runMethod(true,"getText");Debug.locals.put("citizen_id", _citizen_id);
 BA.debugLineNum = 115;BA.debugLine="job2.Initialize(\"Job3\", Me)";
Debug.ShouldStop(262144);
citizen.mostCurrent._job2.runVoidMethod ("_initialize",citizen.processBA,(Object)(BA.ObjectToString("Job3")),(Object)(citizen.getObject()));
 BA.debugLineNum = 116;BA.debugLine="job2.PostString(domain&\"ta_v2/endpoint/citizen_se";
Debug.ShouldStop(524288);
citizen.mostCurrent._job2.runVoidMethod ("_poststring",(Object)(RemoteObject.concat(citizen.mostCurrent._domain,RemoteObject.createImmutable("ta_v2/endpoint/citizen_search.php"))),(Object)(RemoteObject.concat(RemoteObject.createImmutable("citizen_id="),_citizen_id)));
 BA.debugLineNum = 117;BA.debugLine="ProgressDialogShow(\"Loading...\")";
Debug.ShouldStop(1048576);
citizen.mostCurrent.__c.runVoidMethod ("ProgressDialogShow",citizen.mostCurrent.activityBA,(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Loading..."))));
 BA.debugLineNum = 118;BA.debugLine="Dim Size As Int";
Debug.ShouldStop(2097152);
_size = RemoteObject.createImmutable(0);Debug.locals.put("Size", _size);
 BA.debugLineNum = 119;BA.debugLine="Size=ListView1.Size";
Debug.ShouldStop(4194304);
_size = citizen.mostCurrent._listview1.runMethod(true,"getSize");Debug.locals.put("Size", _size);
 BA.debugLineNum = 120;BA.debugLine="Log(\"Jumlah Data: \" & Size)";
Debug.ShouldStop(8388608);
citizen.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("Jumlah Data: "),_size)));
 BA.debugLineNum = 122;BA.debugLine="For x= Size To 0 Step -1";
Debug.ShouldStop(33554432);
{
final int step9 = -1;
final int limit9 = 0;
_x = _size.<Integer>get().intValue() ;
for (;(step9 > 0 && _x <= limit9) || (step9 < 0 && _x >= limit9) ;_x = ((int)(0 + _x + step9))  ) {
Debug.locals.put("x", _x);
 BA.debugLineNum = 123;BA.debugLine="If x==0 Then";
Debug.ShouldStop(67108864);
if (RemoteObject.solveBoolean("=",RemoteObject.createImmutable(_x),BA.numberCast(double.class, 0))) { 
 }else {
 BA.debugLineNum = 126;BA.debugLine="ListView1.RemoveAt(x-1)";
Debug.ShouldStop(536870912);
citizen.mostCurrent._listview1.runVoidMethod ("RemoveAt",(Object)(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_x),RemoteObject.createImmutable(1)}, "-",1, 1)));
 };
 }
}Debug.locals.put("x", _x);
;
 BA.debugLineNum = 129;BA.debugLine="End Sub";
Debug.ShouldStop(1);
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
 //BA.debugLineNum = 15;BA.debugLine="Dim pnlInput, pnlSelect, PanelMain As Panel";
citizen.mostCurrent._pnlinput = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
citizen.mostCurrent._pnlselect = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
citizen.mostCurrent._panelmain = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 16;BA.debugLine="Dim mh1,mh2,mw1,mw2 As Float";
citizen._mh1 = RemoteObject.createImmutable(0f);
citizen._mh2 = RemoteObject.createImmutable(0f);
citizen._mw1 = RemoteObject.createImmutable(0f);
citizen._mw2 = RemoteObject.createImmutable(0f);
 //BA.debugLineNum = 17;BA.debugLine="Dim domain As String";
citizen.mostCurrent._domain = RemoteObject.createImmutable("");
 //BA.debugLineNum = 18;BA.debugLine="Dim job2 As HttpJob";
citizen.mostCurrent._job2 = RemoteObject.createNew ("anywheresoftware.b4a.samples.httputils2.httpjob");
 //BA.debugLineNum = 20;BA.debugLine="domain=\"https://b9312448.ngrok.io/\"";
citizen.mostCurrent._domain = BA.ObjectToString("https://b9312448.ngrok.io/");
 //BA.debugLineNum = 22;BA.debugLine="Private Label10 As Label";
citizen.mostCurrent._label10 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 23;BA.debugLine="Private Label11 As Label";
citizen.mostCurrent._label11 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Private EditText1 As EditText";
citizen.mostCurrent._edittext1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 25;BA.debugLine="Private ListView1 As ListView";
citizen.mostCurrent._listview1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ListViewWrapper");
 //BA.debugLineNum = 26;BA.debugLine="Private Label12 As Label";
citizen.mostCurrent._label12 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 27;BA.debugLine="Private ScrollView1 As ScrollView";
citizen.mostCurrent._scrollview1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ScrollViewWrapper");
 //BA.debugLineNum = 28;BA.debugLine="Private Button1 As Button";
citizen.mostCurrent._button1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 29;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _jobdone(RemoteObject _job) throws Exception{
try {
		Debug.PushSubsStack("JobDone (citizen) ","citizen",10,citizen.mostCurrent.activityBA,citizen.mostCurrent,50);
if (RapidSub.canDelegate("jobdone")) { return b4a.example.citizen.remoteMe.runUserSub(false, "citizen","jobdone", _job);}
RemoteObject _parser = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser");
RemoteObject _root = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _features = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _colfeatures = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _properties = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _fcn = RemoteObject.createImmutable("");
RemoteObject _fcc = RemoteObject.createImmutable("");
RemoteObject _nik = RemoteObject.createImmutable("");
RemoteObject _clan_name = RemoteObject.createImmutable("");
RemoteObject _citizen_name = RemoteObject.createImmutable("");
RemoteObject _address = RemoteObject.createImmutable("");
RemoteObject _gender = RemoteObject.createImmutable("");
RemoteObject _phone = RemoteObject.createImmutable("");
RemoteObject _cs_name = RemoteObject.createImmutable("");
RemoteObject _born_date = RemoteObject.createImmutable("");
Debug.locals.put("Job", _job);
 BA.debugLineNum = 50;BA.debugLine="Sub JobDone (Job As HttpJob)";
Debug.ShouldStop(131072);
 BA.debugLineNum = 52;BA.debugLine="Log(\"JobName = \" & Job.JobName & \", Success = \" &";
Debug.ShouldStop(524288);
citizen.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("JobName = "),_job.getField(true,"_jobname"),RemoteObject.createImmutable(", Success = "),_job.getField(true,"_success"))));
 BA.debugLineNum = 53;BA.debugLine="If Job.Success = True Then";
Debug.ShouldStop(1048576);
if (RemoteObject.solveBoolean("=",_job.getField(true,"_success"),citizen.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 54;BA.debugLine="ProgressDialogHide";
Debug.ShouldStop(2097152);
citizen.mostCurrent.__c.runVoidMethod ("ProgressDialogHide");
 BA.debugLineNum = 56;BA.debugLine="Select Job.JobName";
Debug.ShouldStop(8388608);
switch (BA.switchObjectToInt(_job.getField(true,"_jobname"),BA.ObjectToString("Job2"),BA.ObjectToString("Job3"))) {
case 0: {
 BA.debugLineNum = 58;BA.debugLine="Dim parser As JSONParser";
Debug.ShouldStop(33554432);
_parser = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("parser", _parser);
 BA.debugLineNum = 59;BA.debugLine="parser.Initialize(Job.GetString)";
Debug.ShouldStop(67108864);
_parser.runVoidMethod ("Initialize",(Object)(_job.runMethod(true,"_getstring")));
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
final RemoteObject group10 = _features;
final int groupLen10 = group10.runMethod(true,"getSize").<Integer>get()
;int index10 = 0;
;
for (; index10 < groupLen10;index10++){
_colfeatures.setObject(group10.runMethod(false,"Get",index10));
Debug.locals.put("colfeatures", _colfeatures);
 BA.debugLineNum = 63;BA.debugLine="Dim properties As Map = colfeatures.Get(\"prop";
Debug.ShouldStop(1073741824);
_properties = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_properties.setObject(_colfeatures.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("properties")))));Debug.locals.put("properties", _properties);
 BA.debugLineNum = 64;BA.debugLine="Dim fcn As String = properties.Get(\"fcn\")";
Debug.ShouldStop(-2147483648);
_fcn = BA.ObjectToString(_properties.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("fcn")))));Debug.locals.put("fcn", _fcn);Debug.locals.put("fcn", _fcn);
 BA.debugLineNum = 65;BA.debugLine="Dim fcc As String = properties.Get(\"fcc\")";
Debug.ShouldStop(1);
_fcc = BA.ObjectToString(_properties.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("fcc")))));Debug.locals.put("fcc", _fcc);Debug.locals.put("fcc", _fcc);
 BA.debugLineNum = 67;BA.debugLine="Label10.Text=fcn";
Debug.ShouldStop(4);
citizen.mostCurrent._label10.runMethod(true,"setText",BA.ObjectToCharSequence(_fcn));
 BA.debugLineNum = 68;BA.debugLine="Label11.Text=fcc";
Debug.ShouldStop(8);
citizen.mostCurrent._label11.runMethod(true,"setText",BA.ObjectToCharSequence(_fcc));
 }
}Debug.locals.put("colfeatures", _colfeatures);
;
 BA.debugLineNum = 70;BA.debugLine="Job.Release";
Debug.ShouldStop(32);
_job.runVoidMethod ("_release");
 break; }
case 1: {
 BA.debugLineNum = 72;BA.debugLine="Dim parser As JSONParser";
Debug.ShouldStop(128);
_parser = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("parser", _parser);
 BA.debugLineNum = 73;BA.debugLine="parser.Initialize(Job.GetString)";
Debug.ShouldStop(256);
_parser.runVoidMethod ("Initialize",(Object)(_job.runMethod(true,"_getstring")));
 BA.debugLineNum = 74;BA.debugLine="Dim root As Map = parser.NextObject";
Debug.ShouldStop(512);
_root = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_root = _parser.runMethod(false,"NextObject");Debug.locals.put("root", _root);Debug.locals.put("root", _root);
 BA.debugLineNum = 75;BA.debugLine="Dim features As List = root.Get(\"features\")";
Debug.ShouldStop(1024);
_features = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_features.setObject(_root.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("features")))));Debug.locals.put("features", _features);
 BA.debugLineNum = 76;BA.debugLine="For Each colfeatures As Map In features";
Debug.ShouldStop(2048);
_colfeatures = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
{
final RemoteObject group23 = _features;
final int groupLen23 = group23.runMethod(true,"getSize").<Integer>get()
;int index23 = 0;
;
for (; index23 < groupLen23;index23++){
_colfeatures.setObject(group23.runMethod(false,"Get",index23));
Debug.locals.put("colfeatures", _colfeatures);
 BA.debugLineNum = 77;BA.debugLine="Dim properties As Map = colfeatures.Get(\"prop";
Debug.ShouldStop(4096);
_properties = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_properties.setObject(_colfeatures.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("properties")))));Debug.locals.put("properties", _properties);
 BA.debugLineNum = 78;BA.debugLine="Dim nik As String = properties.Get(\"nik\")";
Debug.ShouldStop(8192);
_nik = BA.ObjectToString(_properties.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("nik")))));Debug.locals.put("nik", _nik);Debug.locals.put("nik", _nik);
 BA.debugLineNum = 79;BA.debugLine="Dim clan_name As String = properties.Get(\"cla";
Debug.ShouldStop(16384);
_clan_name = BA.ObjectToString(_properties.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("clan_name")))));Debug.locals.put("clan_name", _clan_name);Debug.locals.put("clan_name", _clan_name);
 BA.debugLineNum = 80;BA.debugLine="Dim citizen_name As String = properties.Get(\"";
Debug.ShouldStop(32768);
_citizen_name = BA.ObjectToString(_properties.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("citizen_name")))));Debug.locals.put("citizen_name", _citizen_name);Debug.locals.put("citizen_name", _citizen_name);
 BA.debugLineNum = 81;BA.debugLine="Dim address As String = properties.Get(\"addre";
Debug.ShouldStop(65536);
_address = BA.ObjectToString(_properties.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("address")))));Debug.locals.put("address", _address);Debug.locals.put("address", _address);
 BA.debugLineNum = 82;BA.debugLine="Dim gender As String = properties.Get(\"gender";
Debug.ShouldStop(131072);
_gender = BA.ObjectToString(_properties.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("gender")))));Debug.locals.put("gender", _gender);Debug.locals.put("gender", _gender);
 BA.debugLineNum = 83;BA.debugLine="Dim phone As String = properties.Get(\"phone\")";
Debug.ShouldStop(262144);
_phone = BA.ObjectToString(_properties.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("phone")))));Debug.locals.put("phone", _phone);Debug.locals.put("phone", _phone);
 BA.debugLineNum = 84;BA.debugLine="Dim cs_name As String = properties.Get(\"cs_na";
Debug.ShouldStop(524288);
_cs_name = BA.ObjectToString(_properties.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("cs_name")))));Debug.locals.put("cs_name", _cs_name);Debug.locals.put("cs_name", _cs_name);
 BA.debugLineNum = 85;BA.debugLine="Dim born_date As String = properties.Get(\"bor";
Debug.ShouldStop(1048576);
_born_date = BA.ObjectToString(_properties.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("born_date")))));Debug.locals.put("born_date", _born_date);Debug.locals.put("born_date", _born_date);
 }
}Debug.locals.put("colfeatures", _colfeatures);
;
 BA.debugLineNum = 90;BA.debugLine="ListView1.AddSingleLine(nik)";
Debug.ShouldStop(33554432);
citizen.mostCurrent._listview1.runVoidMethod ("AddSingleLine",(Object)(BA.ObjectToCharSequence(_nik)));
 BA.debugLineNum = 91;BA.debugLine="ListView1.AddSingleLine(\"Land Owning\")";
Debug.ShouldStop(67108864);
citizen.mostCurrent._listview1.runVoidMethod ("AddSingleLine",(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Land Owning"))));
 BA.debugLineNum = 92;BA.debugLine="ListView1.AddSingleLine(\"Building Owning\")";
Debug.ShouldStop(134217728);
citizen.mostCurrent._listview1.runVoidMethod ("AddSingleLine",(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Building Owning"))));
 BA.debugLineNum = 93;BA.debugLine="ListView1.SingleLineLayout.Label.TextSize=20";
Debug.ShouldStop(268435456);
citizen.mostCurrent._listview1.runMethod(false,"getSingleLineLayout").getField(false,"Label").runMethod(true,"setTextSize",BA.numberCast(float.class, 20));
 BA.debugLineNum = 94;BA.debugLine="ListView1.SingleLineLayout.ItemHeight = 24dip";
Debug.ShouldStop(536870912);
citizen.mostCurrent._listview1.runMethod(false,"getSingleLineLayout").runMethod(true,"setItemHeight",citizen.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 24))));
 BA.debugLineNum = 95;BA.debugLine="ListView1.SingleLineLayout.Label.TextColor = C";
Debug.ShouldStop(1073741824);
citizen.mostCurrent._listview1.runMethod(false,"getSingleLineLayout").getField(false,"Label").runMethod(true,"setTextColor",citizen.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 96;BA.debugLine="ListView1.SingleLineLayout.Label.Gravity=Gravi";
Debug.ShouldStop(-2147483648);
citizen.mostCurrent._listview1.runMethod(false,"getSingleLineLayout").getField(false,"Label").runMethod(true,"setGravity",citizen.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER_HORIZONTAL"));
 BA.debugLineNum = 98;BA.debugLine="Job.Release";
Debug.ShouldStop(2);
_job.runVoidMethod ("_release");
 break; }
}
;
 }else {
 BA.debugLineNum = 101;BA.debugLine="Log(\"Error: \" & Job.ErrorMessage)";
Debug.ShouldStop(16);
citizen.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("Error: "),_job.getField(true,"_errormessage"))));
 BA.debugLineNum = 102;BA.debugLine="ToastMessageShow(\"Error: \" & Job.ErrorMessage, T";
Debug.ShouldStop(32);
citizen.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Error: "),_job.getField(true,"_errormessage")))),(Object)(citizen.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 103;BA.debugLine="Job.Release";
Debug.ShouldStop(64);
_job.runVoidMethod ("_release");
 };
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
public static RemoteObject  _listview1_itemclick(RemoteObject _position,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("ListView1_ItemClick (citizen) ","citizen",10,citizen.mostCurrent.activityBA,citizen.mostCurrent,161);
if (RapidSub.canDelegate("listview1_itemclick")) { return b4a.example.citizen.remoteMe.runUserSub(false, "citizen","listview1_itemclick", _position, _value);}
Debug.locals.put("Position", _position);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 161;BA.debugLine="Sub ListView1_ItemClick (Position As Int, Value As";
Debug.ShouldStop(1);
 BA.debugLineNum = 162;BA.debugLine="Button1.Visible=False";
Debug.ShouldStop(2);
citizen.mostCurrent._button1.runMethod(true,"setVisible",citizen.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 166;BA.debugLine="PanPop(\"cpanel.bal\", 20, 10,Value)";
Debug.ShouldStop(32);
_panpop(BA.ObjectToString("cpanel.bal"),BA.numberCast(int.class, 20),BA.numberCast(int.class, 10),BA.ObjectToString(_value));
 BA.debugLineNum = 168;BA.debugLine="Log(\"Data yang diklik: \" & Value)";
Debug.ShouldStop(128);
citizen.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("Data yang diklik: "),_value)));
 BA.debugLineNum = 174;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _panpop(RemoteObject _mlayout,RemoteObject _hc,RemoteObject _wc,RemoteObject _nik) throws Exception{
try {
		Debug.PushSubsStack("PanPop (citizen) ","citizen",10,citizen.mostCurrent.activityBA,citizen.mostCurrent,132);
if (RapidSub.canDelegate("panpop")) { return b4a.example.citizen.remoteMe.runUserSub(false, "citizen","panpop", _mlayout, _hc, _wc, _nik);}
Debug.locals.put("mlayout", _mlayout);
Debug.locals.put("hc", _hc);
Debug.locals.put("wc", _wc);
Debug.locals.put("NIK", _nik);
 BA.debugLineNum = 132;BA.debugLine="Sub PanPop (mlayout As String, hc As Int, wc As In";
Debug.ShouldStop(8);
 BA.debugLineNum = 134;BA.debugLine="pnlSelect.Initialize ( \"Select\")";
Debug.ShouldStop(32);
citizen.mostCurrent._pnlselect.runVoidMethod ("Initialize",citizen.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("Select")));
 BA.debugLineNum = 135;BA.debugLine="pnlInput.Initialize (\"\")";
Debug.ShouldStop(64);
citizen.mostCurrent._pnlinput.runVoidMethod ("Initialize",citizen.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 136;BA.debugLine="pnlInput.LoadLayout ( mlayout )";
Debug.ShouldStop(128);
citizen.mostCurrent._pnlinput.runMethodAndSync(false,"LoadLayout",(Object)(_mlayout),citizen.mostCurrent.activityBA);
 BA.debugLineNum = 138;BA.debugLine="pnlSelect.BringToFront";
Debug.ShouldStop(512);
citizen.mostCurrent._pnlselect.runVoidMethod ("BringToFront");
 BA.debugLineNum = 139;BA.debugLine="pnlSelect.Color  = Colors.ARGB (150,0,0,0)";
Debug.ShouldStop(1024);
citizen.mostCurrent._pnlselect.runVoidMethod ("setColor",citizen.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 150)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0))));
 BA.debugLineNum = 140;BA.debugLine="Activity.AddView (pnlSelect, 0, 0,   100%x, 100%y";
Debug.ShouldStop(2048);
citizen.mostCurrent._activity.runVoidMethod ("AddView",(Object)((citizen.mostCurrent._pnlselect.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(citizen.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),citizen.mostCurrent.activityBA)),(Object)(citizen.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),citizen.mostCurrent.activityBA)));
 BA.debugLineNum = 141;BA.debugLine="mh1=(pnlSelect.Height/2) - (PanelMain.Height/2) +";
Debug.ShouldStop(4096);
citizen._mh1 = BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {citizen.mostCurrent._pnlselect.runMethod(true,"getHeight"),RemoteObject.createImmutable(2)}, "/",0, 0)),(RemoteObject.solve(new RemoteObject[] {citizen.mostCurrent._panelmain.runMethod(true,"getHeight"),RemoteObject.createImmutable(2)}, "/",0, 0)),_hc}, "-+",2, 0));
 BA.debugLineNum = 142;BA.debugLine="mw1=pnlSelect.Width/2 - (PanelMain.Width/2) + wc";
Debug.ShouldStop(8192);
citizen._mw1 = BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {citizen.mostCurrent._pnlselect.runMethod(true,"getWidth"),RemoteObject.createImmutable(2),(RemoteObject.solve(new RemoteObject[] {citizen.mostCurrent._panelmain.runMethod(true,"getWidth"),RemoteObject.createImmutable(2)}, "/",0, 0)),_wc}, "/-+",2, 0));
 BA.debugLineNum = 143;BA.debugLine="mh2=PanelMain.Height";
Debug.ShouldStop(16384);
citizen._mh2 = BA.numberCast(float.class, citizen.mostCurrent._panelmain.runMethod(true,"getHeight"));
 BA.debugLineNum = 144;BA.debugLine="mw2=PanelMain.Width";
Debug.ShouldStop(32768);
citizen._mw2 = BA.numberCast(float.class, citizen.mostCurrent._panelmain.runMethod(true,"getWidth"));
 BA.debugLineNum = 145;BA.debugLine="pnlSelect.AddView (pnlInput, mw1, mh1, mw2, mh2)";
Debug.ShouldStop(65536);
citizen.mostCurrent._pnlselect.runVoidMethod ("AddView",(Object)((citizen.mostCurrent._pnlinput.getObject())),(Object)(BA.numberCast(int.class, citizen._mw1)),(Object)(BA.numberCast(int.class, citizen._mh1)),(Object)(BA.numberCast(int.class, citizen._mw2)),(Object)(BA.numberCast(int.class, citizen._mh2)));
 BA.debugLineNum = 153;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
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
public static RemoteObject  _select_click() throws Exception{
try {
		Debug.PushSubsStack("Select_Click (citizen) ","citizen",10,citizen.mostCurrent.activityBA,citizen.mostCurrent,155);
if (RapidSub.canDelegate("select_click")) { return b4a.example.citizen.remoteMe.runUserSub(false, "citizen","select_click");}
 BA.debugLineNum = 155;BA.debugLine="Sub Select_Click ' Stop clicks on Select panel get";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 157;BA.debugLine="pnlSelect.RemoveView";
Debug.ShouldStop(268435456);
citizen.mostCurrent._pnlselect.runVoidMethod ("RemoveView");
 BA.debugLineNum = 158;BA.debugLine="Button1.Visible=True";
Debug.ShouldStop(536870912);
citizen.mostCurrent._button1.runMethod(true,"setVisible",citizen.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 159;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}
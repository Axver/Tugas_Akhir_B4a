package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class citizen_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (citizen) ","citizen",10,citizen.mostCurrent.activityBA,citizen.mostCurrent,44);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.citizen.remoteMe.runUserSub(false, "citizen","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 44;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(2048);
 BA.debugLineNum = 46;BA.debugLine="Activity.LoadLayout(\"citizen\")";
Debug.ShouldStop(8192);
citizen.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("citizen")),citizen.mostCurrent.activityBA);
 BA.debugLineNum = 47;BA.debugLine="job2.Initialize(\"Job2\", Me)";
Debug.ShouldStop(16384);
citizen.mostCurrent._job2.runVoidMethod ("_initialize",citizen.processBA,(Object)(BA.ObjectToString("Job2")),(Object)(citizen.getObject()));
 BA.debugLineNum = 48;BA.debugLine="job2.PostString(domain&\"ta_v2/endpoint/countFcn.p";
Debug.ShouldStop(32768);
citizen.mostCurrent._job2.runVoidMethod ("_poststring",(Object)(RemoteObject.concat(citizen.mostCurrent._domain,RemoteObject.createImmutable("ta_v2/endpoint/countFcn.php"))),(Object)(RemoteObject.concat(RemoteObject.createImmutable("send=test"),RemoteObject.createImmutable("&data=test"))));
 BA.debugLineNum = 49;BA.debugLine="ProgressDialogShow(\"Loading...\")";
Debug.ShouldStop(65536);
citizen.mostCurrent.__c.runVoidMethod ("ProgressDialogShow",citizen.mostCurrent.activityBA,(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Loading..."))));
 BA.debugLineNum = 51;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
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
		Debug.PushSubsStack("Activity_Pause (citizen) ","citizen",10,citizen.mostCurrent.activityBA,citizen.mostCurrent,59);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.citizen.remoteMe.runUserSub(false, "citizen","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 59;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 61;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
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
		Debug.PushSubsStack("Activity_Resume (citizen) ","citizen",10,citizen.mostCurrent.activityBA,citizen.mostCurrent,53);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.citizen.remoteMe.runUserSub(false, "citizen","activity_resume");}
 BA.debugLineNum = 53;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 54;BA.debugLine="job2.Initialize(\"Job2\", Me)";
Debug.ShouldStop(2097152);
citizen.mostCurrent._job2.runVoidMethod ("_initialize",citizen.processBA,(Object)(BA.ObjectToString("Job2")),(Object)(citizen.getObject()));
 BA.debugLineNum = 55;BA.debugLine="job2.PostString(domain&\"ta_v2/endpoint/countFcn.p";
Debug.ShouldStop(4194304);
citizen.mostCurrent._job2.runVoidMethod ("_poststring",(Object)(RemoteObject.concat(citizen.mostCurrent._domain,RemoteObject.createImmutable("ta_v2/endpoint/countFcn.php"))),(Object)(RemoteObject.concat(RemoteObject.createImmutable("send=test"),RemoteObject.createImmutable("&data=test"))));
 BA.debugLineNum = 56;BA.debugLine="ProgressDialogShow(\"Loading...\")";
Debug.ShouldStop(8388608);
citizen.mostCurrent.__c.runVoidMethod ("ProgressDialogShow",citizen.mostCurrent.activityBA,(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Loading..."))));
 BA.debugLineNum = 57;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
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
		Debug.PushSubsStack("Button1_Click (citizen) ","citizen",10,citizen.mostCurrent.activityBA,citizen.mostCurrent,143);
if (RapidSub.canDelegate("button1_click")) { return b4a.example.citizen.remoteMe.runUserSub(false, "citizen","button1_click");}
RemoteObject _citizen_id = RemoteObject.createImmutable("");
RemoteObject _size = RemoteObject.createImmutable(0);
int _x = 0;
 BA.debugLineNum = 143;BA.debugLine="Sub Button1_Click";
Debug.ShouldStop(16384);
 BA.debugLineNum = 144;BA.debugLine="Dim citizen_id As String";
Debug.ShouldStop(32768);
_citizen_id = RemoteObject.createImmutable("");Debug.locals.put("citizen_id", _citizen_id);
 BA.debugLineNum = 145;BA.debugLine="citizen_id=EditText1.Text";
Debug.ShouldStop(65536);
_citizen_id = citizen.mostCurrent._edittext1.runMethod(true,"getText");Debug.locals.put("citizen_id", _citizen_id);
 BA.debugLineNum = 147;BA.debugLine="job2.Initialize(\"Job3\", Me)";
Debug.ShouldStop(262144);
citizen.mostCurrent._job2.runVoidMethod ("_initialize",citizen.processBA,(Object)(BA.ObjectToString("Job3")),(Object)(citizen.getObject()));
 BA.debugLineNum = 148;BA.debugLine="job2.PostString(domain&\"ta_v2/endpoint/citizen_se";
Debug.ShouldStop(524288);
citizen.mostCurrent._job2.runVoidMethod ("_poststring",(Object)(RemoteObject.concat(citizen.mostCurrent._domain,RemoteObject.createImmutable("ta_v2/endpoint/citizen_search.php"))),(Object)(RemoteObject.concat(RemoteObject.createImmutable("citizen_id="),_citizen_id)));
 BA.debugLineNum = 149;BA.debugLine="ProgressDialogShow(\"Loading...\")";
Debug.ShouldStop(1048576);
citizen.mostCurrent.__c.runVoidMethod ("ProgressDialogShow",citizen.mostCurrent.activityBA,(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Loading..."))));
 BA.debugLineNum = 150;BA.debugLine="Dim Size As Int";
Debug.ShouldStop(2097152);
_size = RemoteObject.createImmutable(0);Debug.locals.put("Size", _size);
 BA.debugLineNum = 151;BA.debugLine="Size=ListView1.Size";
Debug.ShouldStop(4194304);
_size = citizen.mostCurrent._listview1.runMethod(true,"getSize");Debug.locals.put("Size", _size);
 BA.debugLineNum = 152;BA.debugLine="Log(\"Jumlah Data: \" & Size)";
Debug.ShouldStop(8388608);
citizen.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("Jumlah Data: "),_size)));
 BA.debugLineNum = 154;BA.debugLine="For x= Size To 0 Step -1";
Debug.ShouldStop(33554432);
{
final int step9 = -1;
final int limit9 = 0;
_x = _size.<Integer>get().intValue() ;
for (;(step9 > 0 && _x <= limit9) || (step9 < 0 && _x >= limit9) ;_x = ((int)(0 + _x + step9))  ) {
Debug.locals.put("x", _x);
 BA.debugLineNum = 155;BA.debugLine="If x==0 Then";
Debug.ShouldStop(67108864);
if (RemoteObject.solveBoolean("=",RemoteObject.createImmutable(_x),BA.numberCast(double.class, 0))) { 
 }else {
 BA.debugLineNum = 158;BA.debugLine="ListView1.RemoveAt(x-1)";
Debug.ShouldStop(536870912);
citizen.mostCurrent._listview1.runVoidMethod ("RemoveAt",(Object)(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_x),RemoteObject.createImmutable(1)}, "-",1, 1)));
 };
 }
}Debug.locals.put("x", _x);
;
 BA.debugLineNum = 161;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 15;BA.debugLine="Dim pnlInput, pnlSelect, PanelMain,PanelMain1 As";
citizen.mostCurrent._pnlinput = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
citizen.mostCurrent._pnlselect = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
citizen.mostCurrent._panelmain = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
citizen.mostCurrent._panelmain1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 16;BA.debugLine="Dim mh1,mh2,mw1,mw2 As Float";
citizen._mh1 = RemoteObject.createImmutable(0f);
citizen._mh2 = RemoteObject.createImmutable(0f);
citizen._mw1 = RemoteObject.createImmutable(0f);
citizen._mw2 = RemoteObject.createImmutable(0f);
 //BA.debugLineNum = 17;BA.debugLine="Dim domain As String";
citizen.mostCurrent._domain = RemoteObject.createImmutable("");
 //BA.debugLineNum = 18;BA.debugLine="Dim job2 As HttpJob";
citizen.mostCurrent._job2 = RemoteObject.createNew ("anywheresoftware.b4a.samples.httputils2.httpjob");
 //BA.debugLineNum = 19;BA.debugLine="Dim wv1 As WebView";
citizen.mostCurrent._wv1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.WebViewWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Dim citizen_name_g As String";
citizen.mostCurrent._citizen_name_g = RemoteObject.createImmutable("");
 //BA.debugLineNum = 22;BA.debugLine="Dim clan_g As String";
citizen.mostCurrent._clan_g = RemoteObject.createImmutable("");
 //BA.debugLineNum = 23;BA.debugLine="Dim gender_g As String";
citizen.mostCurrent._gender_g = RemoteObject.createImmutable("");
 //BA.debugLineNum = 24;BA.debugLine="Dim phone_g As String";
citizen.mostCurrent._phone_g = RemoteObject.createImmutable("");
 //BA.debugLineNum = 25;BA.debugLine="Dim status_g As String";
citizen.mostCurrent._status_g = RemoteObject.createImmutable("");
 //BA.debugLineNum = 28;BA.debugLine="domain=\"http://ca024f23.ngrok.io/\"";
citizen.mostCurrent._domain = BA.ObjectToString("http://ca024f23.ngrok.io/");
 //BA.debugLineNum = 30;BA.debugLine="Private Label10 As Label";
citizen.mostCurrent._label10 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 31;BA.debugLine="Private Label11 As Label";
citizen.mostCurrent._label11 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 32;BA.debugLine="Private EditText1 As EditText";
citizen.mostCurrent._edittext1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 33;BA.debugLine="Private ListView1 As ListView";
citizen.mostCurrent._listview1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ListViewWrapper");
 //BA.debugLineNum = 34;BA.debugLine="Private Label12 As Label";
citizen.mostCurrent._label12 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 35;BA.debugLine="Private ScrollView1 As ScrollView";
citizen.mostCurrent._scrollview1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ScrollViewWrapper");
 //BA.debugLineNum = 36;BA.debugLine="Private Button1 As Button";
citizen.mostCurrent._button1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 37;BA.debugLine="Private Label1 As Label";
citizen.mostCurrent._label1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 38;BA.debugLine="Private Label2 As Label";
citizen.mostCurrent._label2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 39;BA.debugLine="Private Label3 As Label";
citizen.mostCurrent._label3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 40;BA.debugLine="Private Label4 As Label";
citizen.mostCurrent._label4 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 41;BA.debugLine="Private Label5 As Label";
citizen.mostCurrent._label5 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 42;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _jobdone(RemoteObject _job) throws Exception{
try {
		Debug.PushSubsStack("JobDone (citizen) ","citizen",10,citizen.mostCurrent.activityBA,citizen.mostCurrent,63);
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
RemoteObject _status_name = RemoteObject.createImmutable("");
Debug.locals.put("Job", _job);
 BA.debugLineNum = 63;BA.debugLine="Sub JobDone (Job As HttpJob)";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 65;BA.debugLine="Log(\"JobName = \" & Job.JobName & \", Success = \" &";
Debug.ShouldStop(1);
citizen.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("JobName = "),_job.getField(true,"_jobname"),RemoteObject.createImmutable(", Success = "),_job.getField(true,"_success"))));
 BA.debugLineNum = 66;BA.debugLine="If Job.Success = True Then";
Debug.ShouldStop(2);
if (RemoteObject.solveBoolean("=",_job.getField(true,"_success"),citizen.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 67;BA.debugLine="ProgressDialogHide";
Debug.ShouldStop(4);
citizen.mostCurrent.__c.runVoidMethod ("ProgressDialogHide");
 BA.debugLineNum = 69;BA.debugLine="Select Job.JobName";
Debug.ShouldStop(16);
switch (BA.switchObjectToInt(_job.getField(true,"_jobname"),BA.ObjectToString("Job2"),BA.ObjectToString("Job3"),BA.ObjectToString("Job4"))) {
case 0: {
 BA.debugLineNum = 71;BA.debugLine="Dim parser As JSONParser";
Debug.ShouldStop(64);
_parser = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("parser", _parser);
 BA.debugLineNum = 72;BA.debugLine="parser.Initialize(Job.GetString)";
Debug.ShouldStop(128);
_parser.runVoidMethod ("Initialize",(Object)(_job.runMethod(true,"_getstring")));
 BA.debugLineNum = 73;BA.debugLine="Dim root As Map = parser.NextObject";
Debug.ShouldStop(256);
_root = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_root = _parser.runMethod(false,"NextObject");Debug.locals.put("root", _root);Debug.locals.put("root", _root);
 BA.debugLineNum = 74;BA.debugLine="Dim features As List = root.Get(\"features\")";
Debug.ShouldStop(512);
_features = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_features.setObject(_root.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("features")))));Debug.locals.put("features", _features);
 BA.debugLineNum = 75;BA.debugLine="For Each colfeatures As Map In features";
Debug.ShouldStop(1024);
_colfeatures = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
{
final RemoteObject group10 = _features;
final int groupLen10 = group10.runMethod(true,"getSize").<Integer>get()
;int index10 = 0;
;
for (; index10 < groupLen10;index10++){
_colfeatures.setObject(group10.runMethod(false,"Get",index10));
Debug.locals.put("colfeatures", _colfeatures);
 BA.debugLineNum = 76;BA.debugLine="Dim properties As Map = colfeatures.Get(\"prop";
Debug.ShouldStop(2048);
_properties = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_properties.setObject(_colfeatures.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("properties")))));Debug.locals.put("properties", _properties);
 BA.debugLineNum = 77;BA.debugLine="Dim fcn As String = properties.Get(\"fcn\")";
Debug.ShouldStop(4096);
_fcn = BA.ObjectToString(_properties.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("fcn")))));Debug.locals.put("fcn", _fcn);Debug.locals.put("fcn", _fcn);
 BA.debugLineNum = 78;BA.debugLine="Dim fcc As String = properties.Get(\"fcc\")";
Debug.ShouldStop(8192);
_fcc = BA.ObjectToString(_properties.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("fcc")))));Debug.locals.put("fcc", _fcc);Debug.locals.put("fcc", _fcc);
 BA.debugLineNum = 80;BA.debugLine="Label10.Text=fcn";
Debug.ShouldStop(32768);
citizen.mostCurrent._label10.runMethod(true,"setText",BA.ObjectToCharSequence(_fcn));
 BA.debugLineNum = 81;BA.debugLine="Label11.Text=fcc";
Debug.ShouldStop(65536);
citizen.mostCurrent._label11.runMethod(true,"setText",BA.ObjectToCharSequence(_fcc));
 }
}Debug.locals.put("colfeatures", _colfeatures);
;
 BA.debugLineNum = 83;BA.debugLine="Job.Release";
Debug.ShouldStop(262144);
_job.runVoidMethod ("_release");
 break; }
case 1: {
 BA.debugLineNum = 85;BA.debugLine="Dim parser As JSONParser";
Debug.ShouldStop(1048576);
_parser = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("parser", _parser);
 BA.debugLineNum = 86;BA.debugLine="parser.Initialize(Job.GetString)";
Debug.ShouldStop(2097152);
_parser.runVoidMethod ("Initialize",(Object)(_job.runMethod(true,"_getstring")));
 BA.debugLineNum = 87;BA.debugLine="Dim root As Map = parser.NextObject";
Debug.ShouldStop(4194304);
_root = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_root = _parser.runMethod(false,"NextObject");Debug.locals.put("root", _root);Debug.locals.put("root", _root);
 BA.debugLineNum = 88;BA.debugLine="Dim features As List = root.Get(\"features\")";
Debug.ShouldStop(8388608);
_features = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_features.setObject(_root.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("features")))));Debug.locals.put("features", _features);
 BA.debugLineNum = 89;BA.debugLine="For Each colfeatures As Map In features";
Debug.ShouldStop(16777216);
_colfeatures = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
{
final RemoteObject group23 = _features;
final int groupLen23 = group23.runMethod(true,"getSize").<Integer>get()
;int index23 = 0;
;
for (; index23 < groupLen23;index23++){
_colfeatures.setObject(group23.runMethod(false,"Get",index23));
Debug.locals.put("colfeatures", _colfeatures);
 BA.debugLineNum = 90;BA.debugLine="Dim properties As Map = colfeatures.Get(\"prop";
Debug.ShouldStop(33554432);
_properties = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_properties.setObject(_colfeatures.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("properties")))));Debug.locals.put("properties", _properties);
 BA.debugLineNum = 91;BA.debugLine="Dim nik As String = properties.Get(\"nik\")";
Debug.ShouldStop(67108864);
_nik = BA.ObjectToString(_properties.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("nik")))));Debug.locals.put("nik", _nik);Debug.locals.put("nik", _nik);
 BA.debugLineNum = 92;BA.debugLine="Dim clan_name As String = properties.Get(\"cla";
Debug.ShouldStop(134217728);
_clan_name = BA.ObjectToString(_properties.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("clan_name")))));Debug.locals.put("clan_name", _clan_name);Debug.locals.put("clan_name", _clan_name);
 BA.debugLineNum = 93;BA.debugLine="Dim citizen_name As String = properties.Get(\"";
Debug.ShouldStop(268435456);
_citizen_name = BA.ObjectToString(_properties.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("citizen_name")))));Debug.locals.put("citizen_name", _citizen_name);Debug.locals.put("citizen_name", _citizen_name);
 BA.debugLineNum = 94;BA.debugLine="Dim address As String = properties.Get(\"addre";
Debug.ShouldStop(536870912);
_address = BA.ObjectToString(_properties.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("address")))));Debug.locals.put("address", _address);Debug.locals.put("address", _address);
 BA.debugLineNum = 95;BA.debugLine="Dim gender As String = properties.Get(\"gender";
Debug.ShouldStop(1073741824);
_gender = BA.ObjectToString(_properties.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("gender")))));Debug.locals.put("gender", _gender);Debug.locals.put("gender", _gender);
 BA.debugLineNum = 96;BA.debugLine="Dim phone As String = properties.Get(\"phone\")";
Debug.ShouldStop(-2147483648);
_phone = BA.ObjectToString(_properties.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("phone")))));Debug.locals.put("phone", _phone);Debug.locals.put("phone", _phone);
 BA.debugLineNum = 97;BA.debugLine="Dim cs_name As String = properties.Get(\"cs_na";
Debug.ShouldStop(1);
_cs_name = BA.ObjectToString(_properties.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("cs_name")))));Debug.locals.put("cs_name", _cs_name);Debug.locals.put("cs_name", _cs_name);
 BA.debugLineNum = 98;BA.debugLine="Dim born_date As String = properties.Get(\"bor";
Debug.ShouldStop(2);
_born_date = BA.ObjectToString(_properties.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("born_date")))));Debug.locals.put("born_date", _born_date);Debug.locals.put("born_date", _born_date);
 }
}Debug.locals.put("colfeatures", _colfeatures);
;
 BA.debugLineNum = 103;BA.debugLine="ListView1.AddSingleLine(nik)";
Debug.ShouldStop(64);
citizen.mostCurrent._listview1.runVoidMethod ("AddSingleLine",(Object)(BA.ObjectToCharSequence(_nik)));
 BA.debugLineNum = 104;BA.debugLine="ListView1.AddSingleLine(\"Land Owning\")";
Debug.ShouldStop(128);
citizen.mostCurrent._listview1.runVoidMethod ("AddSingleLine",(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Land Owning"))));
 BA.debugLineNum = 105;BA.debugLine="ListView1.AddSingleLine(\"Building Owning\")";
Debug.ShouldStop(256);
citizen.mostCurrent._listview1.runVoidMethod ("AddSingleLine",(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Building Owning"))));
 BA.debugLineNum = 106;BA.debugLine="ListView1.SingleLineLayout.Label.TextSize=20";
Debug.ShouldStop(512);
citizen.mostCurrent._listview1.runMethod(false,"getSingleLineLayout").getField(false,"Label").runMethod(true,"setTextSize",BA.numberCast(float.class, 20));
 BA.debugLineNum = 107;BA.debugLine="ListView1.SingleLineLayout.ItemHeight = 24dip";
Debug.ShouldStop(1024);
citizen.mostCurrent._listview1.runMethod(false,"getSingleLineLayout").runMethod(true,"setItemHeight",citizen.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 24))));
 BA.debugLineNum = 108;BA.debugLine="ListView1.SingleLineLayout.Label.TextColor = C";
Debug.ShouldStop(2048);
citizen.mostCurrent._listview1.runMethod(false,"getSingleLineLayout").getField(false,"Label").runMethod(true,"setTextColor",citizen.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 109;BA.debugLine="ListView1.SingleLineLayout.Label.Gravity=Gravi";
Debug.ShouldStop(4096);
citizen.mostCurrent._listview1.runMethod(false,"getSingleLineLayout").getField(false,"Label").runMethod(true,"setGravity",citizen.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER_HORIZONTAL"));
 break; }
case 2: {
 BA.debugLineNum = 112;BA.debugLine="Dim parser As JSONParser";
Debug.ShouldStop(32768);
_parser = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("parser", _parser);
 BA.debugLineNum = 113;BA.debugLine="Log(Job.GetString)";
Debug.ShouldStop(65536);
citizen.mostCurrent.__c.runVoidMethod ("Log",(Object)(_job.runMethod(true,"_getstring")));
 BA.debugLineNum = 114;BA.debugLine="parser.Initialize(Job.GetString)";
Debug.ShouldStop(131072);
_parser.runVoidMethod ("Initialize",(Object)(_job.runMethod(true,"_getstring")));
 BA.debugLineNum = 115;BA.debugLine="Dim root As Map = parser.NextObject";
Debug.ShouldStop(262144);
_root = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_root = _parser.runMethod(false,"NextObject");Debug.locals.put("root", _root);Debug.locals.put("root", _root);
 BA.debugLineNum = 116;BA.debugLine="Dim nik As String = root.Get(\"nik\")";
Debug.ShouldStop(524288);
_nik = BA.ObjectToString(_root.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("nik")))));Debug.locals.put("nik", _nik);Debug.locals.put("nik", _nik);
 BA.debugLineNum = 117;BA.debugLine="Dim clan_name As String = root.Get(\"clan_name\"";
Debug.ShouldStop(1048576);
_clan_name = BA.ObjectToString(_root.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("clan_name")))));Debug.locals.put("clan_name", _clan_name);Debug.locals.put("clan_name", _clan_name);
 BA.debugLineNum = 118;BA.debugLine="Dim citizen_name As String = root.Get(\"citizen";
Debug.ShouldStop(2097152);
_citizen_name = BA.ObjectToString(_root.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("citizen_name")))));Debug.locals.put("citizen_name", _citizen_name);Debug.locals.put("citizen_name", _citizen_name);
 BA.debugLineNum = 119;BA.debugLine="Dim gender As String = root.Get(\"gender\")";
Debug.ShouldStop(4194304);
_gender = BA.ObjectToString(_root.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("gender")))));Debug.locals.put("gender", _gender);Debug.locals.put("gender", _gender);
 BA.debugLineNum = 120;BA.debugLine="Dim phone As String = root.Get(\"phone\")";
Debug.ShouldStop(8388608);
_phone = BA.ObjectToString(_root.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("phone")))));Debug.locals.put("phone", _phone);Debug.locals.put("phone", _phone);
 BA.debugLineNum = 121;BA.debugLine="Dim status_name As String = root.Get(\"status_n";
Debug.ShouldStop(16777216);
_status_name = BA.ObjectToString(_root.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("status_name")))));Debug.locals.put("status_name", _status_name);Debug.locals.put("status_name", _status_name);
 BA.debugLineNum = 122;BA.debugLine="Dim born_date As String = root.Get(\"born_date\"";
Debug.ShouldStop(33554432);
_born_date = BA.ObjectToString(_root.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("born_date")))));Debug.locals.put("born_date", _born_date);Debug.locals.put("born_date", _born_date);
 BA.debugLineNum = 124;BA.debugLine="citizen_name_g=citizen_name";
Debug.ShouldStop(134217728);
citizen.mostCurrent._citizen_name_g = _citizen_name;
 BA.debugLineNum = 125;BA.debugLine="gender_g=gender";
Debug.ShouldStop(268435456);
citizen.mostCurrent._gender_g = _gender;
 BA.debugLineNum = 126;BA.debugLine="phone_g=phone";
Debug.ShouldStop(536870912);
citizen.mostCurrent._phone_g = _phone;
 BA.debugLineNum = 127;BA.debugLine="status_g=status_name";
Debug.ShouldStop(1073741824);
citizen.mostCurrent._status_g = _status_name;
 BA.debugLineNum = 130;BA.debugLine="Job.Release";
Debug.ShouldStop(2);
_job.runVoidMethod ("_release");
 break; }
}
;
 }else {
 BA.debugLineNum = 133;BA.debugLine="Log(\"Error: \" & Job.ErrorMessage)";
Debug.ShouldStop(16);
citizen.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("Error: "),_job.getField(true,"_errormessage"))));
 BA.debugLineNum = 134;BA.debugLine="ToastMessageShow(\"Error: \" & Job.ErrorMessage, T";
Debug.ShouldStop(32);
citizen.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Error: "),_job.getField(true,"_errormessage")))),(Object)(citizen.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 135;BA.debugLine="Job.Release";
Debug.ShouldStop(64);
_job.runVoidMethod ("_release");
 };
 BA.debugLineNum = 138;BA.debugLine="End Sub";
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
		Debug.PushSubsStack("ListView1_ItemClick (citizen) ","citizen",10,citizen.mostCurrent.activityBA,citizen.mostCurrent,227);
if (RapidSub.canDelegate("listview1_itemclick")) { return b4a.example.citizen.remoteMe.runUserSub(false, "citizen","listview1_itemclick", _position, _value);}
Debug.locals.put("Position", _position);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 227;BA.debugLine="Sub ListView1_ItemClick (Position As Int, Value As";
Debug.ShouldStop(4);
 BA.debugLineNum = 228;BA.debugLine="Button1.Visible=False";
Debug.ShouldStop(8);
citizen.mostCurrent._button1.runMethod(true,"setVisible",citizen.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 234;BA.debugLine="Log(\"Data yang diklik: \" & Value)";
Debug.ShouldStop(512);
citizen.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("Data yang diklik: "),_value)));
 BA.debugLineNum = 236;BA.debugLine="If Value==\"Land Owning\" Then";
Debug.ShouldStop(2048);
if (RemoteObject.solveBoolean("=",_value,RemoteObject.createImmutable(("Land Owning")))) { 
 }else 
{ BA.debugLineNum = 238;BA.debugLine="Else If Value==\"Building Owning\" Then";
Debug.ShouldStop(8192);
if (RemoteObject.solveBoolean("=",_value,RemoteObject.createImmutable(("Building Owning")))) { 
 BA.debugLineNum = 239;BA.debugLine="PanPopBuilding(\"cpanel_building.bal\", 0, 0,Value";
Debug.ShouldStop(16384);
_panpopbuilding(BA.ObjectToString("cpanel_building.bal"),BA.numberCast(int.class, 0),BA.numberCast(int.class, 0),BA.ObjectToString(_value));
 }else {
 BA.debugLineNum = 242;BA.debugLine="job2.Initialize(\"Job4\", Me)";
Debug.ShouldStop(131072);
citizen.mostCurrent._job2.runVoidMethod ("_initialize",citizen.processBA,(Object)(BA.ObjectToString("Job4")),(Object)(citizen.getObject()));
 BA.debugLineNum = 243;BA.debugLine="job2.PostString(domain&\"ta_v2/endpoint/citizen_b";
Debug.ShouldStop(262144);
citizen.mostCurrent._job2.runVoidMethod ("_poststring",(Object)(RemoteObject.concat(citizen.mostCurrent._domain,RemoteObject.createImmutable("ta_v2/endpoint/citizen_by_nik.php"))),(Object)(RemoteObject.concat(RemoteObject.createImmutable("citizen_id="),_value)));
 BA.debugLineNum = 244;BA.debugLine="ProgressDialogShow(\"Loading...\")";
Debug.ShouldStop(524288);
citizen.mostCurrent.__c.runVoidMethod ("ProgressDialogShow",citizen.mostCurrent.activityBA,(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Loading..."))));
 BA.debugLineNum = 245;BA.debugLine="Label1.Text=\"Name:\"&citizen_name_g";
Debug.ShouldStop(1048576);
citizen.mostCurrent._label1.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Name:"),citizen.mostCurrent._citizen_name_g)));
 BA.debugLineNum = 246;BA.debugLine="Label2.Text=\"Phone:\"&phone_g";
Debug.ShouldStop(2097152);
citizen.mostCurrent._label2.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Phone:"),citizen.mostCurrent._phone_g)));
 BA.debugLineNum = 247;BA.debugLine="Label3.Text=\"Gender:\"&gender_g";
Debug.ShouldStop(4194304);
citizen.mostCurrent._label3.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Gender:"),citizen.mostCurrent._gender_g)));
 BA.debugLineNum = 248;BA.debugLine="Label4.Text=\"Status:\"&status_g";
Debug.ShouldStop(8388608);
citizen.mostCurrent._label4.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Status:"),citizen.mostCurrent._status_g)));
 BA.debugLineNum = 249;BA.debugLine="Label5.Text=\"Clan:\"&clan_g";
Debug.ShouldStop(16777216);
citizen.mostCurrent._label5.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Clan:"),citizen.mostCurrent._clan_g)));
 BA.debugLineNum = 250;BA.debugLine="ProgressDialogShow(\"Loading...\")";
Debug.ShouldStop(33554432);
citizen.mostCurrent.__c.runVoidMethod ("ProgressDialogShow",citizen.mostCurrent.activityBA,(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Loading..."))));
 BA.debugLineNum = 251;BA.debugLine="PanPop(\"cpanel.bal\", 40, 20,Value)";
Debug.ShouldStop(67108864);
_panpop(BA.ObjectToString("cpanel.bal"),BA.numberCast(int.class, 40),BA.numberCast(int.class, 20),BA.ObjectToString(_value));
 }}
;
 BA.debugLineNum = 260;BA.debugLine="End Sub";
Debug.ShouldStop(8);
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
		Debug.PushSubsStack("PanPop (citizen) ","citizen",10,citizen.mostCurrent.activityBA,citizen.mostCurrent,164);
if (RapidSub.canDelegate("panpop")) { return b4a.example.citizen.remoteMe.runUserSub(false, "citizen","panpop", _mlayout, _hc, _wc, _nik);}
Debug.locals.put("mlayout", _mlayout);
Debug.locals.put("hc", _hc);
Debug.locals.put("wc", _wc);
Debug.locals.put("NIK", _nik);
 BA.debugLineNum = 164;BA.debugLine="Sub PanPop (mlayout As String, hc As Int, wc As In";
Debug.ShouldStop(8);
 BA.debugLineNum = 166;BA.debugLine="pnlSelect.Initialize ( \"Select\")";
Debug.ShouldStop(32);
citizen.mostCurrent._pnlselect.runVoidMethod ("Initialize",citizen.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("Select")));
 BA.debugLineNum = 167;BA.debugLine="pnlInput.Initialize (\"\")";
Debug.ShouldStop(64);
citizen.mostCurrent._pnlinput.runVoidMethod ("Initialize",citizen.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 168;BA.debugLine="pnlInput.LoadLayout ( mlayout )";
Debug.ShouldStop(128);
citizen.mostCurrent._pnlinput.runMethodAndSync(false,"LoadLayout",(Object)(_mlayout),citizen.mostCurrent.activityBA);
 BA.debugLineNum = 170;BA.debugLine="pnlSelect.BringToFront";
Debug.ShouldStop(512);
citizen.mostCurrent._pnlselect.runVoidMethod ("BringToFront");
 BA.debugLineNum = 171;BA.debugLine="pnlSelect.Color  = Colors.ARGB (150,0,0,0)";
Debug.ShouldStop(1024);
citizen.mostCurrent._pnlselect.runVoidMethod ("setColor",citizen.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 150)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0))));
 BA.debugLineNum = 172;BA.debugLine="Activity.AddView (pnlSelect, 0, 0,   100%x, 100%y";
Debug.ShouldStop(2048);
citizen.mostCurrent._activity.runVoidMethod ("AddView",(Object)((citizen.mostCurrent._pnlselect.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(citizen.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),citizen.mostCurrent.activityBA)),(Object)(citizen.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),citizen.mostCurrent.activityBA)));
 BA.debugLineNum = 173;BA.debugLine="mh1=(pnlSelect.Height/2) - (PanelMain.Height/2) +";
Debug.ShouldStop(4096);
citizen._mh1 = BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {citizen.mostCurrent._pnlselect.runMethod(true,"getHeight"),RemoteObject.createImmutable(2)}, "/",0, 0)),(RemoteObject.solve(new RemoteObject[] {citizen.mostCurrent._panelmain.runMethod(true,"getHeight"),RemoteObject.createImmutable(2)}, "/",0, 0)),_hc}, "-+",2, 0));
 BA.debugLineNum = 174;BA.debugLine="mw1=pnlSelect.Width/2 - (PanelMain.Width/2) + wc";
Debug.ShouldStop(8192);
citizen._mw1 = BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {citizen.mostCurrent._pnlselect.runMethod(true,"getWidth"),RemoteObject.createImmutable(2),(RemoteObject.solve(new RemoteObject[] {citizen.mostCurrent._panelmain.runMethod(true,"getWidth"),RemoteObject.createImmutable(2)}, "/",0, 0)),_wc}, "/-+",2, 0));
 BA.debugLineNum = 175;BA.debugLine="mh2=PanelMain.Height";
Debug.ShouldStop(16384);
citizen._mh2 = BA.numberCast(float.class, citizen.mostCurrent._panelmain.runMethod(true,"getHeight"));
 BA.debugLineNum = 176;BA.debugLine="mw2=PanelMain.Width";
Debug.ShouldStop(32768);
citizen._mw2 = BA.numberCast(float.class, citizen.mostCurrent._panelmain.runMethod(true,"getWidth"));
 BA.debugLineNum = 177;BA.debugLine="pnlSelect.AddView (pnlInput, mw1, mh1, mw2, mh2)";
Debug.ShouldStop(65536);
citizen.mostCurrent._pnlselect.runVoidMethod ("AddView",(Object)((citizen.mostCurrent._pnlinput.getObject())),(Object)(BA.numberCast(int.class, citizen._mw1)),(Object)(BA.numberCast(int.class, citizen._mh1)),(Object)(BA.numberCast(int.class, citizen._mw2)),(Object)(BA.numberCast(int.class, citizen._mh2)));
 BA.debugLineNum = 180;BA.debugLine="ProgressDialogShow(\"Loading...\")";
Debug.ShouldStop(524288);
citizen.mostCurrent.__c.runVoidMethod ("ProgressDialogShow",citizen.mostCurrent.activityBA,(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Loading..."))));
 BA.debugLineNum = 181;BA.debugLine="Label1.Text=\"Name:\"&citizen_name_g";
Debug.ShouldStop(1048576);
citizen.mostCurrent._label1.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Name:"),citizen.mostCurrent._citizen_name_g)));
 BA.debugLineNum = 182;BA.debugLine="Label2.Text=\"Phone:\"&phone_g";
Debug.ShouldStop(2097152);
citizen.mostCurrent._label2.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Phone:"),citizen.mostCurrent._phone_g)));
 BA.debugLineNum = 183;BA.debugLine="Label3.Text=\"Gender:\"&gender_g";
Debug.ShouldStop(4194304);
citizen.mostCurrent._label3.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Gender:"),citizen.mostCurrent._gender_g)));
 BA.debugLineNum = 184;BA.debugLine="Label4.Text=\"Status:\"&status_g";
Debug.ShouldStop(8388608);
citizen.mostCurrent._label4.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Status:"),citizen.mostCurrent._status_g)));
 BA.debugLineNum = 185;BA.debugLine="Label5.Text=\"Clan:\"&clan_g";
Debug.ShouldStop(16777216);
citizen.mostCurrent._label5.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Clan:"),citizen.mostCurrent._clan_g)));
 BA.debugLineNum = 192;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _panpopbuilding(RemoteObject _mlayout,RemoteObject _hc,RemoteObject _wc,RemoteObject _nik) throws Exception{
try {
		Debug.PushSubsStack("PanPopBuilding (citizen) ","citizen",10,citizen.mostCurrent.activityBA,citizen.mostCurrent,194);
if (RapidSub.canDelegate("panpopbuilding")) { return b4a.example.citizen.remoteMe.runUserSub(false, "citizen","panpopbuilding", _mlayout, _hc, _wc, _nik);}
RemoteObject _citizen_id = RemoteObject.createImmutable("");
Debug.locals.put("mlayout", _mlayout);
Debug.locals.put("hc", _hc);
Debug.locals.put("wc", _wc);
Debug.locals.put("NIK", _nik);
 BA.debugLineNum = 194;BA.debugLine="Sub PanPopBuilding (mlayout As String, hc As Int,";
Debug.ShouldStop(2);
 BA.debugLineNum = 195;BA.debugLine="Dim citizen_id As String";
Debug.ShouldStop(4);
_citizen_id = RemoteObject.createImmutable("");Debug.locals.put("citizen_id", _citizen_id);
 BA.debugLineNum = 196;BA.debugLine="citizen_id=EditText1.Text";
Debug.ShouldStop(8);
_citizen_id = citizen.mostCurrent._edittext1.runMethod(true,"getText");Debug.locals.put("citizen_id", _citizen_id);
 BA.debugLineNum = 197;BA.debugLine="pnlSelect.Initialize ( \"Select\")";
Debug.ShouldStop(16);
citizen.mostCurrent._pnlselect.runVoidMethod ("Initialize",citizen.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("Select")));
 BA.debugLineNum = 198;BA.debugLine="pnlInput.Initialize (\"\")";
Debug.ShouldStop(32);
citizen.mostCurrent._pnlinput.runVoidMethod ("Initialize",citizen.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 199;BA.debugLine="pnlInput.LoadLayout ( mlayout )";
Debug.ShouldStop(64);
citizen.mostCurrent._pnlinput.runMethodAndSync(false,"LoadLayout",(Object)(_mlayout),citizen.mostCurrent.activityBA);
 BA.debugLineNum = 201;BA.debugLine="pnlSelect.BringToFront";
Debug.ShouldStop(256);
citizen.mostCurrent._pnlselect.runVoidMethod ("BringToFront");
 BA.debugLineNum = 202;BA.debugLine="pnlSelect.Color  = Colors.ARGB (150,0,0,0)";
Debug.ShouldStop(512);
citizen.mostCurrent._pnlselect.runVoidMethod ("setColor",citizen.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 150)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0))));
 BA.debugLineNum = 203;BA.debugLine="Activity.AddView (pnlSelect, 0, 0,   100%x, 100%y";
Debug.ShouldStop(1024);
citizen.mostCurrent._activity.runVoidMethod ("AddView",(Object)((citizen.mostCurrent._pnlselect.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(citizen.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),citizen.mostCurrent.activityBA)),(Object)(citizen.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),citizen.mostCurrent.activityBA)));
 BA.debugLineNum = 204;BA.debugLine="mh1=(pnlSelect.Height/2) - (PanelMain1.Height/2)";
Debug.ShouldStop(2048);
citizen._mh1 = BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {citizen.mostCurrent._pnlselect.runMethod(true,"getHeight"),RemoteObject.createImmutable(2)}, "/",0, 0)),(RemoteObject.solve(new RemoteObject[] {citizen.mostCurrent._panelmain1.runMethod(true,"getHeight"),RemoteObject.createImmutable(2)}, "/",0, 0)),_hc}, "-+",2, 0));
 BA.debugLineNum = 205;BA.debugLine="mw1=pnlSelect.Width/2 - (PanelMain1.Width/2) + wc";
Debug.ShouldStop(4096);
citizen._mw1 = BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {citizen.mostCurrent._pnlselect.runMethod(true,"getWidth"),RemoteObject.createImmutable(2),(RemoteObject.solve(new RemoteObject[] {citizen.mostCurrent._panelmain1.runMethod(true,"getWidth"),RemoteObject.createImmutable(2)}, "/",0, 0)),_wc}, "/-+",2, 0));
 BA.debugLineNum = 206;BA.debugLine="mh2=pnlSelect.Height-50dip";
Debug.ShouldStop(8192);
citizen._mh2 = BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {citizen.mostCurrent._pnlselect.runMethod(true,"getHeight"),citizen.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)))}, "-",1, 1));
 BA.debugLineNum = 207;BA.debugLine="mw2=pnlSelect.Width-50dip";
Debug.ShouldStop(16384);
citizen._mw2 = BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {citizen.mostCurrent._pnlselect.runMethod(true,"getWidth"),citizen.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)))}, "-",1, 1));
 BA.debugLineNum = 209;BA.debugLine="wv1.LoadURL(domain&\"ta_v2/endpoint/view/land_owne";
Debug.ShouldStop(65536);
citizen.mostCurrent._wv1.runVoidMethod ("LoadUrl",(Object)(RemoteObject.concat(citizen.mostCurrent._domain,RemoteObject.createImmutable("ta_v2/endpoint/view/land_owner.php?owner_id="),_citizen_id)));
 BA.debugLineNum = 219;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
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
		Debug.PushSubsStack("Select_Click (citizen) ","citizen",10,citizen.mostCurrent.activityBA,citizen.mostCurrent,221);
if (RapidSub.canDelegate("select_click")) { return b4a.example.citizen.remoteMe.runUserSub(false, "citizen","select_click");}
 BA.debugLineNum = 221;BA.debugLine="Sub Select_Click ' Stop clicks on Select panel get";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 223;BA.debugLine="pnlSelect.RemoveView";
Debug.ShouldStop(1073741824);
citizen.mostCurrent._pnlselect.runVoidMethod ("RemoveView");
 BA.debugLineNum = 224;BA.debugLine="Button1.Visible=True";
Debug.ShouldStop(-2147483648);
citizen.mostCurrent._button1.runMethod(true,"setVisible",citizen.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 225;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}
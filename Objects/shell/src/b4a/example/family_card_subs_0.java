package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class family_card_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (family_card) ","family_card",9,family_card.mostCurrent.activityBA,family_card.mostCurrent,43);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.family_card.remoteMe.runUserSub(false, "family_card","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 43;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(1024);
 BA.debugLineNum = 45;BA.debugLine="Activity.LoadLayout(\"family_card\")";
Debug.ShouldStop(4096);
family_card.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("family_card")),family_card.mostCurrent.activityBA);
 BA.debugLineNum = 50;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
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
		Debug.PushSubsStack("Activity_Pause (family_card) ","family_card",9,family_card.mostCurrent.activityBA,family_card.mostCurrent,58);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.family_card.remoteMe.runUserSub(false, "family_card","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 58;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 60;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
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
		Debug.PushSubsStack("Activity_Resume (family_card) ","family_card",9,family_card.mostCurrent.activityBA,family_card.mostCurrent,52);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.family_card.remoteMe.runUserSub(false, "family_card","activity_resume");}
 BA.debugLineNum = 52;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(524288);
 BA.debugLineNum = 53;BA.debugLine="job2.Initialize(\"Job2\", Me)";
Debug.ShouldStop(1048576);
family_card.mostCurrent._job2.runVoidMethod ("_initialize",family_card.processBA,(Object)(BA.ObjectToString("Job2")),(Object)(family_card.getObject()));
 BA.debugLineNum = 54;BA.debugLine="job2.PostString(domain&\"ta_v2/endpoint/countFcn.p";
Debug.ShouldStop(2097152);
family_card.mostCurrent._job2.runVoidMethod ("_poststring",(Object)(RemoteObject.concat(family_card.mostCurrent._domain,RemoteObject.createImmutable("ta_v2/endpoint/countFcn.php"))),(Object)(RemoteObject.concat(RemoteObject.createImmutable("send=test"),RemoteObject.createImmutable("&data=test"))));
 BA.debugLineNum = 55;BA.debugLine="ProgressDialogShow(\"Loading...\")";
Debug.ShouldStop(4194304);
family_card.mostCurrent.__c.runVoidMethod ("ProgressDialogShow",family_card.mostCurrent.activityBA,(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Loading..."))));
 BA.debugLineNum = 56;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
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
		Debug.PushSubsStack("Button1_Click (family_card) ","family_card",9,family_card.mostCurrent.activityBA,family_card.mostCurrent,132);
if (RapidSub.canDelegate("button1_click")) { return b4a.example.family_card.remoteMe.runUserSub(false, "family_card","button1_click");}
RemoteObject _fc_number = RemoteObject.createImmutable("");
RemoteObject _size = RemoteObject.createImmutable(0);
int _x = 0;
 BA.debugLineNum = 132;BA.debugLine="Sub Button1_Click";
Debug.ShouldStop(8);
 BA.debugLineNum = 133;BA.debugLine="Dim fc_number As String";
Debug.ShouldStop(16);
_fc_number = RemoteObject.createImmutable("");Debug.locals.put("fc_number", _fc_number);
 BA.debugLineNum = 134;BA.debugLine="fc_number=EditText1.Text";
Debug.ShouldStop(32);
_fc_number = family_card.mostCurrent._edittext1.runMethod(true,"getText");Debug.locals.put("fc_number", _fc_number);
 BA.debugLineNum = 136;BA.debugLine="job2.Initialize(\"Job3\", Me)";
Debug.ShouldStop(128);
family_card.mostCurrent._job2.runVoidMethod ("_initialize",family_card.processBA,(Object)(BA.ObjectToString("Job3")),(Object)(family_card.getObject()));
 BA.debugLineNum = 137;BA.debugLine="job2.PostString(domain&\"ta_v2/endpoint/fcn_search";
Debug.ShouldStop(256);
family_card.mostCurrent._job2.runVoidMethod ("_poststring",(Object)(RemoteObject.concat(family_card.mostCurrent._domain,RemoteObject.createImmutable("ta_v2/endpoint/fcn_search.php"))),(Object)(RemoteObject.concat(RemoteObject.createImmutable("family_no="),_fc_number)));
 BA.debugLineNum = 138;BA.debugLine="ProgressDialogShow(\"Loading...\")";
Debug.ShouldStop(512);
family_card.mostCurrent.__c.runVoidMethod ("ProgressDialogShow",family_card.mostCurrent.activityBA,(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Loading..."))));
 BA.debugLineNum = 140;BA.debugLine="Dim Size As Int";
Debug.ShouldStop(2048);
_size = RemoteObject.createImmutable(0);Debug.locals.put("Size", _size);
 BA.debugLineNum = 141;BA.debugLine="Size=ListView1.Size";
Debug.ShouldStop(4096);
_size = family_card.mostCurrent._listview1.runMethod(true,"getSize");Debug.locals.put("Size", _size);
 BA.debugLineNum = 142;BA.debugLine="Log(\"Jumlah Data: \" & Size)";
Debug.ShouldStop(8192);
family_card.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("Jumlah Data: "),_size)));
 BA.debugLineNum = 144;BA.debugLine="For x= Size To 0 Step -1";
Debug.ShouldStop(32768);
{
final int step9 = -1;
final int limit9 = 0;
_x = _size.<Integer>get().intValue() ;
for (;(step9 > 0 && _x <= limit9) || (step9 < 0 && _x >= limit9) ;_x = ((int)(0 + _x + step9))  ) {
Debug.locals.put("x", _x);
 BA.debugLineNum = 145;BA.debugLine="If x==0 Then";
Debug.ShouldStop(65536);
if (RemoteObject.solveBoolean("=",RemoteObject.createImmutable(_x),BA.numberCast(double.class, 0))) { 
 }else {
 BA.debugLineNum = 148;BA.debugLine="ListView1.RemoveAt(x-1)";
Debug.ShouldStop(524288);
family_card.mostCurrent._listview1.runVoidMethod ("RemoveAt",(Object)(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_x),RemoteObject.createImmutable(1)}, "-",1, 1)));
 };
 }
}Debug.locals.put("x", _x);
;
 BA.debugLineNum = 151;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
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
family_card.mostCurrent._pnlinput = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
family_card.mostCurrent._pnlselect = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
family_card.mostCurrent._panelmain = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Dim domain As String";
family_card.mostCurrent._domain = RemoteObject.createImmutable("");
 //BA.debugLineNum = 18;BA.debugLine="Dim mh1,mh2,mw1,mw2 As Float";
family_card._mh1 = RemoteObject.createImmutable(0f);
family_card._mh2 = RemoteObject.createImmutable(0f);
family_card._mw1 = RemoteObject.createImmutable(0f);
family_card._mw2 = RemoteObject.createImmutable(0f);
 //BA.debugLineNum = 19;BA.debugLine="Dim job2 As HttpJob";
family_card.mostCurrent._job2 = RemoteObject.createNew ("anywheresoftware.b4a.samples.httputils2.httpjob");
 //BA.debugLineNum = 20;BA.debugLine="Dim citizen_name_g As String";
family_card.mostCurrent._citizen_name_g = RemoteObject.createImmutable("");
 //BA.debugLineNum = 21;BA.debugLine="Dim clan_g As String";
family_card.mostCurrent._clan_g = RemoteObject.createImmutable("");
 //BA.debugLineNum = 22;BA.debugLine="Dim gender_g As String";
family_card.mostCurrent._gender_g = RemoteObject.createImmutable("");
 //BA.debugLineNum = 23;BA.debugLine="Dim phone_g As String";
family_card.mostCurrent._phone_g = RemoteObject.createImmutable("");
 //BA.debugLineNum = 24;BA.debugLine="Dim status_g As String";
family_card.mostCurrent._status_g = RemoteObject.createImmutable("");
 //BA.debugLineNum = 27;BA.debugLine="domain=\"https://b9312448.ngrok.io/\"";
family_card.mostCurrent._domain = BA.ObjectToString("https://b9312448.ngrok.io/");
 //BA.debugLineNum = 29;BA.debugLine="Private Label10 As Label";
family_card.mostCurrent._label10 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 30;BA.debugLine="Private Label11 As Label";
family_card.mostCurrent._label11 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 31;BA.debugLine="Private EditText1 As EditText";
family_card.mostCurrent._edittext1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 32;BA.debugLine="Private ListView1 As ListView";
family_card.mostCurrent._listview1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ListViewWrapper");
 //BA.debugLineNum = 33;BA.debugLine="Private Label12 As Label";
family_card.mostCurrent._label12 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 35;BA.debugLine="Private Button1 As Button";
family_card.mostCurrent._button1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 36;BA.debugLine="Private Label1 As Label";
family_card.mostCurrent._label1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 37;BA.debugLine="Private Label2 As Label";
family_card.mostCurrent._label2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 38;BA.debugLine="Private Label3 As Label";
family_card.mostCurrent._label3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 39;BA.debugLine="Private Label4 As Label";
family_card.mostCurrent._label4 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 40;BA.debugLine="Private Label5 As Label";
family_card.mostCurrent._label5 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 41;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _jobdone(RemoteObject _job) throws Exception{
try {
		Debug.PushSubsStack("JobDone (family_card) ","family_card",9,family_card.mostCurrent.activityBA,family_card.mostCurrent,62);
if (RapidSub.canDelegate("jobdone")) { return b4a.example.family_card.remoteMe.runUserSub(false, "family_card","jobdone", _job);}
RemoteObject _parser = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser");
RemoteObject _root = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _features = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _colfeatures = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _properties = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _fcn = RemoteObject.createImmutable("");
RemoteObject _fcc = RemoteObject.createImmutable("");
RemoteObject _citizen_id = RemoteObject.createImmutable("");
RemoteObject _name = RemoteObject.createImmutable("");
RemoteObject _count = RemoteObject.createImmutable("");
RemoteObject _nik = RemoteObject.createImmutable("");
RemoteObject _clan_name = RemoteObject.createImmutable("");
RemoteObject _citizen_name = RemoteObject.createImmutable("");
RemoteObject _gender = RemoteObject.createImmutable("");
RemoteObject _phone = RemoteObject.createImmutable("");
RemoteObject _status_name = RemoteObject.createImmutable("");
RemoteObject _born_date = RemoteObject.createImmutable("");
Debug.locals.put("Job", _job);
 BA.debugLineNum = 62;BA.debugLine="Sub JobDone (Job As HttpJob)";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 64;BA.debugLine="Log(\"JobName = \" & Job.JobName & \", Success = \" &";
Debug.ShouldStop(-2147483648);
family_card.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("JobName = "),_job.getField(true,"_jobname"),RemoteObject.createImmutable(", Success = "),_job.getField(true,"_success"))));
 BA.debugLineNum = 65;BA.debugLine="If Job.Success = True Then";
Debug.ShouldStop(1);
if (RemoteObject.solveBoolean("=",_job.getField(true,"_success"),family_card.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 66;BA.debugLine="ProgressDialogHide";
Debug.ShouldStop(2);
family_card.mostCurrent.__c.runVoidMethod ("ProgressDialogHide");
 BA.debugLineNum = 67;BA.debugLine="Select Job.JobName";
Debug.ShouldStop(4);
switch (BA.switchObjectToInt(_job.getField(true,"_jobname"),BA.ObjectToString("Job2"),BA.ObjectToString("Job3"),BA.ObjectToString("Job4"))) {
case 0: {
 BA.debugLineNum = 69;BA.debugLine="Dim parser As JSONParser";
Debug.ShouldStop(16);
_parser = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("parser", _parser);
 BA.debugLineNum = 70;BA.debugLine="parser.Initialize(Job.GetString)";
Debug.ShouldStop(32);
_parser.runVoidMethod ("Initialize",(Object)(_job.runMethod(true,"_getstring")));
 BA.debugLineNum = 71;BA.debugLine="Dim root As Map = parser.NextObject";
Debug.ShouldStop(64);
_root = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_root = _parser.runMethod(false,"NextObject");Debug.locals.put("root", _root);Debug.locals.put("root", _root);
 BA.debugLineNum = 72;BA.debugLine="Dim features As List = root.Get(\"features\")";
Debug.ShouldStop(128);
_features = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_features.setObject(_root.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("features")))));Debug.locals.put("features", _features);
 BA.debugLineNum = 73;BA.debugLine="For Each colfeatures As Map In features";
Debug.ShouldStop(256);
_colfeatures = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
{
final RemoteObject group10 = _features;
final int groupLen10 = group10.runMethod(true,"getSize").<Integer>get()
;int index10 = 0;
;
for (; index10 < groupLen10;index10++){
_colfeatures.setObject(group10.runMethod(false,"Get",index10));
Debug.locals.put("colfeatures", _colfeatures);
 BA.debugLineNum = 74;BA.debugLine="Dim properties As Map = colfeatures.Get(\"prop";
Debug.ShouldStop(512);
_properties = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_properties.setObject(_colfeatures.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("properties")))));Debug.locals.put("properties", _properties);
 BA.debugLineNum = 75;BA.debugLine="Dim fcn As String = properties.Get(\"fcn\")";
Debug.ShouldStop(1024);
_fcn = BA.ObjectToString(_properties.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("fcn")))));Debug.locals.put("fcn", _fcn);Debug.locals.put("fcn", _fcn);
 BA.debugLineNum = 76;BA.debugLine="Dim fcc As String = properties.Get(\"fcc\")";
Debug.ShouldStop(2048);
_fcc = BA.ObjectToString(_properties.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("fcc")))));Debug.locals.put("fcc", _fcc);Debug.locals.put("fcc", _fcc);
 BA.debugLineNum = 78;BA.debugLine="Label10.Text=fcn";
Debug.ShouldStop(8192);
family_card.mostCurrent._label10.runMethod(true,"setText",BA.ObjectToCharSequence(_fcn));
 BA.debugLineNum = 79;BA.debugLine="Label11.Text=fcc";
Debug.ShouldStop(16384);
family_card.mostCurrent._label11.runMethod(true,"setText",BA.ObjectToCharSequence(_fcc));
 }
}Debug.locals.put("colfeatures", _colfeatures);
;
 break; }
case 1: {
 BA.debugLineNum = 82;BA.debugLine="Dim parser As JSONParser";
Debug.ShouldStop(131072);
_parser = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("parser", _parser);
 BA.debugLineNum = 83;BA.debugLine="parser.Initialize(Job.GetString)";
Debug.ShouldStop(262144);
_parser.runVoidMethod ("Initialize",(Object)(_job.runMethod(true,"_getstring")));
 BA.debugLineNum = 84;BA.debugLine="Dim root As Map = parser.NextObject";
Debug.ShouldStop(524288);
_root = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_root = _parser.runMethod(false,"NextObject");Debug.locals.put("root", _root);Debug.locals.put("root", _root);
 BA.debugLineNum = 85;BA.debugLine="Dim features As List = root.Get(\"features\")";
Debug.ShouldStop(1048576);
_features = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_features.setObject(_root.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("features")))));Debug.locals.put("features", _features);
 BA.debugLineNum = 86;BA.debugLine="For Each colfeatures As Map In features";
Debug.ShouldStop(2097152);
_colfeatures = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
{
final RemoteObject group22 = _features;
final int groupLen22 = group22.runMethod(true,"getSize").<Integer>get()
;int index22 = 0;
;
for (; index22 < groupLen22;index22++){
_colfeatures.setObject(group22.runMethod(false,"Get",index22));
Debug.locals.put("colfeatures", _colfeatures);
 BA.debugLineNum = 87;BA.debugLine="Dim properties As Map = colfeatures.Get(\"prop";
Debug.ShouldStop(4194304);
_properties = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_properties.setObject(_colfeatures.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("properties")))));Debug.locals.put("properties", _properties);
 BA.debugLineNum = 88;BA.debugLine="Dim citizen_id As String = properties.Get(\"ci";
Debug.ShouldStop(8388608);
_citizen_id = BA.ObjectToString(_properties.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("citizen_id")))));Debug.locals.put("citizen_id", _citizen_id);Debug.locals.put("citizen_id", _citizen_id);
 BA.debugLineNum = 89;BA.debugLine="Dim name As String = properties.Get(\"name\")";
Debug.ShouldStop(16777216);
_name = BA.ObjectToString(_properties.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("name")))));Debug.locals.put("name", _name);Debug.locals.put("name", _name);
 BA.debugLineNum = 90;BA.debugLine="Dim count As String = properties.Get(\"count\")";
Debug.ShouldStop(33554432);
_count = BA.ObjectToString(_properties.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("count")))));Debug.locals.put("count", _count);Debug.locals.put("count", _count);
 BA.debugLineNum = 91;BA.debugLine="ListView1.AddSingleLine(citizen_id)";
Debug.ShouldStop(67108864);
family_card.mostCurrent._listview1.runVoidMethod ("AddSingleLine",(Object)(BA.ObjectToCharSequence(_citizen_id)));
 BA.debugLineNum = 92;BA.debugLine="ListView1.SingleLineLayout.Label.TextSize=20";
Debug.ShouldStop(134217728);
family_card.mostCurrent._listview1.runMethod(false,"getSingleLineLayout").getField(false,"Label").runMethod(true,"setTextSize",BA.numberCast(float.class, 20));
 BA.debugLineNum = 93;BA.debugLine="ListView1.SingleLineLayout.ItemHeight = 24dip";
Debug.ShouldStop(268435456);
family_card.mostCurrent._listview1.runMethod(false,"getSingleLineLayout").runMethod(true,"setItemHeight",family_card.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 24))));
 BA.debugLineNum = 94;BA.debugLine="ListView1.SingleLineLayout.Label.TextColor =";
Debug.ShouldStop(536870912);
family_card.mostCurrent._listview1.runMethod(false,"getSingleLineLayout").getField(false,"Label").runMethod(true,"setTextColor",family_card.mostCurrent.__c.getField(false,"Colors").getField(true,"Red"));
 BA.debugLineNum = 95;BA.debugLine="ListView1.SingleLineLayout.Label.Gravity=Grav";
Debug.ShouldStop(1073741824);
family_card.mostCurrent._listview1.runMethod(false,"getSingleLineLayout").getField(false,"Label").runMethod(true,"setGravity",family_card.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER_HORIZONTAL"));
 }
}Debug.locals.put("colfeatures", _colfeatures);
;
 break; }
case 2: {
 BA.debugLineNum = 100;BA.debugLine="Dim parser As JSONParser";
Debug.ShouldStop(8);
_parser = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("parser", _parser);
 BA.debugLineNum = 101;BA.debugLine="Log(Job.GetString)";
Debug.ShouldStop(16);
family_card.mostCurrent.__c.runVoidMethod ("Log",(Object)(_job.runMethod(true,"_getstring")));
 BA.debugLineNum = 102;BA.debugLine="parser.Initialize(Job.GetString)";
Debug.ShouldStop(32);
_parser.runVoidMethod ("Initialize",(Object)(_job.runMethod(true,"_getstring")));
 BA.debugLineNum = 103;BA.debugLine="Dim root As Map = parser.NextObject";
Debug.ShouldStop(64);
_root = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_root = _parser.runMethod(false,"NextObject");Debug.locals.put("root", _root);Debug.locals.put("root", _root);
 BA.debugLineNum = 104;BA.debugLine="Dim nik As String = root.Get(\"nik\")";
Debug.ShouldStop(128);
_nik = BA.ObjectToString(_root.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("nik")))));Debug.locals.put("nik", _nik);Debug.locals.put("nik", _nik);
 BA.debugLineNum = 105;BA.debugLine="Dim clan_name As String = root.Get(\"clan_name\"";
Debug.ShouldStop(256);
_clan_name = BA.ObjectToString(_root.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("clan_name")))));Debug.locals.put("clan_name", _clan_name);Debug.locals.put("clan_name", _clan_name);
 BA.debugLineNum = 106;BA.debugLine="Dim citizen_name As String = root.Get(\"citizen";
Debug.ShouldStop(512);
_citizen_name = BA.ObjectToString(_root.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("citizen_name")))));Debug.locals.put("citizen_name", _citizen_name);Debug.locals.put("citizen_name", _citizen_name);
 BA.debugLineNum = 107;BA.debugLine="Dim gender As String = root.Get(\"gender\")";
Debug.ShouldStop(1024);
_gender = BA.ObjectToString(_root.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("gender")))));Debug.locals.put("gender", _gender);Debug.locals.put("gender", _gender);
 BA.debugLineNum = 108;BA.debugLine="Dim phone As String = root.Get(\"phone\")";
Debug.ShouldStop(2048);
_phone = BA.ObjectToString(_root.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("phone")))));Debug.locals.put("phone", _phone);Debug.locals.put("phone", _phone);
 BA.debugLineNum = 109;BA.debugLine="Dim status_name As String = root.Get(\"status_n";
Debug.ShouldStop(4096);
_status_name = BA.ObjectToString(_root.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("status_name")))));Debug.locals.put("status_name", _status_name);Debug.locals.put("status_name", _status_name);
 BA.debugLineNum = 110;BA.debugLine="Dim born_date As String = root.Get(\"born_date\"";
Debug.ShouldStop(8192);
_born_date = BA.ObjectToString(_root.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("born_date")))));Debug.locals.put("born_date", _born_date);Debug.locals.put("born_date", _born_date);
 BA.debugLineNum = 112;BA.debugLine="citizen_name_g=citizen_name";
Debug.ShouldStop(32768);
family_card.mostCurrent._citizen_name_g = _citizen_name;
 BA.debugLineNum = 113;BA.debugLine="gender_g=gender";
Debug.ShouldStop(65536);
family_card.mostCurrent._gender_g = _gender;
 BA.debugLineNum = 114;BA.debugLine="phone_g=phone";
Debug.ShouldStop(131072);
family_card.mostCurrent._phone_g = _phone;
 BA.debugLineNum = 115;BA.debugLine="status_g=status_name";
Debug.ShouldStop(262144);
family_card.mostCurrent._status_g = _status_name;
 BA.debugLineNum = 116;BA.debugLine="Label12.Text=count";
Debug.ShouldStop(524288);
family_card.mostCurrent._label12.runMethod(true,"setText",BA.ObjectToCharSequence(_count));
 break; }
}
;
 }else {
 BA.debugLineNum = 123;BA.debugLine="Log(\"Error: \" & Job.ErrorMessage)";
Debug.ShouldStop(67108864);
family_card.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("Error: "),_job.getField(true,"_errormessage"))));
 BA.debugLineNum = 124;BA.debugLine="ToastMessageShow(\"Error: \" & Job.ErrorMessage, T";
Debug.ShouldStop(134217728);
family_card.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Error: "),_job.getField(true,"_errormessage")))),(Object)(family_card.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 126;BA.debugLine="Job.Release";
Debug.ShouldStop(536870912);
_job.runVoidMethod ("_release");
 BA.debugLineNum = 127;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
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
		Debug.PushSubsStack("ListView1_ItemClick (family_card) ","family_card",9,family_card.mostCurrent.activityBA,family_card.mostCurrent,154);
if (RapidSub.canDelegate("listview1_itemclick")) { return b4a.example.family_card.remoteMe.runUserSub(false, "family_card","listview1_itemclick", _position, _value);}
Debug.locals.put("Position", _position);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 154;BA.debugLine="Sub ListView1_ItemClick (Position As Int, Value As";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 155;BA.debugLine="Button1.Visible=False";
Debug.ShouldStop(67108864);
family_card.mostCurrent._button1.runMethod(true,"setVisible",family_card.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 156;BA.debugLine="job2.Initialize(\"Job4\", Me)";
Debug.ShouldStop(134217728);
family_card.mostCurrent._job2.runVoidMethod ("_initialize",family_card.processBA,(Object)(BA.ObjectToString("Job4")),(Object)(family_card.getObject()));
 BA.debugLineNum = 157;BA.debugLine="job2.PostString(domain&\"ta_v2/endpoint/citizen_by";
Debug.ShouldStop(268435456);
family_card.mostCurrent._job2.runVoidMethod ("_poststring",(Object)(RemoteObject.concat(family_card.mostCurrent._domain,RemoteObject.createImmutable("ta_v2/endpoint/citizen_by_nik.php"))),(Object)(RemoteObject.concat(RemoteObject.createImmutable("citizen_id="),_value)));
 BA.debugLineNum = 158;BA.debugLine="ProgressDialogShow(\"Loading...\")";
Debug.ShouldStop(536870912);
family_card.mostCurrent.__c.runVoidMethod ("ProgressDialogShow",family_card.mostCurrent.activityBA,(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Loading..."))));
 BA.debugLineNum = 159;BA.debugLine="PanPop(\"fcpanel.bal\", 20, 10,Value)";
Debug.ShouldStop(1073741824);
_panpop(BA.ObjectToString("fcpanel.bal"),BA.numberCast(int.class, 20),BA.numberCast(int.class, 10),BA.ObjectToString(_value));
 BA.debugLineNum = 161;BA.debugLine="Log(\"Data yang diklik: \" & Value)";
Debug.ShouldStop(1);
family_card.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("Data yang diklik: "),_value)));
 BA.debugLineNum = 162;BA.debugLine="Label1.Text=\"Name:\"&citizen_name_g";
Debug.ShouldStop(2);
family_card.mostCurrent._label1.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Name:"),family_card.mostCurrent._citizen_name_g)));
 BA.debugLineNum = 163;BA.debugLine="Label2.Text=\"Phone:\"&phone_g";
Debug.ShouldStop(4);
family_card.mostCurrent._label2.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Phone:"),family_card.mostCurrent._phone_g)));
 BA.debugLineNum = 164;BA.debugLine="Label3.Text=\"Gender:\"&gender_g";
Debug.ShouldStop(8);
family_card.mostCurrent._label3.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Gender:"),family_card.mostCurrent._gender_g)));
 BA.debugLineNum = 165;BA.debugLine="Label4.Text=\"Status:\"&status_g";
Debug.ShouldStop(16);
family_card.mostCurrent._label4.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Status:"),family_card.mostCurrent._status_g)));
 BA.debugLineNum = 166;BA.debugLine="Label5.Text=\"Clan:\"&clan_g";
Debug.ShouldStop(32);
family_card.mostCurrent._label5.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Clan:"),family_card.mostCurrent._clan_g)));
 BA.debugLineNum = 167;BA.debugLine="End Sub";
Debug.ShouldStop(64);
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
		Debug.PushSubsStack("PanPop (family_card) ","family_card",9,family_card.mostCurrent.activityBA,family_card.mostCurrent,169);
if (RapidSub.canDelegate("panpop")) { return b4a.example.family_card.remoteMe.runUserSub(false, "family_card","panpop", _mlayout, _hc, _wc, _nik);}
Debug.locals.put("mlayout", _mlayout);
Debug.locals.put("hc", _hc);
Debug.locals.put("wc", _wc);
Debug.locals.put("NIK", _nik);
 BA.debugLineNum = 169;BA.debugLine="Sub PanPop (mlayout As String, hc As Int, wc As In";
Debug.ShouldStop(256);
 BA.debugLineNum = 171;BA.debugLine="pnlSelect.Initialize ( \"Select\")";
Debug.ShouldStop(1024);
family_card.mostCurrent._pnlselect.runVoidMethod ("Initialize",family_card.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("Select")));
 BA.debugLineNum = 172;BA.debugLine="pnlInput.Initialize (\"\")";
Debug.ShouldStop(2048);
family_card.mostCurrent._pnlinput.runVoidMethod ("Initialize",family_card.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 173;BA.debugLine="pnlInput.LoadLayout ( mlayout )";
Debug.ShouldStop(4096);
family_card.mostCurrent._pnlinput.runMethodAndSync(false,"LoadLayout",(Object)(_mlayout),family_card.mostCurrent.activityBA);
 BA.debugLineNum = 175;BA.debugLine="pnlSelect.BringToFront";
Debug.ShouldStop(16384);
family_card.mostCurrent._pnlselect.runVoidMethod ("BringToFront");
 BA.debugLineNum = 176;BA.debugLine="pnlSelect.Color  = Colors.ARGB (150,0,0,0)";
Debug.ShouldStop(32768);
family_card.mostCurrent._pnlselect.runVoidMethod ("setColor",family_card.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 150)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0))));
 BA.debugLineNum = 177;BA.debugLine="Activity.AddView (pnlSelect, 0, 0,   100%x, 100%y";
Debug.ShouldStop(65536);
family_card.mostCurrent._activity.runVoidMethod ("AddView",(Object)((family_card.mostCurrent._pnlselect.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(family_card.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),family_card.mostCurrent.activityBA)),(Object)(family_card.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),family_card.mostCurrent.activityBA)));
 BA.debugLineNum = 178;BA.debugLine="mh1=(pnlSelect.Height/2) - (PanelMain.Height/2) +";
Debug.ShouldStop(131072);
family_card._mh1 = BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {family_card.mostCurrent._pnlselect.runMethod(true,"getHeight"),RemoteObject.createImmutable(2)}, "/",0, 0)),(RemoteObject.solve(new RemoteObject[] {family_card.mostCurrent._panelmain.runMethod(true,"getHeight"),RemoteObject.createImmutable(2)}, "/",0, 0)),_hc}, "-+",2, 0));
 BA.debugLineNum = 179;BA.debugLine="mw1=pnlSelect.Width/2 - (PanelMain.Width/2) + wc";
Debug.ShouldStop(262144);
family_card._mw1 = BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {family_card.mostCurrent._pnlselect.runMethod(true,"getWidth"),RemoteObject.createImmutable(2),(RemoteObject.solve(new RemoteObject[] {family_card.mostCurrent._panelmain.runMethod(true,"getWidth"),RemoteObject.createImmutable(2)}, "/",0, 0)),_wc}, "/-+",2, 0));
 BA.debugLineNum = 180;BA.debugLine="mh2=PanelMain.Height";
Debug.ShouldStop(524288);
family_card._mh2 = BA.numberCast(float.class, family_card.mostCurrent._panelmain.runMethod(true,"getHeight"));
 BA.debugLineNum = 181;BA.debugLine="mw2=PanelMain.Width";
Debug.ShouldStop(1048576);
family_card._mw2 = BA.numberCast(float.class, family_card.mostCurrent._panelmain.runMethod(true,"getWidth"));
 BA.debugLineNum = 182;BA.debugLine="pnlSelect.AddView (pnlInput, mw1, mh1, mw2, mh2)";
Debug.ShouldStop(2097152);
family_card.mostCurrent._pnlselect.runVoidMethod ("AddView",(Object)((family_card.mostCurrent._pnlinput.getObject())),(Object)(BA.numberCast(int.class, family_card._mw1)),(Object)(BA.numberCast(int.class, family_card._mh1)),(Object)(BA.numberCast(int.class, family_card._mw2)),(Object)(BA.numberCast(int.class, family_card._mh2)));
 BA.debugLineNum = 190;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
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
		Debug.PushSubsStack("Select_Click (family_card) ","family_card",9,family_card.mostCurrent.activityBA,family_card.mostCurrent,192);
if (RapidSub.canDelegate("select_click")) { return b4a.example.family_card.remoteMe.runUserSub(false, "family_card","select_click");}
 BA.debugLineNum = 192;BA.debugLine="Sub Select_Click ' Stop clicks on Select panel get";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 194;BA.debugLine="pnlSelect.RemoveView";
Debug.ShouldStop(2);
family_card.mostCurrent._pnlselect.runVoidMethod ("RemoveView");
 BA.debugLineNum = 195;BA.debugLine="Button1.Visible=True";
Debug.ShouldStop(4);
family_card.mostCurrent._button1.runMethod(true,"setVisible",family_card.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 196;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}
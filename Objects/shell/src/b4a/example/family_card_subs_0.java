package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class family_card_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (family_card) ","family_card",9,family_card.mostCurrent.activityBA,family_card.mostCurrent,37);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.family_card.remoteMe.runUserSub(false, "family_card","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 37;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(16);
 BA.debugLineNum = 39;BA.debugLine="Activity.LoadLayout(\"family_card\")";
Debug.ShouldStop(64);
family_card.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("family_card")),family_card.mostCurrent.activityBA);
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
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (family_card) ","family_card",9,family_card.mostCurrent.activityBA,family_card.mostCurrent,52);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.family_card.remoteMe.runUserSub(false, "family_card","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 52;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(524288);
 BA.debugLineNum = 54;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
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
		Debug.PushSubsStack("Activity_Resume (family_card) ","family_card",9,family_card.mostCurrent.activityBA,family_card.mostCurrent,46);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.family_card.remoteMe.runUserSub(false, "family_card","activity_resume");}
 BA.debugLineNum = 46;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(8192);
 BA.debugLineNum = 47;BA.debugLine="job2.Initialize(\"Job2\", Me)";
Debug.ShouldStop(16384);
family_card.mostCurrent._job2.runVoidMethod ("_initialize",family_card.processBA,(Object)(BA.ObjectToString("Job2")),(Object)(family_card.getObject()));
 BA.debugLineNum = 48;BA.debugLine="job2.PostString(domain&\"ta_v2/endpoint/countFcn.p";
Debug.ShouldStop(32768);
family_card.mostCurrent._job2.runVoidMethod ("_poststring",(Object)(RemoteObject.concat(family_card.mostCurrent._domain,RemoteObject.createImmutable("ta_v2/endpoint/countFcn.php"))),(Object)(RemoteObject.concat(RemoteObject.createImmutable("send=test"),RemoteObject.createImmutable("&data=test"))));
 BA.debugLineNum = 49;BA.debugLine="ProgressDialogShow(\"Loading...\")";
Debug.ShouldStop(65536);
family_card.mostCurrent.__c.runVoidMethod ("ProgressDialogShow",family_card.mostCurrent.activityBA,(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Loading..."))));
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
public static RemoteObject  _button1_click() throws Exception{
try {
		Debug.PushSubsStack("Button1_Click (family_card) ","family_card",9,family_card.mostCurrent.activityBA,family_card.mostCurrent,109);
if (RapidSub.canDelegate("button1_click")) { return b4a.example.family_card.remoteMe.runUserSub(false, "family_card","button1_click");}
RemoteObject _fc_number = RemoteObject.createImmutable("");
RemoteObject _size = RemoteObject.createImmutable(0);
int _x = 0;
 BA.debugLineNum = 109;BA.debugLine="Sub Button1_Click";
Debug.ShouldStop(4096);
 BA.debugLineNum = 110;BA.debugLine="Dim fc_number As String";
Debug.ShouldStop(8192);
_fc_number = RemoteObject.createImmutable("");Debug.locals.put("fc_number", _fc_number);
 BA.debugLineNum = 111;BA.debugLine="fc_number=EditText1.Text";
Debug.ShouldStop(16384);
_fc_number = family_card.mostCurrent._edittext1.runMethod(true,"getText");Debug.locals.put("fc_number", _fc_number);
 BA.debugLineNum = 113;BA.debugLine="job2.Initialize(\"Job3\", Me)";
Debug.ShouldStop(65536);
family_card.mostCurrent._job2.runVoidMethod ("_initialize",family_card.processBA,(Object)(BA.ObjectToString("Job3")),(Object)(family_card.getObject()));
 BA.debugLineNum = 114;BA.debugLine="job2.PostString(domain&\"ta_v2/endpoint/fcn_search";
Debug.ShouldStop(131072);
family_card.mostCurrent._job2.runVoidMethod ("_poststring",(Object)(RemoteObject.concat(family_card.mostCurrent._domain,RemoteObject.createImmutable("ta_v2/endpoint/fcn_search.php"))),(Object)(RemoteObject.concat(RemoteObject.createImmutable("family_no="),_fc_number)));
 BA.debugLineNum = 115;BA.debugLine="ProgressDialogShow(\"Loading...\")";
Debug.ShouldStop(262144);
family_card.mostCurrent.__c.runVoidMethod ("ProgressDialogShow",family_card.mostCurrent.activityBA,(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Loading..."))));
 BA.debugLineNum = 117;BA.debugLine="Dim Size As Int";
Debug.ShouldStop(1048576);
_size = RemoteObject.createImmutable(0);Debug.locals.put("Size", _size);
 BA.debugLineNum = 118;BA.debugLine="Size=ListView1.Size";
Debug.ShouldStop(2097152);
_size = family_card.mostCurrent._listview1.runMethod(true,"getSize");Debug.locals.put("Size", _size);
 BA.debugLineNum = 119;BA.debugLine="Log(\"Jumlah Data: \" & Size)";
Debug.ShouldStop(4194304);
family_card.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("Jumlah Data: "),_size)));
 BA.debugLineNum = 121;BA.debugLine="For x= Size To 0 Step -1";
Debug.ShouldStop(16777216);
{
final int step9 = -1;
final int limit9 = 0;
_x = _size.<Integer>get().intValue() ;
for (;(step9 > 0 && _x <= limit9) || (step9 < 0 && _x >= limit9) ;_x = ((int)(0 + _x + step9))  ) {
Debug.locals.put("x", _x);
 BA.debugLineNum = 122;BA.debugLine="If x==0 Then";
Debug.ShouldStop(33554432);
if (RemoteObject.solveBoolean("=",RemoteObject.createImmutable(_x),BA.numberCast(double.class, 0))) { 
 }else {
 BA.debugLineNum = 125;BA.debugLine="ListView1.RemoveAt(x-1)";
Debug.ShouldStop(268435456);
family_card.mostCurrent._listview1.runVoidMethod ("RemoveAt",(Object)(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_x),RemoteObject.createImmutable(1)}, "-",1, 1)));
 };
 }
}Debug.locals.put("x", _x);
;
 BA.debugLineNum = 128;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
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
 //BA.debugLineNum = 21;BA.debugLine="domain=\"http://a56cb1fd.ngrok.io/\"";
family_card.mostCurrent._domain = BA.ObjectToString("http://a56cb1fd.ngrok.io/");
 //BA.debugLineNum = 23;BA.debugLine="Private Label10 As Label";
family_card.mostCurrent._label10 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Private Label11 As Label";
family_card.mostCurrent._label11 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 25;BA.debugLine="Private EditText1 As EditText";
family_card.mostCurrent._edittext1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 26;BA.debugLine="Private ListView1 As ListView";
family_card.mostCurrent._listview1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ListViewWrapper");
 //BA.debugLineNum = 27;BA.debugLine="Private Label12 As Label";
family_card.mostCurrent._label12 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 29;BA.debugLine="Private Button1 As Button";
family_card.mostCurrent._button1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 30;BA.debugLine="Private Label1 As Label";
family_card.mostCurrent._label1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 31;BA.debugLine="Private Label2 As Label";
family_card.mostCurrent._label2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 32;BA.debugLine="Private Label3 As Label";
family_card.mostCurrent._label3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 33;BA.debugLine="Private Label4 As Label";
family_card.mostCurrent._label4 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 34;BA.debugLine="Private Label5 As Label";
family_card.mostCurrent._label5 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 35;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _jobdone(RemoteObject _job) throws Exception{
try {
		Debug.PushSubsStack("JobDone (family_card) ","family_card",9,family_card.mostCurrent.activityBA,family_card.mostCurrent,56);
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
Debug.locals.put("Job", _job);
 BA.debugLineNum = 56;BA.debugLine="Sub JobDone (Job As HttpJob)";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 58;BA.debugLine="Log(\"JobName = \" & Job.JobName & \", Success = \" &";
Debug.ShouldStop(33554432);
family_card.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("JobName = "),_job.getField(true,"_jobname"),RemoteObject.createImmutable(", Success = "),_job.getField(true,"_success"))));
 BA.debugLineNum = 59;BA.debugLine="If Job.Success = True Then";
Debug.ShouldStop(67108864);
if (RemoteObject.solveBoolean("=",_job.getField(true,"_success"),family_card.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 60;BA.debugLine="ProgressDialogHide";
Debug.ShouldStop(134217728);
family_card.mostCurrent.__c.runVoidMethod ("ProgressDialogHide");
 BA.debugLineNum = 61;BA.debugLine="Select Job.JobName";
Debug.ShouldStop(268435456);
switch (BA.switchObjectToInt(_job.getField(true,"_jobname"),BA.ObjectToString("Job2"),BA.ObjectToString("Job3"))) {
case 0: {
 BA.debugLineNum = 63;BA.debugLine="Dim parser As JSONParser";
Debug.ShouldStop(1073741824);
_parser = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("parser", _parser);
 BA.debugLineNum = 64;BA.debugLine="parser.Initialize(Job.GetString)";
Debug.ShouldStop(-2147483648);
_parser.runVoidMethod ("Initialize",(Object)(_job.runMethod(true,"_getstring")));
 BA.debugLineNum = 65;BA.debugLine="Dim root As Map = parser.NextObject";
Debug.ShouldStop(1);
_root = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_root = _parser.runMethod(false,"NextObject");Debug.locals.put("root", _root);Debug.locals.put("root", _root);
 BA.debugLineNum = 66;BA.debugLine="Dim features As List = root.Get(\"features\")";
Debug.ShouldStop(2);
_features = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_features.setObject(_root.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("features")))));Debug.locals.put("features", _features);
 BA.debugLineNum = 67;BA.debugLine="For Each colfeatures As Map In features";
Debug.ShouldStop(4);
_colfeatures = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
{
final RemoteObject group10 = _features;
final int groupLen10 = group10.runMethod(true,"getSize").<Integer>get()
;int index10 = 0;
;
for (; index10 < groupLen10;index10++){
_colfeatures.setObject(group10.runMethod(false,"Get",index10));
Debug.locals.put("colfeatures", _colfeatures);
 BA.debugLineNum = 68;BA.debugLine="Dim properties As Map = colfeatures.Get(\"prop";
Debug.ShouldStop(8);
_properties = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_properties.setObject(_colfeatures.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("properties")))));Debug.locals.put("properties", _properties);
 BA.debugLineNum = 69;BA.debugLine="Dim fcn As String = properties.Get(\"fcn\")";
Debug.ShouldStop(16);
_fcn = BA.ObjectToString(_properties.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("fcn")))));Debug.locals.put("fcn", _fcn);Debug.locals.put("fcn", _fcn);
 BA.debugLineNum = 70;BA.debugLine="Dim fcc As String = properties.Get(\"fcc\")";
Debug.ShouldStop(32);
_fcc = BA.ObjectToString(_properties.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("fcc")))));Debug.locals.put("fcc", _fcc);Debug.locals.put("fcc", _fcc);
 BA.debugLineNum = 72;BA.debugLine="Label10.Text=fcn";
Debug.ShouldStop(128);
family_card.mostCurrent._label10.runMethod(true,"setText",BA.ObjectToCharSequence(_fcn));
 BA.debugLineNum = 73;BA.debugLine="Label11.Text=fcc";
Debug.ShouldStop(256);
family_card.mostCurrent._label11.runMethod(true,"setText",BA.ObjectToCharSequence(_fcc));
 }
}Debug.locals.put("colfeatures", _colfeatures);
;
 break; }
case 1: {
 BA.debugLineNum = 76;BA.debugLine="Dim parser As JSONParser";
Debug.ShouldStop(2048);
_parser = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("parser", _parser);
 BA.debugLineNum = 77;BA.debugLine="parser.Initialize(Job.GetString)";
Debug.ShouldStop(4096);
_parser.runVoidMethod ("Initialize",(Object)(_job.runMethod(true,"_getstring")));
 BA.debugLineNum = 78;BA.debugLine="Dim root As Map = parser.NextObject";
Debug.ShouldStop(8192);
_root = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_root = _parser.runMethod(false,"NextObject");Debug.locals.put("root", _root);Debug.locals.put("root", _root);
 BA.debugLineNum = 79;BA.debugLine="Dim features As List = root.Get(\"features\")";
Debug.ShouldStop(16384);
_features = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_features.setObject(_root.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("features")))));Debug.locals.put("features", _features);
 BA.debugLineNum = 80;BA.debugLine="For Each colfeatures As Map In features";
Debug.ShouldStop(32768);
_colfeatures = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
{
final RemoteObject group22 = _features;
final int groupLen22 = group22.runMethod(true,"getSize").<Integer>get()
;int index22 = 0;
;
for (; index22 < groupLen22;index22++){
_colfeatures.setObject(group22.runMethod(false,"Get",index22));
Debug.locals.put("colfeatures", _colfeatures);
 BA.debugLineNum = 81;BA.debugLine="Dim properties As Map = colfeatures.Get(\"prop";
Debug.ShouldStop(65536);
_properties = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_properties.setObject(_colfeatures.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("properties")))));Debug.locals.put("properties", _properties);
 BA.debugLineNum = 82;BA.debugLine="Dim citizen_id As String = properties.Get(\"ci";
Debug.ShouldStop(131072);
_citizen_id = BA.ObjectToString(_properties.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("citizen_id")))));Debug.locals.put("citizen_id", _citizen_id);Debug.locals.put("citizen_id", _citizen_id);
 BA.debugLineNum = 83;BA.debugLine="Dim name As String = properties.Get(\"name\")";
Debug.ShouldStop(262144);
_name = BA.ObjectToString(_properties.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("name")))));Debug.locals.put("name", _name);Debug.locals.put("name", _name);
 BA.debugLineNum = 84;BA.debugLine="Dim count As String = properties.Get(\"count\")";
Debug.ShouldStop(524288);
_count = BA.ObjectToString(_properties.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("count")))));Debug.locals.put("count", _count);Debug.locals.put("count", _count);
 BA.debugLineNum = 85;BA.debugLine="ListView1.AddSingleLine(citizen_id)";
Debug.ShouldStop(1048576);
family_card.mostCurrent._listview1.runVoidMethod ("AddSingleLine",(Object)(BA.ObjectToCharSequence(_citizen_id)));
 BA.debugLineNum = 86;BA.debugLine="ListView1.SingleLineLayout.Label.TextSize=20";
Debug.ShouldStop(2097152);
family_card.mostCurrent._listview1.runMethod(false,"getSingleLineLayout").getField(false,"Label").runMethod(true,"setTextSize",BA.numberCast(float.class, 20));
 BA.debugLineNum = 87;BA.debugLine="ListView1.SingleLineLayout.ItemHeight = 24dip";
Debug.ShouldStop(4194304);
family_card.mostCurrent._listview1.runMethod(false,"getSingleLineLayout").runMethod(true,"setItemHeight",family_card.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 24))));
 BA.debugLineNum = 88;BA.debugLine="ListView1.SingleLineLayout.Label.TextColor =";
Debug.ShouldStop(8388608);
family_card.mostCurrent._listview1.runMethod(false,"getSingleLineLayout").getField(false,"Label").runMethod(true,"setTextColor",family_card.mostCurrent.__c.getField(false,"Colors").getField(true,"Red"));
 BA.debugLineNum = 89;BA.debugLine="ListView1.SingleLineLayout.Label.Gravity=Grav";
Debug.ShouldStop(16777216);
family_card.mostCurrent._listview1.runMethod(false,"getSingleLineLayout").getField(false,"Label").runMethod(true,"setGravity",family_card.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER_HORIZONTAL"));
 }
}Debug.locals.put("colfeatures", _colfeatures);
;
 BA.debugLineNum = 93;BA.debugLine="Label12.Text=count";
Debug.ShouldStop(268435456);
family_card.mostCurrent._label12.runMethod(true,"setText",BA.ObjectToCharSequence(_count));
 break; }
}
;
 }else {
 BA.debugLineNum = 100;BA.debugLine="Log(\"Error: \" & Job.ErrorMessage)";
Debug.ShouldStop(8);
family_card.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("Error: "),_job.getField(true,"_errormessage"))));
 BA.debugLineNum = 101;BA.debugLine="ToastMessageShow(\"Error: \" & Job.ErrorMessage, T";
Debug.ShouldStop(16);
family_card.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Error: "),_job.getField(true,"_errormessage")))),(Object)(family_card.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 103;BA.debugLine="Job.Release";
Debug.ShouldStop(64);
_job.runVoidMethod ("_release");
 BA.debugLineNum = 104;BA.debugLine="End Sub";
Debug.ShouldStop(128);
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
		Debug.PushSubsStack("ListView1_ItemClick (family_card) ","family_card",9,family_card.mostCurrent.activityBA,family_card.mostCurrent,131);
if (RapidSub.canDelegate("listview1_itemclick")) { return b4a.example.family_card.remoteMe.runUserSub(false, "family_card","listview1_itemclick", _position, _value);}
Debug.locals.put("Position", _position);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 131;BA.debugLine="Sub ListView1_ItemClick (Position As Int, Value As";
Debug.ShouldStop(4);
 BA.debugLineNum = 132;BA.debugLine="Button1.Visible=False";
Debug.ShouldStop(8);
family_card.mostCurrent._button1.runMethod(true,"setVisible",family_card.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 133;BA.debugLine="PanPop(\"fcpanel.bal\", 20, 10)";
Debug.ShouldStop(16);
_panpop(BA.ObjectToString("fcpanel.bal"),BA.numberCast(int.class, 20),BA.numberCast(int.class, 10));
 BA.debugLineNum = 135;BA.debugLine="End Sub";
Debug.ShouldStop(64);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _panpop(RemoteObject _mlayout,RemoteObject _hc,RemoteObject _wc) throws Exception{
try {
		Debug.PushSubsStack("PanPop (family_card) ","family_card",9,family_card.mostCurrent.activityBA,family_card.mostCurrent,137);
if (RapidSub.canDelegate("panpop")) { return b4a.example.family_card.remoteMe.runUserSub(false, "family_card","panpop", _mlayout, _hc, _wc);}
Debug.locals.put("mlayout", _mlayout);
Debug.locals.put("hc", _hc);
Debug.locals.put("wc", _wc);
 BA.debugLineNum = 137;BA.debugLine="Sub PanPop (mlayout As String, hc As Int, wc As In";
Debug.ShouldStop(256);
 BA.debugLineNum = 139;BA.debugLine="pnlSelect.Initialize ( \"Select\")";
Debug.ShouldStop(1024);
family_card.mostCurrent._pnlselect.runVoidMethod ("Initialize",family_card.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("Select")));
 BA.debugLineNum = 140;BA.debugLine="pnlInput.Initialize (\"\")";
Debug.ShouldStop(2048);
family_card.mostCurrent._pnlinput.runVoidMethod ("Initialize",family_card.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 141;BA.debugLine="pnlInput.LoadLayout ( mlayout )";
Debug.ShouldStop(4096);
family_card.mostCurrent._pnlinput.runMethodAndSync(false,"LoadLayout",(Object)(_mlayout),family_card.mostCurrent.activityBA);
 BA.debugLineNum = 143;BA.debugLine="pnlSelect.BringToFront";
Debug.ShouldStop(16384);
family_card.mostCurrent._pnlselect.runVoidMethod ("BringToFront");
 BA.debugLineNum = 144;BA.debugLine="pnlSelect.Color  = Colors.ARGB (150,0,0,0)";
Debug.ShouldStop(32768);
family_card.mostCurrent._pnlselect.runVoidMethod ("setColor",family_card.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 150)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0))));
 BA.debugLineNum = 145;BA.debugLine="Activity.AddView (pnlSelect, 0, 0,   100%x, 100%y";
Debug.ShouldStop(65536);
family_card.mostCurrent._activity.runVoidMethod ("AddView",(Object)((family_card.mostCurrent._pnlselect.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(family_card.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),family_card.mostCurrent.activityBA)),(Object)(family_card.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),family_card.mostCurrent.activityBA)));
 BA.debugLineNum = 146;BA.debugLine="mh1=(pnlSelect.Height/2) - (PanelMain.Height/2) +";
Debug.ShouldStop(131072);
family_card._mh1 = BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {family_card.mostCurrent._pnlselect.runMethod(true,"getHeight"),RemoteObject.createImmutable(2)}, "/",0, 0)),(RemoteObject.solve(new RemoteObject[] {family_card.mostCurrent._panelmain.runMethod(true,"getHeight"),RemoteObject.createImmutable(2)}, "/",0, 0)),_hc}, "-+",2, 0));
 BA.debugLineNum = 147;BA.debugLine="mw1=pnlSelect.Width/2 - (PanelMain.Width/2) + wc";
Debug.ShouldStop(262144);
family_card._mw1 = BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {family_card.mostCurrent._pnlselect.runMethod(true,"getWidth"),RemoteObject.createImmutable(2),(RemoteObject.solve(new RemoteObject[] {family_card.mostCurrent._panelmain.runMethod(true,"getWidth"),RemoteObject.createImmutable(2)}, "/",0, 0)),_wc}, "/-+",2, 0));
 BA.debugLineNum = 148;BA.debugLine="mh2=PanelMain.Height";
Debug.ShouldStop(524288);
family_card._mh2 = BA.numberCast(float.class, family_card.mostCurrent._panelmain.runMethod(true,"getHeight"));
 BA.debugLineNum = 149;BA.debugLine="mw2=PanelMain.Width";
Debug.ShouldStop(1048576);
family_card._mw2 = BA.numberCast(float.class, family_card.mostCurrent._panelmain.runMethod(true,"getWidth"));
 BA.debugLineNum = 150;BA.debugLine="pnlSelect.AddView (pnlInput, mw1, mh1, mw2, mh2)";
Debug.ShouldStop(2097152);
family_card.mostCurrent._pnlselect.runVoidMethod ("AddView",(Object)((family_card.mostCurrent._pnlinput.getObject())),(Object)(BA.numberCast(int.class, family_card._mw1)),(Object)(BA.numberCast(int.class, family_card._mh1)),(Object)(BA.numberCast(int.class, family_card._mw2)),(Object)(BA.numberCast(int.class, family_card._mh2)));
 BA.debugLineNum = 152;BA.debugLine="Label1.Text=\"Name: Jesi Namora\"";
Debug.ShouldStop(8388608);
family_card.mostCurrent._label1.runMethod(true,"setText",BA.ObjectToCharSequence("Name: Jesi Namora"));
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
		Debug.PushSubsStack("Select_Click (family_card) ","family_card",9,family_card.mostCurrent.activityBA,family_card.mostCurrent,155);
if (RapidSub.canDelegate("select_click")) { return b4a.example.family_card.remoteMe.runUserSub(false, "family_card","select_click");}
 BA.debugLineNum = 155;BA.debugLine="Sub Select_Click ' Stop clicks on Select panel get";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 157;BA.debugLine="pnlSelect.RemoveView";
Debug.ShouldStop(268435456);
family_card.mostCurrent._pnlselect.runVoidMethod ("RemoveView");
 BA.debugLineNum = 158;BA.debugLine="Button1.Visible=True";
Debug.ShouldStop(536870912);
family_card.mostCurrent._button1.runMethod(true,"setVisible",family_card.mostCurrent.__c.getField(true,"True"));
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
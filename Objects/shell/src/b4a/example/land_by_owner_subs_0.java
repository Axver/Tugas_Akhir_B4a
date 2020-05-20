package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class land_by_owner_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (land_by_owner) ","land_by_owner",11,land_by_owner.mostCurrent.activityBA,land_by_owner.mostCurrent,25);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.land_by_owner.remoteMe.runUserSub(false, "land_by_owner","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 25;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 27;BA.debugLine="Activity.LoadLayout(\"land_by_owner\")";
Debug.ShouldStop(67108864);
land_by_owner.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("land_by_owner")),land_by_owner.mostCurrent.activityBA);
 BA.debugLineNum = 29;BA.debugLine="WebView1.LoadUrl(domain&\"ta_v2/endpoint/view/laye";
Debug.ShouldStop(268435456);
land_by_owner.mostCurrent._webview1.runVoidMethod ("LoadUrl",(Object)(RemoteObject.concat(land_by_owner.mostCurrent._domain,RemoteObject.createImmutable("ta_v2/endpoint/view/layers.php?request=all"))));
 BA.debugLineNum = 30;BA.debugLine="ProgressDialogShow(\"Loading...\")";
Debug.ShouldStop(536870912);
land_by_owner.mostCurrent.__c.runVoidMethod ("ProgressDialogShow",land_by_owner.mostCurrent.activityBA,(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Loading..."))));
 BA.debugLineNum = 33;BA.debugLine="End Sub";
Debug.ShouldStop(1);
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
		Debug.PushSubsStack("Activity_Pause (land_by_owner) ","land_by_owner",11,land_by_owner.mostCurrent.activityBA,land_by_owner.mostCurrent,39);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.land_by_owner.remoteMe.runUserSub(false, "land_by_owner","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 39;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(64);
 BA.debugLineNum = 41;BA.debugLine="End Sub";
Debug.ShouldStop(256);
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
		Debug.PushSubsStack("Activity_Resume (land_by_owner) ","land_by_owner",11,land_by_owner.mostCurrent.activityBA,land_by_owner.mostCurrent,35);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.land_by_owner.remoteMe.runUserSub(false, "land_by_owner","activity_resume");}
 BA.debugLineNum = 35;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(4);
 BA.debugLineNum = 37;BA.debugLine="End Sub";
Debug.ShouldStop(16);
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
		Debug.PushSubsStack("Button1_Click (land_by_owner) ","land_by_owner",11,land_by_owner.mostCurrent.activityBA,land_by_owner.mostCurrent,49);
if (RapidSub.canDelegate("button1_click")) { return b4a.example.land_by_owner.remoteMe.runUserSub(false, "land_by_owner","button1_click");}
RemoteObject _tax_number = RemoteObject.createImmutable("");
 BA.debugLineNum = 49;BA.debugLine="Sub Button1_Click";
Debug.ShouldStop(65536);
 BA.debugLineNum = 50;BA.debugLine="Dim tax_number As String";
Debug.ShouldStop(131072);
_tax_number = RemoteObject.createImmutable("");Debug.locals.put("tax_number", _tax_number);
 BA.debugLineNum = 51;BA.debugLine="tax_number= EditText1.Text";
Debug.ShouldStop(262144);
_tax_number = land_by_owner.mostCurrent._edittext1.runMethod(true,"getText");Debug.locals.put("tax_number", _tax_number);
 BA.debugLineNum = 53;BA.debugLine="WebView1.LoadUrl(domain&\"ta_v2/endpoint/view/land";
Debug.ShouldStop(1048576);
land_by_owner.mostCurrent._webview1.runVoidMethod ("LoadUrl",(Object)(RemoteObject.concat(land_by_owner.mostCurrent._domain,RemoteObject.createImmutable("ta_v2/endpoint/view/land_tax_view.php?tax_number="),_tax_number)));
 BA.debugLineNum = 54;BA.debugLine="ProgressDialogShow(\"Loading...\")";
Debug.ShouldStop(2097152);
land_by_owner.mostCurrent.__c.runVoidMethod ("ProgressDialogShow",land_by_owner.mostCurrent.activityBA,(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Loading..."))));
 BA.debugLineNum = 56;BA.debugLine="job2.Initialize(\"Job2\", Me)";
Debug.ShouldStop(8388608);
land_by_owner.mostCurrent._job2.runVoidMethod ("_initialize",land_by_owner.processBA,(Object)(BA.ObjectToString("Job2")),(Object)(land_by_owner.getObject()));
 BA.debugLineNum = 57;BA.debugLine="job2.PostString(domain&\"ta_v2/endpoint/land_tax.p";
Debug.ShouldStop(16777216);
land_by_owner.mostCurrent._job2.runVoidMethod ("_poststring",(Object)(RemoteObject.concat(land_by_owner.mostCurrent._domain,RemoteObject.createImmutable("ta_v2/endpoint/land_tax.php"))),(Object)(RemoteObject.concat(RemoteObject.createImmutable("tax_number="),_tax_number)));
 BA.debugLineNum = 58;BA.debugLine="ProgressDialogShow(\"Loading...\")";
Debug.ShouldStop(33554432);
land_by_owner.mostCurrent.__c.runVoidMethod ("ProgressDialogShow",land_by_owner.mostCurrent.activityBA,(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Loading..."))));
 BA.debugLineNum = 59;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
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
 //BA.debugLineNum = 16;BA.debugLine="Private WebView1 As WebView";
land_by_owner.mostCurrent._webview1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.WebViewWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Dim domain As String";
land_by_owner.mostCurrent._domain = RemoteObject.createImmutable("");
 //BA.debugLineNum = 18;BA.debugLine="Dim job2 As HttpJob";
land_by_owner.mostCurrent._job2 = RemoteObject.createNew ("anywheresoftware.b4a.samples.httputils2.httpjob");
 //BA.debugLineNum = 20;BA.debugLine="domain=\"http://34d0b8ce.ngrok.io/\"";
land_by_owner.mostCurrent._domain = BA.ObjectToString("http://34d0b8ce.ngrok.io/");
 //BA.debugLineNum = 21;BA.debugLine="Private EditText1 As EditText";
land_by_owner.mostCurrent._edittext1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 22;BA.debugLine="Private ListView1 As ListView";
land_by_owner.mostCurrent._listview1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ListViewWrapper");
 //BA.debugLineNum = 23;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _jobdone(RemoteObject _job) throws Exception{
try {
		Debug.PushSubsStack("JobDone (land_by_owner) ","land_by_owner",11,land_by_owner.mostCurrent.activityBA,land_by_owner.mostCurrent,61);
if (RapidSub.canDelegate("jobdone")) { return b4a.example.land_by_owner.remoteMe.runUserSub(false, "land_by_owner","jobdone", _job);}
RemoteObject _parser = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser");
RemoteObject _root = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _features = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _colfeatures = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _geometry = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _coordinates = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _colcoordinates = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _colcolcoordinates = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _colcolcolcoordinates = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _colcolcolcolcoordinates = RemoteObject.createImmutable(0);
RemoteObject _type = RemoteObject.createImmutable("");
RemoteObject _properties = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _clan_name = RemoteObject.createImmutable("");
RemoteObject _owner_name = RemoteObject.createImmutable("");
RemoteObject _gender = RemoteObject.createImmutable("");
RemoteObject _land_owner = RemoteObject.createImmutable("");
RemoteObject _phone = RemoteObject.createImmutable("");
RemoteObject _tax_number = RemoteObject.createImmutable("");
RemoteObject _status_name = RemoteObject.createImmutable("");
RemoteObject _x = RemoteObject.createImmutable("");
RemoteObject _y = RemoteObject.createImmutable("");
RemoteObject _land_id = RemoteObject.createImmutable("");
RemoteObject _born_date = RemoteObject.createImmutable("");
Debug.locals.put("Job", _job);
 BA.debugLineNum = 61;BA.debugLine="Sub JobDone (Job As HttpJob)";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 63;BA.debugLine="Log(\"JobName = \" & Job.JobName & \", Success = \" &";
Debug.ShouldStop(1073741824);
land_by_owner.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("JobName = "),_job.getField(true,"_jobname"),RemoteObject.createImmutable(", Success = "),_job.getField(true,"_success"))));
 BA.debugLineNum = 64;BA.debugLine="If Job.Success = True Then";
Debug.ShouldStop(-2147483648);
if (RemoteObject.solveBoolean("=",_job.getField(true,"_success"),land_by_owner.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 65;BA.debugLine="ProgressDialogHide";
Debug.ShouldStop(1);
land_by_owner.mostCurrent.__c.runVoidMethod ("ProgressDialogHide");
 BA.debugLineNum = 66;BA.debugLine="Select Job.JobName";
Debug.ShouldStop(2);
switch (BA.switchObjectToInt(_job.getField(true,"_jobname"),BA.ObjectToString("Job2"))) {
case 0: {
 BA.debugLineNum = 68;BA.debugLine="Dim parser As JSONParser";
Debug.ShouldStop(8);
_parser = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("parser", _parser);
 BA.debugLineNum = 69;BA.debugLine="parser.Initialize(Job.GetString)";
Debug.ShouldStop(16);
_parser.runVoidMethod ("Initialize",(Object)(_job.runMethod(true,"_getstring")));
 BA.debugLineNum = 70;BA.debugLine="Log(Job.GetString)";
Debug.ShouldStop(32);
land_by_owner.mostCurrent.__c.runVoidMethod ("Log",(Object)(_job.runMethod(true,"_getstring")));
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
final RemoteObject group11 = _features;
final int groupLen11 = group11.runMethod(true,"getSize").<Integer>get()
;int index11 = 0;
;
for (; index11 < groupLen11;index11++){
_colfeatures.setObject(group11.runMethod(false,"Get",index11));
Debug.locals.put("colfeatures", _colfeatures);
 BA.debugLineNum = 74;BA.debugLine="Dim geometry As Map = colfeatures.Get(\"geomet";
Debug.ShouldStop(512);
_geometry = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_geometry.setObject(_colfeatures.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("geometry")))));Debug.locals.put("geometry", _geometry);
 BA.debugLineNum = 75;BA.debugLine="Dim coordinates As List = geometry.Get(\"coord";
Debug.ShouldStop(1024);
_coordinates = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_coordinates.setObject(_geometry.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("coordinates")))));Debug.locals.put("coordinates", _coordinates);
 BA.debugLineNum = 76;BA.debugLine="For Each colcoordinates As List In coordinate";
Debug.ShouldStop(2048);
_colcoordinates = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
{
final RemoteObject group14 = _coordinates;
final int groupLen14 = group14.runMethod(true,"getSize").<Integer>get()
;int index14 = 0;
;
for (; index14 < groupLen14;index14++){
_colcoordinates.setObject(group14.runMethod(false,"Get",index14));
Debug.locals.put("colcoordinates", _colcoordinates);
 BA.debugLineNum = 77;BA.debugLine="For Each colcolcoordinates As List In colcoo";
Debug.ShouldStop(4096);
_colcolcoordinates = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
{
final RemoteObject group15 = _colcoordinates;
final int groupLen15 = group15.runMethod(true,"getSize").<Integer>get()
;int index15 = 0;
;
for (; index15 < groupLen15;index15++){
_colcolcoordinates.setObject(group15.runMethod(false,"Get",index15));
Debug.locals.put("colcolcoordinates", _colcolcoordinates);
 BA.debugLineNum = 78;BA.debugLine="For Each colcolcolcoordinates As List In co";
Debug.ShouldStop(8192);
_colcolcolcoordinates = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
{
final RemoteObject group16 = _colcolcoordinates;
final int groupLen16 = group16.runMethod(true,"getSize").<Integer>get()
;int index16 = 0;
;
for (; index16 < groupLen16;index16++){
_colcolcolcoordinates.setObject(group16.runMethod(false,"Get",index16));
Debug.locals.put("colcolcolcoordinates", _colcolcolcoordinates);
 BA.debugLineNum = 79;BA.debugLine="For Each colcolcolcolcoordinates As Double";
Debug.ShouldStop(16384);
{
final RemoteObject group17 = _colcolcolcoordinates;
final int groupLen17 = group17.runMethod(true,"getSize").<Integer>get()
;int index17 = 0;
;
for (; index17 < groupLen17;index17++){
_colcolcolcolcoordinates = BA.numberCast(double.class, group17.runMethod(false,"Get",index17));Debug.locals.put("colcolcolcolcoordinates", _colcolcolcolcoordinates);
Debug.locals.put("colcolcolcolcoordinates", _colcolcolcolcoordinates);
 }
}Debug.locals.put("colcolcolcolcoordinates", _colcolcolcolcoordinates);
;
 }
}Debug.locals.put("colcolcolcoordinates", _colcolcolcoordinates);
;
 }
}Debug.locals.put("colcolcoordinates", _colcolcoordinates);
;
 }
}Debug.locals.put("colcoordinates", _colcoordinates);
;
 BA.debugLineNum = 84;BA.debugLine="Dim Type As String = geometry.Get(\"type\")";
Debug.ShouldStop(524288);
_type = BA.ObjectToString(_geometry.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("type")))));Debug.locals.put("Type", _type);Debug.locals.put("Type", _type);
 BA.debugLineNum = 85;BA.debugLine="Dim Type As String = colfeatures.Get(\"type\")";
Debug.ShouldStop(1048576);
_type = BA.ObjectToString(_colfeatures.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("type")))));Debug.locals.put("Type", _type);Debug.locals.put("Type", _type);
 BA.debugLineNum = 86;BA.debugLine="Dim properties As Map = colfeatures.Get(\"prop";
Debug.ShouldStop(2097152);
_properties = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_properties.setObject(_colfeatures.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("properties")))));Debug.locals.put("properties", _properties);
 BA.debugLineNum = 87;BA.debugLine="Dim clan_name As String = properties.Get(\"cla";
Debug.ShouldStop(4194304);
_clan_name = BA.ObjectToString(_properties.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("clan_name")))));Debug.locals.put("clan_name", _clan_name);Debug.locals.put("clan_name", _clan_name);
 BA.debugLineNum = 88;BA.debugLine="Dim owner_name As String = properties.Get(\"ow";
Debug.ShouldStop(8388608);
_owner_name = BA.ObjectToString(_properties.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("owner_name")))));Debug.locals.put("owner_name", _owner_name);Debug.locals.put("owner_name", _owner_name);
 BA.debugLineNum = 89;BA.debugLine="Dim gender As String = properties.Get(\"gender";
Debug.ShouldStop(16777216);
_gender = BA.ObjectToString(_properties.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("gender")))));Debug.locals.put("gender", _gender);Debug.locals.put("gender", _gender);
 BA.debugLineNum = 90;BA.debugLine="Dim land_owner As String = properties.Get(\"la";
Debug.ShouldStop(33554432);
_land_owner = BA.ObjectToString(_properties.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("land_owner")))));Debug.locals.put("land_owner", _land_owner);Debug.locals.put("land_owner", _land_owner);
 BA.debugLineNum = 91;BA.debugLine="Dim phone As String = properties.Get(\"phone\")";
Debug.ShouldStop(67108864);
_phone = BA.ObjectToString(_properties.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("phone")))));Debug.locals.put("phone", _phone);Debug.locals.put("phone", _phone);
 BA.debugLineNum = 92;BA.debugLine="Dim tax_number As String = properties.Get(\"ta";
Debug.ShouldStop(134217728);
_tax_number = BA.ObjectToString(_properties.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("tax_number")))));Debug.locals.put("tax_number", _tax_number);Debug.locals.put("tax_number", _tax_number);
 BA.debugLineNum = 93;BA.debugLine="Dim status_name As String = properties.Get(\"s";
Debug.ShouldStop(268435456);
_status_name = BA.ObjectToString(_properties.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("status_name")))));Debug.locals.put("status_name", _status_name);Debug.locals.put("status_name", _status_name);
 BA.debugLineNum = 94;BA.debugLine="Dim x As String = properties.Get(\"x\")";
Debug.ShouldStop(536870912);
_x = BA.ObjectToString(_properties.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("x")))));Debug.locals.put("x", _x);Debug.locals.put("x", _x);
 BA.debugLineNum = 95;BA.debugLine="Dim y As String = properties.Get(\"y\")";
Debug.ShouldStop(1073741824);
_y = BA.ObjectToString(_properties.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("y")))));Debug.locals.put("y", _y);Debug.locals.put("y", _y);
 BA.debugLineNum = 96;BA.debugLine="Dim land_id As String = properties.Get(\"land_";
Debug.ShouldStop(-2147483648);
_land_id = BA.ObjectToString(_properties.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("land_id")))));Debug.locals.put("land_id", _land_id);Debug.locals.put("land_id", _land_id);
 BA.debugLineNum = 97;BA.debugLine="Dim born_date As String = properties.Get(\"bor";
Debug.ShouldStop(1);
_born_date = BA.ObjectToString(_properties.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("born_date")))));Debug.locals.put("born_date", _born_date);Debug.locals.put("born_date", _born_date);
 BA.debugLineNum = 100;BA.debugLine="ListView1.AddSingleLine(\"Information\")";
Debug.ShouldStop(8);
land_by_owner.mostCurrent._listview1.runVoidMethod ("AddSingleLine",(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Information"))));
 BA.debugLineNum = 101;BA.debugLine="ListView1.SingleLineLayout.Label.TextSize = 1";
Debug.ShouldStop(16);
land_by_owner.mostCurrent._listview1.runMethod(false,"getSingleLineLayout").getField(false,"Label").runMethod(true,"setTextSize",BA.numberCast(float.class, 12));
 BA.debugLineNum = 102;BA.debugLine="ListView1.SingleLineLayout.Label.TextColor =";
Debug.ShouldStop(32);
land_by_owner.mostCurrent._listview1.runMethod(false,"getSingleLineLayout").getField(false,"Label").runMethod(true,"setTextColor",land_by_owner.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 103;BA.debugLine="ListView1.AddSingleLine(\"Clan Name:\"&clan_nam";
Debug.ShouldStop(64);
land_by_owner.mostCurrent._listview1.runVoidMethod ("AddSingleLine",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Clan Name:"),_clan_name))));
 BA.debugLineNum = 104;BA.debugLine="ListView1.AddSingleLine(\"Owner Name:\"&owner_n";
Debug.ShouldStop(128);
land_by_owner.mostCurrent._listview1.runVoidMethod ("AddSingleLine",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Owner Name:"),_owner_name))));
 BA.debugLineNum = 105;BA.debugLine="ListView1.AddSingleLine(\"Gender:\"&gender)";
Debug.ShouldStop(256);
land_by_owner.mostCurrent._listview1.runVoidMethod ("AddSingleLine",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Gender:"),_gender))));
 BA.debugLineNum = 106;BA.debugLine="ListView1.AddSingleLine(\"Land Owner:\"&land_ow";
Debug.ShouldStop(512);
land_by_owner.mostCurrent._listview1.runVoidMethod ("AddSingleLine",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Land Owner:"),_land_owner))));
 BA.debugLineNum = 107;BA.debugLine="ListView1.AddSingleLine(\"Phone:\"&phone)";
Debug.ShouldStop(1024);
land_by_owner.mostCurrent._listview1.runVoidMethod ("AddSingleLine",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Phone:"),_phone))));
 BA.debugLineNum = 108;BA.debugLine="ListView1.AddSingleLine(\"Tax Number:\"&tax_num";
Debug.ShouldStop(2048);
land_by_owner.mostCurrent._listview1.runVoidMethod ("AddSingleLine",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Tax Number:"),_tax_number))));
 BA.debugLineNum = 109;BA.debugLine="ListView1.AddSingleLine(\"Status:\"&status_name";
Debug.ShouldStop(4096);
land_by_owner.mostCurrent._listview1.runVoidMethod ("AddSingleLine",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Status:"),_status_name))));
 BA.debugLineNum = 110;BA.debugLine="ListView1.AddSingleLine(\"Land Id:\"&land_id)";
Debug.ShouldStop(8192);
land_by_owner.mostCurrent._listview1.runVoidMethod ("AddSingleLine",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Land Id:"),_land_id))));
 BA.debugLineNum = 111;BA.debugLine="ListView1.AddSingleLine(\"Coordinates:\"&x&\"||\"";
Debug.ShouldStop(16384);
land_by_owner.mostCurrent._listview1.runVoidMethod ("AddSingleLine",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Coordinates:"),_x,RemoteObject.createImmutable("||"),_y))));
 }
}Debug.locals.put("colfeatures", _colfeatures);
;
 BA.debugLineNum = 113;BA.debugLine="Dim Type As String = root.Get(\"type\")";
Debug.ShouldStop(65536);
_type = BA.ObjectToString(_root.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("type")))));Debug.locals.put("Type", _type);Debug.locals.put("Type", _type);
 break; }
}
;
 }else {
 BA.debugLineNum = 125;BA.debugLine="Log(\"Error: \" & Job.ErrorMessage)";
Debug.ShouldStop(268435456);
land_by_owner.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("Error: "),_job.getField(true,"_errormessage"))));
 BA.debugLineNum = 126;BA.debugLine="ToastMessageShow(\"Error: \" & Job.ErrorMessage, T";
Debug.ShouldStop(536870912);
land_by_owner.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Error: "),_job.getField(true,"_errormessage")))),(Object)(land_by_owner.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 128;BA.debugLine="Job.Release";
Debug.ShouldStop(-2147483648);
_job.runVoidMethod ("_release");
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
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _webview1_pagefinished(RemoteObject _strurl) throws Exception{
try {
		Debug.PushSubsStack("webview1_PageFinished (land_by_owner) ","land_by_owner",11,land_by_owner.mostCurrent.activityBA,land_by_owner.mostCurrent,43);
if (RapidSub.canDelegate("webview1_pagefinished")) { return b4a.example.land_by_owner.remoteMe.runUserSub(false, "land_by_owner","webview1_pagefinished", _strurl);}
Debug.locals.put("StrUrl", _strurl);
 BA.debugLineNum = 43;BA.debugLine="Sub webview1_PageFinished (StrUrl As String)";
Debug.ShouldStop(1024);
 BA.debugLineNum = 44;BA.debugLine="ProgressDialogHide";
Debug.ShouldStop(2048);
land_by_owner.mostCurrent.__c.runVoidMethod ("ProgressDialogHide");
 BA.debugLineNum = 46;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}
package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class add_outcome_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (add_outcome) ","add_outcome",8,add_outcome.mostCurrent.activityBA,add_outcome.mostCurrent,26);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.add_outcome.remoteMe.runUserSub(false, "add_outcome","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 26;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 28;BA.debugLine="Activity.LoadLayout(\"add_outcome\")";
Debug.ShouldStop(134217728);
add_outcome.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("add_outcome")),add_outcome.mostCurrent.activityBA);
 BA.debugLineNum = 30;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
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
		Debug.PushSubsStack("Activity_Pause (add_outcome) ","add_outcome",8,add_outcome.mostCurrent.activityBA,add_outcome.mostCurrent,36);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.add_outcome.remoteMe.runUserSub(false, "add_outcome","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 36;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(8);
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
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (add_outcome) ","add_outcome",8,add_outcome.mostCurrent.activityBA,add_outcome.mostCurrent,32);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.add_outcome.remoteMe.runUserSub(false, "add_outcome","activity_resume");}
 BA.debugLineNum = 32;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 34;BA.debugLine="End Sub";
Debug.ShouldStop(2);
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
		Debug.PushSubsStack("Button1_Click (add_outcome) ","add_outcome",8,add_outcome.mostCurrent.activityBA,add_outcome.mostCurrent,41);
if (RapidSub.canDelegate("button1_click")) { return b4a.example.add_outcome.remoteMe.runUserSub(false, "add_outcome","button1_click");}
RemoteObject _citizen_id = RemoteObject.createImmutable("");
RemoteObject _from = RemoteObject.createImmutable("");
RemoteObject _destination = RemoteObject.createImmutable("");
RemoteObject _status = RemoteObject.createImmutable("");
 BA.debugLineNum = 41;BA.debugLine="Sub Button1_Click";
Debug.ShouldStop(256);
 BA.debugLineNum = 43;BA.debugLine="Dim citizen_id As String";
Debug.ShouldStop(1024);
_citizen_id = RemoteObject.createImmutable("");Debug.locals.put("citizen_id", _citizen_id);
 BA.debugLineNum = 44;BA.debugLine="Dim from As String";
Debug.ShouldStop(2048);
_from = RemoteObject.createImmutable("");Debug.locals.put("from", _from);
 BA.debugLineNum = 45;BA.debugLine="Dim destination As String";
Debug.ShouldStop(4096);
_destination = RemoteObject.createImmutable("");Debug.locals.put("destination", _destination);
 BA.debugLineNum = 46;BA.debugLine="Dim status As String";
Debug.ShouldStop(8192);
_status = RemoteObject.createImmutable("");Debug.locals.put("status", _status);
 BA.debugLineNum = 48;BA.debugLine="citizen_id=EditText1.Text";
Debug.ShouldStop(32768);
_citizen_id = add_outcome.mostCurrent._edittext1.runMethod(true,"getText");Debug.locals.put("citizen_id", _citizen_id);
 BA.debugLineNum = 49;BA.debugLine="from=EditText2.Text";
Debug.ShouldStop(65536);
_from = add_outcome.mostCurrent._edittext2.runMethod(true,"getText");Debug.locals.put("from", _from);
 BA.debugLineNum = 50;BA.debugLine="destination=EditText3.Text";
Debug.ShouldStop(131072);
_destination = add_outcome.mostCurrent._edittext3.runMethod(true,"getText");Debug.locals.put("destination", _destination);
 BA.debugLineNum = 51;BA.debugLine="status=EditText4.Text";
Debug.ShouldStop(262144);
_status = add_outcome.mostCurrent._edittext4.runMethod(true,"getText");Debug.locals.put("status", _status);
 BA.debugLineNum = 54;BA.debugLine="job2.Initialize(\"Job2\", Me)";
Debug.ShouldStop(2097152);
add_outcome.mostCurrent._job2.runVoidMethod ("_initialize",add_outcome.processBA,(Object)(BA.ObjectToString("Job2")),(Object)(add_outcome.getObject()));
 BA.debugLineNum = 55;BA.debugLine="job2.PostString(domain&\"ta_v2/endpoint/addOutcome";
Debug.ShouldStop(4194304);
add_outcome.mostCurrent._job2.runVoidMethod ("_poststring",(Object)(RemoteObject.concat(add_outcome.mostCurrent._domain,RemoteObject.createImmutable("ta_v2/endpoint/addOutcome.php"))),(Object)(RemoteObject.concat(RemoteObject.createImmutable("citizen_id="),_citizen_id,RemoteObject.createImmutable("&from="),_from,RemoteObject.createImmutable("&destination="),_destination,RemoteObject.createImmutable("&status="),_status)));
 BA.debugLineNum = 56;BA.debugLine="ProgressDialogShow(\"Loading...\")";
Debug.ShouldStop(8388608);
add_outcome.mostCurrent.__c.runVoidMethod ("ProgressDialogShow",add_outcome.mostCurrent.activityBA,(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Loading..."))));
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
public static RemoteObject  _button3_click() throws Exception{
try {
		Debug.PushSubsStack("Button3_Click (add_outcome) ","add_outcome",8,add_outcome.mostCurrent.activityBA,add_outcome.mostCurrent,95);
if (RapidSub.canDelegate("button3_click")) { return b4a.example.add_outcome.remoteMe.runUserSub(false, "add_outcome","button3_click");}
 BA.debugLineNum = 95;BA.debugLine="Sub Button3_Click";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 97;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 15;BA.debugLine="Dim domain As String";
add_outcome.mostCurrent._domain = RemoteObject.createImmutable("");
 //BA.debugLineNum = 16;BA.debugLine="Dim job2 As HttpJob";
add_outcome.mostCurrent._job2 = RemoteObject.createNew ("anywheresoftware.b4a.samples.httputils2.httpjob");
 //BA.debugLineNum = 17;BA.debugLine="Private EditText1 As EditText";
add_outcome.mostCurrent._edittext1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Private EditText2 As EditText";
add_outcome.mostCurrent._edittext2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Private EditText3 As EditText";
add_outcome.mostCurrent._edittext3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 20;BA.debugLine="Private EditText4 As EditText";
add_outcome.mostCurrent._edittext4 = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Private EditText5 As EditText";
add_outcome.mostCurrent._edittext5 = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 22;BA.debugLine="Private Button1 As Button";
add_outcome.mostCurrent._button1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 23;BA.debugLine="domain=\"http://ca024f23.ngrok.io/\"";
add_outcome.mostCurrent._domain = BA.ObjectToString("http://ca024f23.ngrok.io/");
 //BA.debugLineNum = 24;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _jobdone(RemoteObject _job) throws Exception{
try {
		Debug.PushSubsStack("JobDone (add_outcome) ","add_outcome",8,add_outcome.mostCurrent.activityBA,add_outcome.mostCurrent,59);
if (RapidSub.canDelegate("jobdone")) { return b4a.example.add_outcome.remoteMe.runUserSub(false, "add_outcome","jobdone", _job);}
Debug.locals.put("Job", _job);
 BA.debugLineNum = 59;BA.debugLine="Sub JobDone (Job As HttpJob)";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 61;BA.debugLine="Log(\"JobName = \" & Job.JobName & \", Success = \" &";
Debug.ShouldStop(268435456);
add_outcome.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("JobName = "),_job.getField(true,"_jobname"),RemoteObject.createImmutable(", Success = "),_job.getField(true,"_success"))));
 BA.debugLineNum = 62;BA.debugLine="If Job.Success = True Then";
Debug.ShouldStop(536870912);
if (RemoteObject.solveBoolean("=",_job.getField(true,"_success"),add_outcome.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 65;BA.debugLine="Select Job.JobName";
Debug.ShouldStop(1);
switch (BA.switchObjectToInt(_job.getField(true,"_jobname"),BA.ObjectToString("Job2"))) {
case 0: {
 BA.debugLineNum = 68;BA.debugLine="Log(Job.GetString)";
Debug.ShouldStop(8);
add_outcome.mostCurrent.__c.runVoidMethod ("Log",(Object)(_job.runMethod(true,"_getstring")));
 BA.debugLineNum = 69;BA.debugLine="If Job.GetString=\"Success\" Then";
Debug.ShouldStop(16);
if (RemoteObject.solveBoolean("=",_job.runMethod(true,"_getstring"),BA.ObjectToString("Success"))) { 
 BA.debugLineNum = 70;BA.debugLine="StartActivity(\"outcome\")";
Debug.ShouldStop(32);
add_outcome.mostCurrent.__c.runVoidMethod ("StartActivity",add_outcome.processBA,(Object)((RemoteObject.createImmutable("outcome"))));
 }else {
 BA.debugLineNum = 72;BA.debugLine="Log(\"Failed To Input Data\")";
Debug.ShouldStop(128);
add_outcome.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.createImmutable("Failed To Input Data")));
 };
 BA.debugLineNum = 79;BA.debugLine="ProgressDialogHide";
Debug.ShouldStop(16384);
add_outcome.mostCurrent.__c.runVoidMethod ("ProgressDialogHide");
 break; }
}
;
 }else {
 BA.debugLineNum = 84;BA.debugLine="Log(\"Error: \" & Job.ErrorMessage)";
Debug.ShouldStop(524288);
add_outcome.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("Error: "),_job.getField(true,"_errormessage"))));
 BA.debugLineNum = 85;BA.debugLine="ToastMessageShow(\"Error: \" & Job.ErrorMessage, T";
Debug.ShouldStop(1048576);
add_outcome.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Error: "),_job.getField(true,"_errormessage")))),(Object)(add_outcome.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 87;BA.debugLine="Job.Release";
Debug.ShouldStop(4194304);
_job.runVoidMethod ("_release");
 BA.debugLineNum = 88;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
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
		Debug.PushSubsStack("Label3_Click (add_outcome) ","add_outcome",8,add_outcome.mostCurrent.activityBA,add_outcome.mostCurrent,91);
if (RapidSub.canDelegate("label3_click")) { return b4a.example.add_outcome.remoteMe.runUserSub(false, "add_outcome","label3_click");}
 BA.debugLineNum = 91;BA.debugLine="Sub Label3_Click";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 92;BA.debugLine="StartActivity(\"dashboard\")";
Debug.ShouldStop(134217728);
add_outcome.mostCurrent.__c.runVoidMethod ("StartActivity",add_outcome.processBA,(Object)((RemoteObject.createImmutable("dashboard"))));
 BA.debugLineNum = 93;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
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
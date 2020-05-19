package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,28);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 28;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 30;BA.debugLine="Activity.LoadLayout(\"login\")";
Debug.ShouldStop(536870912);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("login")),main.mostCurrent.activityBA);
 BA.debugLineNum = 32;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
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
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,38);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 38;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(32);
 BA.debugLineNum = 40;BA.debugLine="End Sub";
Debug.ShouldStop(128);
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
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,34);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_resume");}
 BA.debugLineNum = 34;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(2);
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
public static RemoteObject  _button1_click() throws Exception{
try {
		Debug.PushSubsStack("Button1_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,43);
if (RapidSub.canDelegate("button1_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","button1_click");}
 BA.debugLineNum = 43;BA.debugLine="Sub Button1_Click";
Debug.ShouldStop(1024);
 BA.debugLineNum = 44;BA.debugLine="StartActivity(\"dashboard\")";
Debug.ShouldStop(2048);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((RemoteObject.createImmutable("dashboard"))));
 BA.debugLineNum = 45;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 22;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 26;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main_subs_0._process_globals();
starter_subs_0._process_globals();
dashboard_subs_0._process_globals();
birth_subs_0._process_globals();
add_birth_subs_0._process_globals();
mortality_subs_0._process_globals();
add_mortality_subs_0._process_globals();
outcome_subs_0._process_globals();
add_outcome_subs_0._process_globals();
family_card_subs_0._process_globals();
citizen_subs_0._process_globals();
lands_id_subs_0._process_globals();
lands_subs_0._process_globals();
land_by_owner_subs_0._process_globals();
building_id_subs_0._process_globals();
building_owner_subs_0._process_globals();
buildings_subs_0._process_globals();
owner_states_subs_0._process_globals();
owners_subs_0._process_globals();
main.myClass = BA.getDeviceClass ("b4a.example.main");
starter.myClass = BA.getDeviceClass ("b4a.example.starter");
dashboard.myClass = BA.getDeviceClass ("b4a.example.dashboard");
birth.myClass = BA.getDeviceClass ("b4a.example.birth");
add_birth.myClass = BA.getDeviceClass ("b4a.example.add_birth");
mortality.myClass = BA.getDeviceClass ("b4a.example.mortality");
add_mortality.myClass = BA.getDeviceClass ("b4a.example.add_mortality");
outcome.myClass = BA.getDeviceClass ("b4a.example.outcome");
add_outcome.myClass = BA.getDeviceClass ("b4a.example.add_outcome");
family_card.myClass = BA.getDeviceClass ("b4a.example.family_card");
citizen.myClass = BA.getDeviceClass ("b4a.example.citizen");
lands_id.myClass = BA.getDeviceClass ("b4a.example.lands_id");
lands.myClass = BA.getDeviceClass ("b4a.example.lands");
land_by_owner.myClass = BA.getDeviceClass ("b4a.example.land_by_owner");
building_id.myClass = BA.getDeviceClass ("b4a.example.building_id");
building_owner.myClass = BA.getDeviceClass ("b4a.example.building_owner");
buildings.myClass = BA.getDeviceClass ("b4a.example.buildings");
owner_states.myClass = BA.getDeviceClass ("b4a.example.owner_states");
owners.myClass = BA.getDeviceClass ("b4a.example.owners");
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 16;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 20;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}
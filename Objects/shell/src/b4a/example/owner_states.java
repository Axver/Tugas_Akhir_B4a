
package b4a.example;

import java.io.IOException;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RDebug;
import anywheresoftware.b4a.pc.RemoteObject;
import anywheresoftware.b4a.pc.RDebug.IRemote;
import anywheresoftware.b4a.pc.Debug;
import anywheresoftware.b4a.pc.B4XTypes.B4XClass;
import anywheresoftware.b4a.pc.B4XTypes.DeviceClass;

public class owner_states implements IRemote{
	public static owner_states mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public owner_states() {
		mostCurrent = this;
	}
    public RemoteObject getRemoteMe() {
        return remoteMe;    
    }
    
	public static void main (String[] args) throws Exception {
		new RDebug(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]), args[3]);
		RDebug.INSTANCE.waitForTask();

	}
    static {
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("owner_states"), "b4a.example.owner_states");
	}

public boolean isSingleton() {
		return true;
	}
     public static RemoteObject getObject() {
		return myClass;
	 }

	public RemoteObject activityBA;
	public RemoteObject _activity;
    private PCBA pcBA;

	public PCBA create(Object[] args) throws ClassNotFoundException{
		processBA = (RemoteObject) args[1];
		activityBA = (RemoteObject) args[2];
		_activity = (RemoteObject) args[3];
        anywheresoftware.b4a.keywords.Common.Density = (Float)args[4];
        remoteMe = (RemoteObject) args[5];
		pcBA = new PCBA(this, owner_states.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _httputils2service = RemoteObject.declareNull("anywheresoftware.b4a.samples.httputils2.httputils2service");
public static b4a.example.main _main = null;
public static b4a.example.starter _starter = null;
public static b4a.example.dashboard _dashboard = null;
public static b4a.example.birth _birth = null;
public static b4a.example.add_birth _add_birth = null;
public static b4a.example.mortality _mortality = null;
public static b4a.example.add_mortality _add_mortality = null;
public static b4a.example.outcome _outcome = null;
public static b4a.example.add_outcome _add_outcome = null;
public static b4a.example.family_card _family_card = null;
public static b4a.example.citizen _citizen = null;
public static b4a.example.land_by_owner _land_by_owner = null;
public static b4a.example.building_id _building_id = null;
public static b4a.example.building_owner _building_owner = null;
public static b4a.example.buildings _buildings = null;
public static b4a.example.owners _owners = null;
public static b4a.example.lands _lands = null;
public static b4a.example.lands_id _lands_id = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",owner_states.mostCurrent._activity,"add_birth",Debug.moduleToString(b4a.example.add_birth.class),"add_mortality",Debug.moduleToString(b4a.example.add_mortality.class),"add_outcome",Debug.moduleToString(b4a.example.add_outcome.class),"birth",Debug.moduleToString(b4a.example.birth.class),"building_id",Debug.moduleToString(b4a.example.building_id.class),"building_owner",Debug.moduleToString(b4a.example.building_owner.class),"buildings",Debug.moduleToString(b4a.example.buildings.class),"citizen",Debug.moduleToString(b4a.example.citizen.class),"dashboard",Debug.moduleToString(b4a.example.dashboard.class),"family_card",Debug.moduleToString(b4a.example.family_card.class),"HttpUtils2Service",owner_states.mostCurrent._httputils2service,"land_by_owner",Debug.moduleToString(b4a.example.land_by_owner.class),"lands",Debug.moduleToString(b4a.example.lands.class),"lands_id",Debug.moduleToString(b4a.example.lands_id.class),"Main",Debug.moduleToString(b4a.example.main.class),"mortality",Debug.moduleToString(b4a.example.mortality.class),"outcome",Debug.moduleToString(b4a.example.outcome.class),"owners",Debug.moduleToString(b4a.example.owners.class),"Starter",Debug.moduleToString(b4a.example.starter.class)};
}
}
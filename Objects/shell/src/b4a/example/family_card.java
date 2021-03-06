
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

public class family_card implements IRemote{
	public static family_card mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public family_card() {
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
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("family_card"), "b4a.example.family_card");
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
		pcBA = new PCBA(this, family_card.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _pnlinput = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _pnlselect = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _panelmain = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _domain = RemoteObject.createImmutable("");
public static RemoteObject _mh1 = RemoteObject.createImmutable(0f);
public static RemoteObject _mh2 = RemoteObject.createImmutable(0f);
public static RemoteObject _mw1 = RemoteObject.createImmutable(0f);
public static RemoteObject _mw2 = RemoteObject.createImmutable(0f);
public static RemoteObject _job2 = RemoteObject.declareNull("anywheresoftware.b4a.samples.httputils2.httpjob");
public static RemoteObject _citizen_name_g = RemoteObject.createImmutable("");
public static RemoteObject _clan_g = RemoteObject.createImmutable("");
public static RemoteObject _gender_g = RemoteObject.createImmutable("");
public static RemoteObject _phone_g = RemoteObject.createImmutable("");
public static RemoteObject _status_g = RemoteObject.createImmutable("");
public static RemoteObject _label10 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _label11 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _edittext1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _listview1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.ListViewWrapper");
public static RemoteObject _label12 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _button1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _label1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _label2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _label3 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _label4 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _label5 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
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
public static b4a.example.citizen _citizen = null;
public static b4a.example.land_by_owner _land_by_owner = null;
public static b4a.example.building_id _building_id = null;
public static b4a.example.building_owner _building_owner = null;
public static b4a.example.buildings _buildings = null;
public static b4a.example.owner_states _owner_states = null;
public static b4a.example.owners _owners = null;
public static b4a.example.lands _lands = null;
public static b4a.example.lands_id _lands_id = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",family_card.mostCurrent._activity,"add_birth",Debug.moduleToString(b4a.example.add_birth.class),"add_mortality",Debug.moduleToString(b4a.example.add_mortality.class),"add_outcome",Debug.moduleToString(b4a.example.add_outcome.class),"birth",Debug.moduleToString(b4a.example.birth.class),"building_id",Debug.moduleToString(b4a.example.building_id.class),"building_owner",Debug.moduleToString(b4a.example.building_owner.class),"buildings",Debug.moduleToString(b4a.example.buildings.class),"Button1",family_card.mostCurrent._button1,"citizen",Debug.moduleToString(b4a.example.citizen.class),"citizen_name_g",family_card.mostCurrent._citizen_name_g,"clan_g",family_card.mostCurrent._clan_g,"dashboard",Debug.moduleToString(b4a.example.dashboard.class),"domain",family_card.mostCurrent._domain,"EditText1",family_card.mostCurrent._edittext1,"gender_g",family_card.mostCurrent._gender_g,"HttpUtils2Service",family_card.mostCurrent._httputils2service,"job2",family_card.mostCurrent._job2,"Label1",family_card.mostCurrent._label1,"Label10",family_card.mostCurrent._label10,"Label11",family_card.mostCurrent._label11,"Label12",family_card.mostCurrent._label12,"Label2",family_card.mostCurrent._label2,"Label3",family_card.mostCurrent._label3,"Label4",family_card.mostCurrent._label4,"Label5",family_card.mostCurrent._label5,"land_by_owner",Debug.moduleToString(b4a.example.land_by_owner.class),"lands",Debug.moduleToString(b4a.example.lands.class),"lands_id",Debug.moduleToString(b4a.example.lands_id.class),"ListView1",family_card.mostCurrent._listview1,"Main",Debug.moduleToString(b4a.example.main.class),"mh1",family_card._mh1,"mh2",family_card._mh2,"mortality",Debug.moduleToString(b4a.example.mortality.class),"mw1",family_card._mw1,"mw2",family_card._mw2,"outcome",Debug.moduleToString(b4a.example.outcome.class),"owner_states",Debug.moduleToString(b4a.example.owner_states.class),"owners",Debug.moduleToString(b4a.example.owners.class),"PanelMain",family_card.mostCurrent._panelmain,"phone_g",family_card.mostCurrent._phone_g,"pnlInput",family_card.mostCurrent._pnlinput,"pnlSelect",family_card.mostCurrent._pnlselect,"Starter",Debug.moduleToString(b4a.example.starter.class),"status_g",family_card.mostCurrent._status_g};
}
}
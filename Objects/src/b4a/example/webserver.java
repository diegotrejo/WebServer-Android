package b4a.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.objects.ServiceHelper;
import anywheresoftware.b4a.debug.*;

public class webserver extends android.app.Service{
	public static class webserver_BR extends android.content.BroadcastReceiver {

		@Override
		public void onReceive(android.content.Context context, android.content.Intent intent) {
            BA.LogInfo("** Receiver (webserver) OnReceive **");
			android.content.Intent in = new android.content.Intent(context, webserver.class);
			if (intent != null)
				in.putExtra("b4a_internal_intent", intent);
            ServiceHelper.StarterHelper.startServiceFromReceiver (context, in, false, anywheresoftware.b4a.ShellBA.class);
		}

	}
    static webserver mostCurrent;
	public static BA processBA;
    private ServiceHelper _service;
    public static Class<?> getObject() {
		return webserver.class;
	}
	@Override
	public void onCreate() {
        super.onCreate();
        mostCurrent = this;
        if (processBA == null) {
		    processBA = new anywheresoftware.b4a.ShellBA(this, null, null, "b4a.example", "b4a.example.webserver");
            if (BA.isShellModeRuntimeCheck(processBA)) {
                processBA.raiseEvent2(null, true, "SHELL", false);
		    }
            try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            processBA.loadHtSubs(this.getClass());
            ServiceHelper.init();
        }
        _service = new ServiceHelper(this);
        processBA.service = this;
        
        if (BA.isShellModeRuntimeCheck(processBA)) {
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.webserver", processBA, _service, anywheresoftware.b4a.keywords.Common.Density);
		}
        if (!false && ServiceHelper.StarterHelper.startFromServiceCreate(processBA, true) == false) {
				
		}
		else {
            processBA.setActivityPaused(false);
            BA.LogInfo("*** Service (webserver) Create ***");
            processBA.raiseEvent(null, "service_create");
        }
        processBA.runHook("oncreate", this, null);
        if (false) {
			ServiceHelper.StarterHelper.runWaitForLayouts();
		}
    }
		@Override
	public void onStart(android.content.Intent intent, int startId) {
		onStartCommand(intent, 0, 0);
    }
    @Override
    public int onStartCommand(final android.content.Intent intent, int flags, int startId) {
    	if (ServiceHelper.StarterHelper.onStartCommand(processBA, new Runnable() {
            public void run() {
                handleStart(intent);
            }}))
			;
		else {
			ServiceHelper.StarterHelper.addWaitForLayout (new Runnable() {
				public void run() {
                    processBA.setActivityPaused(false);
                    BA.LogInfo("** Service (webserver) Create **");
                    processBA.raiseEvent(null, "service_create");
					handleStart(intent);
                    ServiceHelper.StarterHelper.removeWaitForLayout();
				}
			});
		}
        processBA.runHook("onstartcommand", this, new Object[] {intent, flags, startId});
		return android.app.Service.START_NOT_STICKY;
    }
    public void onTaskRemoved(android.content.Intent rootIntent) {
        super.onTaskRemoved(rootIntent);
        if (false)
            processBA.raiseEvent(null, "service_taskremoved");
            
    }
    private void handleStart(android.content.Intent intent) {
    	BA.LogInfo("** Service (webserver) Start **");
    	java.lang.reflect.Method startEvent = processBA.htSubs.get("service_start");
    	if (startEvent != null) {
    		if (startEvent.getParameterTypes().length > 0) {
    			anywheresoftware.b4a.objects.IntentWrapper iw = ServiceHelper.StarterHelper.handleStartIntent(intent, _service, processBA);
    			processBA.raiseEvent(null, "service_start", iw);
    		}
    		else {
    			processBA.raiseEvent(null, "service_start");
    		}
    	}
    }
	
	@Override
	public void onDestroy() {
        super.onDestroy();
        if (false) {
            BA.LogInfo("** Service (webserver) Destroy (ignored)**");
        }
        else {
            BA.LogInfo("** Service (webserver) Destroy **");
		    processBA.raiseEvent(null, "service_destroy");
            processBA.service = null;
		    mostCurrent = null;
		    processBA.setActivityPaused(true);
            processBA.runHook("ondestroy", this, null);
        }
	}

@Override
	public android.os.IBinder onBind(android.content.Intent intent) {
		return null;
	}
public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.objects.HttpServer _httpserver = null;
public static boolean _servicioactivo = false;
public b4a.example.main _main = null;
public static boolean  _application_error(anywheresoftware.b4a.objects.B4AException _error,String _stacktrace) throws Exception{
RDebugUtils.currentModule="webserver";
if (Debug.shouldDelegate(processBA, "application_error", false))
	 {return ((Boolean) Debug.delegate(processBA, "application_error", new Object[] {_error,_stacktrace}));}
RDebugUtils.currentLine=1048576;
 //BA.debugLineNum = 1048576;BA.debugLine="Sub Application_Error (Error As Exception, StackTr";
RDebugUtils.currentLine=1048577;
 //BA.debugLineNum = 1048577;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=1048578;
 //BA.debugLineNum = 1048578;BA.debugLine="End Sub";
return false;
}
public static String  _httpserver_handlerequest(anywheresoftware.b4a.objects.Servlet.ServletRequestWrapper _request,anywheresoftware.b4a.objects.Servlet.ServletResponseWrapper _response) throws Exception{
RDebugUtils.currentModule="webserver";
if (Debug.shouldDelegate(processBA, "httpserver_handlerequest", false))
	 {return ((String) Debug.delegate(processBA, "httpserver_handlerequest", new Object[] {_request,_response}));}
String _html = "";
String _json = "";
anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator _jsongenerator = null;
anywheresoftware.b4a.objects.collections.List _datos = null;
int _i = 0;
anywheresoftware.b4a.objects.collections.Map _registro = null;
String _verb = "";
String _user = "";
String _pass = "";
RDebugUtils.currentLine=1441792;
 //BA.debugLineNum = 1441792;BA.debugLine="Private Sub httpserver_HandleRequest (Request As S";
RDebugUtils.currentLine=1441793;
 //BA.debugLineNum = 1441793;BA.debugLine="Select Request.RequestURI";
switch (BA.switchObjectToInt(_request.getRequestURI(),"/","/datos","/seguro.jsp")) {
case 0: {
RDebugUtils.currentLine=1441795;
 //BA.debugLineNum = 1441795;BA.debugLine="Dim html As String";
_html = "";
RDebugUtils.currentLine=1441797;
 //BA.debugLineNum = 1441797;BA.debugLine="html =  File.GetText( File.DirAssets, \"index.htm";
_html = anywheresoftware.b4a.keywords.Common.File.GetText(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"index.html");
RDebugUtils.currentLine=1441798;
 //BA.debugLineNum = 1441798;BA.debugLine="html = html.Replace(\"{empresa}\", \"UTN\")";
_html = _html.replace("{empresa}","UTN");
RDebugUtils.currentLine=1441799;
 //BA.debugLineNum = 1441799;BA.debugLine="html = html.Replace(\"{marca}\", \"SAMSUNG\")";
_html = _html.replace("{marca}","SAMSUNG");
RDebugUtils.currentLine=1441800;
 //BA.debugLineNum = 1441800;BA.debugLine="html = html.Replace(\"{modelo}\", \"A30s\")";
_html = _html.replace("{modelo}","A30s");
RDebugUtils.currentLine=1441802;
 //BA.debugLineNum = 1441802;BA.debugLine="Response.Status = 200";
_response.setStatus((int) (200));
RDebugUtils.currentLine=1441803;
 //BA.debugLineNum = 1441803;BA.debugLine="Response.SendString(html)";
_response.SendString(_html);
 break; }
case 1: {
RDebugUtils.currentLine=1441806;
 //BA.debugLineNum = 1441806;BA.debugLine="Dim json As String";
_json = "";
RDebugUtils.currentLine=1441807;
 //BA.debugLineNum = 1441807;BA.debugLine="Dim jsonGenerator As JSONGenerator";
_jsongenerator = new anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator();
RDebugUtils.currentLine=1441810;
 //BA.debugLineNum = 1441810;BA.debugLine="Dim datos As List";
_datos = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=1441811;
 //BA.debugLineNum = 1441811;BA.debugLine="datos.Initialize";
_datos.Initialize();
RDebugUtils.currentLine=1441813;
 //BA.debugLineNum = 1441813;BA.debugLine="For i = 1 To 5";
{
final int step15 = 1;
final int limit15 = (int) (5);
_i = (int) (1) ;
for (;_i <= limit15 ;_i = _i + step15 ) {
RDebugUtils.currentLine=1441814;
 //BA.debugLineNum = 1441814;BA.debugLine="Dim registro As Map";
_registro = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=1441815;
 //BA.debugLineNum = 1441815;BA.debugLine="registro.Initialize";
_registro.Initialize();
RDebugUtils.currentLine=1441817;
 //BA.debugLineNum = 1441817;BA.debugLine="registro.Put(\"id\", i)";
_registro.Put((Object)("id"),(Object)(_i));
RDebugUtils.currentLine=1441818;
 //BA.debugLineNum = 1441818;BA.debugLine="registro.Put(\"nombres\", \"diego\")";
_registro.Put((Object)("nombres"),(Object)("diego"));
RDebugUtils.currentLine=1441819;
 //BA.debugLineNum = 1441819;BA.debugLine="registro.Put(\"apellidos\", \"trejo\")";
_registro.Put((Object)("apellidos"),(Object)("trejo"));
RDebugUtils.currentLine=1441820;
 //BA.debugLineNum = 1441820;BA.debugLine="registro.Put(\"direccion\", \"av. pichincha 4-32\")";
_registro.Put((Object)("direccion"),(Object)("av. pichincha 4-32"));
RDebugUtils.currentLine=1441821;
 //BA.debugLineNum = 1441821;BA.debugLine="datos.Add(registro)";
_datos.Add((Object)(_registro.getObject()));
 }
};
RDebugUtils.currentLine=1441824;
 //BA.debugLineNum = 1441824;BA.debugLine="Dim registro As Map";
_registro = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=1441825;
 //BA.debugLineNum = 1441825;BA.debugLine="registro.Initialize";
_registro.Initialize();
RDebugUtils.currentLine=1441827;
 //BA.debugLineNum = 1441827;BA.debugLine="registro.Put(\"id\", 90)";
_registro.Put((Object)("id"),(Object)(90));
RDebugUtils.currentLine=1441828;
 //BA.debugLineNum = 1441828;BA.debugLine="registro.Put(\"nombres\", \"diego abc\")";
_registro.Put((Object)("nombres"),(Object)("diego abc"));
RDebugUtils.currentLine=1441829;
 //BA.debugLineNum = 1441829;BA.debugLine="registro.Put(\"apellidos\", \"trejo xyz\")";
_registro.Put((Object)("apellidos"),(Object)("trejo xyz"));
RDebugUtils.currentLine=1441830;
 //BA.debugLineNum = 1441830;BA.debugLine="registro.Put(\"direccion\", \"av. pichincha 4-32 mn";
_registro.Put((Object)("direccion"),(Object)("av. pichincha 4-32 mno"));
RDebugUtils.currentLine=1441831;
 //BA.debugLineNum = 1441831;BA.debugLine="datos.Add(registro)";
_datos.Add((Object)(_registro.getObject()));
RDebugUtils.currentLine=1441835;
 //BA.debugLineNum = 1441835;BA.debugLine="jsonGenerator.Initialize(registro)";
_jsongenerator.Initialize(_registro);
RDebugUtils.currentLine=1441836;
 //BA.debugLineNum = 1441836;BA.debugLine="json = jsonGenerator.ToPrettyString(4)";
_json = _jsongenerator.ToPrettyString((int) (4));
RDebugUtils.currentLine=1441838;
 //BA.debugLineNum = 1441838;BA.debugLine="Response.SetHeader(\"Accept\", \"application/json\")";
_response.SetHeader("Accept","application/json");
RDebugUtils.currentLine=1441839;
 //BA.debugLineNum = 1441839;BA.debugLine="Response.Status = 200";
_response.setStatus((int) (200));
RDebugUtils.currentLine=1441840;
 //BA.debugLineNum = 1441840;BA.debugLine="Response.SendString(json)";
_response.SendString(_json);
 break; }
case 2: {
RDebugUtils.currentLine=1441843;
 //BA.debugLineNum = 1441843;BA.debugLine="Dim verb As String = Request.Method.ToUpperCase";
_verb = _request.getMethod().toUpperCase();
RDebugUtils.currentLine=1441844;
 //BA.debugLineNum = 1441844;BA.debugLine="Dim user As String = Request.GetHeader(\"user\")";
_user = _request.GetHeader("user");
RDebugUtils.currentLine=1441845;
 //BA.debugLineNum = 1441845;BA.debugLine="Dim pass As String = Request.GetHeader(\"pass\")";
_pass = _request.GetHeader("pass");
RDebugUtils.currentLine=1441847;
 //BA.debugLineNum = 1441847;BA.debugLine="If verb <> \"POST\" Then";
if ((_verb).equals("POST") == false) { 
RDebugUtils.currentLine=1441848;
 //BA.debugLineNum = 1441848;BA.debugLine="Response.Status = 401";
_response.setStatus((int) (401));
RDebugUtils.currentLine=1441849;
 //BA.debugLineNum = 1441849;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=1441852;
 //BA.debugLineNum = 1441852;BA.debugLine="If (user = \"pepe\" And pass = \"1234\") = False The";
if (((_user).equals("pepe") && (_pass).equals("1234"))==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=1441853;
 //BA.debugLineNum = 1441853;BA.debugLine="Response.Status = 401";
_response.setStatus((int) (401));
RDebugUtils.currentLine=1441854;
 //BA.debugLineNum = 1441854;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=1441857;
 //BA.debugLineNum = 1441857;BA.debugLine="If Request.RemoteAddress <> \"172.20.154.102\" The";
if ((_request.getRemoteAddress()).equals("172.20.154.102") == false) { 
RDebugUtils.currentLine=1441858;
 //BA.debugLineNum = 1441858;BA.debugLine="Response.Status = 401";
_response.setStatus((int) (401));
 }else {
RDebugUtils.currentLine=1441860;
 //BA.debugLineNum = 1441860;BA.debugLine="Response.Status = 200";
_response.setStatus((int) (200));
RDebugUtils.currentLine=1441861;
 //BA.debugLineNum = 1441861;BA.debugLine="Response.SendString(\"Acceso autorizado !!\")";
_response.SendString("Acceso autorizado !!");
 };
 break; }
default: {
RDebugUtils.currentLine=1441865;
 //BA.debugLineNum = 1441865;BA.debugLine="Response.Status = 401  '' pagina no disponible";
_response.setStatus((int) (401));
 break; }
}
;
RDebugUtils.currentLine=1441868;
 //BA.debugLineNum = 1441868;BA.debugLine="End Sub";
return "";
}
public static String  _service_create() throws Exception{
RDebugUtils.currentModule="webserver";
if (Debug.shouldDelegate(processBA, "service_create", false))
	 {return ((String) Debug.delegate(processBA, "service_create", null));}
RDebugUtils.currentLine=851968;
 //BA.debugLineNum = 851968;BA.debugLine="Sub Service_Create";
RDebugUtils.currentLine=851971;
 //BA.debugLineNum = 851971;BA.debugLine="httpserver.Initialize(\"httpserver\")";
_httpserver.Initialize(processBA,"httpserver");
RDebugUtils.currentLine=851972;
 //BA.debugLineNum = 851972;BA.debugLine="servicioActivo = False";
_servicioactivo = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=851973;
 //BA.debugLineNum = 851973;BA.debugLine="End Sub";
return "";
}
public static String  _service_destroy() throws Exception{
RDebugUtils.currentModule="webserver";
if (Debug.shouldDelegate(processBA, "service_destroy", false))
	 {return ((String) Debug.delegate(processBA, "service_destroy", null));}
RDebugUtils.currentLine=1114112;
 //BA.debugLineNum = 1114112;BA.debugLine="Sub Service_Destroy";
RDebugUtils.currentLine=1114113;
 //BA.debugLineNum = 1114113;BA.debugLine="If servicioActivo Then";
if (_servicioactivo) { 
RDebugUtils.currentLine=1114114;
 //BA.debugLineNum = 1114114;BA.debugLine="httpserver.Stop()";
_httpserver.Stop();
RDebugUtils.currentLine=1114115;
 //BA.debugLineNum = 1114115;BA.debugLine="servicioActivo = False";
_servicioactivo = anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=1114117;
 //BA.debugLineNum = 1114117;BA.debugLine="End Sub";
return "";
}
public static String  _service_start(anywheresoftware.b4a.objects.IntentWrapper _startingintent) throws Exception{
RDebugUtils.currentModule="webserver";
if (Debug.shouldDelegate(processBA, "service_start", false))
	 {return ((String) Debug.delegate(processBA, "service_start", new Object[] {_startingintent}));}
RDebugUtils.currentLine=917504;
 //BA.debugLineNum = 917504;BA.debugLine="Sub Service_Start (StartingIntent As Intent)";
RDebugUtils.currentLine=917505;
 //BA.debugLineNum = 917505;BA.debugLine="Service.StopAutomaticForeground 'Starter service";
mostCurrent._service.StopAutomaticForeground();
RDebugUtils.currentLine=917506;
 //BA.debugLineNum = 917506;BA.debugLine="If servicioActivo = False Then";
if (_servicioactivo==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=917507;
 //BA.debugLineNum = 917507;BA.debugLine="httpserver.Start(8080)";
_httpserver.Start((int) (8080));
RDebugUtils.currentLine=917508;
 //BA.debugLineNum = 917508;BA.debugLine="servicioActivo = True";
_servicioactivo = anywheresoftware.b4a.keywords.Common.True;
 };
RDebugUtils.currentLine=917510;
 //BA.debugLineNum = 917510;BA.debugLine="End Sub";
return "";
}
public static String  _service_taskremoved() throws Exception{
RDebugUtils.currentModule="webserver";
if (Debug.shouldDelegate(processBA, "service_taskremoved", false))
	 {return ((String) Debug.delegate(processBA, "service_taskremoved", null));}
RDebugUtils.currentLine=983040;
 //BA.debugLineNum = 983040;BA.debugLine="Sub Service_TaskRemoved";
RDebugUtils.currentLine=983042;
 //BA.debugLineNum = 983042;BA.debugLine="If servicioActivo Then";
if (_servicioactivo) { 
RDebugUtils.currentLine=983043;
 //BA.debugLineNum = 983043;BA.debugLine="httpserver.Stop()";
_httpserver.Stop();
RDebugUtils.currentLine=983044;
 //BA.debugLineNum = 983044;BA.debugLine="servicioActivo = False";
_servicioactivo = anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=983046;
 //BA.debugLineNum = 983046;BA.debugLine="End Sub";
return "";
}
}
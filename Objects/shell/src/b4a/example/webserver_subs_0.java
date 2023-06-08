package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class webserver_subs_0 {


public static RemoteObject  _application_error(RemoteObject _error,RemoteObject _stacktrace) throws Exception{
try {
		Debug.PushSubsStack("Application_Error (webserver) ","webserver",1,webserver.processBA,webserver.mostCurrent,115);
if (RapidSub.canDelegate("application_error")) { return b4a.example.webserver.remoteMe.runUserSub(false, "webserver","application_error", _error, _stacktrace);}
Debug.locals.put("Error", _error);
Debug.locals.put("StackTrace", _stacktrace);
 BA.debugLineNum = 115;BA.debugLine="Sub Application_Error (Error As Exception, StackTr";
Debug.ShouldStop(262144);
 BA.debugLineNum = 116;BA.debugLine="Return True";
Debug.ShouldStop(524288);
if (true) return webserver.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 117;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _httpserver_handlerequest(RemoteObject _request,RemoteObject _response) throws Exception{
try {
		Debug.PushSubsStack("httpserver_HandleRequest (webserver) ","webserver",1,webserver.processBA,webserver.mostCurrent,20);
if (RapidSub.canDelegate("httpserver_handlerequest")) { return b4a.example.webserver.remoteMe.runUserSub(false, "webserver","httpserver_handlerequest", _request, _response);}
RemoteObject _html = RemoteObject.createImmutable("");
RemoteObject _json = RemoteObject.createImmutable("");
RemoteObject _jsongenerator = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator");
RemoteObject _datos = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
int _i = 0;
RemoteObject _registro = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _verb = RemoteObject.createImmutable("");
RemoteObject _user = RemoteObject.createImmutable("");
RemoteObject _pass = RemoteObject.createImmutable("");
Debug.locals.put("Request", _request);
Debug.locals.put("Response", _response);
 BA.debugLineNum = 20;BA.debugLine="Private Sub httpserver_HandleRequest (Request As S";
Debug.ShouldStop(524288);
 BA.debugLineNum = 21;BA.debugLine="Select Request.RequestURI";
Debug.ShouldStop(1048576);
switch (BA.switchObjectToInt(_request.runMethod(true,"getRequestURI"),BA.ObjectToString("/"),BA.ObjectToString("/datos"),BA.ObjectToString("/seguro.jsp"))) {
case 0: {
 BA.debugLineNum = 23;BA.debugLine="Dim html As String";
Debug.ShouldStop(4194304);
_html = RemoteObject.createImmutable("");Debug.locals.put("html", _html);
 BA.debugLineNum = 25;BA.debugLine="html =  File.GetText( File.DirAssets, \"index.htm";
Debug.ShouldStop(16777216);
_html = webserver.mostCurrent.__c.getField(false,"File").runMethod(true,"GetText",(Object)(webserver.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("index.html")));Debug.locals.put("html", _html);
 BA.debugLineNum = 26;BA.debugLine="html = html.Replace(\"{empresa}\", \"UTN\")";
Debug.ShouldStop(33554432);
_html = _html.runMethod(true,"replace",(Object)(BA.ObjectToString("{empresa}")),(Object)(RemoteObject.createImmutable("UTN")));Debug.locals.put("html", _html);
 BA.debugLineNum = 27;BA.debugLine="html = html.Replace(\"{marca}\", \"SAMSUNG\")";
Debug.ShouldStop(67108864);
_html = _html.runMethod(true,"replace",(Object)(BA.ObjectToString("{marca}")),(Object)(RemoteObject.createImmutable("SAMSUNG")));Debug.locals.put("html", _html);
 BA.debugLineNum = 28;BA.debugLine="html = html.Replace(\"{modelo}\", \"A30s\")";
Debug.ShouldStop(134217728);
_html = _html.runMethod(true,"replace",(Object)(BA.ObjectToString("{modelo}")),(Object)(RemoteObject.createImmutable("A30s")));Debug.locals.put("html", _html);
 BA.debugLineNum = 30;BA.debugLine="Response.Status = 200";
Debug.ShouldStop(536870912);
_response.runVoidMethod ("setStatus",BA.numberCast(int.class, 200));
 BA.debugLineNum = 31;BA.debugLine="Response.SendString(html)";
Debug.ShouldStop(1073741824);
_response.runVoidMethod ("SendString",(Object)(_html));
 break; }
case 1: {
 BA.debugLineNum = 34;BA.debugLine="Dim json As String";
Debug.ShouldStop(2);
_json = RemoteObject.createImmutable("");Debug.locals.put("json", _json);
 BA.debugLineNum = 35;BA.debugLine="Dim jsonGenerator As JSONGenerator";
Debug.ShouldStop(4);
_jsongenerator = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator");Debug.locals.put("jsonGenerator", _jsongenerator);
 BA.debugLineNum = 38;BA.debugLine="Dim datos As List";
Debug.ShouldStop(32);
_datos = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("datos", _datos);
 BA.debugLineNum = 39;BA.debugLine="datos.Initialize";
Debug.ShouldStop(64);
_datos.runVoidMethod ("Initialize");
 BA.debugLineNum = 41;BA.debugLine="For i = 1 To 5";
Debug.ShouldStop(256);
{
final int step15 = 1;
final int limit15 = 5;
_i = 1 ;
for (;(step15 > 0 && _i <= limit15) || (step15 < 0 && _i >= limit15) ;_i = ((int)(0 + _i + step15))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 42;BA.debugLine="Dim registro As Map";
Debug.ShouldStop(512);
_registro = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("registro", _registro);
 BA.debugLineNum = 43;BA.debugLine="registro.Initialize";
Debug.ShouldStop(1024);
_registro.runVoidMethod ("Initialize");
 BA.debugLineNum = 45;BA.debugLine="registro.Put(\"id\", i)";
Debug.ShouldStop(4096);
_registro.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("id"))),(Object)(RemoteObject.createImmutable((_i))));
 BA.debugLineNum = 46;BA.debugLine="registro.Put(\"nombres\", \"diego\")";
Debug.ShouldStop(8192);
_registro.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("nombres"))),(Object)((RemoteObject.createImmutable("diego"))));
 BA.debugLineNum = 47;BA.debugLine="registro.Put(\"apellidos\", \"trejo\")";
Debug.ShouldStop(16384);
_registro.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("apellidos"))),(Object)((RemoteObject.createImmutable("trejo"))));
 BA.debugLineNum = 48;BA.debugLine="registro.Put(\"direccion\", \"av. pichincha 4-32\")";
Debug.ShouldStop(32768);
_registro.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("direccion"))),(Object)((RemoteObject.createImmutable("av. pichincha 4-32"))));
 BA.debugLineNum = 49;BA.debugLine="datos.Add(registro)";
Debug.ShouldStop(65536);
_datos.runVoidMethod ("Add",(Object)((_registro.getObject())));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 52;BA.debugLine="Dim registro As Map";
Debug.ShouldStop(524288);
_registro = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("registro", _registro);
 BA.debugLineNum = 53;BA.debugLine="registro.Initialize";
Debug.ShouldStop(1048576);
_registro.runVoidMethod ("Initialize");
 BA.debugLineNum = 55;BA.debugLine="registro.Put(\"id\", 90)";
Debug.ShouldStop(4194304);
_registro.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("id"))),(Object)(RemoteObject.createImmutable((90))));
 BA.debugLineNum = 56;BA.debugLine="registro.Put(\"nombres\", \"diego abc\")";
Debug.ShouldStop(8388608);
_registro.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("nombres"))),(Object)((RemoteObject.createImmutable("diego abc"))));
 BA.debugLineNum = 57;BA.debugLine="registro.Put(\"apellidos\", \"trejo xyz\")";
Debug.ShouldStop(16777216);
_registro.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("apellidos"))),(Object)((RemoteObject.createImmutable("trejo xyz"))));
 BA.debugLineNum = 58;BA.debugLine="registro.Put(\"direccion\", \"av. pichincha 4-32 mn";
Debug.ShouldStop(33554432);
_registro.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("direccion"))),(Object)((RemoteObject.createImmutable("av. pichincha 4-32 mno"))));
 BA.debugLineNum = 59;BA.debugLine="datos.Add(registro)";
Debug.ShouldStop(67108864);
_datos.runVoidMethod ("Add",(Object)((_registro.getObject())));
 BA.debugLineNum = 63;BA.debugLine="jsonGenerator.Initialize(registro)";
Debug.ShouldStop(1073741824);
_jsongenerator.runVoidMethod ("Initialize",(Object)(_registro));
 BA.debugLineNum = 64;BA.debugLine="json = jsonGenerator.ToPrettyString(4)";
Debug.ShouldStop(-2147483648);
_json = _jsongenerator.runMethod(true,"ToPrettyString",(Object)(BA.numberCast(int.class, 4)));Debug.locals.put("json", _json);
 BA.debugLineNum = 66;BA.debugLine="Response.SetHeader(\"Accept\", \"application/json\")";
Debug.ShouldStop(2);
_response.runVoidMethod ("SetHeader",(Object)(BA.ObjectToString("Accept")),(Object)(RemoteObject.createImmutable("application/json")));
 BA.debugLineNum = 67;BA.debugLine="Response.Status = 200";
Debug.ShouldStop(4);
_response.runVoidMethod ("setStatus",BA.numberCast(int.class, 200));
 BA.debugLineNum = 68;BA.debugLine="Response.SendString(json)";
Debug.ShouldStop(8);
_response.runVoidMethod ("SendString",(Object)(_json));
 break; }
case 2: {
 BA.debugLineNum = 71;BA.debugLine="Dim verb As String = Request.Method.ToUpperCase";
Debug.ShouldStop(64);
_verb = _request.runMethod(true,"getMethod").runMethod(true,"toUpperCase");Debug.locals.put("verb", _verb);Debug.locals.put("verb", _verb);
 BA.debugLineNum = 72;BA.debugLine="Dim user As String = Request.GetHeader(\"user\")";
Debug.ShouldStop(128);
_user = _request.runMethod(true,"GetHeader",(Object)(RemoteObject.createImmutable("user")));Debug.locals.put("user", _user);Debug.locals.put("user", _user);
 BA.debugLineNum = 73;BA.debugLine="Dim pass As String = Request.GetHeader(\"pass\")";
Debug.ShouldStop(256);
_pass = _request.runMethod(true,"GetHeader",(Object)(RemoteObject.createImmutable("pass")));Debug.locals.put("pass", _pass);Debug.locals.put("pass", _pass);
 BA.debugLineNum = 75;BA.debugLine="If verb <> \"POST\" Then";
Debug.ShouldStop(1024);
if (RemoteObject.solveBoolean("!",_verb,BA.ObjectToString("POST"))) { 
 BA.debugLineNum = 76;BA.debugLine="Response.Status = 401";
Debug.ShouldStop(2048);
_response.runVoidMethod ("setStatus",BA.numberCast(int.class, 401));
 BA.debugLineNum = 77;BA.debugLine="Return";
Debug.ShouldStop(4096);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 80;BA.debugLine="If (user = \"pepe\" And pass = \"1234\") = False The";
Debug.ShouldStop(32768);
if (RemoteObject.solveBoolean("=",RemoteObject.createImmutable((RemoteObject.solveBoolean("=",_user,BA.ObjectToString("pepe")) && RemoteObject.solveBoolean("=",_pass,RemoteObject.createImmutable("1234")))),webserver.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 81;BA.debugLine="Response.Status = 401";
Debug.ShouldStop(65536);
_response.runVoidMethod ("setStatus",BA.numberCast(int.class, 401));
 BA.debugLineNum = 82;BA.debugLine="Return";
Debug.ShouldStop(131072);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 85;BA.debugLine="If Request.RemoteAddress <> \"172.20.154.102\" The";
Debug.ShouldStop(1048576);
if (RemoteObject.solveBoolean("!",_request.runMethod(true,"getRemoteAddress"),BA.ObjectToString("172.20.154.102"))) { 
 BA.debugLineNum = 86;BA.debugLine="Response.Status = 401";
Debug.ShouldStop(2097152);
_response.runVoidMethod ("setStatus",BA.numberCast(int.class, 401));
 }else {
 BA.debugLineNum = 88;BA.debugLine="Response.Status = 200";
Debug.ShouldStop(8388608);
_response.runVoidMethod ("setStatus",BA.numberCast(int.class, 200));
 BA.debugLineNum = 89;BA.debugLine="Response.SendString(\"Acceso autorizado !!\")";
Debug.ShouldStop(16777216);
_response.runVoidMethod ("SendString",(Object)(RemoteObject.createImmutable("Acceso autorizado !!")));
 };
 break; }
default: {
 BA.debugLineNum = 93;BA.debugLine="Response.Status = 401  '' pagina no disponible";
Debug.ShouldStop(268435456);
_response.runVoidMethod ("setStatus",BA.numberCast(int.class, 401));
 break; }
}
;
 BA.debugLineNum = 96;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
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
 //BA.debugLineNum = 9;BA.debugLine="Private httpserver As HttpServer";
webserver._httpserver = RemoteObject.createNew ("anywheresoftware.b4a.objects.HttpServer");
 //BA.debugLineNum = 10;BA.debugLine="Private servicioActivo As Boolean";
webserver._servicioactivo = RemoteObject.createImmutable(false);
 //BA.debugLineNum = 11;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _service_create() throws Exception{
try {
		Debug.PushSubsStack("Service_Create (webserver) ","webserver",1,webserver.processBA,webserver.mostCurrent,13);
if (RapidSub.canDelegate("service_create")) { return b4a.example.webserver.remoteMe.runUserSub(false, "webserver","service_create");}
 BA.debugLineNum = 13;BA.debugLine="Sub Service_Create";
Debug.ShouldStop(4096);
 BA.debugLineNum = 16;BA.debugLine="httpserver.Initialize(\"httpserver\")";
Debug.ShouldStop(32768);
webserver._httpserver.runVoidMethod ("Initialize",webserver.processBA,(Object)(RemoteObject.createImmutable("httpserver")));
 BA.debugLineNum = 17;BA.debugLine="servicioActivo = False";
Debug.ShouldStop(65536);
webserver._servicioactivo = webserver.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 18;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _service_destroy() throws Exception{
try {
		Debug.PushSubsStack("Service_Destroy (webserver) ","webserver",1,webserver.processBA,webserver.mostCurrent,119);
if (RapidSub.canDelegate("service_destroy")) { return b4a.example.webserver.remoteMe.runUserSub(false, "webserver","service_destroy");}
 BA.debugLineNum = 119;BA.debugLine="Sub Service_Destroy";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 120;BA.debugLine="If servicioActivo Then";
Debug.ShouldStop(8388608);
if (webserver._servicioactivo.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 121;BA.debugLine="httpserver.Stop()";
Debug.ShouldStop(16777216);
webserver._httpserver.runVoidMethod ("Stop");
 BA.debugLineNum = 122;BA.debugLine="servicioActivo = False";
Debug.ShouldStop(33554432);
webserver._servicioactivo = webserver.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 124;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _service_start(RemoteObject _startingintent) throws Exception{
try {
		Debug.PushSubsStack("Service_Start (webserver) ","webserver",1,webserver.processBA,webserver.mostCurrent,98);
if (RapidSub.canDelegate("service_start")) { return b4a.example.webserver.remoteMe.runUserSub(false, "webserver","service_start", _startingintent);}
Debug.locals.put("StartingIntent", _startingintent);
 BA.debugLineNum = 98;BA.debugLine="Sub Service_Start (StartingIntent As Intent)";
Debug.ShouldStop(2);
 BA.debugLineNum = 99;BA.debugLine="Service.StopAutomaticForeground 'Starter service";
Debug.ShouldStop(4);
webserver.mostCurrent._service.runVoidMethod ("StopAutomaticForeground");
 BA.debugLineNum = 100;BA.debugLine="If servicioActivo = False Then";
Debug.ShouldStop(8);
if (RemoteObject.solveBoolean("=",webserver._servicioactivo,webserver.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 101;BA.debugLine="httpserver.Start(8080)";
Debug.ShouldStop(16);
webserver._httpserver.runVoidMethod ("Start",(Object)(BA.numberCast(int.class, 8080)));
 BA.debugLineNum = 102;BA.debugLine="servicioActivo = True";
Debug.ShouldStop(32);
webserver._servicioactivo = webserver.mostCurrent.__c.getField(true,"True");
 };
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
public static RemoteObject  _service_taskremoved() throws Exception{
try {
		Debug.PushSubsStack("Service_TaskRemoved (webserver) ","webserver",1,webserver.processBA,webserver.mostCurrent,106);
if (RapidSub.canDelegate("service_taskremoved")) { return b4a.example.webserver.remoteMe.runUserSub(false, "webserver","service_taskremoved");}
 BA.debugLineNum = 106;BA.debugLine="Sub Service_TaskRemoved";
Debug.ShouldStop(512);
 BA.debugLineNum = 108;BA.debugLine="If servicioActivo Then";
Debug.ShouldStop(2048);
if (webserver._servicioactivo.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 109;BA.debugLine="httpserver.Stop()";
Debug.ShouldStop(4096);
webserver._httpserver.runVoidMethod ("Stop");
 BA.debugLineNum = 110;BA.debugLine="servicioActivo = False";
Debug.ShouldStop(8192);
webserver._servicioactivo = webserver.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 112;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}
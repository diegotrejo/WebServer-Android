B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Service
Version=9.9
@EndOfDesignText@
#Region  Service Attributes 
	#StartAtBoot: False
	#ExcludeFromLibrary: True
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.
	Private httpserver As HttpServer
	Private servicioActivo As Boolean
End Sub

Sub Service_Create
	'This is the program entry point.
	'This is a good place to load resources that are not specific to a single activity.
	httpserver.Initialize("httpserver")
	servicioActivo = False
End Sub

Private Sub httpserver_HandleRequest (Request As ServletRequest, Response As ServletResponse)
	Select Request.RequestURI
	Case "/"   'sitio raiz (home)
		Dim html As String
		
		html =  File.GetText( File.DirAssets, "index.html")
		html = html.Replace("{empresa}", "UTN")
		html = html.Replace("{marca}", "SAMSUNG")
		html = html.Replace("{modelo}", "A30s")
		
		Response.Status = 200
		Response.SendString(html)
		
	Case "/datos"
		Dim json As String
		Dim jsonGenerator As JSONGenerator
		
		''------ SIMULAR QUE LOS DATOS VIENEN DE UNA BDD SQLITE
		Dim datos As List
		datos.Initialize
		
		For i = 1 To 5
			Dim registro As Map
			registro.Initialize
			
			registro.Put("id", i)
			registro.Put("nombres", "diego")
			registro.Put("apellidos", "trejo")
			registro.Put("direccion", "av. pichincha 4-32")
			datos.Add(registro)
		Next
	
		Dim registro As Map
		registro.Initialize
		
		registro.Put("id", 90)
		registro.Put("nombres", "diego abc")
		registro.Put("apellidos", "trejo xyz")
		registro.Put("direccion", "av. pichincha 4-32 mno")
		datos.Add(registro)
		''------ FIN SIMULACION
		
		'jsonGenerator.Initialize2(datos)
		jsonGenerator.Initialize(registro)
		json = jsonGenerator.ToPrettyString(4)
		
		Response.SetHeader("Accept", "application/json")
		Response.Status = 200
		Response.SendString(json)
		
	Case "/seguro.jsp"
		Dim verb As String = Request.Method.ToUpperCase
		Dim user As String = Request.GetHeader("user")
		Dim pass As String = Request.GetHeader("pass")
		
		If verb <> "POST" Then
			Response.Status = 401
			Return
		End If
	
		If (user = "pepe" And pass = "1234") = False Then
			Response.Status = 401
			Return
		End If
		
		If Request.RemoteAddress <> "172.20.154.102" Then
			Response.Status = 401
		Else
			Response.Status = 200
			Response.SendString("Acceso autorizado !!")
		End If
		
	Case Else
		Response.Status = 401  '' pagina no disponible
	End Select
	
End Sub

Sub Service_Start (StartingIntent As Intent)
	Service.StopAutomaticForeground 'Starter service can start in the foreground state in some edge cases.
	If servicioActivo = False Then
		httpserver.Start(8080)
		servicioActivo = True
	End If
End Sub

Sub Service_TaskRemoved
	'This event will be raised when the user removes the app from the recent apps list.
	If servicioActivo Then
		httpserver.Stop()
		servicioActivo = False
	End If
End Sub

'Return true to allow the OS default exceptions handler to handle the uncaught exception.
Sub Application_Error (Error As Exception, StackTrace As String) As Boolean
	Return True
End Sub

Sub Service_Destroy
	If servicioActivo Then
		httpserver.Stop()
		servicioActivo = False
	End If
End Sub

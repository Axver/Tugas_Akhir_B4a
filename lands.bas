B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=8.3
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: True
	#IncludeTitle: False
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.

End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.

	Private WebView1 As WebView
	Dim domain As String
	Dim job2 As HttpJob
	
	domain="http://ca024f23.ngrok.io/"
	Private EditText1 As EditText
	Private ListView1 As ListView
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("lands")
	
	WebView1.LoadUrl(domain&"ta_v2/endpoint/view/layers.php?request=all")
	ProgressDialogShow("Loading...")


End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

Sub webview1_PageFinished (StrUrl As String)
	ProgressDialogHide
	'ToastMessageShow("Loaded " &StrUrl, False)
End Sub


Sub Button1_Click
	Dim tax_number As String
	tax_number= EditText1.Text
	
	WebView1.LoadUrl(domain&"ta_v2/endpoint/view/land_tax_view.php?tax_number="&tax_number)
	ProgressDialogShow("Loading...")
	
	job2.Initialize("Job2", Me)
	job2.PostString(domain&"ta_v2/endpoint/land_tax.php", "tax_number="&tax_number)
	ProgressDialogShow("Loading...")
End Sub

Sub JobDone (Job As HttpJob)
	
	Log("JobName = " & Job.JobName & ", Success = " & Job.Success)
	If Job.Success = True Then
		ProgressDialogHide
		Select Job.JobName
			Case "Job2"
				Dim parser As JSONParser
				parser.Initialize(Job.GetString)
				Log(Job.GetString)
				Dim root As Map = parser.NextObject
				Dim features As List = root.Get("features")
				For Each colfeatures As Map In features
					Dim geometry As Map = colfeatures.Get("geometry")
					Dim coordinates As List = geometry.Get("coordinates")
					For Each colcoordinates As List In coordinates
						For Each colcolcoordinates As List In colcoordinates
							For Each colcolcolcoordinates As List In colcolcoordinates
								For Each colcolcolcolcoordinates As Double In colcolcolcoordinates
								Next
							Next
						Next
					Next
					Dim Type As String = geometry.Get("type")
					Dim Type As String = colfeatures.Get("type")
					Dim properties As Map = colfeatures.Get("properties")
					Dim clan_name As String = properties.Get("clan_name")
					Dim owner_name As String = properties.Get("owner_name")
					Dim gender As String = properties.Get("gender")
					Dim land_owner As String = properties.Get("land_owner")
					Dim phone As String = properties.Get("phone")
					Dim tax_number As String = properties.Get("tax_number")
					Dim status_name As String = properties.Get("status_name")
					Dim x As String = properties.Get("x")
					Dim y As String = properties.Get("y")
					Dim land_id As String = properties.Get("land_id")
					Dim born_date As String = properties.Get("born_date")
					
					
					ListView1.AddSingleLine("Information")
					ListView1.SingleLineLayout.Label.TextSize = 12
					ListView1.SingleLineLayout.Label.TextColor = Colors.Black
					ListView1.AddSingleLine("Clan Name:"&clan_name)
					ListView1.AddSingleLine("Owner Name:"&owner_name)
					ListView1.AddSingleLine("Gender:"&gender)
					ListView1.AddSingleLine("Land Owner:"&land_owner)
					ListView1.AddSingleLine("Phone:"&phone)
					ListView1.AddSingleLine("Tax Number:"&tax_number)
					ListView1.AddSingleLine("Status:"&status_name)
					ListView1.AddSingleLine("Land Id:"&land_id)
					ListView1.AddSingleLine("Coordinates:"&x&"||"&y)
				Next
				Dim Type As String = root.Get("type")
				
				
				
				
				
				


			
		End Select
	Else
		Log("Error: " & Job.ErrorMessage)
		ToastMessageShow("Error: " & Job.ErrorMessage, True)
	End If
	Job.Release
End Sub

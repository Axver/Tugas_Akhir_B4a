B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=8.3
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: True
	#IncludeTitle: false
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.

End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.
	Dim domain As String
	Dim job2 As HttpJob
	domain="http://0b7cfaa1.ngrok.io/"
	
	Private Label10 As Label
	Private Label11 As Label
	Private Label12 As Label
	Private Button1 As Button
	Private Button4 As Button
	Private Button5 As Button
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("dashboard")
	job2.Initialize("Job2", Me)
	job2.PostString(domain&"ta_v2/endpoint/countAll.php", "send=test" &"&data=test")
	ProgressDialogShow("Loading...")

End Sub

Sub Activity_Resume
	job2.Initialize("Job2", Me)
	job2.PostString(domain&"ta_v2/endpoint/countAll.php", "send=test" &"&data=test")
	ProgressDialogShow("Loading...")
End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

Sub JobDone (Job As HttpJob)
	
	Log("JobName = " & Job.JobName & ", Success = " & Job.Success)
	If Job.Success = True Then
		ProgressDialogHide
		Select Job.JobName
			Case "Job2"
				Dim parser As JSONParser
				parser.Initialize(Job.GetString)
				Dim root As Map = parser.NextObject
				Dim features As List = root.Get("features")
				For Each colfeatures As Map In features
					Dim properties As Map = colfeatures.Get("properties")
					Dim citizen1 As String = properties.Get("citizen")
					Dim land As String = properties.Get("land")
					Dim building As String = properties.Get("building")
					Log(building)
					Label10.Text=land
					Label11.Text=building
					Label12.Text=citizen1
				Next

			
		End Select
	Else
		Log("Error: " & Job.ErrorMessage)
		ToastMessageShow("Error: " & Job.ErrorMessage, True)
	End If
	Job.Release
End Sub


Sub Button1_Click
	StartActivity("birth")
End Sub

Sub Label3_Click
	StartActivity("dashboard")
End Sub

Sub Button2_Click
	StartActivity("mortality")
End Sub

Sub Button3_Click
	StartActivity("outcome")
End Sub

Sub Button4_Click
	StartActivity("family_card")
End Sub

Sub Button5_Click
	StartActivity("citizen")
End Sub

Sub Button7_Click
	StartActivity("owners")
End Sub

Sub Button8_Click
	StartActivity("lands")
End Sub
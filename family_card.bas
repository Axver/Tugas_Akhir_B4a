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
	
	Dim domain As String
	Dim job2 As HttpJob
	
	domain="http://e0e5aadb.ngrok.io/"

	Private Label10 As Label
	Private Label11 As Label
	Private EditText1 As EditText
	Private ListView1 As ListView
	Private Label12 As Label
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("family_card")
	job2.Initialize("Job2", Me)
	job2.PostString(domain&"ta_v2/endpoint/countFcn.php", "send=test" &"&data=test")
	ProgressDialogShow("Loading...")

End Sub

Sub Activity_Resume
	job2.Initialize("Job2", Me)
	job2.PostString(domain&"ta_v2/endpoint/countFcn.php", "send=test" &"&data=test")
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
					Dim fcn As String = properties.Get("fcn")
					Dim fcc As String = properties.Get("fcc")
					
					Label10.Text=fcn
					Label11.Text=fcc
				Next
			Case "Job3"
				Dim parser As JSONParser
				parser.Initialize(Job.GetString)
				Dim root As Map = parser.NextObject
				Dim features As List = root.Get("features")
				For Each colfeatures As Map In features
					Dim properties As Map = colfeatures.Get("properties")
					Dim citizen_id As String = properties.Get("citizen_id")
					Dim name As String = properties.Get("name")
					Dim count As String = properties.Get("count")
					ListView1.AddSingleLine(citizen_id&"__"&name)
					
				Next
				Label12.Text=count
				


			
		End Select
	Else
		Log("Error: " & Job.ErrorMessage)
		ToastMessageShow("Error: " & Job.ErrorMessage, True)
	End If
	Job.Release
End Sub




Sub Button1_Click
	Dim fc_number As String
	fc_number=EditText1.Text
	
	job2.Initialize("Job3", Me)
	job2.PostString(domain&"ta_v2/endpoint/fcn_search.php", "family_no="&fc_number)
	ProgressDialogShow("Loading...")
End Sub
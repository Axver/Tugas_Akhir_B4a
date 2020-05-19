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
	
	domain="https://b9312448.ngrok.io/"

	Private Label10 As Label
	Private Label11 As Label
	Private EditText1 As EditText
	Private ListView1 As ListView
	Private Label12 As Label
	Private ScrollView1 As ScrollView
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("citizen")
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
				Job.Release
			Case "Job3"
				Dim parser As JSONParser
				parser.Initialize(Job.GetString)
				Dim root As Map = parser.NextObject
				Dim features As List = root.Get("features")
				For Each colfeatures As Map In features
					Dim properties As Map = colfeatures.Get("properties")
					Dim nik As String = properties.Get("nik")
					Dim clan_name As String = properties.Get("clan_name")
					Dim citizen_name As String = properties.Get("citizen_name")
					Dim address As String = properties.Get("address")
					Dim gender As String = properties.Get("gender")
					Dim phone As String = properties.Get("phone")
					Dim cs_name As String = properties.Get("cs_name")
					Dim born_date As String = properties.Get("born_date")
					
					ListView1.AddSingleLine("Citize Id:"&nik)
					ListView1.AddSingleLine("Clan Name:"&clan_name)
					ListView1.AddSingleLine("Citizen Name:"&citizen_name)
					ListView1.AddSingleLine("Address:"&address)
					ListView1.AddSingleLine("Phone:"&phone)
					ListView1.AddSingleLine("Gender:"&gender)
					ListView1.AddSingleLine("Citizen Status:"&cs_name)
					ListView1.AddSingleLine("Born Date:"&born_date)
					
				Next
				
				
				
				


				Job.Release
		End Select
	Else
		Log("Error: " & Job.ErrorMessage)
		ToastMessageShow("Error: " & Job.ErrorMessage, True)
		Job.Release
	End If
	
End Sub




Sub Button1_Click
	Dim citizen_id As String
	citizen_id=EditText1.Text
	
	job2.Initialize("Job3", Me)
	job2.PostString(domain&"ta_v2/endpoint/citizen_search.php", "citizen_id="&citizen_id)
	ProgressDialogShow("Loading...")
	Dim Size As Int
	Size=ListView1.Size
	Log("Jumlah Data: " & Size)
	
	For x= Size To 0 Step -1
		If x==0 Then
			
		Else
			ListView1.RemoveAt(x-1)
		End If
	Next
End Sub
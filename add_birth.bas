﻿B4A=true
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
	Private EditText1 As EditText
	Private EditText2 As EditText
	Private EditText3 As EditText
	Private EditText4 As EditText
	Private EditText5 As EditText
	Private Button1 As Button
	domain="http://ca024f23.ngrok.io/"
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("add_birth")

End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub


Sub Button1_Click
	Dim birth_no As String
	Dim citizen_id As String
	Dim reporter_id As String
	Dim weight As String
	Dim type_birth As String
	
	birth_no=EditText1.Text
	citizen_id=EditText2.Text
	reporter_id=EditText3.Text
	weight=EditText4.Text
	type_birth=EditText5.Text
	
	job2.Initialize("Job2", Me)
	job2.PostString(domain&"ta_v2/endpoint/addBirth.php", "birth_no=" & birth_no &"&citizen_id=" & citizen_id&"&reporter_id="&reporter_id&"&weight="&weight&"&type_birth="&type_birth)
	ProgressDialogShow("Loading...")
End Sub

Sub JobDone (Job As HttpJob)
	
	Log("JobName = " & Job.JobName & ", Success = " & Job.Success)
	If Job.Success = True Then
		
		
		Select Job.JobName
			Case "Job2"
				
                Log(Job.GetString)
				If Job.GetString="Success" Then
				StartActivity("birth")
				Else
					Log("Failed To Input Data")
				
				End If
				
				
					
				
				ProgressDialogHide

			
		End Select
	Else
		Log("Error: " & Job.ErrorMessage)
		ToastMessageShow("Error: " & Job.ErrorMessage, True)
	End If
	Job.Release
End Sub


Sub Label3_Click
	StartActivity("dashboard")
End Sub
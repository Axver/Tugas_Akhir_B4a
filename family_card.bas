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
	Dim pnlInput, pnlSelect, PanelMain As Panel
	
	Dim domain As String
	Dim mh1,mh2,mw1,mw2 As Float
	Dim job2 As HttpJob
	Dim citizen_name_g As String
	Dim clan_g As String
	Dim gender_g As String
	Dim phone_g As String
	Dim status_g As String
	
	
	domain="https://b9312448.ngrok.io/"

	Private Label10 As Label
	Private Label11 As Label
	Private EditText1 As EditText
	Private ListView1 As ListView
	Private Label12 As Label
	
	Private Button1 As Button
	Private Label1 As Label
	Private Label2 As Label
	Private Label3 As Label
	Private Label4 As Label
	Private Label5 As Label
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("family_card")
	'job2.Initialize("Job2", Me)
	'job2.PostString(domain&"ta_v2/endpoint/countFcn.php", "send=test" &"&data=test")
	'ProgressDialogShow("Loading...")

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
					ListView1.AddSingleLine(citizen_id)
					ListView1.SingleLineLayout.Label.TextSize=20
					ListView1.SingleLineLayout.ItemHeight = 24dip
					ListView1.SingleLineLayout.Label.TextColor = Colors.Red
					ListView1.SingleLineLayout.Label.Gravity=Gravity.CENTER_HORIZONTAL
					
					
				Next
			Case "Job4"
				Dim parser As JSONParser
				Log(Job.GetString)
				parser.Initialize(Job.GetString)
				Dim root As Map = parser.NextObject
				Dim nik As String = root.Get("nik")
				Dim clan_name As String = root.Get("clan_name")
				Dim citizen_name As String = root.Get("citizen_name")
				Dim gender As String = root.Get("gender")
				Dim phone As String = root.Get("phone")
				Dim status_name As String = root.Get("status_name")
				Dim born_date As String = root.Get("born_date")

				citizen_name_g=citizen_name
				gender_g=gender
				phone_g=phone
				status_g=status_name
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


Sub ListView1_ItemClick (Position As Int, Value As Object)
	Button1.Visible=False
	job2.Initialize("Job4", Me)
	job2.PostString(domain&"ta_v2/endpoint/citizen_by_nik.php", "citizen_id="&Value)
	ProgressDialogShow("Loading...")
	PanPop("fcpanel.bal", 20, 10,Value)
	'ListView1.RemoveAt(Position)
	Log("Data yang diklik: " & Value)
	Label1.Text="Name:"&citizen_name_g
	Label2.Text="Phone:"&phone_g
	Label3.Text="Gender:"&gender_g
	Label4.Text="Status:"&status_g
	Label5.Text="Clan:"&clan_g
End Sub

Sub PanPop (mlayout As String, hc As Int, wc As Int,NIK As String) '( mlayout=your .bal file, hc=height offset + or -, wc=same for width )
	
	pnlSelect.Initialize ( "Select")
	pnlInput.Initialize ("")
	pnlInput.LoadLayout ( mlayout )
	
	pnlSelect.BringToFront
	pnlSelect.Color  = Colors.ARGB (150,0,0,0)
	Activity.AddView (pnlSelect, 0, 0,   100%x, 100%y)
	mh1=(pnlSelect.Height/2) - (PanelMain.Height/2) + hc
	mw1=pnlSelect.Width/2 - (PanelMain.Width/2) + wc
	mh2=PanelMain.Height
	mw2=PanelMain.Width
	pnlSelect.AddView (pnlInput, mw1, mh1, mw2, mh2)
	'Jalankan Job4 disini
	
	
	
	
	
	
End Sub

Sub Select_Click ' Stop clicks on Select panel getting to panel underneath
	'this sub stops other clicks outside your panel from working
	pnlSelect.RemoveView
	Button1.Visible=True
End Sub
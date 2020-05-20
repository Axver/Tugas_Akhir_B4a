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
	Dim pnlInput, pnlSelect, PanelMain,PanelMain1 As Panel
	Dim mh1,mh2,mw1,mw2 As Float
	Dim domain As String
	Dim job2 As HttpJob
	Dim wv1 As WebView
	
	Dim citizen_name_g As String
	Dim clan_g As String
	Dim gender_g As String
	Dim phone_g As String
	Dim status_g As String
	
	
	domain="http://ca024f23.ngrok.io/"

	Private Label10 As Label
	Private Label11 As Label
	Private EditText1 As EditText
	Private ListView1 As ListView
	Private Label12 As Label
	Private ScrollView1 As ScrollView
	Private Button1 As Button
	Private Label1 As Label
	Private Label2 As Label
	Private Label3 As Label
	Private Label4 As Label
	Private Label5 As Label
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
					
					
				Next
				
				ListView1.AddSingleLine(nik)
				ListView1.AddSingleLine("Land Owning")
				ListView1.AddSingleLine("Building Owning")
				ListView1.SingleLineLayout.Label.TextSize=20
				ListView1.SingleLineLayout.ItemHeight = 24dip
				ListView1.SingleLineLayout.Label.TextColor = Colors.White
				ListView1.SingleLineLayout.Label.Gravity=Gravity.CENTER_HORIZONTAL
				
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
	
	ProgressDialogShow("Loading...")
	Label1.Text="Name:"&citizen_name_g
	Label2.Text="Phone:"&phone_g
	Label3.Text="Gender:"&gender_g
	Label4.Text="Status:"&status_g
	Label5.Text="Clan:"&clan_g
	
	
	
	
	
	
End Sub

Sub PanPopBuilding (mlayout As String, hc As Int, wc As Int,NIK As String) '( mlayout=your .bal file, hc=height offset + or -, wc=same for width )
	Dim citizen_id As String
	citizen_id=EditText1.Text
	pnlSelect.Initialize ( "Select")
	pnlInput.Initialize ("")
	pnlInput.LoadLayout ( mlayout )
	
	pnlSelect.BringToFront
	pnlSelect.Color  = Colors.ARGB (150,0,0,0)
	Activity.AddView (pnlSelect, 0, 0,   100%x, 100%y)
	mh1=(pnlSelect.Height/2) - (PanelMain1.Height/2) + hc
	mw1=pnlSelect.Width/2 - (PanelMain1.Width/2) + wc
	mh2=pnlSelect.Height-50dip
	mw2=pnlSelect.Width-50dip
	
	wv1.LoadURL(domain&"ta_v2/endpoint/view/land_owner.php?owner_id="&citizen_id)
	
	

	
	
	
	
	
	
End Sub

Sub Select_Click ' Stop clicks on Select panel getting to panel underneath
	'this sub stops other clicks outside your panel from working
	pnlSelect.RemoveView
	Button1.Visible=True
End Sub

Sub ListView1_ItemClick (Position As Int, Value As Object)
	Button1.Visible=False
'	job2.Initialize("Job4", Me)
'	job2.PostString(domain&"ta_v2/endpoint/citizen_by_nik.php", "citizen_id="&Value)
'	ProgressDialogShow("Loading...")
	
	'ListView1.RemoveAt(Position)
	Log("Data yang diklik: " & Value)
	
	If Value=="Land Owning" Then
	
	Else If Value=="Building Owning" Then
		PanPopBuilding("cpanel_building.bal", 0, 0,Value)
	
	Else
		job2.Initialize("Job4", Me)
		job2.PostString(domain&"ta_v2/endpoint/citizen_by_nik.php", "citizen_id="&Value)
		ProgressDialogShow("Loading...")
		Label1.Text="Name:"&citizen_name_g
		Label2.Text="Phone:"&phone_g
		Label3.Text="Gender:"&gender_g
		Label4.Text="Status:"&status_g
		Label5.Text="Clan:"&clan_g
		ProgressDialogShow("Loading...")
		PanPop("cpanel.bal", 40, 20,Value)
	End If
	
	
'	Label1.Text="Name:"&citizen_name_g
'	Label2.Text="Phone:"&phone_g
'	Label3.Text="Gender:"&gender_g
'	Label4.Text="Status:"&status_g
'	Label5.Text="Clan:"&clan_g
End Sub
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
	
	domain="http://a56cb1fd.ngrok.io/"

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
	PanPop("fcpanel.bal", 20, 10)
	'ListView1.RemoveAt(Position)
End Sub

Sub PanPop (mlayout As String, hc As Int, wc As Int) '( mlayout=your .bal file, hc=height offset + or -, wc=same for width )
	
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
	
	Label1.Text="Name: Jesi Namora"
End Sub

Sub Select_Click ' Stop clicks on Select panel getting to panel underneath
	'this sub stops other clicks outside your panel from working
	pnlSelect.RemoveView
	Button1.Visible=True
End Sub
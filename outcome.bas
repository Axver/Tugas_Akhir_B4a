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
	domain="https://b9312448.ngrok.io/"
	
	Dim SV As ScrollView
	Dim Header As Panel
	Dim Table As Panel
	Dim NumberOfColumns, RowHeight, ColumnWidth As Int
	Dim HeaderColor, TableColor, FontColor, HeaderFontColor As Int
	Dim FontSize As Float
	
	Dim Alignment As Int
	Dim SelectedRow As Int
	Dim SelectedRowColor As Int
	
	'Table settings
	HeaderColor = Colors.Green
	NumberOfColumns = 4
	RowHeight = 30dip
	TableColor = Colors.White
	FontColor = Colors.Black
	HeaderFontColor = Colors.White
	FontSize = 14
	Alignment = Gravity.CENTER 'change to Gravity.LEFT or Gravity.RIGHT for other alignments.
	SelectedRowColor = Colors.Blue

	Private Panel7 As Panel
End Sub

Sub Activity_Create(FirstTime As Boolean)
	
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("outcome")
	SV.Initialize(0)
	Table = SV.Panel
	Table.Color = TableColor
	'Activity.AddView(SV, 5%x, 10%y, 90%x, 80%y)
	Panel7.AddView(SV, 5%x, 10%y, 90%x, 80%y)
	ColumnWidth = SV.Width / NumberOfColumns
	SelectedRow = -1
	'add header
	SetHeader(Array As String("Id", "Citizen", "From", "Destination"))
	job2.Initialize("Job2", Me)
	
	job2.PostString(domain&"ta_v2/endpoint/outcome.php", "send=test" &"&data=test")
	ProgressDialogShow("Loading...")
	'add rows
	'For i = 1 To 100
	'AddRow(Array As String(i, "Some text", i * 2, "abc"))
	'Next
	'set the value of a specific cell
	'SetCell(0, 3, "New value")
	'get the value
	'Log("Cell (1, 2) value = " & GetCell(1, 2))

End Sub

Sub Activity_Resume
	ClearAll
	job2.Initialize("Job2", Me)
	job2.PostString(domain&"ta_v2/endpoint/outcome.php", "send=test" &"&data=test")
	ProgressDialogShow("Loading...")
End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

Sub Cell_Click
	Dim rc As RowCol
	Dim l As Label
	l = Sender
	rc = l.Tag
	SelectRow(rc.Row)
	Activity.Title = "Cell clicked: (" & rc.Row & ", " & rc.Col & ")"
End Sub

Sub Header_Click
	Dim l As Label
	Dim col As Int
	l = Sender
	col = l.Tag
	Activity.Title = "Header clicked: " & col
End Sub
Sub SelectRow(Row As Int)
	'remove the color of previously selected row
	If SelectedRow > -1 Then
		For col = 0 To NumberOfColumns - 1
			GetView(SelectedRow, col).Color = Colors.Transparent
		Next
	End If
	SelectedRow = Row
	For col = 0 To NumberOfColumns - 1
		GetView(Row, col).Color = SelectedRowColor
	Next
End Sub
Sub GetView(Row As Int, Col As Int) As Label
	Dim l As Label
	l = Table.GetView(Row * NumberOfColumns + Col)
	Return l
End Sub
Sub AddRow(Values() As String)
	If Values.Length <> NumberOfColumns Then
		Log("Wrong number of values.")
		Return
	End If
	Dim lastRow As Int
	lastRow = NumberOfRows
	For i = 0 To NumberOfColumns - 1
		Dim l As Label
		l.Initialize("cell")
		l.Text = Values(i)
		l.Gravity = Alignment
		l.TextSize = FontSize
		l.TextColor = FontColor
		Dim rc As RowCol
		rc.Initialize
		rc.Col = i
		rc.Row = lastRow
		l.Tag = rc
		Table.AddView(l, ColumnWidth * i, RowHeight * lastRow, ColumnWidth, RowHeight)
	Next
	Table.Height = NumberOfRows * RowHeight
End Sub
Sub SetHeader(Values() As String)
	If Header.IsInitialized Then Return 'should only be called once
	Header.Initialize("")
	For i = 0 To NumberOfColumns - 1
		Dim l As Label
		l.Initialize("header")
		l.Text = Values(i)
		l.Gravity = Gravity.CENTER
		l.TextSize = FontSize
		l.Color = HeaderColor
		l.TextColor = HeaderFontColor
		l.Tag = i
		Header.AddView(l, ColumnWidth * i, 0, ColumnWidth, RowHeight)
	Next
	Activity.AddView(Header, SV.Left, SV.Top+200, SV.Width, RowHeight)
End Sub
Sub NumberOfRows As Int
	Return Table.NumberOfViews / NumberOfColumns
End Sub

Sub SetCell(Row As Int, Col As Int, Value As String)
	GetView(Row, Col).Text = Value
End Sub
Sub GetCell(Row As Int, Col As Int) As String
	Return GetView(Row, Col).Text
End Sub
Sub ClearAll
	For i = Table.NumberOfViews -1 To 0 Step -1
		Table.RemoveViewAt(i)
	Next
	Table.Height = 0
	SelectedRow = -1
End Sub

Sub JobDone (Job As HttpJob)
	
	Log("JobName = " & Job.JobName & ", Success = " & Job.Success)
	If Job.Success = True Then
		ClearAll
		Dim i As Int
		i=1
		
		Select Job.JobName
			Case "Job2"
				Dim parser As JSONParser
				parser.Initialize(Job.GetString)
				Dim root As Map = parser.NextObject
				Dim features As List = root.Get("features")
				For Each colfeatures As Map In features
					Dim properties As Map = colfeatures.Get("properties")
					Dim citizen_id As String = properties.Get("citizen_id")
					Dim destination As String = properties.Get("destination")
					Dim from As String = properties.Get("from")
					Dim status As String = properties.Get("status")
					AddRow(Array As String(i, citizen_id, from, destination))
					i=i+1
				Next
				
				

				
				
   
				ProgressDialogHide

			
		End Select
	Else
		Log("Error: " & Job.ErrorMessage)
		ToastMessageShow("Error: " & Job.ErrorMessage, True)
	End If
	Job.Release
End Sub


Sub Label7_Click
	StartActivity("add_outcome")
End Sub

Sub Label3_Click
	StartActivity("dashboard")
End Sub
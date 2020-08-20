Set oShell = CreateObject ("Wscript.Shell") 
Dim strArgs
strArgs = "cmd /c PuzzleMatch.bat"
oShell.Run strArgs, 0, false
Set oShell = CreateObject ("Wscript.Shell") 
Dim strArgs
strArgs = "cmd /c java -jar --enable-preview C:/Users/Manor/OneDrive/VSCodeWorkspace/Java/EarbudsConnector/EarbudsConnector.jar"
oShell.Run strArgs, 0, false
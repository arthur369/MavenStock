del /F /S C:\Users\Arthur\Downloads\*.zip 
del /F /S C:\Users\Arthur\Downloads\*.7z
forfiles /p C:\Users\Arthur\Downloads /d -200 /c "cmd /c del /s /q @path"

del /F /S D:\�U��\*.zip 
del /F /S D:\�U��\*.7z
forfiles /p D:\�U�� /d -200 /c "cmd /c del /s /q @path"
pause
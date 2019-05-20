del /F /S C:\Users\Arthur\Downloads\*.zip 
del /F /S C:\Users\Arthur\Downloads\*.7z
forfiles /p C:\Users\Arthur\Downloads /d -200 /c "cmd /c del /s /q @path"

del /F /S D:\¤U¸ü\*.zip 
del /F /S D:\¤U¸ü\*.7z
forfiles /p D:\¤U¸ü /d -200 /c "cmd /c del /s /q @path"
pause
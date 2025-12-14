@echo off
:: 1. Go to the project directory
cd /d "D:\projects\leetbot\Coding-Practice"

:: 2. Run the watcher using the VENV python (adjust if your venv is named differently)
:: If you don't use venv, just 'python watcher.py' works, but the 'cd' above is critical.
call venv\Scripts\activate.bat
python watcher.py

:: 3. Keep window open if it crashes (so you can see the error)
pause
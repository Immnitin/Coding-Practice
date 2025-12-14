import time
import subprocess
import pygetwindow as gw
import sys
from plyer import notification  # <--- Import notification here too

# --- CONFIGURATION ---
BOT_SCRIPT = "main.py"
PYTHON_EXE = sys.executable 

def send_watcher_alert(title, message):
    try:
        notification.notify(
            title=title,
            message=message,
            app_name='LeetBot Watcher',
            timeout=10
        )
    except:
        pass

def is_leetcode_open():
    """Checks if any active window title contains 'LeetCode'."""
    try:
        windows = gw.getAllTitles()
        for title in windows:
            if "LeetCode" in title:
                return True
        return False
    except Exception:
        return False
def run_bot():
    """Runs the main pipeline once."""
    print("🚀 LeetCode detected! Starting main.py...")
    
    try:
        # We capture the output to see what went wrong
        result = subprocess.run([PYTHON_EXE, BOT_SCRIPT], capture_output=True, text=True)
        
        # PRINT THE OUTPUT TO THE TERMINAL
        print("--- STDOUT (Normal Output) ---")
        print(result.stdout)
        print("--- STDERR (Error Output) ---")
        print(result.stderr)  # <--- THIS IS WHAT WE NEED TO SEE
        print("-----------------------------")

        if result.returncode != 0:
            error_msg = result.stderr if result.stderr else "Unknown Error"
            send_watcher_alert("LeetBot Crashed ❌", f"Check terminal for details.")
            
    except Exception as e:
        print(f"Wrapper Exception: {e}")
        send_watcher_alert("Watcher Error ⚠️", f"Could not start bot: {e}")
if __name__ == "__main__":
    print("👀 Watcher started...")
    
    while True:
        if is_leetcode_open():
            run_bot()
            # Wait 5 minutes before checking again
            time.sleep(300) 
        else:
            time.sleep(60)  
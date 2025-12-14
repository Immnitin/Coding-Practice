# 🤖 Automated Coding Portfolio

![LeetBot Status](https://img.shields.io/badge/LeetBot-Active-brightgreen?style=for-the-badge&logo=python)
![Java](https://img.shields.io/badge/Solutions-Java-orange?style=for-the-badge&logo=java)
![AI Power](https://img.shields.io/badge/AI-Llama3-blue?style=for-the-badge&logo=meta)

Welcome to my coding portfolio! This repository tracks my progress in Data Structures & Algorithms (DSA), specifically on **LeetCode**.

**But this is not a standard code dump.** I engineered a custom **CI/CD Pipeline** using Python and Generative AI to automate the entire documentation and deployment workflow.

---

## 🚀 How It Works (The "LeetBot")

I built a background service that runs on my local machine and manages this repository automatically.

1.  **👀 Detection:** A Python "Watcher" script monitors my active windows. When I open **LeetCode** in my browser, the bot wakes up.
2.  **📥 Scraping:** It polls the LeetCode API to detect new successful submissions.
3.  **🧠 AI Processing:** The raw code is sent to **Groq (Llama 3)**. The AI:
    * Analyzes the code logic.
    * Calculates **Time & Space Complexity**.
    * Writes a detailed **Javadoc/Explanation** for the approach.
    * *Crucially, it wraps my original code without modifying the logic.*
4.  **📂 Organization:** The file is automatically named and moved into a category folder (e.g., `SlidingWindow`, `Arrays`).
5.  **☁️ Deployment:** The pipeline commits the changes and pushes them to this GitHub repository.
6.  **🔔 Notification:** I receive a Windows Desktop Notification confirming the sync is complete.

---

## 📂 Repository Structure

The solutions are automatically organized by the underlying pattern or data structure:

```text
Coding-Practice/
├── LeetCode-Solutions/
│   ├── Arrays/
│   │   ├── TwoSum.java
│   │   └── ContainerWithMostWater.java
│   ├── SlidingWindow/
│   │   ├── MaxSlidingWindow.java
│   │   └── LongestSubstring.java
│   ├── DynamicProgramming/
│   └── Graphs/
└── README.md

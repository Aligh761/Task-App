<div align="center">

# ✅ TaskApp

**A clean, fast and offline-first task manager for Android**

Capture your tasks, tick them off, and watch your list update instantly.

![Kotlin](https://img.shields.io/badge/Kotlin-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white)
![Android](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![Room](https://img.shields.io/badge/Room-Database-4285F4?style=for-the-badge)
![Architecture](https://img.shields.io/badge/Architecture-MVP-orange?style=for-the-badge)
![License](https://img.shields.io/badge/License-MIT-blue?style=for-the-badge)

</div>

---

## 📸 Screenshots

<div align="center">

 <img src="[screenshots/splash.png](https://github.com/user-attachments/assets/2df2f319-2f09-46f2-b225-eaa76a020b2d)" width="200"/> | <img src="[screenshots/pending.png](https://github.com/user-attachments/assets/e8782655-61b8-45d6-9391-cf6f9b997104)" width="200"/> | <img src="[screenshots/add_task.png](https://github.com/user-attachments/assets/89d3ce27-6191-4363-b45c-dbab877c82bd)" width="200"/> 

</div>

---

## ✨ Features

- ➕ **Add tasks** quickly through a custom dialog with input validation
- ☑️ **Check / uncheck** a task with a single tap
- 🗑️ **Delete** tasks you no longer need
- 🔀 **Switch views** between pending and completed tasks
- ⚡ **Real-time updates**: the list refreshes the moment your data changes
- 🎞️ **Smooth animations** thanks to DiffUtil
- 💾 **Works offline**: all data is stored locally on your device
- 🌐 **Persian (RTL-friendly)** user interface

---

## 🏗️ Architecture

TaskApp is built with the **MVP (Model-View-Presenter)** pattern, keeping each layer small and focused.

```
┌──────────┐  user actions   ┌─────────────┐   data requests   ┌──────────┐
│   View   │ ──────────────▶ │  Presenter  │ ────────────────▶ │  Model   │
│ (UI/List)│ ◀────────────── │ (app logic) │ ◀──────────────── │ (Room DB)│
└──────────┘   show results  └─────────────┘   Flow updates    └──────────┘
```

- **Model**: insert, update, delete and observe tasks
- **View**: dialog, RecyclerView and screen widgets
- **Presenter**: connects the View and Model
- `OnBindData` callbacks carry data between layers, and `BaseLifeCycle` standardizes the presenter lifecycle

---

## 🛠️ Tech Stack

| Area | Library / Tool |
|------|----------------|
| Language | Kotlin |
| Local database | Room |
| Async work | Kotlin Coroutines & Flow |
| UI | RecyclerView, ViewBinding, Material components |
| List updates | DiffUtil |
| Architecture | MVP |

---

## 📁 Project Structure

```
ali.ghanbariyan.taskapp
├── adapter/      # RecyclerView adapter and DiffUtil callback
├── db/           # Room database, DAO and entity
├── mvp/          # Model, View, Presenter and shared interfaces
└── ui/activity/  # SplashScreen and MainActivity
```

---

## 🚀 Getting Started

1. **Clone** the repository
   ```bash
   git clone https://github.com/<your-username>/TaskApp.git
   ```
2. **Open** the project in Android Studio
3. **Sync** Gradle and wait for it to finish
4. **Run** the app on an emulator or a physical device

---

## 🗺️ Roadmap

- [ ] Edit task titles
- [ ] Categories, due dates and reminders
- [ ] Search and sorting
- [ ] Dark theme
- [ ] Migrate to ViewModel + StateFlow (MVVM)

---

## 🤝 Contributing

Contributions, issues and feature requests are welcome! Feel free to open an issue or submit a pull request.

---

<div align="center">

Made with ❤️ by **Ali Ghanbariyan**

If you like this project, give it a ⭐

</div>

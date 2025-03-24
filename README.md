# **Compose Multiplatform Project: Bookly**

A simple, cross-platform application built using **Jetpack Compose** for **Android** and **Compose Multiplatform** for **iOS**. This app allows users to explore, search, and manage a collection of books across multiple platforms seamlessly.

## **Table of Contents**

- [About](#about)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Installation](#installation)
- [Usage](#usage)
- [Contributing](#contributing)

---

## **About**

**Bookly** is a simple cross-platform mobile application built with **Kotlin Multiplatform** (KMP) and **Jetpack Compose Multiplatform (CMP)**. This project demonstrates how to build and run an app with a shared codebase for both Android and iOS platforms.

### **Key Features**:
- **Cross-Platform Development**: Using KMP for shared business logic and CMP for UI across Android and iOS.
- **Seamless Integration**: Utilize Kotlin Coroutines and other Kotlin libraries.
- **User Interface**: Modern, declarative UI built using Compose.

---

## **Features**

- **Book Search**: Search books by title, author, or genre.
- **Bookmarking**: Save your favorite books to a personal list.
- **Responsive UI**: UI adapts to both Android and iOS devices.

---

## **Technologies Used**

- **Kotlin Multiplatform** (KMP) for shared code across Android and iOS.
- **Jetpack Compose** for declarative UI on Android.
- **Compose Multiplatform** (CMP) for declarative UI on iOS.
- **Kotlin Coroutines** for managing background tasks and UI updates.
- **Kotlin Serialization** for data handling and serialization.

---

## **Installation**

To run this project locally on your machine, follow the instructions below.

### **Prerequisites**

- **Android Studio** with the Kotlin Multiplatform plugin installed.
- **Xcode** installed for iOS development.
- **CocoaPods** for managing iOS dependencies.
- **JDK 17** or higher.

### **Clone the Repository**

```bash
git clone https://github.com/yourusername/bookly.git
cd bookly
```

### **Android Setup**

1. Open the project in **Android Studio**.
2. Ensure your Android project syncs by clicking **File > Sync Project with Gradle Files**.
3. Run the project on an **Android emulator** or a physical device.

### **iOS Setup**

1. Install dependencies for iOS via **CocoaPods**:
   ```bash
   cd iosApp
   pod install
   ```
2. Open the `.xcworkspace` file in **Xcode**.
3. Build and run the project in the **iOS simulator** or a physical iOS device.

---

## **Usage**

1. Open the project in **Android Studio** for Android development or **Xcode** for iOS development.
2. Run the app on an **Android emulator** or **iOS simulator**.
3. Explore the features such as searching for books, bookmarking, and navigating through the app.

---

## **Contributing**

We welcome contributions! Feel free to fork the project and submit pull requests with your improvements or bug fixes.

### **How to contribute**

1. Fork the project.
2. Create a new branch (`git checkout -b feature-name`).
3. Commit your changes (`git commit -am 'Add new feature'`).
4. Push to the branch (`git push origin feature-name`).
5. Create a new pull request.

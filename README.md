# 🎮 GameBeast 🔥

A **Kotlin Multiplatform Mobile (KMP)** application for discovering
games, searching titles, and managing favorites.

------------------------------------------------------------------------

## 📖 Introduction

GameBeast is a Kotlin Multiplatform project built using:

-   MVVM (Model--View--ViewModel)
-   Clean Architecture
-   Multi-module structure
-   Shared business logic across platforms

The app allows users to browse games, search for titles, view detailed
information, and manage a personal favorites list with offline support.

------------------------------------------------------------------------

## 📑 Table of Contents

-   [Overview](#-overview)
-   [Features](#-features)
-   [UI](#-ui)
-   [Architecture](#-architecture)
-   [Modules](#-modules)
-   [Data Management](#-data-management)
-   [Navigation Flow](#-navigation-flow)
-   [Tech Stack](#-tech-stack)
-   [Installation](#-installation)
-   [Usage](#-usage)
-   [Configuration](#-configuration)
-   [Project Structure](#-project-structure)
-   [Future Improvements](#-future-improvements)
-   [Troubleshooting](#-troubleshooting)
-   [Contributors](#-contributors)
-   [License](#-license)

------------------------------------------------------------------------

## 📱 Overview

GameBeast is structured using Clean Architecture principles with a
modular Kotlin Multiplatform setup.

The application includes:

-   Home screen with game listings
-   Search functionality
-   Game details view
-   Favorites management with local storage

------------------------------------------------------------------------

## ✨ Features

### 🏠 Home Screen

-   Displays a list of games fetched from remote APIs
-   Entry point to Search and Favorites
-   Navigate to Game Details by selecting a game

### 🔍 Search Screen

-   API-powered game search
-   Navigate to Game Details from results

### 🎮 Game Details Screen

-   Displays complete game information
-   Add or remove games from favorites
-   Favorites stored locally

### ❤️ Favorites Screen

-   Shows saved favorite games
-   Navigate to Game Details
-   Remove games from favorites
-   Offline access supported

------------------------------------------------------------------------
## 🧱 UI
<p align="center">
  <img src="https://github.com/user-attachments/assets/e3748a4a-c633-485f-a7bf-25f2fe96a487" width="210" style="border-radius:12px; margin:6px;"/>
  <img src="https://github.com/user-attachments/assets/724707ca-b8cc-4720-851e-74fad5207396" width="210" style="border-radius:12px; margin:6px;"/>
  <img src="https://github.com/user-attachments/assets/042535ca-44f6-4df5-ae30-708bc593fe26" width="210" style="border-radius:12px; margin:6px;"/>
  <img src="https://github.com/user-attachments/assets/ce504e6b-db88-4a8a-8fab-0fcbc2d263bc" width="210" style="border-radius:12px; margin:6px;"/>
</p>

------------------------------------------------------------------------

## 🧱 Architecture

The project follows:

-   MVVM Architecture
-   Clean Architecture principles
-   Multi-module structure
-   Kotlin Multiplatform (KMP)

### Layer Responsibilities

  Layer          Responsibility
  -------------- ---------------------------------------------
  Presentation   UI + ViewModels
  Domain         Business logic & use cases
  Data           API + Database + Repository implementations

------------------------------------------------------------------------

## 🧩 Modules

### Core Modules

-   `core-network` → API client & networking configuration\
-   `core-database` → SQLDelight database setup\
-   `core-logger` → Logging utilities\
-   `common` → Shared utilities & base components

### Feature Modules

-   `game` → Game listing & details\
-   `search` → Search functionality\
-   `favorite` → Favorite management

------------------------------------------------------------------------

## 💾 Data Management

### Remote Data

-   Game listings and search results fetched from APIs

### Local Data

-   Favorites stored using SQLDelight
-   Add/remove operations supported
-   Offline access to saved games

------------------------------------------------------------------------

## 🧭 Navigation Flow

    Home → Game Details
    Home → Search → Game Details
    Home → Favorites → Game Details

------------------------------------------------------------------------

## 🛠 Tech Stack

-   Kotlin Multiplatform (KMP)
-   MVVM Architecture
-   Clean Architecture
-   SQLDelight
-   Coroutines & Flow
-   Modular Project Structure
-   API Integration

------------------------------------------------------------------------

## 🚀 Installation

1.  Clone the repository:

``` bash
git clone <repository-url>
```

2.  Open the project in Android Studio
3.  Sync Gradle
4.  Select your platform target
5.  Run the project

------------------------------------------------------------------------

## ▶️ Usage

-   Browse games on the Home screen
-   Search for specific titles
-   View detailed game information
-   Add games to Favorites
-   Access saved games offline

------------------------------------------------------------------------

## ⚙️ Configuration

If API keys are required:

1.  Add your API key to:
    -   `local.properties` OR
    -   A secure configuration file
2.  Ensure the key is injected into the `core-network` module.

------------------------------------------------------------------------

## 🗂 Project Structure

    GameBeast
    │
    ├── core-network
    ├── core-database
    ├── core-logger
    ├── common
    │
    ├── game
    ├── search
    ├── favorite
    │
    └── shared

------------------------------------------------------------------------

## 🔮 Future Improvements

-   Pagination support
-   Caching strategy
-   UI enhancements
-   Unit tests
-   Integration tests

------------------------------------------------------------------------

## 🛠 Troubleshooting

### Gradle Sync Issues

-   Use the latest stable Android Studio
-   Invalidate caches and restart if necessary

### API Issues

-   Verify API key configuration
-   Check internet permissions

### Database Issues

-   Clear app data
-   Verify SQLDelight schema configuration

------------------------------------------------------------------------

## 👨‍💻 Contributors

GameBeast --- Kotlin Multiplatform learning project

------------------------------------------------------------------------

## 📄 License

This project is for educational purposes.\
You may modify and use it according to your needs.

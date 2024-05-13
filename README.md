# Usercentrics Case Study

### Overview

**UserCentrices** is a powerful SDK for Consent Management Platform (CMP).This SDK simplifies the process of obtaining consent from users for data collection and tracking. It ensures that users are informed about how their data is used, promoting transparency and compliance with privacy regulations.I thoroughly enjoyed working on this case study and exploring the features and benefits of UserCentrices.

### Environment Requirements

To run this project, you need the following:

- Android Studio Iguanaor later.
- Android SDK with API level 24 or higher.
- Kotlin version 1.9.0 or later.
- Gradle version 8.4.
- Jetpack Compose BOM Version: 2023.08.00
- Pixel emulator

### Getting Started

1. Clone this repository to your local machine.
2. Open the project in Android Studio Iguanaor later.
3. Build the project to download dependencies.
4. Run the app on an emulator or physical device.

# Used Technologies and Design Patterns

## Architecture
### MVVM (Model-View-ViewModel)
The project follows the MVVM architecture pattern, which separates the user interface logic from the business logic and data handling.
The project adopts Clean Architecture principles to maintain separation of concerns and improve testability, scalability, and maintainability.

## Dependency Injection
### Hilt
Hilt is used for dependency injection, providing a standard way to manage dependencies and simplify testing.

### Mockito
Mockito is used for mocking objects in unit tests, allowing isolated testing of individual components.

### JUnit 4
JUnit 4 is the testing framework used for writing and executing unit tests.

### Strategy Design Pattern
The Strategy pattern is used to define a family of algorithms, encapsulate each one, and make them interchangeable. It allows selecting an algorithm at runtime.

### State Flow for View State Management
State Flow is used to manage view state changes in the project. It provides a reactive way to update UI components based on changes in the application state.

### Jetpack Compose
- Utilized for building the user interface, leveraging its modern approach to UI development.
- Integrated Material 3 Design components and guidelines to ensure a consistent and visually appealing UI.
- Employed the ConstraintLayout API to create flexible and responsive layouts, enabling complex UI designs.
- Leveraged the Animation API in Jetpack Compose to add delightful animations and transitions to the UI, enhancing user experience.
- Utilized Jetpack Compose Metrics to gather insights into UI performance and user interactions, aiding in optimization and refinement of the application.

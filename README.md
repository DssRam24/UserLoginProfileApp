
# Student Registration, Login and Profile Management

## About
UserLoginProfileApp is an Android student authentication application designed to provide a basic student portal with registration, login, and profile management functionalities.

The application allows students to create accounts, authenticate using their credentials, access their profile information, and log out securely.

## Features
- Student registration.
- User login and authentication.
- Input validation for name, email, mobile number, and password.
- Duplicate account validation.
- Profile information display.
- SQLite-based user data storage.
- SharedPreferences-based login session management.
- Logout functionality.
- Persistent registration data.

## Technologies Used
- Java
- XML
- Android Studio
- SQLite
- SQLiteOpenHelper
- SharedPreferences
- Android Intents
- Android Activities

## Core Concepts
- User Authentication.
- Form Validation.
- SQLite Database Management.
- SharedPreferences.
- Explicit Intents.
- Activity Navigation.
- Session Management.
- Data Persistence.

## Application Workflow
1. Launch the application.
2. Register using personal details.
3. Validate registration inputs.
4. Store user information in SQLite.
5. Navigate to the Login screen.
6. Authenticate using registered credentials.
7. Open the corresponding student profile.
8. Maintain basic login session information using SharedPreferences.
9. Logout and return to the Login screen.

## Learning Outcomes
- Understanding Android authentication workflows.
- Implementing registration and login functionality.
- Integrating SQLite for persistent storage.
- Managing basic login sessions using SharedPreferences.
- Navigating between activities using explicit Intents.
- Implementing form validation.

## Security Considerations
This project is an educational authentication prototype. Production applications should use secure authentication mechanisms and never store plaintext passwords.

## Platform
Android

## Language
Java

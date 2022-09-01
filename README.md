# Berlin Clock (Mengenlehreclock or Berlin Uhr)



<img width="270" alt="Berlin_clock_2" src="https://user-images.githubusercontent.com/112353324/187903784-dc0ee1bf-62aa-44cf-ac8c-f35467d91aea.png">

# Rules
The Berlin Clock (Mengenlehreclock or Berlin Uhr) is a clock that tells the time using a series of illuminated coloured blocks, as you can see in the picture for this project.

The top lamp blinks to show seconds- it is illuminated on even seconds and off on odd seconds.

The next two rows represent hours. The upper row represents 5 hour blocks and is made up of 4 red lamps. The lower row represents 1 hour blocks and is also made up of 4 red lamps.

The final two rows represent the minutes. The upper row represents 5 minute blocks, and is made up of 11 lamps- every third lamp is red, the rest are yellow. The bottom row represents 1 minute blocks, and is made up of 4 yellow lamps.

# Setup

Clone the project using below command

```bash
https://github.com/2022-DEV2-008/BerlinClock_Katas
```

Here are some useful Gradle/adb commands for executing this project:

 * `./gradlew runApp` - Builds and install the debug apk on the current connected device.
 * `./gradlew compileApp` - Builds the debug apk.
 * `./gradlew runUnitTests` - Execute unit tests (both unit and integration).
 * `./gradlew connectedAndroidTest` - Execute UI tests.

# Running App

- Import Project in android studio
- Perorm gradle build to install all the dependencies
- =Run the application in emulator or physical device using Shift+F10

# Approaches Followed :

- Test Driven Development (TDD)

- UI Tests & Unit Tests

- MVVM architecture

- Dependency Injection

- Data Bindings

# Dependencies used
 
 - Koin
 
 - Navigation Controller
 
 - Google Truth

# Prerequisites
- Android Studio Arctic Fox | 2020.3.1 Patch 4
- Gradle 7.0.4

# SauceDemo Automation Tests
This project contains automated tests for [saucedemo.com](https://www.saucedemo.com/) using Selenium WebDriver and Java.
## 🛠️ Technologies Used
- Java
- Selenium WebDriver
- TestNG
- Maven

## 🧪 Test Scenarios
1. ✅ **Valid Login** – Login with correct username and password.
2. ✅ **valid Login** – Login with correct username and password with screenshots.
3. ❌ **Invalid Login** – Login with incorrect username with screen shot.

## 📸 Screenshots
Screenshots for failed login attempts are saved in the `/screenshots` folder.
## ▶️ How to Run
Make sure you have Java and Maven installed, then run:

```bash
mvn test
src/
  test/
    java/
      ValidLoginTest.java
      InvalidLoginTest.java
screenshots/
pom.xml
```
## 📌 Notes
- Tests use assertions to validate expected results.
- You can add more edge cases like locked-out user, performance glitch user, etc.


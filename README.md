# Appium Automation Scaffold (Java + TestNG)

A minimal, reusable scaffold for **mobile UI automation** using **Appium**, **Java 17+**, and **TestNG**, with **Allure reports** and **screenshots on failure**.

---

## ✨ Features
- Java + TestNG + Appium setup
- **Allure reporting** (`allure-results/`)
- **Screenshots on failure** (`screenshots/`)
- **Config-driven** via `env.json` (devices, app path, capabilities)
- Page Object Model–ready structure
- Works with emulators/simulators and real devices

---

## 🗂 Project Structure
```

.
├─ pom.xml
├─ testng.xml
├─ env.json
├─ src/
│  └─ test/
│     └─ java/
│        ├─ base/            # Driver setup, hooks, Allure attachments
│        ├─ pages/           # Page Objects (locators + actions)
│        └─ tests/           # Test classes (TestNG)
├─ allure-results/           # Generated after test runs
├─ screenshots/              # Failure screenshots
└─ target/                   # Maven build artifacts

````

---

## ⚙️ Prerequisites
- **Java JDK 17+**
- **Maven 3.8+**
- **Node.js** and **Appium server**: `npm i -g appium`
- Platform tools:
  - **Android**: Android SDK + `adb` + emulator or real device
  - **iOS (optional)**: Xcode + simulators or provisioned device
- (Optional) **Allure CLI** to view HTML reports  
  - macOS: `brew install allure`  
  - Others: download Allure CLI and add to `PATH`

---

## 🔧 Configuration

### `env.json`
Edit platform, app path, device name/UDID, and desired capabilities:
```json
{
  "platformName": "Android",
  "isRemote": false,
  "remoteConnectionUrl": "http://127.0.0.1:4723/wd/hub",
  "driverSettings": {
    "android": {
      "deviceKey": "<DEVICES_JSON_KEY>",
      "applicationPath": "./apps/YourApp.apk",
      "capabilities": {
        "platformName": "Android",
        "automationName": "UiAutomator2",
        "deviceName": "<deviceName-or-udid>",
        "udid": "<udid-if-required>"
      }
    },
    "ios": {
      "deviceKey": "<DEVICES_JSON_KEY>",
      "applicationPath": "./apps/TestApp.app.zip",
      "capabilities": {
        "platformName": "iOS",
        "automationName": "XCUITest",
        "deviceName": "iPhone 14"
      }
    }
  }
}
````

> Keep credentials out of VCS; inject via environment variables if needed.

### `testng.xml`

List suites/classes to run and (optionally) enable groups/parallelism.

---

## 🚀 Quickstart

1. **Install dependencies**

```bash
mvn -q -U -DskipTests=false clean compile
```

2. **Start Appium**

```bash
appium
# or bind explicitly:
appium --address 127.0.0.1 --port 4723
```

3. **Connect a device or start an emulator**

```bash
adb devices   # ensure at least one device/emulator is 'device'
```

4. **Run tests**

```bash
mvn -q test
# run a specific class:
mvn -Dtest=tests.LoginTest test
# run with a custom suite:
mvn -Dtestng.xml=testng.xml test
```

5. **Open Allure report**

```bash
# after a run generates allure-results/
allure serve allure-results
# or generate static site:
allure generate --clean allure-results -o allure-report
```

---

## 🧪 Writing Tests (POM-friendly)

* Put setup/teardown and reporting in `base/`.
* Implement screens in `pages/` (locators left blank by design; fill per app).
* Keep test classes in `tests/` small; call page methods only.

**Page sketch:**

```java
public class LoginPage {
  // Fill these for your target app
  private static final By USERNAME = By.xpath("");
  private static final By PASSWORD = By.xpath("");
  private static final By SUBMIT   = By.xpath("");

  public LoginPage typeUsername(String v) { /* ... */ return this; }
  public LoginPage typePassword(String v) { /* ... */ return this; }
  public void submit() { /* ... */ }
}
```

---

## 🖼 Screenshots on Failure

An `@AfterMethod` hook captures a screenshot on test failure, saves it under `screenshots/`, and attaches it to Allure.

---

## 🔁 Multi-Device Tips

Override defaults via system properties:

```bash
mvn -Dplatform=android -Dudid=emulator-5554 -Dapp=./apps/Debug.apk test
mvn -Dplatform=android -Dudid=RZ8N123ABC -Dapp=./apps/Debug.apk test
```

---

## 🧰 Troubleshooting

* **No devices**: `adb kill-server && adb start-server` then `adb devices`
* **Session not created**: verify `udid`, `app` path, and Appium server logs
* **iOS WDA flakiness**: clean derived data; ensure signing; boot simulator
* **Empty Allure**: confirm `allure-results/` files were produced

---

## 🤝 Contributing

1. Create a branch: `feat/your-change`
2. Add/update tests
3. `mvn clean test`
4. Open a PR with a clear description

## 📜 License

Add a `LICENSE` file (e.g., MIT) if you want an explicit OSS license.

```

Did I go through the whole project?  
I **reviewed the repository tree and top-level files** (e.g., `pom.xml`, `testng.xml`, `env.json`, `src/test/java/`, `allure-results/`, `screenshots/`). Direct file contents didn’t fully render in-browser due to a GitHub loading error, but the structure and key files are confirmed. If you want, I can deep-read specific classes once rendering works or you share a zipped copy. :contentReference[oaicite:0]{index=0}
::contentReference[oaicite:1]{index=1}
```

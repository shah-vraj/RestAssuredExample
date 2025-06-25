# 🧪 RestAssuredExample

A clean Java + Rest‑Assured example for testing a REST API using BDD-style tests.

---

## 🔧 Project Setup

### Prerequisites
- Java 11 (or higher)
- Maven 3.6+
- [Rest‑Assured](http://rest-assured.io) for HTTP testing
- TestNG for test execution
- Cucumber BDD for defining feature scenarios

Clone the project:
```bash
git clone https://github.com/shah-vraj/RestAssuredExample.git
cd RestAssuredExample
````

---

## 🚀 Running Tests

### Through IDE

Open the project in your favorite IDE and run the test runner class under `src/test/java/runner/`.

### Via Maven

```bash
mvn clean test
```

---

## 🗂️ Project Structure

```
RestAssuredExample/
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── api/
│   │       │   └── Contains code that makes API calls
│   │       ├── config/
│   │       │   └── App configuration file and its manager
│   │       ├── model/
│   │       │   └── Model classes used in application
│   │       ├── spec/
│   │       │   └── Request specification for API
│   │       └── util/
│   │           └── Utility classes
│   └── test/
│       ├── java/
│       │   ├── runner/
│       │   │   └── Contains all runner classes
│       │   └── stepdef/
│       │       └── Step definition files for all feature
│       └── resources/
│           ├── config/
│           │   └── CLI support xml file for running tests
│           ├── feature/
│           │   └── Feature files written using Gherkin syntax following BDD framework
│           └── api.properties
├── .gitignore
├── pom.xml
└── README.md
```

---

## 📄 How It Works

1. **Configure RestAssured** (base URI, api-key, etc.)
2. Write tests using BDD style (given/when/then)
3. Use Specs or Builders to keep test code DRY
4. Optionally, parse JSON responses into POJOs for object-level assertions

---

## 🔧 Customization Tips

* Configure base URI and authentication in a `config.properties` or environment variables
* Use Java Faker or other libs to generate random test data
* Add JSON schema validation, logging, and retry logic for robust test coverage

---

## ✅ Why This Setup?

Following a structure inspired by widely used API test frameworks

---

## 📈 CI / Reporting

Want to integrate with CI or generate reports?

* Add Maven Surefire plugin for test execution
* Add \[Allure] or \[ExtentReports] for rich test results

---

## 🤝 Contributing

1. Fork the repo
2. Create a new feature branch (`git checkout -b feature/my-test`)
3. Write tests or improvements
4. Submit a pull request

---

Happy testing! 🚀
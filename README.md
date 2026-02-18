#Insider QA Automation Case

##Project Overview

This project is a **Selenium + TestNG UI Test Automation Framework** developed to validate the Insider careers QA job listing flow.

The test scenario automates the following user journey:

1. Visit Insider homepage
2. Accept cookies
3. Verify homepage loads correctly
4. Navigate to QA Careers page
5. Filter jobs by
    * Location → Istanbul, Turkiye
    * Department → Quality Assurance
6. Validate job listings
7. Click **View Role**
8. Verify redirect to Lever application page

---

##Project Architecture

Project follows **Page Object Model (POM)** design pattern.

```
src
 ├── main
 │   ├── java
 │   │   ├── pages
 │   │   └── utilities
 │   └── resources
 └── test
     └── java
         └── tests
```

---

##Packages & Classes

###pages

Contains all page object classes.

####CareersPage

Handles navigation to QA job listings and clicking *See All Jobs*.

####HomePage

Responsible for homepage operations:

* Opening base URL
* Cookie acceptance
* Section load validation

####QAJobsPage

Handles job listing page logic:

* Filtering by location & department
* Validating job list content
* Clicking first job
* Switching to new tab

####LeverPage

Validates that user is redirected to Lever application page.

---

###utilities

Framework infrastructure classes.

####BaseTest

Handles test setup & teardown.

####ConfigReader

Reads configuration values from `config.properties`.

####DriverFactory

Creates and manages WebDriver instance.

####WaitUtils

Custom explicit wait utility wrapper for:

* visibility
* clickability
* element count
* list load

---

###tests

####InsiderTest

Contains the main test scenario:

```
insiderQAFlow()
```

---

###resources

####config.properties

Stores environment configuration:

```
baseUrl=https://insiderone.com
qaUrl=https://insiderone.com/careers/quality-assurance/
```

---

##Technologies Used

* Java 11 (Project built with Java 11 (LTS) for stability and compatibility. Can be upgraded to Java 17 easily if required.)
* Selenium 4.18
* TestNG 7.9
* Maven
* Page Object Model

---

##How to Run Tests

### 1 Clone repository

```
git clone <repo-url>
```

### 2 Install dependencies

```
mvn clean install
```

### 3 Run tests

```
mvn clean test
```

---

##Framework Design Decisions

###Explicit Wait Strategy

All waits are handled via `WaitUtils` to prevent:

* flaky tests
* timing issues
* stale element errors

---

###Singleton Driver Pattern

DriverFactory ensures only one WebDriver instance runs during test execution.

---

###Config Driven URLs

URLs are not hardcoded in tests or pages. They are stored in:

```
config.properties
```

This allows:

* environment switching
* CI/CD compatibility
* easy maintenance

---

##Test Stability Considerations

Framework includes safeguards for dynamic DOM:

* explicit waits for element count
* visibility checks before interaction
* tab switching handling
* locator-based waits

---

##Author

**Munir Akman**

QA Automation Engineer Candidate Case Study

---

##Notes for Reviewers

This framework was intentionally designed to demonstrate:

* clean architecture
* maintainability
* stability practices
* real-world automation standards

Not just passing tests, but **production-ready test design mindset**.

---

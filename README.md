# Spring.boot framework with playwright

Recently I started to work with playwright, so I created this framework to practice & provide an implementation model.

# ⚙️ Dependencies Overview

| Library                    | Version                | Category       | Purpose                                      |
|----------------------------|------------------------|----------------|----------------------------------------------|
| Java                       | 21                     | Runtime        | Application runtime environment              |
| Spring Boot Starter Parent | 3.5.13                 | Framework      | Manages dependency versions                  |
| spring-boot-starter        | 3.5.13                 | Spring         | Core Spring Boot setup                       |
| spring-boot-starter-web    | 3.5.13                 | Spring         | Web context (MVC/REST support)               |
| spring-boot-test           | 3.5.13                 | Spring Testing | Testing utilities and annotations            |
| spring-test                | Managed by Spring Boot | Spring Testing | TestContext framework integration            |
| playwright                 | 1.45.0                 | UI Automation  | Browser automation (Chrome, Firefox, WebKit) |
| cucumber-java              | 7.13.0                 | BDD            | Step definitions for Cucumber                |
| cucumber-spring            | 7.13.0                 | BDD + Spring   | Spring integration for Cucumber              |
| cucumber-testng            | 7.13.0                 | Test Runner    | Runs Cucumber tests via TestNG               |
| assertj-core               | 3.27.7                 | Assertions     | Fluent assertions for tests                  |
| jackson-databind           | 2.15.4                 | JSON           | JSON serialization/deserialization           |
| datafaker                  | 2.2.2                  | Test Data      | Generates fake test data                     |

## Installation

1. Install the Cucumber plugin
2. Run the feature by pressing the run button

## License

MIT
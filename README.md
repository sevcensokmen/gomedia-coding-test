## gomedia-coding-test
This project shows how to use selenium framework to test given example project.

---
## Installation
To develop the testing code
- Selenium WebDriver
- Maven
- Cucumber
- TestNG
- Java 8 JDK 

To run the tests locally with 
- `Chrome`: install ChromeDriver from [here](http://chromedriver.chromium.org)
- `Firefox`: install GeckoDriver from [here](https://github.com/mozilla/geckodriver/releases)


## Files

- Cucumber feature file is under `/resources/features` folder
- Test results report is under`/target/cucumber-reports` folder
- `config.properties` are defined under `src/test/resources/properties` folder.
  - Set browser (chrome or firefox) `browser=chrome`
  - Set OS name (mac or windows) `os.name=mac`

## Running tests ##

1. Run maven project

```console
$ mvn test
```


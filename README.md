# Automation test UI 
http://132.147.72.181:8383/PTBPMS/login

## Getting Started
Automation test UI using selenium
### Prerequisites
IDE: IntelliJ IDEA, Eclipse

Maven
 
Java
1.8

### Run test
Using this command.
```
mvn clean test
```
If the tests fail screenshots will be saved in ${project.basedir}/target/screenshots
### Pattern in this project
PageObject
https://martinfowler.com/bliki/PageObject.html

FluentInterface
https://martinfowler.com/bliki/FluentInterface.html

### Source Code Structer
### A typical top-level directory layout

    ├── PTBPMSTest
        ├── src/main/java                    #Source code handle action,navigation,selecion
            │ com.ptbms
                ├── config                  #Config web driver
                ├── listener                # Add screenshot when testcase failure
                └── pages
                    ├── constants           # Load and stress tests
                    ├── enums               #enum type
                    ├── login               # handle action and validation loginPage
                    ├── navigation          # handle menu navigation
                    ├── orderprocess        # handle orderProces menu
                        ├── replenish       # handle action( create/search/view/...) and validation result Replenish Order List
        ├── src/test/java                   Add test case
            ├── com.test.ptbms
            │   ├── base                    # Test base init 
            │   ├── login                   # Test case login page
            │   └── orderprocess            # Orderprocess test case
            └── ...
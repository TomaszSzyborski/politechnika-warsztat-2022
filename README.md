# politechnika-warsztat-2022


How to execute tests locally:

* set `remote.run=false` in `configuration.properties` (implemente)
* then `gradlew clean test`
* then `gradlew allureServe`

#TODO dockerization + allure serve
Prerequisites:
- Docker installed
- if on Windows then Docker for windows up and running
How to execute tests:
Using commandline - preferably `bash` or `powershell`,
navigate to the project, then run:

```docker-compose up --build --force-recreate --remove-orphans```
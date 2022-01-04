# politechnika-warsztat-2022


How to execute tests locally:

* set `remote.run=false` in `configuration.properties` (remote execution not yet implemented)
* then `gradlew clean test`
* then `gradlew allureReport`
* then `gradlew allureServe`

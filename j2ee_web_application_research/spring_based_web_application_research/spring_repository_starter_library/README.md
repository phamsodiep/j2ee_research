# Spring Repository Blueprints Investigatory Project
## Brief description
This Investigatory Project tries answering how to create a new Repository library that could be used in a similar way to @𝘌𝘯𝘢𝘣𝘭𝘦𝘑𝘱𝘢𝘙𝘦𝘱𝘰𝘴𝘪𝘵𝘰𝘳𝘪𝘦𝘴 or @𝘌𝘯𝘢𝘣𝘭𝘦𝘔𝘰𝘯𝘨𝘰𝘙𝘦𝘱𝘰𝘴𝘪𝘵𝘰𝘳𝘪𝘦𝘴, the Spring repository blueprints.

## Motivation
Since relational database have an unified JDBC interface, adding a new database driver results in @𝘌𝘯𝘢𝘣𝘭𝘦𝘑𝘱𝘢𝘙𝘦𝘱𝘰𝘴𝘪𝘵𝘰𝘳𝘪𝘦𝘴 could be reused, just new JDBC driver is need. However, the NoSQL database has no such unified interface. For such case, a new data library bridging the gap between Spring repository data and new NoSQL database driver is needed.

## Target questions
* How Spring wires up beans with an annotation similar to @𝘌𝘯𝘢𝘣𝘭𝘦𝘑𝘱𝘢𝘙𝘦𝘱𝘰𝘴𝘪𝘵𝘰𝘳𝘪𝘦𝘴 or @𝘌𝘯𝘢𝘣𝘭𝘦𝘔𝘰𝘯𝘨𝘰𝘙𝘦𝘱𝘰𝘴𝘪𝘵𝘰𝘳𝘪𝘦𝘴?
* How Spring implement interface methods e.g. 𝘧𝘪𝘯𝘥𝘉𝘺𝘋𝘢𝘵𝘦, 𝘧𝘪𝘯𝘥𝘉𝘺𝘋𝘖𝘉... at runtime for a declared repository interface?

## Build and test
* To build, launch maven command:
  * mvn clean package
* To test, please refer to project [𝘴𝘱𝘳𝘪𝘯𝘨_𝘳𝘦𝘱𝘰𝘴𝘪𝘵𝘰𝘳𝘺_𝘴𝘵𝘢𝘳𝘵𝘦𝘳_𝘭𝘪𝘣𝘳𝘢𝘳𝘺_𝘵𝘦𝘴𝘵](https://github.com/phamsodiep/j2ee_research/tree/master/j2ee_web_application_research/spring_based_web_application_research/spring_repository_starter_library_test)

## Dependent projects
* This project is independent, but the test project 𝘴𝘱𝘳𝘪𝘯𝘨_𝘳𝘦𝘱𝘰𝘴𝘪𝘵𝘰𝘳𝘺_𝘴𝘵𝘢𝘳𝘵𝘦𝘳_𝘭𝘪𝘣𝘳𝘢𝘳𝘺_𝘵𝘦𝘴𝘵 is not.

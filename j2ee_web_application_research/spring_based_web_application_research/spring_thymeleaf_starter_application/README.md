# Spring Thymeleaf Skeleton Project
## Brief description
A skeleton project to build Spring Boot application that initially applies Spring Thymeleaf library.

### Build
* Launch 𝘮𝘢𝘷𝘦𝘯 build command:
  * mvn clean package

### Test
* Assuming that the cloned version is 0.0.1-𝘚𝘕𝘈𝘗𝘚𝘏𝘖𝘛, launch target generated Spring Boot application jar file 𝘵𝘩𝘺𝘮𝘦𝘭𝘦𝘢𝘧-𝘴𝘬𝘦𝘭𝘦𝘵𝘰𝘯-0.0.1-𝘚𝘕𝘈𝘗𝘚𝘏𝘖𝘛.𝘫𝘢𝘳 for testing.
  * java -jar spring_thymeleaf_starter_application/target/thymeleaf-skeleton-0.0.1-SNAPSHOT.jar

## Dependent projects
* This project is independent.

## Upgrade patches
### google_app_engine
* This patch adds 𝘮𝘢𝘷𝘦𝘯 pom file and related manifest file to build war artifact which could be launched on Google App Engine standard environment.
* Assuming that the target pom file version is 00:
  * Launch below command to patch:
    * ./upgrade/import_scripts/import_google_app_engine_build.sh 00
  * Launch below 𝘮𝘢𝘷𝘦𝘯 build command to build:
    * mvn -f gae-pom-00.xml appengine:deploy

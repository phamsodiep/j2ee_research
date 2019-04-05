# Spring Repository Blueprints Investigatory Project
## Brief description
This project is used to test project [𝘴𝘱𝘳𝘪𝘯𝘨_𝘳𝘦𝘱𝘰𝘴𝘪𝘵𝘰𝘳𝘺_𝘴𝘵𝘢𝘳𝘵𝘦𝘳_𝘭𝘪𝘣𝘳𝘢𝘳𝘺](https://github.com/phamsodiep/j2ee_research/tree/master/j2ee_web_application_research/spring_based_web_application_research/spring_repository_starter_library).

## Procedure
This test project is developed from 𝘴𝘱𝘳𝘪𝘯𝘨_𝘵𝘩𝘺𝘮𝘦𝘭𝘦𝘢𝘧_𝘴𝘵𝘢𝘳𝘵𝘦𝘳_𝘢𝘱𝘱𝘭𝘪𝘤𝘢𝘵𝘪𝘰𝘯 applying library created by 𝘴𝘱𝘳𝘪𝘯𝘨_𝘳𝘦𝘱𝘰𝘴𝘪𝘵𝘰𝘳𝘺_𝘴𝘵𝘢𝘳𝘵𝘦𝘳_𝘭𝘪𝘣𝘳𝘢𝘳𝘺. To archive this, it does:
* Applying patches to 𝘴𝘱𝘳𝘪𝘯𝘨_𝘵𝘩𝘺𝘮𝘦𝘭𝘦𝘢𝘧_𝘴𝘵𝘢𝘳𝘵𝘦𝘳_𝘢𝘱𝘱𝘭𝘪𝘤𝘢𝘵𝘪𝘰𝘯 to create test project.
* Import 𝘮𝘢𝘷𝘦𝘯 𝘵𝘢𝘬𝘢𝘳𝘪 𝘱𝘭𝘶𝘨𝘪𝘯 to build multiple projects and manage dependency between projects. The related projects are:
  * This project: 𝘴𝘱𝘳𝘪𝘯𝘨_𝘳𝘦𝘱𝘰𝘴𝘪𝘵𝘰𝘳𝘺_𝘴𝘵𝘢𝘳𝘵𝘦𝘳_𝘭𝘪𝘣𝘳𝘢𝘳𝘺_𝘵𝘦𝘴𝘵
  * 𝘴𝘱𝘳𝘪𝘯𝘨_𝘳𝘦𝘱𝘰𝘴𝘪𝘵𝘰𝘳𝘺_𝘴𝘵𝘢𝘳𝘵𝘦𝘳_𝘭𝘪𝘣𝘳𝘢𝘳𝘺
  * 𝘴𝘱𝘳𝘪𝘯𝘨_𝘵𝘩𝘺𝘮𝘦𝘭𝘦𝘢𝘧_𝘴𝘵𝘢𝘳𝘵𝘦𝘳_𝘢𝘱𝘱𝘭𝘪𝘤𝘢𝘵𝘪𝘰𝘯 

Procedure includes:
* Pre-build
* Build
* Test

### Pre-build
This does importing and patching, steps include:
* Importing 𝘴𝘱𝘳𝘪𝘯𝘨_𝘵𝘩𝘺𝘮𝘦𝘭𝘦𝘢𝘧_𝘴𝘵𝘢𝘳𝘵𝘦𝘳_𝘢𝘱𝘱𝘭𝘪𝘤𝘢𝘵𝘪𝘰𝘯 for patching
* 𝘴𝘱𝘳𝘪𝘯𝘨_𝘵𝘩𝘺𝘮𝘦𝘭𝘦𝘢𝘧_𝘴𝘵𝘢𝘳𝘵𝘦𝘳_𝘢𝘱𝘱𝘭𝘪𝘤𝘢𝘵𝘪𝘰𝘯 patching
* Importing 𝘮𝘢𝘷𝘦𝘯 𝘵𝘢𝘬𝘢𝘳𝘪 𝘱𝘭𝘶𝘨𝘪𝘯 

Importing notes:
  * These steps are archived by invoking script 𝘪𝘮𝘱𝘰𝘳𝘵.𝘴𝘩 of project 𝘴𝘱𝘳𝘪𝘯𝘨_𝘳𝘦𝘱𝘰𝘴𝘪𝘵𝘰𝘳𝘺_𝘴𝘵𝘢𝘳𝘵𝘦𝘳_𝘭𝘪𝘣𝘳𝘢𝘳𝘺_𝘵𝘦𝘴𝘵.
  * In case of automation script 𝘪𝘮𝘱𝘰𝘳𝘵.𝘴𝘩 is failed executed because of patching. Below notes will help for manual overcoming:
    * Patching sources are located in folder 𝘱𝘢𝘵𝘤𝘩𝘦𝘴/𝘴𝘱𝘳𝘪𝘯𝘨_𝘵𝘩𝘺𝘮𝘦𝘭𝘦𝘢𝘧_𝘴𝘵𝘢𝘳𝘵𝘦𝘳_𝘢𝘱𝘱𝘭𝘪𝘤𝘢𝘵𝘪𝘰𝘯.
    * Folder 𝘱𝘢𝘵𝘤𝘩𝘦𝘴/𝘴𝘱𝘳𝘪𝘯𝘨_𝘵𝘩𝘺𝘮𝘦𝘭𝘦𝘢𝘧_𝘴𝘵𝘢𝘳𝘵𝘦𝘳_𝘢𝘱𝘱𝘭𝘪𝘤𝘢𝘵𝘪𝘰𝘯/𝘴𝘳𝘤 contains new source code files need adding to the imported project 𝘴𝘱𝘳𝘪𝘯𝘨_𝘵𝘩𝘺𝘮𝘦𝘭𝘦𝘢𝘧_𝘴𝘵𝘢𝘳𝘵𝘦𝘳_𝘢𝘱𝘱𝘭𝘪𝘤𝘢𝘵𝘪𝘰𝘯
    * File 𝘱𝘰𝘮.𝘹𝘮𝘭.𝘱𝘢𝘵𝘤𝘩 is employed to add dependency 𝘯𝘦𝘸𝘯𝘰𝘴𝘲𝘭-𝘳𝘦𝘱𝘰𝘴𝘪𝘵𝘰𝘳𝘺-𝘴𝘬𝘦𝘭𝘦𝘵𝘰𝘯  to imported project 𝘴𝘱𝘳𝘪𝘯𝘨_𝘵𝘩𝘺𝘮𝘦𝘭𝘦𝘢𝘧_𝘴𝘵𝘢𝘳𝘵𝘦𝘳_𝘢𝘱𝘱𝘭𝘪𝘤𝘢𝘵𝘪𝘰𝘯 (dependency 𝘯𝘦𝘸𝘯𝘰𝘴𝘲𝘭-𝘳𝘦𝘱𝘰𝘴𝘪𝘵𝘰𝘳𝘺-𝘴𝘬𝘦𝘭𝘦𝘵𝘰𝘯 is compiled by project 𝘴𝘱𝘳𝘪𝘯𝘨_𝘳𝘦𝘱𝘰𝘴𝘪𝘵𝘰𝘳𝘺_𝘴𝘵𝘢𝘳𝘵𝘦𝘳_𝘭𝘪𝘣𝘳𝘢𝘳𝘺).
    * File 𝘈𝘱𝘱𝘭𝘪𝘤𝘢𝘵𝘪𝘰𝘯.𝘫𝘢𝘷𝘢.𝘱𝘢𝘵𝘤𝘩 is employed to add annotation @𝘌𝘯𝘢𝘣𝘭𝘦𝘕𝘦𝘸𝘕𝘰𝘴𝘲𝘭𝘙𝘦𝘱𝘰𝘴𝘪𝘵𝘰𝘳𝘪𝘦𝘴 to enable library 𝘴𝘱𝘳𝘪𝘯𝘨_𝘳𝘦𝘱𝘰𝘴𝘪𝘵𝘰𝘳𝘺_𝘴𝘵𝘢𝘳𝘵𝘦𝘳_𝘭𝘪𝘣𝘳𝘢𝘳𝘺 in the imported project 𝘴𝘱𝘳𝘪𝘯𝘨_𝘵𝘩𝘺𝘮𝘦𝘭𝘦𝘢𝘧_𝘴𝘵𝘢𝘳𝘵𝘦𝘳_𝘢𝘱𝘱𝘭𝘪𝘤𝘢𝘵𝘪𝘰𝘯.
    * Adding details are as below:

𝘱𝘰𝘮.𝘹𝘮𝘭.𝘱𝘢𝘵𝘤𝘩
```xml
</dependencies>
  ...
  <dependency>
      <groupId>org.phamsodiep.template</groupId>
      <artifactId>newnosql-repository-skeleton</artifactId>
      <version>0.0.1-SNAPSHOT</version>
  </dependency>
</dependencies>
```

𝘈𝘱𝘱𝘭𝘪𝘤𝘢𝘵𝘪𝘰𝘯.𝘫𝘢𝘷𝘢.𝘱𝘢𝘵𝘤𝘩
```java
@SpringBootApplication
@EnableNewNosqlRepositories
public class Application {
  ...
}
```

### Build
* Launch 𝘮𝘢𝘷𝘦𝘯 𝘵𝘢𝘬𝘢𝘳𝘪 𝘱𝘭𝘶𝘨𝘪𝘯 command:
  * ./mvnw clean package

### Test
* Assuming that the cloned version is 0.0.1-𝘚𝘕𝘈𝘗𝘚𝘏𝘖𝘛, launch target generated Spring Boot application jar file 𝘵𝘩𝘺𝘮𝘦𝘭𝘦𝘢𝘧-𝘴𝘬𝘦𝘭𝘦𝘵𝘰𝘯-0.0.1-𝘚𝘕𝘈𝘗𝘚𝘏𝘖𝘛.𝘫𝘢𝘳 for testing.
  * java -jar spring_thymeleaf_starter_application/target/thymeleaf-skeleton-0.0.1-SNAPSHOT.jar

## Dependent projects
* This project needs below projects to be built:
  * 𝘴𝘱𝘳𝘪𝘯𝘨_𝘳𝘦𝘱𝘰𝘴𝘪𝘵𝘰𝘳𝘺_𝘴𝘵𝘢𝘳𝘵𝘦𝘳_𝘭𝘪𝘣𝘳𝘢𝘳𝘺
  * 𝘴𝘱𝘳𝘪𝘯𝘨_𝘵𝘩𝘺𝘮𝘦𝘭𝘦𝘢𝘧_𝘴𝘵𝘢𝘳𝘵𝘦𝘳_𝘢𝘱𝘱𝘭𝘪𝘤𝘢𝘵𝘪𝘰𝘯


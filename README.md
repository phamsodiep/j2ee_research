# Java j2ee research
## Brief description
Java j2ee skeleton projects that could be used as starter project for application development. There are some notes:
* All projects are used Maven as build tool (if it is applicable).
* All projects are developed with Java SE 8.0 and/or Java JEE 7 (EJB 3.2). Source code is encoded as Unicode.
* All projects are starter projects, more features could be added via patches in folder 𝘶𝘱𝘨𝘳𝘢𝘥𝘦. Please consult file 𝘙𝘌𝘈𝘋𝘔𝘌.𝘮𝘥 of project (if any) for detail guideline.
## Project folder structure
Project folder structure is obeyed Maven conventions.
Extension points:
* Folder 𝘥𝘰𝘤𝘴 contains document files (include tutorial guide)
* Tutorial guide (if any) is named as 𝘵𝘶𝘵𝘰𝘳𝘪𝘢𝘭.𝘵𝘹𝘵 or 𝘵𝘶𝘵𝘰𝘳𝘪𝘢𝘭.𝘩𝘵𝘮𝘭.
## Starter project list
### j2ee_starter_application
Two starter projects demonstrate how to build a simple EJB 3.2 stateless bean. They include:
* 𝘦𝘫𝘣-𝘴𝘵𝘢𝘵𝘦𝘭𝘦𝘴𝘴-𝘴𝘦𝘳𝘷𝘦𝘳: server project which is built to generate an 𝘦𝘢𝘳 package file that could be deployed on GlassFish 4.0 server.
* 𝘦𝘫𝘣-𝘴𝘵𝘢𝘵𝘦𝘭𝘦𝘴𝘴-𝘤𝘭𝘪𝘦𝘯𝘵: client project which is run with Maven exec:java goal to test the deployed stateless bean.
### j2ee_web_application_research
Containing project group related to servlets based lightweight j2ee projects (project that could be run on servlets container like Tomcat, Jetty...)
#### spring_based_web_application_research
This project group contains sub-groups or projects that apply Spring frameworks.
* 𝘴𝘱𝘳𝘪𝘯𝘨_𝘵𝘩𝘺𝘮𝘦𝘭𝘦𝘢𝘧_𝘴𝘵𝘢𝘳𝘵𝘦𝘳_𝘢𝘱𝘱𝘭𝘪𝘤𝘢𝘵𝘪𝘰𝘯: most simple Spring application project that applies Thymeleaf library. It could be used as a skeleton project to develop more.
* 𝘴𝘱𝘳𝘪𝘯𝘨_𝘳𝘦𝘱𝘰𝘴𝘪𝘵𝘰𝘳𝘺_𝘴𝘵𝘢𝘳𝘵𝘦𝘳_𝘭𝘪𝘣𝘳𝘢𝘳𝘺: most simple Spring repository project that demonstrates how @𝘌𝘯𝘢𝘣𝘭𝘦𝘑𝘱𝘢𝘙𝘦𝘱𝘰𝘴𝘪𝘵𝘰𝘳𝘪𝘦𝘴 or @𝘌𝘯𝘢𝘣𝘭𝘦𝘔𝘰𝘯𝘨𝘰𝘙𝘦𝘱𝘰𝘴𝘪𝘵𝘰𝘳𝘪𝘦𝘴 works. It could be used as a skeleton project to develop more (e.g. developing @𝘌𝘯𝘢𝘣𝘭𝘦𝘍𝘪𝘳𝘦𝘣𝘢𝘴𝘦𝘙𝘦𝘱𝘰𝘴𝘪𝘵𝘰𝘳𝘪𝘦𝘴 for Google Firebase NoSql library).


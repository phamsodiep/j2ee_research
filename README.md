# Java j2ee research
## Brief description
Java j2ee skeleton projects that could be used as starter project for application development. There are some notes:
* All projects are used Maven as build tool (if it is applicable).
* All projects are developed with Java SE 8.0 and/or Java JEE 7 (EJB 3.2). Source code is encoded as Unicode.
* All projects are starter projects, more features could be added via patches in folder 𝘶𝘱𝘨𝘳𝘢𝘥𝘦. Please consult file 𝘙𝘌𝘈𝘋𝘔𝘌.𝘵𝘹𝘵 in this folder for detail guideline.
## Project folder structure
* Project folder structure is obeyed Maven conventions.
* Extension points:
	* Folder 𝘥𝘰𝘤𝘴 houses document files (include tutorial guide)
	* Tutorial guide (if any) is named as 𝘵𝘶𝘵𝘰𝘳𝘪𝘢𝘭.𝘵𝘹𝘵 or 𝘵𝘶𝘵𝘰𝘳𝘪𝘢𝘭.𝘩𝘵𝘮𝘭.
## Starter project list
### j2ee_starter_application
* Two starter projects demonstrate how to build a simple EJB 3.2 stateless bean. They include:
	* 𝘦𝘫𝘣-𝘴𝘵𝘢𝘵𝘦𝘭𝘦𝘴𝘴-𝘴𝘦𝘳𝘷𝘦𝘳: server project which is built to generate an 𝘦𝘢𝘳 package file that could be deployed on GlassFish 4.0 server.
	* 𝘦𝘫𝘣-𝘴𝘵𝘢𝘵𝘦𝘭𝘦𝘴𝘴-𝘤𝘭𝘪𝘦𝘯𝘵: client project which is run with Maven exec:java goal to test the deployed stateless bean.



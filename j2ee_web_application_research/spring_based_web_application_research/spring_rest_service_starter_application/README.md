# Spring Rest Service Skeleton Project
## Brief description
A skeleton project to build RESTful Web Services. It implements a RESTful Web Service accessing Version resource.

### Build
* Launch 𝘮𝘢𝘷𝘦𝘯 build command:
  * mvn clean package

### Test
* Assuming that the cloned version is 0.0.1-𝘚𝘕𝘈𝘗𝘚𝘏𝘖𝘛, launch target generated Spring Boot application jar file 𝘳𝘦𝘴𝘵-𝘴𝘦𝘳𝘷𝘪𝘤𝘦-𝘴𝘬𝘦𝘭𝘦𝘵𝘰𝘯-0.0.1-𝘚𝘕𝘈𝘗𝘚𝘏𝘖𝘛.𝘫𝘢𝘳 to start web server for testing.
  * java -jar target/rest-service-skeleton-0.0.1-SNAPSHOT.jar
* Browse to below url by web browser (e.g. Firefox, Chrome) for an Http GET request to server.
  * http://localhost:8080/version

## Dependent projects
* This project is independent.

## Upgrade patches
### source_code_browser_controller
#### Brief description
Demonstration for a simple RESTfull server supporting HTTP post request.
#### Description
This patch implements a RESTful Web Service for Source Code Browser resource. It processes a source code browse request as an HTTP post request. The request information includes: file name (current edited file), file position (current cursor position).
The idea is that emacs IDE will send an HTTP post request to this RESTfull server. The server will process request, determine the definition location and send back this location to emacs via emacsclient library.
For simple demonstration, this patch implementation just accepts a request and do System.out.println.
#### Pre-build
This does import source code. Launch below command for importing:
* ./upgrade/import_scripts/import_source_code_browser.sh
#### Build
* Launch 𝘮𝘢𝘷𝘦𝘯 command:
  * mvn clean package
#### Test
* Test with emacs. Do below steps manually to add browse source code function to emacs
  * Backup your 𝘪𝘯𝘪𝘵.𝘦𝘭 file first (it may be located in ~/.𝘦𝘮𝘢𝘤𝘴.𝘥)
  * Overwrite 𝘪𝘯𝘪𝘵.𝘦𝘭 file located in 𝘶𝘱𝘨𝘳𝘢𝘥𝘦/𝘴𝘰𝘶𝘳𝘤𝘦_𝘤𝘰𝘥𝘦_𝘣𝘳𝘰𝘸𝘴𝘦𝘳_𝘤𝘰𝘯𝘵𝘳𝘰𝘭𝘭𝘦𝘳 to ~/.𝘦𝘮𝘢𝘤𝘴.𝘥/𝘪𝘯𝘪𝘵.𝘦𝘭
  * Open a file with emacs, put cursor at a method and press M-. to browse source code.
  * Browse source request source will be traced on Server console log similarly to below one:
    * Emacs request update browser target to /home/phamsodiep/emacs/hi-cloud-project/Main.java@23
* Test with python script
    * Run file 𝘵𝘦𝘴𝘵_𝘴𝘰𝘶𝘳𝘤𝘦_𝘤𝘰𝘥𝘦_𝘣𝘳𝘰𝘸𝘴𝘦𝘳.𝘱𝘺 as below example:
      * ./𝘵𝘦𝘴𝘵_𝘴𝘰𝘶𝘳𝘤𝘦_𝘤𝘰𝘥𝘦_𝘣𝘳𝘰𝘸𝘴𝘦𝘳.𝘱𝘺 /𝘩𝘰𝘮𝘦/𝘱𝘩𝘢𝘮𝘴𝘰𝘥𝘪𝘦𝘱/𝘦𝘮𝘢𝘤𝘴/𝘩𝘪-𝘤𝘭𝘰𝘶𝘥-𝘱𝘳𝘰𝘫𝘦𝘤𝘵/𝘔𝘢𝘪𝘯.𝘫𝘢𝘷𝘢 23

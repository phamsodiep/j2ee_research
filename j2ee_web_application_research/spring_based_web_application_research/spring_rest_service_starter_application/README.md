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
#### Version 00
#### Brief description
Demonstration for a simple RESTfull server supporting HTTP post request.
#### Description
This patch implements a RESTful Web Service for Source Code Browser resource. It processes a source code browse request as an HTTP post request. The request information includes: file name (current edited file), file position (current cursor position).
The idea is that Emacs IDE will send an HTTP post request to this RESTfull server. The server will process request, determine the definition location and send back this location to Emacs via Emacsclient library.
For simple demonstration, this patch implementation just accepts a request and do System.out.println.
#### Pre-build
This does import source code. Launch below command for importing:
* ./upgrade/import_scripts/import_source_code_browser.sh
#### Build
* Launch 𝘮𝘢𝘷𝘦𝘯 command:
  * mvn clean package
#### Test
* Start RESTfull server first. Assuming that target version is 0.0.1-SNAPSHOT, launch below command to start server:
    * java -jar target/rest-service-skeleton-0.0.1-SNAPSHOT.jar
* Test with Emacs. Do below steps manually to add browse source code function to Emacs
  * Backup your 𝘪𝘯𝘪𝘵.𝘦𝘭 file first (it may be located in ~/.𝘦𝘮𝘢𝘤𝘴.𝘥)
  * Overwrite 𝘪𝘯𝘪𝘵.𝘦𝘭 file located in 𝘶𝘱𝘨𝘳𝘢𝘥𝘦/𝘴𝘰𝘶𝘳𝘤𝘦_𝘤𝘰𝘥𝘦_𝘣𝘳𝘰𝘸𝘴𝘦𝘳_𝘤𝘰𝘯𝘵𝘳𝘰𝘭𝘭𝘦𝘳/00 to ~/.𝘦𝘮𝘢𝘤𝘴.𝘥/𝘪𝘯𝘪𝘵.𝘦𝘭
  * Open a file with Emacs, put cursor at a method and press M-. to browse source code.
  * Browse source request source will be traced on Server console log similarly to below one:
    * Emacs requests update browser target to:
      * File: untitled.java
      * Position: 2048
* Test with python script
    * Run file 𝘣𝘳𝘰𝘸𝘴𝘦_𝘴𝘰𝘶𝘳𝘤𝘦_𝘤𝘰𝘥𝘦.𝘱𝘺 as below example:
      * ./browse_source_code.py /home/phamsodiep/emacs/hi-cloud-project/Main.java 23
#### Version 01
#### Brief description
Demonstration for accessing application scope variable (ServletContext).
#### Description
This patch extends version 00 patch. It processes a configuration setting request. The setting request information includes: host, port and authorization key.
The idea is that Emacs IDE will send configuration setting request to this RESTfull server only one time while it is being opened. The server will persist this information for future communication back to Emacs via Emacsclient library.
#### Pre-build
This does import source code. Launch below command for importing:
* ./upgrade/import_scripts/import_source_code_browser_with_config.sh
#### Build
* Launch 𝘮𝘢𝘷𝘦𝘯 command:
  * mvn clean package
#### Test
* Start RESTfull server first. Assuming that target version is 0.0.1-SNAPSHOT, launch below command to start server:
    * java -jar target/rest-service-skeleton-0.0.1-SNAPSHOT.jar
* Test with python script
    * Run file 𝘤𝘰𝘯𝘧𝘪𝘨_𝘴𝘰𝘶𝘳𝘤𝘦_𝘤𝘰𝘥𝘦_𝘣𝘳𝘰𝘸𝘴𝘦𝘳.𝘱𝘺 as below example:
      * ./config_source_code_browser.py
* Server should trace as below:
  * Previous configuration:
	  * Host: 
	  * Port: 8888
	  * Key: 
  * Emacs requests configuration update:
	  * Host: sjc.local
	  * Port: 9999
	  * Key: banananananananananananana
* There are some notes:
  * The 𝘗𝘳𝘦𝘷𝘪𝘰𝘶𝘴 𝘤𝘰𝘯𝘧𝘪𝘨𝘶𝘳𝘢𝘵𝘪𝘰𝘯 information is initial value which is assigned by Constructor of class Configuration.
  * The 𝘌𝘮𝘢𝘤𝘴 𝘳𝘦𝘲𝘶𝘦𝘴𝘵𝘴 𝘤𝘰𝘯𝘧𝘪𝘨𝘶𝘳𝘢𝘵𝘪𝘰𝘯 𝘶𝘱𝘥𝘢𝘵𝘦 information is the setting request information sent by script 𝘤𝘰𝘯𝘧𝘪𝘨_𝘴𝘰𝘶𝘳𝘤𝘦_𝘤𝘰𝘥𝘦_𝘣𝘳𝘰𝘸𝘴𝘦𝘳.𝘱𝘺.
* Test with Emacs. Do below steps manually to program Emacs sends configuration setting request to RESTfull server for each time it is being opened.
  * Backup your 𝘪𝘯𝘪𝘵.𝘦𝘭 file first (it may be located in ~/.𝘦𝘮𝘢𝘤𝘴.𝘥)
  * Overwrite 𝘪𝘯𝘪𝘵.𝘦𝘭 file located in 𝘶𝘱𝘨𝘳𝘢𝘥𝘦/𝘴𝘰𝘶𝘳𝘤𝘦_𝘤𝘰𝘥𝘦_𝘣𝘳𝘰𝘸𝘴𝘦𝘳_𝘤𝘰𝘯𝘵𝘳𝘰𝘭𝘭𝘦𝘳/01 to ~/.𝘦𝘮𝘢𝘤𝘴.𝘥/𝘪𝘯𝘪𝘵.𝘦𝘭
  * Launch Emacs (This results in configuration setting request is sent to RESTfull server while 𝘪𝘯𝘪𝘵.𝘦𝘭 is being processed).
  * Server should trace as below:
    * Previous configuration:
	    * Host: sjc.local
	    * Port: 9999
	    * Key: banananananananananananana
    * Emacs requests configuration update:
	    * Host: 127.0.0.1
	    * Port: 1024
	    * Key: tTJ#\b5D2.4=GN>n"*g-9)AH2-bM;H]&h4@K3k>(/+XYDi*UnIS3C_vXgz~[GJqj
* There are some notes:
  * The 𝘗𝘳𝘦𝘷𝘪𝘰𝘶𝘴 𝘤𝘰𝘯𝘧𝘪𝘨𝘶𝘳𝘢𝘵𝘪𝘰𝘯 information is the setting request information sent by script 𝘤𝘰𝘯𝘧𝘪𝘨_𝘴𝘰𝘶𝘳𝘤𝘦_𝘤𝘰𝘥𝘦_𝘣𝘳𝘰𝘸𝘴𝘦𝘳.𝘱𝘺.
  * The 𝘌𝘮𝘢𝘤𝘴 𝘳𝘦𝘲𝘶𝘦𝘴𝘵𝘴 𝘤𝘰𝘯𝘧𝘪𝘨𝘶𝘳𝘢𝘵𝘪𝘰𝘯 𝘶𝘱𝘥𝘢𝘵𝘦 information is the setting request information sent by Emacs. Your one may be different with the this demonstration guideline.


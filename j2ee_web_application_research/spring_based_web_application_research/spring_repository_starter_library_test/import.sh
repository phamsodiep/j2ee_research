#!/bin/bash
echo " "
echo " "

echo "Copying project folder 'spring_thymeleaf_starter_application'..."
cp -r ../spring_thymeleaf_starter_application .

echo " "
echo "Add dependency 'newnosql-repository-skeleton' to project 'spring_thymeleaf_starter_application'"
cd spring_thymeleaf_starter_application
patch < ../patches/spring_thymeleaf_starter_application/pom.xml.patch

echo " "
echo "Add '@EnableNewNosqlRepositories' to CustomerApplication.java of project 'spring_thymeleaf_starter_application'"
patch -d src/main/java/org/phamsodiep/template/webapp < ../patches/spring_thymeleaf_starter_application/CustomerApplication.java.patch

echo " "
echo "Add test source files to project 'spring_thymeleaf_starter_application'"
#tar -xpzf ../patches/spring_thymeleaf_starter_application/src.tgz
cp -r ../patches/spring_thymeleaf_starter_application/src .

echo " "
echo "Install maven takari plugin"
cd ..
mvn io.takari:maven:wrapper

echo " "
echo " "


#!/bin/sh

# enter plugin directory
cd ./tutorial || exit

# compile project
mvn compile
# build package
mvn clean package
cd ..

# make directory for plugins if it doesn't exist
mkdir -p ./server/plugins

# move target jar into plugin folder
mv ./tutorial/target/TutorialPlugin-1.0.jar ./server/plugins/
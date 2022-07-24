#!/bin/sh

# enter plugin directory
cd ./tutorial || exit

# compile project
mvn compile || exit
# build package
mvn clean package || exit
cd ..

# make directory for plugins if it doesn't exist
mkdir -p ./server/plugins/

# move target jar into plugin folder
mv ./tutorial/target/Tutorial-1.0.jar ./server/plugins/
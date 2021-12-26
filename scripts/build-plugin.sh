#!/bin/sh
cd ./tutorial || exit

mvn compile

mvn clean package

cd ..

mv ./tutorial/target/TutorialPlugin-1.0.jar ./server/plugins/
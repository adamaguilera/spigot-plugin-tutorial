#!/bin/sh

cd ./server || exit

(java -Xmx1024M -Xms1024M -jar spigot-latest.jar nogui)


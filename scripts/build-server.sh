#!/bin/sh

# some of this uses benz56's script found here
# https://www.spigotmc.org/threads/buildtools-script-download-spigot-with-the-click-of-a-button.458205/

# this is the name of the temporary directory to build spigot
dir=build-tools

# remove previous download folder if present, remove old latest.jar
# as well as create build-tools folder
# Removes any files starting with 'spigot' as well as the download folder.
rm -rf $dir && rm -f ./server/latest.jar && mkdir $dir
cd $dir || exit

# Download latest BuildTools, ask for the Spigot version (latest), and run BuildTools.
curl -z BuildTools.jar -o BuildTools.jar https://hub.spigotmc.org/jenkins/job/BuildTools/lastSuccessfulBuild/artifact/target/BuildTools.jar
java -jar BuildTools.jar --rev ${version:-latest}

# rename spigot-{version} into spigot-latest
for f in spigot-*.jar; do mv -v "$f" "${f/-*.jar/-latest.jar}"; done;

# Move the downloaded artifact out of the temp folder and remove the folder.
cd ..
mv $dir/spigot-latest.jar ./server/
rm -rf $dir
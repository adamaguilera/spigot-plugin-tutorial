# spigot-plugin-tutorial

# Prerequisites
- Latest Java Development Kit
- [Apache Maven](https://maven.apache.org/download.cgi) for building the plugin
- Git Bash if you are on Windows

# Tutorial
## 1. Creating a Spigot Server
- Open your terminal and change your directory to /spigot-plugin-tutorial
- Run build server script `sh ./scripts/build-server.sh`

## 2. Compile your plugin
- Run build plugin script `sh ./scripts/build-plugin.sh`

## 3. Start your server
- Run start server script `sh ./scripts/start-server.sh`

## 4. Test some commands!
- There are demo commands added to display different concepts, try using the following:
```
/helloworld
    Prints "Hello World!" to the player
/config
    Prints data stored in the config
```

## Trouble Updating Java?
- On macOS you can run `brew install java` for the latest openJDK
- Otherwise check [Oracle's webpage](https://www.oracle.com/java/technologies/downloads/) for downloads

# Purpose of this tutorial
> I've started so many plugin ideas in Minecraft and the most difficult part is setting up the project.
> Whether it is configuring the pom.xml files to setting up the project structure, it is annoying at takes a lot of time.
> This repository contains a list of scripts that easily allow you to start a plugin idea without having to look up tutorials
> Another perk of this tutorial is that it doesn't require IntelliJ or Eclipse to build your plugin, a crutch I relied upon for far too long.
> The number of times I configured artifacts and configurations in IDEA turned out to be one too many lol and here we are.
> I also added some utility functions to make plugin development easier

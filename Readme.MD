# termnote

<p>
    This app is created to take notes on terminal. If your job is managing servers,
    and spending most of your time on the terminal, I think you will like it!
</p>
<p>
This app is tested to run on java11 and java18, if you are using another version
of java please make sure to check the compatibility to not run into any issues.
</p>

## Install
<p>
Just clone the repository to your system. An executable jar is included with the project,
so you can choose only to run that, if you make any changes to the app, please make sure
to recompile the .jar file.

## How to create the jar file?
If you are using IntelliJ or any other IDE it can do it for you. If not, just use maven commands. MANIFEST.MF
is provided under the src/main/resources/META-INF for your convenience.

## How to use the app

The intended usecase of the app is to use it as a command tool. So add 
```
java -jar <$path_the_project_from_the_home_directory>/out/artifacts/termnote_jar/termnote.jar
```
to your .zshrc or .bashrc file as an alias, and use the app from any directory you are
with the alias!
</p>

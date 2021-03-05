# Jotter: to do list app
Welcome to Jotter, a simple to do list app that you can run from the command line.
The app is a work in progress, so functionality is limited just now (5 March 2021).

## Getting started
Jotter can be run directly via Gradle or via a generated jar file.

### Run with Gradle
In the root folder, start Jotter with the following command:
```bash
gradle run --console plain
```
### Run with jar file
Generate the jar file with Gradle's build command.
```bash
gradle build
```
The jar file will be generated in `build/libs`. Run it using the command:
```bash
java -jar build/libs/to-do-list-app-1.0-SNAPSHOT.jar
```

## Using this app
At the moment, the app just prints a welcome screen with the main options.
In future releases, you will be able to:

### View task list
View the task list and sort by title or project.

### Add tasks
Add tasks and give them a title, due date and a project that it belongs to.

1: Start screenshot to be added

### Edit tasks
Edit tasks, mark tasks as done or remove tasks.

2: Edit task screenshot to be added

### Save and quit task list
Save the current task list and restart the app with the task list restored.

## Authors and acknowledgments
Thank you to the staff and teaching assistants of SDA for sharing their knowledge. Thanks also to David J Barnes and Michel Kölling, authors of 'Objects First with Java' for providing code inspiration in the World of Zuul, Tech Support and Address Book projects.

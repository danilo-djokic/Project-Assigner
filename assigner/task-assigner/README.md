
# Description

Goal of the application is to provide a way for project managers to describe and assign tasks to developers in a project.

# Use cases

## Creating a project

Logged in project manager should be able to create a project by defining its name and brief description.

After creation, project should be available in the list of active projects to the logged in project manager. Project manager can only see projects that he created.

## Creating tasks

Clicking on a specific project in the list. Loggedin project manager can create a task under that specific project. Task should contain the text of the task, status(in progress, completed), and developer that the task has been assigned to. Developer is chosen from the drop down menu of list of all developers.

> Nice to have: only developers that dont have "in progress tasks" are available to the project manager.

After creation, the task should be available in the list of active tasks under the project screen.

## Developer task view

Note: it is okay for users(developers,project managers) to be added manually in the database without creating a proper frontend interface.

Logged in developer should see a list tasks that he's been assigned to.

Clicking on the task. Developer should see the text of the task, creation date, and a dropdown having the status of the task.

Choosing a status and clicking "update" developer should be returned to the login screen and the task, if he chose "completed" should no longed be in the list of active tasks. 

> Nice to have: different tabs(or pages) showing tasks with different statuses.

# Architecture constraints

Project should be built as a MVC project leveraging Spring MVC. 

# Technology constraints

Frontend:

HTML5/CSS3, Thymeleaf

> Nice to have: Bootstrap or any other CSS library.

Backend:

Spring Boot 2.6+, Java 11+, MariaDB 10.3+

> Nice to have: flyway migration for managing the database schema. Unit tests (JUnit5).

Other:

Spring security with appropriate roles is a must.

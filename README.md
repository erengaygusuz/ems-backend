# EMS - Backend (Employee Management System Demo)

![Alt text](/screenshots/1-ems.png)

## Project Description

* The general purpose of the project is to create, update, delete and view the information of employees in a company on the web.

* This repo contains the backend module of the project.

* You can try the live version of the back end module at the following address:
* Link: api-ems.erengaygusuz.com.tr/api/employees

## Project Architecture

* There are 3 layers in the application part of the project. These are:

  - PresentationLayer (FrontEndApp)
  - DataAccessLayer (BackEndApp)
  - DatabaseLayer (Database)

* Additionally, the general architectural diagram of the project is shown in the image below:

![Alt text](/screenshots/ems-architecture.png)

## General Technical Features of this Module

* Using Best Practices such as Splitting Module to Packages like Mapping, Repositories, Services, Dtos, Controllers
* Dockerizing Module and Pushing to Docker Hub
* Running Docker Image as a Container at AWS EC2 Virtual Machine
* Adding Custom Domain to Backend App
* Adding SSL Certificate to Domain with AWS ACM

## Tools and Technologies Used in this Module

The list of all packages and tools used in this module is provided below, along with their version.

* Java 17
* Java Spring Boot Framework 3.2.3
* Lombok
* Maven
* Docker
* Docker Hub
* AWS EC2
* AWS ALB
* AWS ACM
* Natro Domain
* Natro MySQL Database

## Module Usage

* Be sure that IntelliJ IDEA Community Edition 2023 is installed in your PC.
* Clone the module using this command: ``` git clone https://github.com/erengaygusuz/ems-backend.git ```
* Run the module with IntelliJ IDEA Community Edition 2023

## License

The MIT License (MIT)

## Screenshots

![Alt text](/screenshots/1-ems.png)

![Alt text](/screenshots/2-ems.png)

![Alt text](/screenshots/3-ems.png)

![Alt text](/screenshots/4-ems.png)

![Alt text](/screenshots/5-ems.png)

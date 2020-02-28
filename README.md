# Alten Vehicles Monitoring
![](https://github.com/AlirezaTabasi/alten-vehicles-monitoring/blob/master/Image/screenshot-1.jpg)
![](https://github.com/AlirezaTabasi/alten-vehicles-monitoring/blob/master/Image/screenshot-2.jpg)
![](https://github.com/AlirezaTabasi/alten-vehicles-monitoring/blob/master/Image/screenshot-3.jpg)
# Scenario:
Imagine you are an Alten consultant and you got assigned to a project at one of our top partners.
They have a number of connected vehicles that belongs to a number of customers.
They have a need to be able to view the status of the connection among these vehicles on a monitoring display.

The vehicles send the status of the connection one time per minute.
The status can be compared with a ping (network trace); no request from the vehicle means no connection.

# Task:
Your task will be to create a data store that keeps these vehicles with their status and the customers who own them, as well as a GUI (preferably web-based) that displays the status.
How the GUI is designed is up to you, as well as how you chose to implement the features and use suitable technologies.

Obviously, for this task, there are no real vehicles available that can respond to your "ping" request.
This can either be solved by using static values or ​​by creating a separate machinery that returns random fake status.

# Requirements
1. Web GUI (Single Page Application Framework/Platform).
 - An overview of all vehicles should be visible on one page (full-screen display), together with their status.
 - It should be able to filter, to only show vehicles for a specific customer.
 - It should be able to filter, to only show vehicles that have a specific status.
2. Random simulation to vehicles status sending.
3. If database design will consume a lot of time, use data in-memory representation.
4. Unit Testing.
5. .NET Core, Java or any native language.
6. Complete analysis for the problem.
 - Full architectural sketch to solution.
 - Analysis behind the solution design, technologies,....
 - How the solution will make use of cloud.
 - Deployment steps.

# Optional Requirements
1. Write an integration tests.
2. Write an automation test.
3. Use CI(Travis, Circle, TeamCity...) to verify your code (Static analysis,..) and tests.
4. Dockerize the whole solution.
5. Microservices architecture for driver, vehicle and FaaS APIs.
 - Use any Microservices Chassis Framework.
6. Explain if it is possible to be in Serverless architecture and how?

# Data:
Below you have all customers from the system; their addresses and the vehicles they own.

**Customer name:** Kalles Grustransporter AB

**Customer address:** Cementvägen 8, 111 11 Södertälje

| **VIN (VehicleId)**    |   **Reg. nr.**     |
|--------------------|----------------|
| YS2R4X20005399401  |   ABC123       |
| VLUR4X20009093588  |   DEF456       |
| VLUR4X20009048066  |  GHI789        |

**Customer name:** Johans Bulk AB

**Customer address:** Balkvägen 12, 222 22 Stockholm

| **VIN (VehicleId)**    |   **Reg. nr.**     |
|--------------------|----------------|
| YS2R4X20005388011  |   JKL012       |
| YS2R4X20005387949  |   MNO345       |

**Customer name:** Haralds Värdetransporter AB

**Customer address:** Budgetvägen 1, 333 33 Uppsala

| **VIN (VehicleId)**    |   **Reg. nr.**     |
|--------------------|----------------|
| YS2R4X20005387765  |   PQR678       |
| YS2R4X20005387055  |   STU901       |

# Solution Architecture
# Architecture 

Since the business of the project is highly dynamic. And scaling is important. So I recommend that the application will be cloud compliant. The selection for architecture here will be a Microservice Architecture. And as the load on the application endpoints is not similar. For scaling the project only we can scale some high loaded microservice instead of scaling whole the project.
![](https://github.com/AlirezaTabasi/alten-vehicles-monitoring/blob/master/Image/architecture.jpg)
# Technologies
The related technologies for mentioned Architecture.
![](https://github.com/AlirezaTabasi/alten-vehicles-monitoring/blob/master/Image/technologies.jpg)

The technologies used in the implementation of the project are:

**gateway**: build over Zuul to load balance and hide the service complexity.

**service registry**: build over Eureka to keep registry with the service instances, also used by the gateway to load balance.

**customer**: Spring boot, h2-database.

**vehicle**: Spring boot, h2-database.

**ui**: Spring boot, Thymeleaf.
# Deployment
First of all you need to build the below projects.
1.Registry
 |cd service-registry|
 |mvn package        |
# Production URL
 The live version of the app http://

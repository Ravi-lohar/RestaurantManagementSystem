<div align = "center">
  <h1> Restaurant Management System</h1>
 </div>

## Framework and Language
* Java 
* SpringBoot

## Dependencies
  * SpringWeb
  * Lombok
  * Swagger
  * JPA
  * My SQL Server
  * Validation
    
## Database Used 
  * Sql

    
## Data flow
  **The project has four main packages which are following** 
  
* Controller - Controller package has all the api and Crud operations.
* Services - Service class has all the business logic and it will return the result of that method which is called by controller class . 
* Repository - Respository has all the datasource in it i uses SQL Database
* Model - Model class has model User , Admin , FoodItem and order 
> The flow of data is from controller has all the api and logics of that api has in service class and
service class is using the repository class which has all the data it keeps data source.The api called by user call the controller method
return the logic which is written in service class so service class object is called and service class use data source of repo class.

## Project Summary 
This is a Restaurant Mangement System which has user, admin and visitor with some rights . Admin has control over the application admin can create foodItems by signin into admin account . 
This project has functionality of sign in , sign up . User and Admin both can sign in and signup . User can only place order while he has signed in account while vistor who has not signed in can not place orders .
every time it authenticate respect to functionality . Following operation can be performed 
* Admin SignUp
* Admin SignIn
* Admin an Create FoodItem 
* Admin SignOut
* Admin Can be Deleted 
* User SignUp
* User SignIn
* User can place order during SignIn 
* User SignOut
* User Can Be Deleted
* Visitors can see FoodItems

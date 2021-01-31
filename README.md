# search-engine-be

This is backend application for 'Search-engine-acoustic' created on SpringBoot with Jdk 15.

The search works for Item by ItemName with pagination feature.
Item -> {id , %itemName%, relatedContent}

To get this application running. Please install maven and run below command.

`mvn clean spring-boot:run`
or simply run 
`SearchEngineBeApplication.main()`

The application creates in memory h2 database and runs on default port 8080
To configure more properties use application.properties file
# Fraud Detection using Flink

## Pre-requisites
1. Java 8 or higher. (This project was compiled and executed using Java 23)
2. Apache Maven (This project was compiled using Maven 3.9.9)

## How to run
1. Clone the repository
2. Allow the IDE to read and compile the project. Once done, open the `DetailedFraudDetectionJob`, and run it as a Java application.
   > The run config are available in the run folder. When running in IntelliJ, it automatically recognizes the run configurations.
   
   > Running the project in an IDE may result in a java.lang.NoClassDefFoundError exception.
   > This is probably because you do not have all required Flink dependencies implicitly loaded into the classpath.
      IntelliJ IDEA: Go to Run > Edit Configurations > Modify options > Select include dependencies with "Provided" scope. 
      This run configuration will now include all required classes to run the application from within the IDE.

## Important Note
This project also contains the code for the walk-through file. Should you want to run that, run the `FraudDetectionJob` instead.
However, you will have to update the `log4j.properties` and `pom.xml` file to have the correct alert sink and main class.

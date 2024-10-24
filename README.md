# Fraud Detection using Flink

## Pre-requisites
1. Java (This project was compiled and executed using Java 23)
2. Apache Maven (This project was compiled using Maven 3.9.9)

## How to run
1. Clone the repository
2. Open the `DetailedFraudDetectionJob` under the spendreport.detailed package, and run it.
   > The run config are available in the runConfigurations folder.
   
   > Running the project in an IDE may result in a java.lang.NoClassDefFoundError exception.
   > This is probably because you do not have all required Flink dependencies implicitly loaded into the classpath.
    > * IntelliJ IDEA: Go to Run > Edit Configurations > Modify options > Select include dependencies with "Provided" scope.

   > If you see an error higher Java versions: java.lang.RuntimeException: java.lang.reflect.InaccessibleObjectException: Unable to make field private final java.lang.Object[] 
                           java.util.Arrays$ArrayList.a accessible: module java.base does not "opens java.util" to unnamed module
   > This typically arises in Java 9 and later versions due to the Java Platform Module System (JPMS)
   > * IntelliJ IDEA: Go to Run > Edit Configurations > Modify options > Select Add VM Options > Add `--add-opens=java.base/java.util=ALL-UNNAMED` to VM options field.

## Important Note
This project also contains the code for the walk-through file. Should you want to run that, run the `FraudDetectionJob` instead.
However, you will have to update the `log4j.properties` and `pom.xml` file to have the correct alert sink and main class.
# Homework 1 - Responding to Change

## Authors
1) Eric Sheetz, fsm6wv, [RelinquentZebra]
2) Dor Frechter, huz4kk, [dorfrechter]
3) Christina Yang, gca9aa, [cayang17]

## To Run

[Firstly,open the terminal and use the "./gradlew build" command to build your jar file. It will be in your libs folder within the build folder. 
To run the file use the command java -jar and then specify the filepath to the jar file followed by the path to the desired csv file. Another
option is to use the cd command until you reach the folder where the jar and/or csv file is and then just write the names of hte files. An
example of a command line code is "java -jar Apportionment.jar example_input.csv". Running this command will print an alphabetically sorted list
of all the states in the file and the # of representatives allocated to each one of them.]

## Contributions
List the primary contributions of each author. It is recommended to update this with your contributions after each coding session.:

### [Eric Sheetz]

* Wrote checkNumReps function
* Helped with ListToHashMap and ListMaker functions
* Data Reading Testing

### [Dor Frechter]

* Wrote JeffersonApportionment class
* Wrote the methods dealing with making a hashmap of the states
* wrote methods to get the number of representatives using binary search and hashmaps.
* Tested with several csv files
* Formatted output for part 2
* Changed the functions, so they look for index of state and population column and iterate based on index
* Handeled excel file reading

### [Christina Yang]

* Wrote the JUnit tests in JeffersonApportionmentTest and DataReadingTest class
* Helped write error messages for certain edge cases
* Tested with csv and excel files in terminal
* Tested with csv and excel files using resources folder in IntelliJ


## Issues
List any known issues (bugs, incorrect behavior, etc.) at the time of submission.
It's perfect (I think)
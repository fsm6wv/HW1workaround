# Reflection Questions

Answer these questions thoroughly, using examples from your code. Good answers will be 1-2 paragraphs that cite specific code examples and show a meaningful reflection on how your development went, and how it could be improved in the future.

## Question 1

In part 2, you now have to support two different inputs, CSV and XLSX. Imagine we asked you to also support reading in another file format, such as JSON. How much code would you need to add/change to enable this? Cite specific existing functions/classes that would need to change.


[Not much. The only changes I would have to make are in the data reading class and in the way the code is outputted on main.
 When we were tasked with making an excel file the only changes I had to make were adding the apache POI dependencies and then
write functions that behave exactly like the csv input but rather for the excel input. Hence, in the DataReading class you
can find several methods with their excel vs csv implementation (e.g. csvFileToHashmap vs excelFileToHashmap) Adding a new type of input would simply mean changing how main decides what to output(with a method similar to isCSV) and 
writing very similar functions to the existing ones that deal with parsing data and formatting it in the DataReading class.
Overall, I do think there is a way narrow it down to one method that will be able to give the same output of an Arraylist containing
the data and it would know how to operate regardless of the file type, so in the future I would like the code to be more efficient in that sense.
additionally, I hope to develop in a more neat way. For instance, splitting the DataReading class to an excel reader and csv reader class.
all these things could make the code much more readable and easier to build on from.]

## Question 2

Looking back, which part was more difficult? Part 1, where you had to start from scratch, or Part 2, where you had to change existing code. Explain your answer, citing any specific challenges. In hindsight, would you do anything differently?
 

[Part one was definitely harder, as we had to figure how every aspect of this program should operate, what are the efficient
ways to do things, and how to manage work within a group. In part 2 we already knew what all the functions were doing,
understood the task in a deeper sense initially compare to part 1, and were immediately ready to work. We only had to reimplement
a few methods based on existing code, while some classes and methods were not changed (JeffersonApportionment). The main point is that
building on from previous work is easier than building everything from scratch. For that reason, it is important we maintain
organized code that is understandable, so we can work from it in the future. Not to say that this assignment was written in a neat
way, but I am sure if it was all written as one program in main it would have been a lot harder to implement part 2. Thanks to its
(somewhat) organized structure, it was not too difficult complete part 2. The only thing I would have done differently is make
the code even more organized and understandable, so the implementation of part 2 would be even more simple]


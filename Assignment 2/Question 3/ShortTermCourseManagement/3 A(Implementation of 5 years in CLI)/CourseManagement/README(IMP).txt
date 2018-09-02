Author:Ashrujit Ghoshal
Roll Number:14CS10060
Assignment 2:Problem 3: Short Term Course Management Software.This was created in eclipse
.java files are in STCM in src folder.This just extends the implementation of q1 of assignment 1 to 5 years
This is a Short Term Course Management Software(in the package STCM) that runs on the console.
It is entirely menu driven.

It contains 5 classes:

1.CourseManagement(This contains the main method) 

2.Person

3.Faculty(Derived class from Person)

4.Participant(Derived class from Person)

5.Course


A few notes about the program:

1.to display courses more than 5 year old we have select display all courses.
(Total of MAXCOURSES no of courses are allowed.10 max in 1 year)
2.A note on modification of faculty details and participant details:
First the user is asked for course index in the 
displayed list.Then as per the case he is asked to choose the faculty or participant to be modified.In the modification
 section,
for every field the user  is given the option to retain the  previous data.(In order to modify he needs to
 press 1) 
3.A note on modification of course details:
 Only the name,start date,fees,duration,course co-ordinator can be
 modified in course modification.(I have commented out the part modifying instructors and students as tht can be done
 
 seperately too to avoid confusion)
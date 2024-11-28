JustInvestSystem
-----------------

Description:
--------------

This project contains 5 java classes, 2.txt file, and 1 ReadMe.txt file.

The Project is made up of the following files:

AccessControl.java              A single Java script
Roles.java                      A single Java script
JustInvestSystem.java           A single Java script
Main.java                       A single Java script
PasswordGenerator.java          A single Java script

Usage:
----------------
>AccessControl.java: This class is responsible for Access control of the system, where each
User has a pre-defined role. This class covers Problem 1.
> JustInvestSystem.java: This class is responsible for the signUp/Login functionality of the system, where
it writes the usernames, passwords, and roles of the users in passwd.txt. This covers Problem 3 and Problem 4.
> Main.java: This class is responsible for combining all the other classes and handling the interface.
> PasswordGenerator.java: This class is responsible for generating a random salt for each password and then hashing it using
SHA-256 algorithm. This covers Problem 2.
> Roles.java: This class is responsible for The roles of each User.


>To test Teller Login system, Please enter time in 12h format. (no minutes included)
> 
Steps:
------
To be able to run the program on the VM:

Navigate to src of the project
>Step 1: cd src

To compile the Main file:
>Step 2: javac Main.java

To run Main:
>Step 3: java Main


Copyright 2024 Jalal Mourad

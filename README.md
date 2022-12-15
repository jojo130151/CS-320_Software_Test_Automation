# CS-320_Software_Test_Automation
Repository for CS-320 Software Test Automation &amp; QA course.

How can I ensure that my code, program, or software is functional and secure?

- To test my program for functionality, security, weird input, fringe input, and random null values put in, JUnit test are ideal to run the program under specific conditions. Input can be tested, branches can be explored for all possibilities, and the program can be run many times. For security, I would make sure that, aside from the tests, that the code itself had checks, like if statements and Exceptions throws. This will stop the program from processing that bad input and data.


How do I interpret user needs and incorporate them into a program?

- The client or user are at the core of the program and their specifications are important. If they need a function to run in a specific way, then it is the responsibility of the programmer to create the function in that specific manner. For example, the customer for this project needed a storage variable for phone numbers but the phone number had to be only numbers, only digits, and couldn't be null. I set the constructor to check for these invalid phone numbers and throw and exception if they were found. Then, I implemented JUnit tests to make sure the check would succeed in stopping the invalid phone number. I was informed of the customers needs and made sure that their specifications were present in the program.


How do I approach designing software?

- I start with the obect classes and set the constructor, getters, and setters. I then switch to working on the classes that use these objects for their functions. If during the work on these classes, I need to work on the object classes and tweak them then I'll go back. I just like setting the building foundational blocks first. It also helps when coding the function classes that the object that it is using is already in place so that errors are more clear by not being constantly thrown by the lack of an established object class.


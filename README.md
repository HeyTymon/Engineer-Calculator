# A calculator that allows for converting decimal numbers to numbers in InQk codes.

The program includes:

1) Login panel
   - To log into the calculator, the user must provide a login and password, which are stored in the data.txt file.
     The data is arranged in the order of login, followed by password (then the data of subsequent users).
   - The program compares the login data provided, and if they are incorrect, it returns an error. If the data is correct,
     the user is directed to the next panel.

2) Calculator panel
   - The calculator panel contains several informational fields in which the user sets the code they want to work on:<br>
      a) Qn Field - the value of Q, or how many bits (up to 15) the user wants to allocate for the fractional part.<br>
      b) U2 CheckBox - when selected, it enables the use of U2 code for negative numbers.<br>
      c) HEX - the user sets whether they want to convert from decimal to InQk code or vice versa.<br>
   - Below are three buttons:<br>
      a) Calculate Button - performs the conversion calculation.<br>
      b) Save Button - enables the user to save the calculated value to the values.txt file.<br>
      c) Create new user Button - enables the addition of a new user if the current user is logged in as an administrator (admin, admin1).<br>
      
3) New user addition panel
   - If the user is logged in as an administrator, this panel allows the addition of a new user. The login and password are saved
     to the data.txt file.

Conditions for the program to function correctly:
   - Decimal fractions should be written according to the american notation using "." as a separator.

Program expansion possibilities:
   - Creation of password creation conditions (requiring 1 lowercase letter, 1 uppercase letter, etc.).

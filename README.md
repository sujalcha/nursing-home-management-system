# nursing-home-management-system

A Java windowed application for a nursing home management system.
The program allows the user to read the resident name, age, and health condition description from a text file (ResidentData.txt), save data to the same file, display data in a text area, sort data by the resident name, search data by the resident name, add a record and delete an entry.

How the program works

There are four menus (File, Tools, Help and Exit). The File menu contains 2 items (Read and
Save), the Tools menu has 5 items (List, Add, Delete, Sort and Search), the Help menu has 1
item (Details) and the Exit menu has 1 item (Exit). The menu items are described below.
File→Read: Reads the data from the file ResidentData.txt (see format of this file below) and
stores the data in a Linked List or an ArrayList. The application must use appropriate
exception handling to deal with problems during the file opening (e.g. what to do if file
doesn’t exist).

The file contains a series of records, each record with the resident name (String), age
(integer) and health condition description (String).

File→Save: Saves all the data from ArrayList/LinkedList to the same file name
ResidentData.txt file. The saved file contains the resident name, age and health condition
description, separating with comma. This file should be allowed to re-open and read data as
the File->Read operation as above. The application must use the appropriate exception
handling to deal with problems during the file saving.

Tools→List: Lists all resident records from ArrayList/LinkedList in the display area as
shown below.
 
Tools→Add: Adds a resident entry to the Linked List via a series of input dialog box to enter
the resident name, age and health condition description respectively. For example, the
following input dialog box allows entering the resident name.

Tools→Delete: Deletes a resident entry by entering the resident name as the following input
dialog box. Accordingly, the matched object of a resident stored in the Linked List is
removed.

Tools→Sort: Sorts data by the resident name in ascending order using the best sorting
algorithm covered in COIT20256 unit and displays sorted data in the display area as shown
below. You are not allowed to use any built-in sorting algorithm. You must write your own
code to implement sorting.

Tools→Search: Asks the user to enter a resident name via an input dialog box as shown
below and uses the best searching algorithm covered in COIT20256 unit to search for the 
given resident name. It displays appropriate message found or not found in the display area.
You must write your code to implement searching.

Help→Details: Provides the user with some brief information on this application program as
shown in the following message box.

Exit→Exit: Allows the user to exit the application.

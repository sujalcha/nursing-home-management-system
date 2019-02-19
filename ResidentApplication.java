package nursinghome;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;



public class ResidentApplication extends JFrame {

 // declaring arraylist to hold resident variables 
 ArrayList < Resident > list = new ArrayList < > ();

 public ResidentApplication() {

  super("Nursing Home Application System V2.0");

  JMenu fileMenu = new JMenu("File"); // create file menu
  JMenuItem readItem = new JMenuItem("Read"); // create Save menu item
  fileMenu.add(readItem); // add save item to file menu
  //saveItem.addActionListener(new Save()); //click on save saves the info in the txt file
  JMenuItem saveItem = new JMenuItem("Save"); // create Save menu item
  fileMenu.add(saveItem);

  JMenu toolsMenu = new JMenu("Tools"); // create file menu
  JMenuItem listItem = new JMenuItem("List"); // create Save menu item
  toolsMenu.add(listItem); // add save item to file menu
  JMenuItem addItem = new JMenuItem("Add"); // create Save menu item
  toolsMenu.add(addItem); // add save item to file menu
  JMenuItem deleteItem = new JMenuItem("Delete"); // create Save menu item
  toolsMenu.add(deleteItem); // add save item to file menu
  JMenuItem sortItem = new JMenuItem("Sort"); // create Save menu item
  toolsMenu.add(sortItem); // add save item to file menu
  JMenuItem searchItem = new JMenuItem("Search"); // create Save menu item
  toolsMenu.add(searchItem); // add save item to file menu

  JMenu helpMenu = new JMenu("Help"); // create Help menu
  JMenuItem detailsItem = new JMenuItem("Details"); //create about menu item
  helpMenu.add(detailsItem); // add about item to file menu

  JMenu exitMenu = new JMenu("Exit"); // create exit menu
  JMenuItem exitItem = new JMenuItem("Exit"); //create exit menu item
  exitMenu.add(exitItem); // add exit item to file menu
 

  JMenuBar bar;
  bar = new JMenuBar();

  setJMenuBar(bar); // add menu bar to application
  bar.add(fileMenu); // add file menu to menu bar
  bar.add(toolsMenu); // add edit menu to menu bar
  bar.add(helpMenu); // add help menu to menu bar
  bar.add(exitMenu); // add exit menu to menu bar

  JPanel contentPanel = new JPanel();
  contentPanel = new JPanel(new GridLayout(1, 1));
  JTextArea displayArea = new JTextArea();
  displayArea.setEditable(false);
  contentPanel.add(displayArea);
  JScrollPane sp = new JScrollPane(displayArea);
  contentPanel.add(sp);
  add(contentPanel);
  
  JTextField[] name = new JTextField[10];
  JTextField[] age = new JTextField[10];
  JTextField[] condition = new JTextField[10];
  

  // read item pressed
  readItem.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent rf) {

    // The name of the file to open.
    String fileName = "ResidentData.txt";
    list.clear();

    // This will reference one line at a time
    String line = null;

    try {
     // FileReader reads text files in the default encoding.
     FileReader fileReader =
      new FileReader(fileName);

     // Always wrap FileReader in BufferedReader.
     BufferedReader bufferedReader =
      new BufferedReader(fileReader);
     long startTime = System.nanoTime();
     while ((line = bufferedReader.readLine()) != null) {
      //System.out.println(line);
      
      String[] temp;
      temp = line.split(",", 1);
      String[] name;
      name = new String[temp.length];
      String[] age;
      age = new String[temp.length];
      String[] condition;
      condition = new String[temp.length];
      String[] resident;

      for (int i = 0; i < temp.length; i++) {
       resident = line.split(",", 3);
       name[i] = resident[i];
       age[i] = resident[i + 1];
       condition[i] = resident[i + 2];
       Resident p = new Resident(name[i], age[i], condition[i]);

       list.add(p);
     
       //System.out.println(name[i] + age[i] + condition[i] + " added");
      }
      
     }
       long estimatedTime = System.nanoTime() - startTime;
       System.out.println("Time Taken to read " + estimatedTime+" Nano Seconds " );

     // Always close files.
     bufferedReader.close();
     displayArea.setText("Document has been read");
    } catch (FileNotFoundException ex) {
     System.out.println(
      "Unable to open file '" +
      fileName + "'");
     displayArea.setText("Unable to open file");
    } catch (IOException ex) {
     System.out.println(
      "Error reading file '" + fileName + "'");
     displayArea.setText("Error Reading file");
   
    }

   }
  });

  // save item pressed
  saveItem.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent sf) {

    if (list.isEmpty()) {
     displayArea.setText("There is nothing in the list please read the document first");
    } else {
     try (FileWriter fw = new FileWriter("ResidentData.txt", false); BufferedWriter bw = new BufferedWriter(fw); PrintWriter out = new PrintWriter(bw)) {
      out.println("zero dock");
     } catch (IOException ie) {
      //if the document doesnot save the user might be given the given information
     }


     // The name of the file to open.
     String fileName = "ResidentData.txt";

     try {

      FileWriter outFile = new FileWriter("ResidentData.txt");
      BufferedWriter outStream = new BufferedWriter(outFile);
      for (Resident detail: list) {
       outStream.write(detail.toStringdoc());
       outStream.newLine();

       System.out.println("Save " + detail);

      }
      outStream.close();
      displayArea.setText("List has been saved to document");
      // Always close files.



     } catch (FileNotFoundException ex) {
      System.out.println(
       "Unable to open file '" +
       fileName + "'");
      displayArea.setText("Unable to open file");
     } catch (IOException ex) {
      System.out.println(
       "Error reading file '" + fileName + "'");
      displayArea.setText("Error reading file");
      // Or we could just do this: 
      // ex.printStackTrace();
     }
    }
   }
  });

  // list item pressed
  listItem.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent lf) {

    if (list.isEmpty()) {
     displayArea.setText("There is nothing in the list please read the document first");
    } else {





     displayArea.setText("");
     displayArea.append("\tResident Name\t\t\tAge\t\t\tHealth Description\n");
     displayArea.append("\t===============================================================================================\n");

     int itemCount = list.size();
     for (int i = 0; i < itemCount; i++) {
      displayArea.append(list.get(i) + "\n");
     }

     displayArea.append("\t===============================================================================================\n");
    }
   }
  });

  // add item pressed
  addItem.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent af) {

    if (list.isEmpty()) {
     displayArea.setText("There is nothing in the list please read the document first");
    } else {


     JFrame namewindow = new JFrame();
     String name = JOptionPane.showInputDialog(namewindow, "Enter Name");
     if (name == null) { // if the user press cancel;
      return;
     }
     name = name.trim();
     if (name.equals("") || name.isEmpty()) {
      JOptionPane.showMessageDialog(null, "Please enter a valid input!");

     } else {


      String age = JOptionPane.showInputDialog(namewindow, "Enter Age");
      if (age == null) { // if the user press cancel;
       return;
      }
      age = age.trim();
      if (age.equals("") || age.isEmpty()) {
       JOptionPane.showMessageDialog(null, "Please enter a valid age!");
       return;
      } else {

       String condition = JOptionPane.showInputDialog(namewindow, "Enter Condition");
       if (age == null) { // if the user press cancel;
        return;
       }
       age = age.trim();
       if (age.equals("") || age.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Please enter a valid condition!");
        return;
       } else {


        Resident p = new Resident(name, age, condition);
        list.add(p);
        displayArea.setText("New Resident " + name + " has been added");

       }

      }
     }

    }
   }
  });
  
  // delete button pressed
  deleteItem.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent df) {

    if (list.isEmpty()) {
     displayArea.setText("There is nothing in the list please read the document first");
    } else {

     JFrame namewindow = new JFrame();
     String name = JOptionPane.showInputDialog(namewindow, "Enter Name");
     if (name == null) { // if the user press cancel;
      return;
     }
     name = name.trim();
     if (name.equals("") || name.isEmpty()) {
      JOptionPane.showMessageDialog(null, "Please enter a valid input!");

     } else {


      namewindow.dispose();
      for (Iterator < Resident > iterator = list.iterator(); iterator.hasNext();) {
       Resident temp = iterator.next();

       // Add null checks for proper error handling.

       if (temp.name.equalsIgnoreCase(name)) {
        iterator.remove();
        System.out.println(name + " has been deleted.");
        displayArea.setText(name + " has been deleted.");
        return;
       }
      }
      System.out.println("No contact with first name " + name + " was found.");
      displayArea.setText("No contact with first name " + name + " was found.");

     }
    }
   }
  });

  //sort button pressed
  sortItem.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent sof) {


    displayArea.setText("");
    displayArea.append("");

    long startTime = System.nanoTime();
    Comparator < Resident > NameComparator = new Comparator < Resident > () {

     public int compare(Resident res1, Resident res2) {

      String resName1 = res1.getname().toUpperCase();
      String resName2 = res2.getname().toUpperCase();

      //ascending order
      return resName1.compareTo(resName2);

     
     }

    };
    if (list.isEmpty()) {
     displayArea.setText("There is nothing in the list please read the document first");
    } else {
     displayArea.append("\tResident Name\t\t\tAge\t\t\tHealth Description\n");
     displayArea.append("\t===============================================================================================\n");

     Collections.sort(list, NameComparator);
     int itemCount = list.size();
     for (int i = 0; i < itemCount; i++) {
      displayArea.append(list.get(i) + "\n");
     }

     displayArea.append("\t===============================================================================================\n");
    }
    long estimatedTime = System.nanoTime() - startTime;
    System.out.println("Time Taken to sort " + estimatedTime+" Nano Seconds ");

   }
  });

  // search button pressed
  searchItem.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent seaf) {

    if (list.isEmpty()) {
     displayArea.setText("There is nothing in the list please read the document first");
    } else {


     JFrame namewindow = new JFrame();
     String namesearch = JOptionPane.showInputDialog(namewindow, "Enter Name");
     if (namesearch == null) { // if the user press cancel;
      return;
     }
     
     namesearch = namesearch.trim();
     if (namesearch.equals("") || namesearch.isEmpty()) {
      JOptionPane.showMessageDialog(null, "Please enter a valid input!");
      
     } else {


      namewindow.dispose();
      long startTime = System.nanoTime();
      Comparator < Resident > NamComparator = new Comparator < Resident > () {

       public int compare(Resident r1, Resident r2) {

        String resName1 = r1.getname().toUpperCase();
        String resName2 = r2.getname().toUpperCase();


        return resName1.compareTo(resName2);


       }

      };

      Collections.sort(list, NamComparator);
      int idx = Collections.binarySearch(
       list, new Resident(namesearch, null, null), NamComparator);


      
      //System.out.println(namesearch + " found at index = " + idx);
      for (Iterator < Resident > iterator = list.iterator(); iterator.hasNext();) {
       Resident temp = iterator.next();


       // Add null checks for proper error handling.

       if (temp.name.equalsIgnoreCase(namesearch)) {

        displayArea.setText("");
        //System.out.println(temp);

        displayArea.append("\tResident Name\t\t\tAge\t\t\tHealth Description\n");
        displayArea.append("\t===============================================================================================\n");

        displayArea.append(list.get(idx) + "\n");

        displayArea.append("\t===============================================================================================\n");

        long estimatedTime = System.nanoTime() - startTime;
        System.out.println("Time Taken to search " + estimatedTime+" Nano Seconds " );


        return;
       }
      }
      System.out.println("No contact with first name " + namesearch + " was found.");
      displayArea.setText("No contact with first name " + namesearch + " was found.");


     }
    }

   }
  });


  // details button
  detailsItem.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent df) {
    JFrame namewindow = new JFrame();
    JOptionPane.showMessageDialog(namewindow, "Instructions\n" + "1. Select File ->Read menu to read data\n" + "2. Select File ->Save menu to write data\n" + "3. Select Tools ->List menu to display data\n" + "4. Select Tools ->Add/Delete menu to add/delete data\n" + "5. Select Tools ->Sort menu to sort data\n" + "6. Select Tools ->Search menu to search a Resident\n" + "7. Select Help ->Help menu to display help message\n" + "8. Select Exit ->Exit menu to exit from application\n");

   }
  });

  //exit button
  exitItem.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent df) {
    System.exit(0);
   }

  });


 }

// main method
 
 public static void main(String[] args) {
  ResidentApplication displayFrame = new ResidentApplication();
  displayFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  displayFrame.setSize(800, 550); //setting dimensions for the frame
  displayFrame.setVisible(true);


 }



}
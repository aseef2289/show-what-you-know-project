/*
* File Name: Main.java
* Author: Aseef Ali Hasan
* Date: August 15, 2021
* Description:
* This program calculates the user's average mark
* It can take up to 5 marks
* The program accounts for empty string errors
* using if else statements
* It uses arrays and for loops to calculate average
* Displays information through a GUI
*/

//Import classes used for the GUI
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;

class Main {
  //Class variables
  //All the elements needed to build GUI 
  static JFrame frmMain;

  static JLabel lblTitle;

  static JLabel lblMarkOne;
  static JLabel lblMarkTwo;
  static JLabel lblMarkThree;
  static JLabel lblMarkFour;
  static JLabel lblMarkFive;
  
  static JTextField txtMarkOne;
  static JTextField txtMarkTwo;
  static JTextField txtMarkThree;
  static JTextField txtMarkFour;
  static JTextField txtMarkFive;

  static JTextArea txtDisplay;

  static JButton btnCalculate;

  //stores user's first mark
  static double markOne;
  //stores user's second mark
  static double markTwo;
  //stores user's third mark
  static double markThree;
  //stores user's fourth mark
  static double markFour;
  //stores user's fifth mark
  static double markFive;
  //Used when adding marks together
  static double total = 0;
  //stores user's average
  static double userAverage;
  
  //string to store statement to show user at the end
  static String finalStatement;
  //constant string storing instructions for user
  static final String USER_INSTRUCTIONS = "Please enter your 5 marks";
  //constant string storing message if user has zeros
  //and has left text fields blank
  static final String IF_BLANK = "If you have zero as a mark" +
                                "\nplease enter them as 0." +
                                "\nPlease don't leave any" +
                                "\nfields blank.";

  //string storing text in 1st text field
  static String stringOne;
  //string storing text in 2nd text field
  static String stringTwo;
  //string storing text in 3rd text field
  static String stringThree;
  //string storing text in 4th text field
  static String stringFour;
  //string storing text in 5th text field
  static String stringFive;
  
  public static void main(String[] args) {
	
    //stores all the labels for the mark JLabels as an array
    final String [] markLabels = new String [5]; 
    markLabels [0] = "<html>Course Mark 1: ";
    markLabels [1] = "<html>Course Mark 2: ";
    markLabels [2] = "<html>Course Mark 3: ";
    markLabels [3] = "<html>Course Mark 4: ";
    markLabels [4] = "<html>Course Mark 5: ";
	
    /*
    * Initialize all GUI elements and place them in the form
    */
    //setting up the main frame
    frmMain = new JFrame("Average Calculator");
    //stops program when user closes window
    frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //allows for specific element locations
    frmMain.setLayout(null);
    //makes window visible to user
    frmMain.setVisible(true);
    frmMain.setBounds(10,10,400,500);

    //Setting title position and adding it to the frame
    lblTitle = new JLabel("<html>Average Calculator");
    lblTitle.setBounds(130,10,200,30);
    frmMain.add(lblTitle);
    
    //add 1st mark label and text field
    lblMarkOne = new JLabel(markLabels [0]);
    lblMarkOne.setBounds(10,50,150,100);
    frmMain.add(lblMarkOne);
    txtMarkOne = new JTextField();
    txtMarkOne.setBounds(310,80,50,30);
    frmMain.add(txtMarkOne);

    //add 2nd mark label and text field
    lblMarkTwo = new JLabel(markLabels [1]);
    lblMarkTwo.setBounds(10,100,150,100);
    frmMain.add(lblMarkTwo);
    txtMarkTwo = new JTextField();
    txtMarkTwo.setBounds(310,130,50,30);
    frmMain.add(txtMarkTwo);

    //add 3rd mark label and text field
    lblMarkThree = new JLabel(markLabels [2]);
    lblMarkThree.setBounds(10,150,150,100);
    frmMain.add(lblMarkThree);
    txtMarkThree = new JTextField();
    txtMarkThree.setBounds(310,180,50,30);
    frmMain.add(txtMarkThree);

    //add 4th mark label and text field
    lblMarkFour = new JLabel(markLabels [3]);
    lblMarkFour.setBounds(10,200,150,100);
    frmMain.add(lblMarkFour);
    txtMarkFour = new JTextField();
    txtMarkFour.setBounds(310,230,50,30);
    frmMain.add(txtMarkFour);

    //add 5th mark label and text field
    lblMarkFive = new JLabel(markLabels [4]);
    lblMarkFive.setBounds(10,250,150,100);
    frmMain.add(lblMarkFive);
    txtMarkFive = new JTextField();
    txtMarkFive.setBounds(310,280,50,30);
    frmMain.add(txtMarkFive);

    //add text area to show user messages and results
    //shows user instructions to use program
    txtDisplay = new JTextArea(USER_INSTRUCTIONS);
    txtDisplay.setBounds(100,380,200,100);
    //makes text area not editable
    txtDisplay.setEditable(false); 
    frmMain.add(txtDisplay);

    //add button to calculate average to frame
    btnCalculate = new JButton("Calculate");
    btnCalculate.setBounds(100,340,200,20);
    frmMain.add(btnCalculate);
    
    //add calculate button to action element
    btnCalculate.addActionListener((ActionEvent e)-> {
      
      //retrieves text from mark text fields
      stringOne = txtMarkOne.getText();
      stringTwo = txtMarkTwo.getText();
      stringThree = txtMarkThree.getText();
      stringFour = txtMarkFour.getText();
      stringFive = txtMarkFive.getText();
      
      //actions if the text fields are blank
      if (stringOne.equals("") || stringTwo.equals("") || 
          stringThree.equals("") || stringFour.equals("") 
          || stringFive.equals(""))
      {
        //tells user to input zeros instead of leaving field blank
        //avoids empty string error
    	  txtDisplay.setLineWrap(true);
    	  txtDisplay.setText(IF_BLANK);
      }
      
      //actions if the text fields have numbers
      else {
        //stores marks as doubles
	      markOne = Double.parseDouble(txtMarkOne.getText());
	      markTwo = Double.parseDouble(txtMarkTwo.getText());
	      markThree = Double.parseDouble(txtMarkThree.getText());
	      markFour = Double.parseDouble(txtMarkFour.getText());
	      markFive = Double.parseDouble(txtMarkFive.getText());
	      
        //creates array with the five marks the user enters
	      double [] marks = {markOne, markTwo, markThree, markFour, markFive};

        /*
         * i starts at 0
         * will continue to add one each time
         * until i is less than or equal to 4
         * adds marks together
         */
	      for (int i = 0; i <= 4; i++)
	      {
          //adds all 5 marks together
          //until it reaches the index value of 4
	        total = total + marks[i];
	      }
	      
	      //stores total number of marks from array
	      int totalMarks = marks.length;

        //calculates the user's average
	      userAverage = (total) / totalMarks;

        //rounds user's average to 2 decimal places
	      userAverage = userAverage * 100;
	      userAverage = Math.round(userAverage);
	      userAverage = userAverage / 100;

        //Sets up final statement for user
	      finalStatement = "Your average is: " + String.valueOf(userAverage) + "%";

        //Turns of line wrap so text doesn't go off screen
	      txtDisplay.setLineWrap(true);

        //Puts final statement in the text area for user
	      txtDisplay.setText(finalStatement);

        //Sets all text fields to blank for next calculation
	      txtMarkOne.setText("");
	      txtMarkTwo.setText("");
	      txtMarkThree.setText("");
	      txtMarkFour.setText("");
	      txtMarkFive.setText("");
      }
    });//end of action listener
  }//end of main method
}//end of class method
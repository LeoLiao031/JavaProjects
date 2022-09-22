// MUST MAKE CONSOLE WIDE 
// OR SET BROWSER ZOOM REALLY LOW: 50% ZOOM WORKS
// importing different packages that will be used in the program
// this package allows for a delay to be created
import java.util.concurrent.TimeUnit;
// imported to track keyboard inputs from the user
import java.util.Scanner;
// imported package to allow for random value generation
import java.util.Random;
class Main {
// each array contains data for its corresponding city based on index
/* Table that shows shich element corresponds to which cities data
City                Element #
Halifax                0
Vancouver              1
Toronto                2
Montreal               3
St. Johns              4
Fredericton            5
Charlottetown          6
Winnipeg               7
Edmonton               8
Regina                 9

*/
static String[] cities = {"Halifax", "Vancouver", "Toronto", "Montreal", "St. Johns", "Fredericton", "Charlottetown", "Winnipeg", "Edmonton", "Regina" };
static int[] housing = {1515, 2167, 1989, 1461, 842, 1400, 829, 1164, 1011, 895};
static double[] westernfood = {436.81, 436.81, 413.85,441.07,463.53,427.66, 559.40, 401.86, 393.89, 385.16};
static double[] asianfood = {382.46, 340.01, 310.64, 322.24, 367.05, 360.08, 436.04, 323.78, 307.53, 299.93};
static double[] childcare = {939.00, 1400.00, 1600.00, 255.00, 750.00, 820.00, 738.00, 450.00, 1050.00, 850.00};
static double[] cellular = {90.00, 90.00, 90.00, 58.00, 90.00, 90.00, 90.00, 48.00, 90.00, 48.00};
static double[] gasprice = {278.33, 312.89, 278.74, 289.92, 319.93, 285.58, 282.47, 272.75, 269.85, 272.54};
static double[] publictrans = {82.50, 100.25, 156.00, 90.00, 77.00, 80.00, 58.50, 104.00, 100.00, 88.00}; 
// declaration of variables
static boolean invalid = true;
static boolean print = true;
static boolean ask = true;
static String city;
static String cuisine; 
static String household; 
static String children;
static String working;
static String transportation;
static String command;
static String tablevalue="";
static String miscellaneous;
static String editcost;
static String entryoption;
static int familysize= 0 ;
static int childrennumber = 0;
static int workingnumber = 0; 
static int index = 0;
static int placeholder = 0;
static int blankspace;
static int limit;
// $19930 income is what is considered the amount for bare minimum livng of one person thus is suitable to show poverty line
static int povertyincome = 19930/12;
static double extracost = 0;
static double monthlyexpenses = 0;
static double changecost = 0;
static Scanner input = new Scanner(System.in);
static Random rand = new Random();

// creating a method to dislay a table as it will be used multiple times later on
static void table(){
  System.out.println("");
// title for table along with the name of the city that its data is based off of
  System.out.println("Monthly Expenses Cost Table For "+(cities[index]));

// header of the table with the titles each column will have a space of 15 characters
System.out.println("\nCity           |Rent           |Asian Food     |Western Food   |Childcare     |Cellular       |Gas Price      |Public Trans   |Miscellaneous  ");
System.out.println("_______________|_______________|_______________|_______________|______________|_______________|_______________|_______________|_______________");
// for loop that displays the values on the table based on the data entered by the user
monthlyexpenses = 0;
for(int i = 0; i < 9; i++){
  if (i == 0){
// checking character length of string to calculate blank spaces that come after
  tablevalue = cities[index];
  blankspace = 15-tablevalue.length();
// displaying the city in the first column
  System.out.print(tablevalue);
  // for loop that prints blank spaces based on what was calculated earlier
  for(int y=0;y<blankspace;y++){
      System.out.print(" ");
  }
  System.out.print("|");
  }
// if statement that prints the rent and has a value based on the element number
  if (i == 1){
  tablevalue = String.valueOf(housing[index]);
  monthlyexpenses += housing[index];
  blankspace = 15-tablevalue.length();
  System.out.print("$");
  System.out.print(tablevalue);
  for(int q=0;q<blankspace-1;q++){
    System.out.print(" ");
  } // end of for loop that prints blank spaces
  System.out.print("|");
  } // end of the if statement that prints the city name
  // outputting the cost of asian food in the city
  else if (i == 2){
  tablevalue = String.valueOf(Math.round(asianfood[index]*familysize*1000.00)/1000.00);
  blankspace = 15-tablevalue.length();
  if (cuisine.equalsIgnoreCase("asian")){
  monthlyexpenses += asianfood[index]*familysize;
  System.out.print("$");
  System.out.print(tablevalue);
  for(int w=0;w<blankspace-1;w++){
    System.out.print(" ");
  }// end of the for loop that prints blank spaces
  System.out.print("|");
  } // end of the if statement that prints the value of asian food
  // prints a N/A value on the table when the other type of cuisine is chosen
  else 
  System.out.print("N/A            |");
}// end of table value 2 if statement
  // outputting the cost of western food in the city
  else if (i == 3){
  tablevalue = String.valueOf(Math.round(westernfood[index]*familysize*1000.00)/1000.00);
  blankspace = 15-tablevalue.length();
  if (cuisine.equalsIgnoreCase("western")){
  monthlyexpenses += westernfood[index]*familysize;
  System.out.print("$");
  System.out.print(tablevalue);
  for(int q=0;q<blankspace-1;q++){
    System.out.print(" ");
  } // end of for loop that prints blank spaces
  System.out.print("|");
  } // end of the if statement that prints the value of western food
  else
  // printing N/A in the case that asian food was chosen
  System.out.print("N/A            |");
  } // end of table value 3 if statement 
  // outputting the cost of childcare 
  else if(i == 4){
    if (childrennumber != 0){
    tablevalue = String.valueOf(childcare[index]*childrennumber);
    monthlyexpenses += childcare[index]*childrennumber;
    blankspace = 15-tablevalue.length();
    System.out.print("$");
    System.out.print(tablevalue);
    for(int r=0;r<blankspace-2;r++){
    System.out.print(" ");
    } // end of for loop 
    System.out.print("|");
    } // end of if statement for childcare when there's a child oor multiple
    else {
    // printing N/A when inputted data has children at 0
    System.out.print("N/A           |");
    }// else for when there aren't any children in the family
  } // end of table value 4
  // end of outputting the cost of childcare
  // if statement that outputs the cost of a cellular plan
  else if(i == 5){
    tablevalue = String.valueOf(cellular[index]*workingnumber);
    blankspace = 15-tablevalue.length();
    monthlyexpenses += (cellular[index]*workingnumber);
    System.out.print("$");
    System.out.print(tablevalue);
    for(int t=0;t<blankspace-1;t++){
    System.out.print(" ");
    }// end of for loop that prints blank spaces
    System.out.print("|");
  } // end of cellular plan 
  // outputting gas price per month calculated based on one car
  else if (i == 6){
    if (transportation.equals("1")){
      tablevalue = String.valueOf(gasprice[index]);
      monthlyexpenses += gasprice[index];
      blankspace = 15-tablevalue.length();
      System.out.print("$");
      System.out.print(tablevalue);
      for(int y=0;y<blankspace-1;y++){
      System.out.print(" ");
      } // end of loop that prints blank spaces
      System.out.print("|");   
      } // end of the i statement for gas price
      // case for when they're taking public transportation
    else
      System.out.print("N/A            |");
  }// end of if statement for gas price
  // if statement to display the cost of public transit
  else if (i == 7){
    if (transportation.equals("2")){
      tablevalue = String.valueOf(Math.round(publictrans[index]*workingnumber*1000.00)/1000.00);
      monthlyexpenses += publictrans[index];
      blankspace = 15-tablevalue.length();
      System.out.print("$");
      System.out.print(tablevalue);
      for(int y=0;y<blankspace-1;y++){
      System.out.print(" ");
      }
      System.out.print("|");
    } // end of nested if for when public transportation is picked of driving
    // case for when driving is chosen over public transit
    else 
    System.out.print("N/A            |");
  }// end of if statement for public transit
  // if statement for outputting miscellaneous cost 
  else if (i == 8){
    miscellaneous = String.valueOf(extracost);
    blankspace = 15 - miscellaneous.length();
    monthlyexpenses += extracost;
    System.out.print("$");
    System.out.print(miscellaneous);
    for(int u=0;u<blankspace-1;u++){
    System.out.print(" ");
    }// end of for loop that print blank spaces
    System.out.print("|\n");
  } // end of if statement that outputs the miscellenous cist titak
}// end of for loop that draws table
System.out.println("______________________________________________________________________________________________________________________________________________|\n");
} // end of method for printing table

// creation of method that displays the total expenses per month, combined income and prompts for input that will be used to determine what happens next
static void instructions(){
double roundedmonthlyexpenses = Math.round(monthlyexpenses*1000.0)/1000.0;
System.out.println("Expenses per month is: $"+roundedmonthlyexpenses );
System.out.println("The combined income of your family assuming everyones wage is under the poverty line would be $"+(povertyincome*workingnumber));
System.out.println("\nPlease enter a command\nFor commmands enter help");
command = input.nextLine();
// using string manipulation to allow for a switch statement to function 
command = command.toLowerCase();
} // end of instuctions method
// method for manual input of information
static void manual(){
// asking the user to input their information to give a benchmark
System.out.println("Please enter the number that corresponds to the city you live in"); 
//displaying all the cities to give the user a list to choose from 
for (int i =0; i<cities.length; i++){
  System.out.println(i+". "+ cities[i]);
} // end of for loop that displays the cities
// while loop that asks for input until it's valid
while (invalid){
  city = input.nextLine();
// if statement determining whether city is valid one from list as values are only for select cities
if (city.equals("0")||city.equals("1")||city.equals("2")||city.equals("3")||city.equals("4")||city.equals("5")||city.equals("6")||city.equals("7")||city.equals("8")||city.equals("9")){
    System.out.println("Chosen city is "+ cities[Integer.parseInt(city)]);
    index = Integer.parseInt(city);
    invalid = false;}
// prompt for when the input doesn't match a city in the array
else{
    System.out.print("Invalid input for city please try again: ");
    }
} 
// assumed that user will be renting a one bedroom apartment as it's the cheapest
// reseting invalid for another loop where their the type of food they eat will be asked
invalid = true; 
// asking the user for what type of food that they eat 
// do while that keeps asking for input until a valid one is found
do {
  System.out.println("Please enter \"asian\" if you eat asian food or \"western\": ");
  cuisine = input.nextLine();
  if (cuisine.equalsIgnoreCase("asian")||cuisine.equalsIgnoreCase("western")){
    System.out.println("Type of cuisine chosen is "+cuisine.toLowerCase());
    // invalid is set to false to stop the loop
    invalid = false;
  } // end of if statement for a valid input
  // prompt that tells user that their input is invalid
  else
  System.out.println("Invalid input for type of cuisine please try again");
} // end of do loop for cuisine choice  
while (invalid);

// reseting invalid for usage in a loop that asks for familly size
invalid = true;
// asking the user how many people live in their household
do {
  System.out.println("How many people live in your household? ");
  household = input.nextLine();
// making sure that user input is a number
    try {
        familysize = Integer.parseInt(household);
        System.out.println("Size of household is "+familysize+" members");
        invalid = false;
    } catch (NumberFormatException nfe) {
        System.out.println("Invalid input for household size please try again");
    } // end of cath
} // end of do loop
while (invalid);

// reseting invalid
invalid = true;
// asking the user if their family contains a child
do {
  System.out.println("Does your household contain a child? ");
  System.out.println("Enter \"yes\" or \"no\"");
  household = input.nextLine();
  household = household.toLowerCase();
  if (household.equals("yes")||household.equals("no")){
  // switch statement for when yes is the input
    switch (household){
    case "yes":
    System.out.println("Household does have a child");
    invalid = true;
    do {
    System.out.println("How many children live in your household? ");
    children = input.nextLine();
    // making sure that user input is a number for children count
    try {
        childrennumber = Integer.parseInt(children);
        System.out.println("Your household has "+childrennumber+" children");
        invalid = false;
        continue;
    } catch (NumberFormatException nfe) {
        System.out.println("Invalid input for number of children");
    } // end of catch
    } // end of do loop that prompts for input of the amount of children in the household
    while (invalid);
    break;
  case "no":
  // prompt for when family is declared to have no child
  System.out.println("Household doesn't have a child");
  invalid = false;
  break;
    } // end of switch statement for yes or no
    } // end of if statement that fofr when the input is yes or no
  // prompt for when the input to the initia yes or no was invalid
  else{
  System.out.println("Invalid input for question please try again");}
} // end of do loop for children count in household
while (invalid);

// asking the user how many members of the household work
invalid = true;
do {
  System.out.println("How many people work in your household? ");
  working = input.nextLine();
// making sure that user input is a valid number
    try {
        workingnumber = Integer.parseInt(working);
        System.out.println("Household has "+workingnumber+" working members");
        invalid = false;
    } catch (NumberFormatException nfe) {
        System.out.println("Invalid input for working household members please try again");
    } // end of catch
} // end of do loop for working members of household
while (invalid);

// reset of invalid
invalid = true;
// asking the user if they take public transit or drive their own car
System.out.println("Please enter the number that corresponds to the type of transportation you use");
System.out.println("1. Driving own car\n2. Public transportion");
// do while that keeps asking for input until valid form of transportation is entered 
do {
// prompting the user for an input 
transportation = input.nextLine();
transportation = transportation.toLowerCase();
if (transportation.equals("1")){
System.out.println("Type of transportation chosen is driving");
invalid = false;
} // end of if statement for when the transportation method chosen is driving
else if (transportation.equals("2")){
System.out.println("Type of transportation chosen is public");
invalid = false;
} // end of if statement for when method chosen in public 
else 
// prompt for invalid input
System.out.println("Invalid input for transportation please try again");
} // end of do loop for transportation 
while(invalid);

// asking how much user spends on other things not asked prior 
System.out.println("How much money per month do you spend on expenses not listed?");
invalid = true;
do {
miscellaneous = input.nextLine();
    // testing if the input is valid by utilizing double parsing 
    try {
      extracost = Double.parseDouble(miscellaneous);
      System.out.println("Misccellaneous costs per month is $"+extracost);
      invalid = false;
  } catch (NumberFormatException nfe) {
      // prompt for invalid input
      System.out.println("Invalid input for miscellaneous please try again");
    } // end of catch
}// end of do loop for miscellaneous costs
while (invalid);
//  delay to let the user see the inputs given
try{
TimeUnit.SECONDS.sleep(1);
}
catch (InterruptedException ie){
  Thread.currentThread().interrupt();
}
}// end of method for manual input of information
// creating a method to clear screen 
static void clearscreen(){
       System.out.print("\033[H\033[2J");
       System.out.flush();
       } // end of clearscreen methof
  public static void main(String[] args) {

// banner that tells the user what this program is
System.out.println("    __    _       _                ______                                   ______      __           __      __ ");           
System.out.println("   / /   (_)   __(_)___  ____ _   / ____/  ______  ___  ____  ________     / ____/___ _/ /______  __/ /___ _/ /_____  _____");
System.out.println("  / /   / / | / / / __ \\/ __ `/  / __/ | |/_/ __ \\/ _ \\/ __ \\/ ___/ _ \\   / /   / __ `/ / ___/ / / / / __ `/ __/ __ \\/ ___/");
System.out.println(" / /___/ /| |/ / / / / / /_/ /  / /____>  </ /_/ /  __/ / / (__  )  __/  / /___/ /_/ / / /__/ /_/ / / /_/ / /_/ /_/ / /");    
System.out.println("/_____/_/ |___/_/_/ /_/\\__, /  /_____/_/|_/ .___/\\___/_/ /_/____/\\___/   \\____/\\__,_/_/\\___/\\__,_/_/\\__,_/\\__/\\____/_/");     
System.out.println("                      /____/             /_/ ");     
System.out.println("\nPlease enter some information to get started");
// prompt that tells the user to manually input information or use randomly generated values
System.out.println("\nIf you want a randomized option enter \"r\" or just press enter for manual entry");
// getting the input from the user that will decides which input type will be chosen 
entryoption = input.nextLine();
// if statement for when the input is for a random family 
if (entryoption.equalsIgnoreCase("r")){
// random city creation
limit = 10;
index = rand.nextInt(limit);
limit = 3;
// random cuisine creation
placeholder = rand.nextInt(limit);
if (placeholder == 1)
cuisine = "asian";
else
cuisine = "western";
limit = 4;
// random family size from 1-4
familysize = rand.nextInt(limit)+1;
limit = familysize+1;
// random children number
if(familysize>1)
workingnumber = rand.nextInt(limit+1);
childrennumber = familysize-workingnumber;
limit = 3;
transportation = String.valueOf((rand.nextInt(limit)+1));
limit = 1001;
extracost = rand.nextInt(limit);
}// end of random variable creation
// else statement for when the user wants to manually input information
else{
manual();
} // end of else statement
// clearing the screen to allow for a table to be drawn
clearscreen();
// drawing a table 
table();
// switch statement that determines what the command will do
// reseting invalid 
invalid = true;
// while loop that keeps running set command asking until the condition is met
while (invalid){
  // if statement that prints out instructions and total expense if print condition is met
  if (print == true)
  instructions();
  // doesn't print total monthly expenses but instead asks for command only used for when the command entered isn't one that outputs a table i.e help, wipe or default
  else
  command = input.nextLine();
  print = true;
// switch statement that branches code based on command entered by user
switch(command){
  // when the command is exit, the code ends and prints a message
  case "exit":
    clearscreen();
    System.out.println("Have a nice day!");
    invalid = false;
    break;
  // command that displays to the user what the other commands are
  case "help":
    System.out.println("exit: program will end\ncity: change current city\nasian/western: if N/A, changed to other type of cuisine\ngas/public: if N/A, changed to other type of transportation\nmiscellaneous: add or subtract costs\nwipe: delete current tables and reprint more recent one\nfamily: shows what the current family looks like\nrandom: change family conditions to random\nmanual: change family conditions manually");
    // setting command to an invalid one so a prompt is reset
    command = "placeholder";
    print = false;
    break;
  // switches the chosen cuisine to asian which makes western N/A
  case "asian":
    cuisine = "asian";
    table();
    break;
  // switches the chosen cuisine to western while making asian N/A 
  case "western":
    cuisine = "western";
    table();
    break;
  // switches the transportation to driven instead of public
  case "gas":
    transportation = "1";
    table();
    break;
  // switches the transportation to public transit
  case "public":
    transportation = "2";
    table();
    break;
  // wipes the console while printing the last table 
  case "wipe":
    clearscreen();
    table();
    break;
  // letting the user 
  case "city":
    System.out.println("Please enter the number that corresponds to a city");
    for (int i =0; i<cities.length; i++){
    System.out.println(i+". "+ cities[i]);
    }// end of the for loop that prints cities
    ask = true;
    while (ask){
    city = input.nextLine();
    // if statement determining whether city is valid one from list as values are only for select cities\
    if (city.equals("0")||city.equals("1")||city.equals("2")||city.equals("3")||city.equals("4")||city.equals("5")||city.equals("6")||city.equals("7")||city.equals("8")||city.equals("9")){
    System.out.println("Chosen city is "+ cities[Integer.parseInt(city)]);
    index = Integer.parseInt(city);
    ask = false;
    } // end of if statement
    else{
    System.out.print("Invalid input for city please try again: ");
    }// end of else statement
    }// end of while loop
    table();
    break;
  // changes the cost of the miscellaneous 
  case "miscellaneous":
    System.out.println("Are you adding or subtracting");
    ask = true;
      System.out.println("Please enter \'+\' or \'-\'");
      editcost = input.nextLine();
      // if loop for when a value is being added to miscellaneous
      if (editcost.equals("+")){
      // check to see if their entered value is a number
      ask = true;
      // loop that runs until valid input
      do {
      System.out.println("What is the amount you're adding to miscellaneous? ");
      editcost = input.nextLine();
      // making sure that user input is a number
      try {
        changecost = Integer.parseInt(editcost);
        ask = false;
        extracost+=changecost;
      } catch (NumberFormatException nfe) {
        System.out.println("Invalid input please try again");
      }
      } // end of do loop for miscellaneous
      while (ask);
      } // end if loop for +
      // if loop for subtraction from miscellaneous
      else if (editcost.equals("-")){
      // check to see if their entered value is a number
      ask = true;
      // do while that runs until a valid input is done
      do {
      System.out.println("What is the amount you're subtracting from miscellaneous? ");
      editcost = input.nextLine();
      // making sure that user input is a number
      try {
        changecost = Integer.parseInt(editcost);
        extracost-=changecost;
        ask = false;
      } catch (NumberFormatException nfe) {
        System.out.println("Invalid input please try again");
      } // end of catch
      } // end of loop for - 
      while(ask);
      } // end of else if
    table();
    break;
  // outputs to the user the amount of family size, working members and children
  case "family":
    System.out.printf("Family has %d members",familysize);
    // if statement for the case where the family has 0 children
    if (childrennumber == 0)
    // changed wording for when the child amount is singular
    System.out.println("\nFamily has no children");
    else if (childrennumber == 1)
    System.out.print("\nFamily has 1 child");
    else
    System.out.printf("\nFamily has %d children", childrennumber);
    // case for when there is only one working member of the family
    if (workingnumber == 1)
    System.out.print("\nFamily has 1 working member\n");
    else
    System.out.printf("\nFamily has %d working members\n",workingnumber);
    print = false;
    break;
  // randomly generates new values for the family members
  case "random":
    index = (int)Math.floor(Math.random()*(9-1+1)+1);
    placeholder = (int)Math.floor(Math.random()*(2-1+1)+1);
    // random cuisine between asian and western
    if (placeholder == 1)
    cuisine = "asian";
    else
    cuisine = "western";
    // random family size between 1 and 4
    familysize = (int)Math.floor(Math.random()*(4-1+1)+1);
    // random working family members amount between 1 and family number at most
    workingnumber = (int)Math.floor(Math.random()*(familysize-1+1)+1);
    childrennumber = familysize-workingnumber;
    transportation = String.valueOf((int)Math.floor(Math.random()*(2-2)+1));
    // random range of money from 100-1000
    extracost = (int)Math.floor(Math.random()*(1000-100+1)+1);
    table();
    break;
  // letting the user manually input information
  case "manual":
    manual();
    table();
    invalid = true;
    break;
  // defualt for when there's no matches with the other cases
  default:
    // outputting that the entered command was invalid as it didn't match any others
    System.out.print("Invalid input please try again: ");
    print = false;
}// end of switch statement
}// end of while
}
}

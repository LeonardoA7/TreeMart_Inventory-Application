// --== CS400 File Header Information ==--
// Name: <Leonardo Alfaro>
// Email: <lalfaro2@wisc.edu>
// Team: <BLUE>
// Group: <KE>
// TA: <Keren>
// Lecturer: <Heimerl>
// Notes to Grader: <None>
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
public class TestFrontend {
  
  /**
  * 
  * Test 1 will ensure that the exit function from the main menu works as intended. 
  * By entering 'x' from the main menu, the program is exited.
  * 
  */
  @Test
  public void test1() {
    PrintStream standardOut = System.out;
    InputStream standardIn = System.in;
    String input = "x";// command to exit the program
    InputStream inputStream = new ByteArrayInputStream(input.getBytes());
    System.setIn(inputStream);
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outputStream));
    Object frontend = new Frontend();      
    Frontend.main(new String[] {"listdata.csv"});      
    System.setOut(standardOut);
    System.setIn(standardIn);
    String appOutput = outputStream.toString();
    // test fails if the output does not contain closing message
    assertEquals(true, frontend != null && appOutput.contains("Have a Good Day!"));       
  }
  
  /**
  * 
  * Test 2 will ensure that the User Interface can switch between modes based on the user's input.
  * After returning to the main screen from either the update inventory menu or print menu screens,
  * the user should be able to continue changing products from both menus without the program
  * terminating. By entering 'x' on the update inventory menu or print menu screens, the user should be 
  * returned to the main menu screen. 
  * 
  */
  @Test
  public void test2() {
    PrintStream standardOut = System.out;
    InputStream standardIn = System.in;
    String input = "u" + System.lineSeparator() + "x" + System.lineSeparator()
    + "p" + System.lineSeparator()+ "x" + System.lineSeparator()+ "u" + System.lineSeparator() // navigating through menus
    + "x" + System.lineSeparator()+ "x" + System.lineSeparator();
    InputStream inputStream = new ByteArrayInputStream(input.getBytes());
    System.setIn(inputStream);
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outputStream));
    Object frontend = new Frontend();      
    Frontend.main(new String[] {"listdata.csv"});      
    System.setOut(standardOut);
    System.setIn(standardIn);
    String appOutput = outputStream.toString();
    System.out.println(outputStream.toString());
    // test fails if the output does not contain closing message, Update Inventory Menu or Print Menu
    assertEquals(true, frontend != null && appOutput.contains("Have a Good Day!") && appOutput.contains("Inventory  Menu")
        && appOutput.contains("Print Menu")); 
  }
  
  /**
  * 
  * Test 3: Test 3 will ensure that the functionality of
  * writing back to the .csv file works as intended. By entering ‘f’ from the print menu 
  * screen, the entire inventory will be printed in ascending-ID order through in-order traversal, and 
  * that data will be transferred back into the .csv file so the inventory is updated within the project.
  * 
  */
  @Test
  public void test3() {
    PrintStream standardOut = System.out;
    InputStream standardIn = System.in;
    String input = "p" + System.lineSeparator() + "f" + System.lineSeparator()
    + "y" + System.lineSeparator()+ "y" + System.lineSeparator()+ "x" + System.lineSeparator()+ "x" + System.lineSeparator();// commands to print file in the program
    InputStream inputStream = new ByteArrayInputStream(input.getBytes());
    System.setIn(inputStream);
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outputStream));
    Object frontend = new Frontend();      
    Frontend.main(new String[] {"listdata.csv"});      
    System.setOut(standardOut);
    System.setIn(standardIn);
    String appOutput = outputStream.toString();
    System.out.println(outputStream.toString());
    // Test fails if success statement is not printed
    assertEquals(true, frontend != null && appOutput.contains("File Successfully Updated. Type Anything To Continue"));  
  }
  
  /**
  * 
  * Test 4: Test 4 will ensure that the summary function under the Print Menu works as intended. 
  * By entering ‘s’ from the print menu screen, it will print to the console a summary of the changes 
  * that occurred to the inventory since it was loaded in on startup, including changes to stock and newly added 
  * items, as well as overall profit (or loss ☹ ) from those changes.
  * 
  */
  @Test
  public void test4() {
    PrintStream standardOut = System.out;
    InputStream standardIn = System.in;
    String input = "p" + System.lineSeparator() + "s" + System.lineSeparator()
    + "y" + System.lineSeparator()+ "x" + System.lineSeparator()+ "x" + System.lineSeparator();// commands to print file in the program
    InputStream inputStream = new ByteArrayInputStream(input.getBytes());
    System.setIn(inputStream);
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outputStream));
    Object frontend = new Frontend();      
    Frontend.main(new String[] {"listdata.csv"});      
    System.setOut(standardOut);
    System.setIn(standardIn);
    String appOutput = outputStream.toString();
    System.out.println(outputStream.toString());
    assertEquals(true, frontend != null && appOutput.contains("During This Session, The Following Products Were Changed:"));   
  }
  
  /**
  * 
  * Test 5: Test 5 will ensure that the print by name-lookup works as intended. 
  * By entering ‘p’ from the print menu screen, the user will be asked to enter a 
  * specific name of a product that TreeMart sells. If the product with that name exists in the RB-tree, 
  * the description of that item will be printed to the console.
  * 
  */
  @Test
  public void test5() {
    PrintStream standardOut = System.out;
    InputStream standardIn = System.in;
    //
    //
    //
    String input = "p" + System.lineSeparator() + "l" + System.lineSeparator()
    + "Apples" + System.lineSeparator()+ "y" + System.lineSeparator()+ "x" + System.lineSeparator()+ "x" + System.lineSeparator();// commands to print file in the program
    // ^
    // | Might have to change 'Apples' with the name of a real product
    //
    InputStream inputStream = new ByteArrayInputStream(input.getBytes());
    System.setIn(inputStream);
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outputStream));
    Object frontend = new Frontend();      
    Frontend.main(new String[] {"listdata.csv"});      
    System.setOut(standardOut);
    System.setIn(standardIn);
    String appOutput = outputStream.toString();
    System.out.println(outputStream.toString());
    //
    //
    //
    assertEquals(true, frontend != null && appOutput.contains("Product{ID=1234, name='Apples', "
        + "quantity_sold=10, quantity_available=55, cost=15.99, retail_price=9.99}")); // might have to switch to a real Product
    //
    //
    //
  }
}

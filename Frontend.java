// --== CS400 File Header Information ==--
// Name: <Leonardo Alfaro>
// Email: <lalfaro2@wisc.edu>
// Team: <BLUE>
// Group: <KE>
// TA: <Keren>
// Lecturer: <Heimerl>
// Notes to Grader: <None>
import java.util.ArrayList;
import java.util.Scanner;
public class Frontend {
  
  private ArrayList<ProductInterface> changed;
  private ArrayList<ProductInterface> lowProducts;
  private ArrayList<Product> allProducts;
  private Scanner sc = new Scanner(System.in);
  private Backend dummy;
  private float netProfit;
  
  public static void main(String[] args) {
    args = new String[] {"listdata.csv"};
    //
    //
    //
    //
    Backend dummy = new Backend(args); // switch to real backend
    //
    //
    //
    //
    Frontend frontend = new Frontend();
    //
    //
    //
    frontend.netProfit = dummy.dailyProfit(); // switch to real backend
    //
    //
    //
    frontend.run(dummy);// replace with real backend
  }
  
  public void run(Backend back) { // replace with real backend
    dummy = back; 
    boolean done = false;
    while(!done) {
      clearScreen();
      String toDo = printHeader();
      printMode(toDo);
      if(toDo.equals("x")) 
        done = true;   
    }
    return;
  }
  
  public String printHeader() {
    System.out.println("+--------------------------------------------+");
    System.out.println("|              Welcome to Our                |");
    System.out.println("|      TreeMart™ Inventory Application       |");
    System.out.println("+--------------------------------------------+");
    System.out.println("What Would You Like To Do?\n------------------------------------");
    System.out.println("Update Invetory(u)\nPrint Menu(p)\nExit(x)");
    String input = sc.next();
    input = valid(input, "Main", sc);
    return input;
  }
  
  public void printMode(String i) {
    clearScreen();
    if(i.equals("u")) {
      System.out.println("+--------------------------------------------+");
      System.out.println("|                  Update                    |");
      System.out.println("|             Inventory  Menu                |");
      System.out.println("+--------------------------------------------+");
      this.updateInventoryMenu();
    }
    if(i.equals("p")) {
      System.out.println("+--------------------------------------------+");
      System.out.println("|                Print Menu                  |");
      System.out.println("+--------------------------------------------+");
      this.printMenu();
    }
    if(i.equals("x")) { 
        System.out.println("+--------------------------------------------+");
        System.out.println("|              Have a Good Day!              |");
        System.out.println("+--------------------------------------------+");
        if(changed == null) {
          System.out.println("Products Changed In This Session: NONE");
        } else {
          System.out.println("Products Changed In This Session: ");
          for(int j = 0; j < changed.size(); j++) 
            System.out.println(changed.get(j).getName());          
        }
        System.out.println("Net Profit: " + netProfit);
    }
  }
  
  public void clearScreen() {
    for (int i = 0; i < 50; ++i)
      System.out.println();
  }
  
  public String valid(String input, String menu, Scanner sc) {    
    if(menu.equals("Main")) {
      while(!input.equals("u") && !input.equals("p") && !input.equals("x")) {
        System.out.println("Please Enter a Valid Option");
        input = sc.next();
      }

    }
    if(menu.equals("Update")) {
      while(!input.equals("i") && !input.equals("d") && !input.equals("a") && !input.equals("x")) {
        System.out.println("Please Enter a Valid Option");
        input = sc.next();
      }
    }
    if(menu.equals("Adding")) {
      while(!input.equals("y") && !input.equals("n")) {
        System.out.println("Please Enter a Valid Option");
        input = sc.next();
      }
    }
    if(menu.equals("Print")) {
      while(!input.equals("l") && !input.equals("f") && !input.equals("s") && !input.equals("x")) {
        System.out.println("Please Enter a Valid Option");
        input = sc.next();
      }
    }
    return input; 
  }
  
  public void updateInventoryMenu() {
    System.out.println("What Would You Like To Do?\n------------------------------------");
    System.out.println("Restock(i)\nDestock(d)\nAdd New Item(a)\nReturn To Main Menu(x)");
    String input = sc.next();
    input = valid(input, "Update", sc);
    if(input.equals("i")) {
      clearScreen();
      //
      //
      //
      lowProducts = dummy.needsRestock(3);
      for(int i = 0; i < 3; i++) {
  // change to the real list that needs restocking (lowProducts = backend.needsRestock())
        System.out.println(lowProducts.get(i));
      }
      //
      //
      //
      System.out.println("Which Existing Item Would You Like Increase?\n------------------------------------");
      String input1 = sc.next();
      clearScreen();
      System.out.println("How Much Would You Like To Increase(Integer) " + input1 + " by?\n------------------------------------");
      int input2 = sc.nextInt();
      //
      //
      //
      boolean worked = dummy.restock(input1, input2); // change to real backend
      //
      //
      //
      if(worked) {
        clearScreen();
        //
        //
        //
        changed.add(dummy.getProduct(input1)); // change to real backend
        //
        //
        //
        System.out.println(input1 + " Was Successfully Restocked by " + input2 + "\n------------------------------------");
        System.out.println("------------------------------------\nType Anything To Continue");
        String anything = sc.next();
        printMode("u");
      } else {
        clearScreen();
        System.out.println(input1 + " Was Unsuccessfully Restocked As The Item In Not Within The System" + "\n------------------------------------");
        System.out.println("Type Anything To Continue");
        String anything = sc.next();
        printMode("u");
      }
    }
    if(input.equals("d")) {
      clearScreen();
      System.out.println("Which Existing Item Would You Like to Decrease(Integer)?\n------------------------------------");
      String input1 = sc.next();
      System.out.println("How Much Would You Like To Sell?\n------------------------------------");
      int input2 = sc.nextInt();
      //
      //
      //
      if(dummy.getProduct(input1) != null) {
        dummy.sell(input1, input2);  //replace with real backend
        changed.add(dummy.getProduct(input1)); //replace with real backend
      }
      //
      //
      //
      else {
        clearScreen();
        System.out.println(input1 + " Was Unsuccessfully Destocked As The Item In Not Within The System" + "\n------------------------------------");
        System.out.println("Type Anything To Continue");
        String anything = sc.next();
        printMode("u");
      }
    }
    if(input.equals("a")) {
      clearScreen();
      System.out.println("What Is The Name of The New Product You Would Like to Add?\n------------------------------------");
      String name = sc.next();
      clearScreen();
      System.out.println("How Many " + name + "(s) Are You Adding?\n------------------------------------");
      int amount = sc.nextInt();
      clearScreen();
      System.out.println("How Much Is Each " + name + " Worth?\n------------------------------------");
      Double cost = sc.nextDouble();
      clearScreen();
      System.out.println("At What Retail Price Will " + name +" Be Sold For?\n------------------------------------");      
      Double retail = sc.nextDouble();
      //
      //
      //
      Product fresh = new Product(dummy.newProductID(), name, 0, amount, cost, retail); // switch to real backend
      //
      //
      //
      System.out.println("Are You Sure You Want To Add " + fresh.toString() + "?(y or n)\n------------------------------------");
      String answer = sc.next();
      answer = valid(answer, "Adding", sc);
      if(answer.equals("y")) {
        //
        //
        dummy.addProduct(fresh);                        //
        changed.add(fresh);            // replace with real backend
        this.allProducts = dummy.getAllProducts();      //
        //
        //
        //
      }
      if(answer.equals("n")) 
        printMode("u");
      
    }
    if(input.equals("x")) 
      return;   
  }
  public void printMenu() {
    System.out.println("What would you like to do?\n------------------------------------");
    System.out.println("Look Up Item(l)\nPrint All Products to CSV file(f)\nSummary of Session(s)\nReturn To Main Menu(x)");
    String input = sc.next();
    input = valid(input, "Print", sc);
    if(input.equals("l")) {
      clearScreen();
      System.out.println("Please Insert the Name(String) of the Product You Are Looking For\n------------------------------------");
      String input1 = sc.next();
      //
      //
      //
      while(dummy.getProduct(input1) == null) { // replace with real backend
        System.out.println("Please Enter The Name of a Product That Exists\n------------------------------------");
        input1 = sc.next();
      }
      //
      //
      //
      //
      ProductInterface got = dummy.getProduct(input1); // replace with real backend
      //
      //
      //
      System.out.println(got.toString());
      System.out.println("------------------------------------\nType Anything To Continue");
      input = sc.next();
      printMode("p");
    }
    if(input.equals("f")) {
      clearScreen();
      System.out.println("Print Inventory To .csv File\n");
      System.out.println(
          "\nWould You Like To Update The .csv File To Reflect Your New Inventory?\n(Type 'y' or 'n')");
      if (sc.hasNext()) {
        char response = sc.next().charAt(0);
        while (response != 'y' && response != 'n') {
          System.out.println("Invalid Response. (Type 'y' or 'n')");
          response = sc.next().charAt(0);
        }
        if (response == 'y') {
          boolean wrote = filePrinter();
          if(wrote) {
            for(int i = 0; i < allProducts.size(); i++) {
              System.out.println(allProducts.get(i).toString());
            }
            System.out.println("File Successfully Updated. Type Anything To Continue");
            String in = sc.next(); 
          } else {
            System.out.println("File Unsuccessfully Updated. Type Anything To Continue");
            String in = sc.next();  
          }
        }
        printMode("p");
        return;        
      }
    }
    if(input.equals("s")) {
      clearScreen();
      System.out.println("During This Session, The Following Products Were Changed:\n------------------------------------");
      if(changed == null) {
        System.out.println("Products Changed In This Session: NONE");
      } else { 
        for(int i = 0; i < changed.size(); i++) 
          System.out.println(changed.get(i).getName());      
      }
      //
      //
      //      
      netProfit = dummy.dailyProfit();      
      //
      //
      //
      System.out.println("The Current Net Profit is: " + netProfit);
      System.out.println("------------------------------------\nType Anything To Continue");
      String anything = sc.next();
      printMode("p");
    }
    if(input.equals("x")) 
      return;   
  }
  public boolean filePrinter() {
    //
    //
    //
    //
    boolean wrote = dummy.printToCSV(); // switch to real backend
    //
    //
    //
    String[] args = new String[] {"inventory.csv"};
    //
    //
    //
    dummy = new Backend(args); // switch to real backend
    allProducts = dummy.getAllProducts();
    //
    //
    return wrote;
  }
  //
  // You will have to add this method to the backend class for filePrinter() to work.
  //
  /**public boolean printToCSV() {
    try {
      final String CSV_FILE_NAME = "inventory.csv";
      FileWriter myWriter = new FileWriter(CSV_FILE_NAME);
      for (ProductInterface p : this.getAllProducts()) {
        myWriter.write(p.getID() + "," + p.getName() + "," + p.getQuantityAvailable() + ","
            + p.getQuantitySold() + "," + String.format("%.2f", p.getCost()) + ","
            + String.format("%.2f", p.getRetailPrice()) + "\n");
      }
      myWriter.close();
      return true;
    } catch (IOException e) {
      return false;
    }
  }
  */
}
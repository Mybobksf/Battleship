import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    // This array contains the grid
    String[][] user_grid = new String[10][10];
    for (int i = 0; i < user_grid.length; i++) {
      for (int j = 0; j < user_grid.length; j++) {
        user_grid[i][j] = "*";
      }
    }

    // This array that contains all the targets
    String[][] user_targets = new String[10][10];
    user_targets[4][2] = "x";
    user_targets[3][1] = "O";
    user_targets[4][1] = "-";
    user_targets[6][1] = "x";
    user_targets[7][1] = "-";
    user_targets[6][2] = "x";
    user_targets[5][1] = "O";
    user_targets[5][3] = "x";
    user_targets[5][2] = "-";

    // These 2 variables contains how many times you hit or miss the target. If you hit a target, hits will go up by one but if you miss the target, the misses will go up by one
    int hits = 0;
    int misses = 0;

    while (true) {
      // The code in this while loop makes the user guess the row and column.
      PrintingGrid(user_grid);
      System.out.print("What row do you want to attack? ");
      Scanner scanned = new Scanner(System.in);
      int row = scanned.nextInt();
      System.out.print("What column do you want to attack? ");
      Scanner scanning = new Scanner(System.in);
      int column = scanning.nextInt();

      // If the user guesses the correct target, hits will go up by one and it'll

      if (user_targets[row][column] == "x") {
        user_grid[row][column] = "x";
        hits += 1;
        PrintingGrid(user_grid);
        System.out.println("You hit a target.");
        System.out.println("You hit " + hits + " targets");
      } else if (user_targets[row][column] == "O") {
        user_grid[row][column] = "O";
        hits += 1;
        PrintingGrid(user_grid);
        System.out.println("You hit a target.");
        System.out.println("You hit " + hits + " targets");
      } else if (user_targets[row][column] == "-") {
        user_grid[row][column] = "-";
        hits += 1;
        PrintingGrid(user_grid);
        System.out.println("You hit a target.");
        System.out.println("You hit " + hits + " targets");
      }
      // If the user gets the wrong target, misses will go up by one and it'll inform the user that they hit the wrong target

      else {
        misses += 1;
        System.out.println("You missed " + misses + " target ");
        System.out.println("Try again");
      }

      // To avoid the user getting frustrated, if the user misses 3 times, they can get a hint or leave the game

      if (misses == 3) {
        System.out.print("Do you want a hint? ");
        Scanner scanner = new Scanner(System.in);
        String hint = scanner.next();

        if (hint.equalsIgnoreCase("yes")) {
          System.out.println("One of the target is in row 7");
          misses = 0;
        } else {
          System.out.println("You missed the 3 targets so you lost the game.");
          break;
        }
      }

      // If they hit all the targets, they win
      if (hits == 9) {
        System.out.println("You win!");
        break;
      }
    }
  }

  public static void PrintingGrid(String[][] twentybytwenty) {

    // This method prints the whole grid

    System.out.print("   ");
    for (int i = 0; i < 10; i++) {
      System.out.print(i + "  ");
    }
    System.out.println();
    for (int i = 0; i < twentybytwenty.length; i++) {
      System.out.print(i + "  ");
      for (int j = 0; j < twentybytwenty.length; j++) {
        System.out.print(twentybytwenty[i][j] + "  ");
      }
      System.out.println();
    }
  }
}
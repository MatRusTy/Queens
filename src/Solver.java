import java.util.*;

public class Solver {

    /**
     * Calculates the solution to the n queens problem.
     *
     * @author Mathias og Kasper
     * @version 1.0
     */

    private int noOfQueens; //Amount of queens
    private int[] queens; //Array with an element for each row and an integer value representing the column placement of that particular queen.
    private int noOfSolutions;
    private boolean showSolutions = true; //Specifies if the solutions should be printed to the terminal.
    private long duration;

    public static void main(String args[]) {
        testSolver();
    }

    public static void testSolver() {
        Solver sol = new Solver();

        sol.findAllSolutions(1);
        sol.findAllSolutions(2);
        sol.findAllSolutions(6);

        sol.findNoOfSolutions(1, 12);
    }

    /**
     * Constructor for objects of class Solver
     */
    public Solver() {

    }

    /**
     * Inserts a specific number of queens and prints all possible solutions, and the runtime of the method.
     *
     * @param noOfQueens - Takes the amount of queens to place as a parameter.
     */
    public void findAllSolutions(int noOfQueens) {
        if(showSolutions) {
            System.out.println("*********************************************");
            System.out.println("Solutions for " + noOfQueens + " queens:");
            System.out.println();
        }

        long timeBefore = System.currentTimeMillis();

        noOfSolutions = 0;
        this.noOfQueens = noOfQueens;
        queens = new int[noOfQueens]; //Creates new queens array of size noOfQueens
        positionQueens(0);

        long timeAfter = System.currentTimeMillis();
        long time = timeAfter - timeBefore; //Time for execution of calculations in ms.

        duration = time; //Sets the field variable duration, so that it can be used in findNoOfSolutions for calculations.

        if(showSolutions) {
            System.out.println();
            System.out.println("A total of " + noOfSolutions + " were found in " + time + " ms");
            System.out.println("*********************************************");
            System.out.println();
        }
        //Test af hvor mange dronninger som man kan finde løsninger for efter 3 minutter.
        //15 dronninger tog 88,777 sekunder.
        //16 dronninger tog 24,76305 minutter
        //Derfor kan man inden for 3 minutter højst finde løsningerne for 15 dronninger.
        //Testet med Intel i5-4590 CPU @ 3.30 GHz
    }

    /**
     * Runs through the findAllSolutions with a specified interval of queens and creates a table detailing the solutions.
     *
     * @param min - Takes the lower limit of the interval to create a table over.
     * @param max - Takes the upper limit of the interval to create a table over.
     */
    public void findNoOfSolutions(int min, int max) {
        showSolutions = false;

        System.out.println("*********************************************");
        System.out.println("Queens" + "    Solutions " + "  Time(ms) " + " Solutions/ms");
        for(int i = min; i <= max; i++) {

            findAllSolutions(i);

            System.out.format("  %3d %,12d   %,8d      %,8d %n", noOfQueens, noOfSolutions, duration+1, noOfSolutions/(duration+1));
        }
        System.out.println("*********************************************");
        System.out.println();

        showSolutions = true;
    }

    /**
     * Positions a queen in the row specified in the parameter.
     *
     * @param row - The row to place the queen in.
     */
    private void positionQueens(int row) {

        for (int i = 0; i < noOfQueens; i++) { //Runs through the columns to check which column the queen can be placed in.
            if (legal(row, i)) { //Tests if column i is legal
                queens[row] = i;

                if (!(row == noOfQueens-1)) {
                    positionQueens(row + 1);
                } else {

                    if(showSolutions) {
                        printSolution();
                    }
                    noOfSolutions++;
                }
            }
        }
    }

    /**
     * Checks if the current position (row and column values) of a queen is legal.
     *
     * @param row - The row that our queen, which we are checking for, is in.
     * @param col - The column that our queen, which we are checking for, is in.
     * @return boolean - This boolean evaluates to true if the queen is allowed to be placed in the particular row.
     */
    private boolean legal(int row, int col) {

        for(int i = 1; i <= row; i++) { //i represents how many rows we are under the row that our queen, which we are checking for, is in.
            int currentRow = (row-i);
            if(queens[currentRow] == col || queens[currentRow] == col-i || queens[currentRow] == col+i){
                return false;
            }
        }
        return true;
    }

    /**
     * Prints a solution
     */
    private void printSolution() {

        for(int row = 0; row < noOfQueens; row++) {
            System.out.print(convert(row,queens[row]) + " ");
        }
        System.out.println();
    }

    /**
     * Converts the row and column to a traditional chess notation.
     *
     * @param row - Current row
     * @param col - Current column
     * @return String - Returns string representation of a square.
     */
    private String convert(int row, int col) {
        char[] library = new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','x','y','z'};
        return  library[col] + "" +  (row + 1);
    }
}
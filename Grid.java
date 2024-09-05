// Asif Chowdhury -- Project 2 {MineSweeper};
// Professor Eva Sofianos
// Due Date: 11/30/2023

// YouTube Link: https://youtu.be/m9Kew2x2frQ

import java.util.Random;

public class Grid {    
    private int numRows;
    private int numColumns;
    private int numBombs;
    private boolean[][] bombGrid;
    private int[][] countGrid;

    public Grid() {
        numRows = 10;
        numColumns = 10;
        numBombs = 25;
        bombGrid = new boolean[numRows][numColumns];
        countGrid = new int[numRows][numColumns];
        createBombGrid();
        createCountGrid();
    }

    public Grid(int rows, int columns) {
        numRows = rows;
        numColumns = columns;
        numBombs = 25;
        bombGrid = new boolean[numRows][numColumns];
        countGrid = new int[numRows][numColumns];
        createBombGrid();
        createCountGrid();
    }

    public Grid(int rows, int columns, int bombs) {
        numRows = rows;
        numColumns = columns;
        numBombs = bombs;
        bombGrid = new boolean[numRows][numColumns];
        countGrid = new int[numRows][numColumns];
        createBombGrid();
        createCountGrid();
    }

    public int getNumRows() {
        return numRows;
    }

    public int getNumColumns() {
        return numColumns;
    }

    public int getNumBombs() {
        return numBombs;
    }

    public boolean[][] getBombGrid() {
        boolean[][] bombGridClone = new boolean[numRows][numColumns];
        for(int i = 0; i < numRows; i++) {
            for (int j = 0; j < numColumns; j++) {bombGridClone[i][j] = bombGrid[i][j];}
        }
        return bombGridClone;
    }

    public int[][] getCountGrid() {
        int[][] countGridClone = new int[numRows][numColumns];
        for(int i = 0; i < numRows; i++) {
            for (int j = 0; j < numColumns; j++) {countGridClone[i][j] = countGrid[i][j];}
        }
        return countGridClone;
    }

    public boolean isBombAtLocation(int row, int column) {
        return bombGrid[row][column];
    }
    
    public int getCountAtLocation(int row, int column) {
        return countGrid[row][column];
    }

    public void revealBombLocation(int row, int column) {
        
    }

    public void createBombGrid() {
        for(int i = 0; i < numRows; i++) {
            for(int j = 0; j < numColumns; j++) {
                bombGrid[i][j] = false;
            }
        }

        Random random = new Random();

        for(int k = 0; k < numBombs; k++) {
            int i = random.nextInt(numRows); 
            int j = random.nextInt(numColumns);
    
            while(bombGrid[i][j]) {
                i = random.nextInt(numRows);
                j = random.nextInt(numColumns);
            }
    
            bombGrid[i][j] = true;
        }   
    }

    public void createCountGrid() {

        // Fields for box positions

        boolean center;
        boolean left;
        boolean right;
        boolean topLeft;
        boolean topRight;
        boolean top;
        boolean bottom;
        boolean bottomLeft;
        boolean bottomRight;
        
        
        for(int row = 0; row < numRows; row++) {
            for(int column = 0; column < numColumns; column++) {

                int count = 0;

                center = bombGrid[row][column];
                if (center) {count++;} 

                if(column - 1 >= 0) {
                    left = bombGrid[row][column - 1];
                        if (left) {count++;} 
                }

                if(column + 1 < numColumns) {
                    right = bombGrid[row][column + 1];
                        if(right) {count++;} 
                }

                if(row - 1 >= 0 && column - 1 >= 0) {
                    topLeft = bombGrid[row - 1][column - 1];
                        if(topLeft) {count++;} 
                }

                if(row - 1 >= 0 && column + 1 < numColumns) {
                    topRight = bombGrid[row - 1][column + 1];
                        if(topRight) {count++;} 
                }

                if(row - 1 >= 0) {
                    top = bombGrid[row - 1][column];
                        if(top) {count++;} 
                }

                if(row + 1 < numRows) {
                    bottom = bombGrid[row + 1][column];
                        if(bottom) {count++;} 
                }

                if(row + 1 < numRows && column + 1 < numColumns) {
                    bottomRight = bombGrid[row + 1][column + 1];
                        if(bottomRight) {count++;} 
                }

                if(row + 1 < numRows && column - 1 >= 0) {
                    bottomLeft = bombGrid[row + 1][column - 1];
                    if(bottomLeft) {count++;} 
                }
        
                countGrid[row][column] = count; 
            }
        }
    }
}




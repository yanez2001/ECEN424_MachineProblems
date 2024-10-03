package MP2;
/* Yanez Saucedo, Nick Caso 
 * Texas A&M University - Fall 2024
 * ECEN424 Machine Probelm 2
 * 
 * An Aggie does not lie, cheat or steal or tolerate those who do.
 * 
 * Problem Statement:
 * In this assignment, you will implement a multithreaded version of matrix multiplication. 
 * The normal method  for multiplying two such matrices involves performing all the 
 * calculations in the main thread. Each element (i, j) of the product matrix is obtained 
 * by multiplying the ith row of the first matrix with the jth column of the second. In 
 * the multithreaded version, you will divide this computation among threads to achieve 
 * parallelism. Initialize two 20 × 20 matrices with random values. Create five threads. 
 * Each thread will compute 1/5th of the product matrix. So the first thread calculates the 
 * product elements for the first four rows, the second for the next four rows and so on. 
 * The main thread should wait for all the threads to complete, and then print the resultant 
 * product matrix. Verify that this produces the same result as the normal method.
*/

import java.util.Random;

class matrixMultiplication implements Runnable {
    public double[][] A;  // First matrix
    private double[][] B;  // Second matrix
    private double[][] resultant;  // Resultant matrix (product)
    private int initialRow; // Starting row for this thread
    private int lastRow;   // Ending row for this thread

    // Constructor to initialize the thread with a portion of work
    public matrixMultiplication(double[][] A, double[][] B, double[][] resultant, int initialRow, int lastRow) {
        this.A = A;
        this.B = B;
        this.resultant = resultant;
        this.initialRow = initialRow;
        this.lastRow = lastRow;
    }

    @Override
    public void run() {
        // Perform matrix multiplication for the assigned rows
        for (int i = initialRow; i < lastRow; i++) {
            for (int j = 0; j < 20; j++) {
                resultant[i][j] = 0; // Initialize element
                for (int k = 0; k < 20; k++) {
                    resultant[i][j] += A[i][k] * B[k][j];
                }
            }
        }
    }
}

public class multiThreading extends Thread
{
    public static void main(String[] args) 
    {
        // initialize the matrices size
        double[][] A = new double[20][20];
        double[][] B = new double[20][20];
        double[][] resultant = new  double [20][20];

        // generate randomness for matrices
        Random rand = new Random();
        for(int i = 0; i < 20; i++){
            for(int j = 0; j < 20; j++){
                A[i][j] = rand.nextDouble();
                B[i][j] = rand.nextDouble();
            }
        }

        Thread[] threads = new Thread[5];

        int n = 5; // the number of threads needed
        for(int i = 0; i < n; i++)
        {
            int initialRow = i * 4;
            int lastRow = (i + 1) * 4;

            threads[i] = new Thread(new matrixMultiplication(A, B, resultant, initialRow, lastRow)); /
            threads[i].start(); 
        }
        // wait for threads to compute using join()
        for (int i = 0; i < 5; i++) {
            try {
                threads[i].join(); // Wait for the thread to finish
            } catch (InterruptedException e) {
                System.out.println("Main thread was interrupted.");
            }
        }

        // print out the matrix
        System.out.println ("This is the resultant matrix: ");
        printMatrix(resultant);
    }

    public static void printMatrix(double[][] matrix)
    {
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length; j++){
                // print out the matrix
                System.out.printf("%.2f", matrix[i][j]);
            }
        }
    }
}



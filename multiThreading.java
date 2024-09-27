/* Yanez Saucedo, Nick ___ 
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

class matrixMultiplication
{
    // generate randomness
    Random rand = new Random();

    // matrix multiplication
    for(int i = 0; i < 20; i++){
        for(int j = 0; j < 20; j++){
            // fix
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
        Radnom rand = new Random();
        for(int i = 0; i < 20; i++){
            for(j = 0; j < 20; j++){
                A[i][j] = rand.nextDouble();
                B[i][j] = rand.nextDouble();
            }
        }

        int n = 5; // the number of threads needed
        for(int i = 0; i < n; i++)
        {
            //threading here
        }

        // print out the matrix
        System.out.println('This is the resultant matrix: ');
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
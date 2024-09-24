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
class matrixMultiplication
{
    
}
public class multiThreading
{
    public static void main(String[] args) 
    {
        int n = 5; // the number of threads needed
        for(int i = 0; i < n; i++)
        {
            //threading here
        }
    }
}
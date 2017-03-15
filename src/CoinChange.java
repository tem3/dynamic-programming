import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CoinChange {
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        Scanner in = new Scanner(System.in);
        int change = in.nextInt();
        int numTypes = in.nextInt();
        int[] coinValues = new int[numTypes];
        for(int i = 0; i < numTypes; i++) {
            coinValues[i] = in.nextInt();
        }
       
    }
}

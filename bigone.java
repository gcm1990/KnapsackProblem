import java.util.Scanner;

/****************************************************************************Assignment 4*******************************************************************************************
 * 
 *                                                                         Author:Gavin Murray
 *                                                                             
 *                                                                           Class: COP3530
 *                         
 *                                                            This code uses recursion to solve the Knapsack Problem.
 *///---------------------------------------------------------------------------------------------------------------------------------------------------------------------------\\\

public class n01062011 {

	public static void main  (String[] args) {
		
		Scanner input, myScan;
		String userInput="";
		int i=0;
		int trgt = 0;            
		int[]a={};                  
		int[]b={};   
		Knapsack ks;
		                             
		String.


System.out.println("Type the capacity of the knapsack followed by the weights available to put into it.(Greatest to least, 100lbs max, 25 weights at the most)");

input= new Scanner(System.in);

userInput = input.nextLine();

myScan = new Scanner(userInput);
if(myScan.hasNextInt()){  //Make sure input is an integer to avoid io mismatch exception
while (myScan.hasNextInt()){
if (i==0)
	trgt=myScan.nextInt();
a=Knapsack.expand(a, a.length+1);
a[i]=myScan.nextInt();
i++;
}

input.close();
myScan.close();


ks = new Knapsack(a);

System.out.println("The solutions are the following:");

ks.scale(trgt,b, 0, 0); //This calls the recursive method that prints the solution to the Knapsack problem. 
System.out.println();
	

}



}


}
	
	


class Knapsack{
private int contents[];	
private int k=0; // This counts the number of times toString is used, to indicate no solutions if equal to 0. 

	Knapsack(int[] newContents){
contents = new int[newContents.length];
contents=newContents;


	
}

private void toString(int[] a){
	if (a.length==0)
		return;
	else{
	for(int i=0; i<a.length;i++){
			System.out.print(a[i]+" ");
	}
	System.out.println("");
	}
	k++;  //
}

private static void copy(int a[], int b[]){ //a is copied to b
	if (b.length==0)
		return;
	for(int i=0; i<a.length;i++){
		b[i]=a[i];
		}

}

public static int[] expand(int a[], int size){
int[] b = new int[size];  //increases array size
copy(a,b);
return b;

}

public void scale(int target,int[]oldAry, int i, int j ){
	  
	   
	    int[] newAry = expand(oldAry,j+1);                  //Set up a larger array for storage. I.e. make a new spot. 
	    int current = contents[i];                            
		newAry[j]=current;                                  //Fill new spot with the current weight
		if((newAry[j]==target))        
			toString(newAry);  
		if(i+1<contents.length){
			if(newAry[j]<target){
			   scale((target-current), newAry, i+1, j+1);    //When current is less than the target, it is safe to store it            
		}
			scale(target, oldAry, i+1, j);                   //Whether current is greater or less than the target, it is safe to omit it. 
		}
		else{
			if((k==0)&&(i+1==contents.length)&&(j==0))
					System.out.println("No solutions found.");
			return;                                          //When current is greater than the target, and it's the last weight, no more solutions.  
		}
		
}


}









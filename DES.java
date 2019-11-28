/**
 * 
 */

/**
 * @author Ananta Bhatt
 * Problem:1.b
 *
 */
public class DES {
	//Initialising the values
	public static int[][] sbox1= {{15,1,8,14,6,11,3,4,9,7,2,13,12,0,5,10},
			{3,13,4,7,15,2,8,14,12,0,1,10,6,9,11,5},
			{0,14,7,11,10,4,13,1,5,8,12,6,9,3,2,15},
			{13,8,10,1,3,15,4,2,11,6,7,12,0,5,14,9}};
	public static int[][] sbox2= {{7,13,14,3,0,6,9,10,1,2,8,5,11,12,4,15},
			{13,8,11,5,6,15,0,3,4,7,2,12,1,10,14,9},
			{10,6,9,0,12,11,7,13,15,1,3,14,5,2,8,4},
			{3,15,0,6,10,1,13,8,9,4,5,11,12,7,2,4}};
	
	//Padding to 8 bit string to 12 bit input
	public static int[] padding_even (int[] input)
	{
		int[] paddedInput = new int[12];
	
		for(int i=0 ; i< 8 ; i++)
		paddedInput[i]= input[i];
		
		for(int i=8, j=0; i< 12; i++, j+=2)
			paddedInput[i]= input[j+1];
		
		return paddedInput;
	}
	
	//Dividing into 6 bits and finding the row and column according to sbox1
	public static int[] sbox1(int[] exor)
	{
		for(int i=0; i<12; i++)
			System.out.print(exor[i]);
		int m=exor.length/2;
		int [] exor1 = new int[6];
		for(int i=0;i<m-1;i++)
		{
		exor1[i]=exor[i];
		}
		String concat = Integer.toString(exor1[0]) + Integer.toString(exor1[5]);
		System.out.println();
		System.out.print("\nConcatinated Binary value of rows from S-box1: "+concat);
		int concat_value = Integer.parseInt(concat);
		int rows=0,p=0;
	    
	    while(concat_value!=0)
	    {
	    	rows+=((concat_value%10)*Math.pow(2,p));
	    	concat_value=concat_value/10;
	        p++;
	    }
	    System.out.println();
	    System.out.println("\nRow Integer value:"+ rows);
	    String concat2 = Integer.toString(exor1[1]) + Integer.toString(exor1[2])+ Integer.toString(exor1[3])+ Integer.toString(exor1[4]);
		System.out.println("\nConcatinated Binary value of column from S-box1: "+concat2);
		int concat_value2 = Integer.parseInt(concat2);
	    int column=0,q=0;
	    
	    while(concat_value2!=0)
	    {
	    	column+=((concat_value2%10)*Math.pow(2,q));
	    	concat_value2=concat_value2/10;
	        q++;
	    }
	    System.out.println("\nColumn Integer value:"+ column);
	    int output=sbox1[rows][column];
	    System.out.println("\nSbox-1 Output in Decimal:"+ output);
	    int[] bin=convertBinary(output);
		return bin;

	}
	//Dividing into 6 bits and finding the row and column according to sbox2
	public static int[] sbox2(int[] exor)
	{
		int [] exor2=new int[6];

		
		int count=0;
		for(int i=6;i<12;i++)
		{
			
		exor2[count]=exor[i];
		count++;
		}
		String concat = Integer.toString(exor2[0]) + Integer.toString(exor2[5]);
		System.out.println("\nConcatinated binary value of row from S-box2: "+concat);
		int concat_value = Integer.parseInt(concat);
		int rows=0,p=0;
		while(concat_value!=0)
	    {
	    	rows+=((concat_value%10)*Math.pow(2,p));
	    	concat_value=concat_value/10;
	        p++;
	    }
	    System.out.println("\nRow Integer value:"+ rows);
	    String concat2 = Integer.toString(exor2[1]) + Integer.toString(exor2[2])+ Integer.toString(exor2[3])+ Integer.toString(exor2[4]);
		System.out.print("\nConcatinated Binary value of column from S-box2: "+concat2);
		int concat_value2 = Integer.parseInt(concat2);
	    int column=0,q=0;
	    
	    while(concat_value2!=0)
	    {
	    	column+=((concat_value2%10)*Math.pow(2,q));
	    	concat_value2=concat_value2/10;
	        q++;
	    }
	    System.out.println();
	    System.out.println("\nColumn Integer value:"+ column);
	    int output=sbox2[rows][column];
	    System.out.println("\nFinal Output in Decimal:"+ output);
	    int[] bin=convertBinary(output);
		return bin ;
	}
	
	//Converting decimal into binary
	public static int[] convertBinary(int no) {
	    int i = 0, temp[] = new int[4];
	    int binary[];
	    while (no > 0) {
	        temp[i++] = no % 2;
	        no /= 2;
	    }
	    binary = new int[4];
	    int k = 0;
	    for (int j = i - 1; j >= 0; j--) {
	        binary[k++] = temp[j];
	    }
	  
	    
	    return binary;
	}
	//Performs exor function on paddedInput and key
	public static int[] exor_input(int [] paddedInput,int[] key) {
		int[] exor = new int[12];
		for (int i=0; i<12; i++)
		exor[i] = paddedInput[i] ^ key[i];
		
		System.out.println("\nThe exored Input is: ");
	    
	    return exor;
	}
	public static void main(String args[])
	{
			int [] b= {1,0,1,1,0,1,0,1};
	int [] key = {0,0,1,1,0,1,0,0,1,1,1,1};
	int [] paddedInput = new int [12];
	paddedInput= padding_even (b);
	System.out.print("The padded Input is: ");
	for(int i=0; i<12; i++)
		System.out.print(paddedInput[i]);
	System.out.println();

	int[] exor = new int[12];
	exor=exor_input(paddedInput,key);
	int[] sbox1_output= sbox1(exor);
	int[] sbox2_output= sbox2(exor);
	
	
	System.out.println("\nThe Final 8-bit String Output from two S-boxes is: " );
	for(int i=0;i<4;i++)
	{
		System.out.print(sbox1_output[i]);
	}
	for(int i=0;i<4;i++)
	{
		System.out.print(sbox2_output[i]);
	}

    
}
}
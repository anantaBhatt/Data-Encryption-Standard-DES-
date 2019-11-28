# Data-Encryption-Standard-DES-

Solution:
Software: Eclipse Java Oxygen, Version: Oxygen.2 Release (4.7.2)
Programming Language: Java Language
Compiler: jdk-9.0.4

Step 1: Initialisation:
Bitstring b of length 8, key, sboxes according to the given value.

Step 2: Padding Even bit to b:
Pad the b bitstring according to the even position of the block making the block 12 bit in length.

Step 3:Exor padded b bitstring and key:
Perform exor operation on each element of the padded input and the key.

Step 4: Call sbox1 function:
The exored value is passed and divided into 6bit length. Further, to find the row value the element at position 0 and position 5 is concatenated. This is further converted to integer value. The column value is found by considering elements at position-1,2,3,4. The value stored at sbox1 position of the row and column are returned in binary form

Step 5: Call sbox2 function:
Step 5 is similar to step4, instead of sbox1 value stored at sbox2 position of calculated row and column is returned in binary f

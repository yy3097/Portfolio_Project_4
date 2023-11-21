# Portfolio Project: Huffman Coding
This repository is part of the portfolio uses for SFU MDM application only. 

This project is a homework from the computer programming course I took during my undergraduate study. All codes are completed in Java.


## Project Description
This is a program working as a simple version of the Huffman coding algorithm devised by David A. Huffman for compressing text data to make a file occupy a smaller number of bytes.


## Work Done
I completed HuffmanTree.java and HuffmanNode.java files. The other files were provided by course instructor.


## File Description
**HuffmanTree:** a class that constructs a tree of character frequencies that can manage a Huffman code for a particular file using the Huffman algorithm. 

**HuffmanNode:** a class that stores information of one character.

**MakeCode:** a client program that is uses for create a .code file of a .txt file. 

**Encode:** a client program that is uses for encode a .txt file to a compressed .short file using its .code file. 

**Decode:** a client program that is uses for decode a compressed .short file to a .txt file using its .code file. 

**BitInputStream:** a helping class for reading input one bit at a time. 

**BitOutputStream:** a helping class for writing output one bit at a time. 

**Other files:** the input text files, sample compressed files (in .code and .short forms) and sample compressed bytes files. 



## Outcome
MakeCode takes a .txt file as input and will generate a .code file. Encode takes both the original .txt file and its .code file and will generate a compressed file in .short form. Decode takes the encoded .short file and its .code file and will generate a decompressed .txt file. 

// Yao Yi
// 12/10/2015
// CSE 143 AC 
// TA: LATHE,CHLOE M.  
// 
// This class manages a huffman code for a particular file using the huffman algorithm. 
// It can compress characters into codes or decompress codes into characters. 

import java.util.*;
import java.io.*;

public class HuffmanTree {
   private HuffmanNode myRoot; 
   
   // pre: pass in a integer array of frequencies of certain characters appears.
   // post: initialize a new HuffmanTree over the given data. 
   public HuffmanTree(int[] counts) {
      Queue<HuffmanNode> orderData = new PriorityQueue<HuffmanNode>();
      for (int i = 0; i < counts.length; i++) {
			if (counts[i] != 0) {
				orderData.add(new HuffmanNode(counts[i], i));
			}
		} // order the data. 
      orderData.add(new HuffmanNode(1, counts.length)); // introduce ¡°end of file¡± character. 
      while (orderData.size() > 1) {
			HuffmanNode left = orderData.remove();
			HuffmanNode right = orderData.remove();
			HuffmanNode newNode = new HuffmanNode(left.frequency + right.frequency, -1, left, right);
			orderData.add(newNode);
		}
		myRoot = orderData.remove();     
   }
      
   // pre: pass in PrintStream object to write out the code. 
   // post: write the code to the given output stream in standard format by traversal order. 
   public void write(PrintStream output) {
      saveFile(myRoot, output, ""); 
   }
   
   // pre: pass in a HuffmanNode represents the current node works on, the PrintStream object 
   //      to write out the code, and a String to record the code. 
   // post: write the code to the given output stream in standard format by traversal order. 
   private void saveFile(HuffmanNode current, PrintStream output, String currentStr) {
      if (current.left != null || current.right != null) {
			saveFile(current.left, output, currentStr + "0");
			saveFile(current.right, output, currentStr + "1");
		} else { // base case, reach the leaves
			output.println(current.theChar);
			output.println(currentStr);
		}
   }
   
   // pre: pass in a Scanner object that reads a code file. 
   // post: reconstructs the HuffmanTree from this given file. 
   public HuffmanTree(Scanner input) {
		while (input.hasNextLine()) {
			int last = Integer.parseInt(input.nextLine());
			String code = input.nextLine();
			myRoot = createTree(myRoot, last, code);
		}
   }
   
   // pre: pass in a HuffmanNode represents the current node works on, an integer 
   //      represents a certain character, and a string of the code of this character. 
   // post: build up the HuffmanTree over the given data and return its root. 
   private HuffmanNode createTree(HuffmanNode current, int last, String code) {
      if (current == null) {
			if (code.isEmpty()) { 
            return new HuffmanNode(0, last);
		   } else {
			   current = new HuffmanNode(0, -1);
         }
		} // base case. if current is null create a new node to build up the tree. 
      if (code.startsWith("0")) {
			current.left = createTree(current.left, last, code.substring(1)); 
		} else { // if startsWith 1
			current.right = createTree(current.right, last, code.substring(1));
		}
		return current;
   }
     
   // pre: pass in a BitInputStream object to read the input, a PrintStream object to write 
   //      out the output and an integer which is the number of ¡°end of file¡± character. 
   // post: read individual bits from the input stream and write the corresponding 
   //       characters to the output. 
   //       stop reading when encounters a character with value equal to the eof parameter. 
   public void decode(BitInputStream input, PrintStream output, int eof) {
      boolean isEOF = false; 
      while (!isEOF) { // loop until reach EOF
         HuffmanNode current = myRoot; 
         while (current.left != null && current.right != null) {
            int theBit = input.readBit();
				if (theBit == 0) {
					current = current.left;
				} else { // theBit is 1
					current = current.right;
				}
         }
         if (current.theChar == eof) {
            isEOF = true; 
         } else {
            output.write(current.theChar); 
         }
      }
   }
}
// Yao Yi
// 12/10/2015
// CSE 143 AC 
// TA: LATHE,CHLOE M.  
// 
// This class represents a single node of a binary tree.


public class HuffmanNode implements Comparable<HuffmanNode> {
   public int theChar; // number represents the character
   public int frequency; // frequency of the character appears
   public HuffmanNode left; // left branch
   public HuffmanNode right; // right branch
   
   // pre: pass in 2 integers, one is a number represents a character, the other is the number 
   //      of times this character appears. 
   // post: initialize a single node of the tree over the given data.  
	public HuffmanNode(int frequency, int theChar) {
		this(frequency, theChar, null, null);
	}
	
 	// pre: pass in in 2 integers which are a number represents a character and the number of 
   //      times this character appears, and 2 other HuffmanNode which will be the branches. 
   // post: initialize a single node of the tree over the given data, and links it to the two 
   //       nodes by left and right sides seperately. 
	public HuffmanNode(int frequency, int theChar, HuffmanNode left, HuffmanNode right) {
		this.theChar = theChar;
      this.frequency = frequency;
		this.left = left;
		this.right = right;
	}
	
	// pre: pass in another HuffmanNode. 
   // post: compare the frequencies in this node and the passed in node and return the result. 
	public int compareTo(HuffmanNode other) {
		return frequency - other.frequency;
	}
}
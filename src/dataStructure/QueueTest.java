package dataStructure;

import java.io.InputStreamReader;
import java.io.Reader;

public class QueueTest {
	   // in: reader for reading input data
	   private static Reader in = 
	         new InputStreamReader(System.in);

	   private static char getNextChar() {
	      char ch = ' ';
	      try {
	         ch = (char)in.read();
	      }
	      catch (Exception exception) {
	         System.err.println("Read Error");
	         ch = ' ';
	      }
	      return ch;
	   }

	   public static void main(String[] args) {
	      Queue queue = new Queue(4); // 10 chars
	      char ch;
	      while ((ch = getNextChar()) != 'q') {
	         switch (ch) {
	         case 'i':
	            ch = getNextChar();
	            queue.insert(ch);
	            System.out.println(ch + " inserted");
	            break;
	         case 'd':
	            System.out.println(queue.delete() + 
	               " deleted");
	            break;
	         case 'p':
	            queue.printq();
	            break;
	         default: System.out.println("Input error");
	         }
	         while ((ch = getNextChar()) != '\n')
	            ;
	      }
	   }
}

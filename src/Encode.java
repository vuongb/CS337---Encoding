import java.io.FileOutputStream;
import java.io.FileReader;
import java.lang.*;


public class Encode {
	
	public static void main(String[] args) throws Exception {
		Integer c;
		char ch;
		int decimalOutput;
		int oneCount = 0;
		String str = "";
		String out = "";
		FileReader fr = new FileReader("project0.txt");
		FileOutputStream fos = new FileOutputStream("project0.enc");
		while(-1 != (c = fr.read())) {
			str = Integer.toBinaryString(c);
			for(int i = 0; i < str.length(); i++) {
				if(str.charAt(i) == '1')
					oneCount++;
			}
			
			// Odd
			if(oneCount % 2 == 1)
				out += '1';
			else
				out += '0';
			
	
			for(int i = 0; i < str.length(); i++) {
				out += str.charAt(i);
			}
			
			
			decimalOutput = Integer.parseInt(out, 2);
			ch = (char) decimalOutput;
			fos.write((char) decimalOutput);
			str = "";
			out = "";
			oneCount = 0;
		
			
		}
		fr.close();
		fos.close();
	}
}

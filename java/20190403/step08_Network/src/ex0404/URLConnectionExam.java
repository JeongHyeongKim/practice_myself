package ex0404;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class URLConnectionExam {
	
	public URLConnectionExam() {
		try {
			URL url = new URL("https://www.daum.net");
			
			BufferedInputStream bis = 
					new BufferedInputStream(url.openStream());
			
			/*BufferedOutputStream bos =
					new BufferedOutputStream("");*/
			
			byte b [] = new byte [bis.available()];
			bis.read(b);
			/*int i=0;
			while((i=bis.read())!=-1) {
				bos.write(i);
			}*/
			
			//System.out.println(new String(b));
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("src/ex0404/daum.txt"));      
			bos.write(b);
			bos.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new URLConnectionExam();
	}

}

package filedemo;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

public class Filedemo3 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter file name (with extension)");//accept filename from user
		String fname=sc.nextLine();
		String curDir=System.getProperty("user.dir");
				System.out.println("The current dir is"+curDir);
		FileReader fr;
		try {
			fr = new FileReader(fname);
		 
		BufferedReader br=new BufferedReader(fr);
		String line=br.readLine();
		
		do
		{
			int lines=0;
				while(line!=null && lines<20)
					{
						System.out.println(line);
						line=br.readLine();
						lines++;
					}
		System.out.println("Press ENTER to continue");
		} 	
		while(sc.nextLine().contentEquals(""));
		
    fr.close();
	br.close();
    sc.close();
		}
		
		catch (IOException e) 
		{	
			e.printStackTrace();
		}
	}

	
}
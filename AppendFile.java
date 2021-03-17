package filedemo;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileReader;

public class AppendFile {
public static void display_menu()
{
	System.out.println("Select an option");
	System.out.println("1.Append \n 2.Overwrite \n 3.Delete ");
}
	
	public static void main(String args[]) 
	{
		
		File f=new File("output.txt");
		if(!f.exists())
		{
			try {
				f.createNewFile();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		
		Scanner in=new Scanner(System.in);
		
		display_menu();
		
		switch(in.nextInt())
		{
		case 1:
			FileWriter fw;
			BufferedWriter writer1;
			try {
				fw = new FileWriter(f,true);
			
			writer1=new BufferedWriter(fw);
			System.out.println("Enter the text");
			Scanner sc=new Scanner(System.in);
			String text=sc.nextLine();
			writer1.write(text);
			writer1.newLine();
			writer1.close();
			fw.close();
			sc.close();
			System.out.println("Your input is appended");
			}
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			break;
		
		case 2:
			FileWriter fw1;
			BufferedWriter writer2;
			try {
				fw1 = new FileWriter(f);
			
			writer2=new BufferedWriter(fw1);
			System.out.println("Enter the text");
			Scanner sc1=new Scanner(System.in);
			String text1=sc1.nextLine();
			writer2.write(text1);
			writer2.newLine();
			writer2.close();
			fw1.close();
			sc1.close();
			System.out.println("Your input is overwritten");
			break;
			} catch (IOException e) {
				e.printStackTrace();
			}
		case 3:
			File tempFile=new File("tempFilennn.txt");
			try {
				tempFile.createNewFile();
			
			FileWriter fw2=new FileWriter(f);
			BufferedWriter writer3=new BufferedWriter(fw2);

			
			boolean available=false;
			FileReader fr=new FileReader(f);
			BufferedReader br=new BufferedReader(fr);
			System.out.println("Enter the text");
			Scanner sc2=new Scanner(System.in);
			String text2=sc2.nextLine();
			String line=br.readLine();
			while(line!=null)
			{
				if(line.equals(text2))
					{
					available=true;
					}
				else
				{
				writer3.write(line);
				writer3.newLine();
				}
				line=br.readLine();
				
			}
			writer3.flush();
			writer3.close();
			br.close();
			fr.close();
			fw2.close();
			sc2.close();
			in.close();
			if(available==false)
			{
				System.out.println("Your input is not present in the file");
				
			}
			else
			{
				System.out.println("Your input is deleted from the file");
				
					
			if(f.delete())
			
				{
					if(!tempFile.renameTo(f))
					{
						System.out.println("Could not rename");
					}
				}
			else
			{
				throw new IOException("Could not delete the file");
			}
			}
		} catch (IOException e)
			{
			e.printStackTrace();
		    }
			break;
			default:
				System.out.println("Invalid input");
				break;
		}
		
		
		
		}	
		
		
			
	
	
}


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.io.*;

public class Program3 {
 public static void main(String args[])throws Exception {
    	
    	String log = "";
    	String fileName = null;
    	ArrayList<String> questions = new ArrayList<>();
        ArrayList<String> options = new ArrayList<>();
        ArrayList<String> answer = new ArrayList<>();
        String temp="";
        int i=0;
        BufferedReader bufferReader=new BufferedReader( new InputStreamReader(System.in));
		System.out.println("Give the path of the input file");
		 fileName = bufferReader.readLine();
		 System.out.println("Please select from the folloowing \n 1.input \n 2.quiz \n 3.exit");
			System.out.println("enter an option");
			Scanner sc=new Scanner(System.in);
			i = sc.nextInt();
			String un;
    int attempt=0;
    //reading file line by line in Java using BufferedReader       
    FileInputStream fis = null;
    BufferedReader reader = null;
while(i>0){
	
	
		switch(i)
    	{
    	case 1 :System.out.println("Please enter user name");
    				Scanner sc3=new Scanner(System.in);
    				un=sc3.nextLine();
				System.out.println("username is  "+un);
				log = log + "\n"+ "usename is: "+un;
    				System.out.println("Please select from the folloowing \n 1.input \n 2.quiz \n 3.exit");
    				System.out.println("enter an option");
    				Scanner sc1=new Scanner(System.in);
    				i=sc1.nextInt();
    				break;
    	case 2 :
    		        attempt=attempt+1;
			System.out.println(" your attempt is   "+attempt);
    		        
	log = log + "\n"+ "     your attempt is   "+attempt;
    		            fis = new FileInputStream(fileName);
    		            reader = new BufferedReader(new InputStreamReader(fis));

    		            System.out.println("Start the test \n");
    					System.out.println("Specify the quiz time limit in seconds?");
    					Scanner sc12=new Scanner(System.in);
    					int q= sc12.nextInt();	
    					long m = (long)q * 1000;

    		            String line = reader.readLine();
    		            while (line != null) {
    		                if (line.contains("@Q")) {
    		                    temp = "";
    		                } else if (line.contains("@E")) {
    		                    questions.add(temp);

    		                } else {
    		                    temp = temp + "\n" + line;
    		                }


    		                line = reader.readLine();
    		            }
int p = questions.size();
    		            int count = 0;
    		            int correct = 0;
    		long elapsedTime = 0;
    		            long startTime = System.currentTimeMillis();
    		                while(elapsedTime < m) {
    		                    Random r = new Random();
    		                    int random = r.nextInt(p);
    		                    String lines[] = questions.get(random).split("\\r?\\n");
    		                    count=count+1;
    							System.out.println(count+") "+lines[2]);
    							
    		                    System.out.println(" \n Your options are");
    		                    System.out.println("1) " + lines[6]);
    		                    System.out.println("2) " + lines[7]);
    		                    System.out.println("3) " + lines[8]);
    		                    System.out.println("4) " + lines[9]);
    		                    System.out.println("5) " + lines[10]);
    		elapsedTime = System.currentTimeMillis() - startTime;
    							
    		                    System.out.println("\n Your answer");
    		                    Scanner scan = new Scanner(System.in);
    		                    int i1 = scan.nextInt();
    		                    int k = Integer.parseInt(lines[5]);
    							
    		                    if (i1 == k) {
    		                        System.out.println("correct answer \n\n");
    								
    		                        correct=correct+1;
    		                    } else {
    		                        System.out.println("incorrect answer");
    								
    		                        System.out.println(k);
    		                    }
    		                
    		        }

	
	System.out.println("Questions answered correctly "+correct+" out of total questions "+count);
    		log = log + "\n"+ "   Questions answered correctly: "+correct+" out of total questions: "+count;
    		double perc = (double) correct / (double) count ;
    		        perc = perc * 100;
    				log = log + "\n"+ "  your result in percentage is: "+perc;

    		System.out.println("your result in percentage is "+perc);
    		//System.out.println(log);
    		PrintStream out = new PrintStream(new FileOutputStream("quizlog.txt"));
    		    out.print(log);
    		                
    		                System.out.println("Please select from the folloowing \n 1.input \n 2.quiz \n 3.exit");
    		    			System.out.println("enter an option");
    		    			Scanner sc11=new Scanner(System.in);
    		    			i=sc11.nextInt();
    		    			break;
    	case 3: System.exit(0);
    	break;
    		            
    	}
        } 
        }

    

}

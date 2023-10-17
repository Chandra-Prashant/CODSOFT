import java.util.Scanner;
class StudentGradeCalculator{
	public static void main(String [] args){
		Scanner scan=new Scanner(System.in);
		//inputing th marks in various subjects from the user
		System.out.println("Enter the marks obtained (out of 100) in:");
		System.out.print("English? ");
		int eng=scan.nextInt();
		System.out.print("Hindi? ");
		int hin=scan.nextInt();
		System.out.print("Mathematics? ");
		int mat=scan.nextInt();
		System.out.print("Science? ");
		int sci=scan.nextInt();
		System.out.print("Social Science? ");
		int soc=scan.nextInt();
		//finding the total
		int total=eng+hin+mat+sci+soc;
		System.out.println("Total marks scored in five subjects(out of 500) is "+total);
		//finding the percentage
		double percentage=((total*100)/500);
		System.out.println("Percentage obtained is "+percentage+"%.");
		//deciding the grade based upon the percentage user got
		if(percentage>90){
			System.out.println("You got A+ grade.");
		}
		else if(percentage>80){
			System.out.println("You got A grade.");
		}
		else if(percentage>70){
			System.out.println("You got B+ grade.");
		}
		else if(percentage>65){
			System.out.println("You got B grade.");
		}
		else if(percentage>60){
			System.out.println("You got C+ grade.");
		}
		else if(percentage>55){
			System.out.println("You got C grade.");
		}
		else if(percentage>50){
			System.out.println("You got D+ grade.");
		}
		else if(percentage>45){
			System.out.println("You got D grade.");
		}
		else{
			System.out.println("You got F grade.");
		}
	}
}
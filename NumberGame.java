import java.util.Scanner;
import java.util.Random;
class NumberGame{
	public static void main(String [] args){
		Scanner scan=new Scanner(System.in);
		Random rand=new Random();
		//define the range of numbers
		int min=1;
		int max=100;
		//define the chance the user got to guess
		int chances=5;
		int score=0;
		boolean again=true;
		System.out.println("Welcome!!!");
		while(again){
			//generating a random number
			int randNumber=rand.nextInt(max-min+1)+min;
			int guess;
			System.out.println("System has chosen a number.");
			System.out.println("Now you have to guess that number between "+min+" and "+max+".");
			System.out.println("You can try "+chances+" times.");
			//taking input from user of the guess and checking it to be correct or not
			for(int chance=1;chance<=chances;chance++){
				System.out.print("Chance "+chance+", Enter what you guess: ");
				guess=scan.nextInt();
				if(guess==randNumber){
					System.out.println("Yesss!!!,you are correct");
					score++;
					break;
				}
				else if(guess<randNumber){
					System.out.println("Too low.Retry...");
				}
				else{
					System.out.println("Too high.Retry...");
				}
				if(chance==chances){
					System.out.println("Game Over...");
				}
			}
			//condition for user to play again based on two conditions ya and na
			System.out.print("Wanna play again?(ya/na): ");
			String playAgain=scan.next().toLowerCase();
			again=playAgain.equals("ya");
		}
		System.out.println("Thanks for playing.");
		//giving user the score he/she obtained
		System.out.println("You scored "+score);
	}
}
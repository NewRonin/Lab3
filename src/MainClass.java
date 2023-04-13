import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class MainClass {
	
	public static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args){
		
		try {
			Format f = new Format(in.nextLine());
			f.getForm();
		}
		catch (DateTimeParseException e) {
			System.out.println("Неверно указана дата!");
		}
		
		catch (StringIndexOutOfBoundsException e) {
			System.out.println("Неверно указано отчество!");
		}
		
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Недостаточно данных!");
		}
		
	}

}

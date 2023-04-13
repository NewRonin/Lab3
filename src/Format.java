import java.lang.IllegalArgumentException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Format {
	
	private String name;
	private String surname;
	private String patronymic;
	private String date;
	
	public Format(String inputString) throws IllegalArgumentException {
		
		String[] input = inputString.split(" ");
		
		this.surname = input[0];
		this.name = input[1];
		this.patronymic = input[2];
		this.date = input[3];
		
	}
	
	public void getForm() {
		System.out.println(formatName() + " " + getGender() + " " + formatAge());
	}
	
	private String formatName(){
		
		return String.format("%s %c. %c.", surname, name.charAt(0), patronymic.charAt(0));
		
	}
	
	
	//Основывается на правилах состоавления отчества в русском языке
	private String getGender() {
		
		String ending = this.patronymic.substring(patronymic.length() - 2);
		
		if (ending.equals("ич") || ending.equals("лы")) {
			return "М";
		}
		
		else {
			return "Ж";
		}
		
	}
	
	private int getAge() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyyy");
		LocalDate date = LocalDate.parse(this.date, formatter);
		
		return (int) java.time.temporal.ChronoUnit.YEARS.between(date, LocalDate.now());
		
	}
	
	//Основывается на правилах подбора данных слов к числительным  в русскмо языке
	private String formatAge() {
		int age = getAge();
		
		if (age == 1) {
			return age + " год";
		
		}
		else if (age > 4 && age < 21) {
			return age + " лет";
		}
		else if (age % 10 > 1 && age % 10 < 5) {
			return age + " года";
		}
		else {
			return age + " лет";
		}
		
	}

}

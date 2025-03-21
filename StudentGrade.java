import java.util.*;

public class StudentGrade
{
	public static void main(String[] args) {
	    // Create Scanner object for input
		Scanner sc = new Scanner(System.in);
		// Ask user for number of subjects
		System.out.print("Enter total no of subjects: ");
		int subject_count = sc.nextInt();
		
		int[] subjects = new int[subject_count];
		int totalMarks = 0;
		// Input marks for each subject
		for(int i=0;i<subject_count;i++){
		    System.out.print("Enter the marks of Subject "+(i+1)+": ");
		    subjects[i] = sc.nextInt();
		    // Validate marks (between 0 and 100)
		    if( subjects[i] < 0 || subjects[i] > 100 ){
		        System.out.println("Invalid marks! Marks should be between 0 and 100.");
		        i--; // Validate marks (between 0 and 100)
		    }
		    else {
		        totalMarks += subjects[i];
		    }
		}
		// Calculate percentage
		float percentage = (float) totalMarks / (subject_count * 100) * 100;
		
		// Determine grade based on percentage
		String grade;
		if (percentage >= 90){
		    grade = "O";
		} else if (percentage >= 80){
		    grade = "A+";
		} else if (percentage >= 70){
		    grade = "A";
		} else if (percentage >= 60){
		    grade = "B+";
		} else if (percentage>=50){
		    grade = "B";
		} else {
		    grade = "F";
		}
        // Display results
		System.out.println("Total Marks: " + totalMarks);
		System.out.println("percentage: " + percentage + "%");
		System.out.println("Grade: " + grade);
		// Close the scanner to avoid memory leak
		sc.close();
	}
}

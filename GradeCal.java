import java.util.*;

class GradeCal {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the total number of subjects");
        int n = in.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the total marks obtained in each subject:");
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        int totalMark = 0; 
        for (int i = 0; i < n; i++) {
            totalMark += arr[i]; 
        }

        int averageMark = totalMark / n; 
        String grade = "";
        switch (averageMark / 10) {
            case 10:
               
                break;
            case 9:
                grade = "A";
                break;
            case 8:
                grade = "B";
                break;
            case 7:
                grade = "C";
                break;
            case 6:
                grade = "D";
                break;
            default:
                grade = "Fail";
                break;
        }

        System.out.println("\nTotal marks obtained by the student: " + totalMark);
        System.out.println("Average marks obtained: " + averageMark);
        System.out.println("Grade of the student: " + grade);
    }
}




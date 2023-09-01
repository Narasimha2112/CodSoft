import java.util.Scanner;   

public class StuGrade 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your name :- ");
        String name = sc.next();

        System.out.println("Enter the Marks of Telugu :-");
        int tel = sc.nextInt();

        System.out.println("Enter the Marks of English :-");
        int eng = sc.nextInt();

        System.out.println("Enter the Marks of Maths :-");
        int mat = sc.nextInt();

        System.out.println("Enter the Marks of Science :-");
        int sci = sc.nextInt();

        System.out.println("Enter the Marks of Social :-");
        int soc = sc.nextInt();

        int tot = tel+eng+mat+sci+soc;

        double averagePercentage = tot/5;

        if(averagePercentage>=90)
        {
            System.out.println("Grade O");
        }
        else if(averagePercentage>=80)
        {
            System.out.println("Grade A");
        }
        else if(averagePercentage>=70)
        {
            System.out.println("Grade B");
        }
        else if(averagePercentage>=60)
        {
            System.out.println("Grade C");
        }
        else if(averagePercentage>=50)
        {
            System.out.println("Grade D");
        }
        else
        {
            System.out.println("You Failed");
        }

        System.out.println("Total Marks: " + tot);
        System.out.println("Average Percentage: " + averagePercentage);
    }
    
}

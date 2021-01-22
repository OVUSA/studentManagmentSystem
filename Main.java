package studentManagementSystem;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        System.out.print("Input the size of the class (how many students are there in the class this semester?) >> ");
        int size = input.nextInt();
        System.out.println();
        StudentDataOperator studentDataOperator = new StudentDataOperator(size);
        studentDataOperator.run();
    }
}

import java.util.Scanner;

public class Driver
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("[The GatlingTea Factory]");

        System.out.print("How many boxes of Jasmine Tea would you like to order? ");
        int jasmine = input.nextInt();
        System.out.print("How many boxes of Earl Grey Tea would you like to order? ");
        int earlGrey = input.nextInt();
        System.out.print("How many boxes of Lemon Tea would you like to order? ");
        int lemon = input.nextInt();

        TheDrum theDrumCreated = new TheDrum(jasmine, earlGrey, lemon);

        System.out.println("The Drum™ has been created and shipped.");

        System.out.print("How many employees will help unload? ");
        int employees = input.nextInt();


        Employee[] employeesList = new Employee[employees];
        for (int i = 0; i < employees; i++)
        {
            employeesList[i] = new Employee(theDrumCreated);
            employeesList[i].start();
        }

        for (int i = 0; i < employees; i++) {
            try {
                employeesList[i].join();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < employees; i++)
        {
            System.out.println(employeesList[i].toString());
        }

        int totalUnloaded = 0;
        for (int i = 0; i < employees; i++)
        {
            totalUnloaded += employeesList[i].totalTea();
        }

        System.out.println("A total of " + totalUnloaded + " boxes of tea were stocked");


    }
}

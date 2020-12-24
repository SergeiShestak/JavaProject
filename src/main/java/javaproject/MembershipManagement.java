package javaproject;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class MembershipManagement {
    final private Scanner reader = new Scanner(System.in);

    private int getIntInput() {
        int choice = 0;
        while (choice == 0)
        try {
            System.out.print("Please enter number:");
            choice = reader.nextInt();
            if (choice == 0)
                throw new InputMismatchException();
            reader.nextLine();

        } catch (InputMismatchException e) {
            reader.nextLine();
            System.out.println("ERROR : invalid input. Please try again");
        }
        return choice;
    }
    public void printClubOptions(){
        System.out.println("1) Club Mercury");
        System.out.println("2) Club Neptune");
        System.out.println("3) Club Jupiter");
        System.out.println("4) Multi Clubs");
    }
    public int getChoice(){
        int choice;
        System.out.println("WELCOME TO OZONE FITNESSE CENTER");
        System.out.println("================================");
        System.out.println("1) Add member");
        System.out.println("2) Remove member");
        System.out.println("3) Display member information \n");
        System.out.println("Please select options (or enter -1 to quit :");
        choice= getIntInput();
        return choice;

    }
    public String addMembers(LinkedList<Members> m){
        String name;
        int club;
        String mem;
        double fees;
        int memberId;
        Members mbr;
        Calculator<Integer> cal;

        Scanner reader = new Scanner(System.in);
        System.out.print("Please enter member's name: ");
        name = reader.nextLine();
        printClubOptions();
        System.out.println("Please enter clubID");
        club = getIntInput();
        while (club < 1 || club > 4) {
            System.out.println("You entered incorrect club's number");
            System.out.print("Please try again: ");
            club = reader.nextInt();
        }
            if(m.size()>0)
                memberId = m.getLast().getMemberId()+1;
            else
                memberId = 1;

            if(club !=4){
                cal =(n)-> {
                    switch (n){
                        case(1):
                            return 900;
                        case(2):
                            return 950;
                        case(3):
                            return 1000;
                        default:
                            return -1;
                    }
                };
                fees = cal.calculateFees(club);
                mbr = new SingleClubMember('S',memberId,name,fees,club);
                m.add(mbr);
                mem = mbr.toString();
                //System.out.println(mem);
                System.out.println("\nSTATUS: Single Club Member added");
            }
            else {
                cal = (n)-> {
                    if (n == 4)
                        return 1200;
                    else
                        return -1;
                };
                fees = cal.calculateFees(club);
                mbr = new MultiClubMember('M',memberId,name,fees,club);
                m.add(mbr);
                mem = mbr.toString();
                System.out.println(mem);
                System.out.println("\nSTATUS: Multi Club Member added");

            }
            return mem;
        }
    public void removeMembers(LinkedList<Members> m){
        int memberID;
        System.out.println("Please enter memberId for remove:");
        memberID = getIntInput();
        for (int i = 0; i < m.size(); i++){
            if(m.get(i).getMemberId()== memberID){
                m.remove(i);
                System.out.println("Member "+ memberID + " deleted ");
                return;
            }
        }
        System.out.println("The memberID doesn't find");


    }
    public void printMemberInfo(LinkedList<Members> m){
        int memberID;
        System.out.println("Please enter memberID for info");
        memberID = getIntInput();
        for(int i = 0; i < m.size();i++)
        {
            if(m.get(i).getMemberId()==memberID)
            {
                String[] memberInfo = m.get(i).toString().split(", ");

                System.out.println("\t\tMember Type = " + memberInfo[1]);
                    System.out.println("\t\tMemberID = " + memberInfo[1]);
                    System.out.println("\t\tMember Name = " + memberInfo[2]);
                    System.out.println("\t\tMember Fees = " + memberInfo[3]);
                if (memberInfo[0].equals("S")) {
                    System.out.println("\t\tClub ID = " + memberInfo[4]);
                }else{
                    System.out.println("\t\tMembership Points = " + memberInfo[4]);
                }
            }
        }
    }

}




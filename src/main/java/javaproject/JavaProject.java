package javaproject;
import java.util.LinkedList;

public class JavaProject {
    public static void main(String [] args){
        String mem;
        MembershipManagement mm = new MembershipManagement();
        FileHandler fh = new FileHandler();
        LinkedList<Members> m = fh.readFile();
        int choice = mm.getChoice();

        while(choice != -1){
            switch (choice){
                case (1):
                    mem = mm.addMembers(m);
                    fh.appendFile(mem);
                    break;
                case(2):
                    mm.removeMembers(m);
                    fh.overWriteFile(m);
                    break;
                case(3):
                    mm.printMemberInfo(m);
                    break;
                default:
                    System.out.println("You enter incorrect.Try again");
            }
            choice= mm.getChoice();
        }
    }

}

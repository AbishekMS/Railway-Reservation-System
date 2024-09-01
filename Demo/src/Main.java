import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    public static void cancelTicket(int id){
        TicketBooking tb=new TicketBooking();
        if(!TicketBooking.passengers.containsKey(id)) System.out.println("Passenger not found");
        else tb.cancelId(id);
    }
    public static void bookTicket(Passenger p){
        TicketBooking tb=new TicketBooking();
        tb.addPassenger(p);
    }
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       boolean flag=true;
       System.out.println("Number of trains:");
       int m=1;
       String[] tr = {"Kovia SF Express", "Ernakulam", "Coimbatore Express"};
       String[] bp={"Chennai","Chennai","Cheenai"};
       String[] dp={"Coimbatore","Coimbatore","Coimbatore"};
       String[] time={"10 PM","11 PM","9 PM"};
       int[] maxi={5,7,2};
       List<Train> trains = new ArrayList<>();
       while(m<=3){
           String train_name=tr[m-1];

           String boarding_point=bp[m-1];
           //System.out.println("Destination point");
           String destination=dp[m-1];

           String Depart_time=time[m-1];

           int tickets=maxi[m-1];
           Train temp=new Train(m,train_name,boarding_point,destination,Depart_time,tickets);
           trains.add(temp);
           TicketBooking tb=new TicketBooking();
           tb.addTrain(temp);
           m++;
       }
       System.out.println("Train No"+ " Train_name "+" Boarding_point "+" Destination "+" Depart_time "+" Tickets ");
        for(Train t: trains){
            System.out.println(t.id+"  "+t.train_name+"  "+t.boarding_point+"  "+t.destination+"  "+t.Depart_time);
        }
       while(flag){
           System.out.println("1.Book Ticket \n2.Cancel Ticket \n3.View Ticket Status \n4.Exit");
           int n = sc.nextInt();
           if(flag){
           switch (n) {

               case 1: {
                   TicketBooking tb=new TicketBooking();
                  //2 tb.print();
                   String name, board, destination, booking_type;
                   int age, train_no;
                   System.out.println("Enter Your Name:");
                   name = sc.next();
                   System.out.println("Enter Your Age:");
                   age = sc.nextInt();
                   System.out.println("Enter Your Boarding point:");

                   board = sc.next();
                   if(!tb.Boarding.contains(board)) return;
                   System.out.println("Enter Your Destination point:");
                   destination = sc.next();
                   if(!tb.Destinations.contains(destination)) return;
                   System.out.println("Enter Your Train Number:");
                   train_no = sc.nextInt();
                   if(!tb.trainIDs.contains(train_no)) return;
                   System.out.println("Enter Your Booking Type:(Normal ,Sleeper,AC)");
                   booking_type = sc.next();
                   Passenger p=new Passenger(name,age,board,destination,booking_type,train_no);

                   bookTicket(p);
               }
               break;
               case 2: {

                   System.out.println("Enter Your PNR number:");
                   int pnr = sc.nextInt();
                   TicketBooking tb=new TicketBooking();
                   tb.cancelId(pnr);

               }
               break;
               case 3: {
                   TicketBooking ticket = new TicketBooking();
                   int pnr;
                   System.out.println("Enter Your ID:");
                   pnr = sc.nextInt();
                   ticket.viewStatus(pnr);

               }
               break;
               case 4: {
                   flag = false;
                   break;
               }
               default:
                   System.out.println("Invalid option");
                   flag = false;
                   break;

           }
           }
       }

    }
}

import java.util.*;

public class TicketBooking {
    static int wait=0;
    static Queue<Passenger>waiting = new LinkedList<>();
    static HashMap<Integer,List<Passenger>>trainpassengers = new HashMap<>();
    static List<String> Destinations=new ArrayList<>();
    static List<String> Boarding=new ArrayList<>();
    static List<Integer> trainIDs=new ArrayList<>();
    static HashMap<Integer,Passenger>passengers=new HashMap<>();
    static HashMap<Integer,Train>trains=new HashMap<>();
    public void addPassenger(Passenger p){
        for(Map.Entry<Integer,Train> entry:trains.entrySet()){
            if(entry.getValue().id==p.train_no){
                if(Train.tickets >0) Train.tickets--;
                else {
                    waiting.add(p);
                    wait++;
                }
            }
        }
        System.out.println("PNR Number"+ Passenger.pnr);
        passengers.put(Passenger.id,p);



    }
    public void addTrainPassengers(){
        for(Map.Entry<Integer,Train>entry:trains.entrySet()){
            List<Passenger> p=new ArrayList<>();
            for(Map.Entry<Integer,Passenger>e:passengers.entrySet()){
                if(e.getValue().train_no==entry.getKey()){
                    p.add(e.getValue());
                }
            }
            trainpassengers.put(entry.getKey(), p);
        }
    }


    public void cancelId(int p) {
        int id=-1;
        int trainid=-1;

        for(Map.Entry<Integer,Passenger> entry:passengers.entrySet()){
            if(Passenger.pnr==p){
                id=entry.getKey();
                trainid=entry.getValue().train_no;
            }
        }
        for(Map.Entry<Integer,Train>entry:trains.entrySet()){
            if(entry.getValue().id==trainid){
                Train.tickets = Train.tickets+1;

            }
        }
        for(Passenger pp:waiting){
            List<Passenger>temp=new ArrayList<>();
            if(pp.train_no==trainid){
                temp.add(pp);
            }
            trainpassengers.put(trainid,temp);
        }




          passengers.remove(id);

          System.out.println("Passenger ticket cancelled");
    }

    public void addTrain(Train temp) {
        trains.put(temp.id,temp);
        Destinations.add(temp.destination);
        Boarding.add(temp.boarding_point);
        trainIDs.add(temp.id);

    }
    public void viewStatus(int pass_id){
        int trainid=-1;

        for(Map.Entry<Integer,Passenger>p:passengers.entrySet()){
            if(Passenger.pnr ==pass_id){
                trainid=p.getValue().train_no;
            }
        }
        if(trainid==-1){
            System.out.println("Details not found");
            return;}
        for(Map.Entry<Integer,Train>t:trains.entrySet()){

            if(t.getKey()==trainid){
                System.out.println("Train Name :"+t.getValue().train_name+"\nBoarding Point :"+t.getValue().boarding_point+
                        " \nDesination Point :"+t.getValue().destination+" \nDeparture Time:"+t.getValue().Depart_time);
            }
        }
    }
}

public class Train {
    int id;
    String train_name;
    String boarding_point;
    String destination;
    String Depart_time;
    static int tickets;
    Train(int id,String train_name, String boarding_point, String destination, String Depart_time, int tickets) {
        this.id=id;
        this.train_name = train_name;
        this.boarding_point = boarding_point;
        this.destination = destination;
        this.Depart_time = Depart_time;
        Train.tickets = tickets;
    }


}

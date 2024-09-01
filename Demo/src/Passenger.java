public class Passenger {
    static int id=0;
    public boolean tickets;
    String name;
    int age;
    String boarding_point;
    String desination;
    String type;
    int train_no;
    static int pnr=10001;
    Passenger(String name, int age, String boarding_point, String desination, String type,int train_no) {
        this.name = name;
        id=id+1;
        this.age = age;
        this.boarding_point = boarding_point;
        this.desination = desination;
        this.type=type;
        this.train_no = train_no;
        pnr=pnr+1;
    }
}

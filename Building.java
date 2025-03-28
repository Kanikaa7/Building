import java.util.*;

public class Building{
    static class Lift{
        int liftNo;
        int currentFloor;
        char dir;    // i - idle, u - upwards, d - downwards
        int capacity;
        int currentLoad;
        public Lift(int no, int f){
            this.liftNo = no;
            this.currentFloor = f;
            this.dir = 'i';
            this.capacity = 10;
            this.currentLoad = 0;
        }
        public void moveToFloor(int requestedFloor) {
            if (requestedFloor > currentFloor) {
                dir = "u";
            } else if (requestedFloor < currentFloor) {
                dir = "d";
            } else {
                dir = "i";
            }
            System.out.println("Lift " + liftNo + " moving " + dir + " to floor " + requestedFloor);
            currentFloor = requestedFloor;
            dir = "i";
        }
    }
    static class Floor{
        int floorNo;
        public Floor(int floorNo){
            this.floorNo = floorNo;
        }
    }
    static class Sys{
        Floor[] floors;
        Lift[] lifts;
        public Sys(){
            this.floors = new Floor[30];
            for(int i=0;i<30;i++){
                floors[i] = new Floor(i+1);
            }
            this.lifts = new Lift[8]; 
            for(int i=0;i<8;i++){
                lifts[i] = new Lift(i+1,1);
            }
        }
        public void callLift(int requestedfloor){
            int min = 9;
            Lift bestLift = null;
            for(Lift l:lifts){
                if(min>Math.abs(l.currentFloor-requestedFloor) && l.currentLoad<l.capacity){
                    bestLift = l;
                    min = Math.abs(l.currentFloor-requestedFloor);
                }
            }
            if(bestLift!=null){
                bestLift.moveToFloor(requestedFloor);
            }else{
                System.out.println("No available lifts at the moment.");
            }
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] req = new int[n];
        Sys s1 = new Sys();
        for(int i=0;i<n;i++){
            req[i] = sc.nextInt();
            s1.callLift(req[i]);
        }
        
        
    }
}
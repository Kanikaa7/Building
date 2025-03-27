import java.util.*;

public class Building{
    static class Lift{
        int liftNo;
        int currentFloor;
        public Lift(int no, int f){
            this.liftNo = no;
            this.currentFloor = f;
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
            int min = 9, l=0;
            for(int i=0;i<8;i++){
                if(min>Math.abs(lifts[i].currentFloor-requestedfloor)){
                    l = i;
                    min = Math.abs(lifts[i].currentFloor-requestedfloor);
                }
            }
            System.out.println("lift no. " + (l+1) + " will be called!!");
            lifts[l].currentFloor = requestedfloor;
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
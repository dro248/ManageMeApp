package manageme.managemeapp;

import java.util.ArrayList;

public class DataBank {
    private ArrayList<Request> myRequests = new ArrayList<>();
    private static DataBank bank = new DataBank();

    public static DataBank getDataBank(){
        return (bank == null) ? new DataBank() : bank;
    }


    public void addRequest(Request r){
        myRequests.add(r);
    }

    public void deleteRequest(int index){
        myRequests.remove(index);
    }

    public Request getRequest(int index){
        return myRequests.get(index);
    }

    public int length(){
        return myRequests.size();
    }

}

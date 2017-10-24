package manageme.managemeapp;

import java.util.ArrayList;

public class DataBank {
    private ArrayList<Request> myRequests = new ArrayList<>();
    private ViewPendingScreen pendingScreen;
    private static DataBank bank;

    public static DataBank getDataBank(){
        if (bank == null){
            bank = new DataBank();
            bank.addRequest(new Request(
                    "Kitchen Sink is Leaking",
                    "There is a drip under the sink that is warping the wood underneath.",
                    "Scheduled: 5 November 2017",
                    "med",
                    null)
            );
        }
        return bank;
    }

    public void addRequest(Request r){ myRequests.add(r); }
    public void deleteRequest(int index){ myRequests.remove(index); }
    public Request getRequest(int index){ return myRequests.get(index); }
    public int length(){ return myRequests.size(); }

    public ViewPendingScreen getPendingScreen() { return pendingScreen; }
    public void setPendingScreen(ViewPendingScreen pendingScreen) { this.pendingScreen = pendingScreen; }
}
package manageme.managemeapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;

public class ViewPendingScreen extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter myAdapter;
    private RecyclerView.LayoutManager myLayoutManager;
    private Request[] requestedData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pending_screen);

        // Set activity title
        setTitle("Unresolved Requests");

        // Get requested Data (FIRST)
        getRequestedData();

        // Bind to view
        recyclerView = (RecyclerView) findViewById(R.id.requests_view);
        recyclerView.setHasFixedSize(false);

        myLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(myLayoutManager);

        myAdapter = new MyRequestsAdapter(requestedData);
        recyclerView.setAdapter(myAdapter);
    }


    private void getRequestedData(){
        // TODO: How to get data from firebase?

    }
}

package manageme.managemeapp;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainScreen extends AppCompatActivity {
    private Button createRequestButton;
    private Button viewPendingRequestsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        createRequestButton = (Button) findViewById(R.id.create_request_button);
        viewPendingRequestsButton = (Button) findViewById(R.id.view_pending_requests_button);

        createRequestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create the new Request Form
                System.out.println("Create a new request.");
                createRequestForm();
            }
        });

        viewPendingRequestsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create the new Request Form
                System.out.println("View pending requests.");
                viewPendingRequestsScreen();
            }
        });
    }

    private void createRequestForm(){
        Intent requestIntent = new Intent(this, RequestFormScreen.class);
        startActivity(requestIntent);
    }
    
    private void viewPendingRequestsScreen(){
        Intent pendingRequestsIntent = new Intent(this, ViewPendingScreen.class);
        startActivity(pendingRequestsIntent);
    }
}

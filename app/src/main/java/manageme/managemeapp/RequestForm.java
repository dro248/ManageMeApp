package manageme.managemeapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class RequestForm extends AppCompatActivity {

    private Button submitFormButton;
    private Button cancelButton;
    private TextView title;
    private TextView description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_form);

        // Bind GUI to objects
        submitFormButton = (Button) findViewById(R.id.submitFormButton);
        cancelButton = (Button) findViewById(R.id.cancelButton);


        // Create Event Listeners for GUI
        submitFormButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create Database Connection
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("request");
                Request myRequest = new Request("","","","");
                Gson gson = new Gson();

                // Attempt to create a Request object
                try{
//                    myRequest = createRequestObject();
                    myRequest = new Request("myTitle", "descriptors...n stuff", "unviewed", "HI");

                }
                catch(Exception e){
                    Toast.makeText(getApplicationContext(), "Title, Description, and Severity required.", Toast.LENGTH_SHORT).show();
                }

                // Attempt to Submit to firebase
                try{
                    myRef.setValue(gson.toJson(myRequest));
                    Toast.makeText(getApplicationContext(), "Request Submitted!", Toast.LENGTH_SHORT).show();
                    finish();
                }
                catch(Exception e){
                    Toast.makeText(getApplicationContext(), "Transmission Failure: Could not submit request.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { finish(); }
        });

    }

//    private Request createRequestObject() throws RuntimeException{
//
//    }
}

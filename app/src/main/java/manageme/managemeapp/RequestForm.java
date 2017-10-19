package manageme.managemeapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.RuntimeExecutionException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.w3c.dom.Text;


public class RequestForm extends AppCompatActivity {

    private Button submitFormButton;
    private Button cancelButton;
    private TextView title;
    private TextView description;
    private RadioGroup severityGroup;
    private String severity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_form);

        // Bind GUI to objects
        submitFormButton = (Button) findViewById(R.id.submitFormButton);
        cancelButton = (Button) findViewById(R.id.cancelButton);
        title = (TextView) findViewById(R.id.titleText);
        description = (TextView) findViewById(R.id.descriptionText);
        severityGroup = (RadioGroup) findViewById(R.id.severityGroup);

        // Create Event Listeners for GUI
        submitFormButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create Database Connection
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("pending_request");
                Request myRequest = new Request("","","","");
                Gson gson = new Gson();

                // Attempt to create a Request object
                try{
                    myRequest = createRequestObject();
                    System.out.println(gson.toJson(myRequest).toString());
                }
                catch(Exception e){
                    Toast.makeText(getApplicationContext(), "Could not submit: Title, Description, and Severity options required!", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Attempt to Submit to firebase
                try{
                    myRef.setValue(gson.toJson(myRequest));
                    Toast.makeText(getApplicationContext(), "Success! Request Submitted.", Toast.LENGTH_SHORT).show();
                    finish();
                }
                catch(Exception e){
                    Toast.makeText(getApplicationContext(), "Transmission Failure: Could not submit request!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { finish(); }
        });

    }

    private Request createRequestObject() throws RuntimeException{
        int index = severityGroup.indexOfChild(findViewById(severityGroup.getCheckedRadioButtonId()));
        System.out.println("Index: " + index);

        switch(index){
            case 0:
                severity = "low";
                break;
            case 2:
                severity = "med";
                break;
            case 4:
                severity = "high";
                break;
            default:
                throw new RuntimeException();
        }

        if(title.getText().equals("") || description.getText().equals(""))
            throw new RuntimeException();

        // TODO: Change STATUS
        return new Request(title.getText().toString(), description.getText().toString(), "unviewed", severity);
    }
}

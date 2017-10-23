package manageme.managemeapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
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

    private DataBank bank = DataBank.getDataBank();
    static final int REQUEST_IMAGE_CAPTURE = 1;
    private ImageButton cameraButton;
    private Button submitFormButton;
    private Button cancelButton;
    private TextView title;
    private TextView description;
    private RadioGroup severityGroup;
    private String severity;
    private Bitmap myPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_form);

        // Set activity title
        setTitle("New Request Form");

        // Bind GUI to objects
        submitFormButton = (Button) findViewById(R.id.submitFormButton);
        cancelButton = (Button) findViewById(R.id.cancelButton);
        cameraButton = (ImageButton) findViewById(R.id.cameraButton);
        title = (TextView) findViewById(R.id.titleText);
        description = (TextView) findViewById(R.id.descriptionText);
        severityGroup = (RadioGroup) findViewById(R.id.severityGroup);


        // Create Event Listeners for GUI

        // CAMERA BUTTON
        cameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Look for a camera app
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                // If a camera app is found...
                if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                    // ...try to take picture with camera app...

                    try {
                        startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                        Toast.makeText(getApplicationContext(), "Success with Camera!", Toast.LENGTH_SHORT).show();
                        // TODO:...get image back
                    }
                    catch(Exception e){
                        Toast.makeText(getApplicationContext(), "Error: There was a problem launching the camera.", Toast.LENGTH_SHORT).show();
                    }
                }
                // If a camera app is NOT found...
                else {
                    Toast.makeText(getApplicationContext(), "Error: No camera app available!", Toast.LENGTH_SHORT).show();
                }
            }
        });


        submitFormButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                title.setError(null);
                description.setError(null);

                // Create Database Connection
//                FirebaseDatabase database = FirebaseDatabase.getInstance();
//                DatabaseReference myRef = database.getReference("pending_request");
                Request myRequest;
//                Gson gson = new Gson();

                // Attempt to create a Request object
                try{
                    myRequest = createRequestObject();
//                    System.out.println(gson.toJson(myRequest).toString());
                }
                catch(Exception e){
                    // Reset errors.
                    title.setError("This field is required!");
                    description.setError("This field is required!");
                    Toast.makeText(getApplicationContext(), "Could not submit: Title, Description, and Severity options required!", Toast.LENGTH_SHORT).show();
                    return;
                }

                // TODO: Attempt to Submit to firebase
                try{
//                    myRef.setValue(gson.toJson(myRequest));

                    // Insert into DataBank instead
                    bank.addRequest(myRequest);
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

        if(title.getText().length() < 1 || description.getText().length() < 1)
            throw new RuntimeException();

        // TODO: Change STATUS
        return new Request(title.getText().toString(), description.getText().toString(), "unviewed", severity);
    }
}

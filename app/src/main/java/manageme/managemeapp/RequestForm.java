package manageme.managemeapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class RequestForm extends AppCompatActivity {

    private Button submitFormButton;
    private Button cancelButton;

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
                // Submit Form...
                Toast.makeText(getApplicationContext(), "Request Submitted!",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { finish(); }
        });

    }
}

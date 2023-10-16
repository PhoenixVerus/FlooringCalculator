package CIS3334.flooringcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editTextWidth;
    EditText editTextLength;
    Button buttonResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initializing elements in the GUI
        editTextWidth = findViewById(R.id.editTextWidth);
        editTextLength = findViewById(R.id.editTextLength);

        setupResultsButton();
    }

    /**
     * Method to setup the Get Results button;
     * button sends user to second activity with the calculation result
     */
    private void setupResultsButton() {
        buttonResults = findViewById(R.id.buttonResults);
        buttonResults.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //grabs input values for width and length
                Double width = Double.parseDouble(editTextWidth.getText().toString());
                Double length = Double.parseDouble(editTextLength.getText().toString());

                //creation of intent to send dimension inputs to second activity for calculation
                Intent secActIntent = new Intent(MainActivity.this, ResultsActivity.class);
                secActIntent.putExtra("Width", width);
                secActIntent.putExtra("Length", length);
                startActivity(secActIntent);
            }
        });
    }
}
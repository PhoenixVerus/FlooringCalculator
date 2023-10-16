package CIS3334.flooringcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {

    Double width;
    Double length;
    Double area;
    TextView textViewResults;
    Button buttonAnotherCalc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        textViewResults = (TextView) findViewById(R.id.textViewResults);

        // pulls in elements from intent and shows calculation result
        Bundle extras = getIntent().getExtras();
        width = extras.getDouble("Width");
        length = extras.getDouble("Length");
        area = width * length;
        String result = "Flooring needed is " + area + ", when width is " + width + " and length is " + length + ".";
        textViewResults.setText(result);

        setupAnotherCalcButton();

        //launcher = registerForActivityResult()
    }

    /**
     * Method to setup the Another Calculation button;
     * button finishes the activity so it goes back to the main activity
     */
    private void setupAnotherCalcButton() {
        buttonAnotherCalc = findViewById(R.id.buttonAnotherCalc);
        buttonAnotherCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
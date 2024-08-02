package com.example.gdsc;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private EditText dayOfYearInput, yearInput;
    private TextView outputDate, outputWeekOfYear, outputLeapYear;
    private Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dayOfYearInput = findViewById(R.id.dayOfYearInput);
        yearInput = findViewById(R.id.yearInput);
        outputDate = findViewById(R.id.outputDate);
        outputWeekOfYear = findViewById(R.id.outputWeekOfYear);
        outputLeapYear = findViewById(R.id.outputLeapYear);
        calculateButton = findViewById(R.id.calculateButton);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateDateDetails();
            }
        });
    }

    private void calculateDateDetails() {
        int dayOfYear = Integer.parseInt(dayOfYearInput.getText().toString());
        int year = Integer.parseInt(yearInput.getText().toString());

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.DAY_OF_YEAR, dayOfYear);
        Date date = calendar.getTime();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        String formattedDate = dateFormat.format(date);
        int weekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);
        boolean isLeapYear = calendar.getActualMaximum(Calendar.DAY_OF_YEAR) > 365;

        outputDate.setText("Date: " + formattedDate);
        outputWeekOfYear.setText("Week of the Year: " + weekOfYear);
        outputLeapYear.setText("Leap Year: " + isLeapYear);
    }
}

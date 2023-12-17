package com.example.musss;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private int[] result;
    private int orderedCount;
    private int unorderedCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = Generator.gen();

        TextView instructionsTextView = findViewById(R.id.instructionsTextView);
        EditText inputEditText = findViewById(R.id.inputEditText);
        Button submitBtn = findViewById(R.id.submitBtn);

        // Add references to the new TextViews
        TextView orderedCountTextView = findViewById(R.id.orderedCountTextView);
        TextView unorderedCountTextView = findViewById(R.id.unorderedCountTextView);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleGuess(inputEditText.getText().toString());

                // Update the TextViews on the main (UI) thread
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        orderedCountTextView.setText("Ordered: " + orderedCount);
                        unorderedCountTextView.setText("Unordered: " + unorderedCount);
                    }
                });
            }
        });
    }

    private void handleGuess(String input) {
        try {
            int[] array = parseInput(input);

            // Ensure Check.answer is called on the UI thread
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    int[] counts = Check.answer(result, array);
                    orderedCount = counts[0];
                    unorderedCount = counts[1];
                }
            });

            // You can update the UI or perform any other actions based on the result.
        } catch (NumberFormatException e) {
            // Handle invalid input
            // You might want to show a Toast or update a TextView to inform the user.
        }
    }

    private int[] parseInput(String input) {
        int number = Integer.parseInt(input);
        int[] array = new int[4];

        for (int i = 3; i >= 0; i--) {
            array[i] = number % 10;
            number /= 10;
        }

        return array;
    }
}

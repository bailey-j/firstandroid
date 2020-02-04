package uk.ac.tees.w90005319.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static android.content.Intent.ACTION_DIAL;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "uk.ac.tees.w9005319.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View view){
        //Do something when button tapped...
        //Really important change
        //Another feature added
        Intent intent;
        intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.nameEditText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

    }


}

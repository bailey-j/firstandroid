package uk.ac.tees.w90005319.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

//import static org.apache.http.protocol.HttpCoreContext;

public class DisplayMessageActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextView textView;
        textView = findViewById(R.id.textView);
        textView.setText(message);


/*        Intent newIntent = new Intent(Intent.ACTION_SEND);

        // Always use string resources for UI text.
        // This says something like "Share this photo with"
                String title = "Share this photo with";//getResources().getString(R.string.chooser_title);
        // Create intent to show chooser
                Intent chooser = Intent.createChooser(newIntent, title);

        // Verify the intent will resolve to at least one activity
                if (newIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(chooser);
                }*/



//        Button callBtn = findViewById(R.id.callBtn);
//
//        callBtn.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//
//                Uri number = Uri.parse("tel:077789324");
//                Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
//
//                startActivity(callIntent);
//
//            }
//        });




    }



    public void callNumber(View view){

        Uri number = Uri.parse("tel:077789324");
        Intent callIntent = new Intent(Intent.ACTION_DIAL, number);

        startActivity(callIntent);
    }

    public void findLocation(View view){
        // Build the intent
        Uri location = Uri.parse("geo:0,0?q=1600+Amphitheatre+Parkway,+Mountain+View,+California");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);

        // Verify it resolves
        PackageManager packageManager = getPackageManager();
        List<ResolveInfo> activities = packageManager.queryIntentActivities(mapIntent, 0);
        boolean isIntentSafe = activities.size() > 0;

        // Start an activity if it's safe
        if (isIntentSafe) {
            startActivity(mapIntent);
        }
    }


    public void openEmail(View view){
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        // The intent does not have a URI, so declare the "text/plain" MIME type
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {"jon@example.com"}); // recipients
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "New Subject");
        String message = emailIntent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        emailIntent.putExtra(Intent.EXTRA_TEXT, message);
        //emailIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse("content://path/to/email/attachment"));
        // You can also attach multiple items by passing an ArrayList of Uris


        startActivity(emailIntent);
    }

    public void browseWeb(View view){
                //Build the intent
                Uri webpage = Uri.parse("http://www.android.com");
                Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);


                // Verify it resolves
                PackageManager packageManager = getPackageManager();
                List<ResolveInfo> activities = packageManager.queryIntentActivities(webIntent, 0);
                boolean isIntentSafe = activities.size() > 0;

                // Start an activity if it's safe
                if (isIntentSafe) {
                    startActivity(webIntent);
                }

    }




}
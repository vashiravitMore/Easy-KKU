package muenruekham.vashiravit.easykku;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class ServiceActivity extends AppCompatActivity {

    //Explicit
    private ListView listView;
    private String[] nameStrings,
                    phoneStrings,
                    imageStrings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        //Bind widget
        listView = (ListView) findViewById(R.id.livFriend);

        // Receive value form Intend
        nameStrings = getIntent().getStringArrayExtra("Name");
        phoneStrings = getIntent().getStringArrayExtra("Phone");
        imageStrings = getIntent().getStringArrayExtra("Image");


        // Create ListView
        MyAdapter myAdapter = new MyAdapter(ServiceActivity.this,
                nameStrings,
                phoneStrings,
                imageStrings);
        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //
                confirmCall(nameStrings[i], phoneStrings[i]);

            } // On Item Click

        });





    } // main method

    private void confirmCall(String nameString, String phoneString) {
    }


} // Main class

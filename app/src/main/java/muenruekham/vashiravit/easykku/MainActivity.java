package muenruekham.vashiravit.easykku;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    // Explicit
    private Button signInButton, signUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Bind Widget
        signInButton = (Button) findViewById(R.id.btn_signIn);
        signUpButton = (Button) findViewById(R.id.btn_signUp);

        // Sign Up Controller
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(
                        MainActivity.this,
                        SignUpActivity.class
                ));
            }
        });




    } // Main Method

} // Main Class นี้คือ คลาสหลัก


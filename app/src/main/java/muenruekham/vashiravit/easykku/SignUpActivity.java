package muenruekham.vashiravit.easykku;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

public class SignUpActivity extends AppCompatActivity {

    // Explicit
    private EditText nameEditText,
                phoneEditText,
                passwordEditText,
                userEditText;
    private ImageView imageView;
    private Button button;
    private String nameString,
                phoneString,
                passwordString,
                userString;

    public SignUpActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //Bing widget
        nameEditText = (EditText) findViewById(R.id.edtName);
        phoneEditText = (EditText) findViewById(R.id.edtPhone);
        userEditText = (EditText) findViewById(R.id.edtUser);
        passwordEditText = (EditText) findViewById(R.id.edtPassword);
        imageView = (ImageView) findViewById(R.id.imgViewProfile);
        button = (Button) findViewById(R.id.btnSignUp);

        //sign up  controller
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Get Value From Edit Text
                nameString = nameEditText.getText().toString().trim();
                phoneString = phoneEditText.getText().toString().trim();
                userString = userEditText.getText().toString().trim();
                passwordString = passwordEditText.getText().toString().trim();

                // Check Space
                if (nameString.equals("") ||
                        phoneString.equals("") ||
                        userString.equals("") ||
                        passwordString.equals("") ) {
                    // Have Space
                    Log.d("12novV1", "Have Space");
                    MyAlert myAlert = new MyAlert(SignUpActivity.this,
                            R.drawable.nobita48,
                            "มีช่องว่าง",
                            "กรุณากรองให้ครบทุกช่อง");
                    myAlert.myDialog();


                }


            } // onClick
        });




    } // Main Method

} // Main Class

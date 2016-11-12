package muenruekham.vashiravit.easykku;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

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
                userString,
                imagePathString,
                imageNameString;

    private Uri uri; // เก็บ uri จาก gallery


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

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
                        passwordString.equals("")) {
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

        // Image Controller
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_GET_CONTENT); // ไปทำงานที่โปรแกรมอื่น
                intent.setType("image/*"); // ให้เป็นโปรแกรมที่ทำการดูภาพ
                startActivityForResult(
                        intent.createChooser(intent, "โปรดเลือกแอปดูภาพ"),
                        0);  // 0 คือตัวเลือกรูปภาพ


            } // onClick
        });

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    } // Main Method

    @Override //  onActivityResult จากการกด Ctrl + o
    protected void onActivityResult(int requestCode,
                                    int resultCode,
                                    Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if ((requestCode == 0) && (resultCode == RESULT_OK)) {

            Log.d("12novV1", "Result OK");

            // show Image
            uri = data.getData();
            try {
                Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver()
                        .openInputStream(uri));
                imageView.setImageBitmap(bitmap);

            } catch (Exception e) {
                e.printStackTrace();
            }

            // Find path of Image
            imagePathString = myFindPath(uri);
            Log.d("12novV1", "Image Path : "+ imagePathString);

            // Find Name Of Image
            imageNameString = imagePathString.substring(imagePathString.lastIndexOf("/"));
            Log.d("12novV1", "Image Name : " + imageNameString);



        } // if


    }

    private String myFindPath(Uri uri) {
        String result = null;

        String[] strings = {MediaStore.Images.Media.DATA};
        Cursor cursor = getContentResolver().query(uri, strings, null, null, null);
        if (cursor != null) {

            cursor.moveToFirst();
            int index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            result = cursor.getString(index); // choose index image


        } else {
            result = uri.getPath();
        }

        return result;
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("SignUp Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
} // Main Class

package muenruekham.vashiravit.easykku;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Created by vashi on 12-Nov-16.
 */

public class MyAlert {

    // Explicit

    private Context context;
    private int anInt; // mean Icon
    private String titleString, messageString;

    public MyAlert(Context context, int anInt, String titleString, String messageString) {
        this.context = context;
        this.anInt = anInt;
        this.titleString = titleString;
        this.messageString = messageString;
    }

    public void myDialog () {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setCancelable(false); // user กด ok ข้อความจะหายไป เนื่องจากห้าม undo
        builder.setIcon(anInt);
        builder.setTitle(titleString);
        builder.setMessage(messageString);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.show();



    }  // myDialog
} // Main Class

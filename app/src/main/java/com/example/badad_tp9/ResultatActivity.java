package com.example.badad_tp9;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.badad_tp9.R;

public class ResultatActivity extends AppCompatActivity {


    private NotificationManagerCompat notificationManagerCompat;
    Integer resultat;
    TextView resultatText;
    TextView resultatBof;
    TextView resultatCool;
    TextView resultatNul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultat);

        resultatText = (TextView) findViewById(R.id.textViewResultat);
        resultatBof = (TextView) findViewById(R.id.textViewBof);
        resultatCool = (TextView) findViewById(R.id.textViewCool);
        resultatNul = (TextView) findViewById(R.id.textViewNull);


        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        resultat = Integer.valueOf(message);

        resultatText.setText(message+"/2");

        this.notificationManagerCompat = NotificationManagerCompat.from(this);

        if (resultat == 0){
            resultatNul.setVisibility(View.VISIBLE);
            echecChannel();
        }
        if(resultat == 1){
            resultatBof.setVisibility(View.VISIBLE);
            echecChannel();
        }
        if(resultat == 2){
            resultatCool.setVisibility(View.VISIBLE);
            reussiteChannel();
        }
    }

    private void reussiteChannel()  {

        Intent notifyIntent = new Intent(this, CalculatriceActivity.class);
        notifyIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent notifyPendingIntent = PendingIntent.getActivity(
                this, 0, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT
        );

        String title = "Bravo !";
        String message = "Vous avez réussi ! N'hésitez pas à utiliser cette superbe calculatrice ! ";

        Notification notification = new NotificationCompat.Builder(this, NotificationApp.CHANNEL_1_ID)
                .setSmallIcon(R.drawable.icon_notify1)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setContentIntent(notifyPendingIntent)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();

        int notificationId = 1;
        this.notificationManagerCompat.notify(notificationId, notification);
    }

    private void echecChannel()  {
        String title = "Echec";
        String message = "Malheureusement vous avez échoué. Ce n'est pas grave !";

        Notification notification = new NotificationCompat.Builder(this, NotificationApp.CHANNEL_2_ID)
                .setSmallIcon(R.drawable.icon_notify2)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setCategory(NotificationCompat.CATEGORY_PROMO) // Promotion.
                .build();

        int notificationId = 2;
        this.notificationManagerCompat.notify(notificationId, notification);
    }
}

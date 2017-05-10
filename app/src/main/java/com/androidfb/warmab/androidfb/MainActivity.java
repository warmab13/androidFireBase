package com.androidfb.warmab.androidfb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    private static final String TAGLOG = "firebase-db";

    private TextView lblCielo;
    private TextView lblTemperatura;
    private TextView lblHumedad;
    private Button btnEliminarListener;

    private DatabaseReference dbCielo;
    private DatabaseReference dbPrediccion;
    private ValueEventListener eventListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lblCielo = (TextView)findViewById(R.id.lblCielo);
        lblTemperatura = (TextView)findViewById(R.id.lblTemperatura);
        lblHumedad = (TextView)findViewById(R.id.lblHumedad);
        btnEliminarListener = (Button)findViewById(R.id.btnEliminarListener);

        btnEliminarListener.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                dbPrediccion.removeEventListener(eventListener);
            }
        });

        dbPrediccion = FirebaseDatabase.getInstance().getReference().child("prediccion-hoy");

        eventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Prediccion pred = dataSnapshot.getValue(Prediccion.class);
                lblCielo.setText(pred.getCielo());
                lblTemperatura.setText(pred.getTemperatura() + "ºC");
                lblHumedad.setText(pred.getHumedad() + "%");
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e(TAGLOG, "Error!", databaseError.toException());
            }
        };

        dbPrediccion.addValueEventListener(eventListener);
    }
}

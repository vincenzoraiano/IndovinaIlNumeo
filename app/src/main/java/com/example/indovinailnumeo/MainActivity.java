package com.example.indovinailnumeo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //Dichiaro. le varibili fuori dai metodi cosi da renderle globali.
    int numeroRandom;
    //Dichiaro una variabile String da inizializzare all'interno del while loop.
    String messaggio;
    int numeroTentativi=0;

    //Rendo interattivo il bottone creando il metodo.
    public  void bottoneControlla(View view){

        //Creo una variabile che casta in EditText il numero inserito dall'utente.
        EditText numeroInseritoUtente=(EditText) findViewById(R.id.numeroInserito);

        //Creo una variabile int alla quale assegno il valore prima trasformato in stringa.
        //con il metodo toString.
        //e poi trasforma la stringa in integer col metodo parseInt.
       int numeroInteger=Integer.parseInt(numeroInseritoUtente.getText().toString());

       //creo un whle loop per iterare finche il valore dei tentativi non è pari a 10.
        while(numeroTentativi!=10) {
            if (numeroInteger > numeroRandom) {

                messaggio = "Il numero è minore";

            } else if (numeroInteger < numeroRandom) {

                messaggio = "Il numero è maggiore";

            } else {

                messaggio = "Numero indovinato";
            }
            //Superati i costrutti di controllo  printo il messaggio madificato all'interno dei costrutti
            Toast.makeText(this, messaggio, Toast.LENGTH_SHORT).show();
            //Incremento il numero di tentativi
            numeroTentativi++;

            if(numeroTentativi==10){
                //raggiunto il numero di tentativi printo questo messaggio.
                 Toast.makeText(this,"Numero non indovinato e numero di tentativi esauriti, riavviare l'app",Toast.LENGTH_SHORT).show();
                break;
             }

        }

        //Controllo le variabili con i log.
        //Prendo la variabile edittext e la converto in stringa
        Log.i("Numero inserito",numeroInseritoUtente.getText().toString());
        //prendo il valore integer in int e lo trasformo in stringa
        Log.i("Il numero random",Integer.toString(numeroRandom));
    }


    //metodo che viene utilizzato quando l'app viene avviata.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //creo una referenza alla classe random nel metodo onCreate.
        Random ran=new Random();
        //assegno alla variabile numeroRandom
        //il numero all'interno della varaibile parte da 0.
        numeroRandom=ran.nextInt(20)+1;




    }
}

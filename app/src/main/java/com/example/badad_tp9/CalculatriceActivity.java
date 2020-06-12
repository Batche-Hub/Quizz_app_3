package com.example.badad_tp9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CalculatriceActivity extends AppCompatActivity{

    private Button addition,soustraction,multiplication,division,egal,
            un,deux,trois,quatre,cinq,six,sept,huit,neuf,zero,
            virgule,clear, retourAccueil;

    private float valeur1, valeur2, resultat;

    private boolean additionBool, soustrationBool, multiplicationBool, divisionBool, calculFaitBool = false;

    private TextView ecranResultat;
    private TextView ecranCalculs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculatrice);
        init();

        System.out.println(ecranCalculs.getText());
    }

    private void init(){
        addition = (Button) findViewById(R.id.buttonPlus);
        soustraction = (Button) findViewById(R.id.buttonMoins);
        multiplication = (Button) findViewById(R.id.buttonMultiplier);
        division = (Button) findViewById(R.id.buttonDiviser);
        egal = (Button) findViewById(R.id.buttonEgal);
        un = (Button) findViewById(R.id.buttonUn);
        deux = (Button) findViewById(R.id.buttonDeux);
        trois = (Button) findViewById(R.id.buttonTrois);
        quatre = (Button) findViewById(R.id.buttonQuatre);
        cinq = (Button) findViewById(R.id.buttonCinq);
        six = (Button) findViewById(R.id.buttonSix);
        sept = (Button) findViewById(R.id.buttonSept);
        huit = (Button) findViewById(R.id.buttonHuit);
        neuf = (Button) findViewById(R.id.buttoNeuf);
        zero = (Button) findViewById(R.id.buttonZero);
        virgule = (Button) findViewById(R.id.buttonVirgule);
        clear = (Button) findViewById(R.id.buttonEffacer);
        retourAccueil = (Button) findViewById(R.id.buttonAccueil);

        ecranResultat = (TextView) findViewById(R.id.textViewEcranResultat);
        ecranCalculs = (TextView) findViewById(R.id.textViewEcranCalculs);

        addition.setOnClickListener(additionListener);
        soustraction.setOnClickListener(soustractionListener);
        multiplication.setOnClickListener(multiplicationListener);
        division.setOnClickListener(divisionListener);
        egal.setOnClickListener(egalListener);
        un.setOnClickListener(unListener);
        deux.setOnClickListener(deuxListener);
        trois.setOnClickListener(troisListener);
        quatre.setOnClickListener(quatreListener);
        cinq.setOnClickListener(cinqListener);
        six.setOnClickListener(sixListener);
        sept.setOnClickListener(septListener);
        huit.setOnClickListener(huitListener);
        neuf.setOnClickListener(neufListener);
        zero.setOnClickListener(zeroListener);
        virgule.setOnClickListener(virguleListener);
        clear.setOnClickListener(clearListener);
        retourAccueil.setOnClickListener(retourAccueilListener);
    }


    private View.OnClickListener additionListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (ecranCalculs.getText().length() == 0) {
                ecranCalculs.setText("");
                Toast toast = Toast.makeText(CalculatriceActivity.this, "Une chiffre ! Un chiffre ! !", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER_HORIZONTAL,0,0);
                toast.show();
            } else {
                valeur1 = Float.parseFloat(ecranCalculs.getText() + "");
                additionBool = true;
                ecranCalculs.setText(null);
            }
        }
    };

    private View.OnClickListener soustractionListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (ecranCalculs.getText().length() == 0) {
                ecranCalculs.setText("");
                Toast toast = Toast.makeText(getApplicationContext(), "Veuillez entrer un chiffre svp", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER_HORIZONTAL,0,0);
                toast.show();
            } else {
                valeur1 = Float.parseFloat(ecranCalculs.getText() + "");
                soustrationBool = true;
                ecranCalculs.setText(null);
            }
        }
    };

    private View.OnClickListener multiplicationListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (ecranCalculs.getText().length() == 0) {
                Toast toast = Toast.makeText(getApplicationContext(), "Ouille !", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER_HORIZONTAL,0,0);
                toast.show();
                ecranCalculs.setText("");
            } else {
                valeur1 = Float.parseFloat(ecranCalculs.getText() + "");
                multiplicationBool = true;
                ecranCalculs.setText(null);
            }
        }
    };

    private View.OnClickListener divisionListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (ecranCalculs.getText().length() == 0) {
                Toast toast = Toast.makeText(getApplicationContext(), "Nooooooon !", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER_HORIZONTAL,0,0);
                toast.show();
                ecranCalculs.setText("");
            } else {
                valeur1 = Float.parseFloat(ecranCalculs.getText() + "");
                divisionBool = true;
                ecranCalculs.setText(null);
            }
        }
    };

    private View.OnClickListener egalListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            System.out.println(ecranCalculs.getText().length());
            if (ecranCalculs.getText().length() == 0) {
                Toast toast = Toast.makeText(CalculatriceActivity.this, "Rhoo !", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER_HORIZONTAL,0,0);
                toast.show();
                ecranCalculs.setText("");
            } else {
                valeur2 = Float.parseFloat(ecranCalculs.getText() + "");
                calculFaitBool = true;
                if (additionBool) {
                    ecranResultat.setText(String.valueOf(valeur1 + valeur2));
                    ecranCalculs.setText(null);
                    resultat = valeur1 + valeur2;
                    additionBool = false;
                    System.out.println(ecranCalculs.getText().length());
                }

                if (soustrationBool) {
                    ecranResultat.setText(String.valueOf(valeur1 - valeur2));
                    ecranCalculs.setText(null);
                    resultat = valeur1 - valeur2;
                    soustrationBool = false;
                }

                if (multiplicationBool) {
                    ecranResultat.setText(String.valueOf(valeur1 * valeur2));
                    ecranCalculs.setText(null);
                    resultat = valeur1 * valeur2;
                    multiplicationBool = false;
                }

                if (divisionBool) {
                    ecranResultat.setText(String.valueOf(valeur1 / valeur2));
                    ecranCalculs.setText(null);
                    resultat = valeur1 / valeur2;
                    divisionBool = false;
                }

            }
        }
    };

    private View.OnClickListener unListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ecranCalculs.setText(ecranCalculs.getText().toString()+"1");
        }
    };

    private View.OnClickListener deuxListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ecranCalculs.setText(ecranCalculs.getText().toString()+"2");
        }
    };

    private View.OnClickListener troisListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ecranCalculs.setText(ecranCalculs.getText().toString()+"3");
        }
    };

    private View.OnClickListener quatreListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ecranCalculs.setText(ecranCalculs.getText().toString()+"4");
        }
    };

    private View.OnClickListener cinqListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ecranCalculs.setText(ecranCalculs.getText().toString()+"5");
        }
    };

    private View.OnClickListener sixListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ecranCalculs.setText(ecranCalculs.getText().toString() + "6");
        }
    };

    private View.OnClickListener septListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ecranCalculs.setText(ecranCalculs.getText().toString()+"7");
        }
    };

    private View.OnClickListener huitListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ecranCalculs.setText(ecranCalculs.getText().toString()+"8");
        }
    };

    private View.OnClickListener neufListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ecranCalculs.setText(ecranCalculs.getText().toString()+"9");
        }
    };

    private View.OnClickListener zeroListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ecranCalculs.setText(ecranCalculs.getText().toString()+"0");
        }
    };

    private View.OnClickListener virguleListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (ecranCalculs.getText().length() == 0) {
                ecranCalculs.setText("0.");
            }else if(ecranCalculs.getText().toString().contains(".")){
                ecranCalculs.setText(ecranCalculs.getText().toString());
            }else{
                ecranCalculs.setText(ecranCalculs.getText().toString()+".");
            }
        }
    };

    private View.OnClickListener clearListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ecranResultat.setText(null);
            ecranCalculs.setText(null);
        }
    };

    private View.OnClickListener retourAccueilListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if(calculFaitBool) {
                String resultatStr = String.valueOf(resultat);
                Intent intent = new Intent();
                intent.putExtra("RESULTAT", resultatStr);
                setResult(2, intent);
                finish();
            }else if (!calculFaitBool){
                String resultatStr= "Aucun calcul n'a été fait !";
                Intent intent2 = new Intent();
                intent2.putExtra("NORESULTAT", resultatStr);
                setResult(1, intent2);
                finish();
            }
        }
    };



}

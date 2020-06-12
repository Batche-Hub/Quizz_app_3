package utils;

import android.util.SparseBooleanArray;
import android.widget.ListView;

import com.example.badad_tp9.Answer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Utils {

    private Utils() {
    }

    public static List<Answer> fabriquerListeBonnesReponse(Answer[] tableauReponses){
        List<Answer> listeBonneReponses = new ArrayList<>();
        List<Answer> list = new ArrayList<>(Arrays.asList(tableauReponses));

        for(Answer a : list){
            if(a.getAnswerIsCorrect() == true){
                listeBonneReponses.add(a);
            }
        }
        return listeBonneReponses;
    }

    public static List<Answer>fabriquerListeReponsesDonnees(SparseBooleanArray sp, ListView listView){
        List<Answer> listReponsesDonnees = new ArrayList<>();
        for(int i=0;i<sp.size();i++){
            if(sp.valueAt(i)==true){
                listReponsesDonnees.add((Answer) listView.getItemAtPosition(i));
            }
        }
        return listReponsesDonnees;
    }
}

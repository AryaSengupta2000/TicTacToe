package com.example.tictac;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int player1 = 0;
    int[] play={2,2,2,2,2,2,2,2,2,2};
    int[][] sol={{1,2,3},{4,5,6},{7,8,9},{1,4,7},{2,5,8},{3,6,9},{1,5,9},{3,5,7}};
    public void dropIn (View view) {
        ImageView counter;
        counter = (ImageView) view;
        String winner="";
        //counter.setTranslationY(-1000f);
        //counter.animate().translationXBy(1000f).setDuration(200);
        System.out.println(counter.getTag().toString());
        int pos = Integer.parseInt(counter.getTag().toString());
        if (play[pos] == 2) {
            play[pos] = player1;
            if (player1 == 0) {
                counter.setImageResource(R.drawable.o);
                player1 = 1;
            } else {
                counter.setImageResource(R.drawable.cross);
                player1 = 0;
            }
            for (int[] sol : sol) {
                if (play[sol[0]] == play[sol[1]] && play[sol[1]] == play[sol[2]] && play[sol[0]] != 2) {
                    winner = "circle won!!";
                    if (play[sol[0]] == 1) {
                        winner = "cross won!!";
                        if (play[sol[0]] != play[sol[1]] && play[sol[1]] != play[sol[2]] && play[sol[0]] != 2){
                            winner = "draw";
                        }
                    }
                }
            }
                Toast.makeText(this,winner.toString(), Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}


package com.example.week7tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // 1) is the imageview already have an image X O
    // 2) we have to keep track of whatis in it? X or O
    // 3) keep track of the turns...
    // 4) keep track of whose winning?
    // assume 0 is player  nought (0)
    // assume 1 is player cross (x)
    // assume -1 is when the cells are empty..

    private int player = 0; // player o starts the game
                                // {0,1,2,3,4...8}
    private int[] gameState = {-1, -1, -1, -1, -1, -1, -1, -1, -1};

    int[][] winning_position ={{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}};

    boolean isActive = true;
    // call this function when an event happens ...
    public void dropImage(View v){

        ImageView iv = (ImageView) v;


        int state = Integer.valueOf(iv.getTag().toString());

        if(gameState[state] == -1 && isActive){
            gameState[state] = player;

            iv.setTranslationY(-2000); // animation

            if(player == 0){
                iv.setImageResource(R.drawable.nought);
                player = 1;
            }
            else{
                iv.setImageResource(R.drawable.cross);
                player = 0;

            }
            iv.animate().translationYBy(2000).setDuration(300);
            for (int [] winningPosition : winning_position)

            {
                if(gameState[winningPosition[0]] == gameState[winningPosition[1]] &&
                        gameState[winningPosition[1]] ==gameState[winningPosition[2]]
                        && gameState[winningPosition[0]] != -1)
                {

                    isActive = false;
                String winner = (player == 0) ? "Cross": "Nought";

                    Toast.makeText(this, "The winner is "+winner, Toast.LENGTH_LONG).show();
                }



            }


        }




    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
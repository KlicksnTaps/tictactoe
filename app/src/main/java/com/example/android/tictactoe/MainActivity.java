package com.example.android.tictactoe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int checker[][];
    int i, j;
    int player;
    Button b[][];
    TextView txtv;
    Button newgame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    private void SetBoard() {
        b = new Button[4][4];
        checker = new int[4][4];
        txtv = (TextView) findViewById(R.id.txt);
        newgame = (Button) findViewById(R.id.newgame);

        newgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (newgame.isEnabled()) {
                    newgame.setText("Player One Plays");
                    player = 0;
                    SetBoard();

                }
            }


        });


        b[1][1] = findViewById(R.id.but1);
        b[1][2] = findViewById(R.id.but2);
        b[1][3] = findViewById(R.id.but3);
        b[2][1] = findViewById(R.id.but4);
        b[2][2] = findViewById(R.id.but5);
        b[2][3] = findViewById(R.id.but6);
        b[3][1] = findViewById(R.id.but7);
        b[3][2] = findViewById(R.id.but8);
        b[3][3] = findViewById(R.id.but9);
        for (int i; i <= 3; i++) {
            for (int j; j <= 3; j++)
                checker[i][j] = 2;

        }
        for (int i; i <= 3; i++) {
            for (int j; j <= 3; j++) {
                b[i][j].setOnClickListener(new MyClickListener));
                if (!b[i][j].isEnabled()) {
                    b[i][j].setText("");
                    b[i][j].setEnabled(true);
                }
            }
        }
    }

    abstract class MyClickListener implements View.OnClickListener {

        int x;
        int y;


    public MyClickListener(int x, int y) {
        {
            this.x = x;
            this.y = y;



    public void onClick(View view) {
        if (b[x][y].isEnabled()) {
            b[x][y].setEnabled(false);
            if (player == 0) {
                b[x][y].setText("X");
                player = (player + 1) % 2;
                checker[x][y] = 0;
                CheckScores();
            } else {
                b[x][y].setText("O");
                player = (player + 1) % 2;
                checker[x][y] = 1;
                CheckScores();

            }
        }
    }

}

    private boolean CheckScores() {
        boolean gameOver = false;
        if ((checker[1][1] == 0 && checker[2][2] == 0 && checker[3][3] == 0)
                || (checker[1][3] == 0 && checker[2][2] == 0 && checker[3][1] == 0)
                || (checker[1][2] == 0 && checker[2][2] == 0 && checker[3][2] == 0)
                || (checker[1][3] == 0 && checker[2][3] == 0 && checker[3][3] == 0)
                || (checker[1][1] == 0 && checker[1][2] == 0 && checker[1][3] == 0)
                || (checker[2][1] == 0 && checker[2][2] == 0 && checker[2][3] == 0)
                || (checker[3][1] == 0 && checker[3][2] == 0 && checker[3][3] == 0)
                || (checker[1][1] == 0 && checker[2][1] == 0 && checker[3][1] == 0)) {
            txtv.setText("Player 1 Wins");
            gameOver = true;
        } else if ((checker[1][1] == 1 && checker[2][2] == 1 && checker[3][3] == 1)
                || (checker[1][3] == 1 && checker[2][2] == 1 && checker[3][1] == 1)
                || (checker[1][2] == 1 && checker[2][2] == 1 && checker[3][2] == 1)
                || (checker[1][3] == 1 && checker[2][3] == 1 && checker[3][3] == 1)
                || (checker[1][1] == 1 && checker[1][2] == 1 && checker[1][3] == 1)
                || (checker[2][1] == 1 && checker[2][2] == 1 && checker[2][3] == 1)
                || (checker[3][1] == 1 && checker[3][2] == 1 && checker[3][3] == 1)
                || (checker[1][1] == 1 && checker[2][1] == 1 && checker[3][1] == 1)) {
            txtv.setText("Player 2 Wins");
            gameOver = true;
        } else {
            boolean empty = false;
            for (i = 1; i <= 3; i++) {
                for (j = 1; j <= 3; j++) {
                    if (checker[i][j] == 2) {
                        empty = true;
                        break;
                    }
                }
            }
            if (!empty) {
                gameOver = true;
                txtv.setText("Draw!");

            }
        }
        if (gameOver)

            for (i = 1; i <= 3; i++) {
                for (j = 1; j <= 3; j++) {
                    b[i][j].setEnabled(false);
                }
            }

        return gameOver;
    }
}

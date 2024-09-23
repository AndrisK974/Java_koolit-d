package com.example.kodutoo6_andris_koiv;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Random;

public class TripsTrapsTrull extends Application {

    private static final int BOARD_SIZE = 4;
    private static final String EMPTY_CELL = " ";
    private static final String PLAYER_X = "X";
    private static final String PLAYER_O = "O";

    private Button[][] buttons = new Button[BOARD_SIZE][BOARD_SIZE];
    private boolean xTurn = true; // Kas X mängija käib
    private Random random = new Random();

    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();
        initializeButtons(gridPane);

        Scene scene = new Scene(gridPane, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Trips-Traps-Trull");
        primaryStage.show();
    }

    private void initializeButtons(GridPane gridPane) {
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                Button button = new Button(EMPTY_CELL);
                button.setPrefSize(50, 50);
                button.setOnAction(event -> handleButtonClick(button));
                buttons[row][col] = button;
                gridPane.add(button, col, row);
            }
        }
    }

    private void handleButtonClick(Button button) {
        if (!button.getText().equals(EMPTY_CELL)) {
            return; // Ära tee midagi, kui ruut on juba käidud
        }


        button.setText(PLAYER_X);
        if (checkWin()) {
            System.out.println("X võitis!");
            resetBoard();
            return;
        }

        if (checkDraw()) {
            System.out.println("Viik!");
            resetBoard();
            return;
        }

        computerMove();
        if (checkWin()) {
            System.out.println("O võitis!");
            resetBoard();
            return;
        }

        if (checkDraw()) {
            System.out.println("Viik!");
            resetBoard();
            return;
        }
    }

    private void computerMove() {
        // 1. Kontrolli, kas arvutil on võiduvõimalus (rida, veerg või diagonaal)
        if (checkWinningMove(PLAYER_O)) {
            return; // Arvuti võitis
        }

        // 2. Kontrolli, kas mängijal on võiduvõimalus (rida, veerg või diagonaal), ja blokeeri see
        if (checkWinningMove(PLAYER_X)) {
            return; // Blokeeriti mängija võiduvõimalus
        }

        if (makeStrategicMove()) {
            return; // Kui strateegiline käik tehti, lõpeta arvuti käik siin
        }
        makeRandomMove();

    }
    private boolean makeStrategicMove() {
        // Kontrolli, kas arvutil on võimalik teha võiduvõimalus kahes järjestikuses kohas
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                if (buttons[row][col].getText().equals(EMPTY_CELL)) {
                    buttons[row][col].setText(PLAYER_O);
                    if (checkWinningMove(PLAYER_O)) {
                        return true;
                    }
                    buttons[row][col].setText(EMPTY_CELL);
                }
            }
        }

        // Kui vastane mängija ähvardab võita, blokeeri see käik
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                if (buttons[row][col].getText().equals(EMPTY_CELL)) {
                    buttons[row][col].setText(PLAYER_X);
                    if (checkWinningMove(PLAYER_X)) {
                        buttons[row][col].setText(PLAYER_O);
                        return true;
                    }
                    buttons[row][col].setText(EMPTY_CELL);
                }
            }
        }

        // Kui mängija on teinud käigu keskele, mine vastukaaluks nurga juurde
        if (buttons[1][1].getText().equals(PLAYER_X)) {
            if (buttons[0][0].getText().equals(EMPTY_CELL)) {
                buttons[0][0].setText(PLAYER_O);
                return true;
            }
            if (buttons[0][3].getText().equals(EMPTY_CELL)) {
                buttons[0][3].setText(PLAYER_O);
                return true;
            }
            if (buttons[3][0].getText().equals(EMPTY_CELL)) {
                buttons[3][0].setText(PLAYER_O);
                return true;
            }
            if (buttons[3][3].getText().equals(EMPTY_CELL)) {
                buttons[3][3].setText(PLAYER_O);
                return true;
            }
        }
        return false;
    }
    private boolean makeRandomMove() {
        int row, col;
        do {
            row = random.nextInt(BOARD_SIZE);
            col = random.nextInt(BOARD_SIZE);
        } while (!buttons[row][col].getText().equals(EMPTY_CELL));
        buttons[row][col].setText(PLAYER_O);
        return true;
    }

    private boolean checkWinningMove(String player) {
        // Kontrollime ridu, veerge ja diagonaale
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col <= BOARD_SIZE - 4; col++) {
                if (buttons[row][col].getText().equals(EMPTY_CELL) &&
                        buttons[row][col + 1].getText().equals(player) &&
                        buttons[row][col + 2].getText().equals(player) &&
                        buttons[row][col + 3].getText().equals(EMPTY_CELL))
                {
                    buttons[row][col + 3].setText(player);
                    return true; // Võiduvõimalus reas
                }
            }
        }

        for (int col = 0; col < BOARD_SIZE; col++) {
            for (int row = 0; row <= BOARD_SIZE - 4; row++) {
                if (buttons[row][col].getText().equals(EMPTY_CELL) &&
                        buttons[row + 1][col].getText().equals(player) &&
                        buttons[row + 2][col].getText().equals(player) &&
                        buttons[row + 3][col].getText().equals(EMPTY_CELL)) {
                    buttons[row + 3][col].setText(player);
                    return true; // Võiduvõimalus veerus
                }
            }
        }

        for (int row = 0; row <= BOARD_SIZE - 4; row++) {
            for (int col = 0; col <= BOARD_SIZE - 4; col++) {
                if (buttons[row][col].getText().equals(EMPTY_CELL) &&
                        buttons[row + 1][col + 1].getText().equals(player) &&
                        buttons[row + 2][col + 2].getText().equals(player) &&
                        buttons[row + 3][col + 3].getText().equals(EMPTY_CELL)) {
                    buttons[row + 3][col + 3].setText(player);
                    return true; // Võiduvõimalus diagonaalis (ülevalt vasakult alla paremale)
                }
            }
        }

        for (int row = 3; row < BOARD_SIZE; row++) {
            for (int col = 0; col <= BOARD_SIZE - 4; col++) {
                if (buttons[row][col].getText().equals(EMPTY_CELL) &&
                        buttons[row - 1][col + 1].getText().equals(player) &&
                        buttons[row - 2][col + 2].getText().equals(player) &&
                        buttons[row - 3][col + 3].getText().equals(EMPTY_CELL)) {
                    buttons[row - 3][col + 3].setText(player);
                    return true; // Võiduvõimalus diagonaalis (ülevalt paremalt alla vasakule)
                }
            }
        }

        return false; // Pole võiduvõimalust
    }

    private boolean checkWin() {
        // Kontrollime ridu
        for (int row = 0; row < BOARD_SIZE; row++) {
            if (buttons[row][0].getText().equals(PLAYER_X) &&
                    buttons[row][1].getText().equals(PLAYER_X) &&
                    buttons[row][2].getText().equals(PLAYER_X) &&
                    buttons[row][3].getText().equals(PLAYER_X)) {
                return true; // X võitis reas
            }
        }

        // Kontrollime veerge
        for (int col = 0; col < BOARD_SIZE; col++) {
            if (buttons[0][col].getText().equals(PLAYER_X) &&
                    buttons[1][col].getText().equals(PLAYER_X) &&
                    buttons[2][col].getText().equals(PLAYER_X) &&
                    buttons[3][col].getText().equals(PLAYER_X)) {
                return true; // X võitis veerus
            }
        }

        // Kontrollime diagonaale
        if (buttons[0][0].getText().equals(PLAYER_X) &&
                buttons[1][1].getText().equals(PLAYER_X) &&
                buttons[2][2].getText().equals(PLAYER_X) &&
                buttons[3][3].getText().equals(PLAYER_X)) {
            return true; // X võitis diagonaalis (ülevalt vasakult alla paremale)
        }

        if (buttons[0][3].getText().equals(PLAYER_X) &&
                buttons[1][2].getText().equals(PLAYER_X) &&
                buttons[2][1].getText().equals(PLAYER_X) &&
                buttons[3][0].getText().equals(PLAYER_X)) {
            return true; // X võitis diagonaalis (ülevalt paremalt alla vasakule)
        }

        // Kui ei leitud võiduolukorda, siis mäng jätkub
        return false;
    }


    private boolean checkDraw() {
        // Kontrollime, kas kõik ruudud on täidetud
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                if (buttons[row][col].getText().equals(EMPTY_CELL)) {
                    return false; // Leiti tühi ruut, mäng ei ole viik
                }
            }
        }
        // Kui kõik ruudud on täidetud ja võiduolukorda ei tuvastatud, siis on viik
        return true;
    }

    private void resetBoard() {
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                buttons[row][col].setText(EMPTY_CELL);
            }
        }
        xTurn = true;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
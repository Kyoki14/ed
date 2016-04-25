package chessdesktop;

import Chess.ChessBoard;
import Chess.ChessPiece;
import Chess.ChessRandomAI;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class FXMLDocumentController implements Initializable {
	
    ChessBoardRenderer board = new ChessBoardRenderer();
    ChessRandomAI randomAI = new ChessRandomAI();
    ChessBoard boardAI = board.getBoard();

    boolean finished = false;
    boolean isWhiteTurn = true;

    @FXML
    private Label label;
    @FXML
    private Canvas canvas;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        board = new ChessBoardRenderer();
        board.draw(canvas);
        isWhiteTurn = true;
        finished = false;
        label.setText("");
        boardAI = board.getBoard();

    }

    @FXML
    private void handleSaveButtonAction(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save game");
        File file = fileChooser.showSaveDialog(null);
        if (file != null) {
            Charset charset = Charset.forName("US-ASCII");
            try (BufferedWriter outFile = Files.newBufferedWriter(file.toPath(), charset)) {
                board.getBoard().saveToFile(file);
                outFile.close();
            } 
            catch (IOException x) {
                System.err.format("IOException: %s%n", x);
            }
        }
    }

    @FXML
    private void handleLoadButtonAction(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open file");
        fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Txt Files", "*.txt"));
        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {
            try {
                Scanner inFile = new Scanner(selectedFile);
                board.getBoard().loadFromFile(selectedFile);
                inFile.close();

            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
            board.draw(canvas);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        board.draw(canvas);

        canvas.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
            Chess.ChessPiece piece = board.getPieceAt(canvas, e.getX(), e.getY());

            if(!finished){
                if (board.getMovingPiece() == piece) {
                    board.setMovingPiece(null);
                    board.draw(canvas);
                    return;
                }
                if (board.getMovingPiece() == null) {
                    if(piece.getColor() == ChessPiece.Color.WHITE && isWhiteTurn )
                    {
                        board.setMovingPiece(piece);
                        board.draw(canvas);
                        board.drawAvailablePositions(canvas,piece.getAvailablePositions(board.getBoard()));
                        return;
                    }

                    if(piece.getColor() == ChessPiece.Color.BLACK && !isWhiteTurn )
                    {
                        board.setMovingPiece(piece);
                        board.draw(canvas);
                        board.drawAvailablePositions(canvas,piece.getAvailablePositions(board.getBoard()));
                        return;
                    }
                }
                if (board.movePieceTo(canvas, e.getX(), e.getY())) {
                    board.setMovingPiece(null);
                    isWhiteTurn = !isWhiteTurn;
                    board.draw(canvas);
                    if (!board.containsKing(ChessPiece.Color.BLACK) || !board.containsKing(ChessPiece.Color.WHITE)) {
                            if (!board.containsKing(ChessPiece.Color.BLACK))
                                    label.setText("Ganan las blancas");
                            else
                                    label.setText("Ganan las negras");

                            finished=true;
                    }
                }

                if (!isWhiteTurn){
                    if (randomAI.performNextMovement( boardAI, ChessPiece.Color.BLACK))
                    {
                        isWhiteTurn = !isWhiteTurn;
                        board.draw(canvas);

                        if (!board.containsKing(ChessPiece.Color.BLACK) || !board.containsKing(ChessPiece.Color.WHITE)) {
                            if (!board.containsKing(ChessPiece.Color.BLACK))
                                label.setText("Ganan las blancas");
                            else
                                label.setText("Ganan las negras");
                        }
                        board.draw(canvas);
                    }
                }
            }
        });
    }
}
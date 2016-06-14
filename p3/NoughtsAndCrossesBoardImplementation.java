package tresenraya;

public class NoughtsAndCrossesBoardImplementation implements NoughtsAndCrossesBoard {
    
    private Color[][] board = new Color[3][3];
    private Color[][] temp = new Color[3][3];
     
    public NoughtsAndCrossesBoardImplementation() {
        
        board[0][0] = Color.RED;           
        board[1][0] = Color.VOID;         
        board[2][0] = Color.WHITE; 
        
        board[0][1] = Color.WHITE;          
        board[1][1] = Color.RED;           
        board[2][1] = Color.VOID; 
        
        board[0][2] = Color.RED;         
        board[1][2] = Color.VOID;          
        board[2][2] = Color.WHITE;  
        
        temp = board;
    }
                               
    @Override
    public boolean isGameOver() {
        // Diagonal
        if ( ((board[0][0] == Color.RED) && (board[1][1] == Color.RED) && (board[2][2] == Color.RED)) || 
                ((board[0][0] == Color.WHITE) && (board[1][1] == Color.WHITE) && (board[2][2] == Color.WHITE)) ) {
            return true;
        }
        else if ( ((board[2][0] == Color.RED) && (board[1][1] == Color.RED) && (board[0][2] == Color.RED)) || 
                ((board[2][0] == Color.WHITE) && (board[1][1] == Color.WHITE) && (board[0][2] == Color.WHITE)) ) {
            return true;
        }
        // Horizontal
        if ( ((board[0][0] == Color.RED) && (board[1][0] == Color.RED) && (board[2][0] == Color.RED)) || 
                ((board[0][0] == Color.WHITE) && (board[1][0] == Color.WHITE) && (board[2][0] == Color.WHITE)) ) {
            return true;
        }
        else if ( ((board[0][1] == Color.RED) && (board[1][1] == Color.RED) && (board[2][1] == Color.RED)) || 
                ((board[0][1] == Color.WHITE) && (board[1][1] == Color.WHITE) && (board[2][1] == Color.WHITE)) ) {
            return true;
        }
        else if ( ((board[0][2] == Color.RED) && (board[1][2] == Color.RED) && (board[2][2] == Color.RED)) || 
                ((board[0][2] == Color.WHITE) && (board[1][2] == Color.WHITE) && (board[2][2] == Color.WHITE)) ) {
            return true;
        }
        // Vertical
        if ( ((board[0][0] == Color.RED) && (board[0][1] == Color.RED) && (board[0][2] == Color.RED)) || 
                ((board[0][0] == Color.WHITE) && (board[0][1] == Color.WHITE) && (board[0][2] == Color.WHITE)) ) {
            return true;
        }
        else if ( ((board[1][0] == Color.RED) && (board[1][1] == Color.RED) && (board[1][2] == Color.RED)) || 
                ((board[1][0] == Color.WHITE) && (board[1][1] == Color.WHITE) && (board[1][2] == Color.WHITE)) ) {
            return true;
        }
        else if ( ((board[2][0] == Color.RED) && (board[2][1] == Color.RED) && (board[2][2] == Color.RED)) || 
                ((board[2][0] == Color.WHITE) && (board[2][1] == Color.WHITE) && (board[2][2] == Color.WHITE)) ) {
            return true;
        }
        
        
        
        return false;
    }

    @Override
    public boolean movePiece(int fromX, int fromY, int toX, int toY) {
        
        if ( (fromX == toX) && (fromY == toY) ) {
            return false;
        }
              
        if (((fromX >= 0) && (fromX <= 2)) && ((fromY >= 0) && (fromY <= 2))) {
            if (((toX >= 0) && (toX <= 2)) && ((toY >= 0) && (toY <= 2))) {
                
                if ( (board[fromX][fromY] == Color.RED) && (board[toX][toY] == Color.WHITE)) {
                    return false;
                }
                else if ((board[fromX][fromY] == Color.WHITE) && (board[toX][toY] == Color.RED)) {
                    return false;
                }
                
                if ((board[fromX][fromY] == Color.WHITE) && (board[toX][toY] == Color.WHITE)) {
                    return false;
                }
                else if ((board[fromX][fromY] == Color.RED) && (board[toX][toY] == Color.RED)) {
                    return false;
                }
                
                else {

                    if (canMovePieceAt(toX, toY)) {
                        temp[toX][toY] = getPieceAt(fromX, fromY);
                        temp[fromX][fromY] = Color.VOID;

                        board = temp;

                        return true;
                    }
                }
                
             
            }                
          
        }
         
        return false;
    }

    @Override
    public Color getPieceAt(int x, int y) {
        if (((x >= 0) && (x <= 2)) && ((y >= 0) && (y <= 2))) {
            if (board[x][y] == Color.WHITE) {
                return Color.WHITE;
            }
            else if (board[x][y] == Color.RED) {
                return Color.RED;
            }
        }     
        return Color.VOID;
    }

    @Override
    public boolean canMovePieceAt(int x, int y) {
        
        if (((x >= 0) && (x <= 2)) && ((y >= 0) && (y <= 2))) {
            
            if ( (getPieceAt(x, y) != Color.WHITE) || (getPieceAt(x, y) != Color.RED)) {
                return true;
            }

        }
              
        return false;
    }
    
}

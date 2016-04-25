package Chess;

public class ChessPieceImplementation implements ChessPiece {

    private Color color;
    private Type type;
    private boolean hasBeenMoved;
    
    public ChessPieceImplementation(Color color, Type type) {
        this.color = color;
        this.type = type;
        hasBeenMoved = false;
    }
    public ChessPieceImplementation(Color color, Type type, boolean hasBeenMoved) {
        this.color = color;
        this.type = type;
        this.hasBeenMoved = hasBeenMoved;
    }
    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public void notifyMoved() {
        hasBeenMoved = true;
    }

    @Override
    public boolean wasMoved() {
        return hasBeenMoved;
    }

    @Override
    public PiecePosition[] getAvailablePositions(ChessBoard aBoard) {
     
        switch (getType()) {
            case BISHOP:
                return ChessMovementManager.getAvailablePositionsOfBishop(this,aBoard);
            case KING:
                return ChessMovementManager.getAvailablePositionsOfKing(this,aBoard);
            case KNIGHT:
                return ChessMovementManager.getAvailablePositionsOfKnight(this,aBoard);
            case QUEEN:
                return ChessMovementManager.getAvailablePositionsOfQueen(this,aBoard);
            case ROOK:
                return ChessMovementManager.getAvailablePositionsOfRook(this,aBoard);
            default:
                return ChessMovementManager.getAvailablePositionsOfPawn(this,aBoard);
        }              
    }
}

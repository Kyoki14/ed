package Chess;

public class PiecePosition {

    /**
     * @param column Columna a comprobar.
     * @param row Fila a comprobar
     * @return Devuelve true si en la columna y fila dadas la posición está disponible
     * dentro de los límites máximos de 8 filas y 8 columnas y false en caso contrario.
     */
    public static boolean isAvailable(int column, int row) {
        return column >= 0 && column < 8 && row >= 0 && row < 8;
    }

    /**
     * @param position Posición de una pieza que contiene su fila y su columna actual.
     * @param columnIncrement Indica el número por el que incrementará la columna de la pieza.
     * @param rowIncrement Indica el número por el que incrementará la fila de la pieza.
     * @return Devuelve true si la nueva positión de la pieza está disponible, en caso contrario
     * se devuelve false y los incrementos de fila y columna de la pieza no se efectuan.
     */
    static boolean isAvailable(PiecePosition position, int columnIncrement, int rowIncrement) {
        if (position == null)
                return false;

        int newColumn = position.getColumn() + columnIncrement;
        int newRow = position.getRow() + rowIncrement;
        return isAvailable(newColumn, newRow);
    }

    /**
     * @param position Posición de una pieza que contiene su fila y su columna actual.
     * @return Devuelve true si en la fila y en la columna en las que se encuentra 
     * la pieza está disponible y false en caso contrario.
     */
    static boolean isAvailable(PiecePosition position) {
        if (position == null)
                return false;
        return isAvailable(position.getColumn(), position.getRow());
    }

    private int column, row;

    /**
     * Función que permite asignar una nueva columna y fila a una pieza
     * @param column Número de la nueva columna
     * @param row Número de la nueva fila
     */
    public PiecePosition(int column, int row) {
        this.column = column;
        this.row = row;
    }

    /**
     * @return Devuelve el valor de la columna
     */
    public int getColumn() {
        return column;
    }

    /**
     * @return Devuelve el valor de la fila
     */
    public int getRow() {
        return row;
    }

    /**
     * @param column Nuevo valor de  columna
     * @param row Nuevo valor de fila
     * @return Si en la fila y columna dadas la posición está disponible
     * devuelve true, en caso contrario devuelve false.
     */
    public boolean setValues(int column, int row) {
        if (isAvailable(column, row)) {
            this.column = column;
            this.row = row;			
            return true;
        }
        return false;
    }

    /**
     * @param columnCount Número de columnas
     * @param rowCount Número de filas
     * @return 
     */
    public PiecePosition getDisplacedPiece(int columnCount, int rowCount) {		
        if (!isAvailable(this, columnCount, rowCount))
            return null;
        int newColumn = getColumn() + columnCount;
        int newRow = getRow() + rowCount;
        return new PiecePosition(newColumn, newRow);
    }

    /**
     * @return Devuelve una cópia de la posición de una pieza.
     */
    public PiecePosition clone() {
        return new PiecePosition(column, row);
    }

    /**
     * @param aPosition Posición concreta de una pieza
     * @return Devuelve true si la posición de una pieza equivale a la 
     * posición de otra pieza dadas sus filas y columnas.
     */
    public boolean equals(PiecePosition aPosition) {
        return aPosition.getColumn() == getColumn() && aPosition.getRow() == getRow();
    }
}

public class Board {

    int size;
    PlayingPiece[][] board;

    public Board(int size){
        this.size = size;
        board = new PlayingPiece[size][size];
    }

    public boolean isFreeCellsAvailable(){

        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(board[i][j] == null){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean addPiece(int row, int col,PlayingPiece playingPiece){

        if(row<0 || row >= size || col<0 || col>=size || board[row][col] instanceof PlayingPiece){
            return false;
        }
        else{
            board[row][col] = playingPiece;
        }
        return true;
    }

    public void printBoard() {

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == null) {
                    System.out.print(" " + " | ");
                } else {
                    System.out.print(board[i][j].pieceType + " | ");
                }
            }
            System.out.println();
        }
    }
}

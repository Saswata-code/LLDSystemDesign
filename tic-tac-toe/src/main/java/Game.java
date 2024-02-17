import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Game {
    Deque<Player> players;
    Board board;

    public void initialiseGame(){

        players = new LinkedList<>();

        Player playerX = new Player("Saswata",new PlayingPieceX());
        Player playerO = new Player("Neha",new PlayingPieceO());

        players.addFirst(playerO);
        players.addFirst(playerX);

        board = new Board(3);
    }

    public String startGame(){
        boolean noWinner = true;

        while(noWinner){

            //take out the player whose turn is and also put the player in the list back
            Player playerTurn = players.removeFirst();

            board.printBoard();
            if(!board.isFreeCellsAvailable()){
                return "tie";
            }

            //read the user input
            System.out.print("Player Name: " + playerTurn.name + ". Enter row,column : ");
            Scanner sc = new Scanner(System.in);
            String s = sc.nextLine();
            String[] str = s.split(",");

            int rowValue = Integer.valueOf(str[0]);
            int colValue = Integer.valueOf(str[1]);

            //place the piece
            boolean isPieceAddedSuccessfully = board.addPiece(rowValue,colValue,playerTurn.playingPiece);

            if(!isPieceAddedSuccessfully){
                System.out.println("Invalid row and column, please try again");
                players.addFirst(playerTurn);
                continue;
            }

            players.addLast(playerTurn);

            boolean isThereWinner = isWinnerPresent(rowValue,colValue,playerTurn.playingPiece.pieceType);

            if(isThereWinner){
                board.printBoard();
                return playerTurn.name;
            }
        }

        return null;
    }

    public boolean isWinnerPresent(int row,int col,PieceType pieceType){

        boolean rowMatching = true;
        boolean colMatching = true;
        boolean diagonalMatching = true;
        boolean antiDiagonalMatching = true;

        // checking if row is matching
        for(int j=0;j< board.size;j++){
            if(board.board[row][j] == null || !board.board[row][j].pieceType.equals(pieceType)){
                rowMatching = false;
                break;
            }
        }

        // checking if column is matching
        for(int i=0;i< board.size;i++){
            if(board.board[i][col] == null || !board.board[i][col].pieceType.equals(pieceType)){
                colMatching = false;
                break;
            }
        }

        // checking if diagonal is matching
        for(int i=0,j=0;i< board.size ; i++,j++){
            if(board.board[i][j] == null || !board.board[i][j].pieceType.equals(pieceType)){
                diagonalMatching = false;
                break;
            }
        }

        // checking if anti-diagonals are matching
        for(int i=0,j= board.size - 1; i< board.size;i++,j--){
            if(board.board[i][j] == null || !board.board[i][j].pieceType.equals(pieceType)){
                antiDiagonalMatching = false;
                break;
            }
        }

        return rowMatching || colMatching || diagonalMatching || antiDiagonalMatching;
    }
}

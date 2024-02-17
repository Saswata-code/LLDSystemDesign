public class TicTacToeApplication {

    public static void main(String[] args){
        Game game = new Game();
        game.initialiseGame();
        String winner = game.startGame();
        System.out.println("The Winner is : " + winner);
    }
}

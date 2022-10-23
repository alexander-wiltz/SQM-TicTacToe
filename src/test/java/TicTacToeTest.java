import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class TicTacToeTest {

    @Test
    public void testCase1EmptyBoard() {
        TicTacToe ticTacToe = new TicTacToe();
        int[] board = {
                0,0,0,
                0,0,0,
                0,0,0
        };

        int result = ticTacToe.checkTicTacToePosition(board);

        assertThat(result).isEqualTo(0);
    }

    @Test
    public void testCase2Player1WonRow() {
        TicTacToe ticTacToe = new TicTacToe();
        int[] board = {
                1,1,1,
                2,2,0,
                2,0,0
        };

        int result = ticTacToe.checkTicTacToePosition(board);

        assertThat(result).isEqualTo(1);
    }

    @Test
    public void testCase3Player2WonCol() {
        TicTacToe ticTacToe = new TicTacToe();
        int[] board = {
                2,1,1,
                2,1,0,
                2,0,0
        };

        int result = ticTacToe.checkTicTacToePosition(board);

        assertThat(result).isEqualTo(2);
    }

    @Test
    public void testCase4Player1WonFromTopLeft() {
        TicTacToe ticTacToe = new TicTacToe();
        int[] board = {
                1,2,1,
                2,1,0,
                2,0,1
        };

        int result = ticTacToe.checkTicTacToePosition(board);

        assertThat(result).isEqualTo(1);
    }

    @Test
    public void testCase5Player2WonFromTopRight() {
        TicTacToe ticTacToe = new TicTacToe();
        int[] board = {
                2,1,2,
                1,2,1,
                2,0,0
        };

        int result = ticTacToe.checkTicTacToePosition(board);

        assertThat(result).isEqualTo(2);
    }

    @Test
    public void testCase6InvalidBoardSize() {
        TicTacToe ticTacToe = new TicTacToe();
        int[] board = {
                0,0,0,
                0,0,0,
                0,0,0,
                0
        };

        assertThatIllegalArgumentException().isThrownBy(() -> {
            int result = ticTacToe.checkTicTacToePosition(board);
        }).withMessageMatching("Incorrect size of board");
    }

    @Test
    public void testCase7InvalidPlayer() {
        TicTacToe ticTacToe = new TicTacToe();
        int[] board = {
                3,1,1,
                0,0,0,
                0,0,0
        };

        assertThatIllegalArgumentException().isThrownBy(() -> {
            int result = ticTacToe.checkTicTacToePosition(board);
        }).withMessageMatching("Invalid player");
    }

    @Test
    public void testCase8TooManyMoves() {
        TicTacToe ticTacToe = new TicTacToe();
        int[] board = {
                1,1,1,
                0,0,0,
                0,0,0
        };

        assertThatIllegalArgumentException().isThrownBy(() -> {
            int result = ticTacToe.checkTicTacToePosition(board);
        }).withMessageMatching("One player has made too many moves");
    }

}

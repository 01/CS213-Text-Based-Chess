package chess;
import java.io.IOException;
import java.util.Arrays;

public class Chess {

    public static String[][] board;

    public static void main( String[] args ) throws IOException {
        createBoard();
    }

    public static void createBoard(){

        String tiles[]= {"a1","b1","c1","d1","e1","f1","g1","h1",
                "a2","b2","c2","d2","e2","f2","g2","h2",
                "a3","b3","c3","d3","e3","f3","g3","h3",
                "a4","b4","c4","d4","e4","f4","g4","h4",
                "a5","b5","c5","d5","e5","f5","g5","h5",
                "a6","b6","c6","d6","e6","f6","g6","h6",
                "a7","b7","c7","d7","e7","f7","g7","h7",
                "a8","b8","c8","d8","e8","f8","g8","h8"
        };

        String places[]= {"wR","wN","wB","wQ","wK","wB","wN","wR",
                "wp","wp","wp","wp","wp","wp","wp","wp",
                "##","  ","##","  ","##","  ","##","  ",
                "  ", "##","  ","##","  ","##","  ","##",
                "##","  ","##","  ","##","  ","##","  ",
                "  ", "##","  ","##","  ","##","  ","##",
                "bp","bp","bp","bp","bp","bp","bp","bp",
                "bR","bN","bB","bQ","bK","bB","bN","bR"
        };

        board = new String[64][2];

        for (int i = 0; i < 64; i++) {
            board [i][0] = tiles[i];
            board [i][1] = places[i];
        }

        for(int j = board.length-1; j>=0; j--) {
            System.out.print(board[j][1]+" ");
            if (j%8==0)
                System.out.println();
        }

        System.out.println();
        System.out.println(Arrays.deepToString(board));
    }
}

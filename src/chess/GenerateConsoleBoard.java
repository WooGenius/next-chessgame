package chess;

public class GenerateConsoleBoard implements GenerateBoard {

	@Override
	public String generateBoard(Board board) {
		StringBuilder sb = new StringBuilder();
		for (int i = Board.ROW_SIZE; i > 0; i--) {
			sb.append(board.generateRank(i-1) + Board.NEW_LINE);
		}
		return sb.toString();
	}

}

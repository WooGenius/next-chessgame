package chess;

public class GenerateHTMLBoard implements GenerateBoard {

	@Override
	public String generateBoard(Board board) {
		StringBuilder sb = new StringBuilder();
		sb.append("<html>");
		sb.append("<body>");
		for (int i = Board.ROW_SIZE; i > 0; i--) {
			sb.append(board.generateRank(i-1) + Board.NEW_LINE);
		}
		sb.append("</body>");
		sb.append("</html>");
		return sb.toString();
	}

}

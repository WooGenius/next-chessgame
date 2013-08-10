package pieces;

import java.util.ArrayList;
import java.util.List;


public class Pawn extends Piece {
	public Pawn(Color color, Position position) {
		super(color, Type.PAWN, position);
	}

	@Override
	List<Position> getPossibleMoves() {
		PositionController posCon = new PositionController(position);
		List<Position> pawnMoves = new ArrayList<Position>();
		if (color == Color.WHITE) {
			pawnMoves = posCon.findsWhitePawnPositionAll();
		} else if(color == Color.BLACK) {
			pawnMoves = posCon.findsBlackPawnPositionAll();
		}
		return pawnMoves;
	}
}

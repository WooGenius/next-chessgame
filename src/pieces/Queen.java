package pieces;

import java.util.List;


public class Queen extends Piece {
	public Queen(Color color, Position position) {
		super(color, Type.QUEEN, position);
	}

	@Override
	public List<Position> getPossibleMoves() {
		PositionController posCon = new PositionController(position);
		List<Position> queenMoves = posCon.findsQueenPositionAll();
		return queenMoves;
	}
}

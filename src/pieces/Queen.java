package pieces;

import java.util.List;


public class Queen extends Piece {
	public Queen(Color color, Position position) {
		super(color, Type.QUEEN, position);
	}

	@Override
	List<Position> getPossibleMoves() {
		PositionController posCon = new PositionController(position);
		List<Position> queenMoves = posCon.findsDiagonalPositionAll();
		queenMoves.addAll(posCon.findsLinearPositionAll());
		return queenMoves;
	}
}

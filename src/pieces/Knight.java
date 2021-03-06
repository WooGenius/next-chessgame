package pieces;

import java.util.List;

public class Knight extends Piece {
	public Knight(Color color, Position position) {
		super(color, Type.KNIGHT, position);
	}

	@Override
	public List<Position> getPossibleMoves() {
		PositionController posCon = new PositionController(position);
		List<Position> knightMoves = posCon.findsKnightPositionAll();
		return knightMoves;
	}
}

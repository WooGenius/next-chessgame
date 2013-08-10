package pieces;

import java.util.List;

public class King extends Piece {
	public King(Color color, Position position) {
		super(color, Type.KING, position);
	}

	@Override
	List<Position> getPossibleMoves() {
		PositionController posCon = new PositionController(position);
		List<Position> kingMoves = posCon.findsKingPositionAll();
		return kingMoves;
	}
}


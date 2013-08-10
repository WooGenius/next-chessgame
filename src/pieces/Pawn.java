package pieces;

import java.util.ArrayList;
import java.util.List;


public class Pawn extends Piece {
	public Pawn(Color color, Position position) {
		super(color, Type.PAWN, position);
	}

	@Override
	List<Position> getPossibleMoves() {
		List<Position> pawnMoves = new ArrayList<Position>();
		if (color == Color.WHITE) {
			pawnMoves.add(position.move(Direction.NORTH));
		} else if(color == Color.BLACK) {
			pawnMoves.add(position.move(Direction.SOUTH));
		}
		return pawnMoves;
	}
}

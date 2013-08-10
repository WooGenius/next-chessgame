package pieces;

import java.util.List;

import pieces.Piece.Color;
import junit.framework.TestCase;

public class PawnTest extends TestCase {
	public void testPossibleMoves() throws Exception {
		Position pos = new Position("d5");
		Pawn blackPawn = new Pawn(Color.BLACK, pos);
		Pawn whitePawn = new Pawn(Color.WHITE, pos);
		List<Position> blackPossibleMoves = blackPawn.getPossibleMoves();
		List<Position> whitePossibleMoves = whitePawn.getPossibleMoves();
		
		assertEquals(pos.move(Direction.SOUTH), blackPossibleMoves.get(0));
		assertEquals(pos.move(Direction.NORTH), whitePossibleMoves.get(0));
		
	}
}

package chess;

import junit.framework.TestCase;
import pieces.Empty;
import pieces.Pawn;
import pieces.PieceOperations;
import pieces.Piece.Color;
import pieces.Position;

public class BoardTest extends TestCase {
	private Board board;
	
	@Override
	protected void setUp() throws Exception {
		board = new Board();
	}
	
	public void testCreate() throws Exception {
		board.initialize();
		assertEquals(RankTest.WHITE_PAWN_RANK, board.generateRank(1));
		assertEquals(RankTest.BLACK_PAWN_RANK, board.generateRank(6));
	}
	
	public void testPrint() throws Exception {
		board.initialize();
		String expected = 
			RankTest.BLACK_EXCEPT_PAWN_RANK + Board.NEW_LINE +
			RankTest.BLACK_PAWN_RANK + Board.NEW_LINE +
			createEmptyRank() + 
			createEmptyRank() + 
			createEmptyRank() + 
			createEmptyRank() +
			RankTest.WHITE_PAWN_RANK + Board.NEW_LINE +
			RankTest.WHITE_EXCEPT_PAWN_RANK + Board.NEW_LINE;
		assertEquals(expected, board.generateBoard());
		System.out.println(board.generateBoard());
	}
	
	private String createEmptyRank() {
		return RankTest.EMPTY_RANK + Board.NEW_LINE;
	}
	
	public void testFindPiece() throws Exception {
		board.initialize();
		assertEquals('R', board.findPiece("a8").getSymbol());
		assertEquals('k', board.findPiece("e1").getSymbol());
	}
	
	public void testInitializeEmpty() throws Exception {
		board.initializeEmpty();
		System.out.println(board.generateBoard());
	}
	
	public void testMovePiece() throws Exception {
		board.initialize();
		Position source = new Position("a2");
		PieceOperations sourcePiece = board.findPiece(source);
		assertEquals(new Pawn(Color.WHITE, source), sourcePiece);
		
		Position target = new Position("a3");
		board.movePiece(source, target);
		assertEquals(new Empty(Color.NOCOLOR, source), board.findPiece(source));
		assertEquals(new Pawn(Color.WHITE, target), board.findPiece(target));
		System.out.println(board.generateBoard());
	}
	
	public void testMoveEmpty() throws Exception {
		board.initialize();
		Position source = new Position("a3");
		Position target = new Position("a2");
		PieceOperations emptyPiece = board.findPiece(source);
		PieceOperations targetPiece = board.findPiece(target);
		
		board.movePiece(source, target);
		assertEquals(new Empty(Color.NOCOLOR, source), emptyPiece);
		assertEquals(new Pawn(Color.WHITE, target), targetPiece);
		System.out.println(board.generateBoard());
		
	}
	
	public void testMoveInvalidTarget() throws Exception {
		board.initialize();
		int invalidX = -1;
		int invalidY = -1;
		Position source = new Position("a2");
		Position target = new Position(invalidX, invalidY);
		PieceOperations sourcePiece = board.findPiece(source);
		
		board.movePiece(source, target);
		assertEquals(new Pawn(Color.WHITE, source), sourcePiece);
		System.out.println(board.generateBoard());
	}
	
	public void testMoveToSameColor() throws Exception {
		board.initialize();
		Position source = new Position("a2");
		Position target = new Position("b2");
		PieceOperations sourcePiece = board.findPiece(source);
		PieceOperations targetPiece = board.findPiece(target);
		
		board.movePiece(source, target);
		assertEquals(new Pawn(Color.WHITE, source), sourcePiece);
		assertEquals(new Pawn(Color.WHITE, target), targetPiece);
		System.out.println(board.generateBoard());
	}
	
	public void testMoveByPiece() throws Exception {
		board.initialize();
		Position source = new Position("a2");
		Position target = new Position("b3");
		PieceOperations sourcePiece = board.findPiece(source);
		PieceOperations targetPiece = board.findPiece(target);
		
		board.movePiece(source, target);
		assertEquals(new Pawn(Color.WHITE, source), sourcePiece);
		assertEquals(new Empty(Color.NOCOLOR, target), targetPiece);
		System.out.println(board.generateBoard());
	}
}

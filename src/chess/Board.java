package chess;

import java.util.ArrayList;
import java.util.List;

import pieces.Piece;
import pieces.Position;

public class Board {
	public static final String NEW_LINE = System.getProperty("line.separator");
	public static final int ROW_SIZE = 8;
	public static final int COLUMN_SIZE = 8;
	
	List<Rank> ranks = new ArrayList<Rank>();
	
	Board() {
	}

	void initialize() {
		for (int i = 0; i < ROW_SIZE; i++) {
			Rank rank = new Rank(i);
			if (i==0) {
				rank.initializeWhiteExceptPawn();
			} else if (i==1) {
				rank.initializeWhitePawn();
			} else if (i==6) {	
				rank.initializeBlackPawn();
			} else if (i==7) {
				rank.initializeBlackExceptPawn();
			} else {
				rank.initializeEmpty();
			}
			ranks.add(rank);
		}
	}
	
	void initializeEmpty() {
		for (int i = 0; i < ROW_SIZE; i++) {
			Rank rank = new Rank(i);
			rank.initializeEmpty();
			ranks.add(rank);
		}
	}

	Piece findPiece(String xy) {
		Position position = new Position(xy);
		return findPiece(position);
	}

	Piece findPiece(Position position) {
		Rank rank = ranks.get(position.getY());
		return rank.findPiece(position);
	}

	void movePiece(String source, String target) {
		movePiece(new Position(source), new Position(target));
	}

	void movePiece(Position source, Position target) {
		Piece targetPiece = findPiece(source);
		Piece sourcePiece = targetPiece.leave();
		
		if(invalidMove(source, target)) {
			return;
		}
			Rank sourceRank = ranks.get(source.getY());
			sourceRank.move(sourcePiece, source);
			
			Rank targetRank = ranks.get(target.getY());
			targetRank.move(targetPiece, target);
	}
	
	private boolean invalidMove(Position source, Position target) {
		// empty piece
		if(findPiece(source).isEmpty()) {
			System.out.println("empty piece cant move");
			return true;
		}
		// invalid target
		if (!target.isValid()) {
			System.out.println("cant move to invalid target position");
			return true;
		}
		// same color position
		if (findPiece(target).getColor() == findPiece(source).getColor()) {
			System.out.println("cant move to same color piece");
			return true;
		}
		return false;
	}

	String generateRank(int rankIndex) {
		Rank rank = ranks.get(rankIndex);
		StringBuilder sb = new StringBuilder();
		sb.append(rank.generate());
		return sb.toString();
	}

	String generateBoard() {
		StringBuilder sb = new StringBuilder();
		for (int i = ROW_SIZE; i > 0; i--) {
			sb.append(generateRank(i-1) + NEW_LINE);
		}
		return sb.toString();
	}
}

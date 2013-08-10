package pieces;

import java.util.ArrayList;
import java.util.List;

public class PositionController {
	private Position position;;

	public PositionController(Position position) {
		this.position = position;
	}

	public List<Position> findsLinearPositionAll() {
		Direction[] linears = Direction.linearDirection();
		List<Position> positions = new ArrayList<Position>();
		for (Direction direction : linears) {
			positions.addAll(position.findsPosition(direction));
		}
		return positions;
	}

	public List<Position> findsDiagonalPositionAll() {
		Direction[] diagonals = Direction.diagonalDirection();
		List<Position> positions = new ArrayList<Position>();
		for (Direction direction : diagonals) {
			positions.addAll(position.findsPosition(direction));
		}
		return positions;
	}

	public List<Position> findQueenPositionAll() {
		Direction[] everyDirection = Direction.everyDirection();
		List<Position> positions = new ArrayList<Position>();
		for (Direction direction : everyDirection) {
			positions.addAll(position.findsPosition(direction));
		}
		return positions;
	}
	
	public List<Position> findKingPositionAll() {
		Direction[] everyDirection = Direction.everyDirection();
		List<Position> positions = new ArrayList<Position>();
		for (Direction direction : everyDirection) {
			Position movedPosition = position.move(direction);
			if (movedPosition.isValid()) {
				positions.add(movedPosition);				
			}
		}
		return positions;
	}
}

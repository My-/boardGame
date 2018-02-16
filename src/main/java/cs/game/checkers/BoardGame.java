package cs.game.checkers;

import my.utils.Position;

import java.util.Optional;

/**
 * this interface will be used for each squareBoard game.
 * At the moment is just a template to get idea what to expect from it.
 */
public interface BoardGame {

    Optional<Piece> get(Position pos);

    /**
     * Should be used to select piece before moving it or before any action an a piece.
     */
    Optional<Piece> select(Position atPosition);

    /**
     * use to unselected piece.
     */
    void dropSelected();

    /**
     * use to move selected piece to given position.
     */
    boolean move(Position toPosition);

    /**
     * use it to check if we have winner.
     * @return winner or Optional empty if here is no winner.
     */
    public Optional<Pieces> getWinner();
}

package cs.game.checkers;

import my.utils.Position;

import java.util.Optional;

/**
 * this interface will be used for each squareBoard game.
 * At the moment is just a template to get idea what to expect from it.
 */
public interface BoardGame {

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
     * use to start game
     */
    void start();

    /**
     * use to check game.
     * say in chess it would be is here check or mate.
     * maybe done() or nextMove() would be better name.
     */
    void check();
}

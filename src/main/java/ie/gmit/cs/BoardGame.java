package ie.gmit.cs;

import some.custom.Position.class

/**
 * this interface will be used for each board game.
 * At the moment is just a template to get idea what to expect from it.
 */
public interface BoardGame {

    /**
     * should be used to select piece. to move piece, to attack piece and so on.
     */
    boolean select(Position atPosition);

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

package cs.game.checkers;

import my.utils.Position;

import java.util.Objects;

public class Piece {

    private Pieces name;
    private Position pos;

    /**
     * Private constructor. Use factory method  <u>Piece.of()</u> to create instance of this class.
     *
     * @param name piece name.
     * @param pos position of the piece.
     */
    private Piece(Pieces name, Position pos) {
        this.name = name;
        this.pos = pos;
    }

    /**
     * Factory method to create new Piece instance.
     *
     * @param name piece name.
     * @param pos position of the piece.
     * @return newly created piece.
     */
    public static Piece of(Pieces name, Position pos){
        return new Piece(name, pos);
    }

    /**
     * Getter to get piece name.
     *
     * @return name of this instance.
     */
    public Pieces getName() {
        return name;
    }

    /**
     * Getter to get position of this piece.
     *
     * @return position of this piece.
     */
    public Position getPos() {
        return pos;
    }

    /**
     * This method changes (mutates) instance <u>position</u> field.
     *
     * @param pos new position of the field.
     * @return updated this instance.
     */
    public Piece changePosition(Position pos){
        this.pos = Position.of(pos);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piece piece = (Piece) o;
        return name == piece.name &&
                Objects.equals(pos, piece.pos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, pos);
    }

    @Override
    public String toString() {
        return "Piece{" +
                "name=" + name +
                ", pos=" + pos +
                '}';
    }
}

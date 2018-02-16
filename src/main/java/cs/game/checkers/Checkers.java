package cs.game.checkers;

import my.utils.Position;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public class Checkers implements BoardGame{

    private Set<Position> black, white;
    private Piece selected;

    private Checkers(){
        // TODO: initialize checkers to default position.
    }

    public static Checkers of(){
        return new Checkers();
    }


    Optional<Piece> get(Position pos){
        if( this.black.contains(pos) ){
            return Optional.of(Piece.of(Pieces.BLACK, Position.of(pos)));
        }else if( this.white.contains(pos) ){
            return Optional.of(Piece.of(Pieces.WHITE, Position.of(pos)));
        }

        return Optional.empty();
    }

    public int blackSize() {
        return black.size();
    }

    public int whiteSize() {
        return white.size();
    }

    @Override
    public Optional<Piece> select(Position atPosition) {
        if( get(atPosition).isPresent() ){
            selected = get(atPosition).get();

            switch(selected.getName()){
                case BLACK: black.remove(selected.getPos()); break;
                case WHITE: white.remove(selected.getPos()); break;
            }
        }
        return Optional.ofNullable(selected);
    }

    @Override
    public void dropSelected() {
        if(selected != null ){
            switch(selected.getName()){
                case BLACK: black.add(selected.getPos()); break;
                case WHITE: white.add(selected.getPos()); break;
            }
        }
        this.selected = null;
    }

    @Override
    public boolean move(Position toPosition) {
        if( selected != null ){
            switch(selected.getName()){
                case BLACK:
                    black.add(toPosition);
                    selected = null;
                    break;
                case WHITE:
                    white.add(toPosition);
                    selected = null;
                    break;
                default:
                    throw new RuntimeException("Can be 'BLACK' or 'WHITE' but was: " + selected.getName());
            }
            return true;
        }

        return false;
    }

    @Override
    public void start() {

    }

    @Override
    public void check() {

    }
}

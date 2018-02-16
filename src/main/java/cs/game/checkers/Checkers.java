package cs.game.checkers;

import my.utils.Position;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public class Checkers implements BoardGame{

    public static final int BOARD_SIZE = 8;

    private Set<Position> black, white;
    private Piece selected;
    private boolean isBlackMove = true;

    public Optional<Pieces> getWinner() {
        return Optional.ofNullable(winner);
    }

    private Pieces winner = null;

    private Checkers(){
        // TODO: initialize checkers to default position.
    }

    public static Checkers of(){
        return new Checkers();
    }

    void placeCheckers(){
        for(int x = 0; x < BOARD_SIZE; x++){
            for(int y = 0; y < BOARD_SIZE; y++){
                if( x < 3 && x +y % 2 != 0 ){ white.add(Position.of(x, y)); }
                if( x > 4 && x +y % 2 != 0 ){ black.add(Position.of(x, y)); }
            }
        }
    }

    @Override
    public Optional<Piece> get(Position pos){
        if( this.black.contains(pos) ){
            return Optional.of(Piece.of(Pieces.BLACK, Position.of(pos)));
        }else if( this.white.contains(pos) ){
            return Optional.of(Piece.of(Pieces.WHITE, Position.of(pos)));
        }

        return Optional.empty();
    }

    @Override
    public Optional<Piece> select(Position atPosition) {
        if( get(atPosition).isPresent() ){
            if( notValidSelection(atPosition) ){ return Optional.ofNullable(selected); }
            if( selected != null ){ dropSelected(); } // if we have previous selected piece

            selected = get(atPosition).get();

            switch(selected.getName()){
                case BLACK: black.remove(selected.getPos()); break;
                case WHITE: white.remove(selected.getPos()); break;
            }
        }
        return Optional.ofNullable(selected);
    }

    private boolean notValidSelection(Position pos) {
        Pieces selectedName = get(pos).get().getName();
        if( isBlackMove && selectedName == Pieces.WHITE ){ return true; } // if Black move but selected is White piece
        if( !isBlackMove && selectedName == Pieces.BLACK ){ return true; } // if White move but selected is Black piece
        return false;
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
        if( selected == null ){ return false; } // here are no selected piece
        if( black.remove(toPosition) || white.contains(toPosition)){ return false; } // occupied position
        // TODO: check if valid move
        // TODO: check if jumps over piece
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

    public int blackSize() {
        return black.size();
    }

    public int whiteSize() {
        return white.size();
    }

    public boolean gisBlackMove(){
        return isBlackMove;
    }

    public boolean togleMove(){
        isBlackMove = !isBlackMove;
        return isBlackMove;
    }

    public boolean getMoveThenTogle(){
        isBlackMove = !isBlackMove;
        return !isBlackMove;
    }
}

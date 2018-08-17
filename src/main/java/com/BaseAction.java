package com;

public class BaseAction implements UserAction {
    private final GeneratorBoard generator;
    private final Board board;
    private final SaperLogic logic;

    public BaseAction(GeneratorBoard generator, Board board, SaperLogic logic) {
        this.generator = generator;
        this.board = board;
        this.logic = logic;
    }

    @Override
    public void initGame() {
        final Cell[][] cells = generator.generate();
        this.board.drawBoard(cells);
        this.logic.loadBoard(cells);
    }

    /*@Override
    public void select(int x, int y, boolean bomb) {
        this.logic.suggest(x, y, bomb);
        //this.board.drawCell(x, y);
        if (this.logic.shouldBang(x, y)) {
            this.board.drawBang();
        }
        if (this.logic.finish()) {
            this.board.drawCongratulation();
        }
    }*/
}

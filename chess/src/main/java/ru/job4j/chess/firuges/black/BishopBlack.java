package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import java.io.IOException;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest)  {
        if (!isDiagonal(source, dest)) {
            throw new IllegalStateException(
                    String.format("Could not move by diagonal from %s to %s", source, dest)
            );
        }
        Cell[] steps = arrayCell(source, dest);
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        boolean rsl = false;
        Cell[] steps = arrayCell(source, dest);
        for (Cell cell : steps) {
            if (cell.x == dest.x && cell.y == dest.y) {
                rsl = true;
                break;
            }
        }
        return rsl;
    }

    private Cell[] arrayCell(Cell source, Cell dest) {
        int size = Math.abs(source.x - dest.x);
        Cell[] steps = new Cell[size];
        int deltaX = source.x - dest.x;
        int deltaY = source.y - dest.y;
        for (int index = 0; index < size; index++) {
            int x = deltaX < 0 ? source.x + index + 1 : source.x - index - 1;
            int y = deltaY < 0 ? source.y + index + 1 : source.y - index - 1;
            steps[index] = Cell.findBy(x, y);
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}

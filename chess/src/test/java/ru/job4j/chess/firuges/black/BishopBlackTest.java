package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BishopBlackTest {

    @Test
    public void position() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C8);
        Cell result = bishopBlack.position();
        assertThat(result, is(Cell.C8));
    }

    @Test
    public void copy() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C8);
        Figure result = bishopBlack.copy(Cell.D7);
        assertThat(result.position(), is(Cell.D7));
    }

    @Test
    public void way_FromC1ToG5() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] result = bishopBlack.way(Cell.C1, Cell.G5);
        Cell[] extend = new Cell[]{Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(result, is(extend));
    }

    @Test
    public void way_FromC1ToA3() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] result = bishopBlack.way(Cell.C1, Cell.A3);
        Cell[] extend = new Cell[]{Cell.B2, Cell.A3};
        assertThat(result, is(extend));
    }

    @Test
    public void way_FromD4ToF2() {
        BishopBlack bishopBlack = new BishopBlack(Cell.D4);
        Cell[] result = bishopBlack.way(Cell.D4, Cell.F2);
        Cell[] extend = new Cell[]{Cell.E3, Cell.F2};
        assertThat(result, is(extend));
    }

    @Test
    public void way_D4_B2() {
        BishopBlack bishopBlack = new BishopBlack(Cell.D4);
        Cell[] result = bishopBlack.way(Cell.D4, Cell.B2);
        Cell[] extend = new Cell[]{Cell.C3, Cell.B2};
        assertThat(result, is(extend));
    }

    @Test
    public void isDiagonalTrue() {
        BishopBlack bishopBlack = new BishopBlack(Cell.D4);
        Boolean result = bishopBlack.isDiagonal(Cell.D4, Cell.B2);
        assertThat(result, is(true));
    }

    @Test
    public void isDiagonalFalse() {
        BishopBlack bishopBlack = new BishopBlack(Cell.D4);
        Boolean result = bishopBlack.isDiagonal(Cell.D4, Cell.B3);
        assertThat(result, is(false));
    }

}
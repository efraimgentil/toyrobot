package me.efraimgentil.toyrobot.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TableTest {



    @Test
    public void shouldReturnTrueIfTheNewXYPositionWillResultInAFall(){
        Table table = new Table(5);

        assertThat(table.willFall(-1 ,0)).isTrue();
    }

    @Test
    public void shouldReturnTrueIfTheNewXYPositionWillResultInAFall2(){
        Table table = new Table(5);

        assertThat(table.willFall(0 ,-1)).isTrue();
    }

    @Test
    public void shouldReturnTrueIfTheNewXYPositionWillResultInAFall3(){
        Table table = new Table(5);

        assertThat(table.willFall(5 ,0)).isTrue();
    }

    @Test
    public void shouldReturnTrueIfTheNewXYPositionWillResultInAFall4(){
        Table table = new Table(5);

        assertThat(table.willFall(0 ,5)).isTrue();
    }

    @Test
    public void shouldReturnFalseIfTheMoveDoesNotResultInFallingOfTheBoard(){
        Table table = new Table(5);

        assertThat(table.willFall(0 ,4)).isFalse();
    }

}

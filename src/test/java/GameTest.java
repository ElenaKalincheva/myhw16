import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    @Test

    public void testWhenTwoPlayerWin() {
        Player vasya = new Player(1, "Вася", 100);
        Player petya = new Player(2, "Петя", 200);
        Game game = new Game();

        game.register(vasya);
        game.register(petya);
        int actual = game.round("Вася", "Петя");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test

    public void testWhenFirstPlayerWin() {
        Player vasya = new Player(1, "Вася", 300);
        Player petya = new Player(2, "Петя", 200);
        Game game = new Game();

        game.register(vasya);
        game.register(petya);
        int actual = game.round("Вася", "Петя");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test

    public void testWhenDrawPlayerWin() {
        Player vasya = new Player(1, "Вася", 150);
        Player petya = new Player(2, "Петя", 150);
        Game game = new Game();

        game.register(vasya);
        game.register(petya);
        int actual = game.round("Вася", "Петя");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenFirstPlayerNotExist() {
        Player vasya = new Player(1, "Вася", 150);
        Player petya = new Player(2, "Петя", 100);
        Game game = new Game();

        game.register(vasya);
        game.register(petya);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Миша", "Вася")
        );

    }

    @Test
    public void testWhentTwoPlayerNotExist() {
        Player vasya = new Player(1, "Вася", 150);
        Player petya = new Player(2, "Петя", 100);
        Game game = new Game();

        game.register(vasya);
        game.register(petya);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Петя", "Миша")
        );

    }
}
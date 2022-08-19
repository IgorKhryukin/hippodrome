import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class HorseTest {

    /*Проверить, что при передаче в конструктор первым параметром null, будет выброшено IllegalArgumentException.
        Для этого нужно воспользоваться методом assertThrows*/
    @Test
    public void getThrowWhenHorseNameIsNullInConstructor(){
        assertThrows(IllegalArgumentException.class, () -> new Horse(null, 10.5, 10.0));
    }

    /*Проверить, что при передаче в конструктор первым параметром null, выброшенное исключение будет содержать сообщение "Name cannot be null.".
        Для этого нужно получить сообщение из перехваченного исключения и воспользоваться методом assertEquals*/
    @Test
    public void checkThrowMessageWhenFirstParameterIsNullInConstructor(){
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> new Horse(null, 10.5, 10.0));
        assertEquals("Name cannot be null.", exception.getMessage());
    }

    /*Проверить, что при передаче в конструктор первым параметром пустой строки или строки содержащей только
        пробельные символы (пробел, табуляция и т.д.), будет выброшено IllegalArgumentException.
        Чтобы выполнить проверку с разными вариантами пробельных символов, нужно сделать тест параметризованным*/
    @ParameterizedTest
    @ValueSource(strings = {"", "\t\t\t", "\n\n\n"})
    public void getThrowWhenHorseNameIsEmptyInConstructor(String name){
        assertThrows(IllegalArgumentException.class, () -> new Horse(name, 10.5, 10.0));
    }

    /*Проверить, что при передаче в конструктор первым параметром пустой строки или строки содержащей
        только пробельные символы (пробел, табуляция и т.д.), выброшенное исключение будет содержать сообщение
        "Name cannot be blank."*/
    @ParameterizedTest
    @ValueSource(strings = {"", "\t\t\t", "\n\n\n"})
    public void checkThrowMessageWhenNameIsEmptyInConstructor(String name){
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> new Horse(name, 10.5, 10.0));
        assertEquals("Name cannot be blank.", exception.getMessage());
    }

    /*Проверить, что при передаче в конструктор вторым параметром отрицательного числа, будет выброшено IllegalArgumentException*/
    @Test
    public void getThrowWhenHorseSpeedIsNegative(){
        assertThrows(IllegalArgumentException.class, () -> new Horse("name", -1, 10.0));
    }

    /*Проверить, что при передаче в конструктор вторым параметром отрицательного числа,
        выброшенное исключение будет содержать сообщение "Speed cannot be negative."*/
    @Test
    public void checkThrowMessageWhenHorseSpeedIsNegative(){
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> new Horse("name", -1, 10.0));
        assertEquals("Speed cannot be negative.", exception.getMessage());
    }

    /*Проверить, что при передаче в конструктор третьим параметром отрицательного числа, будет выброшено IllegalArgumentException*/
    @Test
    public void getThrowWhenHorseDistanceIsNegative(){
        assertThrows(IllegalArgumentException.class, () -> new Horse("name", 1, -10.0));
    }

    /*Проверить, что при передаче в конструктор третьим параметром отрицательного числа,
        выброшенное исключение будет содержать сообщение "Distance cannot be negative."*/
    @Test
    public void checkThrowMessageWhenHorseDistanceIsNegative(){
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> new Horse("name", 1, -10.0));
        assertEquals("Distance cannot be negative.", exception.getMessage());
    }

    /*Проверить, что метод возвращает строку, которая была передана первым параметром в конструктор*/
    @Test
    public void getNameTest(){
        Horse horse = new Horse("Name", 1, 1);
        assertEquals("Name", horse.getName());
    }

    /*Проверить, что метод возвращает число, которое было передано вторым параметром в конструктор*/
    @Test
    public void getSpeedTest(){
        Horse horse = new Horse("Name", 1, 1);
        assertEquals(1, horse.getSpeed());
    }

    /*Проверить, что метод возвращает число, которое было передано третьим параметром в конструктор*/
    @Test
    public void getDistanceTest(){
        Horse horse = new Horse("Name", 1, 1);
        assertEquals(1, horse.getDistance());
    }

    /*Проверить, что метод возвращает ноль, если объект был создан с помощью конструктора с двумя параметрами*/
    @Test
    public void getDistanceWhenConstructorWithTwoParametersTest(){
        Horse horse = new Horse("Name", 1);
        assertEquals(0, horse.getDistance());
    }

}
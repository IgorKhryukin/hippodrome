import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class HorseTest {

    @Test
    public void getThrowWhenHorseNameIsNullInConstructor(){
        assertThrows(IllegalArgumentException.class, () -> new Horse(null, 10.5, 10.0));
    }

    @Test
    public void checkThrowMessageWhenFirstParameterIsNullInConstructor(){
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> new Horse(null, 10.5, 10.0));
        assertEquals("Name cannot be null.", exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "\t\t\t", "\n\n\n"})
    public void getThrowWhenHorseNameIsEmptyInConstructor(String name){
        assertThrows(IllegalArgumentException.class, () -> new Horse(name, 10.5, 10.0));
    }

}
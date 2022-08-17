import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HorseTest {

    @Test
    public void getThrowWhenHorseNameIsNullInConstructor(){
        assertThrows(IllegalArgumentException.class, () -> new Horse(null, 10.5, 10.0));
    }


}
package dev.swapi;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class SwapiApplicationTest {

    @Test
    public void main() {
        SwapiApplication.main(new String[] {});
    }

}

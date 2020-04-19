import com.avatarduel.card.*;
import com.avatarduel.card.Character;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CardTest {
    private final Character character1 = new Character("Test Character1","This is solely made for test purposes", Element.FIRE,"No image",5,5,3);
    private final Character character2 = new Character("Test Character2","This is solely made for test purposes", Element.WATER, "No image", 4,4,2);
    private final Land land1 = new Land("Test Land1","This is solely made for test purposes",Element.ENERGY,"No image",5);
    private final Destroy destroy1 = new Destroy("Test Destroy1","This is solely made for test purposes",Element.FIRE,"No image",6);


    @Test
    public void testCharacterMethods() {
        assertEquals(character1.getAttack(),5);
        assertEquals(character1.getDefense(),5);
        assertEquals(character1.getCost(),3);
        assertEquals(character1.getDescription(),"This is solely made for test purposes");
    }

    @Test
    public void testSkillMethods() {
        Skill skill1 = destroy1;
        assertNotNull(skill1);
        assertEquals(skill1.getTarget(),-1);
        skill1.setTarget(5);
        assertEquals(skill1.getTarget(),5);
    }
}

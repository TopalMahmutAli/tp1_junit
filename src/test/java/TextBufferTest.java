import fr.einfolearning.tp2.metiers.TextBuffer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
public class TextBufferTest {

    @Test
    public void TestTextBufferToString(){
        //Arrange
        TextBuffer bu = new TextBuffer("Je test la méthode toString() de la classe TextBuffer");

        String expectedText = "Je test la méthode toString() de la classe TextBuffer";

        //Act
        String action = bu.toString();
        //Asset
        Assertions.assertEquals(expectedText, action);
    }
    @Test
    public void TestTextBufferMaxP(){
        //Arrange
        TextBuffer buf = new TextBuffer("je suis le roi Louis 14");

        int expectedTaille = 23;

        //Act
        int taille = buf.maxP();
        //Asset
        Assertions.assertEquals(expectedTaille, taille);
    }

}

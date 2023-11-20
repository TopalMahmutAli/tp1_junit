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

    @Test
    public void testTextBufferIns() {
        // Arrange
        TextBuffer textBuffer = new TextBuffer("Bonjour, je m'appelle !");
        String expectedText = "Bonjour, je m'appelle MahmutAli !";
        int position = 22;
        String insertedText = "MahmutAli ";

        // Act
        textBuffer.ins(insertedText, position);
        String result = textBuffer.toString();

        // Assert
        Assertions.assertEquals(expectedText, result);
    }
    @Test
    public void testTextBufferDel() {
        // Arrange
        TextBuffer textBuffer = new TextBuffer("Bonjour, MahmutAli!");
        String expectedText = "Bonjour, Ali!";
        int from = 9;
        int to = 15;

        // Act
        textBuffer.del(from, to);
        String result = textBuffer.toString();

        // Assert
        Assertions.assertEquals(expectedText, result);
    }
    @Test
    public void testTextBufferSubstr() {
        // Arrange
        TextBuffer textBuffer = new TextBuffer("Bonjour, MahmutAli!");
        String expectedText = "Mahmut";
        int from = 9;
        int to = 15;

        // Act
        String result = textBuffer.substr(from, to);

        // Assert

        Assertions.assertEquals(expectedText, result);
    }
}

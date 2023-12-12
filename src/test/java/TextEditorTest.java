import fr.einfolearning.tp2.metiers.exceptions.EmacsKillRingOverflowException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import fr.einfolearning.tp2.metiers.TextBuffer;
import fr.einfolearning.tp2.metiers.TextEditor;
import fr.einfolearning.tp2.metiers.EmacsKillRing;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.mockito.Mockito.*;


import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
public class TextEditorTest {

    @Test
    public void testYank() throws IllegalAccessException, EmacsKillRingOverflowException{
        TextBuffer textBufferMocks = mock(TextBuffer.class);
        EmacsKillRing emacsKillRingMocks = mock(EmacsKillRing.class);
        TextEditor textEditor = new TextEditor("Bonjour tout le monde");

        when(emacsKillRingMocks.currentElt()).thenReturn("Ceci est un test");
        when(textBufferMocks.maxP()).thenReturn(100);
        textEditor.emacsKillring = emacsKillRingMocks;

        textEditor.yank();
        verify(emacsKillRingMocks, times(1)).currentElt();
        //verify(textBufferMocks).del(anyInt(), anyInt());
        verify(textBufferMocks, times(0)).ins(eq("Ceci est un test"), anyInt());
    }

    @Test
    public void testYankPopAfterYank() throws IllegalAccessException, EmacsKillRingOverflowException{
        EmacsKillRing emacsKillRingMocks = mock(EmacsKillRing.class);
        TextEditor textEditor = new TextEditor("Test text 123");
        textEditor.setMark(0);
        textEditor.setCursor(5);
        when(emacsKillRingMocks.currentElt()).thenReturn("Mock text 123");

        textEditor.emacsKillring = emacsKillRingMocks;

        textEditor.yank();
        textEditor.yankPop();
        verify(emacsKillRingMocks, times(1)).rotateFwd();
    }


}

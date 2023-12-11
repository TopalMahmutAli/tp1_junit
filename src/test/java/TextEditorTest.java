import fr.einfolearning.tp2.metiers.EmacsKillRing;
import fr.einfolearning.tp2.metiers.TextBuffer;
import fr.einfolearning.tp2.metiers.exceptions.EmacsKillRingOverflowException;

import fr.einfolearning.tp2.metiers.TextEditor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito.*;


import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class TextEditorTest {
    @Test
    public void testYankPopAlone() throws IllegalAccessException {
        // Mock des objets externes
        TextBuffer textBufferMock = mock(TextBuffer.class);
        EmacsKillRing emacsKillRingMock = mock(EmacsKillRing.class);

        // Création des objets nécessaires
        TextBuffer textBuffer = new TextBuffer("Sample text");
        EmacsKillRing emacsKillRing = new EmacsKillRing();

        // Création de l'objet à tester en utilisant les objets créés
        TextEditor textEditor = new TextEditor("Sample text");

        // Simulation du comportement
        when(emacsKillRingMock.currentElt()).thenReturn("Text from killring");

        // Appel de la méthode à tester
        try {
            textEditor.yankPop();
        } catch (IllegalAccessException e) {
            // Gérer l'exception si nécessaire (pourrait être jetée si appelée seule)
            // Ajouter les assertions appropriées en fonction du comportement attendu
        }

        // Vérification des appels de méthodes simulées
        verify(emacsKillRingMock).currentElt();
        verify(textBufferMock).del(anyInt(), anyInt()); // Vérifier l'appel à la suppression dans le buffer
    }
}

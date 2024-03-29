package domain.sequence_compiler;

import domain.IInputInterpeter;
import domain.IOutputInterpeter;
import domain.SequenceCompiler;
import infraestructure.GsonInputInterpreter;
import infraestructure.GsonOutputInterpreter;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestSequenceCompilerBoolean {

    static IInputInterpeter inputInterpreter;
    static IOutputInterpeter outputInterpreter;

    @BeforeClass
    public static void init() {
        inputInterpreter = new GsonInputInterpreter();
        outputInterpreter = new GsonOutputInterpreter();
    }

    @Test
    public void testAsBooleanOk() {
        String base = "{\"test\":true}";
        String sentence = "FIELD $test AS false";
        String expected = "{\"test\":false}";

        assertCompile(base, sentence, expected);
    }

    @Test
    public void testMutateBooleanOk() {
        String base = "{\"test\":true}";
        String sentence = "FIELD $test MUTATE false";
        String expected = "{\"test\":false}";

        assertCompile(base, sentence, expected);
    }

    @Test
    public void testMutateBooleanKo() {
        String base = "{\"test\":\"true\"}";
        String sentence = "FIELD $test MUTATE false";
        String expected = "Cannot merge the fields, both must be Boolean type objects";

        assertException(base, sentence, expected);
    }

    @Test
    public void testIncrementBooleanOk() {
        String base = "{\"test\":true}";
        String sentence = "FIELD $test INCREMENT false";
        String expected = "Cannot add up non numeric objects.";

        assertException(base, sentence, expected);
    }

    @Test
    public void testDecrementBooleanOk() {
        String base = "{\"test\":true}";
        String sentence = "FIELD $test DECREMENT false";
        String expected = "Cannot add up non numeric objects.";

        assertException(base, sentence, expected);
    }

    private void assertException(String base, String sentence, String expected) {
        SequenceCompiler compiler = new SequenceCompiler(base, sentence);
        try {
            compiler.compile();
            assertTrue("Exception expected but not thrown", false);
        }
        catch (IllegalArgumentException e){
            assertEquals(expected, e.getMessage());
        }
    }

    private void assertCompile(String base, String sentence, String expected){
        SequenceCompiler compiler = new SequenceCompiler(base, sentence);

        assertEquals(expected, compiler.compile());
    }

}
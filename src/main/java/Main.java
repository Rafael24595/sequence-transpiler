
import domain.SequenceCompiler;
import domain.SequenceDecompiler;
import resources.KInput;

public class Main {

    public static void main(String[] args) {
        SequenceCompiler compiler = new SequenceCompiler(KInput.BASE_TEST_1, KInput.SEQUENCE_TEST_1);
        compiler.compile();

        SequenceDecompiler decompiler = new SequenceDecompiler(KInput.BASE_TEST_2, KInput.UPDATE_TEST_1);
        decompiler.decompile();

        System.out.println("Close app...");
    }

}
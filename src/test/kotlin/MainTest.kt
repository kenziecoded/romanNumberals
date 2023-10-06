import org.example.main
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream


class MainTest {

    val testOut = ByteArrayOutputStream()

    @BeforeEach
    fun setOutput() {
        System.setOut(PrintStream(testOut))
    }

    @Test
    fun test() {
        val input = "2"
        val expectedOutput = "Input is: 2"

        System.setIn(ByteArrayInputStream(input.toByteArray()))
        main()
        assert(testOut.toString().contains(expectedOutput))
    }
}
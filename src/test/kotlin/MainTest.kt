import org.example.main
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream


class MainTest {

    private val testOut = ByteArrayOutputStream()

    @BeforeEach
    fun setOutput() {
        System.setOut(PrintStream(testOut))
    }

    @Test
    fun `given 2 respond with II`() {
        verifyOutput("2", "II")
    }

    @Test
    fun `given 15 respond with XV`() {
        verifyOutput("15", "XV")
    }

    @Test
    fun `given 37 respond with XXXVII`() {
        verifyOutput("37", "XXXVII")
    }

    @Test
    fun `given 47 respond with XLVII`() {
        verifyOutput("47", "XLVII")
    }

    @Test
    fun `given 56 respond with LVI`() {
        verifyOutput("56", "LVI")
    }

    @Test
    fun `given 88 respond with LXXXVIII`() {
        verifyOutput("88", "LXXXVIII")
    }

    @Test
    fun `given 99 respond with XCIX`() {
        verifyOutput("99", "XCIX")
    }

    @Test
    fun `given 100 respond with C`() {
        verifyOutput("100", "C")
    }

    @Test
    fun `given 0 respond with empty string`() {
        verifyOutput("0", "")
    }

    @Test
    fun `given 10000 respond with empty string`() {
        verifyOutput("10000", "")
    }

    private fun verifyOutput(input: String, romanNum: String) {
        val expectedOutput = "Input is: $input"

        System.setIn(ByteArrayInputStream(input.toByteArray()))
        main()
        assert(testOut.toString().contains(expectedOutput))
        assert(testOut.toString().contains("\n$romanNum\n"))
    }
}
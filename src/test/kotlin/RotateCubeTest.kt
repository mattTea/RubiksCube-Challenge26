import Direction.ACW
import Direction.CW
import FaceToRotate.BOTTOM
import FaceToRotate.TOP
import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

class RotateCubeTest {
    private val startingCube = listOf(
        "GGGGGGGGG",
        "YYYYYYYYY",
        "OOOOOOOOO",
        "RRRRRRRRR",
        "WWWWWWWWW",
        "BBBBBBBBB"
    )

    @Test
    fun `should return new cube with 4 faces updated following CW rotation of top face`() {
        val result = rotateCube(startingCube, TOP, CW)
        val expected = listOf(
            "RRRGGGGGG",
            "OOOYYYYYY",
            "GGGOOOOOO",
            "YYYRRRRRR",
            "WWWWWWWWW",
            "BBBBBBBBB"
        )

        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `should return new cube with 4 faces updated following ACW rotation of top face`() {
        val result = rotateCube(startingCube, TOP, ACW)
        val expected = listOf(
            "OOOGGGGGG",
            "RRRYYYYYY",
            "YYYOOOOOO",
            "GGGRRRRRR",
            "WWWWWWWWW",
            "BBBBBBBBB"
        )

        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `should return new cube with 4 faces updated following CW rotation of bottom face`() {
        val result = rotateCube(startingCube, BOTTOM, CW)
        val expected = listOf(
            "GGGGGGOOO",
            "YYYYYYRRR",
            "OOOOOOYYY",
            "RRRRRRGGG",
            "WWWWWWWWW",
            "BBBBBBBBB"
        )

        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `should return new cube with 4 faces updated following ACW rotation of bottom face`() {
        val result = rotateCube(startingCube, BOTTOM, ACW)
        val expected = listOf(
            "GGGGGGRRR",
            "YYYYYYOOO",
            "OOOOOOGGG",
            "RRRRRRYYY",
            "WWWWWWWWW",
            "BBBBBBBBB"
        )

        assertThat(result).isEqualTo(expected)
    }
}
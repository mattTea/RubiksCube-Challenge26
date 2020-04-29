import Direction.CW
import FaceToRotate.TOP
import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

class RotateCubeTest {
    @Test
    fun `should return new cube with 4 faces updated following rotation of top face`() {
        val startingCube = listOf(
            "GGGGGGGGG",
            "YYYYYYYYY",
            "OOOOOOOOO",
            "RRRRRRRRR",
            "WWWWWWWWW",
            "BBBBBBBBB"
        )

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
}
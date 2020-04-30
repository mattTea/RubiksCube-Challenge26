import Direction.ACW
import Direction.CW
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
}

// if direction == ACW
// first 3 chars of frontFace [0] move to rightFace [3]
// first 3 chars of rightFace [3] move to backFace [1]
// first 3 chars of backFace [1] move to leftFace [2]
// first 3 chars of leftFace [2] move to leftFace [0]
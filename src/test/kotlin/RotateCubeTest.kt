import Direction.ACW
import Direction.CW
import FaceToRotate.*
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
    fun `should return new cube following CW rotation of top face`() {
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
    fun `should return new cube following ACW rotation of top face`() {
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
    fun `should return new cube following CW rotation of bottom face`() {
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
    fun `should return new cube following ACW rotation of bottom face`() {
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

    @Test
    fun `should return new cube following CW rotation of front face`() {
        val result = rotateCube(startingCube, FRONT, CW)
        val expected = listOf(
            "GGGGGGGGG",
            "YYYYYYYYY",
            "OOBOOBOOB",
            "WRRWRRWRR",
            "WWWWWWOOO",
            "BBBBBBRRR"
        )

        assertThat(result).isEqualTo(expected)
    }
}

/*
Indexes...

FRONT, -> 0
BACK, -> 1
LEFT, -> 2
RIGHT, -> 3
TOP, -> 4
BOTTOM -> 5
*/
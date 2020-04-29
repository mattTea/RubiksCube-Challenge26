import Direction.CW
import FaceToRotate.TOP

fun rotateCube(cube: List<String>, faceToRotate: FaceToRotate, direction: Direction): List<String> {
    /*
    If...
    TOP -> first 3 chars of first 4 cube faces change
    BOTTOM -> last 3 chars of first 4 cube faces change
    */

    return when (faceToRotate) {
        TOP -> rotateTopFace(cube, direction)
        else -> cube
    }
}

private fun rotateTopFace(cube: List<String>, direction: Direction): List<String> {
    return if (direction == CW) {
        // first 3 chars of frontFace [0] move to leftFace [2]
        val leftFace = cube[2].replaceRange(0, 3, cube[0].take(3))
        // first 3 chars of leftFace [2] move to backFace [1]
        val backFace = cube[1].replaceRange(0, 3, cube[2].take(3))
        // first 3 chars of backFace [1] move to rightFace [3]
        val rightFace = cube[3].replaceRange(0, 3, cube[1].take(3))
        // first 3 chars of rightFace [3] move to frontFace [0]
        val frontFace = cube[0].replaceRange(0, 3, cube[3].take(3))

        listOf(frontFace, backFace, leftFace, rightFace, cube[4], cube[5])
    } else {
        cube
    }
}

data class Cube(val faces: List<String>)

enum class FaceToRotate {
    FRONT,
    BACK,
    LEFT,
    RIGHT,
    TOP,
    BOTTOM
}

enum class Direction {
    CW,
    ACW
}
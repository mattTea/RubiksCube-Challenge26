import Direction.ACW
import Direction.CW
import FaceToRotate.TOP

fun rotateCube(cube: List<String>, faceToRotate: FaceToRotate, direction: Direction): List<String> {

    return when (faceToRotate) {
        TOP -> rotateTopFace(cube, direction)
        else -> cube
    }
}

private fun rotateTopFace(cube: List<String>, direction: Direction): List<String> {
    return when (direction) {
        CW -> {
            val leftFace = cube[2].replaceRange(0, 3, cube[0].take(3))
            val backFace = cube[1].replaceRange(0, 3, cube[2].take(3))
            val rightFace = cube[3].replaceRange(0, 3, cube[1].take(3))
            val frontFace = cube[0].replaceRange(0, 3, cube[3].take(3))

            listOf(frontFace, backFace, leftFace, rightFace, cube[4], cube[5])
        }

        ACW -> {
            val rightFace = cube[3].replaceRange(0, 3, cube[0].take(3))
            val backFace = cube[1].replaceRange(0, 3, cube[3].take(3))
            val leftFace = cube[2].replaceRange(0, 3, cube[1].take(3))
            val frontFace = cube[0].replaceRange(0, 3, cube[2].take(3))

            listOf(frontFace, backFace, leftFace, rightFace, cube[4], cube[5])
        }
    }
}

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
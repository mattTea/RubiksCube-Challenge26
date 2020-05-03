import Direction.ACW
import Direction.CW
import FaceToRotate.BOTTOM
import FaceToRotate.TOP

fun rotateCube(cube: List<String>, faceToRotate: FaceToRotate, direction: Direction): List<String> {
    // When a face is to be rotated, this face should now be facing up, and CW/ ACW rotations are made form this starting point
    return when (faceToRotate) {
        TOP -> rotateFace(cube, faceToRotate, direction)
        BOTTOM -> rotateFace(cube, faceToRotate, direction)
        else -> cube
    }
}

private fun rotateFace(cube: List<String>, faceToRotate: FaceToRotate, direction: Direction): List<String> =
    listOf(
        calculateNewFace(cube, faceToRotate, "front", direction),
        calculateNewFace(cube, faceToRotate, "back", direction),
        calculateNewFace(cube, faceToRotate, "left", direction),
        calculateNewFace(cube, faceToRotate, "right", direction),
        calculateNewFace(cube, faceToRotate, "top", direction),
        calculateNewFace(cube, faceToRotate, "bottom", direction)
    )

private fun calculateNewFace(
    cube: List<String>,
    faceToRotate: FaceToRotate,
    face: String,
    direction: Direction
): String =
    when (faceToRotate) {
        TOP -> {
            when (direction) {
                CW -> {
                    when (face) {
                        "left" -> cube[2].replaceRange(IntRange(0, 2), cube[0].take(3))
                        "back" -> cube[1].replaceRange(IntRange(0, 2), cube[2].take(3))
                        "right" -> cube[3].replaceRange(IntRange(0, 2), cube[1].take(3))
                        "front" -> cube[0].replaceRange(IntRange(0, 2), cube[3].take(3))
                        "top" -> cube[4]
                        "bottom" -> cube[5]
                        else -> ""
                    }
                }
                ACW -> {
                    when (face) {
                        "left" -> cube[2].replaceRange(IntRange(0, 2), cube[1].take(3))
                        "back" -> cube[1].replaceRange(IntRange(0, 2), cube[3].take(3))
                        "right" -> cube[3].replaceRange(IntRange(0, 2), cube[0].take(3))
                        "front" -> cube[0].replaceRange(IntRange(0, 2), cube[2].take(3))
                        "top" -> cube[4]
                        "bottom" -> cube[5]
                        else -> ""
                    }
                }
            }
        }
        BOTTOM -> {
            when (direction) {
                CW -> {
                    // branch the same as TOP ACW apart from range that changes
                    when (face) {
                        "left" -> cube[2].replaceRange(IntRange(6, 8), cube[1].take(3))
                        "back" -> cube[1].replaceRange(IntRange(6, 8), cube[3].take(3))
                        "right" -> cube[3].replaceRange(IntRange(6, 8), cube[0].take(3))
                        "front" -> cube[0].replaceRange(IntRange(6, 8), cube[2].take(3))
                        "top" -> cube[4]
                        "bottom" -> cube[5]
                        else -> ""
                    }
                }
                ACW -> {
                    when (face) {
                        // branch the same as TOP CW apart from range that changes
                        "left" -> cube[2].replaceRange(IntRange(6, 8), cube[0].take(3))
                        "back" -> cube[1].replaceRange(IntRange(6, 8), cube[2].take(3))
                        "right" -> cube[3].replaceRange(IntRange(6, 8), cube[1].take(3))
                        "front" -> cube[0].replaceRange(IntRange(6, 8), cube[3].take(3))
                        "top" -> cube[4]
                        "bottom" -> cube[5]
                        else -> ""
                    }
                }
            }
        }
        else -> ""
    }

enum class FaceToRotate {
    FRONT, // 0
    BACK, // 1
    LEFT, // 2
    RIGHT, // 3
    TOP, // 4
    BOTTOM // 5
}

enum class Direction {
    CW,
    ACW
}
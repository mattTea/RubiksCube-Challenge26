import Direction.ACW
import Direction.CW
import FaceToRotate.*

fun rotateCube(cube: List<String>, faceToRotate: FaceToRotate, direction: Direction): List<String> =

    when (faceToRotate) {
        TOP -> {
            when (direction) {
                CW -> {
                    listOf(
                        cube[0].replaceRange(IntRange(0, 2), cube[3].take(3)),
                        cube[1].replaceRange(IntRange(0, 2), cube[2].take(3)),
                        cube[2].replaceRange(IntRange(0, 2), cube[0].take(3)),
                        cube[3].replaceRange(IntRange(0, 2), cube[1].take(3)),
                        cube[4],
                        cube[5]
                    )
                }
                ACW -> {
                    listOf(
                        cube[0].replaceRange(IntRange(0, 2), cube[2].take(3)),
                        cube[1].replaceRange(IntRange(0, 2), cube[3].take(3)),
                        cube[2].replaceRange(IntRange(0, 2), cube[1].take(3)),
                        cube[3].replaceRange(IntRange(0, 2), cube[0].take(3)),
                        cube[4],
                        cube[5]
                    )
                }
            }
        }
        BOTTOM -> {
            when (direction) {
                CW -> {
                    listOf(
                        cube[0].replaceRange(IntRange(6, 8), cube[2].take(3)),
                        cube[1].replaceRange(IntRange(6, 8), cube[3].take(3)),
                        cube[2].replaceRange(IntRange(6, 8), cube[1].take(3)),
                        cube[3].replaceRange(IntRange(6, 8), cube[0].take(3)),
                        cube[4],
                        cube[5]
                    )
                }
                ACW -> {
                    listOf(
                        cube[0].replaceRange(IntRange(6, 8), cube[3].take(3)),
                        cube[1].replaceRange(IntRange(6, 8), cube[2].take(3)),
                        cube[2].replaceRange(IntRange(6, 8), cube[0].take(3)),
                        cube[3].replaceRange(IntRange(6, 8), cube[1].take(3)),
                        cube[4],
                        cube[5]
                    )
                }
            }
        }
        FRONT -> {
            when (direction) {
                CW -> {
                    listOf(
                        cube[0],
                        cube[1],
                        cube[2]
                            .mapIndexed { index, char -> if ((index + 1) % 3 == 0) cube[5][0] else char }
                            .joinToString(""),
                        cube[3]
                            .mapIndexed { index, char -> if (index % 3 == 0) cube[4][0] else char }
                            .joinToString(""),
                        cube[4].replaceRange(IntRange(6, 8), cube[2].take(3)),
                        cube[5].replaceRange(IntRange(6, 8), cube[3].take(3))
                    )
                }
                ACW -> {
                    listOf(

                    )
                }
            }
        }
        else -> cube
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
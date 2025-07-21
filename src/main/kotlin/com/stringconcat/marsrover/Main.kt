import com.stringconcat.marsrover.domain.entity.Coordinate
import com.stringconcat.marsrover.domain.entity.Direction
import com.stringconcat.marsrover.domain.entity.Plateau
import com.stringconcat.marsrover.domain.entity.Rover

fun main(args: Array<String>) {
    val rover = Rover(Coordinate(0, 0), Direction.NORTH)
    val mars = Plateau(width = 20, height = 20)
    mars.land(rover)

    rover.turnLeft()
    rover.move()
    rover.turnRight()

    println(rover.coordinates)
    println(rover.direction())

}
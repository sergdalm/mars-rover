package com.stringconcat.marsrover.domain.error

class RoverNotPresentException : RuntimeException() {
    override val message: String = "Rover is not present on the plateau"

}

package com.stringconcat.marsrover

class Plateau(val width: Int, val height: Int) {
    var rover : Rover? = null

    fun land(rover: Rover) {
        this.rover = rover
    }


}

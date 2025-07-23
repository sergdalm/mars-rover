package com.stringconcat.marsrover.adapter.out

import com.stringconcat.marsrover.domain.entity.Plateau
import com.stringconcat.marsrover.domain.port.PlateauStorage

class InMemoryPlateauStorage : PlateauStorage {
    var plateau: Plateau? = null

    override fun save(plateau: Plateau): Plateau {
        this.plateau = plateau
        return plateau
    }

    override fun get(): Plateau? {
        return plateau
    }
}
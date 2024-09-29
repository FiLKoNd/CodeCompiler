package com.filkond.codecompiler.compiler

import org.bukkit.entity.Player

interface Compiler {
    @Throws(CompilerException::class)
    fun compile(player: Player, args: Array<out String>): Any?
}

class CompilerException(override val message: String) : Exception()
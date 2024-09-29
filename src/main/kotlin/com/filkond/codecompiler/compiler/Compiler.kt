package com.filkond.codecompiler.compiler

import org.bukkit.entity.Player

interface Compiler {
    fun compile(player: Player, code: String): Any
}

class CompilerException(override val message: String) : Exception()
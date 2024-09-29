package com.filkond.codecompiler.compiler

import bsh.Interpreter
import org.bukkit.entity.Player
import org.bukkit.inventory.meta.BookMeta

class BookCompiler : Compiler {
    private val interpreter = Interpreter()
        get() = field.also { it.reset() }

    override fun compile(player: Player, code: String): Any {
        val stack = player.inventory.itemInMainHand
        if (stack.type != org.bukkit.Material.WRITTEN_BOOK || stack.type != org.bukkit.Material.WRITABLE_BOOK) {
            throw CompilerException("Not a book")
        }

        val meta = stack.itemMeta as BookMeta
        val builder = StringBuilder()
        meta.pages.forEach {
            builder.append(it)
        }

        interpreter.set("player", player)
        return interpreter.eval(builder.toString())
    }
}
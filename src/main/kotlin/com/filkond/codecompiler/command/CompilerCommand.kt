package com.filkond.codecompiler.command

import com.filkond.codecompiler.compiler.BookCompiler
import com.filkond.codecompiler.compiler.CompilerException
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.command.TabExecutor
import org.bukkit.entity.Player

class CompilerCommand(
    private val compiler: BookCompiler
) : TabExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender !is Player) {
            sender.sendMessage("Only players can use this command")
            return true
        }

        if ("book" == args.getOrNull(0)) {
            try {
                compiler.compile(sender, args)
            } catch (e: CompilerException) {
                sender.sendMessage(e.message)
            }
            return true
        }

        sender.sendMessage("Usage: /compiler <book>")
        return true
    }

    override fun onTabComplete(
        sender: CommandSender,
        command: Command,
        label: String,
        args: Array<out String>
    ): MutableList<String> {
        if (args.size == 1) {
            return mutableListOf("book")
        }

        return mutableListOf()
    }
}
package com.filkond.codecompiler

import com.filkond.codecompiler.command.CompilerCommand
import com.filkond.codecompiler.compiler.BookCompiler
import org.bukkit.plugin.java.JavaPlugin

class CodeCompiler : JavaPlugin() {
    override fun onEnable() {
        getCommand("compiler")!!.setExecutor(CompilerCommand(BookCompiler()))
    }
}

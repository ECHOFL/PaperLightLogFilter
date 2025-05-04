package me.fliqq.logfilter;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class GenlifeReloadConsoleFilterCommand implements TabExecutor {

    private final GenlifeLogFilter plugin; 

    public GenlifeReloadConsoleFilterCommand(GenlifeLogFilter plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        
        if (!sender.hasPermission("logfilter.reload")) {
            sender.sendMessage(plugin.getNoPermissionMessage());
            return true;
        }

        plugin.loadConfigs();

        ((org.apache.logging.log4j.core.Logger) org.apache.logging.log4j.LogManager.getRootLogger())
                .addFilter(new LogFilter(plugin.getFilter())); 
        
        sender.sendMessage(plugin.getConfigReloadedMessage()); 
        return true;
    }

    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        return new ArrayList<>();
    }
}

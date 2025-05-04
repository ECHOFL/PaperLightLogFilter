package me.fliqq.logfilter;

import lombok.Getter;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.TextComponent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.List;

public class GenlifeLogFilter extends JavaPlugin {

    @Getter
    private TextComponent noPermissionMessage;

    @Getter
    private TextComponent configReloadedMessage;

    @Getter
    private List<String> filter;

    @Override
    public void onEnable() {
        loadConfigs();

        getCommand("reloadlogfilter").setExecutor(new GenlifeReloadConsoleFilterCommand(this));

        // Ajout du filtre de log
        ((Logger) LogManager.getRootLogger()).addFilter(new LogFilter(getFilter()));

        getLogger().info("Plugin Genlife-LogFilter activé avec succès!");
    }

    public void loadConfigs() {
        File file = new File(getDataFolder(), "config.yml");

        if (!file.exists()) {
            getLogger().warning("Fichier de configuration manquant! Création du fichier par défaut...");
            saveDefaultConfig();
        }

        String noPermissionText = ChatColor.translateAlternateColorCodes('&', getConfig().getString("config.no-permission-message", "&cVous n'avez pas la permission &7consolefilter.reload"));
        String configReloadedText = ChatColor.translateAlternateColorCodes('&', getConfig().getString("config.config-reloaded-message", "&cGenlifeLogFilter &aConfiguration rechargée!"));
        this.noPermissionMessage = new TextComponent(noPermissionText);
        this.configReloadedMessage = new TextComponent(configReloadedText);

        this.filter = getConfig().getStringList("config.filter");
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin Genlife-LogFilter désactivé.");
    }
}

package caps123987.itemmenulib;

import caps123987.itemmenulib.api.registry.ItemRegistry;
import org.bukkit.plugin.java.JavaPlugin;

public final class ItemMenuLib extends JavaPlugin {

    public static ItemMenuLib instance;
    private ItemRegistry itemRegistry;

    @Override
    public void onEnable() {
        instance = this;

        itemRegistry = new ItemRegistry();

        getServer().getPluginManager().registerEvents(itemRegistry, this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static ItemMenuLib getInstance() {
        return instance;
    }

    public ItemRegistry getMenuRegistry() {
        return itemRegistry;
    }
}

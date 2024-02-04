package caps123987.itemmenulib.itemmenu;

import caps123987.itemmenulib.ItemMenuLib;
import caps123987.itemmenulib.registry.ItemRegistry;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class ItemMenu {
    private Inventory inventory;
    private final ItemRegistry itemRegistry;

    public ItemMenu(String title, int size) {
        this.inventory = Bukkit.createInventory(null, size, title);
        itemRegistry = ItemMenuLib.getInstance().getMenuRegistry();
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void open(Player p){
        itemRegistry.addMenuBuffer(p.getUniqueId(), this);
    }
    
}

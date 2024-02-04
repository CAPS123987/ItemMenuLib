package caps123987.itemmenulib.api.itemmenu;

import caps123987.itemmenulib.ItemMenuLib;
import caps123987.itemmenulib.api.registry.ItemRegistry;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import java.util.HashMap;
import java.util.function.Consumer;

public class ItemMenu {
    private Inventory inventory;
    private final ItemRegistry itemRegistry;
    Consumer<InventoryClickEvent> anyClickConsumer;
    HashMap<Integer, ItemClickHandler> clickHandlers = new HashMap<>();

    public ItemMenu(int size, String title) {
        this.inventory = Bukkit.createInventory(null, size, title);
        itemRegistry = ItemMenuLib.getInstance().getMenuRegistry();
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void open(Player p){
        itemRegistry.addMenuBuffer(p.getUniqueId(), this);
        p.openInventory(inventory);
    }

    public void onClick(InventoryClickEvent e) {
        ItemClickHandler handler = clickHandlers.get(e.getSlot());

        if(handler != null){
            handler.onClick(e);
        }

        if(anyClickConsumer != null){
            anyClickConsumer.accept(e);
        }
    }

    public void addItemClickHandler(int slot, ItemClickHandler handler){
        clickHandlers.put(slot, handler);
    }

    public void removeItemClickHandler(int slot){
        clickHandlers.remove(slot);
    }
    public void onAnyClick(Consumer<InventoryClickEvent> consumer){
        anyClickConsumer = consumer;
    }

    public interface ItemClickHandler {
        public void onClick(InventoryClickEvent e);
    }
}

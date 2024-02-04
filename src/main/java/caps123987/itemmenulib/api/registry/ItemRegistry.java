package caps123987.itemmenulib.api.registry;

import caps123987.itemmenulib.api.itemmenu.ItemMenu;
import org.bukkit.Bukkit;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ItemRegistry implements Listener {
    private final Map<UUID, ItemMenu> itemMenus = new HashMap<>();
    private final Map<UUID, ItemMenu> buffer = new HashMap<>();

    public void addMenuBuffer(UUID uuid, ItemMenu itemMenu) {
        buffer.put(uuid, itemMenu);
    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent e) {
        for(HumanEntity p:e.getViewers()){
            itemMenus.remove(p.getUniqueId());
        }
    }

    @EventHandler
    public void onInventoryOpen(InventoryOpenEvent e) {
        for(HumanEntity p:e.getViewers()){
            if(buffer.containsKey(p.getUniqueId())){
                itemMenus.put(p.getUniqueId(), buffer.get(p.getUniqueId()));
                buffer.remove(p.getUniqueId());
            }
        }
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        ItemMenu itemMenu = itemMenus.get(e.getWhoClicked().getUniqueId());
        if(itemMenu != null){
            itemMenu.onClick(e);
        }
    }
}

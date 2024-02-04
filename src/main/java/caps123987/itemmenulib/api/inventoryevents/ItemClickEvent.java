package caps123987.itemmenulib.api.inventoryevents;

import caps123987.itemmenulib.api.itemmenu.ItemMenu;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class ItemClickEvent extends InventoryClickEvent {

    private final ItemMenu menu;

    public ItemClickEvent(InventoryClickEvent e, ItemMenu menu){
        super(e.getView(),e.getSlotType(),e.getSlot(),e.getClick(),e.getAction());
        this.menu = menu;
    }

    public ItemMenu getMenu(){
        return menu;
    }

}

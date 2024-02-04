package caps123987.itemmenulib.api.inventoryevents;

import caps123987.itemmenulib.api.itemmenu.ItemMenu;
import org.bukkit.event.inventory.InventoryClickEvent;


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

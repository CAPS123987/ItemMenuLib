package caps123987.itemmenulib;

import caps123987.itemmenulib.api.itemmenu.ItemMenu;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class comm implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        ItemMenu menu = new ItemMenu(27);

        menu.getInventory().setItem(13, new ItemStack(Material.DIAMOND));

        menu.addItemClickHandler(13, e -> {
            e.getWhoClicked().sendMessage("You clicked the diamond");
            e.setCancelled(true);
        });


        menu.open((Player) sender);



        return true;
    }
}

package me.sat7.dynamicshop.commands;

import org.bukkit.entity.Player;

import me.sat7.dynamicshop.DynamicShop;

import java.util.UUID;

import static me.sat7.dynamicshop.utilities.LangUtil.t;

public final class CommandHelp extends DSCMD
{
    public CommandHelp()
    {
        permission = "";
        validArgCount.add(2);
    }

    @Override
    public void SendHelpMessage(Player player)
    {
        player.sendMessage(DynamicShop.dsPrefix + t("HELP.TITLE").replace("{command}", "cmdHelp"));
        player.sendMessage(" - " + t("HELP.USAGE") + ": /ds cmdHelp <on | off>");
        player.sendMessage(" - " + t("HELP.CMD"));

        player.sendMessage("");
    }

    @Override
    public void RunCMD(String[] args, Player player)
    {
        if(!CheckValid(args, player))
            return;

        UUID uuid = player.getUniqueId();

        if (args[1].equalsIgnoreCase("on"))
        {
            player.sendMessage(DynamicShop.dsPrefix + "켜짐");
            DynamicShop.userTempData.put(uuid, "");
            DynamicShop.ccUser.get().set(player.getUniqueId() + ".cmdHelp", true);
            DynamicShop.ccUser.save();
        } else if (args[1].equalsIgnoreCase("off"))
        {
            player.sendMessage(DynamicShop.dsPrefix + "꺼짐");
            DynamicShop.userTempData.put(uuid, "");
            DynamicShop.ccUser.get().set(player.getUniqueId() + ".cmdHelp", false);
            DynamicShop.ccUser.save();
        } else
        {
            player.sendMessage(DynamicShop.dsPrefix + t("ERR.WRONG_USAGE"));
        }

        return;
    }
}

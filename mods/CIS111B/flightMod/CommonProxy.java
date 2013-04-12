package mods.CIS111B.flightMod;

import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

public class CommonProxy {
    public static String ITEMS_PNG = "/CIS11B/FlightMod/items.png";
    public static String BLOCK_PNG = "/CIS11B/FlightMod/block.png";
    
    // Client stuff
    public void registerRenderers() {
            // Nothing here as the server doesn't render graphics!
    }
}
package mods.CIS111B.flightMod;

import mods.CIS111B.flightMod.GenericItem;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

@Mod(modid="FlightMod", name="FlightMod", version="0.0.0")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class FlightMod {
	// The instance of your mod that Forge uses.
    @Instance("FlightMod")
    public static FlightMod instance;
    //Declaration of all items
    private static final net.minecraft.item.Item avianDNA = new GenericItem(700).setCreativeTab(CreativeTabs.tabMaterials).setMaxStackSize(64).setUnlocalizedName("avianDNA");
    private static final net.minecraft.item.Item airEssence = new GenericItem(701).setCreativeTab(CreativeTabs.tabMaterials).setMaxStackSize(64).setUnlocalizedName("airEssence");
    private static final net.minecraft.item.Item wing = new GenericItem(702).setCreativeTab(CreativeTabs.tabMaterials).setMaxStackSize(64).setUnlocalizedName("wing");
    private static final net.minecraft.item.Item carpo = new GenericItem(703).setCreativeTab(CreativeTabs.tabMaterials).setMaxStackSize(64).setUnlocalizedName("carpo");
    private static final net.minecraft.item.Item ulna = new GenericItem(704).setCreativeTab(CreativeTabs.tabMaterials).setMaxStackSize(64).setUnlocalizedName("ulna");
    private static final net.minecraft.item.Item humerus = new GenericItem(705).setCreativeTab(CreativeTabs.tabMaterials).setMaxStackSize(64).setUnlocalizedName("humerus");
    private static final net.minecraft.item.Item downy = new GenericItem(706).setCreativeTab(CreativeTabs.tabMaterials).setMaxStackSize(64).setUnlocalizedName("downy");
    private static final net.minecraft.item.Item secondary = new GenericItem(707).setCreativeTab(CreativeTabs.tabMaterials).setMaxStackSize(64).setUnlocalizedName("secondary");
    private static final net.minecraft.item.Item primary = new GenericItem(708).setCreativeTab(CreativeTabs.tabMaterials).setMaxStackSize(64).setUnlocalizedName("primary");
    private static final net.minecraft.item.Item skin = new GenericItem(709).setCreativeTab(CreativeTabs.tabMaterials).setMaxStackSize(64).setUnlocalizedName("skin");
    private static final net.minecraft.item.Item tissue = new GenericItem(710).setCreativeTab(CreativeTabs.tabMaterials).setMaxStackSize(64).setUnlocalizedName("tissue");
    static final net.minecraft.item.Item revitalizer = new ItemRevitalizer(711).setCreativeTab(CreativeTabs.tabMisc).setMaxStackSize(1).setUnlocalizedName("revitalizer");
    private static EnumArmorMaterial WingMaterial = net.minecraftforge.common.EnumHelper.addArmorMaterial("wing", 0, new int[]{0,0,0,0} ,0);
    static final net.minecraft.item.Item wings = new Wings(712, WingMaterial, 0, 1).setCreativeTab(CreativeTabs.tabMisc).setMaxStackSize(1).setUnlocalizedName("wings");
    static final ItemStack wingstack = new ItemStack(wings,1);
    /**PlayerCapabilities capa = new PlayerCapabilities();
    EntityPlayer p = new EntityPlayer(this.World);
    InventoryPlayer inv = new InventoryPlayer(this.EntityPlayer);*/
    // Says where the client and server 'proxy' code is loaded.
    @SidedProxy(clientSide = "mods.CIS111B.flightMod.client.ClientProxy", serverSide = "mods.CIS111B.flightMod.CommonProxy")
    public static CommonProxy proxy;
    
    @PreInit
    public void preInit(FMLPreInitializationEvent event) {
            // Stub Method
    }
    
    @Init
    public void load(FMLInitializationEvent event) {
            proxy.registerRenderers();
            TickRegistry.registerTickHandler(new ServerTickHandler(), Side.CLIENT);
            TickRegistry.registerTickHandler(new ServerTickHandler(), Side.SERVER);
            //registration of all item names in Forge dictionary
            LanguageRegistry.addName(avianDNA,"Avian DNA");
            LanguageRegistry.addName(airEssence,"Air Essence");
            LanguageRegistry.addName(wing,"Wing");
            LanguageRegistry.addName(carpo,"Carpometacarpus");
            LanguageRegistry.addName(ulna,"Ulna");
            LanguageRegistry.addName(humerus,"Humerus");
            LanguageRegistry.addName(downy,"Downy Feathers");
            LanguageRegistry.addName(secondary,"Secondary Feathers");
            LanguageRegistry.addName(primary,"Primary Feathers");
            LanguageRegistry.addName(skin,"Skin");
            LanguageRegistry.addName(tissue,"Tissue");
            LanguageRegistry.addName(revitalizer,"Revitalizer");
            LanguageRegistry.addName(wings,"Wings");
            //Adding of smelting recipes
            GameRegistry.addSmelting(288, new ItemStack(avianDNA,1), 0.1f);
            //Itemstacks to be used in recipes
            ItemStack featherstack = new ItemStack(288,1,0);
            ItemStack diamondstack = new ItemStack(264,1,0);
            ItemStack bonestack = new ItemStack(352,1,0);
            ItemStack woolstack = new ItemStack(35,1,0);
            ItemStack rfleshstack = new ItemStack(367,1,0);
            ItemStack leatherstack = new ItemStack(334,1,0);
            ItemStack seyestack = new ItemStack(375,1,0);
            ItemStack porkstack = new ItemStack(319,1,0);
            ItemStack waterstack = new ItemStack(326,1,0);
            ItemStack beefstack = new ItemStack(363,1,0);
            ItemStack chickenstack = new ItemStack(365,1,0);
            ItemStack enderstack = new ItemStack(368,1,0);
            //Addition of crafting recipes
            GameRegistry.addRecipe(new ItemStack(airEssence),"xxx","xyx","xxx",'x',featherstack,'y',diamondstack);
            GameRegistry.addRecipe(new ItemStack(wing),"abc","ded","fgh",'a',carpo,'b',ulna,'c',humerus,'d',skin,'e',tissue,'f',primary,'g',secondary,'h',downy);
            GameRegistry.addRecipe(new ItemStack(carpo,2),"xyx",'x',bonestack,'y',avianDNA);
            GameRegistry.addRecipe(new ItemStack(ulna,3),"xx","xy",'x',bonestack,'y',avianDNA);
            GameRegistry.addRecipe(new ItemStack(humerus,4),"xx","xy","xy",'x',bonestack,'y',avianDNA);
            GameRegistry.addRecipe(new ItemStack(downy,8),"x x"," y ","x x",'x',featherstack,'y',woolstack);
            GameRegistry.addRecipe(new ItemStack(secondary,8),"x","x",'x',featherstack);
            GameRegistry.addRecipe(new ItemStack(primary,8),"x","x","x",'x',featherstack);
            //Adds recipes for all damage values of revitalizer item
            for(int i = 0; i < revitalizer.getMaxDamage(); i++)
            {
            	ItemStack revitStack = new ItemStack(revitalizer,1,i);
            	GameRegistry.addRecipe(new ItemStack(skin,4),"xyx","yzy","xyx",'x',rfleshstack,'y',leatherstack,'z',revitStack);
            }
            GameRegistry.addRecipe(new ItemStack(tissue,2),"xxx","yzy","xxx",'x',seyestack,'y',porkstack,'z',waterstack);
            GameRegistry.addRecipe(new ItemStack(revitalizer),"xyx","wzw","xyx",'w',chickenstack,'x',porkstack,'y',beefstack,'z',enderstack);
            GameRegistry.addRecipe(new ItemStack(wings),"xyx","zzz","zzz",'x',wing,'y',airEssence,'z',avianDNA);
    }
    
    @PostInit
    public void postInit(FMLPostInitializationEvent event) {
    	GameRegistry.registerCraftingHandler(new CraftingHandler());
    }
    public static boolean isPairOfWings(int id) {
		return (id == wings.itemID);
	}
}

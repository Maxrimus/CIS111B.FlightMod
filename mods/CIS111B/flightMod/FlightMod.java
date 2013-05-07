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
import net.minecraft.src.ModLoader;
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

@Mod(modid="FlightMod", name="PilotWings: A Flight Mod", version="0.1.0")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class FlightMod {
	// The instance of your mod that Forge uses.
    @Instance("FlightMod")
    public static FlightMod instance;
    //Declaration of all items
    //materials
    static final net.minecraft.item.Item avianDNA = new GenericItem(700).setCreativeTab(CreativeTabs.tabMaterials).setMaxStackSize(64).setUnlocalizedName("avianDNA");
    static final net.minecraft.item.Item airEssence = new GenericItem(701).setCreativeTab(CreativeTabs.tabMaterials).setMaxStackSize(64).setUnlocalizedName("airEssence");
    static final net.minecraft.item.Item wing = new GenericItem(702).setCreativeTab(CreativeTabs.tabMaterials).setMaxStackSize(64).setUnlocalizedName("wing");
    static final net.minecraft.item.Item carpo = new GenericItem(703).setCreativeTab(CreativeTabs.tabMaterials).setMaxStackSize(64).setUnlocalizedName("carpo");
    static final net.minecraft.item.Item ulna = new GenericItem(704).setCreativeTab(CreativeTabs.tabMaterials).setMaxStackSize(64).setUnlocalizedName("ulna");
    static final net.minecraft.item.Item humerus = new GenericItem(705).setCreativeTab(CreativeTabs.tabMaterials).setMaxStackSize(64).setUnlocalizedName("humerus");
    static final net.minecraft.item.Item downy = new GenericItem(706).setCreativeTab(CreativeTabs.tabMaterials).setMaxStackSize(64).setUnlocalizedName("downy");
    static final net.minecraft.item.Item secondary = new GenericItem(707).setCreativeTab(CreativeTabs.tabMaterials).setMaxStackSize(64).setUnlocalizedName("secondary");
    static final net.minecraft.item.Item primary = new GenericItem(708).setCreativeTab(CreativeTabs.tabMaterials).setMaxStackSize(64).setUnlocalizedName("primary");
    static final net.minecraft.item.Item skin = new GenericItem(709).setCreativeTab(CreativeTabs.tabMaterials).setMaxStackSize(64).setUnlocalizedName("skin");
    static final net.minecraft.item.Item tissue = new GenericItem(710).setCreativeTab(CreativeTabs.tabMaterials).setMaxStackSize(64).setUnlocalizedName("tissue");
    static final net.minecraft.item.Item revitalizer = new ItemRevitalizer(711).setCreativeTab(CreativeTabs.tabMisc).setMaxStackSize(1).setUnlocalizedName("revitalizer");
    //wings
    static EnumArmorMaterial WingMaterial = net.minecraftforge.common.EnumHelper.addArmorMaterial("wing", 0, new int[]{0,0,0,0} ,0);
    static final net.minecraft.item.Item wings = new Wings(712, WingMaterial, 0, 1).setCreativeTab(CreativeTabs.tabMisc).setMaxStackSize(1).setUnlocalizedName("wings");
    static final ItemStack wingstack = new ItemStack(wings,1);
    //armor materials
    public static EnumArmorMaterial winged_leather = net.minecraftforge.common.EnumHelper.addArmorMaterial("Winged Leather", 5, new int[] { 1, 3, 2, 1 }, 15);
    public static EnumArmorMaterial winged_chain = net.minecraftforge.common.EnumHelper.addArmorMaterial("Winged Chain", 15, new int[] { 2, 5, 4, 1 }, 12);
    public static EnumArmorMaterial winged_iron = net.minecraftforge.common.EnumHelper.addArmorMaterial("Winged Iron", 15, new int[] { 2, 6, 5, 2 }, 9);
    public static EnumArmorMaterial winged_gold = net.minecraftforge.common.EnumHelper.addArmorMaterial("Winged Gold", 7, new int[] { 2, 5, 3, 1 }, 25);
	public static EnumArmorMaterial winged_diamond = net.minecraftforge.common.EnumHelper.addArmorMaterial("Winged Diamond", 33, new int[] { 3, 8, 6, 3 },10);
	//armors
	//leather
	public static Item winged_leather_helmet = new FlightArmor(600, winged_leather,ModLoader.addArmor("winged_leather"), 0).setCreativeTab(CreativeTabs.tabCombat).setUnlocalizedName("wLHelm");
	public static Item winged_leather_chest = new FlightArmor(601, winged_leather,ModLoader.addArmor("winged_leather"), 1).setCreativeTab(CreativeTabs.tabCombat).setUnlocalizedName("wLChest");
	public static Item winged_leather_legs = new FlightArmor(602, winged_leather,ModLoader.addArmor("winged_leather"), 2).setCreativeTab(CreativeTabs.tabCombat).setUnlocalizedName("wLPants");
	public static Item winged_leather_boots = new FlightArmor(603, winged_leather,ModLoader.addArmor("winged_leather"), 3).setCreativeTab(CreativeTabs.tabCombat).setUnlocalizedName("wLBoot");
	//chain
	public static Item winged_chain_helmet = new FlightArmor(604, winged_chain, ModLoader.addArmor("winged_chain"), 0).setCreativeTab(CreativeTabs.tabCombat).setUnlocalizedName("wCHelm");
	public static Item winged_chain_chest = new FlightArmor(605, winged_chain, ModLoader.addArmor("winged_chain"), 1).setCreativeTab(CreativeTabs.tabCombat).setUnlocalizedName("wCChest");
	public static Item winged_chain_legs = new FlightArmor(606, winged_chain, ModLoader.addArmor("winged_chain"), 2).setCreativeTab(CreativeTabs.tabCombat).setUnlocalizedName("wCPants");
	public static Item winged_chain_boots = new FlightArmor(607, winged_chain, ModLoader.addArmor("winged_chain"), 3).setCreativeTab(CreativeTabs.tabCombat).setUnlocalizedName("wCBoot");
	//iron
	public static Item winged_iron_helmet = new FlightArmor(608, winged_iron, ModLoader.addArmor("winged_iron"), 0).setCreativeTab(CreativeTabs.tabCombat).setUnlocalizedName("wIHelm");
	public static Item winged_iron_chest = new FlightArmor(609, winged_iron, ModLoader.addArmor("winged_iron"), 1).setCreativeTab(CreativeTabs.tabCombat).setUnlocalizedName("wIChest");
	public static Item winged_iron_legs = new FlightArmor(610, winged_iron, ModLoader.addArmor("winged_iron"), 2).setCreativeTab(CreativeTabs.tabCombat).setUnlocalizedName("wIPants");
	public static Item winged_iron_boots = new FlightArmor(611, winged_iron, ModLoader.addArmor("winged_iron"), 3).setCreativeTab(CreativeTabs.tabCombat).setUnlocalizedName("wIBoot");
	//gold
	public static Item winged_gold_helmet = new FlightArmor(612, winged_gold,ModLoader.addArmor("winged_gold"), 0).setCreativeTab(CreativeTabs.tabCombat).setUnlocalizedName("wGHelm");
	public static Item winged_gold_chest = new FlightArmor(613, winged_gold,ModLoader.addArmor("winged_gold"), 1).setCreativeTab(CreativeTabs.tabCombat).setUnlocalizedName("wGChest");
	public static Item winged_gold_legs = new FlightArmor(614, winged_gold,ModLoader.addArmor("winged_gold"), 2).setCreativeTab(CreativeTabs.tabCombat).setUnlocalizedName("wGPants");
	public static Item winged_gold_boots = new FlightArmor(615, winged_gold,ModLoader.addArmor("winged_gold"), 3).setCreativeTab(CreativeTabs.tabCombat).setUnlocalizedName("wGBoot");
	//diamond
	public static Item winged_diamond_helmet = new FlightArmor(616, winged_diamond,ModLoader.addArmor("winged_diamond"), 0).setCreativeTab(CreativeTabs.tabCombat).setUnlocalizedName("wDHelm");
	public static Item winged_diamond_chest = new FlightArmor(617, winged_diamond,ModLoader.addArmor("winged_diamond"), 1).setCreativeTab(CreativeTabs.tabCombat).setUnlocalizedName("wDChest");
	public static Item winged_diamond_legs = new FlightArmor(618, winged_diamond,ModLoader.addArmor("winged_diamond"), 2).setCreativeTab(CreativeTabs.tabCombat).setUnlocalizedName("wDPants");
	public static Item winged_diamond_boots = new FlightArmor(619, winged_diamond,ModLoader.addArmor("winged_diamond"), 3).setCreativeTab(CreativeTabs.tabCombat).setUnlocalizedName("wDBoot");
	
	// Says where the client and server 'proxy' code is loaded.
    @SidedProxy(clientSide = "mods.CIS111B.flightMod.client.ClientProxy", serverSide = "mods.CIS111B.flightMod.CommonProxy")
    public static CommonProxy proxy;
    
    @PreInit
    public void preInit(FMLPreInitializationEvent event) {
    	 addNames();
         addRecipes();
         addTickers(); 
    }
    
    @Init
    public void load(FMLInitializationEvent event) {
            proxy.registerRenderers();  
    }
    
    private void addTickers() {
    	TickRegistry.registerTickHandler(new ServerTickHandler(), Side.CLIENT);
        TickRegistry.registerTickHandler(new ServerTickHandler(), Side.SERVER);		
	}

	private void addRecipes() {
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
        GameRegistry.addShapelessRecipe(new ItemStack(winged_leather_chest, 1), new ItemStack(299,1,0), new ItemStack(wings));
        GameRegistry.addShapelessRecipe(new ItemStack(winged_chain_chest, 1), new ItemStack(303,1,0), new ItemStack(wings));
        GameRegistry.addShapelessRecipe(new ItemStack(winged_iron_chest, 1), new ItemStack(307,1,0), new ItemStack(wings));
        GameRegistry.addShapelessRecipe(new ItemStack(winged_gold_chest, 1), new ItemStack(315,1,0), new ItemStack(wings));
        GameRegistry.addShapelessRecipe(new ItemStack(winged_diamond_chest, 1), new ItemStack(311,1,0), new ItemStack(wings));
        GameRegistry.addShapelessRecipe(new ItemStack(winged_leather_helmet), new ItemStack(298,1,0), new ItemStack(avianDNA), new ItemStack(avianDNA), new ItemStack(avianDNA));
        GameRegistry.addShapelessRecipe(new ItemStack(winged_chain_helmet), new ItemStack(302,1,0), new ItemStack(avianDNA), new ItemStack(avianDNA), new ItemStack(avianDNA));
        GameRegistry.addShapelessRecipe(new ItemStack(winged_iron_helmet), new ItemStack(306,1,0), new ItemStack(avianDNA), new ItemStack(avianDNA), new ItemStack(avianDNA));
        GameRegistry.addShapelessRecipe(new ItemStack(winged_diamond_helmet), new ItemStack(310,1,0), new ItemStack(avianDNA), new ItemStack(avianDNA), new ItemStack(avianDNA));
        GameRegistry.addShapelessRecipe(new ItemStack(winged_gold_helmet), new ItemStack(314,1,0), new ItemStack(avianDNA), new ItemStack(avianDNA), new ItemStack(avianDNA));
        GameRegistry.addShapelessRecipe(new ItemStack(winged_leather_legs), new ItemStack(300,1,0), new ItemStack(avianDNA), new ItemStack(avianDNA), new ItemStack(avianDNA));
        GameRegistry.addShapelessRecipe(new ItemStack(winged_chain_legs), new ItemStack(304,1,0), new ItemStack(avianDNA), new ItemStack(avianDNA), new ItemStack(avianDNA));
        GameRegistry.addShapelessRecipe(new ItemStack(winged_iron_legs), new ItemStack(308,1,0), new ItemStack(avianDNA), new ItemStack(avianDNA), new ItemStack(avianDNA));
        GameRegistry.addShapelessRecipe(new ItemStack(winged_diamond_legs), new ItemStack(312,1,0), new ItemStack(avianDNA), new ItemStack(avianDNA), new ItemStack(avianDNA));
        GameRegistry.addShapelessRecipe(new ItemStack(winged_gold_legs), new ItemStack(316,1,0), new ItemStack(avianDNA), new ItemStack(avianDNA), new ItemStack(avianDNA));
        GameRegistry.addShapelessRecipe(new ItemStack(winged_leather_boots), new ItemStack(301,1,0), new ItemStack(avianDNA), new ItemStack(avianDNA), new ItemStack(avianDNA));
        GameRegistry.addShapelessRecipe(new ItemStack(winged_chain_boots), new ItemStack(305,1,0), new ItemStack(avianDNA), new ItemStack(avianDNA), new ItemStack(avianDNA));
        GameRegistry.addShapelessRecipe(new ItemStack(winged_iron_boots), new ItemStack(309,1,0), new ItemStack(avianDNA), new ItemStack(avianDNA), new ItemStack(avianDNA));
        GameRegistry.addShapelessRecipe(new ItemStack(winged_diamond_boots), new ItemStack(313,1,0), new ItemStack(avianDNA), new ItemStack(avianDNA), new ItemStack(avianDNA));
        GameRegistry.addShapelessRecipe(new ItemStack(winged_gold_boots), new ItemStack(317,1,0), new ItemStack(avianDNA), new ItemStack(avianDNA), new ItemStack(avianDNA));
	}

	private void addNames() {
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
     // register leather in language registry
     LanguageRegistry.addName(winged_leather_helmet, "Winged Leather Helmet");
     LanguageRegistry.addName(winged_leather_chest, "Winged Leather Chest");
   	 LanguageRegistry.addName(winged_leather_legs, "Winged Leather Legs");
   	 LanguageRegistry.addName(winged_leather_boots, "Winged Leather Boots");
     //register chain in language register
     LanguageRegistry.addName(winged_chain_helmet, "Winged Chain Helmet");
     LanguageRegistry.addName(winged_chain_chest, "Winged Chain Chest");
     LanguageRegistry.addName(winged_chain_legs, "Winged Chain Legs");
     LanguageRegistry.addName(winged_chain_boots, "Winged Chain Boots");
     //register iron in language register
     LanguageRegistry.addName(winged_iron_helmet, "Winged Iron Helmet");
     LanguageRegistry.addName(winged_iron_chest, "Winged Iron Chest");
     LanguageRegistry.addName(winged_iron_legs, "Winged Iron Legs");
     LanguageRegistry.addName(winged_iron_boots, "Winged Iron Boots");		
     //register gold in language register
     LanguageRegistry.addName(winged_gold_helmet, "Winged Gold Helmet");
     LanguageRegistry.addName(winged_gold_chest, "Winged Gold Chest");
     LanguageRegistry.addName(winged_gold_legs, "Winged Gold Legs");
     LanguageRegistry.addName(winged_gold_boots, "Winged Gold Boots");		
     //register diamond in language register
     LanguageRegistry.addName(winged_diamond_helmet, "Winged Diamond Helmet");
     LanguageRegistry.addName(winged_diamond_chest, "Winged Diamond Chest");
     LanguageRegistry.addName(winged_diamond_legs, "Winged Diamond Legs");
     LanguageRegistry.addName(winged_diamond_boots, "Winged Diamond Boots");
	}

	@PostInit
    public void postInit(FMLPostInitializationEvent event) {
    	GameRegistry.registerCraftingHandler(new CraftingHandler());
    }
    public static boolean isPairOfWings(int id) {
		return (id == wings.itemID || id == winged_leather_chest.itemID || id == winged_chain_chest.itemID || id == winged_iron_chest.itemID || id == winged_gold_chest.itemID || id == winged_diamond_chest.itemID);
	}

	public static boolean isPairOfBoots(int id) {
		return(id == winged_leather_boots.itemID || id == winged_chain_boots.itemID || id == winged_iron_boots.itemID || id == winged_diamond_boots.itemID || id == winged_gold_boots.itemID);
	}

	public static boolean isPairOfPants(int id) {
		return(id == winged_leather_legs.itemID || id == winged_chain_legs.itemID || id == winged_iron_legs.itemID || id == winged_diamond_legs.itemID || id == winged_gold_legs.itemID);
	}

	public static boolean isHelmet(int id) {
		return(id == winged_leather_helmet.itemID || id == winged_chain_helmet.itemID || id == winged_iron_helmet.itemID || id == winged_diamond_helmet.itemID || id == winged_gold_helmet.itemID);
	}
}

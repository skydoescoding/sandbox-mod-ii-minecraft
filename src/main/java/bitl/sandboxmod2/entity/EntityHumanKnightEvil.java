package bitl.sandboxmod2.entity;

import bitl.sandboxmod2.SandboxMod2;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveIndoors;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.entity.ai.EntityAIRestrictOpenDoor;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class EntityHumanKnightEvil extends EntityHumanBaseEvil
{
	public int swordTypeEvil;
	public double evilKnightAttackDamage = 1.0D;
	
	public EntityHumanKnightEvil(World par1World) 
	{
		super(par1World);
		this.getNavigator().setBreakDoors(true);
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
		this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityHumanBase.class, 8.0F));
		this.tasks.addTask(5, new EntityAIWatchClosest(this, EntityVillager.class, 8.0F));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.tasks.addTask(7, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.2D, true));
		this.tasks.addTask(8, new EntityAIAttackOnCollide(this, EntityHumanBase.class, 1.2D, true));
		this.tasks.addTask(9, new EntityAIAttackOnCollide(this, EntityVillager.class, 1.2D, true));
		this.tasks.addTask(10, new EntityAIMoveIndoors(this));
        this.tasks.addTask(11, new EntityAIOpenDoor(this, true));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
		this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityHumanBase.class, 0, true));
		this.targetTasks.addTask(4, new EntityAINearestAttackableTarget(this, EntityVillager.class, 0, true));
	}
	
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0D);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(32.0D);
		this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(0.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(this.evilKnightAttackDamage);
	}
	
	public boolean isAIEnabled()
	{
		 return true;
	}
	
	protected void onHumanSpawn()
	{
		this.swordTypeEvil = 0;
		this.addArmorHuman(3);
		this.selectSword();
		this.selectSwordDamage();
		this.setHumanRandomNameEx(StatCollector.translateToLocal("humanname.humanEvilKnight"), "");
		this.setHumanArmorHealth();
	}
	
	public void selectSword()
    {
    	int swordSelector = this.rand.nextInt(7);
    	
		if (swordSelector == 1)
    	{
    		this.swordTypeEvil = 1;
    	}
		else if (swordSelector == 2)
    	{
    		this.swordTypeEvil = 2;
    	}
		else if (swordSelector == 3)
    	{
    		this.swordTypeEvil = 3;
    	}
		else if (swordSelector == 4)
    	{
    		this.swordTypeEvil = 4;
    	}
		else if (swordSelector == 5)
    	{
    		this.swordTypeEvil = 5;
    	}
		else if (swordSelector == 6)
    	{
    		this.swordTypeEvil = 6;
    	}
		else
    	{
    		this.swordTypeEvil = 0;
    	}
    	
		if (this.swordTypeEvil == 1)
    	{
    		this.setCurrentItemOrArmor(0, new ItemStack(Items.wooden_sword));
    	}
		else if (this.swordTypeEvil == 2)
    	{
    		this.setCurrentItemOrArmor(0, new ItemStack(Items.stone_sword));
    	}
    	else if (this.swordTypeEvil == 3)
    	{
    		this.setCurrentItemOrArmor(0, new ItemStack(Items.iron_sword));
    	}
    	else if (this.swordTypeEvil == 4)
    	{
    		this.setCurrentItemOrArmor(0, new ItemStack(Items.golden_sword));
    	}
    	else if (this.swordTypeEvil == 5)
    	{
    		this.setCurrentItemOrArmor(0, new ItemStack(Items.diamond_sword));
    	}
    	else if (this.swordTypeEvil == 6)
    	{
    		this.setCurrentItemOrArmor(0, new ItemStack(SandboxMod2.itemRubySword));
    	}
		else if (this.swordTypeEvil == 0)
    	{
    		this.setCurrentItemOrArmor(0, new ItemStack(Items.wooden_sword));
    	}
    }
	
	public void selectSwordDamage()
	{
		if (this.swordTypeEvil == 1)
    	{
			this.evilKnightAttackDamage = 2.0D;
    	}
		else if (this.swordTypeEvil == 2)
    	{
			this.evilKnightAttackDamage = 3.0D;
    	}
    	else if (this.swordTypeEvil == 3)
    	{
    		this.evilKnightAttackDamage = 4.0D;
    	}
    	else if (this.swordTypeEvil == 4)
    	{
    		this.evilKnightAttackDamage = 5.0D;
    	}
    	else if (this.swordTypeEvil == 5)
    	{
    		this.evilKnightAttackDamage = 6.0D;
    	}
    	else if (this.swordTypeEvil == 6)
    	{
    		this.evilKnightAttackDamage = 6.0D;
    	}
		else if (this.swordTypeEvil == 0)
    	{
			this.evilKnightAttackDamage = 2.0D;
    	}
	}
	
	/**
     * Drop 0-2 items of this living's type
     */
    protected void dropFewItems(boolean par1, int par2)
    {
    	if (this.swordTypeEvil == 1)
        {
    		this.func_145779_a(Items.wooden_sword, 1);
        }
    	else if (this.swordTypeEvil == 2)
        {
    		this.func_145779_a(Items.stone_sword, 1);
        }
    	else if (this.swordTypeEvil == 3)
        {
    		this.func_145779_a(Items.iron_sword, 1);
        }
    	else if (this.swordTypeEvil == 4)
        {
    		this.func_145779_a(Items.golden_sword, 1);
        }
    	else if (this.swordTypeEvil == 5)
        {
    		this.func_145779_a(Items.diamond_sword, 1);
        }
    	else if (this.swordTypeEvil == 6)
        {
    		this.func_145779_a(SandboxMod2.itemRubySword, 1);
        }
    	else if (this.swordTypeEvil == 0)
        {
    		this.func_145779_a(Items.wooden_sword, 1);
        }
    }
    
    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeEntityToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setShort("SwordTypeEvil", (short)this.swordTypeEvil);
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readEntityFromNBT(par1NBTTagCompound);
        this.swordTypeEvil = par1NBTTagCompound.getShort("SwordTypeEvil");
    }
}
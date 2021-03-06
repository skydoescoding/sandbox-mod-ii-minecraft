package bitl.sandboxmod2.entity;

import bitl.sandboxmod2.SandboxMod2;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveIndoors;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityGiantZombie;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.StatCollector;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityHumanArcher extends EntityHumanBase implements IRangedAttackMob
{
	public int bowType;
	public double followDistanceArcher = 1.25D;
	
	public EntityHumanArcher(World par1World) 
	{
		super(par1World);
		this.getNavigator().setBreakDoors(true);
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
		this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityEnderman.class, 8.0F));
		this.tasks.addTask(5, new EntityAIWatchClosest(this, EntityGiantZombie.class, 8.0F));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntitySilverfish.class, 8.0F));
		this.tasks.addTask(7, new EntityAIWatchClosest(this, EntitySkeleton.class, 8.0F));
		this.tasks.addTask(8, new EntityAIWatchClosest(this, EntitySpider.class, 8.0F));
		this.tasks.addTask(9, new EntityAIWatchClosest(this, EntityWitch.class, 8.0F));
		this.tasks.addTask(10, new EntityAIWatchClosest(this, EntityZombie.class, 8.0F));
		this.tasks.addTask(11, new EntityAIWatchClosest(this, EntityHumanBaseEvil.class, 8.0F));
		this.tasks.addTask(12, new EntityAIWatchClosest(this, EntityDragon.class, 8.0F));
		this.tasks.addTask(13, new EntityAIWatchClosest(this, EntitySlime.class, 8.0F));
		this.tasks.addTask(14, new EntityAIWatchClosest(this, EntityBlaze.class, 8.0F));
		this.tasks.addTask(15, new EntityAIWatchClosest(this, EntityGhast.class, 8.0F));
		this.tasks.addTask(16, new EntityAIWatchClosest(this, EntityAIGiant.class, 8.0F));
		this.tasks.addTask(17, new EntityAILookIdle(this));
		this.tasks.addTask(18, new EntityAIArrowAttack(this, 1.0D, 20, 60, 15.0F));
		this.tasks.addTask(19, new EntityAIMoveIndoors(this));
        this.tasks.addTask(20, new EntityAIOpenDoor(this, true));
        this.tasks.addTask(21, new EntityAITempt(this, followDistanceArcher, Items.wooden_sword, false));
        this.tasks.addTask(22, new EntityAITempt(this, followDistanceArcher, Items.stone_sword, false));
        this.tasks.addTask(23, new EntityAITempt(this, followDistanceArcher, Items.iron_sword, false));
        this.tasks.addTask(24, new EntityAITempt(this, followDistanceArcher, Items.golden_sword, false));
        this.tasks.addTask(25, new EntityAITempt(this, followDistanceArcher, Items.diamond_sword, false));
        this.tasks.addTask(26, new EntityAITempt(this, followDistanceArcher, SandboxMod2.itemRubySword, false));
        this.tasks.addTask(27, new EntityAITempt(this, followDistanceArcher, Items.bow, false));
        this.tasks.addTask(28, new EntityAITempt(this, followDistanceArcher, SandboxMod2.itemRubyBow, false));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityBlaze.class, 0, true));
		this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityEnderman.class, 0, true));
		this.targetTasks.addTask(4, new EntityAINearestAttackableTarget(this, EntityGhast.class, 0, true));
		this.targetTasks.addTask(5, new EntityAINearestAttackableTarget(this, EntityGiantZombie.class, 0, true));
		this.targetTasks.addTask(6, new EntityAINearestAttackableTarget(this, EntitySilverfish.class, 0, true));
		this.targetTasks.addTask(7, new EntityAINearestAttackableTarget(this, EntitySkeleton.class, 0, true));
		this.targetTasks.addTask(8, new EntityAINearestAttackableTarget(this, EntitySpider.class, 0, true));
		this.targetTasks.addTask(9, new EntityAINearestAttackableTarget(this, EntityWitch.class, 0, true));
		this.targetTasks.addTask(10, new EntityAINearestAttackableTarget(this, EntityZombie.class, 0, true));
		this.targetTasks.addTask(11, new EntityAINearestAttackableTarget(this, EntityHumanBaseEvil.class, 0, true));
		this.targetTasks.addTask(12, new EntityAINearestAttackableTarget(this, EntitySlime.class, 0, true));
		this.targetTasks.addTask(13, new EntityAINearestAttackableTarget(this, EntityDragon.class, 0, true));
		this.targetTasks.addTask(14, new EntityAINearestAttackableTarget(this, EntityAIGiant.class, 0, true));
	}
	
	protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0D);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(32.0D);
		this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(0.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(3.0D);
    }
	
	public boolean isAIEnabled()
	{
		 return true;
	}
	
	protected void onHumanSpawn()
	{
		this.bowType = 0;
		this.addArmorHuman(3);
		this.selectBow();
		this.setHumanRandomNameEx(StatCollector.translateToLocal("humanname.humanArcher"), "");
		this.setHumanArmorHealth();
	}

	/**
     * Attack the specified entity using a ranged attack.
     */
    public void attackEntityWithRangedAttack(EntityLivingBase par1EntityLivingBase, float par2)
    {
        EntityArrow var3 = new EntityArrow(this.worldObj, this, par1EntityLivingBase, 1.6F, 4);
        if (this.bowType == 1)
        {
        	var3.setDamage(3.5D);
        }
        else
        {
        	var3.setDamage(2.0D);
        }

        this.playSound("random.bow", 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
        this.worldObj.spawnEntityInWorld(var3);
    }
    
    public void selectBow()
    {
    	int bowSelector = this.rand.nextInt(2);
    	
		if (bowSelector == 1)
    	{
    		this.bowType = 1;
    	}
    	else
    	{
    		this.bowType = 0;
    	}
    	
    	if (this.bowType == 1)
    	{
    		this.setCurrentItemOrArmor(0, new ItemStack(SandboxMod2.itemRubyBow));
    	}
    	else
    	{
    		this.setCurrentItemOrArmor(0, new ItemStack(Items.bow));
    	}
    }
    
    /**
     * Drop 0-2 items of this living's type
     */
    protected void dropFewItems(boolean par1, int par2)
    {
        if (this.bowType == 1)
        {
        	this.func_145779_a(SandboxMod2.itemRubyBow, 1);
        }
        else
        {
        	this.func_145779_a(Items.bow, 1);
        }
    }
    
    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeEntityToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setShort("BowType", (short)this.bowType);
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readEntityFromNBT(par1NBTTagCompound);
        this.bowType = par1NBTTagCompound.getShort("BowType");
    }
}

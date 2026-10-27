package connors.pigeons.entity.custom;


import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.behavior.BehaviorUtils;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import org.jspecify.annotations.Nullable;


public class MaxEntity extends TamableAnimal {
    public final AnimationState idleAnimationState =  new AnimationState();
    private int idleAnimationTimeout = 0;
    public MaxEntity(EntityType<? extends TamableAnimal> Entitytype, Level world){
        super(Entitytype, world);
        this.getNavigation().setCanOpenDoors(true);
    }

    public static AttributeSupplier.Builder createMobAttributes() {
        return Animal.createAnimalAttributes()
                .add(Attributes.MOVEMENT_SPEED, 0.3F)
                .add(Attributes.MAX_HEALTH, 7.0F)
                .add(Attributes.TEMPT_RANGE, 16d)
                .add(Attributes.FOLLOW_RANGE, 24D);
    }
    @Override
    protected void registerGoals(){
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 2f));
        this.goalSelector.addGoal(2, new TemptGoal(this, 1.2f, stack -> stack.is(Items.PAPER), false));
        this.goalSelector.addGoal(3, new WaterAvoidingRandomStrollGoal(this, 1f));
        this.goalSelector.addGoal(4, new LookAtPlayerGoal(this, Player.class, 6f));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));

    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack interactionItem = player.getItemInHand(hand);
        ItemStack itemInHand = this.getItemInHand(InteractionHand.MAIN_HAND);
        //allay mobinteract code
        if (itemInHand.isEmpty() && !interactionItem.isEmpty()) {
            ItemStack itemToGive = interactionItem.copyWithCount(1);
            this.setItemInHand(
                    InteractionHand.MAIN_HAND,
                    itemToGive);
            this.removeInteractionItem(player, interactionItem);
            return InteractionResult.SUCCESS;
        }
        //copper golem mobinteract code
        else if ((interactionItem.isEmpty())) {
            ItemStack equippedItem = this.getMainHandItem();
            if (!equippedItem.isEmpty()) {
                BehaviorUtils.throwItem(this, equippedItem, player.position());
                this.setItemInHand(InteractionHand.MAIN_HAND, ItemStack.EMPTY);
                return InteractionResult.SUCCESS;

            }
        }
        return super.mobInteract(player, hand);
    }
    private void removeInteractionItem(final Player player, final ItemStack interactionItem) {
        interactionItem.consume(1, player);
    }



    private void setupAnimationStates(){
        if(this.idleAnimationTimeout <= 0){
            this.idleAnimationTimeout = 20;
            this.idleAnimationState.start(this.tickCount);
        }else{
            --this.idleAnimationTimeout;
        }
    }
    @Override
    public void tick(){
        super.tick();
        if(this.level().isClientSide()){
            this.setupAnimationStates();
        }
    }


    @Override
    public boolean isFood(ItemStack itemStack) {
        return false;
    }

    @Override
    public @Nullable AgeableMob getBreedOffspring(ServerLevel level, AgeableMob partner) {
        return null;
    }
    @Override
    protected void pushEntities() {
    }
}

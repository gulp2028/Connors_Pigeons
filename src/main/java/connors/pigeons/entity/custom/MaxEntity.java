package connors.pigeons.entity.custom;

import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.Level;

public class MaxEntity extends PathfinderMob {
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout= 0;

    public MaxEntity(EntityType<? extends PathfinderMob> type, Level level) {
        super(type, level);
    }
    private void setupAnimationStates(){
        if(this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = 40;
            this.idleAnimationState.start(this.tickCount);
        }else{
            --this.idleAnimationTimeout;
        }
    }
    @Override
    public void tick(){
        super.tick();
        if(this.level().isClientSide()) {
            this.setupAnimationStates();
        }
    }
    public static AttributeSupplier.Builder createAttributes(){
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 10d)
                .add(Attributes.MOVEMENT_SPEED, 0.5d)
                .add(Attributes.TEMPT_RANGE,16d)
                .add(Attributes.FOLLOW_RANGE, 24d);


    }
}

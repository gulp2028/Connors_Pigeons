package connors.pigeons.entity.custom;

import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.level.Level;

public class MaxEntity extends PathfinderMob {
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimout= 0;

    public MaxEntity(EntityType<? extends PathfinderMob> type, Level level) {
        super(type, level);
    }
    private void setupAnimationStates(){
        if
    }
}

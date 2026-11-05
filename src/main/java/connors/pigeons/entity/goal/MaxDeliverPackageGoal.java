package connors.pigeons.entity.goal;

import net.minecraft.world.entity.ai.goal.Goal;

public class MaxDeliverPackageGoal extends Goal {
    @Override
    public boolean canUse() {
        return false;
    }
}

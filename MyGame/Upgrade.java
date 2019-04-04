import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Upgrade here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Upgrade extends Actor
{
    /**
     * Act - do whatever the Upgrade wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private static int reduceReload = 3;
    public void act() 
    {
        checkIfTouchedBy();
    }   
    private void checkIfTouchedBy()
    {
        if (isTouching(MyTank.class))
        {
            // Gets an object reference to the world
            MyWorld world = (MyWorld) getWorld();
            if (MyTank.returnReloadTime() > 0)
            {
            world.getMyTank().changeReloadTime(this.reduceReload);
            }
            //get removed
            //this.isRemoved = true;
            getWorld().removeObject(this);
            
           
        }
    }
   
    
}

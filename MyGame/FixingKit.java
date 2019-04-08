import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FixingKit here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FixingKit extends Actor
{
    /**
     * Act - do whatever the FixingKit wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    static int addLife = 2;
    int frames = 0;
    //private boolean isRemoved = false;
    public void act() 
    {
       checkIfTouchedBy();
       frames ++;
    }   
    private void checkIfTouchedBy()
    {
        if (isTouching(MyTank.class))
        {
            // Gets an object reference to the world
            MyWorld world = (MyWorld) getWorld();
            
            world.getMyTank().changeLifeLevel(this.addLife);
            
            
            //get removed
            //this.isRemoved = true;
            getWorld().removeObject(this);
            
           
        }
    }
    
}

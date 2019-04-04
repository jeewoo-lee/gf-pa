import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Upgrade here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mine extends Actor
{
    /**
     * Act - do whatever the Upgrade wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    int frames = 0;
    public void act() 
    {
        checkIfTouchedBy();
    }   
     private void checkIfTouchedBy()
     {
        if (isTouching(EnemyTank.class))
        {
            // Gets an object reference to the world
            MyWorld world = (MyWorld) getWorld();
            
            
            
            
            //get removed
            //this.isRemoved = true;
            getWorld().removeObject(this);
            
           
        }
    }
 }
   
    



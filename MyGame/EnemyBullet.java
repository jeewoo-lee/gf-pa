import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemyBullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class EnemyBullet extends Actor
{
    /**
     * Act - do whatever the EnemyBullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    boolean isRemoved = false;
    /**
     * Constructor for EnemyBullet class
     */
    EnemyBullet(int rotation)
    {
        setRotation(rotation);
    }
    
    public void act() 
    {
        
        move(5);
        if (isRemoved == false)
        {
            checkIfTouchedBy();
        }
        if(isRemoved == false)
        {
            checkIfAtEdge();
        }
    }  
    
    private void checkIfTouchedBy()
    {
        if (isTouching(MyTank.class))
        {
            // Gets an object reference to the world
            MyWorld world = (MyWorld) getWorld();
            
            //get removed
            this.isRemoved = true;
            getWorld().removeObject(this);
            
           
        }
    }
    private void checkIfAtEdge()
    {
        if (isAtEdge())
        {
            MyWorld world = (MyWorld) getWorld();
           
            //get removed
            this.isRemoved = true;
            getWorld().removeObject(this);
        }
    
    }
    
}

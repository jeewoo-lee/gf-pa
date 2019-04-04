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
    private static int reduceLife = -5;
    
    /**
     * Constructor for EnemyBullet class
     */
    EnemyBullet(int rotation)
    {
        setRotation(rotation);
    }
    
    public void act() 
    {
        // Add your action code here.
        move(2);
    }  
    
    public void checkIfTouchedBy()
    {
        if (isTouching(MyTank.class))
        {
            // Gets an object reference to the world
            MyWorld world = (MyWorld) getWorld();
            if (MyTank.returnLife() < 20)
            {
            world.getMyTank().changeLifeLevel(this.reduceLife);
            }
            //get removed
            
            getWorld().removeObject(this);
            
           
        }
    }
    
}

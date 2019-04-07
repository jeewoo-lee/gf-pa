  import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Bullet extends Actor
{
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private static int reduceLife = -5;
    boolean isRemoved = false;
    /**
     * Constructor for Bullet class
     */
    Bullet(int rotation)
    {
        setRotation(rotation);
    }

    public void act() 
    {
        // Add your action code here.
        move(10);
        
        if (isRemoved == false) 
        {
            checkIfTouchedBy();
        }
        if (isRemoved == false)
        {
            checkIfAtEdge();
        }
    }  

    public void checkIfTouchedBy()
    {
        
        if (isTouching(EnemyTank.class))
        {
            // Gets an object reference to the world
            MyWorld world = (MyWorld) getWorld();
           
            //get removed
            this.isRemoved = true;
            getWorld().removeObject(this);

        }
        else if (isTouching(EnemyTank2.class))
        {
            // Gets an object reference to the world
            MyWorld world = (MyWorld) getWorld();
           
            //get removed
            this.isRemoved = true;
            getWorld().removeObject(this);

        }
        else if (isTouching(EnemyTank3.class))
        {
            // Gets an object reference to the world
            MyWorld world = (MyWorld) getWorld();
           
            //get removed
            this.isRemoved = true;
            getWorld().removeObject(this);

        }
     
    }
    public void checkIfAtEdge()
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

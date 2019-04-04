import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyTank here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyTank extends Actor
{
    /**
     * Act - do whatever the MyTank wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int frames = 60;
    private static int life = 20;
    // private static int reloadTime = 5;
    // private static int reloadWaitTime = 0;
    
    public void act() 
    {
        movement();
        frames++;
        fire();
        String life1 = Integer.toString(life);
        getWorld().showText("Life:",25,20);
        getWorld().showText(life1, 70, 20);
        
    } 

    private void movement()
    {
        if (Greenfoot.isKeyDown("left")) 
        {
            setRotation(getRotation() - 3);
        }

        if (Greenfoot.isKeyDown("right")) 
        {
            setRotation(getRotation() + 3);
        }

        if (Greenfoot.isKeyDown("up")) 
        {
            move(3);
        }

        if (Greenfoot.isKeyDown("down")) 
        {
            move(-3);
        }
    }

    public void changeLifeLevel(int by)
    {
        this.life = this.life + by;

    } 

    // public void changeReloadTime(int by)
    // {
        // this.reloadTime = this.reloadTime - by;
    // }

    public static int returnLife()
    {
        return life;
    }

    // public static int returnReloadTime()
    // {
        // return reloadTime;
    // }

    private void fire()
    {
        if(Greenfoot.isKeyDown("space"))
        {
            if (frames > 1) 
            {
                Bullet newBullet = new Bullet(getRotation());
                getWorld().addObject(newBullet, getX(), getY());
                frames = 0;
            }     
        }
    }

    private void checkIfDamaged()
    {

        if (life == 0)
        {
            getWorld().showText("Game Over!",500,400);
            Greenfoot.stop();
        }

    }
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemyTank here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyTank extends Actor
{
    /**
     * Act - do whatever the EnemyTank wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int frames = 0;
    private static int life = 5;
    private static int reloadTime = 7;
    boolean isRemoved;
    public EnemyTank()
    {
        isRemoved = false;
    }

    public void act() 
    {
        // Add your action code here.
        movement();
        checkIfDamaged();
        if (isRemoved == false) 
        {
            checkIfTimeToUpgrade();
            checkForRemoval();
            
        }
        frames ++;
    } 

    private void movement()
    {
        int selection = Greenfoot.getRandomNumber(6);

        if (selection == 1) 
        {
            setRotation(getRotation() - 3);
        }
        else if (selection == 2) 
        {
            setRotation(getRotation() + 3);
        }
        else if (selection == 3) 
        {
            move(10);
        }
        else if (selection == 4) 
        {
            move(5);
        }
        else
        {
            move(5);
        }

        if (isAtEdge())
        {
            MyWorld world = (MyWorld) getWorld();
            move(-5);
            setRotation(getRotation()+90);
        }

    }

    public void changeLifeLevel(int by)
    {
        this.life = this.life + by;

    } 

    public static int returnLife()
    {
        return life;
    }

    private void checkIfTimeToUpgrade()
    {
        MyWorld world = (MyWorld) getWorld();
        if (world.score() > 9)
        {
            life = 7;
            reloadTime = 6;

        }
        else if (world.score() > 19)
        {
            life = 9;
            reloadTime = 5;

        }
        else if (world.score() > 29)
        {
            life = 10;
            reloadTime = 4;
        }
    }

    private void checkIfDamaged()
    {
        if (isTouching(Bullet.class))
        {
            life --;
        }

        
    }

    private void checkForRemoval()
    {
        if (life == 0)
        {
            MyWorld world = (MyWorld) getWorld();
            world.addScore();
            this.isRemoved = true;
            world.removeObject(this);

        }
    }

}

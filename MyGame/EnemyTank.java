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
    private int reload = 0;
    private int life = 5;
    private int reloadTime = 7;
    private int frames = 0;
    boolean isRemoved;
    public EnemyTank()
    {
        isRemoved = false;
        
    }

    public void act() 
    {
        // Add your action code here.
        movement();
        fire();
        checkIfDamaged();
        if (!isRemoved) 
        {
            checkForRemoval();           
        }
        reload ++;
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

    public int returnLife()
    {
        return life;
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
            Explosion newExplosion = new Explosion();
            getWorld().addObject(newExplosion, getX(), getY());
            getWorld().removeObject(this);

        }
        else if (isTouching(Mine.class))
        {
            MyWorld world = (MyWorld) getWorld();
            world.addScore();
            this.isRemoved = true;
            Explosion newExplosion = new Explosion();
            getWorld().addObject(newExplosion, getX(), getY());
            getWorld().removeObject(this);

        }
    }
    private void fire()
    {
       // if (frames % 30 == 0) 
        //{
                if (reload == 30)
                {
                EnemyBullet newEnemyBullet = new EnemyBullet(getRotation());
                getWorld().addObject(newEnemyBullet, getX(), getY());
                reload = 0;
                }
        // }     
    }
}

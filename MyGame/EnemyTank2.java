import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemyTank2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyTank2 extends Actor
{
    /**
     * Act - do whatever the EnemyTank2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int reload = 0;
    private int life = 7;
    boolean isRemoved;
    public EnemyTank2()
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
        if (isTouching(Mine.class))
        {
             life = life - 2;
            
        }
        
        
    }

    private void checkForRemoval()
    {
        if (life < 1)
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
       
        if (reload == 20)
        {
            EnemyBullet newEnemyBullet = new EnemyBullet(getRotation());
            double x = Math.cos(getRotation()*Math.PI/180) * 34;
            double y = Math.sin(getRotation()*Math.PI/180) * 34;
            
            getWorld().addObject(newEnemyBullet, getX()+(int)Math.round(x), getY()+(int)Math.round(y));
            reload = 0;
        }
           
    }
}

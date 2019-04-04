import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    private static int frames = 0;
    private MyTank myTank;
    private int score = 0;
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 800, 1); 
        myTank = new MyTank();
        this.addObject(myTank,600,400);
        
    }
    public void act()
    {
        time();
        dropEnemyTank();
        dropSupply();
        frames = frames +1;
    }
    private void time()
    {
        // Every 60 frames, update the time
        if ((frames % 60) == 0)
        {
            String timeElapsed = Integer.toString(frames / 60);
            showText("Time:",1100,20);
            showText(timeElapsed, 1150, 20);
            
        }
    }
    public void started()
    {
        frames = 0;
    }
    public MyTank getMyTank()
    {
        return myTank;
    }
    private void dropSupply()
    {
        if (frames % 120 == 0)
        {
            int selection = Greenfoot.getRandomNumber(10);
            if (selection == 1)
            {
                addObject(new FixingKit(),Greenfoot.getRandomNumber(1200),Greenfoot.getRandomNumber(800));
            }
            if (selection == 2)
            {
                addObject(new Upgrade(),Greenfoot.getRandomNumber(1200),Greenfoot.getRandomNumber(800));
            }
        }
    }
    private void dropEnemyTank()
    {
        if (frames % 120 == 0)
        {
            addObject(new EnemyTank(), Greenfoot.getRandomNumber(1200), Greenfoot.getRandomNumber(800));
        }
    }
    void addScore()
    {
        score ++;
        String a = Integer.toString(score);
        showText(a,130,20);
        showText("Score is",70, 20);
      
    }
    int score()
    {
        return score;
    }
    
    
}

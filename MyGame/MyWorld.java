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
        private int frames = 0;
        private MyTank myTank;
        private EnemyTank enemy;
        private Mine mine;
        public int score = 0;
        public MyWorld()
        {    
            // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
            super(1200, 800, 1); 
            myTank = new MyTank();
            this.addObject(myTank,600,400);
            
        }
    
        public void act()
        {
            sound();
            time();
            dropEnemyTank();
            dropSupply();
            frames = frames +1;
            checkIfEnd();
            
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
            score = 0;
        }
    
        public MyTank getMyTank()
        {
            return myTank;
        }
        public Mine getMine()
        {
            return mine;
        }
    
        public EnemyTank getEnemyTank()
        {
            return enemy;
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
                    addObject(new Mine(),Greenfoot.getRandomNumber(1200),Greenfoot.getRandomNumber(800));
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
            showText(a,180,20);
            showText("Score is",130, 20);
    
        }
        private void checkIfEnd()
        {
            if (score ==50)
            {
                String a = Integer.toString(frames / 60);
                showText("YOU WON",580,400);
                showText("Your time is",580, 430);
                showText(a, 680, 430);
                Greenfoot.stop();
            }
        }
        int score()
        {
            return score;
        }
        private void sound()
        {
            if (frames == 0)
            {
               Greenfoot.playSound("engine.wav");
            }
        }

}

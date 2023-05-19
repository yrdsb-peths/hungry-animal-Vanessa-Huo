import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * World where animals live in.
 * 
 * @author (Vanessa) 
 * @version (May 2023)
 */
public class MyWorld extends World
{
    public int score = 0;
    Label scoreLabel;
    Label scoring;
    int level = 1;
    GreenfootImage bcImage = new GreenfootImage("images/Bc.jpeg");
    
    LifePoints heart0;
    LifePoints heart1;
    LifePoints heart2;
        
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1,false);
        //Create a Octopus
        Octopus octopus = new Octopus();
        addObject(octopus, 300, 320);
        
        //Create a life points
        createLifePoints();
        
        //Create a Fish
        createFish();
        
        //Create a Garbage
        createGarbage(); 

        //Create score label
        scoring = new Label("Score: ",30);
        addObject(scoring,50,20);
        scoreLabel = new Label(0,30);
        addObject(scoreLabel,100,20);
        
        bcImage.scale(700,400);
        setBackground(bcImage);
    }
    
    //End the game and draw "game over"
    public void gameOver(){
        Label gameOverLabel = new Label("Game Over", 100);
        addObject(gameOverLabel,300,200);
    }
    
    //Increase score
    public void increaseScore()
    {
        score++;
        scoreLabel.setValue(score);
        
        if(score%5==0)
        {
            level += 1;
        }
    }
    
    //Create new fish at random location at the top of the screen 
    public void createFish()
    {
        Fish fish = new Fish();
        fish.setSpeed(level);
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(fish, x, y);
    }
    
    int count = 0;
    //Remove one Lifepoint when missed a fish
    //Called "game over" when no more Lifepoint left
    public void removeLP()
    {
        if(count==0)
        {
            removeObject(heart0);
            count++;
        }
        else if(count==1)
        {
            removeObject(heart1);
            count++;
        }
        else
        {
            removeObject(heart2);
            count++;
            gameOver();
        }
    }
    
    public int getCount(){
        return count;
    }
    
    public void createGarbage()
    {
        //50% change of generating an garbage
        if(0 == Greenfoot.getRandomNumber(2)){
            Garbage garbage = new Garbage();
            int x = Greenfoot.getRandomNumber(600);
            int y = 0;
            addObject(garbage, x, y);
        }
    }
    
    public void createLifePoints()
    {
        heart2 = new LifePoints();
        heart1 = new LifePoints(); 
        heart0 = new LifePoints(); 
        addObject(heart2, 580, 20);
        addObject(heart1, 550, 20);
        addObject(heart0, 520, 20);
    }
}

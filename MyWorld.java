import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * World where animals live in.
 * 
 * @author (Vanessa) 
 * @version (May 2023)
 */
public class MyWorld extends World
{
    GreenfootImage bcImage = new GreenfootImage("images/Bc.jpeg");
    GreenfootSound gameOverSound = new GreenfootSound("gameover.mp3");
    GreenfootSound reduceLP = new GreenfootSound("lp-1.mp3");
    
    public int score = 0;
    Label scoreLabel;
    Label scoring;
    
    LifePoints heart0;
    LifePoints heart1;
    LifePoints heart2;
    
    int level = 1;
    int spawnTimer;
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

        //Create score label
        scoring = new Label("Score: ",30);
        addObject(scoring,50,20);
        scoreLabel = new Label(0,30);
        addObject(scoreLabel,100,20);
        
        //Set background images
        bcImage.scale(700,400);
        setBackground(bcImage);
    }
    
    public void act(){
        createGarbage();
    }
    
    //End the game and draw "game over"
    public void gameOver(){
        Label gameOverLabel = new Label("Game Over", 100);
        addObject(gameOverLabel,300,200);
        gameOverSound.setVolume(50);
        gameOverSound.play();
    }
    
    //Increase score
    public void increaseScore()
    {
        score++;
        scoreLabel.setValue(score);
        
        //Difficulty increases for every 5 fish eaten 
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
    
    /**
     * Remove one LifePoints when missed a fish
     * Called "game over" when no more LifePoints left
     */
    int count = 0;
    public void removeLP()
    {
        if(count==0)
        {
            removeObject(heart0);
            reduceLP.setVolume(50);
            reduceLP.play();
            count++;
        }
        else if(count==1)
        {
            removeObject(heart1);
            reduceLP.setVolume(50);
            reduceLP.play();
            count++;
        }
        else
        {
            removeObject(heart2);
            count++;
            gameOver();
        }
    }
    
    //Get number of LifePoints/hearts left 
    public int getCount(){
        return count;
    }
    
    //For every 5 second there's 50% change of generating an garbage
    public void createGarbage()
    {
        if(++spawnTimer%300 == 0){
            if(0 == Greenfoot.getRandomNumber(2)){
                Garbage garbage = new Garbage();
                int x = Greenfoot.getRandomNumber(600);
                int y = 0;
                addObject(garbage, x, y);
            }
            //Reset spawnTimer
            spawnTimer=0;
        }
    }
    
    //Create three LifePoints/hearts on the upper-right corner of the screen
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

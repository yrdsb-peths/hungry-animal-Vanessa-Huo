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
    GreenfootImage bcImage = new GreenfootImage("images/Bc.jpeg");
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
        addObject(octopus, 300, 300);
        //Create a apple
        createApple();
        
        //Create label
        scoreLabel = new Label(0,70);
        addObject(scoreLabel,50,50);
        
        bcImage.scale(700,400);
        setBackground(bcImage);
    }
    
    public void gameOver(){
        Label gameOverLabel = new Label("Game Over", 100);
        addObject(gameOverLabel,300,200);
    }
    
    public void increaseScore()
    {
        score++;
        scoreLabel.setValue(score);
    }
    
    public void createApple()
    {
        Apple apple = new Apple();
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(apple, x, y);
    }

}

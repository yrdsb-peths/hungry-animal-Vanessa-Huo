import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * LifePoints system, octopus only has three LifePoints.
 * GameOver when LifePoints becomes zero.
 * Eating garbage and/or missing a fish can reduce LifePoints.
 * @author (Vanessa) 
 * @version (May 2023)
 */
public class LifePoints extends Actor
{
    /**
     * Act - do whatever the LifePoints wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage lp = new GreenfootImage("images/lp.png");
    
    //Create LifePoints
    public LifePoints(){
        setImage(lp);
        lp.scale(30,30);
    }
    
}

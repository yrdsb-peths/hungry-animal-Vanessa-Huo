import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LifePoints here.
 * removeLP
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LifePoints extends Actor
{
    /**
     * Act - do whatever the LifePoints wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage lp =new GreenfootImage("images/lp.png");
    
    public void act()
    {
        // Add your action code here.

    }
    
    public LifePoints(){
        setImage(lp);
        lp.scale(30,30);
    }
    
}

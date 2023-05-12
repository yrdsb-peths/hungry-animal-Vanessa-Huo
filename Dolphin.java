import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Dolphin, the animal.
 * 
 * @author (Vanessa) 
 * @version (May 2023)
 */
public class Dolphin extends Actor
{
    
    GreenfootImage[]tile=new GreenfootImage[6];
    
    public Dolphin()
    {
        for(int i=0;i<tile.length;i++)
        {
            tile[i]=new GreenfootImage("images/octopus/tile00"+i+".png");
        }
        setImage(tile[0]);
    }
    
    
    /**
     * Act - do whatever the Dolphin wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void act()
    {
        if(Greenfoot.isKeyDown("left"))
        {
            move(-1);
        }
        else if(Greenfoot.isKeyDown("right"))
        {
            move(1);
        }
        
        eat();
    }
    
    public void eat()
    {
        if(isTouching(Apple.class))
        {
            removeTouching(Apple.class);
            MyWorld world = (MyWorld)getWorld();
            world.createApple();
            world.increaseScore();
        }
    }
}

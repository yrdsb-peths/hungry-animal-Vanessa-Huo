import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Garbage, the contaminated waste that gets dumped into the ocean.
 * Reduce LifePoints if gets eaten by marine life (octopus).
 * 
 * @author (Vanessa) 
 * @version (May 2023)
 */
public class Garbage extends Actor
{
    /**
     * Act - do whatever the Garbage wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage garbage = new GreenfootImage("images/garbage.png");
    
    int garbageSpeed = 1;
    public void act()
    {
        // Add your action code here.
        
        setLocation(getX(),getY()+garbageSpeed);
        MyWorld world = (MyWorld)getWorld();
        
        if(getY()>=world.getHeight())
        {
            world.removeObject(this);
        }
    }
    
    public Garbage(){
        setImage(garbage);
        garbage.scale(40,35);
    }
}

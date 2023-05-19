import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Garbage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
            world.createGarbage();
        }
    }
    
    public Garbage(){
        setImage(garbage);
        garbage.scale(40,35);
    }
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Fish for octopus.
 * 
 * @author (Vanessa) 
 * @version (May 2023)
 */
public class Fish extends Actor
{
    /**
     * Act - do whatever the Fish wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int speed = 1;
    GreenfootImage[]idleFish=new GreenfootImage[2];
    SimpleTimer animationTimer = new SimpleTimer();
    
    public Fish(){
        for(int i=0;i<idleFish.length;i++)
        {
            idleFish[i]=new GreenfootImage("images/fish/0"+i+".png");
            idleFish[i].scale(30,20);
        }
        
        //Reset the timer
        animationTimer.mark();
        
        //Initial octopus image
        setImage(idleFish[0]);
    }
    
    public void act()
    {
        //Fish fall downwards
        setLocation(getX(),getY()+speed);
        
        MyWorld world = (MyWorld)getWorld();
        if(getY()>=world.getHeight())
        {
            world.gameOver();
            world.removeObject(this);
        }
        
        
        //Animate the octopus 
        animateFish();
    }
    
    int imageIndex=0;
    public void animateFish()
    {
        if(animationTimer.millisElapsed()<200)
        {
            return;
        }
        animationTimer.mark();
        
        setImage(idleFish[imageIndex]);
        imageIndex=(imageIndex + 1) % idleFish.length;
    }
    
    public void setSpeed(int spd)
    {
        speed = spd;
    }
}

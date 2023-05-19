import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Octopus, the animal.
 * 
 * @author (Vanessa) 
 * @version (May 2023)
 */
public class Octopus extends Actor
{
    
    GreenfootImage[]idleRight=new GreenfootImage[6];
    GreenfootImage[]idleLeft=new GreenfootImage[6];
    SimpleTimer animationTimer = new SimpleTimer();
    //Direction the octopus is facing 
    String facing = "right";
    
    public Octopus()
    {
        //Load octopus images
        for(int i=0;i<idleRight.length;i++)
        {
            idleRight[i]=new GreenfootImage("images/octopus/tile00"+i+".png");
            idleRight[i].scale(100,100);
        }
        
        for(int i=0;i<idleLeft.length;i++)
        {
            idleLeft[i]=new GreenfootImage("images/octopus/tile00"+i+".png");
            idleLeft[i].mirrorHorizontally();
            idleLeft[i].scale(100,100);
        }
        
        //Reset the timer
        animationTimer.mark();
        
        //Initial octopus image
        setImage(idleRight[0]);
        
    }
    
    int imageIndex=0;
    public void animateOctopus()
    {
        if(animationTimer.millisElapsed()<200)
        {
            return;
        }
        animationTimer.mark();
        
        if(facing.equals("right"))
        {
            setImage(idleRight[imageIndex]);
            imageIndex=(imageIndex + 1) % idleRight.length;
        }
        else
        {
            setImage(idleLeft[imageIndex]);
            imageIndex=(imageIndex + 1) % idleLeft.length;
        }
    }
    
    /**
     * Act - do whatever the Octopus wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void act()
    {
        if(Greenfoot.isKeyDown("left"))
        {
            move(-2);
            facing = "left";
        }
        else if(Greenfoot.isKeyDown("right"))
        {
            move(2);
            facing = "right";
        }
        
        //Remove fish if octopus eats it
        eat();
        
        //Eat garbage 
        eatGarbage();
        
        //Animate the octopus 
        animateOctopus();
    }
    
    //Eat the fish and spawn new fish if an fish is eaten 
    int notTouching = 3;
    public void eat()
    {
        if(isTouching(Fish.class))
        {
            MyWorld world = (MyWorld)getWorld();
            removeTouching(Fish.class);
            world.createFish();
            world.increaseScore();
        }
    }
    
    public void eatGarbage(){
        if(isTouching(Garbage.class))
        {
            MyWorld world = (MyWorld)getWorld();
            removeTouching(Garbage.class);
            world.removeLP();
            if(world.getCount()<3){
                world.createGarbage();
            }
        }
    }
}

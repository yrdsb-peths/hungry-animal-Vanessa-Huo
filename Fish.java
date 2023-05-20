import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Fish for the octopus.
 * There are three kinds of fish with different speed.
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
    GreenfootImage[]idleFish1=new GreenfootImage[2];
    GreenfootImage[]idleFish2=new GreenfootImage[2];
    GreenfootImage[]idleFish3=new GreenfootImage[2];
    SimpleTimer animationTimer = new SimpleTimer();
    
    public Fish(){
        
        //Change a type of fish when speed changes
        for(int i=0;i<idleFish1.length;i++)
        {
            idleFish1[i]=new GreenfootImage("images/fish/0"+i+".png");
            idleFish1[i].scale(35,25);
        }
        
        for(int i=0;i<idleFish2.length;i++)
        {
            idleFish2[i]=new GreenfootImage("images/fish/1"+i+".png");
            idleFish2[i].scale(35,25);
        }
        
        for(int i=0;i<idleFish3.length;i++)
        {
            idleFish3[i]=new GreenfootImage("images/fish/2"+i+".png");
            idleFish3[i].scale(40,25);
        }
        
        //Reset the timer
        animationTimer.mark();
        
        //Initial octopus image
        setImage(idleFish1[0]);
        

    }
    
    public void act()
    {
        //Fish fall downwards
        setLocation(getX(),getY()+speed);
        
        //Reduce one LifePoint if a fish is missed
        MyWorld world = (MyWorld)getWorld();
        if(getY()>=world.getHeight())
        {
            world.removeLP();
            world.removeObject(this);
            //Respawn one fish
            if(world.getCount()<3){
                world.createFish();
            }
        }
        
        //Animate the fish 
        animateFish();
    }
    
    /**
     * Animate the fish
     */
    int imageIndex=0;
    public void animateFish()
    {
        if(animationTimer.millisElapsed()<200)
        {
            return;
        }
        animationTimer.mark();
        
        if(speed==1){
            setImage(idleFish1[imageIndex]);
            imageIndex=(imageIndex + 1) % idleFish1.length;
        }
        else if(speed==2){
            setImage(idleFish2[imageIndex]);
            imageIndex=(imageIndex + 1) % idleFish2.length;
        }
        else{
            setImage(idleFish3[imageIndex]);
            imageIndex=(imageIndex + 1) % idleFish3.length;
        }
    }
    
    public void setSpeed(int spd)
    {
        speed = spd;
    }
}

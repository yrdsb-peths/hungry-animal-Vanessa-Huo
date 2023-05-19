import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class NewGame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NewGame extends Actor
{
    /**
     * Act - do whatever the NewGame wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage start = new GreenfootImage("images/new.png");
    GreenfootImage move = new GreenfootImage("images/change.png");
    
    public void act()
    {
        //if the mouse has been moved on the "New Game", change color
        if(Greenfoot.mouseMoved(this)){
            move.scale(225,45);
            setImage(move);
        }
        else{
            setImage(start);
        }
        //if the mouse has been clicked on the "New Game", change world
        if(Greenfoot.mouseClicked(this))
        {
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
        }
    }
    
    public NewGame(){
        start.scale(225,45);
        setImage(start);
    }
    
}

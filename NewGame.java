import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The words "New Game" on the title screen.
 * Click to start a new game.
 * 
 * @author (Vanessa) 
 * @version (May 2023)
 */
public class NewGame extends Actor
{
    /**
     * Act - do whatever the NewGame wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    //Initial "New Game" image
    GreenfootImage start = new GreenfootImage("images/new.png");
    //New image when the mouse has been moved onto the words
    GreenfootImage move = new GreenfootImage("images/change.png");
    
    public void act()
    {
        //If the mouse has been moved on the "New Game", change color
        if(Greenfoot.mouseMoved(this)){
            move.scale(225,45);
            setImage(move);
        }
        //Change to initial image when the mouse is not on the words
        else{
            setImage(start);
        }
        //If the mouse has been clicked on the "New Game", change world
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

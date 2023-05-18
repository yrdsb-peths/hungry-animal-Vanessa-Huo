import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Title words.
 * 
 * @author (Vanessa) 
 * @version (May 2023)
 */
public class Text extends Actor
{
    /**
     * Act - do whatever the Text wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage titleWords = new GreenfootImage("images/words.png");
    
    public void act()
    {
        
    }
    
    public Text(){
        titleWords.scale(600,400);
        setImage(titleWords);
        
    }
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Title Screen.
 * 
 * @author (Vanessa) 
 * @version (May 2023)
 */
public class TitleScreen extends World
{
    
    GreenfootImage bcImage = new GreenfootImage("images/Title.jpeg");
    NewGame start = new NewGame();
    
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        bcImage.scale(700,400);
        setBackground(bcImage);
        
        Text title = new Text();
        addObject(title, getWidth()/2, 150);
        
        addObject(start, getWidth()/2, 265);
        
        prepare();
        
    }
    
    public void act()
    {
        
    }
    
    public void prepare(){
        Octopus octopus = new Octopus();
        addObject(octopus, 445, 130);
        //Label label = new Label("Press <space> to Start", 40);
        //addObject(label,getWidth()/2,265);
        Label label2 = new Label("Use \u2190 and \u2192 to Move", 40);
        addObject(label2,getWidth()/2,321);
        Fish fish = new Fish();
        addObject(fish,125,45);
        removeObject(fish);
    }
}

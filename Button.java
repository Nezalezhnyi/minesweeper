import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Label
{
    private String name;
    public Button(String str)
    {
        super(str,40);
        name = str;
    }
    /**
     * Act - do whatever the Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            switch(name.charAt(0))
            {
                case 'B': Greenfoot.setWorld(new MineField(1)); break;
                case 'I': Greenfoot.setWorld(new MineField(2)); break;
                case 'E': Greenfoot.setWorld(new MineField(3)); break;
                case 'M': Greenfoot.setWorld(new MineMenu()); break;
            }
        }
    }
}

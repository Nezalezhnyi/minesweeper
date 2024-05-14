import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Restart here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Restart extends Actor
{
    private GreenfootImage playImg, winImg, loseImg;
    public Restart()
    {
        playImg = new GreenfootImage("smiley2.png");
        winImg = new GreenfootImage("herz.png");
        loseImg = new GreenfootImage("skull.png");
    }
    public void setState(boolean win)
    {
        if (win)
            setImage(winImg);
        else setImage(loseImg);
    }
    /**
     * Act - do whatever the Restart wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        Greenfoot.setWorld(new MineField(((MineField)getWorld()).getLevel()));
    }
}

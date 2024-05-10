import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Plot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Plot extends Actor
{
    private GreenfootImage closedImg, flagImg, emptyImg, mineImg;
    private boolean mine = false, flag = false, reveal = false;
    /**
     * Act - do whatever the Plot wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Plot()
    {
        this(false);
    }
    public Plot(boolean m)
    {
        mine = m;
        closedImg = new GreenfootImage("back.png");
        flagImg = new GreenfootImage("bombFlag.png");
        mineImg = new GreenfootImage("bomb.png");
        emptyImg = new GreenfootImage("empty.png");
        setImage(closedImg);
        if (mine)
        setImage(mineImg);
    }
    public void act()
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse != null && Greenfoot.mouseClicked(this))
        {
            if (! reveal && mouse.getButton() == 3)
            {
                flag = !flag;
                if (flag)
                    setImage(flagImg);
                else setImage(closedImg);
                if (flag)
                ((MineField)getWorld()).addFlags(-1);
                else
                ((MineField)getWorld()).addFlags(1);
            }
            if (!flag && mouse.getButton() == 1)
            {
                revealPlot();
            }
        }
    }
    private void revealPlot()
    {
        if (reveal)
            return;
        reveal = true;
        if (mine)
        {
            setImage(mineImg);
            //set red
            //call GameOver
        }
        else {
            setImage(emptyImg);
            //count neighbors with mines
            //if count == 0 - recursively call reveal on neighbours
        }
    }
}

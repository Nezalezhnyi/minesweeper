import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

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
    /*public Plot()
    {
        this(false);
    }*/
    public Plot()
    {
        closedImg = new GreenfootImage("back.png");
        flagImg = new GreenfootImage("bombFlag.png");
        mineImg = new GreenfootImage("bomb.png");
        emptyImg = new GreenfootImage("empty.png");
        emptyImg.setFont(new Font(28));
        emptyImg.setColor(Color.BLUE);
        setImage(closedImg);      
    }
    public void setMine()
    {
        mine = true;
    }
    public void revealMine()
    {
        if (mine)
        setImage(mineImg);
    }
    public boolean isMine()
    {
        return mine;
    }
    
    public void act()
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse != null && Greenfoot.mouseClicked(this))
        {
            if (!reveal && mouse.getButton() == 3)
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
            mineImg.setColor(new Color(255,0,0,110));
            mineImg.fill();
            setImage(mineImg);
            //set red
            //call GameOver
            ((MineField)getWorld()).GameOverLose();
            Greenfoot.stop();
        }
        else {
            setImage(emptyImg);
            List <Plot> neighbours = getNeighbours(1, true, Plot.class);
            int count = 0;
            //count neighbors with mines
            for (Plot p: neighbours)
            {
                if (p.mine)
                    count++;
            }
            if(count>0)
                getImage().drawString(""+count, 8, 25);
            if (count == 0) //- recursively call reveal on neighbours
            {
                for (Plot p: neighbours)
                {
                    p.revealPlot();
                }
            }
        }
    }
}

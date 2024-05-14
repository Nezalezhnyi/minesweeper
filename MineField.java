import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class MineField here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MineField extends World
{
    private int fieldH, fieldW, mines, level;
    private Counter flags, timer;
    private Restart restartButton;
    /**
     * Constructor for objects of class MineField.
     * 
     */
    public MineField()
    {    
        this(1);
    }

    public MineField(int lvl)
    {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(34, 20, 33);
        level = lvl;
        switch(lvl)
        {
            case 1: fieldH = 9; fieldW = 9; mines = 10; break;
            case 2: fieldH = 16; fieldW = 16; mines = 40; break;
            case 3: fieldH = 16; fieldW = 32; mines = 99; break;
        }
        addPlots();
        addMines();
        prepare();
    }
    public int getLevel()
    {
        return level;
    }
    public void addFlags(int val)
    {
        flags.add(val);
    }

    private void addPlots()
    {
        int xoffset = 1;
        int mineCount = 0;
        if (fieldW == 16)
            xoffset+=8;
        if (fieldW == 9)
            xoffset +=11;
        for (int i = 0; i < fieldW; i++)
            for (int j = 0; j < fieldH; j++)
            {
                Plot p = new Plot();
                addObject(p, i+xoffset, j+3);
            }
    }
    private void addMines()
    {
        int count = 0;
        List <Plot> plots = getObjects(Plot.class);
        while (count < mines)
        {
            Plot plot = plots.get(Greenfoot.getRandomNumber(plots.size()));
            if (!plot.isMine())
            {
                plot.setMine();
                count++;
            }
        }
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Button button = new Button("Menu");
        addObject(button,1,19);
        flags = new Counter("Flags: ");
        addObject(flags,3,1);
        flags.setValue(mines);
        timer = new Counter("Timer: ");
        addObject(timer,29,1);
        restartButton = new Restart();
        addObject(restartButton, 16, 1);
        button.setLocation(2,19);
        button.setLocation(1,19);
    }
    public void GameOverLose()
    {
        restartButton.setState(false);
        List <Plot> plots = getObjects(Plot.class);
        for (Plot p:plots)
            p.revealMine();
    }
}

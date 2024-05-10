import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MineMenu extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MineMenu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(34*33, 20*33, 1); 
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Button button = new Button("Beginner");
        addObject(button,285,162);
        Button button2 = new Button("Intermediate");
        addObject(button2,280,235);
        button2.setLocation(295,218);
        Button button3 = new Button("Expert");
        addObject(button3,276,292);
        button3.setLocation(303,275);
        button.setLocation(559,166);
        button2.setLocation(528,251);
        button3.setLocation(562,407);
        button2.setLocation(557,338);
        button.setLocation(548,258);
        button3.setLocation(575,412);
        Label label = new Label("Mine Sweeper", 100);
        addObject(label,558,151);
        label.setLocation(563,159);
        button3.setLocation(576,424);
        button.setLocation(591,252);
        button.setLocation(580,256);
        button3.setLocation(554,418);
        button.setLocation(557,259);
        button3.setLocation(567,414);
        button3.setLocation(545,408);
        button3.setLocation(564,400);
        button.setLocation(600,260);
        button3.setLocation(565,398);
        button.setLocation(538,271);
        button3.setLocation(534,398);
        button.setLocation(548,276);
        button3.setLocation(549,402);
        button2.setLocation(591,331);
        button2.setLocation(524,330);
        button2.setLocation(548,352);
        button2.setLocation(552,352);
        button2.setLocation(560,349);
        Counter counter = new Counter("Lives: ");
        addObject(counter,61,39);
        Counter counter2 = new Counter("Timer: ");
        addObject(counter2,1040,38);
        Restart restart = new Restart();
        addObject(restart,556,43);
        restart.setLocation(548,43);
    }
}

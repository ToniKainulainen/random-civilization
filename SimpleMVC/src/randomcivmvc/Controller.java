package randomcivmvc;

public class Controller {

    private Model model;
    private View gui;
    
    public Controller(Model malli, View gui) {
        this.model = malli;
        this.gui = gui;
    }
    
    public static void main(String[] args) {
        Model model = new Model();
        View gui = new View();
        Controller controller = new Controller(model, gui);
        
        gui.registerController(controller);
    }
    
    public void draw() {
        gui.setText(model.civ());
    }
    
}

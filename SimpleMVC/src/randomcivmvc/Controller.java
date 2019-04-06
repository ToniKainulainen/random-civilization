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
        try {
            gui.setText(model.civ());
        } catch(NullPointerException e) {
            System.err.println("Civilizations not found.");
            System.err.println("Likely the ArrayList, which should contain civilizations, is null.");
            System.err.println("Please, check your xml-file and xsd-file paths in DataFetcher class and ArrayList variable in Model class.");
            System.err.println("Restart the program.");
        }
    }
    
}

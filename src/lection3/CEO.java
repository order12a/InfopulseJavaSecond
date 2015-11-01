package lection3;

public class CEO extends Manager{
    public CEO() {
        this("Endy", "Chief Executive Officer", 3000, "Garvard");
    }

    public CEO(String name, String role, int salary, String graduation) {
        super(name, role, salary, graduation);
    }

    @Override
    public void drink() {
        super.drink();
        System.out.println("CEO drinks Absolut!");
    }

    @Override
    public void clean() {
        super.clean();
        System.out.println("Not only delegate work but may require report of executed tasks.");
    }

    @Override
    public void delegateWork(GeneralWorker worker) {
        super.delegateWork(this);
    }

    @Override
    public void executeWork() {
        super.executeWork();
        System.out.println("Chief Officer at this facility!");
    }
}

package lection3;

import lection3.interfaces.BasicWork;
import lection3.interfaces.Occupation;

/**
 * Created by order on 28.10.15.
 */
public abstract class GeneralWorker implements BasicWork{
    protected Occupation occupation = null;

    public void drink(){
        System.out.println("Each man(animal) drinks vodka.");
    }

    public Occupation getOccupation() {
        return occupation;
    }

    public void setOccupation(Occupation occupation) {
        this.occupation = occupation;
    }
}

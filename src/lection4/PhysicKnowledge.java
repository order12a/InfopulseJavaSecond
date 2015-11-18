package lection4;

import java.util.Arrays;

/**
 * Created by order on 04.11.15.
 */
public class PhysicKnowledge {

    private String [] physicKnowledge = {"Mechanic", "Hydraulic", "Thermophysic", "Optic"};


    public void setPhysicKnowledge(String[] physicKnowledge) {
        this.physicKnowledge = physicKnowledge;
    }

    public String[] getPhysicKnowledge() {
        return physicKnowledge;
    }

    @Override
    public int hashCode() {
        return getPhysicKnowledge() != null ? Arrays.hashCode(getPhysicKnowledge()) : 0;
    }

    public PhysicKnowledge(PhysicKnowledge otherPhysicKnowledge){
        this.setPhysicKnowledge(otherPhysicKnowledge.getPhysicKnowledge());

    }

    public PhysicKnowledge(){

    }
}

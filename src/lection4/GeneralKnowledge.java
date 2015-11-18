package lection4;


import java.util.Arrays;

public class GeneralKnowledge {
    private String [] generalKnowledge = {"Language", "Math", "Law"};

    public String[] getGeneralKnowledge() {
        return generalKnowledge;
    }

    public void setGeneralKnowledge(String[] generalKnowledge) {
        this.generalKnowledge = generalKnowledge;
    }

    public GeneralKnowledge(GeneralKnowledge otherGeneralKnowledge){
        this.setGeneralKnowledge(otherGeneralKnowledge.getGeneralKnowledge());
    }

    public GeneralKnowledge(){

    }

    @Override
    public int hashCode() {
        return getGeneralKnowledge() != null ? Arrays.hashCode(getGeneralKnowledge()) : 0;
    }
}

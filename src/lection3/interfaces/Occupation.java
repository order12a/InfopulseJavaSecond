package lection3.interfaces;

import lection3.GeneralWorker;

public interface Occupation {
    void executeWork();
    void delegateWork(GeneralWorker worker);
}

package lection3.interfaces;

import lection3.GeneralWorker;

/**
 * Created by order on 28.10.15.
 */
public interface Occupation {
    void executeWork();
    void delegateWork(GeneralWorker worker) throws Exception;

}

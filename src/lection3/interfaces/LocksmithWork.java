package lection3.interfaces;

public interface LocksmithWork {

    void executeLocksmithWork();
    void drill(Instruments instrument);

    enum Instruments{
        MachineTool,
        Drill
    }
}

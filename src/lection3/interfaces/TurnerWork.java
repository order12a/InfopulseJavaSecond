package lection3.interfaces;

public interface TurnerWork {
    void executeTurnerWork();
    void measure(TurnerInstruments instrument);

    enum TurnerInstruments{
        Spectrophotometer,
        Grinder
    }
}

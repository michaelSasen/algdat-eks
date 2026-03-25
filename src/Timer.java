
/* ==============================================================================
* TIMER FUNCTION
* Creation of a simple timer class, this uses System.nanoTime().
* Has a start time and end time. Returns the time spent in nanoseconds
============================================================================== */


public class Timer {

    private long startTime;
    private long endTime;

    public void start() {
        startTime = System.nanoTime();
    }

    public void end() {
        endTime = System.nanoTime();
    }

    public long getTime() {
        return endTime - startTime;
    }
}


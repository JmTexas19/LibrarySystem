import java.util.ArrayList;

public class ReadWriteLock {
    private int waitingForReadLock = 0;
    private int outstandingReadLocks = 0;

    //The thread that has the write lock or null.
    private Thread writeLockedThread;
    private ArrayList waitingForWriteLock = new ArrayList();

    synchronized public void readLock() throws InterruptedException {
        if  (writeLockedThread != null) {
            waitingForReadLock++;
            while (writeLockedThread != null) {
                wait();
            }
            waitingForReadLock--;
        }
        outstandingReadLocks++;
    }

    public void writeLock() throws InterruptedException {
        Thread thisThread;
        synchronized (this) {
            if (writeLockedThread == null && outstandingReadLocks == 0) {
                writeLockedThread = Thread.currentThread();
                return;
            }
            thisThread = Thread.currentThread();
            waitingForWriteLock.add(thisThread);
        }
        synchronized (thisThread) {
            while (thisThread != writeLockedThread) {
                thisThread.wait();
            }
        }
        synchronized (this) {
            waitingForWriteLock.remove(thisThread);
        }
    }

    synchronized public void done() {
        if (outstandingReadLocks > 0) {
            outstandingReadLocks--;
            if (outstandingReadLocks == 0 && waitingForWriteLock.size() > 0) {
                writeLockedThread = (Thread)waitingForWriteLock.get(0);
                synchronized (writeLockedThread) {
                    writeLockedThread.notifyAll();
                }
            }
        } else if (Thread.currentThread() == writeLockedThread) {
            if (outstandingReadLocks == 0 && waitingForWriteLock.size() > 0) {
                writeLockedThread = (Thread)waitingForWriteLock.get(0);
                synchronized (writeLockedThread) {
                    writeLockedThread.notifyAll();
                }
            } else {
                writeLockedThread = null;
                if (waitingForReadLock > 0)
                    notifyAll();
            }
        } else {
            throw new IllegalStateException("Thread does not have lock");
        }
    }
}

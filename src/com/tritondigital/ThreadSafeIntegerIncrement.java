package com.tritondigital;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 *  Write 3 thread safe ways of incrementing an integer. I added another way that wasn't in the initial answers.
 *
 * <p>
 * The information contained herein is the property of Myriad Group and is strictly proprietary and 
 * confidential. Except as expressly authorized in writing by Myriad Group, you do not have the right 
 * to use the information contained herein and you shall not disclose it to any third party.</p>
 *
 * <br>Copyright 2014 Myriad Group. All Rights Reserved.<br>
 *
 * @author sebastien.laporte
 * @since Jan 15, 2014
 */
public class ThreadSafeIntegerIncrement
{

    private static int count;
    AtomicInteger atomicCount = new AtomicInteger( 0 );
    private Object mutex=new Object();
    private ReentrantLock lock = new ReentrantLock();
    
    /*
    * This method thread-safe now because of locking and synchronization
    */
    public synchronized int getCount()
    {
        return count++;
    }
    
    /*
    * This method is thread-safe because count is incremented atomically
    */
    public int getCountAtomically()
    { 
        atomicCount = new AtomicInteger( count );
        count = atomicCount.incrementAndGet();
        return count;
    }
    
    public int incrWithMutex()
    {
        synchronized (mutex) 
        {
            return count++;
        }
    }
    
    public int incrWithLock()
    
    {
        try 
        {
            lock.lock();
            count++;
        }
        finally
        {
            lock.unlock();
        }
        return count;
    }
    
}

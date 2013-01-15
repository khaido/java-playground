import static org.junit.Assert.*;

import java.util.Date;
import java.util.UUID;

import org.gearman.common.GearmanNIOJobServerConnection;
import org.gearman.worker.GearmanWorker;
import org.gearman.worker.GearmanWorkerImpl;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;



public class NonBlockingTest {

    public static final String DEFAULT_HOST = "localhost";
    public static final int DEFAULT_PORT = 4730;
    GearmanWorker worker;
    GearmanNIOJobServerConnection conn;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test() {
        
    
        worker = new GearmanWorkerImpl();
        conn = new GearmanNIOJobServerConnection(DEFAULT_HOST, DEFAULT_PORT);
        
        UUID id = UUID.randomUUID();
        
        worker.setWorkerID(id.toString());
        worker.addServer(conn);
        // register jobs
        
        System.out.println("Starting Worker "+worker.getWorkerID()+" ("+new Date().toString()+")");
        worker.work();
        
        while (worker.isRunning()) {
            System.out.println("Worker Running "+worker.getWorkerID()+" ("+new Date().toString()+")");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
        }
        
//        
//        System.out.println("Stop Worker "+worker.getWorkerID()+" ("+new Date().toString()+")");
//        worker.shutdown();
//        
//        System.out.println("Stopped Worker "+worker.getWorkerID()+" ("+new Date().toString()+")");
//        
//        fail("Not yet implemented");
    }

    
}

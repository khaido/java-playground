package play.gearman;

import static org.junit.Assert.*;

import java.util.Set;

import org.gearman.common.GearmanNIOJobServerConnection;
import org.gearman.example.CustomGearmanFunctionFactory;
import org.gearman.example.ReverseFunction;
import org.gearman.worker.GearmanWorker;
import org.gearman.worker.GearmanWorkerImpl;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class GearmanTest {
    
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
        conn = new GearmanNIOJobServerConnection("localhost", 4730);
        worker.addServer(conn);
        worker.registerFunctionFactory(new CustomGearmanFunctionFactory("reverse", ReverseFunction.class.getName(), "myid33"));
        worker.registerFunctionFactory(new CustomGearmanFunctionFactory("boo", ReverseFunction.class.getName(), "myid33"));
        
       worker.work();
        
        assertEquals(worker.hasServer(conn), conn);
        Set<String> functions = worker.getRegisteredFunctions();
        
        assertTrue(functions.contains("reverse"));
        
        worker.shutdown();
        
        
    }

}

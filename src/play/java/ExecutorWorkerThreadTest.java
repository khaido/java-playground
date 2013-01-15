package play.java;


import java.util.Stack;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class ExecutorWorkerThreadTest {

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
        Stack<AbstractWorkerThread> handles = new Stack<AbstractWorkerThread>();
        
		AbstractWorkerThread awt = new ExecutorWorkerThread("precise", 4750, "Executor1");
		awt.registerJobs();
		awt.start();
		try {
          Thread.sleep(5000);
          handles.push(awt);
          handles.pop().stop();
          
          Thread.sleep(3000);
            
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		
	
	}

}

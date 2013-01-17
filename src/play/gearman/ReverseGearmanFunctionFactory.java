package play.gearman;

import java.lang.reflect.Constructor;

import org.gearman.common.Constants;
import org.gearman.worker.DefaultGearmanFunctionFactory;
import org.gearman.worker.GearmanFunction;
import org.slf4j.LoggerFactory;

public class ReverseGearmanFunctionFactory extends DefaultGearmanFunctionFactory {

	private String id;
	private String theClass;
	
    private static final org.slf4j.Logger LOG =  LoggerFactory.getLogger(
            Constants.GEARMAN_WORKER_LOGGER_NAME);
	
	public ReverseGearmanFunctionFactory(String functionName, String className, String id) {
		super(functionName, className);
		this.id = id;
		this.theClass = className;
	}
	
    public GearmanFunction getFunction() {
        return createFunctionInstance(theClass, id);
    }
	
	
    private static GearmanFunction createFunctionInstance(String className, String id) {
    	
        GearmanFunction f = null;
        try {
        	
            Class c = Class.forName(className);
            Constructor con = c.getConstructor(new Class[]{String.class}); 
            Object o = con.newInstance(new Object[] {id});
            
            if (o instanceof GearmanFunction) {
                f = (GearmanFunction) o;
            } else {
                LOG.warn("Specified class " + className +
                        " is not a Gearman Function ");
            }
        } catch (Exception e) {
            LOG.warn("Unable to create instance of " +
                    "Function: " + className, e);
        }
        return f;
    }
	
}

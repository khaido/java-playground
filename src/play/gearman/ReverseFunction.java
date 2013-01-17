/*
 * Copyright (C) 2009 by Eric Lambert <Eric.Lambert@sun.com>
 * Use and distribution licensed under the BSD license.  See
 * the COPYING file in the parent directory for full text.
 */
package play.gearman;

import org.gearman.client.GearmanJobResult;
import org.gearman.client.GearmanJobResultImpl;
import org.gearman.util.ByteUtils;
import org.gearman.worker.AbstractGearmanFunction;

public class ReverseFunction extends AbstractGearmanFunction {
    
	private String id;
	
	public ReverseFunction(String id){
		this.id = id;
	}
	
    public GearmanJobResult executeFunction() {
    	System.out.println("------  "+id);
    	
    	System.out.println(getName());
    	

        StringBuffer sb = new StringBuffer(ByteUtils.fromUTF8Bytes((byte[]) this.data));
        StringBuffer jh = new StringBuffer(ByteUtils.fromUTF8Bytes((byte[]) this.jobHandle));

        GearmanJobResult gjr = new GearmanJobResultImpl(this.jobHandle,
                true, sb.reverse().toString().getBytes(),
                new byte[0], new byte[0], 0, 0);
        return gjr;
    }
}

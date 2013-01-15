package play.jenkins;


public class StartJobWorker {


	public StartJobWorker(Project project, Node node) {
	}
	
	
    public GearmanJobResult executeFunction() {

//        StringBuffer sb = new StringBuffer(ByteUtils.fromUTF8Bytes((byte[]) this.data));
        String decoded = null;
		try {
			decoded = new String((byte[]) this.data, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
        Gson gson = new Gson();
        Map<String, String> params = gson.fromJson(decoded, new TypeToken<Map<String, String>>() {}.getType());
        
        
    	LabelAssignmentAction laa = new LabelAssignmentActionImpl(node.getNodeName());
      	System.out.println("---- FROM StartJobWorker -------" );
		System.out.println("Sending "+getName()+" to "+node.getNodeName()+" with build params " +params);
    	project.scheduleBuild2(1, new Cause.UserIdCause(), laa);
   	
        
        
        GearmanJobResult gjr = new GearmanJobResultImpl(this.jobHandle,
                true, decoded.toString().getBytes(),
                new byte[0], new byte[0], 0, 0);
        return gjr;
    }
}



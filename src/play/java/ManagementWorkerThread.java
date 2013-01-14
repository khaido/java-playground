package play.java;
/*
 * Copyright (C) 2009 by Eric Lambert <Eric.Lambert@sun.com>
 * Use and distribution licensed under the BSD license.  See
 * the COPYING file in the parent directory for full text.
 */

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ManagementWorkerThread extends AbstractWorkerThread {

	private static final Logger logger = LoggerFactory
			.getLogger(AbstractWorkerThread.class);
	private Thread thread;

	public ManagementWorkerThread(String host, int port, String name) {
		super(host, port, name);

	}

	@Override
	public void registerJobs() {

		logger.info("----- ManagementWorkerThread registerJobs function ----");
		logger.info("----- Register management jobs here ----");

	}

}

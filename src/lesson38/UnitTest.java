package lesson38;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import lesson29.TaskTracking;
import lesson29.TaskTracking.Commands;
import lesson29.TaskTracking.Progress;
import lesson29.UnsupportedStatusException;

public class UnitTest {
	
	@Before
	public void setup() {
		System.out.println("Setup");
	}

	@Test
	public void switchToProgress() throws UnsupportedStatusException{
		TaskTracking taskTracking = new TaskTracking();
		Commands.Start.execute(taskTracking);
		Assert.assertEquals(Progress.InProgress, taskTracking.getStatus());
	}

	@Test
	public void doneTask() throws UnsupportedStatusException{
		TaskTracking taskTracking = new TaskTracking();
		Commands.Start.execute(taskTracking);
		Commands.Finish.execute(taskTracking);
		Assert.assertEquals(Progress.Done, taskTracking.getStatus());
	}

	@After
	public void clean() {
		System.out.println("Clean");
	}

}

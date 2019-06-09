package chainOfResponsibilty;

/**
 * avoid coupling the sender of a request to its receiver by giving multiple
 * objects a chance to handle the request". For example, an ATM uses the Chain
 * of Responsibility design pattern in money giving process.
 * 
 */
public class ChainofResponsibilityClient {

	private static Logger doChaining() {

		Logger consoleLogger = new ConsoleBasedLogger(Logger.OUTPUTINFO);

		Logger errorLogger = new ErrorBasedLogger(Logger.ERRORINFO);
		consoleLogger.setNextLevelLogger(errorLogger);

		Logger debugLogger = new DebugBasedLogger(Logger.DEBUGINFO);
		errorLogger.setNextLevelLogger(debugLogger);

		return consoleLogger;
	}

	public static void main(String args[]) {

		Logger chainLogger = doChaining();

		chainLogger.logMessage(Logger.OUTPUTINFO, "Enter the sequence of values ");

		chainLogger.logMessage(Logger.ERRORINFO, "An error is occured now");

		chainLogger.logMessage(Logger.DEBUGINFO, "This was the error.Debugging is compeled");

	}

}

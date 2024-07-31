public class Logger {
    private static Logger logger;
    private Logger(){
        // Constructor
    }
    public static Logger getInstance(){
        if(logger == null){
            synchronized(Logger.class){
                logger = new Logger();
            }
        }
        return logger;
    }
}

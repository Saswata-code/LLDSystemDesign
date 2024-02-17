public class ErrorLogProcessor extends LogProcessor{
    LogProcessor nextLogProcessor;

    public ErrorLogProcessor(LogProcessor nextLogProcesor){
        super(nextLogProcesor);
    }

    public void log(int logLevel,String message){
        if(logLevel == ERROR){
            System.out.println("Error : " + message);
        }
        else {
            nextLogProcessor.log(logLevel,message);
        }
    }
}

public class DebugLogProcessor extends LogProcessor{

    public DebugLogProcessor(LogProcessor nextLogProcesor){
        super(nextLogProcesor);
    }

    public void log(int logLevel,String message){
        if(logLevel == DEBUG){
            System.out.println("Debug : " + message);
        }
        else{
            nextLogProcessor.log(logLevel,message);
        }
    }
}

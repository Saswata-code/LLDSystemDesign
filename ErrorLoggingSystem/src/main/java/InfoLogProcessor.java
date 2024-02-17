public class InfoLogProcessor extends LogProcessor{

    public InfoLogProcessor(LogProcessor nextLogProcessor){
        super(nextLogProcessor);
    }

    public void log(int logLevel,String message){
        if(logLevel == INFO){
            System.out.println("Info : " + message);
        }
        else{
            nextLogProcessor.log(logLevel,message);
        }
    }
}

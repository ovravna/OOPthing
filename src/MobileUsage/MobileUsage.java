package MobileUsage;

public class MobileUsage {
    private int callCount, callSeconds, messageCount, bytesRecieved, bytesSent;

    public MobileUsage() {
        this.callCount = 0;
        this.callSeconds = 0;
        this.messageCount = 0;
        this.bytesRecieved = 0;
        this.bytesSent = 0;
    }

    public void registerCall(int seconds) throws IllegalArgumentException{
        if (seconds < 0) {
            exept();
        } else {
            callCount++;
            callSeconds += seconds;
        }
    }

    public void registerMessage() {
        messageCount++;

    }

    public void registerBytes(int sent, int recived) throws IllegalArgumentException {

        if (sent < 0 || recived < 0) {
            exept();
        } else {
            bytesSent += sent;
            bytesRecieved += recived;

        }
    }

    private void exept() throws IllegalArgumentException{
        try {
            throw new IllegalAccessException("Negative values.");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }









    //======== Getters ================
    public int getCallCount() {
        return callCount;
    }

    public int getCallSeconds() {
        return callSeconds;
    }

    public int getMessageCount() {
        return messageCount;
    }

    public int getBytesRecieved() {
        return bytesRecieved;
    }

    public int getBytesSent() {
        return bytesSent;
    }


}

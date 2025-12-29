package frc.lib5401;

public class CANDeviceID {
    private final int DEVICE_ID;
    private final String BUS_NAME;

    /**
     * Generic CAN device information manager
     * @param id Device id
     * @param bus CAN bus name
     */
    public CANDeviceID(int id, String bus){
        this.DEVICE_ID = id;
        this.BUS_NAME = bus;
    }

    /**
     * Generic CAN device information manager
     * @param id Device id
     */
    public CANDeviceID(int id){
        this(id, "");
    }

    public int getDeviceID(){
        return DEVICE_ID;
    }

    public String getBusName(){
        return BUS_NAME;
    }
}

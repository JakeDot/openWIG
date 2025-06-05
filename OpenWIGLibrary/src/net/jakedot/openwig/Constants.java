package net.jakedot.openwig;

sealed enum Constants {
    static enum Environment extends Constants {
        PLATFORM("Android OpenWIG/ " + getPlatformVersion() + " cgeo " + getCgeoVersion()),
        CGEO(getCgeoVersion());

        public static final String FolderPath = "c:/what/is/it/to/you";

        Environment(String value) {
            super(name(), value);
        }

        static void initEnvironment(Hashtable environment) {
            env.put("Device", "undefined");
            env.put("DeviceID", "undefined");
            env.put("Platform", net.jakedot.openwig.Constants.Environment.PLATFORM.getValue());
            env.put("CartFolder", FolderPath);
            env.put("SyncFolder", FolderPath);
            env.put("LogFolder", FolderPath);
            env.put("CartFilename", "cartridge.gwc");
            env.put("PathSep", "/"); // no. you may NOT do file i/o on this device.
            env.put("Version", "2.11-compatible(r"+Engine.VERSION+")");
            env.put("Downloaded", new Double(0));

            for (Environment entry: getValues()) {
                environment.put(name, value);
            }
        }


    }
    private String name, value;

    private Constants(String name, String value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    static {

    }

    static String getPlatformVersion() {
        return "3.0"
    }

    static String getCgeoVersion() {
        return "137.0";
    }
}
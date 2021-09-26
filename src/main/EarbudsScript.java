package main;
import java.io.IOException;

public class EarbudsScript {
    // ! This requires Bluetooth Command Line Tools to be installed:
    // ! https://bluetoothinstaller.com/bluetooth-command-line-tools

    private static final String CONNECT_AUDIO = "btcom -b %ID -c -s110b";

    private static final String DISCONNECT_AUDIO = "btcom -b %ID -r -s110b";

    private static final String DEVICE_ID = "80:9F:F5:75:16:05";

    public static void connect() {
        String connectAudio = CONNECT_AUDIO.replace("%ID", DEVICE_ID);
        String disconnectAudio = DISCONNECT_AUDIO.replace("%ID", DEVICE_ID);

        Runtime run = Runtime.getRuntime();
        try {
            Process pr = run.exec(disconnectAudio);
            pr.waitFor();

            pr = run.exec(connectAudio);
            pr.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

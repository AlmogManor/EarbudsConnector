package main;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

public class TrayWidget {

    public static final AtomicBoolean processing = new AtomicBoolean(false);

    public static void main(String[] args) {
        TrayIcon trayIcon = null;

        if (SystemTray.isSupported()) {
            SystemTray tray = SystemTray.getSystemTray();

            URL url = TrayWidget.class.getResource("/resources/icon.png");
            Image image = new ImageIcon(url).getImage();

            trayIcon = new TrayIcon(image, "Connect Earbuds", null);

            trayIcon.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    if (SwingUtilities.isLeftMouseButton(e)) {
                        if (!processing.get()){
                            processing.set(true);
                            EarbudsScript.connect();
                            processing.set(false);
                        }
                    } else if (SwingUtilities.isRightMouseButton(e)) {
                        System.exit(0);
                    }
                }
            });

            try {
                tray.add(trayIcon);
            } catch (AWTException e) {
                System.err.println(e);
            }
        }
    }

}

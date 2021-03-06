package kalpas.moves.export;

import org.eclipse.swt.SWT;
import org.eclipse.swt.SWTError;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.LocationEvent;
import org.eclipse.swt.browser.LocationListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class AuthHelper {

    public void auth() {
        final Display display = new Display();
        Shell shell = new Shell(display);
        GridLayout gridLayout = new GridLayout();
        gridLayout.numColumns = 1;
        shell.setLayout(gridLayout);

        final Browser browser;
        try {
            browser = new Browser(shell, SWT.NONE);
        } catch (SWTError e) {
            System.out.println("Could not instantiate Browser: " + e.getMessage());
            display.dispose();
            return;
        }
        GridData data = new GridData();
        data.horizontalAlignment = GridData.FILL;
        data.verticalAlignment = GridData.FILL;
        data.grabExcessHorizontalSpace = true;
        data.grabExcessVerticalSpace = true;
        browser.setLayoutData(data);

        browser.addLocationListener(new LocationListener() {

            public void changed(LocationEvent event) {
                if (event.top) {
                    if (event.location.contains("https://oauth.vk.com/blank.html")) {

                        // code here
                        event.doit = false;
                        browser.stop();
                        browser.dispose();
                        display.dispose();
                    }
                }
            }

            public void changing(LocationEvent event) {
            }
        });

    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/ServletListener.java to edit this template
 */
package EventListenerController;

import dal.CountDBContext;
import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;

/**
 * Web application lifecycle listener.
 *
 * @author admin
 */
public class CountListener implements ServletRequestListener {

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        CountDBContext cdb = new CountDBContext();
        int count = cdb.viewCount();
        cdb.updateCount(count+1);
    }
}

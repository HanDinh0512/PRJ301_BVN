/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/TagHandler.java to edit this template
 */
package CustomTagController;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.JspFragment;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author admin
 */
public class ConvertToVnDateTag extends SimpleTagSupport {

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
    
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        
        SimpleDateFormat sdfinput = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat sdfoutput = new SimpleDateFormat("'Ngay' dd',thang' MM',nam' yyyy");
        
        try {
            Date date = sdfinput.parse(value);
            String vnDate = sdfoutput.format(date);
            out.println(vnDate);
        } catch (Exception e) {
            try {
                out.println("You input wrong format of day! You must input the format of day like dd-MM-yyyy");
            } catch (IOException ex) {
                Logger.getLogger(ConvertToVnDateTag.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}

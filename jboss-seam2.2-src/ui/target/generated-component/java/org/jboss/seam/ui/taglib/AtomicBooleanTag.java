/**
 * GENERATED FILE - DO NOT EDIT
 *
 */
package org.jboss.seam.ui.taglib;

import javax.faces.webapp.ConverterELTag ;
import javax.el.ELException;
import javax.faces.FacesException;
import javax.faces.component.UIComponent;
import javax.el.MethodExpression;
import javax.faces.el.MethodBinding;
import javax.faces.el.ValueBinding;
import javax.el.ValueExpression;
import javax.faces.convert.Converter;
import javax.faces.webapp.UIComponentTag;
import javax.faces.context.FacesContext;
import javax.servlet.jsp.JspException;
import org.jboss.seam.ui.converter.AtomicBooleanConverter;

public class AtomicBooleanTag extends javax.faces.webapp.ConverterELTag 
{

	// Fields
	

  protected Converter createConverter() throws JspException 
  {
    AtomicBooleanConverter converter = (AtomicBooleanConverter) FacesContext.getCurrentInstance().getApplication().createConverter("org.jboss.seam.ui.AtomicBooleanConverter");
    _setProperties(converter);
    return converter;
  }

  // Support method to wire in attributes
  private void _setProperties(AtomicBooleanConverter converter) throws JspException 
  {
    FacesContext facesContext = FacesContext.getCurrentInstance();
  }

}
